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
	}

}
