package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOUsuario;
import com.tlamatini.presentacion.VentanaLogin;

public class ControlVentanaLogin {
	ConexionDB conexion;
	DAOUsuario daoUsuarios;
	private Usuario usuario;
	
	public ControlVentanaLogin(ConexionDB con){
		conexion=con;
		daoUsuarios=new DAOUsuario(conexion);
		VentanaLogin ventanaLogin=new VentanaLogin(this,conexion);
		ventanaLogin.setVisible(true);
	}

	public boolean comparaDatos(String nombre, String psswd) {
		 usuario=daoUsuarios.buscaUsuario(nombre);
		 if(usuario!=null)
			 return usuario.getPassword().equals(psswd);	
		 return false;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	

}
