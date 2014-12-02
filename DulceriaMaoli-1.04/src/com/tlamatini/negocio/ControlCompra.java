package com.tlamatini.negocio;

import java.sql.Date;
import java.util.ArrayList;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.modelo.Compra;
import com.tlamatini.persistencia.DAOProducto;
import com.tlamatini.persistencia.DAOCompra;
import com.tlamatini.presentacion.VentanaCompra;

public class ControlCompra {
	

	private int id_usuario;
	private Usuario user;
	private Compra compra;
	private DAOProducto daoProducto;
	private DAOCompra daoCompra;
	private VentanaCompra ventana;
	private ConexionDB conexion;
	/**
	 * constructor vacio
	 * @param user 
	 */
	public ControlCompra(Usuario user,ConexionDB con){ 
		conexion=con;
		this.user=user;
		ventana=new VentanaCompra(this);
		daoProducto = new DAOProducto(conexion);	
		daoCompra = new DAOCompra(conexion);
		ventana.setVisible(true);
	}
	
	public void setVentana(VentanaCompra ventana){
		ventana=ventana;
	}
	/**
	 * incializa la venta creando el obheto de tipo venta
	 * @param nick nickname del usuario que se encuentra activo
	 * @return true su se creo la venta, false en caso contrario
	 */
	public boolean iniciaVenta(){
		this.id_usuario=user.getId_usuario();
		
		java.util.Date utilDate = new java.util.Date(); //fecha actual
		long lnMilisegundos = utilDate.getTime();
		Date fechaActual = new java.sql.Date(lnMilisegundos);//fecha actual en formato Date para sql
		
		compra = new Compra(fechaActual,id_usuario);
		
		if(compra == null)
			return false;
		else{
			return true;
		}
		
	}
	/**
	 * agrega agrega un nuevo producto a la venta
	 * @param idProducto identificador del producto
	 * @return si existe el producto lo regresa, en caso contrario devuelve null
	 */
	public Producto agregaProductoACompra(int idProducto, int cantidad){
		
		Producto producto;
		producto = daoProducto.buscaProducto(idProducto);
		
		
		
		if(producto==null){
			return null;
		}else{
			
			
			//agrega solo si no existe el producto en la venta
			Producto[] productos = compra.getProductos();
			for(int i = 0;i<productos.length;i++){
				if(productos[i].getIdProducto()==idProducto){
					return productos[i];
				}
			}
			producto.setCantidad(cantidad);
			compra.addProducto(producto);
			
			return producto;
		}
	}
	/**
	 * actualiza la cantidad de productos que se venden
	 * @param nuevaCantidad
	 * @return regresa true si la actualizacion se realizo con exito, false si no
	 */
	public boolean actualizaCantidad(int idProducto, int nuevaCantidad){
		
		Producto[] productos = compra.getProductos();
		Producto productoActualizado;
		Producto productoTemp;
		
		
		for(int i = 0;i<productos.length;i++){
			productoTemp = productos[i];
			if(productoTemp.getIdProducto()== idProducto){
				productoActualizado = new Producto();
				productoActualizado.setIdProducto(productoTemp.getIdProducto());
				productoActualizado.setCantidad(nuevaCantidad+productoTemp.getCantidad());
				productoActualizado.setCostoUnitario(productoTemp.getCostoUnitario());
				
				//elimina producto de la lista de venta 
				compra.removeProducto(idProducto);
				//agrega producto actualizado
				compra.addProducto(productoActualizado);
				return true;
				
				
			}
		}
		return false;
		
		
	}
	/**
	 * calcula el precio de venta del producto, mayoreo o menudeo
	 * @param precioUnitario
	 * @return
	 */
	public double calculaPrecioUnidad(Producto producto){
		
		
		if(producto.getCantidad()>=producto.getTopeMayoreo()){
			return producto.getCostoUnitario();
		}else{
			return producto.getCostoUnitario();
		}
		
	}
	
	/**
	 * calcula total
	 * @param subTotales
	 * @return el total de la venta
	 */
	public double calculaTotal(ArrayList<Double> subTotales){
		double total=0;
		
		for(int i = 0;i<subTotales.size();i++){
			total = total + subTotales.get(i);
		}
		
		compra.setImporte(total);
		
		return total;
	}
	/**
	 * agrega la venta al DAOVenta
	 * @return true si se agrego a la base de datos, false si no 
	 */
	public boolean agregaCompra(){
		
		if(compra.getProductos().length==0)
			return false;
		return daoCompra.agregaCompra(compra);
	}
	
	public boolean eliminaProducto(int idProducto){
		
		return compra.removeProducto(idProducto);
				
	}

	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return user;
	}
	

}
