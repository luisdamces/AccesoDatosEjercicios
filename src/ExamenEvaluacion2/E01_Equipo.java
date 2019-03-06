package ExamenEvaluacion2;

public class E01_Equipo {

	private String nombre;
	private int ligas;
	private int copas;
	private int fundacion;
	private int enPrimera;
	
	public E01_Equipo(String nombre, int ligas, int copas, int fundacion, int enPrimera) {
		super();
		this.nombre = nombre;
		this.ligas = ligas;
		this.copas = copas;
		this.fundacion = fundacion;
		this.enPrimera = enPrimera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLigas() {
		return ligas;
	}

	public void setLigas(int ligas) {
		this.ligas = ligas;
	}

	public int getCopas() {
		return copas;
	}

	public void setCopas(int copas) {
		this.copas = copas;
	}

	public int getFundacion() {
		return fundacion;
	}

	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}

	public int getEnPrimera() {
		return enPrimera;
	}

	public void setEnPrimera(int enPrimera) {
		this.enPrimera = enPrimera;
	}
	
	
	
}
