package P03_lectura_escritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Provincias {

	public static void main(String[] args) throws IOException{

		String ruta = "src\\P03_lectura_escritura\\provincias.txt"; //si el fichero ya tiene contenido, se borra todo lo que tenía escrito
		File fichero = new File(ruta);
		
		String provincias[] = new String[10];
			provincias[0]="Álava";
			provincias[1]="Albacete";
			provincias[2]="Alicante";
			provincias[3]="Almería";
			provincias[4]="Asturias";
			provincias[5]="Ávila";
			provincias[6]="Badajoz";
			provincias[7]="Barcelona";
			provincias[8]="Burgos";
			provincias[9]="Cáceres";
		
		FileWriter escribir = new FileWriter(fichero); 
		
		for(int i = 0; i < 10; i++)
		{
			escribir.write(provincias[i] + "\r\n");
		}

		escribir.close();
		
	}

}
