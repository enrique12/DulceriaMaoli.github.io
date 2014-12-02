package com.tlamatini.modelo;

import java.sql.Date;


/**
 * Constructor vacío de la clase Producto
 */

public class Producto {
	
	private int idProducto;
	private int id_empresa;
	private String nombre;
	private String descripcion;
	private Date fechaCaducidad;
	private double costoUnitario;
	private int cantidad;
	private String nombreProveedor;
	private int topeMayoreo;
	private int activo;//0 existe 1 no existe
	private int num_producto;

	/**
	 * Constructor vacío de la clase Producto
	 */
	public Producto() {
		super();
	}
	

	/**
	 * Constructor de instancias de Producto dado todos sus campos
	 * @param idProducto
	 * @param id_empresa
	 * @param nombre
	 * @param descripcion
	 * @param fechaCaducidad
	 * @param costoUnitario
	 * @param cantidad
	 * @param topeMayoreo
	 */
	public Producto(int idProducto,int id_empresa, String nombre, String descripcion,
			double costoUnitario,Date fechaCaducidad,  int cantidad,
			int topeMayoreo,int activo) {
		super();
		this.idProducto = idProducto;
		this.id_empresa=id_empresa;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCaducidad = fechaCaducidad;
		this.costoUnitario = costoUnitario;
		this.cantidad = cantidad;
		this.topeMayoreo = topeMayoreo;
		this.activo=activo;
	}
	public Producto(int idProducto,int num_producto) {
		super();
		this.idProducto = idProducto;
		this.num_producto=num_producto;
	}
	
	/**
	 * Regresa el valor de id_empresa
	 * @return int id_empresa
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
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public int getIdProducto() {
		return idProducto;
	}

	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public double getCostoUnitario() {
		return costoUnitario;
	}

	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	/**
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Cambia el valor de folio por el recibido en el parámetro
	 * @param int folio
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Regresa el valor de nombreProveedor
	 * @return String nombreProveedor*/
	 
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * Cambia el valor de proveedor por el recibido en el parámetro
	 * @param String nombreProveedor*/
	 
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	/**
	 * Regresa el valor de TopeMayoreo
	 * @return int topeMayoreo
	 */
	public int getTopeMayoreo() {
		return topeMayoreo;
	}

	/**
	 * Cambia el valor de TopeMayoreo por el recibido en el parámetro
	 * @param int topeMayoreo
	 */
	public void setTopeMayoreo(int topeMayoreo) {
		this.topeMayoreo = topeMayoreo;
	}
	/**
	 * Regresa el numero de productos vendidos ALEJ.
	 * @return int num_producto
	 */
	public int getNumProducto(){
		
		return num_producto;
	}
	/**
	 * Modifica el numero de productos vendidos ALEJ.
	 * @param int num_producto
	 */
	public void setNumProducto(int num_producto){
		this.num_producto=num_producto;
		
	}

	/**
	 * Regresa el estado activo del producto 0 existe 1 no existe ALEJ.
	 * @return int activo
	 */
	public int getActivo() {
		return activo;
	}

	/**
	 * Modifica el estado activo del producto 0 existe 1 no existe  ALEJ.
	 * @param int activo
	 */
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
}