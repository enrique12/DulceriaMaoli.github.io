package com.tlamatini.test;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.modelo.Venta;
import com.tlamatini.negocio.ControlEstadoFinanciero;
import com.tlamatini.persistencia.DAOCompra;
import com.tlamatini.persistencia.DAOVenta;

public class ControlEstadoFinancieroTest {
	int  id_usuario;
	int id_empresa;
	ConexionDB conexion = new ConexionDB();

	DAOCompra daoCompra = new DAOCompra(conexion);
	DAOVenta daoVenta = new DAOVenta(conexion);
	Usuario user = new Usuario();
	ControlEstadoFinanciero CEF = new ControlEstadoFinanciero(user ,conexion);
	
	int folio = 12;
	ArrayList<Producto> productos=new ArrayList<Producto>();
	double importe = 100.0;
	Date fechaOperacion= new Date(2014/02/02);
	String nick = "admin";
	String nombreProveedor = "emp";
	Compra c = new Compra();

	Date fechaInicio = new Date(2014/01/01); 
	Date fechaFin = new Date(2015/01/01);
	ArrayList<Double> Compras =new ArrayList<Double>();
	Compra[] compraTempArreglo = new Compra[daoCompra.buscaCompra(fechaInicio, fechaFin).length];
		
	int f=1;
	ArrayList<Producto> prod=new ArrayList<Producto>();;
	double impor = 123.5;
	Date fechaOper = new Date(2014/02/02);
	String ni = "admin";
	Venta v = new Venta();
	
	Date fechaIni = new Date(2014/01/01); 
	Date fechaFi = new Date(2015/01/01);
	ArrayList<Double> Ventas =new ArrayList<Double>();
	Venta[] ventaTempArreglo = new Venta[daoVenta.buscaVenta(fechaIni, fechaFi).length];
	
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
