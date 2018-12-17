package UD03_P01_ORM;

//importamos el modelo-entidad de la tabla departamentos
//que hemos generado con Hibernate
import modelos.entidades.*;
import org.hibernate.*;

//clase necesaria para el funcionamiento de hibernate
import modelo.HibernateUtils;
//

public class E01_PruebaHibernate {
	
	public static void main (String[] args) {
		//generamos el objeto SessionFactory a partir de la clase HibernateUtils
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//abrimos la sesión
		Session sesion = sessionFactory.openSession();
		//genera conexion entre aplicacion y base de datos
		Transaction tr = sesion.beginTransaction();
		
		Jugadores jugador = new Jugadores();
		jugador.setNombre("Oscar Tutor");
		sesion.save(jugador);
		tr.commit();
		sessionFactory.close();
	}
}
