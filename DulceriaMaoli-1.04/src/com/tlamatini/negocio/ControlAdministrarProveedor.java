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
	private ControlAgregaProveedor nuevoProvedor;
	private ControlModificaProveedor modificaProvedor;
	private DAOProveedor daopreoveedor;
	ConexionDB conexion;
	public ControlAdministrarProveedor(Usuario usuario,ConexionDB con){
		conexion=con;
		loggedIn=usuario;
		daopreoveedor = new DAOProveedor(conexion);
		nuevoProvedor = new ControlAgregaProveedor(loggedIn,conexion);
		modificaProvedor = new ControlModificaProveedor(loggedIn,conexion);
		VentanaAdministrarProveedor ventana=new VentanaAdministrarProveedor(this,conexion);
		ventana.setVisible(true);
		
	}
	public Usuario getLoggedIn() {
		return loggedIn;
	}
	public void nuevoProveedor(){
		nuevoProvedor.inicia();
	}
	
	/**
	 * Busca en la base de datos el Proveedor de la empresa con el nombre exacto enviado por parametros se usa para eliminar el proveedor con el nombre exacto @param
	 * @param empresa
	 * @return proveedor
	 */
	public Proveedor buscaProvedor_nombre(String empresa){
		return daopreoveedor.buscaProveedor_empresa_nombre(empresa);
	}
	
	/**
	 * Busca en la base de datos a los proveedores de la empresa que contengan en su nombre algo de la cadena enviada @param
	 * @param empresa
	 * @return proveedor
	 */
	public ArrayList<Proveedor> buscaProvedor(String empresa){
		return daopreoveedor.buscaProveedor_empresa(empresa);
	}
	
	/**
	 * Muestra todos los Proveedores existentes
	 * @param  empresa
	 * @return ArrayList<Proveedor>
	 */
	public ArrayList<Proveedor> buscaProvedores(String empresa){
		return daopreoveedor.buscaProveedores_empresa_nombre(empresa);
	}
	
	public boolean elminaProveedor(Proveedor proveedor){
		return daopreoveedor.borraProveedor(proveedor);
	}
	public void modificaProveedor(Proveedor provedor){
		
		modificaProvedor.inicia(provedor);
	}
	public ArrayList<Proveedor> dameTodosProveedores(){
		return daopreoveedor.buscaTodos();		
	}

}
