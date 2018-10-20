package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Insertar_final_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		
		File f = new File("src\\P04_FicherosBytes\\ficheros\\escritura_fichero_aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile (f, "rw");
		
		int id = 11;
		String apellido = "Garc�a";
		int dpto = 12;
		double salario = 1000;
		
		long posicion = raf.length();		
		raf.seek(posicion);
		
		raf.writeInt(id);//n�mero de empleado
		
		StringBuffer sb = null;
		sb= new StringBuffer(apellido);
		sb.setLength(10);
		raf.writeChars(sb.toString());
		
		raf.writeInt(dpto);
		raf.writeDouble(salario);	
		
		raf.close();
	}
}