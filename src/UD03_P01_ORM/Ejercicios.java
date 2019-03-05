package UD03_P01_ORM;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import modelo.HibernateUtils;
import modelos.entidades.Equipos;
import modelos.entidades.Estadisticas;
import modelos.entidades.Jugadores;

public class Ejercicios {

	public static Session session;
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		
		datosJugador(1);
		jugadoresEquipo("Clippers");
		estadisticasJugador(3);

	}

	public static void datosJugador(int codigo) {
		Query query = session.createQuery("FROM Jugadores where codigo = '" + codigo + "'");
		List<Jugadores> jugadores = query.list();
		
		if(jugadores.isEmpty()) {
			System.out.println("El jugador con ese código no existe");
			return;
		}
		
		for (Jugadores jugador : jugadores)
			System.out.println("Nombre: " + jugador.getNombre() + " | Procedencia: " + jugador.getProcedencia()
			+ " | Altura: " + jugador.getAltura() + " | Peso: " + jugador.getPeso() 
			+ " | Posición: " + jugador.getPosicion() + " | Nombre equipo: " + jugador.getEquipos());
	}
	
	public static void jugadoresEquipo(String nombre) {
		Query query = session.createQuery("FROM Jugadores where nombre_equipo = '" + nombre + "'");
		List<Jugadores> jugadores = query.list();
		
		if(jugadores.isEmpty()) {
			System.out.println("No existe un equipo con ese nombre");
			return;
		}
		
		for (Jugadores jugador : jugadores)
			System.out.println("Nombre: " + jugador.getNombre() + " | Procedencia: " + jugador.getProcedencia()
			+ " | Altura: " + jugador.getAltura() + " | Peso: " + jugador.getPeso() 
			+ " | Posición: " + jugador.getPosicion());
	}
	
	public static void estadisticasJugador(int codigo) {
		Query query = session.createQuery("FROM Jugadores jug INNER JOIN Estadisticas est ON jug.codigo = est.jugador"
				+ " WHERE jug.codigo = '" + codigo +"'");
		List<Object[]> objetos = query.list();
		
		boolean seguir = true;
		
		for (Object[] row: objetos) {
			//crear objetos jugador y estadisiticas a partir de la consulta de varias clases
			Jugadores jug = (Jugadores)row[0];
			Estadisticas est = (Estadisticas) row[1];
			
			//escribir solo una vez los datos del jugador
			if(seguir)
				System.out.println("---DATOS DEL JUGADOR---\n" 
				+ "Nombre: " + jug.getNombre() + " | Procedencia: " + jug.getProcedencia()
				+ " | Altura: " + jug.getAltura() + " | Peso: " + jug.getPeso()
				+ " | Posición: " + jug.getPosicion() + " | Nombre Equipo: " + jug.getEquipos()
				+ "\n---ESTADISTICAS---");
			
			//escribir todas las estadisticas del jugador
		    System.out.println("Temporada: " + est.getTemporada() + " | Puntos partido: " + est.getPuntos_por_partido()
		    +" | Asistencias partido: " + est.getAsistencias_por_partido() 
		    +" | Tapones partido: " + est.getTapones_por_partido()
		    +" | Rebotes partido: " + est.getRebotes_por_partido());
		    seguir = false;
		}
	}
}
