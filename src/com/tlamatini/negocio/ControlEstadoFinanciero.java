package com.tlamatini.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.ListIterator;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Venta;
import com.tlamatini.persistencia.DAOCompra;
import com.tlamatini.persistencia.DAOVenta;
import com.tlamatini.presentacion.VentanaEstadoFinanciero;

public class ControlEstadoFinanciero {

	DAOCompra daoCompra;
	DAOVenta daoVenta;
	ConexionDB conexion;
	public ControlEstadoFinanciero(ConexionDB con){
		conexion=con;
		daoCompra = new DAOCompra(conexion);
		daoVenta = new DAOVenta(conexion);
		VentanaEstadoFinanciero ventana=new VentanaEstadoFinanciero(this);
		ventana.setVisible(true);
	}
	/**
	 * regresa las ventas realizadas en el intervalo de tiempo especificado
	 * @param fechaInicio 
	 * @param fechaFinal
	 * @return arreglo con las ventas
	 */
	public Venta[] dameVentas(Date fechaInicio,Date fechaFinal){
		return daoVenta.buscaVenta(fechaInicio, fechaFinal);
	}
	/**
	 * regresa las compras realizadas en el intervalo de timpor especificado
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return arreglo con las compras
	 */
	public Compra[] dameCompras(Date fechaInicio,Date fechaFinal){
		return daoCompra.buscaCompra(fechaInicio, fechaFinal);
	}
	
	public Double calculaGanancia(ArrayList<Double> listaImporteVentas, ArrayList<Double> listaImporteCompras){
		
		double totalVentas=0;
		double totalCompras=0;
		
		for(int i = 0;i<listaImporteVentas.size();i++){
			totalVentas += listaImporteVentas.get(i);
		}
		for(int i = 0;i<listaImporteCompras.size();i++){
			totalCompras += listaImporteCompras.get(i);
		}
		System.out.println(totalVentas);
		System.out.println(totalVentas-totalCompras);
		return totalVentas-totalCompras;
	}

}
