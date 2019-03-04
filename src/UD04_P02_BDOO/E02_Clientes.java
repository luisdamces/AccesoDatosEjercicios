package UD04_P02_BDOO;

public class E02_Clientes {

	 private int numcli ;
	 private String nombre;
     private String pobla;
     
     
     public E02_Clientes(){}
     
	public E02_Clientes(int numcli, String nombre, String pobla) {
		super();
		this.numcli = numcli;
		this.nombre = nombre;
		this.pobla = pobla;
	}
	public int getNumcli() {
		return numcli;
	}
	public void setNumcli(int numcli) {
		this.numcli = numcli;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPobla() {
		return pobla;
	}
	public void setPobla(String pobla) {
		this.pobla = pobla;
	}

        
}
