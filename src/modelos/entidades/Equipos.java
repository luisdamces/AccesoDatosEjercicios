package modelos.entidades;
// Generated 17-dic-2018 17:31:44 by Hibernate Tools 5.3.6.Final

import javax.persistence.*;

@Entity
@Table(name="equipos")
public class Equipos implements java.io.Serializable {

	@Id
    @Column(name="nombre")
	private String nombre;

	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="conferencia")
	private String conferencia;
	
	@Column(name="division")
	private String division;
	
	// Las relaciones también se mapean

	public Equipos() {
	}

	public Equipos(String nombre) {
		this.nombre = nombre;
	}

	public Equipos(String nombre, String ciudad, String conferencia, String division) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.conferencia = conferencia;
		this.division = division;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getConferencia() {
		return conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
}
