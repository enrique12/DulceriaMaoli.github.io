package com.tlamatini.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.persistencia.DAOProveedor;

public class DAOProveedorTest {
	String empresa = "empresaJUnit";
	String direccion = "direccionJUnit";
	int telefono = 55555555;
	ConexionDB conexion = new ConexionDB();
	DAOProveedor daoProveedor = new DAOProveedor(conexion);
	Proveedor proveedor = new Proveedor(empresa, direccion, telefono);
	ArrayList<Proveedor> arrayListProveedor = daoProveedor.buscaTodos();

	@Test
	public final void testAgregaProveedor() {
		assertTrue(daoProveedor.agregaProveedor(proveedor));
	}

	@Test
	public final void testBuscaProveedor() {
		assertEquals(proveedor.getEmpresa(), daoProveedor.buscaProveedor_empresa(empresa).getEmpresa());
	}

	@Test
	public final void testModificaProveedor() {
		assertTrue(daoProveedor.modificaProveedor(proveedor));
	}

	@Test
	public final void testBorraProveedor() {
		assertTrue(daoProveedor.borraProveedor(proveedor));
	}

	@Test
	public final void testBuscaTodos() {
		 assertEquals(arrayListProveedor.size(), daoProveedor.buscaTodos().size());
	}

}