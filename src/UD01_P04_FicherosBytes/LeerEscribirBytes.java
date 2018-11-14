package UD01_P04_FicherosBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerEscribirBytes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//leer y escribir bytes
		
		File f1 = new File("src\\P04_FicherosBytes\\datos.dat");
		f1.createNewFile();
		
		int i;
		FileOutputStream fileout = new FileOutputStream(f1);
		FileInputStream filein = new FileInputStream(f1);
		
		for(i=0;i<100;i++) {
			fileout.write(i);
		}
		fileout.close();
		
		while((i=filein.read())!=-1){
			System.out.println(i);
		}
		
		filein.close();

	}

}
