package com.tlamatini.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tlamatini.datos.ConexionDB;
//import com.tlamatini.datos.ManejadorBD;
import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.modelo.Usuario;

public class DAOProveedor {

	private Proveedor proveedores[];
	private Proveedor pros[];
	ConexionDB conexion;
	public DAOProveedor(ConexionDB con){
		conexion=con;
	}
	/**
	 * Agrega a la base de datos el Proveedor dado @param
	 * @param proveedor
	 * @return true si hubo éxito, de lo contrario false
	 */
	public boolean agregaProveedor(Proveedor proveedor) {
		String query;  
		//try {
		        // Crea el statement
		        //Statement statement = ManejadorBD.dameConnection().createStatement();
		        query="insert into provedor(empresa,telefono,direccion,activo) values ('"+proveedor.getEmpresa()+"',"+proveedor.getTelefono()+",'"
		        +proveedor.getDireccion()+"','"+0+"')";
		        
		        return conexion.ejecutarSQL(query);
		        //statement.execute("insert into proveedor values ('"+proveedor.getEmpresa()+"',"+proveedor.getTelefono()+",'"+proveedor.getDireccion()+"')");
		     
		        /*return true;
		    	} catch (SQLException e) {
		        // Cacha excepcion
		    		e.printStackTrace();
		    		return false;
		    	}*/
	}
	/**
	 * Busca en la base de datos el Proveedor de la empresa dada @param
	 * @param empresa
	 * @return proveedor
	 */
	public Proveedor buscaProveedor_id(int id_empresa) {
		Proveedor proveedor=null;
		String query;
		ResultSet rs;
		 try {
	            // Crea el statement
	            //Statement statement = ManejadorBD.dameConnection().createStatement();
			 	query="SELECT * FROM provedor WHERE id_empresa='"+id_empresa+"'";
	            // Recibe los resutados
	           rs = conexion.ejecutarSQLSelect(query);

	            if(rs.next()){
	                // Crea una nueva instancia del objeto
	                proveedor = new Proveedor(rs.getInt("id_empresa"),rs.getString("empresa"), rs.getString("direccion"), rs.getInt("telefono"),rs.getInt("activo"));
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return proveedor;
	}
	/**
	 * Busca en la base de datos a los proveedores de la empresa que contengan en su nombre algo de la cadena enviada @param
	 * @param empresa
	 * @return ArrayList<Proveedor>
	 */
	public ArrayList<Proveedor> buscaProveedor_empresa(String empresa) {
		ArrayList<Proveedor> listaProvedor=new ArrayList<Proveedor>();
		//Proveedor proveedor=null;
		String query;
		ResultSet rs;
		 try {
	            // Crea el statement where NOMBRE like '%algo%'
			 	query="SELECT * FROM provedor where empresa like '%"+empresa+"%'";
	            // Recibe los resutados
	           rs = conexion.ejecutarSQLSelect(query);

	            while(rs.next()){
	                listaProvedor.add(new Proveedor(rs.getInt("id_empresa"),rs.getString("empresa"), rs.getString("direccion"), rs.getInt("telefono"),rs.getInt("activo")));
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listaProvedor;
	}
	
	/**
	 * Busca en la base de datos el Proveedor de la empresa con el nombre exacto enviado por parametros se usa para eliminar el proveedor con el nombre exacto @param
	 * @param empresa
	 * @return proveedor
	 */
	public Proveedor buscaProveedor_empresa_nombre(String empresa) {
		Proveedor provedor=null;
		String query;
		ResultSet rs;
		 try {
	           query="SELECT * FROM provedor where empresa='"+empresa+"'";
	           rs = conexion.ejecutarSQLSelect(query);
	            while(rs.next()){
	                provedor=new Proveedor(rs.getInt("id_empresa"),rs.getString("empresa"), rs.getString("direccion"), rs.getInt("telefono"),rs.getInt("activo"));
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return provedor;
	}
	/**
	 * Busca en la base de datos el Proveedor de la empresa dada @param
	 * @param empresa
	 * @return ArrayList<Proveedor>
	 */
	public ArrayList<Proveedor> buscaProveedores_empresa_nombre(String empresa) {
		ArrayList<Proveedor> listaProvedor=new ArrayList<Proveedor>();;
		String query;
		ResultSet rs;
		 try {
	           query="SELECT * FROM provedor where empresa like '%"+empresa+"%'";
	           rs = conexion.ejecutarSQLSelect(query);
	            while(rs.next()){
	                listaProvedor.add(new Proveedor(rs.getInt("id_empresa"),rs.getString("empresa"), rs.getString("direccion"), rs.getInt("telefono"),rs.getInt("activo")));
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listaProvedor;
	}
	/**
	 * Modifica el proveedor en la base de datos reemplazandolo con el dado en @param
	 * @param proveedor
	 * @return true si hubo éxito, de lo contrario false
	 */
	public boolean modificaProveedor(Proveedor proveedor) {

		 int resultado = 0;
		 String query;
		 query="Update provedor Set direccion='"+proveedor.getDireccion()+"', telefono='"+proveedor.getTelefono()+"' " +
		 		"WHERE id_empresa='"+proveedor.getId_empresa()+"'";
		 return conexion.ejecutarSQL(query);
			
	}
	
	
	/**
	 * Borra el proveedor dado @param en la base de datos.
	 * @param proveedor
	 * @return true si hubo éxito, de lo contrario false
	 */
	public boolean borraProveedor(Proveedor proveedor){
		int resultado = 0;
		String query;
		 query="Update provedor set activo='"+1+"' WHERE id_empresa='"+proveedor.getId_empresa()+"'";
		 return conexion.ejecutarSQL(query);
	}
	/**
	 * Restrablece al proveedor dado @param en la base de datos.
	 * @param proveedor
	 * @return true si hubo éxito, de lo contrario false
	 */
	public boolean restablecerProveedor(Proveedor proveedor){
		int resultado = 0;
		String query;
		 query="Update provedor set activo='"+0+"' WHERE id_empresa='"+proveedor.getId_empresa()+"'";
		 return conexion.ejecutarSQL(query);
	}
	/**
	 * Regresa un ArryList<Proveedor> de los proveedores exisitentes en la base de datos.ALEJ.
	 * @param ArrayList<proveedor>
	 * @return ArrayList<proveedor>
	 */
	 public ArrayList<Proveedor> buscaTodos(){
 		pros = null;
 		ArrayList<Proveedor> proveedoresList=new ArrayList<Proveedor>();
 		String query="SELECT * FROM provedor"; 
 		try {
 	            ResultSet rs = conexion.ejecutarSQLSelect(query);

 	            while(rs.next()){
 	                proveedoresList.add(new Proveedor(rs.getInt("id_empresa"),rs.getString("empresa"),rs.getString("direccion"),rs.getInt("telefono"),rs.getInt("activo")));
 	            }


 		 } catch (SQLException e) {
 	            e.printStackTrace();
 	        }
 	        return proveedoresList;
  	}

	
	

}
