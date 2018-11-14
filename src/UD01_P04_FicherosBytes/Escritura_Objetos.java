package UD01_P04_FicherosBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Escritura_Objetos {
	
	static Scanner teclado;

	public static void main(String[] args) throws IOException {
		
		teclado = new Scanner(System.in);

		File f1 = new File("src\\P04_FicherosBytes\\personas.dat");
		f1.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(f1);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		
		String[] nombres = new String[5];
		int[] edades = new int[5];

				
			for(int i = 0; i < 5; i++)
			{
				System.out.println("Introduce el nombre n� " + (i+1));
				
				nombres[i] = teclado.nextLine();
				
				System.out.println("Introduce su edad");
				
				edades[i] = teclado.nextInt();
					teclado.nextLine();
			}
			
			
		for(int i = 0; i < 5; i++)
		{
			Persona p = new Persona(edades[i], nombres[i]);
			
			objectOut.writeObject(p);
		}
		
		objectOut.close();
	}

}
