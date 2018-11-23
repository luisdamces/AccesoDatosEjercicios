package UD02_P01_Conectores_MySQL;

import java.sql.*;

public class Procedimientos_funciones {
	
	public static void main(String[] args) 
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
    				"jdbc:mysql://www.db4free.net:3306/tubalcain",
    				"tubalcain_dam",
    				"12345678"
    				); 

			//
				// recuperar parametros de main
				int dep = 1;   //"10"; // departamento
				float subida = 50;//"1000"; // subida					
				// construir orden DE LLAMADA
				String sql = "{ call subida_sal_oscar (?, ?) } ";
	
				// Preparamos la llamada
				CallableStatement llamada = conexion.prepareCall(sql);
				
				// Damos valor a los argumentos
				llamada.setInt(1, dep); // primer argumento-dep
				llamada.setFloat(2, subida); // segundo arg
																
				llamada.executeUpdate(); // ejecutar el procedimiento
				System.out.println("Subida realizada....");
			//
			
			//llamada a la funcion que devuelve nombre de departamento
				dep = 10;
				sql = "{ ? = call nombre_dep_oscar (?) } ";
				
				//preparamos la llamada
				llamada = conexion.prepareCall(sql);
				
				//registramos el parametro de salida que esta en la posicion 1
				llamada.registerOutParameter(1, Types.VARCHAR);
				//damos valor a los argumentos. tiene que ser el segundo
				//porque el primero es lo que devuelve la funcion
				llamada.setInt(2, dep);
				
				//ejecutar el procedimiento
				llamada.execute();
				
				//recogemos el valor que devuelve
				System.out.println("N. de departamento: " + dep + " - Nombre: "
						+ llamada.getString(1));

			//
				
			//
				//llamada a la funcion que devuelve datos de departamento
				sql = "{ call datos_dep_oscar (?, ?, ?) } ";
				
				//preparamos la llamada
				llamada = conexion.prepareCall(sql);
				
				//registramos el parametro de salida que esta en la posicion 2 y 3
				llamada.registerOutParameter(2, Types.VARCHAR);
				llamada.registerOutParameter(3, Types.VARCHAR);
				//damos valor a los argumentos. tiene que ser el segundo
				//porque el primero es lo que devuelve la funcion
				llamada.setInt(1, dep);
				
				//ejecutar el procedimiento
				llamada.execute();
				
				//recogemos el valor que devuelve
				System.out.println("Nombre: " + llamada.getString(2) 
						+ " - Localidad: " + llamada.getString(3));

			//
			
			llamada.close();
			conexion.close();
		} 
		catch (ClassNotFoundException cn) 
		{
			cn.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
}