package UD01_P03_lectura_escritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

	public static void main(String[] args) throws IOException{

		String ruta = "src\\P03_lectura_escritura\\fichero.txt";
		File fichero = new File(ruta);
		int i; //n� caracter actual
		
		FileReader leer = new FileReader(fichero);//flujo de entrada al fichero
			
		
		while((i=leer.read())!=-1)//while para leer el fichero
		{
				System.out.print((char)i);
		}
		
		leer.close();
		
		System.out.println();
		
		//ahora con array de tipo caracter
		
		leer = new FileReader(fichero);
		
		char b[] = new char[50]; //segun el tama�o del array ir� leyendo en grupos
		
		i = 0;
		
		while((i=leer.read(b))!=-1)
		{
			System.out.println(b);
		}
		
		leer.close();//cerrar fichero
		
		
	}

}
