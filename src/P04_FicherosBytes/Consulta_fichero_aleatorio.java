/*Lo que vamos a hacer es en vex de leer todos los empleados, solo queremos leer uno (consulta)*/

package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Consulta_fichero_aleatorio {
	
	static Scanner teclado;

	public static void main(String[] args) throws IOException{
		
		teclado = new Scanner(System.in);

		File f = new File("src\\P04_FicherosBytes\\ficheros\\escritura_fichero_aleatorio.dat");
		RandomAccessFile raf = new RandomAccessFile (f, "r");	
		
		int id;
		
		char[] letras = new char [10];
		char aux;
		String apellido;
		
		int dpto;
		
		double salario;
		
		System.out.println("Introduce el ID de empleado");
			id = teclado.nextInt();
			
		int posicion=(id-1)*36;//Restamos -1 porque tenemos que empezar a leer una posición antes
		
		raf.seek(posicion);//Nos situamos en un lugar determinado del fichero para empezar a leer desde allí
		id=raf.readInt();				
		
		for(int i = 0; i < letras.length; i++) 
		{
			aux=raf.readChar();
			letras[i]=aux;
		}
		
		apellido = new String(letras);
		
		dpto = raf.readInt();
		salario = raf.readDouble();
		
		System.out.println("Id: "+id+" Apellidos: "+apellido+" Departamento: "+dpto+" Salario: "+salario);
		
		raf.close();
	}
}