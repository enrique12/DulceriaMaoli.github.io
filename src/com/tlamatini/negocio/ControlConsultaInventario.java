package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOProducto;
import com.tlamatini.presentacion.VentanaConsultaInventario;

public class ControlConsultaInventario {

	Usuario loggedIn;
	DAOProducto daoProducto;
	Producto[] todos;
	VentanaConsultaInventario ventana;
	ConexionDB conexion;
	public ControlConsultaInventario(Usuario loggedIn,ConexionDB con) {
		// TODO Auto-generated constructor stub
		conexion=con;
		this.loggedIn=loggedIn;
		daoProducto=new DAOProducto(conexion);
		ventana=new VentanaConsultaInventario(this);
		ventana.setVisible(true);
	}
	
	

	public Producto[] dameProductos(){
		return daoProducto.buscaTodos();
	}
	
	public Producto[] dameProductos(String nombreProducto){
		return daoProducto.buscaProducto(nombreProducto);
	}
	
	public  boolean borrarProducto(Producto producto){
		boolean aux=daoProducto.borraProducto(producto);
		return aux;
	}
	
	public Producto dameProducto(int idProducto){
		return daoProducto.buscaProducto(idProducto);
	}
	
	public Usuario getUser() {
		// TODO Auto-generated method stub
		return loggedIn;
	}

}
