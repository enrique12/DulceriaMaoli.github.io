package com.tlamatini.persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tlamatini.datos.ConexionDB;
//import com.tlamatini.datos.ManejadorBD;
import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;

public class DAOCompra {
	ConexionDB conexion;
	public DAOCompra(ConexionDB con){
		conexion=con;
	}
	/**
	 * Agrega el objeto Compra @param a la base de datos
	 * @param compra
	 * @return true si fue exitoso, false de lo contrario
	 */
	public boolean agregaCompra(Compra compra) {
		ResultSet rs;
		String query;
		try {
			int llave=-1;
			// Crea el statement
			//Statement statement = ManejadorBD.dameConnection().createStatement();
			
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			query="insert into compra(id_usuario,id_empresa,fechaOperacion,importe) values ('"+compra.getId_usuario()+"','"+compra.getId_empresa()+"','"+compra.getFechaOperacion()+"','"+compra.getImporte()+"'";
			//statement.execute("insert into compra(id_usuario,id_empresa,fechaOperacion,importe) values ('"+compra.getId_usuario()+"','"+compra.getId_empresa()+"','"+compra.getFechaOperacion()+"','"+compra.getImporte()+"'");
			if(conexion.ejecutarSQL(query)==true){
				query="select folio from compra";
				rs=conexion.ejecutarSQLSelect(query);
				if (rs != null && rs.next()) {
				    llave = rs.getInt("folio");   
				}
				
			}else{
				return false;
			}
			
			//guarda la lista de productos de la venta en la base de datos
			for(int i = 0; i<compra.getProductos().length;i++){
				query="insert into compraproducto(folio,idProducto,numeroProductos) values ("+llave+","+compra.getProductos()[i].getIdProducto()+","+compra.getProductos()[i].getCantidad()+")";
				conexion.ejecutarSQL(query);
			}
			return true;
			
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			
			return false;
		}
	}
	/**
	 * busca en la base de datoslas Compras que se hicieron entre el periodo de tiempo fechaInicio y fechaFin
	 * y las regresa en un arreglo compras
	 * @param fechaInicio
	 * @param fechaFin
	 * @return compras
	 */
	public Compra[] buscaCompra(Date fechaInicio, Date fechaFin) {
		ArrayList<Compra> compraTemp = new ArrayList<Compra>();
		ResultSet rs,rs2,rs3;
		String query;
		try {
			
			query="SELECT * FROM compra WHERE fechaOperacion BETWEEN '"+fechaInicio+"'AND '"+fechaFin+"'";
			// Recibe los resutados
			rs= conexion.ejecutarSQLSelect(query);
			
			while(rs.next()){
				// Crea una nueva instancia del objeto
				Compra compra= new Compra(rs.getInt("folio"),null,rs.getDouble("importe"),rs.getDate("fechaOperacion"), rs.getInt("id_usuario"),rs.getInt("id_empresa"));
				compraTemp.add(compra);
				query="SELECT * FROM compraProducto WHERE folio = "+compra.getFolio();
				//agrega los productos asociados a la compra
				rs2 = conexion.ejecutarSQLSelect(query);
				while(rs2.next()){
					query="SELECT * FROM producto WHERE idProducto = "+rs2.getInt("idProducto");
					rs3 = conexion.ejecutarSQLSelect(query);
					if(rs3.next())
						compra.addProducto(new Producto(rs3.getInt("idProducto"),rs3.getInt("id_empresa"),rs3.getString("nombre"),rs3.getString("descripcion"),rs3.getDouble("costoUnitario"),rs3.getDate("fechaCaducidad"), rs3.getInt("cantidad"),rs3.getInt("topeMayoreo"),rs3.getInt("activo")));
				}
				
			}
			
			Compra compraTempArreglo[] = new Compra[compraTemp.size()];
			compraTemp.toArray(compraTempArreglo);
			return compraTempArreglo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	

}
