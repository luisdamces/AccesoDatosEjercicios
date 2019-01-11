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
		//obtener datos de un equipo con query
		Query query = session.createQuery("FROM Equipos where nombre = '" + clave + "'");
		List<Equipos> equipos = query.list();
		
		for (Equipos equipo : equipos) {
		System.out.println("Nombre: " + equipo.getNombre() + " - Ciudad: " + equipo.getCiudad() + 
				" - Conferencia: " + equipo.getConferencia() + " - Division: " + equipo.getDivision());
		}
		
		sessionFactory.close();
	}
}
