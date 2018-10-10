package Utilidades;

import java.util.Scanner;

public class Ejemplo_Scanner {
	
	static Scanner teclado;

	public static void main(String[] args) {
		
		int a;
		int b;

		teclado = new Scanner(System.in); // creamos este objeto para poder introducir informacion por teclado
		
		System.out.println("Introduce dos numeros: ");
		
			a = teclado.nextInt();
		
			b = teclado.nextInt();
			
		System.out.println("El resultado de la suma de los dos números es " + (a+b));

	}

}
