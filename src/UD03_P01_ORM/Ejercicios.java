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
		estadisticasJugador(2);

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
		//consulta a jugadores
		Query query = session.createQuery("FROM Jugadores where codigo = '" + codigo + "'");
		List<Jugadores> jugadores = query.list();
		//consulta a estadisticas
		query = session.createQuery("FROM Estadisticas where jugador = '" + codigo + "'");
		List<Estadisticas> estadisticas = query.list();
		
		if(jugadores.isEmpty() || estadisticas.isEmpty()) {
			System.out.println("El jugador con ese código no existe o no tiene estadisticas");
			return;
		}
		
		System.out.println("------------------------------------------------------");
		for (Jugadores jugador : jugadores) 
			System.out.println("Nombre: " + jugador.getNombre() + " | Procedencia: " + jugador.getProcedencia()
			+ " | Altura: " + jugador.getAltura() + " | Peso: " + jugador.getPeso() 
			+ " | Posición: " + jugador.getPosicion() + " | Nombre equipo: " + jugador.getEquipos());

		System.out.println("ESTADISTICAS:");
		for (Estadisticas estadistica : estadisticas) 
			System.out.println("Temporada: " + estadistica.getTemporada() 
			+ " | Puntos partido: " + estadistica.getPuntos_por_partido()
			+ " | Asistencias partido: " + estadistica.getAsistencias_por_partido() 
			+ " | Tapones partido: " + estadistica.getTapones_por_partido()
			+ " | Rebotes partido: " + estadistica.getRebotes_por_partido());
	}
}
