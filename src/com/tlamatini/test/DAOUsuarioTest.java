package com.tlamatini.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOUsuario;

public class DAOUsuarioTest {
	String nick = "nickUserTest";
	String nombre = "NombreUserTest";
	String nombre2 = "kozk";
	String apellido = "ApellidoUseTest";
	String password = "pass";
	int telefono = 12345678;
	String correo = "correo";
	boolean esAdministrador = false;
	ConexionDB conexion = new ConexionDB();
	boolean connbo = conexion.crearConexion();
	DAOUsuario daoUsuario = new DAOUsuario(conexion);
	Usuario user = new Usuario(nick,nombre,apellido, password,telefono,correo,esAdministrador);
	Usuario userOtro = new Usuario(nick,nombre2,apellido, password,telefono,correo,esAdministrador);
/*
	@Test
	public final void testAgregaUsuario() {
		assertTrue(daoUsuario.agregaUsuario(user));
	}
*/
	@Test
	public final void testBuscaUsuario() {
		assertEquals(userOtro.getNombre(), daoUsuario.buscaUsuario("kozk").getNombre());
	}

	@Test
	public final void testModificaUsuario() {
		assertTrue(daoUsuario.modificaUsuario(userOtro));
	}

	@Test
	public final void testBorraUsuario() {
		assertTrue(daoUsuario.borraUsuario(user));
	}

}
