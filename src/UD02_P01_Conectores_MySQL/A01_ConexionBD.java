package UD02_P01_Conectores_MySQL;

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

		// Creando la conexi√≥n
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/oscardam", "oscardam",
					"12345678");

			// USO DE METODOS //
			
			A01_Departamento dep = consultarDepartamento(20);
			
			System.out.println("DEPTNO: " + dep.getIdDepartamento() + " - DNAME: " + dep.getNombreDepartamento() + 
					" - LOC: " + dep.getLocalidad());
			
			/////////////////////

			conexion.close();
			System.out.println("Se ha cerrado la conexi√≥n");
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
	 * MÈtodo que devuelve un ArrayList con todos los departamentos de la base de datos
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
	 * MÈtodo devuelve un objeto Departamento a partir de un Id introducido por argumento
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
}
