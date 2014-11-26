package com.tlamatini.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;
import com.tlamatini.persistencia.DAOVenta;

public class TestDAOVenta {
	
	private int folio=1;
	private ArrayList<Producto> productos=new ArrayList<Producto>();;
	private double importe = 123.4;
	private Date fechaOperacion = new Date(2014/02/02);
	private String nick = "admin";
	DAOVenta daoVenta = new DAOVenta();
	Venta v = new Venta(folio, productos,importe,fechaOperacion,nick);
	
	Date fechaInicio = new Date(2014/01/01); 
	Date fechaFin = new Date(2015/01/01);
	private	Venta[] ventaTempArreglo = new Venta[daoVenta.buscaVenta(fechaInicio, fechaFin).length];
	
	@Test
	public void testAgregaVenta() {
		assertTrue(daoVenta.agregaVenta(v));
	}

	@Test
	public void testBuscaVenta() {
		assertEquals(ventaTempArreglo.length,daoVenta.buscaVenta(fechaInicio, fechaFin).length);
	}
}
