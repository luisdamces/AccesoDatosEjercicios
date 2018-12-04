/*
int -> 4B
Double -> 8B
char -> 2B
String -> 2B(char) * n�mero de characters que haya*/

package UD01_P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.RandomAccessFile;

public class Lectura_fichero_aleatorio {

	public static void main(String[] args) throws IOException {


		File f = new File("src\\UD01_P04_FicherosBytes\\ficheros\\escritura_fichero_aleatorio.dat");
		RandomAccessFile raf = new RandomAccessFile (f, "r");//r->Modo lectura	
		
		int posicion = 0;
		
		int id;
		
		char[] apellidos = new char [10];
		char aux;
		String apellido;
		
		int dpto;
		
		double salario;
		
		try {
			
			do {
				
				//raf.seek(posicion);//Nos situamos en un lugar determinado del fichero para empezar a leer desde all�
				id=raf.readInt();				
				
				for(int i = 0; i < apellidos.length; i++) {
					
					aux = raf.readChar();
					apellidos[i]=aux;
					
				}
				
				apellido = new String(apellidos);
				
				dpto = raf.readInt();
				salario = raf.readDouble();
				
				System.out.println("Id: "+id+" Apellidos: "+apellido+" Departamento: "+dpto+" Salario: "+salario);
				
				//posicion += 36;
				/*36 porque ocupan todos los elementos 36B
				2 int = 8B
				1 Double = 8B
				1 String = 2B * 10 = 20B
				Total = 36B*/
						
			}while(raf.getFilePointer()!=raf.length());
			/*.getFilePointer nos dice hacia donde est� apuntando el puntero
			.length dice el total de bytes que ocupa la informacion escrita en el fichero*/
			
			raf.close();
			
		}
		catch (EOFException e) 
		{
			System.out.printf("Se ha llegado al final del fichero");
		}	
	}
}