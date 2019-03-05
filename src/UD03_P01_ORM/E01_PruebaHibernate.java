package UD03_P01_ORM;

//importamos el modelo-entidad de la tabla departamentos
//que hemos generado con Hibernate
import modelos.entidades.*;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;


//clase necesaria para el funcionamiento de hibernate
import modelo.HibernateUtils;
//

public class E01_PruebaHibernate {
	
	public static void main (String[] args) {
		//generamos el objeto SessionFactory a partir de la clase HibernateUtilss
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//abrimos la sesión
		Session session = sessionFactory.openSession();
		//genera conexion entre aplicacion y base de datos
		Transaction tr = session.beginTransaction();
		
		Jugadores jugador = new Jugadores(616, null, "Alex", "Novallas", "7-2", 300, "C");
		
		//insertar jugador
		//session.save(jugador);
		
		//borrar jugador
		//session.delete(jugador);
		
		//actualizar jugador
		//jugador.setPeso(250);
		//session.update(jugador);
		
		tr.commit();
		
		//obtener datos de un jugador
		Jugadores jugador2 = (Jugadores) session.get(Jugadores.class, 614);
		System.out.println("C�digo: " + jugador2.getCodigo() + " - Nombre: " + jugador2.getNombre());
		
		sessionFactory.close();
	}
}
