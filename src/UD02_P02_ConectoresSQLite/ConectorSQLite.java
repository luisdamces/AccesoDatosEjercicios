package UD02_P02_ConectoresSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorSQLite {
	
	private static Statement statement;
	private static ResultSet rs;
	
	  public static void main(String[] args)
      {
        Connection connection = null;
        
        try
        {
        	
          // create a database connection
          connection = DriverManager.getConnection
            ("jdbc:sqlite:src\\UD02_P02_ConectoresSQLite\\SQLite\\prueba.db");
          
          statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          //crear la tabla principal
          statement.executeUpdate("drop table if exists persona");
          statement.executeUpdate
          	("create table persona (id integer, nombre string, apellido string,"
          	 + "email string, telefono string, localidad string)");
          
          insertar("oscar", "tutor", "a@a.es", "898787676", "tudela");
          insertar("jorge", "jorgito", "a@a.es", "898787676", "tarazona");
          insertar("pepe", "pepito", "a@a.es", "898787676", "pepe");
          insertar("alex", "alejandro", "a@a.es", "898787676", "novallas");
          
          consultar();
          
          buscar(2);
          
          borrar(2);
          
          actualizar(1, "oksdjpasd");
          
          consultar();
          
         
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
      }
	  
	  
	  /**
	   * Metodo que inserta un registro en la tabla personas
	   * @param nombre
	   * @param apellido
	   * @param email
	   * @param telefono
	   * @param localidad
	   * @throws SQLException 
	   */
	  public static void insertar(String nombre, String apellido, String email, 
		                   String telefono, String localidad) throws SQLException
	  {
		  int id = 1;
		  
		  //comprobar el ultimo id de la base de datos
		  rs = statement.executeQuery("select id from persona ORDER BY id ASC");
		  
		  //incrementa en 1 el id para que sea autoincrementado
          while(rs.next())
          {
        	  id = rs.getInt("id");
        	  id++;
          }
		  
		  statement.executeUpdate("insert into persona values("+id+", '"+nombre+"', "
		  		+ "'"+apellido+"','"+email+"', '"+telefono+"','"+localidad+"')");
	  }
	  
	  
	  /**
	   * Metodo que saca por pantalla todos los registros de la base de datos
	   * @throws SQLException Excepcion
	   */
	  public static void consultar() throws SQLException
	  {
		  //consulta a base de datos
		  rs = statement.executeQuery("select * from persona");
		  
		  System.out.println("Registros de la base de datos: ");
		  
          while(rs.next())
          {
            // read the result set
        	System.out.print("id = " + rs.getInt("id") + " | ");
            System.out.print("nombre = " + rs.getString("nombre") + " | ");
            System.out.print("apellido = " + rs.getString("apellido") + " | ");
            System.out.print("email = " + rs.getString("email") + " | ");
            System.out.print("telefono = " + rs.getString("telefono") + " | ");
            System.out.println("localidad = " + rs.getString("localidad"));       
          }
	  }

	  
	  /**
	   * Metodo que busca un registro a partir de un id
	   * @param id Id para buscar un registro
	   * @throws SQLException Excepcion
	   */
	  public static void buscar(int id) throws SQLException
	  {
		  //consulta a base de datos
		  rs = statement.executeQuery("select * from persona where id = '"+id+"'");
		  
		  System.out.println("Registro con ID " + id +":");
		  
          while(rs.next())
          {
            // read the result set
        	System.out.print("id = " + rs.getInt("id") + " | ");
            System.out.print("nombre = " + rs.getString("nombre") + " | ");
            System.out.print("apellido = " + rs.getString("apellido") + " | ");
            System.out.print("email = " + rs.getString("email") + " | ");
            System.out.print("telefono = " + rs.getString("telefono") + " | ");
            System.out.println("localidad = " + rs.getString("localidad"));       
          }
	  }

	  
	  /**
	   * Metodo que elimina un registro de la tabla a partir de un ID
	   * @param id
	   * @throws SQLException Excepcion
	   */
	  public static void borrar(int id)
	  {
		  try
		  {
			  //borrar un registro a partir del id
			  rs = statement.executeQuery("delete from persona where id = '"+id+"'");
			  
		  }
		  catch(SQLException e)
		  {  
		  }

	  }
	  
	  
	  /**
	   * Metodo para cambiar el nombre a un registro a partir del id
	   * @param id 
	   * @throws SQLException Excepcion
	   */
	  public static void actualizar(int id, String nombre) throws SQLException
	  {
		  try
		  {
			  //borrar un registro a partir del id
			  rs = statement.executeQuery("update persona set nombre = '"+nombre+
					  						"'where id = '"+id+"'"); 
		  }
		  catch(Exception e)
		  {
			  
		  }
		   
		

	  }
}
