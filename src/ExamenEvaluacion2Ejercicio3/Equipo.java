package ExamenEvaluacion2Ejercicio3;

public class Equipo {

	private int codigo;
	private String nombre;
	private int ligas;
	private int copas;
	private int fundacion;
	private int enPrimera;
	
	public Equipo(int codigo, String nombre, int ligas, int copas, int fundacion, int enPrimera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ligas = ligas;
		this.copas = copas;
		this.fundacion = fundacion;
		this.enPrimera = enPrimera;
	}

	public Equipo() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	@Override
	public String toString() {
		return nombre + " - " + ligas + " - " + copas + " - "
				+fundacion + " - " + enPrimera;
	}
	
}
