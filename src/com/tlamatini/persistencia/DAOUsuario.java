package com.tlamatini.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tlamatini.datos.ConexionDB;
//import com.tlamatini.datos.ManejadorBD;
import com.tlamatini.modelo.Usuario;

public class DAOUsuario{
	ConexionDB conexion;
	public DAOUsuario(ConexionDB con){
		conexion=con;
	}
	
	/**
	 * Agrega el objeto Usuario @param a la base de datos
	 * @param usuario
	 * @return true si fue exitoso, false de lo contrario
	 */
	public boolean agregaUsuario(Usuario usuario) {
		int llave;
		String query;
    
        // Crea el statement
        //Statement statement = ManejadorBD.dameConnection().createStatement();
        
        /*statement.execute("insert into usuario values ('"+usuario.getNick()+"','"+usuario.getNombre()+"','"+usuario.getApellido()+
        		"','"+usuario.getPassword()+"',"+usuario.isEsAdministrador()+","+usuario.getTelefono()+",'"+usuario.getCorreo()+"')");
       */
		query="insert into usuario(nick,nombre,apellido,password,administrador,telefono,correo) " +
				"values ('"+usuario.getNick()+"','"+usuario.getNombre()+"','"+usuario.getApellido()+
        		"','"+usuario.getPassword()+"',"+usuario.esAdministrador()+","+usuario.getTelefono()+",'"
				+usuario.getCorreo()+"')";
        if(conexion.ejecutarSQL(query)==true){
        	return true;
        }else{
        	return false;
        }
        	
        
    	
}

	
	/**
	 * Busca el Usuario con nick @param en la base de datos
	 * @param nick
	 * @return usuario
	 */
	public Usuario buscaUsuario(String nick) {
		Usuario usuario=null;
		ResultSet rs;
		String query;
		 try {
	            // Crea el statement
	            //Statement statement = ManejadorBD.dameConnection().createStatement();
	            query="SELECT * FROM usuario WHERE nick='"+nick+"'";
	            // Recibe los resutados
	            rs= conexion.ejecutarSQLSelect(query);

	            if(rs.next())
	            {
	                // Crea una nueva instancia del objeto
	                usuario = new Usuario(rs.getInt("id_usuario"),rs.getString("nick"), rs.getString("nombre"),  rs.getString("apellido"), rs.getString("password"), rs.getInt("telefono"), rs.getString("correo"),rs.getBoolean("administrador"));

	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usuario;
	}
	/**
	 * Modifica el usuario dado @param en la base de datos
	 * @param usuario
	 * @return true si fue exitoso, de otro modo false
	 */
	public boolean modificaUsuario(Usuario usuario) {
		int resultado=0;
		String query;
		//try {
			query="UPDATE usuario set correo='"+usuario.getCorreo()+"', password='"+usuario.getPassword()+"', telefono="+usuario.getTelefono()+" " +
					"where nick='"+usuario.getNick()+"'";
			if(conexion.ejecutarSQL(query)==true){
				return true;
				
			}else{
				return false;
			}
			/* //Statement statement = ManejadorBD.dameConnection().createStatement();
		     resultado=statement.executeUpdate("UPDATE usuario set correo='"+usuario.getCorreo()+"' where nick='"+usuario.getNick()+"'");
		     if(resultado==0)
		    	 return false;

		     resultado=statement.executeUpdate("UPDATE usuario set password='"+usuario.getPassword()+"' where nick='"+usuario.getNick()+"'");
		     if(resultado==0)
		    	 return false;
		     
		     resultado=statement.executeUpdate("UPDATE usuario set telefono="+usuario.getTelefono()+"where nick='"+usuario.getNick()+"'");
		     if(resultado==0)
		    	 return false;
		     
		    } catch (Exception e) {
		      System.err.println("Exception: "+e.getMessage());
		      e.printStackTrace();
		      return false;
		    }
        if(resultado == 0) {
            return false;
        } else {
            return true;
        }*/
	}
	/**
	 * Borra el usuario @param dado en la base de datos
	 * @param usuario
	 * @return true si fue exitoso, de otro modo false
	 */
	public boolean borraUsuario(Usuario usuario){
		 int resultado = 0;
		 String query;
	        //try {
	            // Crea el statement
	          //  Statement statement = ManejadorBD.dameConnection().createStatement();
	            
		 query="DELETE FROM usuario WHERE nick='"+usuario.getNick()+"')";
		 return conexion.ejecutarSQL(query);
	            // Recibe los resutados
	            /*resultado = statement.executeUpdate("DELETE FROM usuario WHERE nick='"+usuario.getNick()+"')");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        if(resultado == 0) {
	            return false;
	        } else {
	            return true;
	        }*/

	    }
		

}
