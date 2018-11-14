package UD01_P03_lectura_escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirLinea {

	public static void main(String[] args) {

		try
		{
			File f = new File("src\\P03_lectura_escritura\\prueba_buffered_writer.txt");
			FileWriter fr = new FileWriter(f);
			BufferedWriter br = new BufferedWriter(fr);
			
			int nLineas = 10;
			
			for(int i = 1; i <= nLineas; i++)
			{
				br.write("Fila n�mero: " + i);
				br.newLine();
			}
			
			br.close();
		}
		catch (FileNotFoundException fn)
		{
			System.out.println("El fichero no se encuentra");
		}
		catch (IOException io)
		{
			System.out.println("Error de E/S");
		}
		
		

	}

}
