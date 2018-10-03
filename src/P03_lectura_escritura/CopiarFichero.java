package P03_lectura_escritura;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarFichero {

	public static void main(String[] args) throws IOException{

		File f1 = new File("src\\P03_lectura_escritura\\f1.txt");
			f1.createNewFile();
		File f2 = new File("src\\P03_lectura_escritura\\f2.txt");
			f2.createNewFile();
			
		int i = 0;
		
		String texto = "";
		
		char caracteres[];
		
		//LEER EL PRIMERO FICHERO
		
		FileReader fr = new FileReader(f1);
		
		while((i=fr.read())!=-1)//while para leer el fichero
		{
				texto = texto + (char)i;
		}
		
		fr.close();
		
		//ESCRIBIR EL TEXTO EN EL SEGUNDO
		
		FileWriter fw = new FileWriter(f2);
		
		caracteres = texto.toCharArray();
		
		for(int x = 0; x < caracteres.length; x++)
		{
			fw.write(caracteres[x]);
		}

		fw.close();
		
	}

}
