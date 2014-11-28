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
	 * Busca en la base de datos el Proveedor de la empresa dada @param
	 * @param empresa
	 * @return proveedor
	 */
	public Proveedor buscaProveedor_empresa(String empresa) {
		Proveedor proveedor=null;
		String query;
		ResultSet rs;
		 try {
	            // Crea el statement where NOMBRE like '%algo%'
	            //Statement statement = ManejadorBD.dameConnection().createStatement();
			 	query="SELECT * FROM provedor where empresa like '%"+empresa+"%'";
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
	 * Busca en la base de datos el Proveedor de la empresa dada @param
	 * @param empresa
	 * @return proveedor
	 */
	public Proveedor buscaProveedor_empresa_nombre(String empresa) {
		Proveedor proveedor=null;
		String query;
		ResultSet rs;
		 try {
	            
	            //Statement statement = ManejadorBD.dameConnection().createStatement();
			 	query="SELECT * FROM provedor where empresa like '"+empresa+"'";
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
	 * Modifica el proveedor en la base de datos reemplazandolo con el dado en @param
	 * @param proveedor
	 * @return true si hubo éxito, de lo contrario false
	 */
	public boolean modificaProveedor(Proveedor proveedor) {

		 int resultado = 0;
		 String query;
		 query="Update proveedor Set direccion='"+proveedor.getDireccion()+"', telefono='"+proveedor.getTelefono()+"' " +
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
        /*try {
            // Crea el statement
            Statement statement = ManejadorBD.dameConnection().createStatement();

            // Recibe los resutados
            resultado = statement.executeUpdate("DELETE FROM proveedor WHERE empresa='"+proveedor.getEmpresa()+"'");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultado == 0) {
            return false;
        } else {
            return true;
        }*/
        
       
		
	}
	
	 public ArrayList<Proveedor> buscaTodos(){
 		pros = null;
 		ArrayList<Proveedor> proveedoresList=new ArrayList<Proveedor>();
 		String query="SELECT * FROM provedor"; 
 		try {
 	            // Crea el statement
 	            //Statement statement = ManejadorBD.dameConnection().createStatement();

 	            // Recibe los resutados
 	            ResultSet rs = conexion.ejecutarSQLSelect(query);

 	            while(rs.next()){
 	                // Crea una nueva instancia del objeto
 	                proveedoresList.add(new Proveedor(rs.getInt("id_empresa"),rs.getString("empresa"),rs.getString("direccion"),rs.getInt("telefono"),rs.getInt("activo")));
 	            }
 	            //proveedoresList.toArray(proveedores);
 	            //for(int i=0;i<proveedoresList.size();i++){
 	            //	System.out.println(""+proveedoresList.get(i).getEmpresa());
 	            //	System.out.println(""+proveedoresList.get(i).getDireccion());
 	            //	System.out.println(""+proveedoresList.get(i).getTelefono());
 	            //}

 		 } catch (SQLException e) {
 	            e.printStackTrace();
 	        }
 	        return proveedoresList;
  	}

	
	

}
