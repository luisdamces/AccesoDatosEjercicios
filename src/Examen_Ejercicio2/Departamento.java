package Examen_Ejercicio2;

/**
 * Clase Departamento con atributos de la base de datos
 * @author ifc
 *
 */
public class Departamento 
{
	private int idDepartamento;
	private String nombreDepartamento;
	private String localidad;

	/*
	 * Constructor de la clase Departamento
	 */
	public Departamento(int n, String nombre, String localidad)
	{
		idDepartamento = n;
		nombreDepartamento = nombre;
		this.localidad = localidad;
	}
	
	//Getters y Setters
	
	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
