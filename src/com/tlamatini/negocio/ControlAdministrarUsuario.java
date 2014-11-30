package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOUsuario;
import com.tlamatini.presentacion.VentanaAdministrarUsuario;

public class ControlAdministrarUsuario {
	
	Usuario loggedIn;
	DAOUsuario daoUsuario;
	ConexionDB conexion;
	public ControlAdministrarUsuario(Usuario loggedIn,ConexionDB con){
		conexion=con;
		this.loggedIn=loggedIn;
		daoUsuario=new DAOUsuario(conexion);

		
	}
	
	
	public Usuario getLoggedIn() {
		return loggedIn;
	}


	public void inicia(){
		VentanaAdministrarUsuario ventana=new VentanaAdministrarUsuario(this,conexion);
		ventana.setVisible(true);
	}
	
	public boolean agregarUsuario(Usuario nuevo){
		if(daoUsuario.buscaUsuario(nuevo.getNick())==null)
			return daoUsuario.agregaUsuario(nuevo);
		return false;
	}
	
	public boolean modificarUsuario(Usuario usuario){
		if(daoUsuario.buscaUsuario(usuario.getNick())==null)
			return false;
		return daoUsuario.modificaUsuario(usuario);
	}
	
	public boolean borrarUsuario(Usuario usuario){
		if(daoUsuario.buscaUsuario(usuario.getNick())==null)
			return false;
		return daoUsuario.borraUsuario(usuario);
		
	}

}