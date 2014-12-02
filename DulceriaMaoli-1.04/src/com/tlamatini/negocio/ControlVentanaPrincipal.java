package com.tlamatini.negocio;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.presentacion.VentanaPrincipal;

public class ControlVentanaPrincipal{
	
	
	private Usuario user;
	private ConexionDB conexion;
	public ControlVentanaPrincipal(Usuario usuario,ConexionDB con){
		conexion=con;
		user=usuario;
		VentanaPrincipal ventanaPrincipal=new VentanaPrincipal(this,conexion);
		ventanaPrincipal.setVisible(true);
		
	}	
	public Usuario getUser() {
		return user;
	}
	
	public void MiCuenta(){
		ControlMiCuenta controlMC=new ControlMiCuenta(user,conexion);
		
	}
	
	public void realizarVenta(){
		ControlVenta controlRV=new ControlVenta(user,conexion);
		
	}
	
	public void agregarProducto(){
		
		ControlAgregarProducto controlAP=new ControlAgregarProducto(user,conexion);
	}
	
	public void consultarInventario(){
		
		ControlConsultaInventario controlCI=new ControlConsultaInventario(user,conexion);
	}
	
	
	public void proximosACaducar(){
		ControlProductosProximosACaducar controlPC=new ControlProductosProximosACaducar(user,conexion);
		
	}
	
	public void Usuarios(){
		
	}
	
	public void Inventario(){
		
	}
	
	public void Proveedores(){
		
	}
	
	public void Finanzas(){
		
	}
	
	public void Salir(){
		
	}
}
