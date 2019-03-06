package ExamenEvaluacion2Ejercicio3;


import java.util.ArrayList;
import java.util.List;

public class ControllerEquipos {
	
	private ViewEquipos vista = new ViewEquipos();
	
	
	public ControllerEquipos() {
	}
	
	public void create(Equipo equipo) {
		EquipoDao dao = new EquipoDaoMySQLImp();
		dao.create(equipo);
	}
	
	public void update(Equipo equipo) {
		EquipoDao dao = new EquipoDaoMySQLImp();
		dao.update(equipo);
	}
	
	public void remove(Equipo equipo) {
		EquipoDao dao = new EquipoDaoMySQLImp();
		dao.delete(equipo);
	}
	
	public void viewEquipos() {
		
		/*List<Equipos> equipos = new ArrayList<Equipos>();
		JugadorDao dao = new JugadorDaoMySQLImp();
		
		 equipos = dao.read();
		 vista.viewTodosJugadores(equipos);*/
		
		EquipoDao daoMongo = new EquipoDaoMySQLImp();
		List<Equipo> equiposMongo = new ArrayList<Equipo>();
		equiposMongo = daoMongo.read();
		vista.viewTodosEquipos((equiposMongo));
	}
	
	public void viewEquipos(Equipo equipo) {
		vista.viewEquipo(equipo);
	}
	
	public static void actualizarEquipo(Equipo equipo) {
		
	}
}
