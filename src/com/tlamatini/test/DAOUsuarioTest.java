package com.tlamatini.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOUsuario;

public class DAOUsuarioTest {
	int id_usuario = 3;
	String nick = "nickUser";
	String nombre = "NombreUser";
	String apellido = "ApellUser";
	String password = "pass";
	int telefono = 123456;
	String correo = "algo@serv.ext";
	boolean esAdministrador = true;
	
	ConexionDB conexion = new ConexionDB();
	DAOUsuario daoUsuario = new DAOUsuario(conexion);
	Usuario usuario = new Usuario(id_usuario,nick,nombre,apellido,password,telefono,correo,esAdministrador);
/*
	@Test //
	public final void testDAOUsuario() {
		//TODO
	}
*/
	@Test
	public final void testAgregaUsuario() {
		assertTrue(daoUsuario.agregaUsuario(usuario));
	}
/*
	@Test
	public final void testBuscaUsuario() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testModificaUsuario() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testBorraUsuario() {
		fail("Not yet implemented"); // TODO
	}
*/
}
