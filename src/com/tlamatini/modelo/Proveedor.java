package com.tlamatini.modelo;

public class Proveedor {
	private int id_empresa;
	private String empresa;
	private String direccion;
	private int telefono;
	private int activo;//donde 0 existe y 1 no existe
	/**
	 * Constructor vacío de la clase Proveedor
	 */
	public Proveedor() {
		super();
	}
	/**
	 * Constructo de instancias de Proveedor dados todos sus campos
	 * @param empresa
	 * @param direccion
	 * @param telefono
	 */
	public Proveedor(String empresa, String direccion,
			int telefono) {
		super();
		this.empresa = empresa;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	/**
	 * Constructo de instancias de Proveedor dados todos sus campos
	 * @param id_empresa
	 * @param empresa
	 * @param direccion
	 * @param telefono
	 * @param activo
	 */
	public Proveedor(int id_empresa,String empresa, String direccion,
			int telefono,int activo) {
		super();
		this.id_empresa=id_empresa;
		this.empresa = empresa;
		this.direccion = direccion;
		this.telefono = telefono;
		this.activo=activo;
	}
	/**
	 * Regresa el valor de id_empresa
	 * @return id_empresa
	 */
	public int getId_empresa() {
		return id_empresa;
	}
	/**
	 * Cambia el valor de id_empresa por el recibido en el parámetro
	 * @param id_empresa
	 */
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	/**
	 * Regresa el valor de activo
	 * @return activo
	 */
	public int getActivo() {
		return activo;
	}
	/**
	 * Cambia el valor de activo por el recibido en el parámetro
	 * @param activo
	 */
	public void setActivo(int activo) {
		this.activo = activo;
	}
	/**
	 * Regresa el valor de empresa
	 * @return empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Cambia el valor de empresa por el recibido en el parámetro
	 * @param empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Regresa el valor de direccion
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Cambia el valor de direccion por el recibido en el parámetro
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Regresa el valor de telefono
	 * @return telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Cambia el valor de telefono por el recibido en el parámetro
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	


}
