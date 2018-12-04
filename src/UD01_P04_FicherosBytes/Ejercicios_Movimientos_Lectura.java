//clase que lee los movimientos bancarios de un fichero de datos, los muestra por pantalla y hace un calculo de la cantidad total

package UD01_P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicios_Movimientos_Lectura {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File fichero = new File("src\\UD01_P04_FicherosBytes\\ficheros\\movimientos.dat");
		
		FileInputStream fileIn = new FileInputStream(fichero);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		
		Movimiento_bancario mov;
		
		int cantidad_total = 0;
		int i = 0;
		
		try
		{
			
			while(true)
			{
				
				mov = (Movimiento_bancario)objectIn.readObject();
				
				System.out.println("Movimiento n� " + ++i + " - Fecha: " + mov.getFecha() + " - Concepto: " + mov.getConcepto()
				+ " - Cantidad: " + mov.getCantidad() + " - Tipo: " + mov.getTipo());
				
				
				if(mov.getTipo())
					cantidad_total += mov.getCantidad();
				
				else
					cantidad_total -= mov.getCantidad();
				
			}
		}
		catch(EOFException e)
		{
			System.out.println("Ya no hay m�s movimientos");
		}
		
		objectIn.close();
		
		System.out.println("La cantidad total de saldo es " + cantidad_total);
	}

}
