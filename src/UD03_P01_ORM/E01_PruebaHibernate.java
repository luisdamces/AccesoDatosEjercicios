package UD03_P01_ORM;

//importamos el modelo-entidad de la tabla departamentos
//que hemos generado con Hibernate
import modelos.entidades.*;

import java.util.List;

import org.hibernate.*;


//clase necesaria para el funcionamiento de hibernate
import modelo.HibernateUtils;
//

public class E01_PruebaHibernate {
	
	public static void main (String[] args) {
		//generamos el objeto SessionFactory a partir de la clase HibernateUtilss
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//abrimos la sesi√≥n
		Session session = sessionFactory.openSession();
		//genera conexion entre aplicacion y base de datos
		Transaction tr = session.beginTransaction();
		
		//insertar jugador
		Jugadores jugador = new Jugadores(616, null, "Alex", "Novallas", "7-2", 300, "C");
		session.save(jugador);
		tr.commit();
		
		//obtener datos de un jugador
		Jugadores jugador2 = (Jugadores) session.get(Jugadores.class, 614);
		System.out.println("CÛdigo: " + jugador2.getCodigo() + " - Nombre: " + jugador2.getNombre());
		
		//obtener datos de un jugador con query
		Query query = session.createQuery("SELECT j FROM Jugadores j");
		List<Jugadores> jugadores = query.list();
		
		for (Jugadores jugador : jugadores) {
		System.out.println(jugador.toString());
		}
		
		sessionFactory.close();
	}
}
