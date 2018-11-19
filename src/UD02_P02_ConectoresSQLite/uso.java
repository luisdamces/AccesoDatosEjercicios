package UD02_P02_ConectoresSQLite;

import java.sql.SQLException;

public class uso {

	public static void main(String[] args) throws SQLException {

		ConectorSQLite conector = new ConectorSQLite();
		conector.conexionBD();
		conector.consultar();
		
		conector.borrar(2);
		conector.consultar();

	}

}
