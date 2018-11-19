package UD02_P02_ConectoresSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorSQLite {
	
	private static Statement statement;
	
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
          
          ResultSet rs = statement.executeQuery("select * from persona");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
          }
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
		  statement.executeUpdate("insert into persona values(2, '"+nombre+"', "
		  		+ "'"+apellido+"','"+email+"', '"+telefono+"','"+localidad+"')");
	  }

}
