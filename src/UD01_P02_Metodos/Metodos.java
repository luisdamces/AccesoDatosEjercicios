package UD01_P02_Metodos;

import java.io.File;
import java.io.IOException;


public class Metodos {
	
	public static void main(String[] args){
		
	String ruta = "src\\UD01_P02_Metodos\\fichero_prueba.txt";
	
	File fichero = new File(ruta);	
	
	if(fichero.exists())
	{
		//mostrar nombre del fichero
		System.out.println("El nombre del fichero es '" + fichero.getName()+"'");
		
		//sacar la ruta del fichero
		System.out.println("La ruta absoluta del fichero es '" + fichero.getAbsolutePath() + "'");
		
		//sacar la ruta del fichero
		System.out.println("La ruta relativa del fichero es '" + fichero.getPath() + "'");
		
		//comprobar si existe
		System.out.println("El fichero existe?: " + fichero.exists());
		
		//comprobar si es archivo
		System.out.println("Es fichero?: " + fichero.isFile());
		
		//comprobar si es carpeta
		System.out.println("Es carpeta?: " + fichero.isDirectory());
		
		//ver tama�o del fichero
		System.out.println("El fichero ocupa " + fichero.length() + " bytes");
		
		//ver directorio padre
		System.out.println("El fichero se encuentra en el directorio padre '" + fichero.getParent() + "'");
		
		
		//-----mostrar nombre de los ficheros y directorios dentro de una carpeta-----
		String dir = "src\\UD01_P02_Metodos";
		File f = new File(dir);
		String[] listaNombres = f.list();
		File[] listaFicheros = f.listFiles();
		
		//---a�adir al final si el archivo es un fichero o una carpeta
		
		System.out.println("\r\nLos archivos que hay en el directorio '" + dir +"' son los siguientes:");
		
		for(int i = 0; i< listaNombres.length; i++)
		{
			System.out.print("Nombre: '" + listaNombres[i] + "' - ");
			
			File ruta_fichero = new File(f, listaNombres[i]);
			
			System.out.print("Es fichero?: " + ruta_fichero.isFile() + " - ");
			
			System.out.println("Es carpeta?: " + ruta_fichero.isDirectory());
		}
		
		
		
		//----ahora haremos lo mismo pero usando el metodo listFiles
		
		System.out.println("\r\nLos archivos que hay en el directorio '" + dir +"' son los siguientes:");
		
		for(int i = 0; i< listaFicheros.length; i++)
		{
			System.out.print("Nombre: '" + listaFicheros[i].getName() + "' - ");
			
			System.out.print("Es fichero?: " + listaFicheros[i].isFile() + " - ");
			
			System.out.println("Es carpeta?: " + listaFicheros[i].isDirectory());
		}
		
		
		
		//---crear directorio y a�adir dentro cuatro ficheros
		
		File directorio = new File("src\\UD01_P02_Metodos\\TBBT");
		
		if(directorio.mkdir())//si el directorio ya existe no crea otro carpeta ni la sobreescribe
		{
			System.out.print("\r\nLa carpeta se ha creado");
			
			File personajes = new File(directorio, "sheldon.txt");
			File personajep = new File(directorio, "penny.txt");
			File personajel = new File(directorio, "leonard.txt");
			File personajeh = new File(directorio, "howard.txt");	
				
			try
			{
				if(personajes.createNewFile() && personajep.createNewFile() && personajel.createNewFile() && personajeh.createNewFile())
				{
					System.out.println(" y los ficheros tambi�n");
				}
				else
				{
					System.out.println(" pero los ficheros no");
				}	
			}
			catch(IOException e)
			{}
			
			
			
			//cambiar el nombre de un fichero
			
			personajeh.renameTo(new File(directorio, "bernadet.txt"));
			
			//borrar un fichero
			
			if(personajes.delete())
			{
				System.out.println("\r\nEl fichero se ha eliminado.");
			}
			else
			{
				System.out.println("\r\nHa habido un problema y el fichero no se ha eliminado.");
			}
			
			
			
		}
		else
		{
			System.out.println("\r\nLa carpeta no se ha creado");
		}
		
	}
	else
	{
		System.out.println("La ruta del fichero es incorrecta.");
	}

		

	}

}
