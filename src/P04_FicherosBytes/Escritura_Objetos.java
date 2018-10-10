package P04_FicherosBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escritura_Objetos {

	public static void main(String[] args) throws IOException {

		File f1 = new File("src\\P04_FicherosBytes\\personas.dat");
		f1.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(f1);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		
		String[] nombres = new String[5];
			nombres[0]="Pepe";
			nombres[1]="Juan";
			nombres[2]="Pedro";
			nombres[3]="Maria";
			nombres[4]="Carmen";
			
		int[] edades = new int[5];
			edades[0] = 20;
			edades[1] = 25;
			edades[2] = 40;
			edades[3] = 15;
			edades[4] = 20;
			
			
		for(int i = 0; i < 5; i++)
		{
			Persona p = new Persona(edades[i], nombres[i]);
			
			objectOut.writeObject(p);
		}
		
		objectOut.close();
	}

}
