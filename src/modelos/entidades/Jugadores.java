package modelos.entidades;
// Generated 17-dic-2018 17:31:44 by Hibernate Tools 5.3.6.Final

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="jugadores")
public class Jugadores implements java.io.Serializable{

	//ATRIBUTOS
	@Id
    @Column(name="codigo")
	private int codigo;
	
	@Column(name="Nombre_equipo")
	private String nombre_equipo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Procedencia")
	private String procedencia;
	
	@Column(name="Altura")
	private String altura;
	
	@Column(name="Peso")
	private Integer peso;
	
	@Column(name="Posicion")
	private String posicion;


	//CONSTRUCTORES
	
	public Jugadores() {
	}

	public Jugadores(int codigo) {
		this.codigo = codigo;
	}

	public Jugadores(int codigo, String equipos, String nombre, String procedencia, String altura, Integer peso, String posicion) {
		this.codigo = codigo;
		this.nombre_equipo = equipos;
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
	}
	
	
	//GETTERS Y SETTERS
	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEquipos() {
		return this.nombre_equipo;
	}

	public void setEquipos(String equipos) {
		this.nombre_equipo = equipos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getAltura() {
		return this.altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Integer getPeso() {
		return this.peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}	
}