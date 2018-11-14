/* Este programa crea un fichero de tipo binario, escribe en �l los nombres y edades de 10 personas,
 * y despu�s los lee y los env�a a la salida est�ndar
 * */

package UD01_P04_FicherosBytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EdadesByte {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("src\\P04_FicherosBytes\\edades.dat");
		f.createNewFile();
		
		FileOutputStream fileout = new FileOutputStream(f);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		
		String[] nombres = new String[10];
		nombres[0]="Pepe";
		nombres[1]="Juan";
		nombres[2]="Jorge";
		nombres[3]="Luis";
		nombres[4]="Fran";
		nombres[5]="Pedro";
		nombres[6]="Javier";
		nombres[7]="Ana";
		nombres[8]="Lucia";
		nombres[9]="Bea";

		int[] edades = new int[10];
		edades[0]=19;
		edades[1]=18;
		edades[2]=17;
		edades[3]=21;
		edades[4]=22;
		edades[5]=25;
		edades[6]=26;
		edades[7]=15;
		edades[8]=19;
		edades[9]=17;
		
		int i;
		
		for(i=0;i<10;i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);
		}
		
		dataOS.close();

		
		FileInputStream filein = new FileInputStream(f);
		DataInputStream dataIS = new DataInputStream(filein);
		
		String n;
		int e;
		
		try {
			while(true) {
				for(i=0;i<10;i++) {
				n=dataIS.readUTF();
				e=dataIS.readInt();
				System.out.println("Persona"+(i+1)+" Nombre: "+n+" Edad: "+e);
				}
				
			}
			
		}catch(EOFException eo) {
			System.out.println("Error");
		}
		
		
		

	}

}
