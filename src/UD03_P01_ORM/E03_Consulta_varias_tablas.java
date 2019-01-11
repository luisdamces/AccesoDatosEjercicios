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
		Query query1 = session.createQuery("FROM Jugadores where codigo = '" + clave + "'");
		List<Jugadores> jugadores = query1.list();
		
		for (Jugadores jugador : jugadores) {	
		System.out.println("Nombre: " + jugador.getNombre() + " - Altura: " + jugador.getAltura() + 
				" - Posición: " + jugador.getPosicion() + " - Peso: " + jugador.getPeso() + 
				" - Equipo: " + jugador.getEquipos() + " - Ciudad del equipo: " );
		}
		
		sessionFactory.close();
	}
}
