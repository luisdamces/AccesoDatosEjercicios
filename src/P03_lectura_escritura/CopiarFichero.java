package P03_lectura_escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarFichero {

	public static void main(String[] args) throws IOException{

		File f1 = new File("src\\P03_lectura_escritura\\f1.txt");
			f1.createNewFile();
		File f2 = new File("src\\P03_lectura_escritura\\f2.txt");
			f2.createNewFile();
		
		String texto = "";
		
		//LEER EL PRIMER FICHERO
		
		texto = leerFichero(f1);
		
		//ESCRIBIR EL TEXTO EN EL SEGUNDO
		
		escribirFichero(texto, f2);
		
	}
	
	public static String leerFichero(File f) throws IOException
	{
		String texto = "";
		
		int i = 0;
		
		//
		
		FileReader fr = new FileReader(f);
		
		while((i=fr.read())!=-1)//while para leer el fichero
		{
				texto = texto + (char)i;
		}
		
		fr.close();
		
		return texto;
	}

	public static void escribirFichero(String t, File f) throws IOException
	{
		char caracteres[];
		
		//
		
		FileWriter fw = new FileWriter(f);
		
		caracteres = t.toCharArray();
		
		for(int x = 0; x < caracteres.length; x++)
		{
			fw.write(caracteres[x]);
		}

		fw.close();
	}
}
