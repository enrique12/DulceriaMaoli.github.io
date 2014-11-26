package com.tlamatini.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;
import com.tlamatini.persistencia.*;

import org.junit.Test;

public class TestDAOCompra {
	
	private int folio = 12;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	private double importe = 150.5;
	private Date fechaOperacion= new Date(2014/02/02);
	private String nick = "admin";
	private String nombreProveedor = "emp";
	DAOCompra daoCompra = new DAOCompra();
	Compra c = new Compra(folio, productos,importe,fechaOperacion,nick,nombreProveedor);
	
	Date fechaInicio = new Date(2014/01/01); 
	Date fechaFin = new Date(2015/01/01);
	private	Compra[] compraTempArreglo = new Compra[daoCompra.buscaCompra(fechaInicio, fechaFin).length];
	
	@Test
	public void testAgregaCompra() {
		assertTrue(daoCompra.agregaCompra(c));
	}

	@Test
	public void testBuscaCompra() {
		assertEquals(compraTempArreglo.length,daoCompra.buscaCompra(fechaInicio, fechaFin).length);
	}

}
