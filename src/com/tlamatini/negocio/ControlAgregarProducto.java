package com.tlamatini.negocio;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.modelo.Venta;
import com.tlamatini.persistencia.DAOCompra;
import com.tlamatini.persistencia.DAOProducto;
import com.tlamatini.persistencia.DAOProveedor;
import com.tlamatini.presentacion.VentanaAgregarProducto;


public class ControlAgregarProducto {
	
	Usuario loggedIn;
	DAOProducto daoProducto;
	DAOCompra daoCompra;
	int id_usuario;
	Compra compra;
	ConexionDB conexion;
	public ControlAgregarProducto(Usuario loggedIn,ConexionDB con) {
		conexion=con;
		daoCompra = new DAOCompra(conexion);
		this.loggedIn=loggedIn;
		VentanaAgregarProducto ventana=new VentanaAgregarProducto(this);
		ventana.setVisible(true);
		daoProducto=new DAOProducto(conexion);
	}
	
		public boolean productoEsNuevo(int idProducto){
			if(daoProducto.buscaProducto(idProducto)==null)
				return true;
			return false;
		}
	
		public boolean agregaProductoNuevo(Producto producto){

			if(daoProducto.buscaProducto(producto.getIdProducto())==null)
				return daoProducto.agregaProducto(producto);
			return false;
				
			
		}
		
		public boolean agregaProductoExistente(Producto producto){
			Producto productoAux=null;
			productoAux=daoProducto.buscaProducto(producto.getIdProducto());
			productoAux.setCantidad(productoAux.getCantidad()+producto.getCantidad());
			productoAux.setCostoUnitario(productoAux.getCostoUnitario()+producto.getCostoUnitario());
			return daoProducto.modificaProducto(productoAux);
		}
		
		/*public boolean agregarCompra(){
			
			int llave = (int) Math.random();
			DAOProveedor daoProveedor = new DAOProveedor(conexion);
			
			daoProveedor.agregaProveedor(new Proveedor(""+llave,"direccion",555555));
			
			compra.setId_empresa(llave);
			compra.setId_usuario(loggedIn.getId_usuario());
			return daoCompra.agregaCompra(compra);
//			/return true;
			
		}*/
		
		public boolean iniciaCompra(){
			id_usuario=loggedIn.getId_usuario();
			
			java.util.Date utilDate = new java.util.Date(); //fecha actual
			long lnMilisegundos = utilDate.getTime();
			Date fechaActual = new java.sql.Date(lnMilisegundos);//fecha actual en formato Date para sql
			
			compra = new Compra(fechaActual,id_usuario);
			
			if(compra == null)
				return false;
			else{
				return true;
			}

		}
		
		public Producto agregaProductoACompra(int idProducto, int cantidad){
			
			Producto producto;
			producto = daoProducto.buscaProducto(idProducto);
			if(producto==null){
				return null;
			}else{
				//agrega solo si no existe el producto en la venta
				Producto[] productos = compra.getProductos();
				for(int i = 0;i<productos.length;i++){
					if(productos[i].getIdProducto()==idProducto){
						return productos[i];
					}
				}
				producto.setCantidad(cantidad);
				compra.addProducto(producto);
				
				//calcula precio
				
				compra.setImporte(producto.getCostoUnitario()*cantidad);
				
				return producto;
			}
		}

		public Producto buscaProducto(int parseInt) {
			// TODO Auto-generated method stub
			return daoProducto.buscaProducto(parseInt);
		}
		
		
		public LinkedList dameProvedor(){
			LinkedList listaProvedor=new LinkedList();
			String query;
			ResultSet rs;
			try{
				query="Select empresa from provedor";
				rs=conexion.ejecutarSQLSelect(query);
				while(rs.next()){
					//System.out.println(rs.getString("empresa"));
					listaProvedor.add(rs.getString("empresa"));		
				}
			}catch(SQLException e){
				//e.printStackTrace();
			}
			return listaProvedor;		
		}
		public int dameId_empresa(Object emp){
			String empresa=(String)emp;
			return daoProducto.dameId_empresa(empresa);
		}
		
}
