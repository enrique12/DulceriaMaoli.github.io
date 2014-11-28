package com.tlamatini.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.persistencia.DAOProveedor;

public class DAOProveedorTest {
	String empresa = "empresaJUnit00";
	String empresa01 = "empresaJUnit01";
	String direccion = "direccionJUnit00";
	int telefono = 12345;
	
	ConexionDB conexion = new ConexionDB();
	boolean connbo = conexion.crearConexion();
	
	DAOProveedor daoProveedor = new DAOProveedor(conexion);
	Proveedor proveedor = new Proveedor(empresa01, direccion, telefono);
	Proveedor proveedorBorrar = new Proveedor(empresa, direccion, telefono);
	Proveedor proveedorModifica = new Proveedor(empresa, direccion, telefono);
	ArrayList<Proveedor> arrayListProveedor = daoProveedor.buscaTodos();
/*
	@Test
	public final void testAgregaProveedor() {
		assertTrue(daoProveedor.agregaProveedor(proveedor));
	}

	@Test
	public final void testBuscaProveedor() {
		assertEquals(proveedor.getEmpresa(), daoProveedor.buscaProveedor_empresa(empresa01).getEmpresa());
	}

	@Test
	public final void testModificaProveedor() {
		assertTrue(daoProveedor.modificaProveedor(proveedorModifica));
	}

	@Test
	public final void testBorraProveedor() {
			assertTrue(daoProveedor.borraProveedor(proveedor));
	}
*/
	@Test
	public final void testBuscaTodos() {
		 assertEquals(arrayListProveedor.size(), daoProveedor.buscaTodos().size());
	}

}