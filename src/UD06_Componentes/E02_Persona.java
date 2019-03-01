package UD06_Componentes;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * Bean con los atributos correspondientes a los campos de la tabla de base
 * de datos.
 * @author chuidiang
 */
public class E02_Persona {
	
	int id;
	String nombre;
	Date fechaNacimiento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/** Para poder escribir el bean en pantalla de forma r�pida */
	public String toString()
	{
		return ""+id+" "+nombre+" "+formateador.format(fechaNacimiento);
	}
	
	/** Para escribir las fechas en un formato m�s mejor */
	private static SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
}