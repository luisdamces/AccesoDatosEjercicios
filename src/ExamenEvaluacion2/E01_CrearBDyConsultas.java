package ExamenEvaluacion2;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.omg.CORBA.PUBLIC_MEMBER;

import UD04_P02_BDOO.E01_Jugadores;

public class E01_CrearBDyConsultas {
	
	static ODB odb;

	public static void main(String[] args) {
		//creo la conexion
		odb = ODBFactory.open("src\\ExamenEvaluacion2\\ficheros\\futbol.db");
		
		// Creo los equipos
		E01_Equipo e1= new E01_Equipo ("Recreativo de Huelva", 0, 0, 1889, 5);
		E01_Equipo e2= new E01_Equipo ("Athletic Club", 8, 23, 1898, 83);
		E01_Equipo e3= new E01_Equipo ("Barcelona", 22, 26, 1899, 83);
		E01_Equipo e4= new E01_Equipo ("Espanyol", 0, 4, 1900, 79);
		E01_Equipo e5= new E01_Equipo ("Real Madrid", 32, 18, 1902, 83);
		
		// Inserto los objetos
		/*odb.store(e1);
		odb.store(e2);
		odb.store(e3);
		odb.store(e4);
		odb.store(e5);*/
		
		equipoMasAntiguoGanador();
		equipoMenosTempsPrimera();
	
		odb.close();	
	}
	
	public static void equipoMasAntiguoGanador() {
		ICriterion criterio = new And().add(Where.gt("ligas", 0));
		
		IQuery query = new CriteriaQuery(E01_Equipo.class, criterio);
		query.orderByAsc("fundacion");
		
		Objects<E01_Equipo> objects = odb.getObjects(query);
		
		while(objects.hasNext()){
			E01_Equipo equipo = objects.next();
		     
			System.out.println("---------------------------------------------");
			System.out.println("Equipo mas antiguo que ha ganado alguna liga:");
		    System.out.println("Nombre equipo: "+equipo.getNombre()
		    	+ " | Ligas: " + equipo.getLigas() + " | Copas: " + equipo.getCopas()
		    	+ " | Fundacion: " + equipo.getFundacion() 
		    	+ " | En primera: " + equipo.getEnPrimera());
		    System.out.println("---------------------------------------------");
		    break;
		}
	}
	
	public static void equipoMenosTempsPrimera() {
		IQuery query = new CriteriaQuery(E01_Equipo.class);
		query.orderByAsc("enPrimera");
		
		Objects<E01_Equipo> objects = odb.getObjects(query);
		
		while(objects.hasNext()){
			E01_Equipo equipo = objects.next();
		    
			System.out.println("Equipo mas antiguo que ha ganado alguna liga:");
		    System.out.println("Nombre equipo: "+equipo.getNombre()
		    	+ " | Ligas: " + equipo.getLigas() + " | Copas: " + equipo.getCopas()
		    	+ " | Fundacion: " + equipo.getFundacion() 
		    	+ " | En primera: " + equipo.getEnPrimera());
		    System.out.println("---------------------------------------------");
		    break;
		}
	}
}
