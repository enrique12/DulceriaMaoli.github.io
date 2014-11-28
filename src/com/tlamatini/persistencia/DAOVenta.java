package com.tlamatini.persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tlamatini.datos.ConexionDB;
//import com.tlamatini.datos.ManejadorBD;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;

public class DAOVenta{
	ConexionDB conexion;
	public DAOVenta(ConexionDB con){
		conexion=con;
	}
	/**
	 * Agrega el objeto Venta @param a la base de datos
	 * @param venta
	 * @return true si fue exitoso, false de lo contrario
	 */
	public boolean agregaVenta(Venta venta) {
		ResultSet rs;
		String query;
		try {
			int llave=-1;
			// Crea el statement
			//Statement statement = ManejadorBD.dameConnection().createStatement();
			
			query="insert into venta(folio,id_usuario,fechaOperacion,importe,importeDescuento,descuento) " +
					"values ('"+venta.getFolio()+"','"+venta.getId_usuario()+"','"+venta.getFechaOperacion()+
	        		"','"+venta.getImporte()+"',"+venta.getImporteDescuento()+","+venta.getDescuento()+"')";
// Parece que tiene error de sintaxis SQL en query			
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			if(conexion.ejecutarSQL(query)==true){
				query="select folio from venta";
				rs=conexion.ejecutarSQLSelect(query);
				if (rs != null && rs.next()) {
				    llave = rs.getInt("folio");   
				}
			}else{
				return false;
			}
			
			
			//guarda la lista de productos de la venta en la base de datos
			for(int i = 0; i<venta.getProductos().length;i++){
				query="insert into ventaProducto values ("+llave+","+venta.getProductos()[i].getIdProducto()+","+venta.getProductos()[i].getCantidad()+")";
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
	 * busca en la base de datos las Ventas que se hicieron entre el periodo de tiempo fechaInicio y fechaFin 
	 * y las regresa en un arreglo ventas
	 * @param fechaInicio
	 * @param fechaFin
	 * @return ventas
	 */
	public Venta[] buscaVenta(Date fechaInicio, Date fechaFin) {
		Venta venta;
		ArrayList<Venta> ventaTemp = new ArrayList<Venta>();
		ResultSet rs,rs2,rs3;
		String query;
		try {
			// Crea el statement
			/*Statement statement = ManejadorBD.dameConnection().createStatement();
			Statement statement2 = ManejadorBD.dameConnection().createStatement();
			Statement statement3 = ManejadorBD.dameConnection().createStatement();
			*/
			// Recibe los resutados
			query="SELECT * FROM venta WHERE fechaOperacion BETWEEN '"+fechaInicio+"'AND '"+fechaFin+"'";
			rs = conexion.ejecutarSQLSelect(query);
			
			while(rs.next()){
				// Crea una nueva instancia del objeto
				venta= new Venta(rs.getInt("folio"),rs.getInt("id_usuario"),rs.getDate("fechaOperacion"),rs.getDouble("importe"),rs.getDouble("importeDescuento"),rs.getDouble("descuento"), null);
				ventaTemp.add(venta);

				//agrega los productos asociados a la venta
				query="SELECT * FROM ventaProducto WHERE folio = "+venta.getFolio();
				rs2=conexion.ejecutarSQLSelect(query);
				while(rs2.next()){
					query="SELECT * FROM producto WHERE idProducto = "+rs2.getInt("idProducto");
					rs3=conexion.ejecutarSQLSelect(query);
					if(rs3.next())
						venta.addProducto(new Producto(rs3.getInt("idProducto"),rs3.getInt("id_empresa"),rs3.getString("nombre"),rs3.getString("descripcion"),rs3.getDouble("costoUnitario"),rs3.getDate("fechaCaducidad"), rs3.getInt("cantidad"),rs3.getInt("topeMayoreo"),rs3.getInt("activo")));
				}
				
			}
			
			Venta ventaTempArreglo[] = new Venta[ventaTemp.size()];
			ventaTemp.toArray(ventaTempArreglo);
			return ventaTempArreglo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
