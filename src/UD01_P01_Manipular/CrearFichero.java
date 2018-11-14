package UD01_P01_Manipular;

import java.io.File;
import java.io.IOException;

public class CrearFichero {

	public static void main(String[] args)
	{
		
		try
		{
			File fichero = new File("C:\\Users\\ifc\\Desktop\\fichero.txt"); //prueba--
			
			if(fichero.exists())
			{
				System.out.println("El fichero ya existe.");
			}
			else
			{
				fichero.createNewFile();
			}
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
