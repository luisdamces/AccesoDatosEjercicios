package UD04_P01_BDOO;

import java.io.File;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class E01_Main {

	public static void main(String[] args) {
		//creo la conexion
		ODB odb = ODBFactory.open("src\\UD04_P01_BDOO\\data\\Equipos.db");
		
		// Creo los paises
		E01_Paises pais1 = new E01_Paises(1, "Espana");
		E01_Paises pais2 = new E01_Paises(2, "Mexico");
		// Creo los equipos
		E01_Jugadores j1= new E01_Jugadores ("María", "voleibol", "Madrid", 14, pais1);
		E01_Jugadores j2= new E01_Jugadores ("Miguel", "tenis", "Madrid", 15, pais1);
		E01_Jugadores j3= new E01_Jugadores ("Mario", "baloncesto", "Guadalajara", 15, pais2);
		E01_Jugadores j4= new E01_Jugadores ("Alicia", "tenis", "Madrid", 14, pais1);
		
		// Inserto los objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		odb.store(pais1);
		odb.store(pais2);
		
		// sacar los datos de todos los jugadores
		Objects<E01_Jugadores> objects = odb.getObjects(E01_Jugadores.class);
		int i = 1;
		
		System.out.println(objects.size() + " jugadores:");

		while(objects.hasNext()){
			E01_Jugadores jug= objects.next();
		     
		    System.out.println((i++) + "\t: " + jug.getNombre() + "*" + 
		    jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		}
		System.out.println("------------");
		
		///////CONSULTA 1//////////
		
		IQuery query = new CriteriaQuery(E01_Jugadores.class, Where.equal("deporte", "tenis"));
		query.orderByDesc("edad");
		i = 1;
		
		Objects<E01_Jugadores> objects1 = odb.getObjects(query);
		
		System.out.println("Jugadores que juegan al tenis: ");
		
		while(objects1.hasNext()){
			E01_Jugadores jug = objects1.next();
		     
		    System.out.println((i++) + "\t: " + jug.getNombre() + "*" + 
		    jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		}
		System.out.println("------------");
		
		//////CONSULTA 2 CON criterio///////
		
		ICriterion criterio2 = new And().add(Where.equal("ciudad", "Madrid")).
				add(Where.ge("edad",15));
		
		query = new CriteriaQuery(E01_Jugadores.class, criterio2);
		
		Objects<E01_Jugadores> objects2 = odb.getObjects(query);
		
		mostrarDatos(objects2, "Jugadores que son de Madrid y tienen 5 años");
		
		//////CONSULTA 3 CON jugadores y paises///////
		
		odb.close();
		//borrar el fichero al final para que no se acumulen datos
		File f = new File("src\\UD04_P01_BDOO\\data\\neodatis.test");
		f.delete();
	}
	
	public static void mostrarDatos(Objects<E01_Jugadores> objects, String mensaje) {
		System.out.println(mensaje);
		int i = 1;
		while(objects.hasNext()){
			E01_Jugadores jug = objects.next();
		     
		    System.out.println((i++) + "\t: " + jug.getNombre() + "*" + 
		    jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		}
		System.out.println("------------");
	}
}
