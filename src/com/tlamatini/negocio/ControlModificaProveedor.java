package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOProveedor;
import com.tlamatini.presentacion.VentanaModificaProveedor;

public class ControlModificaProveedor {
	DAOProveedor daoprovedor;
	ConexionDB conexion;
	Usuario loggedIn;
	Proveedor provedor;
	public ControlModificaProveedor(Usuario loggedIn,ConexionDB con) {
		conexion=con;
		this.daoprovedor = new DAOProveedor(conexion);
		this.loggedIn = loggedIn;
	}
	
	
	public void inicia(Proveedor provedor){
		this.provedor=provedor;
		VentanaModificaProveedor ventana = new VentanaModificaProveedor(this,conexion,this.provedor);
		ventana.setVisible(true);
		
		
	}
	
	public Usuario getLoggedIn() {
		return loggedIn;
	}


	public boolean modificar(Proveedor pro){
		return daoprovedor.modificaProveedor(pro);
	}
	/*public Proveedor busca(String busca){
		return daoprovedor.buscaProveedor_empresa(busca);
	}*/
	
	
	

}
