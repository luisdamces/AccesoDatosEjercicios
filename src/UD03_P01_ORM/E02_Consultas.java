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

public class E02_Consultas {
	
	static Scanner teclado;
	
	public static void main (String[] args) {
		
		teclado = new Scanner(System.in);
		String clave = "";
		
		//generamos el objeto SessionFactory a partir de la clase HibernateUtilss
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//abrimos la sesión
		Session session = sessionFactory.openSession();
		
		///////////
		//pedir por teclado un nombre de equipo
		System.out.println("---------------------------------");
		System.out.println("Introduce el nombre de un equipo:");
		clave = teclado.nextLine();
		//obtener datos de un equipo con query
		Query query = session.createQuery("FROM Equipos where nombre = '" + clave + "'");
		List<Equipos> equipos = query.list();
		
		for (Equipos equipo : equipos) {
		System.out.println("Nombre: " + equipo.getNombre() + " - Ciudad: " + equipo.getCiudad() + 
				" - Conferencia: " + equipo.getConferencia() + " - Division: " + equipo.getDivision());
		}
		///////////
		
		//////////
		//pedir por teclado un nombre de equipo
		System.out.println("-------------------------------------------");
		System.out.println("Introduce el equipo para ver sus jugadores:");
		clave = teclado.nextLine();
		//obtener datos de jugadores que juegan en un equipo
		query = session.createQuery("FROM Jugadores where nombre_equipo = '" + clave + "'");
		List<Jugadores> jugadores = query.list();
				
		for (Jugadores jugador : jugadores) {
		System.out.println("Codigo: " + jugador.getCodigo() + " - Nombre: " + jugador.getNombre());
		}
		///////
		
		//////////
		//pedir por teclado un nombre de jugador
		System.out.println("----------------------------------");
		System.out.println("Introduce el nombre de un jugador:");
		clave = teclado.nextLine();
		//obtener datos de jugadores que juegan en un equipo
		query = session.createQuery("FROM Jugadores where nombre like '%" + clave + "%'");
		jugadores = query.list();
				
		for (Jugadores jugador : jugadores) {
		System.out.println("Codigo: " + jugador.getCodigo() + " - Nombre: " + jugador.getNombre() + 
				" - Procedencia: " + jugador.getProcedencia() + " - Altura: " + jugador.getAltura() + 
				" - Peso: " + jugador.getPeso() + " - Posicion: " + jugador.getPosicion() + 
				" - Nombre de equipo: " + jugador.getEquipos());
		}
		///////
		
		sessionFactory.close();
	}
}
