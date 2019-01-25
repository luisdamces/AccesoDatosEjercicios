package UD04_P01_BDOO;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class E01_Main {

	public static void main(String[] args) {
		//creo la conexion
		ODB odb = ODBFactory.open("d:\\neodatis.test");
		
		// Creo los jugadores
		E01_Jugadores j1= new E01_Jugadores ("María", "voleibol", "Madrid", 14);
		E01_Jugadores j2= new E01_Jugadores ("Miguel", "tenis", "Madrid", 15);
		E01_Jugadores j3= new E01_Jugadores ("Mario", "baloncesto", "Guadalajara", 15);
		E01_Jugadores j4= new E01_Jugadores ("Alicia", "tenis", "Madrid", 14);
		
		// Inserto los objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		//se cierra la conexion
		odb.close();
	}
	
}
