package UD02_P01_Conectores_MySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class A01_ConexionBD {

	static Connection conexion;

	public static void main(String args[]) {

		System.out.println("Iniciando");

		// Creando la conexión
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/oscardam", "oscardam",
					"12345678");

			// USO DE METODOS //
			
			if(modificarDepartamento(new A01_Departamento(99, "Prueba3", "Madrid"))) 
				System.out.println("Se ha modificado correctamente");
			else
				System.out.println("No se ha podido modificar");
			
			
			/////////////////////

			conexion.close();
			System.out.println("Se ha cerrado la conexión");
		} catch (Exception e) {
			System.out.println("Error: no se ha podido realizar la conexion");
		}
	}

	/**
	 * Metodo para insertar un nuevo departamento en la base de datos. Devuelve un
	 * booleano para comprobar que se han insertado datos correctamente
	 * 
	 * @param numero ID del departamento
	 * @param nombre Nombre del departamento
	 * @param localidad Localidad del departamento
	 */
	public static boolean insertarDepartamento(int numero, String nombre, String localidad) {
		String query1 = "insert into DEPT (`DEPTNO`, `DNAME`, `LOC`) " + "values (" + numero + ", '" + nombre + "', '"
				+ localidad + "');";

		String query2 = "select DEPTNO from DEPT where DEPTNO=" + numero;

		Statement stmt = null;

		try {
			// se crea la conexion
			stmt = conexion.createStatement();
			// se ejecuta el insert
			stmt.execute(query1);

			// consultamos ls bd para ver si se ha introducido
			ResultSet rs = stmt.executeQuery(query2);

			if (rs != null) {
				stmt.close();
				return true;
			} else {
				stmt.close();
				return false;
			}

		} catch (SQLException e) {
		}

		return false;
	}

	/**
	 * Metodo para insertar un nuevo departamento en la base de datos. Devuelve un
	 * booleano para comprobar que se han insertado datos correctamente
	 * 
	 * @param dep Objeto departamento
	 * @return Devuelve un booleano indicando si se ha insertado o no datos en la B.D.
	 */
	public static boolean insertarDepartamento(A01_Departamento dep) {
		String query1 = "insert into DEPT (`DEPTNO`, `DNAME`, `LOC`) " + "values (" + dep.getIdDepartamento() + ", "
				+ "'" + dep.getNombreDepartamento() + "'," + " '" + dep.getLocalidad() + "');";

		String query2 = "select DEPTNO from DEPT " + "where DEPTNO=" + dep.getIdDepartamento();

		Statement stmt = null;

		try {
			// se crea la conexion
			stmt = conexion.createStatement();
			// se ejecuta el insert
			stmt.execute(query1);

			// consultamos ls bd para ver si se ha introducido
			ResultSet rs = stmt.executeQuery(query2);

			if (rs != null) {
				stmt.close();
				return true;
			} else {
				stmt.close();
				return false;
			}

		} catch (SQLException e) {
		}

		return false;
	}

	/**
	 * M�todo que devuelve un ArrayList con todos los departamentos de la base de datos
	 * 
	 * @return ArrayList de objetos Departamento
	 */
	public static ArrayList<A01_Departamento> consultarDepartamentos() {

		ArrayList<A01_Departamento> lista= new ArrayList<A01_Departamento>();
		String query = "select * from DEPT";

		Statement stmt = null;

		try {
			// se crea la conexion
			stmt = conexion.createStatement();
			// se ejecuta el select
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				A01_Departamento dep = new A01_Departamento(rs.getInt("DEPTNO"), rs.getString("DNAME"),
						rs.getString("LOC"));

				lista.add(dep);
			}	
		} catch (SQLException e) {
		}

		return lista;
		
	}

	/**
	 * M�todo devuelve un objeto Departamento a partir de un Id introducido por argumento
	 * 
	 * @return Devuelve un objeto Departamento
	 */
	public static A01_Departamento consultarDepartamento(int id) {
		
		A01_Departamento dep = null;
		String query = "select * from DEPT where DEPTNO=" + id;

		Statement stmt = null;

		try {
			// se crea la conexion
			stmt = conexion.createStatement();
			// se ejecuta el select
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				dep = new A01_Departamento(rs.getInt("DEPTNO"), rs.getString("DNAME"),
						rs.getString("LOC"));
			}	
		} catch (SQLException e) {
		}

		return dep;	
	}

	/**
	 * M�todo que elimina un departamento de la base de datos seg�n el id introducido
	 * 
	 * @param id Id del departamento a borrar
	 * @return Devuelve un numero indicando el n�mero de filas afectadas
	 */
	public static int eliminarDepartamento(int id) {
		
		String query1 = "delete from DEPT where DEPTNO=" + id;

		Statement stmt = null;

		try {
			stmt = conexion.createStatement();
			//comprobamos que el id introducido existe
			A01_Departamento dep = consultarDepartamento(id);
			
			if(dep != null)
				stmt.execute(query1);
			else
				return 0;
			
			//comprobamos que el id introducido ya no existe
			dep = consultarDepartamento(id);
			
			if(dep != null)
				return 0;
			else
				return 1;

		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return 0;	
	}

	/**
	 * M�todo que modifica la localidad de un departamento segun el id
	 * @param id Id del departamento
	 * @param localidad Nueva localidad
	 * @return Devuelve un booleano indicando si el proceso se ha realizado correctamente
	 */
	public static boolean modificarDepartamento(int id, String localidad) {

		Statement stmt = null;

		try {
			stmt = conexion.createStatement();
			//comprobamos que el id introducido existe
			A01_Departamento dep = consultarDepartamento(id);
			
			if(dep != null) {
				// Preparamos la llamada
				CallableStatement llamada = conexion.prepareCall("{ call actualizaDept (?, ?) }");
				// Damos valor a los argumentos
				llamada.setInt(1, id); // primer argumento - id
				llamada.setString(2, localidad); // segundo arg - localidad
				llamada.executeUpdate(); // ejecutar el procedimiento
				
				stmt.close();
				llamada.close();
				
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}	
		return false;
	}

	/**
	 * Método al que le pasas un objeto departamento, y si un departamento con
	 * ese ID existe en la base de datos, lo modifica
	 * @param dep Objeto departamento
	 * @return Devuelve un boolean indicando si el proceso se ha realizado
	 * correctamente o no
	 */
	public static boolean modificarDepartamento(A01_Departamento dep) {
		
		String query = "UPDATE DEPT SET DNAME = '"+dep.getNombreDepartamento()+
				"', LOC = '"+dep.getLocalidad()+"' where DEPTNO = " + dep.getIdDepartamento();
		Statement stmt = null;

		try {
			stmt = conexion.createStatement();
			//comprobamos que el id introducido existe
			A01_Departamento existe = consultarDepartamento(dep.getIdDepartamento());
			
			if(existe != null) {
				
				stmt.execute(query);
				
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}	
		return false;
	}
}
