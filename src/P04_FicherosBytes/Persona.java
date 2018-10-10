package P04_FicherosBytes;

import java.io.Serializable;

public class Persona implements Serializable{

	private int edad;
	private String nombre;
	
	public Persona()
	{
		edad = 21;
		nombre="Óscar";
	}
	
	//getters-
	
	public String getNombre()
	{
		return "El nombre de la persona es " + nombre; 
	}
	
	public String getEdad()
	{
		return "La edad de la persona es " + edad; 
	}
	
	//setters-
	
	public void setEdad(int vedad)
	{
		edad = vedad;
	}
	
	public void setNombre(String vnombre)
	{
		nombre = vnombre;
	}
	
	
}
