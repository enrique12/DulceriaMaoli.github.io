package com.tlamatini.persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import com.tlamatini.datos.ConexionDB;
//import com.tlamatini.datos.ManejadorBD;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Proveedor;


public class DAOProducto {
	ConexionDB conexion;
	public DAOProducto(ConexionDB con){
		conexion=con;
		
	}
	/**
	 * Agrega a la base de datos la cantidad del Producto dado @param
	 * @param producto
	 * @return true si es exitoso, de otra manera false.
	 */
	public boolean agregaProducto(Producto producto) {
        // Crea el statement
       // Statement statement = ManejadorBD.dameConnection().createStatement();
        String query;
        query="insert into producto(idProducto,id_empresa,nombre,descripcion,costoUnitario,fechaCaducidad,cantidad,topeMayoreo) " +
				"values ('"+producto.getIdProducto()+"','"+producto.getId_empresa()+"','"+producto.getNombre()+
        		"','"+producto.getDescripcion()+"',"+producto.getCostoUnitario()+","+producto.getFechaCaducidad()+",'"+producto.getCantidad()+",'"
				+producto.getTopeMayoreo()+"')";
        return conexion.ejecutarSQL(query);
        /*statement.execute("insert into producto values ("+producto.getIdProducto()+",'"+producto.getNombre()+"','"+producto.getDescripcion()+
        		"',"+producto.getCostoUnitario()+",'"+producto.getFechaCaducidad()+"',"+producto.getCantidad()+
        		",'"+producto.getNombreProveedor()+"',"+producto.getTopeMayoreo()+")");
     */
       
	}
	
	/**
	 * Busca en la base de datos el producto cuya idProducto es igual al dado @param
	 * @param idProducto
	 * @return producto
	 */
	public Producto buscaProducto(int idProducto){
		Producto producto=null;
		ResultSet rs;
		String query;
		 try {
	            // Crea el statement
	            //Statement statement = ManejadorBD.dameConnection().createStatement();
			 	query="SELECT * FROM producto WHERE idProducto="+idProducto;
	            // Recibe los resutados
	            rs=conexion.ejecutarSQLSelect(query);
	            if(rs.next())
	            {
	                // Crea una nueva instancia del objeto
	                producto= new Producto(rs.getInt("idProducto"),rs.getInt("id_empresa"),rs.getString("nombre"),rs.getString("descripcion"),
	                		rs.getDouble("costoUnitario"),rs.getDate("fechaCaducidad"),rs.getInt("cantidad"),rs.getInt("topeMayoreo"),rs.getInt("activo"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return producto;
		
	}
	
	/**
	 * Busca en la base de datos todas las entradas de la tabla Producto
	 * @return productos
	 */
	public Producto[] buscaTodos(){
		Producto[]productos=null;
		ArrayList<Producto> productosList=new ArrayList<Producto>();
		String query;
		ResultSet rs;
		 try {
	            // Crea el statement
	            //Statement statement = ManejadorBD.dameConnection().createStatement();
			 	
			 	query="SELECT * FROM producto";
	            // Recibe los resutados
	           	rs=conexion.ejecutarSQLSelect(query);

	            while(rs.next()){
	                // Crea una nueva instancia del objeto
	                productosList.add(new Producto(rs.getInt("idProducto"),rs.getInt("id_empresa"),rs.getString("nombre"),rs.getString("descripcion"),
	                		rs.getDouble("costoUnitario"),rs.getDate("fechaCaducidad"),rs.getInt("cantidad"),rs.getInt("topeMayoreo"),rs.getInt("activo")));
	                
	            }

	            productos=new Producto[productosList.size()];
	            productosList.toArray(productos);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productos;
		
	}

	/**
	 * Busca los productos en la base de datos cuya fechaCaducidad sea menor a la
	 *fechaCaducidad dada @param
	 * @param fechaCaducidad
	 * @return productos
	 */
	public Producto[] buscaProductosPorFecha(Date fechaCaducidad){
		Producto[] productos=null;
		Producto producto;
		ArrayList<Producto> productosList=new ArrayList<Producto>();
		ResultSet rs,rs2;
		String query;
		 try {
	            // Crea el statement
	            //Statement statement = ManejadorBD.dameConnection().createStatement();

	            // Recibe los resutados
	         query="SELECT * FROM producto WHERE fechaCaducidad<='"+fechaCaducidad+"'";   
			 rs= conexion.ejecutarSQLSelect(query);

	            while(rs.next())
	            {
	                // Crea una nueva instancia del objeto
	                productosList.add(new Producto(rs.getInt("idProducto"),rs.getInt("id_empresa"),rs.getString("nombre"),rs.getString("descripcion"),
	                		rs.getDouble("costoUnitario"),rs.getDate("fechaCaducidad"),rs.getInt("cantidad"),rs.getInt("topeMayoreo"),rs.getInt("activo")));
	                
	                
	            }
	            for(int i=0;i<productosList.size();i++){
	            	producto=productosList.get(i);
	            	query="Select empresa from provedor where id_empresa='"+producto.getId_empresa()+"'";
	            	rs2=conexion.ejecutarSQLSelect(query);
	            	while(rs2.next()){
	            		producto.setNombreProveedor(rs2.getString("empresa"));
	            	}
	            }
	            productos=new Producto[productosList.size()];
	            productosList.toArray(productos);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productos;
		
	}
	/*public Proveedor[] dameProvedor(){
		Proveedor listaProvedor[] = null;
		int cont=0;
		String query;
		ResultSet rs;
		try{
			query="select * from provedor";
			rs=conexion.ejecutarSQLSelect(query);
			while(rs.next()){
				listaProvedor[cont]=rs.getString("empresa");
				cont++;			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listaProvedor;
		
	}*/
	public int dameId_empresa(String empresa){
		ResultSet rs;
		int val=-1;
		String query;
		try {
			query="select id_empresa from provedor where empresa='"+empresa+"'";
			rs=conexion.ejecutarSQLSelect(query);
		
			if(rs.next()){
				val=rs.getInt("id_empresa");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return val;
	}
	
	/**
	 * Busca en la base de datos a los productos con el nombre dado @param
	 * @param nombre
	 * @return producto
	 */
	public Producto[] buscaProducto(String nombre) {
		Producto[] productos=null;
		ArrayList<Producto> productosList=new ArrayList<Producto>();
		ResultSet rs;
		String query;
		 try {
	            // Crea el statement
	            //Statement statement = ManejadorBD.dameConnection().createStatement();

			 	query="SELECT * FROM producto WHERE nombre LIKE '%"+nombre+"%'";
	            // Recibe los resutados
	            rs=conexion.ejecutarSQLSelect(query);

	            while(rs.next()){
	                // Crea una nueva instancia del objeto
	                productosList.add(new Producto(rs.getInt("idProducto"),rs.getInt("id_empresa"),rs.getString("nombre"),rs.getString("descripcion"),
	                		rs.getDouble("costoUnitario"),rs.getDate("fechaCaducidad"),rs.getInt("cantidad"),rs.getInt("topeMayoreo"),rs.getInt("activo")));
	                
	            }
	            productos=new Producto[productosList.size()];
	            productosList.toArray(productos);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productos;
	}
	/**
	 * Modifica en la base de datos al producto con aquel dado @param
	 * @param producto
	 * @return true si fue exitoso, false si no
	 */
	public boolean modificaProducto(Producto producto) {
		String query;
		query="UPDATE producto set cantidad="+producto.getCantidad()+" where idProducto="+producto.getIdProducto(); 
			return conexion.ejecutarSQL(query);   
	}
	/**
	 * Borra en la base de datos el objeto dado @param
	 * @param producto
	 * @return true si hubo exito, false si no.
	 */
	public boolean borraProducto(Producto producto){
		String query;
        query="UPDATE producto set activo="+1+" where idProducto="+producto.getIdProducto();
        
        return conexion.ejecutarSQL(query);
        
	}
	// Regresa un arreglo de tipo Producto con productos más vendidos en un mes y ordenados de mayor a menor  ALEJ.
	public Producto[] masVendido(int mes){
		Producto[]productos=null;
		ArrayList<Producto> productosList=new ArrayList<Producto>();
		LinkedList<Integer> listaFolio=new LinkedList<Integer>();
		ResultSet rs1,rs2,rs3;
		String query;
		int folio,idproducto = 0, total_producto=0;
		try {
			
			rs2=null;
			rs3=null;
			
			//Se realiza consulta para obtener los folios de productos vendidos por el mes seleccionado ALEJ.
			query="select * from venta " +
					"where month(fechaOperacion) = "+mes+"";
			rs1=conexion.ejecutarSQLSelect(query);
			System.out.println("se realizo la consulta de idProducto por mes");
			//Se agregan los folios obtenidos por mes a una lista de folios
			while(rs1!=null && rs1.next()){
				//System.out.println("dentro del While de rs1");
				listaFolio.add(rs1.getInt("folio"));
			}
			//Se realiza la consulta para obtener el idProducto y el total de producto vendido por ese folio ALEJ.
			for(int i=0;i<listaFolio.size();i++){
				folio=listaFolio.get(i);
				System.out.println("Soy el folio de rs1 "+folio);
				query="Select idProducto,(sum(numeroProductos)) as total_producto" +
						" from ventaProducto where folio="+folio+"  group by idProducto";
				rs3=conexion.ejecutarSQLSelect(query);
				//Se agrega a la lista productos los productos obtenidos por los folios ALEJ.
				while(rs3!=null && rs3.next()){
					idproducto=rs3.getInt("idProducto");
					total_producto=rs3.getInt("total_producto");
					//System.out.println("Soy el idProdcuto de rs3 "+idproducto);
					//System.out.println("Soy el total_producto:"+total_producto+" del idProducto "+idproducto);
					productosList.add(new Producto(idproducto,total_producto));
					System.out.println("se agrego un nuevo producto");
				}
			}
			//Se realiza la consulta de los productos con el idProducto obtenido ALEJ.
			for(int i=0;i<productosList.size();i++){
				idproducto=productosList.get(i).getIdProducto();
				total_producto=productosList.get(i).getNumProducto();
				query="select * from producto where idProducto="+idproducto+"";
				rs2=conexion.ejecutarSQLSelect(query);
				System.out.println("se realizo la consulta para obtner producto con base en idProducto "+ idproducto);
				//Al tipo producto del producto de la lista se modifica los elemenots obtenidos por el idProducto ALEJ.	
				while(rs2.next()){
					
					/*System.out.println("id Producto: "+rs2.getInt("idProducto")+", Nombre: "+rs2.getString("nombre")+
							", Descripcion: "+rs2.getString("descripcion")+", Fecha de Caducidad: "+rs2.getString("fechaCaducidad")+
							", Costo unitario: "+rs2.getDouble("costoUnitario")+", Cantidad: "+rs2.getInt("cantidad")+
							", Empresa: "+rs2.getString("empresa")+", Tope Mayoreo: "+rs2.getInt("topeMayoreo")+
							", Total Producto: "+total_producto);*/
					System.out.println(" ");
					productosList.get(i).setIdProducto(rs2.getInt("idProducto"));
					productosList.get(i).setIdProducto(rs2.getInt("id_empresa"));
					productosList.get(i).setNombre(rs2.getString("nombre"));
					productosList.get(i).setDescripcion(rs2.getString("descripcion"));
					productosList.get(i).setCostoUnitario(rs2.getDouble("costoUnitario"));
					productosList.get(i).setFechaCaducidad(rs2.getDate("fechaCaducidad"));
					productosList.get(i).setCantidad(rs2.getInt("cantidad"));
					productosList.get(i).setTopeMayoreo(rs2.getInt("topeMayoreo"));
					productosList.get(i).setNombreProveedor(rs2.getString("activo"));
				}
				/*System.out.println("soy el producto coon idProducto: "+productosList.get(i).getIdProducto()+
						" soy el nombre del producto: "+productosList.get(i).getNombre()+
						" soy el total producto: "+productosList.get(i).getNumProducto());*/
				
			}
				//Se suman los productos vendidos en un mes no por folio ALEJ.
			productosList=sumaProducto(productosList);
			//Se ordenan productos por cantidad de productos de mayor a menos por mes ALEJ.
			productosList=ordenaProducto(productosList);
			
			productos=new Producto[productosList.size()];
            productosList.toArray(productos);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("hay un error "+e);
			e.printStackTrace();
			return null;
		}
		return productos;
	}
		//Suma la cantidad de productos vendidos realizadas con ventas distintas en el mes elegido ALEJ.
	public ArrayList<Producto> sumaProducto(ArrayList<Producto> listaProducto){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		Producto producto;
		int i,j,total_producto;
		for(i=0;i<listaProducto.size();i++){
			producto=listaProducto.get(i);
			
			for(j=i+1;j<listaProducto.size();j++){
				if(producto.getIdProducto()==listaProducto.get(j).getIdProducto()){
					total_producto=producto.getNumProducto()+listaProducto.get(j).getNumProducto();
					producto.setNumProducto(total_producto);
					listaProducto.remove(j);					
				}
			}
			lista.add(producto);
		}
		return lista;
	}
	//Ordena los productos por el numero de productos vendidos ALEJ.
	public ArrayList<Producto> ordenaProducto(ArrayList<Producto> listaProducto){
		Producto producto;
		int i,j;
		for(i=0;i<listaProducto.size()-1;i++){
			for(j=0;j<listaProducto.size()-1;j++){
	            if(listaProducto.get(j).getNumProducto()<listaProducto.get(j+1).getNumProducto()){
	               producto=listaProducto.get(j);
	               listaProducto.set(j, listaProducto.get(j+1));
	               listaProducto.set(j+1,producto);
	            }
			}
		}
		return listaProducto;
		
	}

}
