package com.tlamatini.modelo;

import java.util.ArrayList;

public class Usuario {
	private int id_usuario;
	private String nick;
	private String nombre;
	private String apellido;
	private String password;
	private int telefono;
	private String correo;
	private boolean esAdministrador;
	
	/**
	 * Constructor vacío de la clase Usuario
	 */
	
	public Usuario() {
		super();
	}

	/**
	 * Constructor de la clase Usuario usando todos sus campos
	 * @param nick
	 * @param nombre
	 * @param apellido
	 * @param password
	 * @param telefono
	 * @param correo
	 * @param esAdministrador
	 */
	public Usuario(String nick, String nombre, String apellido,
			String password, int telefono, String correo,
			boolean esAdministrador) {
		super();
		//this.id_usuario=id_usuario;
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.correo = correo;
		this.esAdministrador = esAdministrador;
	}
	/**
	 * Constructor de la clase Usuario usando todos sus campos
	 * @param id_usuario
	 * @param nick
	 * @param nombre
	 * @param apellido
	 * @param password
	 * @param telefono
	 * @param correo
	 * @param esAdministrador
	 */
	public Usuario(int id_usuario,String nick, String nombre, String apellido,
			String password, int telefono, String correo,
			boolean esAdministrador) {
		super();
		this.id_usuario=id_usuario;
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.correo = correo;
		this.esAdministrador = esAdministrador;
	}
	/**
	 * Regresa el valor de id_usuario
	 * @return id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}
	/**
	 * Cambia el valor de id_usuario por el recibido en el parámetro
	 * @param id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Regresa el valor de nick
	 * @return nick
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * Cambia el valor de nick por el recibido en el parámetro
	 * @param nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	

	/**
	 * Regresa el valor de nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el valor de nombre por el recibido en el parámetro
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Regresa el valor de apellido
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Cambia el valor de apellido por el recibido en el parámetro
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Regresa el valor de password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Cambia el valor de password por el recibido en el parámetro
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * Regresa el valor de correo
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Cambia el valor de correo por el recibido en el parámetro
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Regresa el valor de esAdministrador
	 * @return esAdministrador
	 */
	public boolean isEsAdministrador() {
		return esAdministrador;
	}
	public int esAdministrador(){
		if(isEsAdministrador()==true){
			return 1;
		}else{
			return 0;
		}
		
	}
	/**
	 * Cambia el valor de esAdministrador por el recibido en el parámetro
	 * @param esAdministrador
	 */
	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}
	
	
}
