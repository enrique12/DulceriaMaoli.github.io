package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOCompra;
import com.tlamatini.persistencia.DAOProducto;
import com.tlamatini.persistencia.DAOProveedor;
import com.tlamatini.presentacion.VentanaAdministrarProveedor;
import com.tlamatini.presentacion.VentanaAgregarProveedor;

public class ControlAgregaProveedor {
	ConexionDB conexion;
	Usuario loggedIn;
	DAOProveedor daoProveedor;
	ControlAdministrarProveedor cp;
	VentanaAgregarProveedor ventana;
	

	public ControlAgregaProveedor(Usuario loggedIn,ConexionDB con) {
		conexion=con;
		daoProveedor=new DAOProveedor(conexion);
		this.loggedIn = loggedIn;
	}
	
	public void inicia(){
		 ventana = new VentanaAgregarProveedor(conexion);
		ventana.setVisible(true);
	}
	
	public boolean agregarProveedor(Proveedor proveedor){
		if(daoProveedor.agregaProveedor(proveedor))
			return true;
		return false;
	}
	
	public void cancelar(){
			
	}
	
	public String regresaNombreUsuario(){
		return (""+loggedIn.getNick());
	}
	
	
	

	

}
