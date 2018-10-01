package P03_lectura_escritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecturaEscritura {

	public static void main(String[] args) throws IOException{

		String ruta = "src\\P03_lectura_escritura\\fichero.txt";
		File fichero = new File(ruta);
		int i; //nº caracter actual
		
		FileReader leer = new FileReader(fichero);
			
		
		while((i=leer.read())!=-1)
		{
				System.out.print((char)i);
		}
		
		
	}

}
