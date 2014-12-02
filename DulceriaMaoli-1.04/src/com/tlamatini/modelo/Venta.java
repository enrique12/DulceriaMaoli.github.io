package com.tlamatini.modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Venta {

	private int folio;
	private int id_usuario;
	private Date fechaOperacion;
	private double importe;
	private double importeDescuento;
	private double descuento;
	private ArrayList<Producto> productos;
	
	

	/**
	 * Constructor vac�o de la clase Venta
	 */
	public Venta() {
		super();
		productos=new ArrayList<Producto>();
	}
	
	/**
	 * Constructor de instancias de Venta dados los campos fechaOperacion y id_usuario
	 * @param fechaOperacion
	 * @param id_usuario
	 */
	public Venta(Date fechaOperacion, int id_usuario) {
		super();
		productos=new ArrayList<Producto>();
		this.fechaOperacion = fechaOperacion;
		this.id_usuario = id_usuario;
	}
	
	/**
	 * Constructor de Venta usando todos sus campos
	 * @param folio
	 * @param id_usuario
	 * @param fechaOperacion
	 * @param importe
	 * @param importeDescuento
	 * @param descuento
	 * @param productos
	 */

	public Venta(int folio,int id_usuario,Date fechaOperacion, double importe,
			double importeDescuento,double descuento, ArrayList<Producto> productos) {
		super();
		productos=new ArrayList<Producto>();
		this.folio = folio;
		this.id_usuario=id_usuario;
		this.fechaOperacion = fechaOperacion;
		this.importe = importe;
		this.importeDescuento = importeDescuento;
		this.descuento = descuento;
		this.productos = productos;

	}

	/**
	 * Regresa el valor de folio
	 * @return int folio
	 */
	public int getFolio() {
		return folio;
	}

	/**
	 * Cambia el valor de folio por el recibido en el par�metro
	 * @param int folio
	 */
	public void setFolio(int folio) {
		this.folio = folio;
	}
	/**
	 * Regresa el valor de id_usuario
	 * @return id_usuario
	 */

	public int getId_usuario() {
		return id_usuario;
	}
	/**
	 * Cambia el valor de id_usuario por el recibido en el par�metro
	 * @param id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Regresa el valor de fechaOperacion
	 * @return fechaOperacion
	 */
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * Cambia el valor de fechaOperacion por el recibido en el par�metro
	 * @param fechaOperacion
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}


	/**
	 * Regresa el valor de importe
	 * @return importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * Cambia el valor de importe por el recibido en el par�metro
	 * @param importe
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}
	/**
	 * Regresa el valor de importeDescuento
	 * @return importeDescuento
	 */
	public double getImporteDescuento() {
		return importeDescuento;
	}
	/**
	 * Cambia el valor de importeDescuento por el recibido en el par�metro
	 * @param importeDescuento
	 */
	public void setImporteDescuento(double importeDescuento) {
		this.importeDescuento = importeDescuento;
	}
	/**
	 * Regresa el valor de descuento
	 * @return fechaOperacion
	 */
	public double getDescuento() {
		return descuento;
	}
	/**
	 * Cambia el valor de descuento por el recibido en el par�metro
	 * @param descuento
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
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
	 * @param idProducto
	 * @return true si se elimino correctamente o false en caso contrario
	 */
	public boolean removeProducto(int idProducto){
		
		
		for(int i = 0;i<productos.size();i++){
			if(productos.get(i).getIdProducto()==idProducto){
				productos.remove(i);
				return true;
			}
				
			
		}
		return false;
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
