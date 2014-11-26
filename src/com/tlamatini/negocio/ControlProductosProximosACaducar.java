package com.tlamatini.negocio;

import java.sql.Date;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOProducto;
import com.tlamatini.presentacion.VentanaProductosProximosACaducar;

public class ControlProductosProximosACaducar {
	private Usuario user;
	private DAOProducto daoProducto;
	ConexionDB conexion;
	/**
	 * constructor
	 * @param user usuario en linea
	 */
	public ControlProductosProximosACaducar(Usuario user,ConexionDB con) {
		conexion=con;
		this.user=user;
		daoProducto=new DAOProducto(conexion);
		VentanaProductosProximosACaducar ventana=new VentanaProductosProximosACaducar(this, user);
		ventana.setVisible(true);
		
	}
	/**
	 * busca los productos los cuales su fecha de caducidad se encuentre por debajo de la fecha especificada
	 * @param fechaCaducidad valor limite de las dechas de caducidad
	 * @return Producto[] lista con los productos 
	 */
	public Producto[] buscaProductosProximosACaducar(Date fechaCaducidad){
		return daoProducto.buscaProductosPorFecha(fechaCaducidad);
	}
	

}
