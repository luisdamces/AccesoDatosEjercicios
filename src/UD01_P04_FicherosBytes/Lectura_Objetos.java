package UD01_P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Lectura_Objetos {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		File f1 = new File("src\\P04_FicherosBytes\\personas.dat");
		
		Persona p;
		
		FileInputStream fileIn = new FileInputStream(f1);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		
		try
		{
			
			while(true)
			{
				p = (Persona)objectIn.readObject();
				
				System.out.println("Nombre: " + p.getNombre() + " - Edad: " + p.getEdad());
				
			}
			
		}
		catch(EOFException e)
		{
			System.out.println("Ya no hay mas objetos");
		}
		

	}

}
