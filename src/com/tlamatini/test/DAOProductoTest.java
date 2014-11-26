package com.tlamatini.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.tlamatini.modelo.Producto;
import com.tlamatini.persistencia.DAOProducto;

public class DAOProductoTest {
	int idProducto = 13;
	String nombre = "PruebaJUnit";
	String descripcion = "agregaProducto y buscaProducto";
	Date fechaCaducidad = new Date(2020/02/02); // 01:02:03;
	Date fechaCaducidad2 = new Date(2012/02/02);
	double costoUnitario = 1.1;
	int cantidad = 40;
	String nombreProveedor = "emp";
	int topeMayoreo = 40;
	int mes = 1;
	DAOProducto daoProducto = new DAOProducto();
	Producto producto = new Producto(idProducto, nombre, descripcion, fechaCaducidad, costoUnitario, cantidad, nombreProveedor, topeMayoreo);
	Producto producto1 = new Producto(12, nombre, descripcion, fechaCaducidad, costoUnitario, cantidad, nombreProveedor, topeMayoreo);
	Producto[] productos = daoProducto.buscaProducto("PruebaJUnit");
	Producto[] producto2 = daoProducto.buscaProductosPorFecha(fechaCaducidad);
	Producto[] producto3 = daoProducto.buscaProducto(nombre);
	Producto[] producto4 = daoProducto.masVendido(mes);
	ArrayList<Producto> listaProducto = new ArrayList<Producto>();
	ArrayList<Producto> listaProductos = daoProducto.sumaProducto(listaProducto);


/*
	@Test
	public final void testAgregaProducto() {
		assertTrue(daoProducto.agregaProducto(producto));
	}
*/
	@Test
	public final void testBuscaProductoInt() {
		assertEquals(productos.length, daoProducto.buscaProducto(producto.getNombre()).length);
	}

	@Test
	public final void testBuscaTodos() {
		assertEquals(productos.length, daoProducto.buscaProducto(producto.getNombre()).length);
	}
	
	@Test
	public final void testBuscaProductosPorFecha() {
		assertEquals(producto2.length, daoProducto.buscaProductosPorFecha(fechaCaducidad).length);
	}

	@Test
	public final void testBuscaProductoString() {
		assertEquals(producto3.length, daoProducto.buscaProducto(nombre).length);
	}

/*
	@Test
	public final void testBorraProducto() {
		assertTrue(daoProducto.borraProducto(producto));
	}
*/
	@Test
	public final void testMasVendido() {
		assertEquals(producto4.length, daoProducto.masVendido(mes).length);
	}
	@Test
	public final void testModificaProducto() {
		assertTrue(daoProducto.modificaProducto(producto));
	}
	@Test
	public final void testSumaProducto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testOrdenaProducto() {
		fail("Not yet implemented"); // TODO
	}
}
