package UD03_P01_ORM;

//importamos el modelo-entidad de la tabla departamentos
//que hemos generado con Hibernate
import modelos.entidades.*;
import java.util.List;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.query.Query;


//clase necesaria para el funcionamiento de hibernate
import modelo.HibernateUtils;
//

public class E03_Consulta_varias_tablas {
	
	static Scanner teclado;
	
	public static void main (String[] args) {
		
		teclado = new Scanner(System.in);
		String clave = "";
		
		//generamos el objeto SessionFactory a partir de la clase HibernateUtilss
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//abrimos la sesiÃ³n
		Session session = sessionFactory.openSession();
		
		//pedir por teclado un nombre de equipo
		System.out.println("Introduce el código de un jugador:");
		clave = teclado.nextLine();
		
		//obtener datos de un jugador
		/*Query query1 = session.createQuery("SELECT Jugadores.nombre, Equipos.ciudad FROM Jugadores, Equipos "
				+ "where Jugadores.nombre_equipo = Equipos.nombre and Jugadores.codigo = 1");*/
		Query query1 = session.createQuery("FROM Jugadores where codigo = '"+ clave + "'");
		List<Jugadores> jugadores = query1.list();
		
		System.out.println("---DATOS DEL JUGADOR---");
		
		for (Jugadores jugador : jugadores) {	
		System.out.println("Nombre: " + jugador.getNombre() + " - Altura: " + jugador.getAltura() + 
				" - Posición: " + jugador.getPosicion() + " - Peso: " + jugador.getPeso() + 
				" - Equipo: " + jugador.getEquipos() + " - Ciudad del equipo: " );
		}
		
		//obtener estadisticas del jugador
		Query query2 = session.createQuery("FROM Estadisticas where jugador = '" + clave + "'");
		List<Estadisticas> estadisticas = query2.list();
		
		System.out.println("---ESTADISTICAS DEL JUGADOR---");
		
		for (Estadisticas estadistica : estadisticas) {	
		System.out.println("Temporada: " + estadistica.getTemporada() + " - Puntos por partido: " + estadistica.getPuntos_por_partido() +
				" - Asistencias por partido: " + estadistica.getAsistencias_por_partido() + " - Tapones por partido: " + estadistica.getTapones_por_partido() + 
				" - Rebotes por partido: " + estadistica.getRebotes_por_partido());
		}
		
		sessionFactory.close();
	}
}
