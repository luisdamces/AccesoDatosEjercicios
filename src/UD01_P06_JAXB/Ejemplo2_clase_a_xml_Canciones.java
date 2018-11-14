package UD01_P06_JAXB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Ejemplo2_clase_a_xml_Canciones {
	
	private static final String ruta_xml = 
			"src\\P06_JAXB\\ficheros\\canciones_jabx.xml";
	
	public static void main(String args[]) throws JAXBException, FileNotFoundException
	{
		//Se crea la lista de libros
		ArrayList<Cancion> lista = new ArrayList<Cancion>();
		
		//Creamos dos libros y los añadimos
		Cancion c1 = new Cancion(1, 2013, "Flying Golem",
				"Wand", "3:30", false);
		lista.add(c1);
		
		Cancion c2 = new Cancion(2, 2014, "Gold on the ceiling",
				"Black Keys", "3:20", false);
		lista.add(c2);
		
		//se crea la lista de canciones y se le asigna la lista
		ListaCanciones listaCanciones = new ListaCanciones();
		listaCanciones.setListaCanciones(lista);
		
		//Creamos el contexto indicando la clase raiz
		JAXBContext context = JAXBContext.newInstance(ListaCanciones.class);
		
		//Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();
        
        //Formateamos el xml para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
        // Lo visualizamos con system out
        m.marshal(listaCanciones, System.out);
 
        // Escribimos en el archivo
        m.marshal(listaCanciones, new File(ruta_xml));
 
        // Visualizamos ahora los datos del documento XML creado
        System.out.println("------------ Leo el XML ---------");
        
        //Se crea Unmarshaller en el cotexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();
        
        //Utilizamos el método unmarshal, para obtener datos de un Reader
        ListaCanciones lista2 = (ListaCanciones) unmars.unmarshal(
        		new FileReader(ruta_xml));
	}

}
