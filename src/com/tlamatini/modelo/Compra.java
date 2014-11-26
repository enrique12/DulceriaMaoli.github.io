package com.tlamatini.modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Compra {
	private int folio;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	private double importe;
	private Date fechaOperacion;
	private int  id_usuario;
	private int id_empresa;
	
	
	/**
	 * Constructor vacío de la clase Compra
	 */

	public Compra() {
		super();
		productos=new ArrayList<Producto>();
	}

	/**
	 * Constructor de instancias de Compra, dada una fecha y el id del usuario que autoriza la Compra
	 * @param Date fechaOperacion
	 * @param int id_usuario
	 */
	
	public Compra(Date fechaOperacion, int id_usuario) {
		super();
		productos=new ArrayList<Producto>();
		this.fechaOperacion = fechaOperacion;
		this.id_usuario = id_usuario;
	}

	/**
	 * Constructor de Compra dados todos los campos.
	 * @param folio
	 * @param productos
	 * @param importe
	 * @param fechaOperacion
	 * @param nick
	 * @param nombreProveedor
	 */
	
	public Compra(int folio, ArrayList<Producto> productos, double importe,
			Date fechaOperacion, int id_usuario, int id_empresa) {
		super();
		productos=new ArrayList<Producto>();
		this.folio = folio;
		this.productos = productos;
		this.importe = importe;
		this.fechaOperacion = fechaOperacion;
		this.id_usuario = id_usuario;
		this.id_empresa = id_empresa;
	}

	/**
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public int getFolio() {
		return folio;
	}
	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setFolio(int folio) {
		this.folio = folio;
	}
	/**
	 * Regresa el valor de importe
	 * @return double importe
	 */
	public double getImporte() {
		return importe;
	}
	

	/**
	 * Cambia el valor de importe por el recibido en el parámetro
	 * @param double importe
	 */
	
	public void setImporte(double importe) {
		this.importe = importe;
	}
	

	/**
	 * Regresa el valor de FechaOperacion
	 * @return Date FechaOperacion
	 */
	
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * Cambia el valor de fechaOperacion por el recibido en el parámetro
	 * @param Date fechaOperacion
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	/**
	 * Regresa el valor de id_usuario
	 * @return String id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}
	/**
	 * Cambia el valor de id_usuario por el recibido en el parámetro
	 * @param String id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	/**
	 * Regresa el valor de id_empresa
	 * @return String id_empresa
	 */
	
	public int getId_empresa() {
		return id_empresa;
	}
	/**
	 * Cambia el valor de id_empresa por el recibido en el parámetro
	 * @param int id_empresa
	 */
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}


	/**
	 * permite agregar un nuevo producto a la venta
	 * @param nuevoProducto
	 * @return true si se agrego correctamente o false en caso contrario
	 */
	public boolean addProducto(Producto nuevoProducto){
		return productos.add(nuevoProducto);
	}

	/**
	 * permite eliminar un producto existente de la venta
 	 * @param producto
 	 * @return true si se elimino correctamente o false en caso contrario
 	 */
	public boolean removeProducto(Producto producto){
		return productos.remove(producto);
	}
	
	/**
	 * Regresa un arreglo con los Productos en el ArrayList productos
	 * @return arrayProductos
	 */
	public Producto[] getProductos(){
		Producto[] arrayProductos=new Producto[productos.size()];
		productos.toArray(arrayProductos);
		return arrayProductos;
	}
	
	
}
