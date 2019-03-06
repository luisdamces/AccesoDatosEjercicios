package ExamenEvaluacion2Ejercicio3;

import ExamenEvaluacion2Ejercicio3.ControllerEquipos;

public class Demo {

	public static void main(String[] args) {
		
		ControllerEquipos controllerEquipos = new ControllerEquipos();
		
		controllerEquipos.viewEquipos();
		
		/*controllerEquipos.create(new Equipos("prueba", 
				"prueba", "prueba", "prueba"));
		controllerEquipos.viewEquipos();
		
		controllerEquipos.update(new Equipos("Bucks", "Milwaukee", "EastEast", "Central"));
		controllerEquipos.viewEquipos();
		controllerEquipos.update(new Equipos("Bucks", "Milwaukee", "East", "Central"));
		
		controllerEquipos.remove(new Equipos("prueba", "", "", ""));
		controllerEquipos.viewEquipos();*/
		
		controllerEquipos.viewEquipos();
		
		controllerEquipos.create(new Equipo(26, "Real Zaragoza", 0, 6, 1932, 59));
		
		controllerEquipos.update(new Equipo(3, "Barcelona", 24, 26, 1907, 83));
		
		controllerEquipos.remove(new Equipo(17, "Mérida", 0, 0, 0, 0));
	}

}
