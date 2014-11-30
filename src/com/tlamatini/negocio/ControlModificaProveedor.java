package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.persistencia.DAOProveedor;
import com.tlamatini.presentacion.VentanaModificaProveedor;

public class ControlModificaProveedor {
	DAOProveedor daoprovedor;
	Proveedor pro;
	ConexionDB conexion;
	public ControlModificaProveedor(DAOProveedor daoprovedor,ConexionDB con) {
		conexion=con;
		daoprovedor = new DAOProveedor(conexion);
		this.daoprovedor = daoprovedor;		
	}
	
	public void inicia(){
		VentanaModificaProveedor ventana = new VentanaModificaProveedor(conexion);
		ventana.setVisible(true);
		
		
	}
	
	public boolean modificar(Proveedor pro){
		return daoprovedor.modificaProveedor(pro);
	}
	/*public Proveedor busca(String busca){
		return daoprovedor.buscaProveedor_empresa(busca);
	}*/
	
	
	

}
