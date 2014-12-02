package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOUsuario;
import com.tlamatini.presentacion.VentanaMiCuenta;

public class ControlMiCuenta {
	
	DAOUsuario daoUsuario;
	Usuario user;
	ConexionDB conexion;
	public ControlMiCuenta(Usuario user,ConexionDB con) {
		// TODO Auto-generated constructor stub
		conexion=con;
		this.user=user;
		daoUsuario=new DAOUsuario(conexion);
		VentanaMiCuenta ventana=new VentanaMiCuenta(this,conexion);
		ventana.setVisible(true);
		
	}
	
	public String dameUsuario(){
		return user.getNick();
	}

	public boolean modificarUsuario(Usuario usuario){
		if(daoUsuario.buscaUsuario(usuario.getNick())==null)
			return false;
		return daoUsuario.modificaUsuario(usuario);
	}

}
