package ExamenEvaluacion2Ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class EquipoDaoMySQLImp implements EquipoDao {

	@Override
	public boolean create(Equipo equipo) {
		
	boolean created = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO equipos values ("+equipo.getCodigo()+",'"+equipo.getNombre()
			+"',"+equipo.getFundacion()+","+equipo.getEnPrimera()+","
			+equipo.getLigas()+","+equipo.getCopas();
		
		try {			
			con=MySQLConnection.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			created=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método create");
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Equipo> read() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM equipos ORDER BY codigo";
		
		List<Equipo> listaJugadores= new ArrayList<Equipo>();
		
		try {			
			co= MySQLConnection.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				
				Equipo j = new Equipo();
				j.setCodigo(rs.getInt(1));
				j.setNombre(rs.getString(2));
				j.setFundacion(rs.getInt(3));
				j.setEnPrimera(rs.getInt(4));
				j.setLigas(rs.getInt(5));
				j.setCopas(rs.getInt(6));
				listaJugadores.add(j);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método read");
			e.printStackTrace();
		}
		
		return listaJugadores;
	}

	@Override
	public boolean update(Equipo equipo) {
		
		Connection connect= null;
		Statement stm= null;
		
		boolean updated=false;
		
		String sql="UPDATE equipos SET nombre='"+equipo.getNombre()+"', fundacion='"
		+equipo.getFundacion()+"', temp_primera='"+equipo.getEnPrimera()
		+"', ligas=" + equipo.getLigas()+", copas='" 
				+ equipo.getCopas()+"' WHERE codigo="
				+equipo.getCodigo();
		
		try {
			connect=MySQLConnection.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			updated=true;
		} catch (SQLException e) {
			System.out.println("Error: JugadorDaoMySQLImp, método actualizar");
			e.printStackTrace();
		}		
		return updated;
	}

	@Override
	public boolean delete(Equipo Equipo) {
		Connection con = null;
		Statement stm = null;
		
		boolean removed = false;
		String sql = "DELETE FROM equipos WHERE codigo = "+Equipo.getCodigo();
		
		try {
			con = MySQLConnection.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			removed = true;
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método delete");
			e.printStackTrace();
		}
		
		
		return removed;
	}

}
