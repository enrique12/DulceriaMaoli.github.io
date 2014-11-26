package com.tlamatini.negocio;




import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.persistencia.DAOProducto;
import com.tlamatini.persistencia.DAOVenta;
import com.tlamatini.presentacion.VentanaConsultaInventario;
import com.tlamatini.presentacion.VentanaProductomasVendido;

public class ControlProductomasVendido {

	Usuario loggedIn;
	DAOProducto daoProducto;
	
	VentanaProductomasVendido ventana;
	ConexionDB conexion;
	public ControlProductomasVendido(Usuario loggedIn,ConexionDB con) {
		// TODO Auto-generated constructor stub
		conexion=con;
		this.loggedIn=loggedIn;
		daoProducto=new DAOProducto(conexion);
		ventana=new VentanaProductomasVendido(this);
		ventana.setVisible(true);
	}
	public Producto[] masVendido(Object mescombo){
		String mes=(String)mescombo;
		Producto[] mas_vendido = null;
		switch (mes){
		case "Enero":
			System.out.println("Selecciono Enero regresa 1");
			mas_vendido=daoProducto.masVendido(1);
			break;
		case "Febrero":
			mas_vendido=daoProducto.masVendido(2);
			break;
		case "Marzo":
			mas_vendido=daoProducto.masVendido(3);
			break;
		case "Abril":
			mas_vendido=daoProducto.masVendido(4);
			break;
		case "Mayo":
			mas_vendido=daoProducto.masVendido(5);
			break;
		case "Junio":
			mas_vendido=daoProducto.masVendido(6);
			break;
		case "Julio":
			mas_vendido=daoProducto.masVendido(7);
			break;
		case "Agosto":
			mas_vendido=daoProducto.masVendido(8);
			break;
		case "Septiembre":
			mas_vendido=daoProducto.masVendido(9);
			break;
		case "Octubre":
			System.out.println("Selecciono Octubre regresa 10");
			mas_vendido=daoProducto.masVendido(10);
			
			break;
		case "Noviembre":
			mas_vendido=daoProducto.masVendido(11);
			break;
		case "Diciembre":
			mas_vendido=daoProducto.masVendido(12);
			break;
		case "---------->":
			System.out.println("Seleccione una opcion del combo");
			break;
		
		}
		
		return mas_vendido;
		
	}

	public Usuario getUser() {
		// TODO Auto-generated method stub
		return loggedIn;
	}

}
