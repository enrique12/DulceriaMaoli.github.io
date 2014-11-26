package com.tlamatini;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.negocio.ControlVentanaLogin;
/**
*
* @author sist3mas
*/
public class Aplicacion {
	ConexionDB conexion= new ConexionDB();
	boolean valida;
	public static void main(String[] args) {
		Aplicacion app=new Aplicacion();
	}
	
	public Aplicacion(){
		valida=conexion.crearConexion();
		if(valida==true){
			ControlVentanaLogin control=new ControlVentanaLogin(conexion);
		}else{
			System.exit(0);
		}
		
	}


}
