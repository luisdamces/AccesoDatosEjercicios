package UD04_P01_BDOO;

import java.io.File;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class E02_CrearBD {

	public static void main(String[] args) {

		File fichero = new File("src\\UD04_P02_BDOO_MySQL_a_Neodatis\\ficheros\\ARTICULOS.DAT");
		if (fichero.delete())
			   System.out.println("BD Borrada");
		// creación de registros en la BD
		  ODB odb = ODBFactory.open("ARTICULOS.DAT"); 
		  
		// creo los artículos
		  E02_Articulos ar1 = new E02_Articulos(1,"Mesas", 30, (float)100.5);
		  E02_Articulos ar2 = new E02_Articulos(2,"Pupitres", 10, (float)150.7);
		  E02_Articulos ar3 = new E02_Articulos(6,"Cuadernos", 100, (float)4.5);
		  E02_Articulos ar4 = new E02_Articulos(8,"Tabletas", 10, (float)175.4);
		  E02_Articulos ar5 = new E02_Articulos(9,"Bolígrafos", 100, (float)3.5);
		  E02_Articulos ar6 = new E02_Articulos(10,"Lapiceros", 300, (float)2.5);
		  E02_Articulos ar7 = new E02_Articulos(14,"Sillas", 30, (float)120.5);
		  E02_Articulos ar8 = new E02_Articulos(16,"Portátil", 25, (float)400.5);
		
		  E02_Articulos ar11 = new E02_Articulos(17,"Espejo baño", 20, (float)100.5);
		  E02_Articulos ar21 = new E02_Articulos(18,"Reloj cocina", 10, (float)20.7);
		  E02_Articulos ar31 = new E02_Articulos(20,"Tarjetero", 50, (float)14.5);
		  E02_Articulos ar41 = new E02_Articulos(22,"Estuches", 110, (float)20.4);
		  E02_Articulos ar51 = new E02_Articulos(23,"Libro BD", 10, (float)23.5);
		  E02_Articulos ar61 = new E02_Articulos(24,"Tijeras", 30, (float)5.0);
		  E02_Articulos ar71 = new E02_Articulos(25,"Cubiertos", 130, (float)10.5);
		  E02_Articulos ar81 = new E02_Articulos(26,"Teclado", 25, (float)40.5);
				
		 
		  // Almacenamos artículos 16 artículos
		  odb.store(ar1); 
		  odb.store(ar2);
		  odb.store(ar3);
		  odb.store(ar4);
		  odb.store(ar5); 
		  odb.store(ar6);
		  odb.store(ar7);
		  odb.store(ar8);
		  odb.store(ar11); 
		  odb.store(ar21);
		  odb.store(ar31);
		  odb.store(ar41);
		  odb.store(ar51); 
		  odb.store(ar61);
		  odb.store(ar71);
		  odb.store(ar81);
		  
		  // Creo los Clientes 12 clientes, num, nom, pob
		  
		  E02_Clientes cli1 = new E02_Clientes(1,"Antonio Ruiz","Talavera");
		  E02_Clientes cli2 = new E02_Clientes(2,"La Alameda S.L.","Talavera");
		  E02_Clientes cli3 = new E02_Clientes(7,"Los molinos CB","Madrid");
		  E02_Clientes cli4 = new E02_Clientes(8,"Pedro Morán S.L.","Talavera");
		  E02_Clientes cli5 = new E02_Clientes(12,"Azulejos Martín S.L.","Talavera");
		  E02_Clientes cli6 = new E02_Clientes(15,"Bar Girasol","Oropesa");
		  E02_Clientes cli7 = new E02_Clientes(9,"Escuela Mayores","Talavera");
		  E02_Clientes cli8 = new E02_Clientes(17,"Galería Madrid S.L.","Madrid");
		  E02_Clientes cli9 = new E02_Clientes(19,"El corte Chino","Talavera");
		  E02_Clientes cli10 = new E02_Clientes(20,"UNICAS S.A.","Oropesa");
		  E02_Clientes cli11 = new E02_Clientes(21,"Deportivo SAS","Talavera");
		  E02_Clientes cli12 = new E02_Clientes(22,"Academia Padel","Madrid");
		  
		  odb.store(cli1);		 
		  odb.store(cli2);odb.store(cli3);odb.store(cli4);odb.store(cli5); 
		  odb.store(cli6);odb.store(cli7);odb.store(cli8);odb.store(cli9); 
		  odb.store(cli10);odb.store(cli11);odb.store(cli12);
		  
		  // crear unas ventas
		  
	
			E02_Ventas v1 = new E02_Ventas (1,ar1,cli1,5,"05/06/2014");
			E02_Ventas v2 = new E02_Ventas (2,ar1,cli2,4,"15/06/2014");
			E02_Ventas v3 = new E02_Ventas (3,ar1,cli6,3,"25/06/2014");
			
			E02_Ventas v4 = new E02_Ventas (4,ar2,cli6,5,"03/07/2014");
			E02_Ventas v5 = new E02_Ventas (5,ar2,cli7,4,"11/08/2014");
			
			E02_Ventas v6 = new E02_Ventas (6,ar3,cli1,3,"25/04/2014");
			
			odb.store(v1);
			odb.store(v2);
			odb.store(v3);
			odb.store(v4);
			odb.store(v5);
			odb.store(v6);
		  
		  odb.close();
          System.out.println("BASE DE DATOS CREADA");
	}
}
