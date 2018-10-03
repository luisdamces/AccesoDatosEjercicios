package P03_lectura_escritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import javax.swing.text.AbstractDocument.BranchElement;

public class LeerLinea {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(new File("src\\P03_lectura_escritura\\fichero_texto.txt"));
		
		BufferedReader buffer = new BufferedReader(fr); //con la clase bufferedreader se puede leer un fichero linea por linea
		
		String tmp;
		
			while((tmp = buffer.readLine())!=null) 
			{
				System.out.println(tmp);
			}

		buffer.close();
		
	}

}
