package P04_FicherosBytes;

import java.io.Serializable;

public class Cancion implements Serializable{
	
	private int id;
	private int ano;
	private String titulo;
	private String artista;
	private String duracion;
	private boolean cancion_espanola;
	
	Cancion(int vid, int vano, String vtitulo, String vartista, String vduracion, boolean vcancion_espanola)
	{
		id = vid;
		ano = vano;
		titulo = vtitulo;
		artista = vartista;
		duracion = vduracion;
		cancion_espanola = vcancion_espanola;
	}
	
	//GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public boolean isCancion_espanola() {
		return cancion_espanola;
	}

	public void setCancion_espanola(boolean cancion_espanola) {
		this.cancion_espanola = cancion_espanola;
	}
	

}
