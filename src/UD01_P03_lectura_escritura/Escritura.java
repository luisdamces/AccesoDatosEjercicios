package UD01_P03_lectura_escritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

	public static void main(String[] args) throws IOException{

		String ruta = "src\\P03_lectura_escritura\\fichero.txt";
		File fichero = new File(ruta);
		
		FileWriter escribir = new FileWriter(fichero);
		
		String texto = "Tarazona Mo-La";
		
		char caracteres[] = texto.toCharArray(); // convertimos un texto a array de caracteres y lo pasamos a un array
		
			for(int i = 0; i < caracteres.length; i++)
			{
				escribir.write(caracteres[i]);
			}
		
		escribir.append("s"); //a�ade un caracter al final del fichero
			
		escribir.close();
		
		

	}

}
