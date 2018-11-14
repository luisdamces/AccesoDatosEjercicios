/**
 * Clase que contiene una lista de canciones
 */

package P06_JAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//namespace es opcional
//@XmlRootElement(namespace = "ejemplo1.xml")
//@XmlRootElement(namespace = "")

//Esto significa que la clases "Libreria.java" es el elemento raiz
@XmlRootElement()

public class ListaCanciones {
	
	private ArrayList<Cancion> lista = new ArrayList<Cancion>();
	
	public ListaCanciones()
	{
		
	}
	
	public void setListaCanciones(ArrayList<Cancion> vlista)
	{
		lista = vlista;
	}
	
	//-Wrapper, envoltura alrededor la representación XML
    //Anotaciones para atributos que son colecciones
	//-Hay que poner estas anotaciones delante del metodo
	//que devuelve la coleccion
    //@XmlElementWrapper(name = "ListaCanciones") 
    @XmlElement(name = "Cancion")
	public List<Cancion> getListaCanciones()
	{
		return lista;
	}
	
	

}
