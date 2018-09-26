package P02_Metodos;

import java.io.FileWriter;
import java.io.IOException;


public class Metodos {
	
	public static void main(String[] args) {
		
		//Comentario1
		
		try
		{
			FileWriter fichero = new FileWriter("src\\P02_Metodos\\fichero.txt");
			
			fichero.write("¿Qué es el Cipotegato?");
			
			fichero.close();
		}
		catch(IOException e)
		{
			
		}
	
		

	}

}
