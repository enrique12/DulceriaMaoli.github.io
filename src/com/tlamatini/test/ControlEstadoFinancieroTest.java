package com.tlamatini.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList; 

import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Venta;
import com.tlamatini.negocio.ControlEstadoFinanciero;
import com.tlamatini.persistencia.DAOCompra;
import com.tlamatini.persistencia.DAOVenta;

public class ControlEstadoFinancieroTest {
	int folio;
	ArrayList<Producto> productos=new ArrayList<Producto>();
	double importe;
	Date fechaOperacion;
	int  id_usuario;
	int id_empresa;

	DAOCompra daoCompra = new DAOCompra();
	DAOVenta daoVenta = new DAOVenta();
	ControlEstadoFinanciero CEF = new ControlEstadoFinanciero();
	
	private int folio = 12;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	private double importe = 100.0;
	private Date fechaOperacion= new Date(2014/02/02);
	private String nick = "admin";
	private String nombreProveedor = "emp";
	Compra c = new Compra(folio, productos,importe,fechaOperacion,nick,nombreProveedor);

	Date fechaInicio = new Date(2014/01/01); 
	Date fechaFin = new Date(2015/01/01);
	ArrayList<Double> Compras =new ArrayList<Double>();
	private	Compra[] compraTempArreglo = new Compra[daoCompra.buscaCompra(fechaInicio, fechaFin).length];
		
	private int f=1;
	private ArrayList<Producto> prod=new ArrayList<Producto>();;
	private double impor = 123.5;
	private Date fechaOper = new Date(2014/02/02);
	private String ni = "admin";
	Venta v = new Venta(f, prod,impor,fechaOper,ni);
	
	Date fechaIni = new Date(2014/01/01); 
	Date fechaFi = new Date(2015/01/01);
	ArrayList<Double> Ventas =new ArrayList<Double>();
	private	Venta[] ventaTempArreglo = new Venta[daoVenta.buscaVenta(fechaIni, fechaFi).length];
	
	@Test
	public void testDameVentas() {
		assertEquals(ventaTempArreglo.length,daoVenta.buscaVenta(fechaInicio, fechaFin).length);	
	}

	@Test
	public void testDameCompras() {
		assertEquals(compraTempArreglo.length,daoCompra.buscaCompra(fechaInicio, fechaFin).length);
	}

	@Test
	public void testCalculaGanancia() {
		Ventas.add(impor);
		Compras.add(importe);
		double resultado = CEF.calculaGanancia(Ventas, Compras);
		assertEquals(23.5,resultado,0.01);
		
	}

}
