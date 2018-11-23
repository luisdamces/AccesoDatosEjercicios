package UD02_P01_Conectores_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A01_ConexionBD 
{
	
	static Connection conexion;
	
	public static void main (String args[])
	{
		 System.out.println("Iniciando");
		    
		    // Creando la conexión
		    try 
		    {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conexion = DriverManager.getConnection(
		        				"jdbc:mysql://www.db4free.net:3306/oscardam",
		        				"oscardam",
		        				"12345678"); 
		        
		        //Uso de metodos/////////
		        
		        //Metodo para insertar departamento con clase Departamento
		        A01_Departamento departamento = 
		        		new A01_Departamento(100,"prueba", "madrid");
		        
		        if(insertarDepartamento(departamento))
		        	System.out.println("Los datos se introducieron correctamente");
		        else
		        	System.out.println("Los datos no fueron introducidos");
		        
		        
		        ///////////
	            conexion.close();
	            System.out.println("Se ha cerrado la conexión");
		    }
		    catch(Exception e)
		    {	
		    	System.out.println("Error: no se ha podido realizar la conexion");
		    }
	}
	
	/**
	 * Metodo para insertar un nuevo departamento en la base de datos. Devuelve
	 * un booleano para comprobar que se han insertado datos correctamente
	 * @param numero ID del departamento
	 * @param nombre Nombre del departamento
	 * @param localidad Localidad del departamento
	 */
	public static boolean insertarDepartamento(int numero, String nombre, String localidad)
	{
		String query1 = "insert into DEPT (`DEPTNO`, `DNAME`, `LOC`) "
				     + "values ("+numero+", '"+nombre+"', '"+localidad+"');";
		
		String query2 = "select DEPTNO from DEPT where DEPTNO="+numero;
        
        Statement stmt = null;
        
        try 
        {
        	//se crea la conexion
            stmt = conexion.createStatement();	
            //se ejecuta el insert
            stmt.execute(query1);
            
            //consultamos ls bd para ver si se ha introducido
            ResultSet rs = stmt.executeQuery(query2);
            
            if(rs != null)
            {
                stmt.close();
                return true;
            }
            else
            {
            	stmt.close();
            	return false;
            }
            
        }
        catch (SQLException e)
        {
        }   
        
        return false;
	}
	
	public static boolean insertarDepartamento(A01_Departamento dep)
	{
		String query1 = "insert into DEPT (`DEPTNO`, `DNAME`, `LOC`) "
				     + "values ("+dep.getIdDepartamento()+", "
				     + "'"+dep.getNombreDepartamento()+"',"
				     + " '"+dep.getLocalidad()+"');";
		
		String query2 = "select DEPTNO from DEPT "
					  + "where DEPTNO="+dep.getIdDepartamento();
        
        Statement stmt = null;
        
        try 
        {
        	//se crea la conexion
            stmt = conexion.createStatement();	
            //se ejecuta el insert
            stmt.execute(query1);
            
            //consultamos ls bd para ver si se ha introducido
            ResultSet rs = stmt.executeQuery(query2);
            
            if(rs != null)
            {
                stmt.close();
                return true;
            }
            else
            {
            	stmt.close();
            	return false;
            }
            
        }
        catch (SQLException e)
        {
        }   
        
        return false;
	}
}
