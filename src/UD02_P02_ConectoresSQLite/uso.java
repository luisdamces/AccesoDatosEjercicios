package UD02_P02_ConectoresSQLite;

import java.sql.SQLException;

public class uso {

	public static void main(String[] args) throws SQLException {

		ConectorSQLite conector = new ConectorSQLite();
		conector.conexionBD();
		conector.consultar();
		
		conector.borrar(2);
		conector.consultar();
		
		System.out.println("crear base de datos de nuevo");
		conector.crearTabla();
		conector.consultar();
		
		conector.actualizar(2, "hasdfkljhadks");
		conector.consultar();

	}

}
