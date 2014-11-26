package com.tlamatini.negocio;

import java.util.ArrayList;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOProveedor;
import com.tlamatini.presentacion.VentanaAdministrarProveedor;
import com.tlamatini.presentacion.VentanaAgregarProveedor;

public class ControlAdministrarProveedor {
	private Usuario loggedIn;
	private ControlAgregaProveedor nuevo;
	private DAOProveedor daopreoveedor;
	ConexionDB conexion;
	public ControlAdministrarProveedor(ConexionDB con){
		conexion=con;
		daopreoveedor = new DAOProveedor(conexion);
		nuevo = new ControlAgregaProveedor(loggedIn,conexion);
		VentanaAdministrarProveedor ventana=new VentanaAdministrarProveedor(this,conexion);
		ventana.setVisible(true);
		
	}
	public void nuevoProveedor(){
		nuevo.inicia();
	}
	
	public Proveedor buscaProvedor(String empresa){
		return daopreoveedor.buscaProveedor_empresa(empresa);
	}
	
	public boolean elminaProveedor(Proveedor proveedor){
		return daopreoveedor.borraProveedor(proveedor);
	}
	public boolean modificaProveedor(){
		return true;
	}
	public ArrayList<Proveedor> dameTodosProveedores(){
		return daopreoveedor.buscaTodos();		
	}

}
