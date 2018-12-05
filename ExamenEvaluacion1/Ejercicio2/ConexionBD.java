package Ejercicio2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;

import com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type;

import UD02_P01_Conectores_MySQL.A01_Departamento;

public class ConexionBD {

	static Connection conexion;

	public static void main(String args[]) {

		System.out.println("Iniciando");

		// Creando la conexión
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/oscardam", "oscardam",
					"12345678");

			// USO DE METODOS //
			
			//consultamos un departamento
			Departamento dep = consultarDepartamento(200);
			System.out.println("Nombre "+dep.getNombreDepartamento()+"-numero "+
			dep.getIdDepartamento()+"-localidad "+dep.getLocalidad());
			//
			//subimos el sueldo de los empleados de un departamento
			incrementarSueldo(20, 3000);
			//
			//mostrar el esquema
			mostrarEsquema();
			
			/////////////////////

			conexion.close();
			System.out.println("Se ha cerrado la conexión");
		} catch (Exception e) {
			System.out.println("Error: no se ha podido realizar la conexion");
		}
	}
	
	 //Metodo para insertar un nuevo departamento en la base de datos. Devuelve un
	 // booleano para comprobar que se han insertado datos correctamente
	public static boolean insertarDepartamento(int numero, String nombre, String localidad) {
		String query1 = "insert into DEPT (`DEPTNO`, `DNAME`, `LOC`) " + 
				"values (" + numero + ", '" + nombre + "', '"
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

	 //M�todo devuelve un objeto Departamento a partir de un Id introducido por argumento
	public static Departamento consultarDepartamento(int id) {
		
		String localidad;
		String nombre;
		
		Departamento dep = null;

		CallableStatement stmt = null;

		try {
			// se crea la conexion
			stmt = conexion.prepareCall("{ call consultaDepar (?, ?, ?) }");
			// damos valor a los argumentos
			stmt.setInt(1, id); // primer argumento - id
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.execute(); // ejecutar el procedimiento
			
			//RECOGEMOS los valores
			dep = new Departamento(id, stmt.getString(2), stmt.getString(3));
			
		} catch (SQLException e) {
		}
		return dep;	
	}

	//Metodo que incrementa el salario de los empleados de un departamento
	public static void incrementarSueldo(int id, int sueldo) {
		
		String query = "UPDATE `EMP` SET `SAL`="+sueldo+" WHERE DEPTNO="+id;
		
		Statement stmt = null;
		
		try {
			stmt = conexion.createStatement();
			stmt.execute(query);
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}	
	}

	//metodo que imprimero el gesto de base de datos empleado, driver, usuario
	public static void mostrarDatos() {
	}

	//metodo que imprima esquema actual de las tablas y vistas
	public static void mostrarEsquema() throws SQLException {
		
		String query = "SHOW TABLES;";
		int contador = 1;
		
		Statement stmt = conexion.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println("Tablas de la base de datos:");
		
		while(rs.next()) {
			System.out.println("Tabla " + contador++ +" - "
					+rs.getString("Tables_in_oscardam"));
		}
	}
}
