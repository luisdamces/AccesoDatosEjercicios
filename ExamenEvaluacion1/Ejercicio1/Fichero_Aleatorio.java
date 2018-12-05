package Ejercicio1;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Fichero_Aleatorio {
	
	static Scanner teclado;
	static Double numero;
	static String ruta;
	static File f;
	static RandomAccessFile raf;
	
	static int opcion;

	public static void main(String[] args) throws IOException {
		
		teclado = new Scanner(System.in);
		
		while(opcion!=-1) {
		
			System.out.println("---------------MENU--------------");
			System.out.println("0 - Crear fichero ---------------");
			System.out.println("1 - Añadir numeros al principio -");
			System.out.println("2 - Añadir numeros al final -----");
			System.out.println("3 - Mostrar contenido del fichero");
			System.out.println("4 - Sustituir numeros -----------");
		
			opcion = teclado.nextInt();
		
			switch(opcion) {
				case 0:{
					String nombre = teclado.nextLine();
					crearFicheroAleatorio(nombre);
				}break;
			
				case 1:{
					anadirNumeroPrincipio();
				}break;
				
				case 2:{
					anadirNumerosFinal();
				}break;
				
				case 3:{
					mostrarNumeros();
				}break;
				
				case 4:{
					sustituirNumeros();
				}break;
			}
		}
		
		raf.close();
	}
	
	//metodo para crear fichero aleatorio y darle nombre
	public static void crearFicheroAleatorio(String nombre) throws FileNotFoundException {
		
		System.out.println("Introduce un nombre de fichero:");
		ruta = "ExamenEvaluacion1\\Ejercicio1\\"+teclado.nextLine()+".dat";
		//creamos el fichero
		f = new File(ruta);
		raf = new RandomAccessFile (f, "rw");
		//
	}

	//metodo para añadir numeros de tipo double al principio del fichero
	public static void anadirNumeroPrincipio() throws IOException {
		
		//introducir numeros al comienzo del fichero
		System.out.println("Introduce un numero(-1 para parar)");
			
		while((numero=teclado.nextDouble())!=-1) {
			raf.writeDouble(numero);
			System.out.println("Introduce un numero(-1 para parar)");
		}
	}

	//metodo para introducir numeros al final del fichero
	public static void anadirNumerosFinal() throws IOException {
	//introducir numeros al final del fichero
		System.out.println("Introduce un numero al final del fichero(-1 para parar)");
		
		while((numero=teclado.nextDouble())!=-1) {
			raf.seek(raf.length());
			raf.writeDouble(numero);
			System.out.println("Introduce un numero al final del fichero(-1 para parar)");
		}
	}

	//metodo para mostrar el contenido
	public static void mostrarNumeros() throws IOException {
		//mostrar los numeros que hay en el fichero
		raf.seek(0);
		System.out.println("---Numero que hay dentro del fichero:---");
		
		try {
			for(int i = 0; i < raf.length(); i++) {
				System.out.println(raf.readDouble());
			}
		}catch(EOFException e) {}
	}

	//metodo para sustitutir un numero por otro
	public static void sustituirNumeros() throws IOException {
	
		int posicion = 0;
		
		System.out.println("Introduce el numero que quieres sustituir");
		Double numero=teclado.nextDouble();
		
		System.out.println("Introduce un nuevo valor para ese número");
		Double numeroNuevo=teclado.nextDouble();
			
		try {
			raf.seek(posicion);			
			for(int i = 0; i < raf.length(); i++) {
				if(raf.readDouble()==numero) {
					raf.seek(posicion);
					raf.writeDouble(numeroNuevo);
				}	
				posicion+=8;
			}
		}catch(EOFException e) {}
	}
}
