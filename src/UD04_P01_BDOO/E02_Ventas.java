package UD04_P01_BDOO;

public class E02_Ventas {

	private int codventa;
	private E02_Articulos codarti;
    private E02_Clientes numcli ;
	private int univen; 
	private String fecha;
	
	public E02_Ventas(){}
	
	public E02_Ventas(int codventa, E02_Articulos codarti, E02_Clientes numcli, int univen, String fecha) {
		super();
		this.codventa = codventa;
		this.codarti = codarti;
		this.numcli = numcli;
		this.univen = univen;
		this.fecha = fecha;
	}
	public int getCodventa() {
		return codventa;
	}
	public void setCodventa(int codventa) {
		this.codventa = codventa;
	}
	public E02_Articulos getCodarti() {
		return codarti;
	}
	public void setCodarti(E02_Articulos codarti) {
		this.codarti = codarti;
	}
	public E02_Clientes getNumcli() {
		return numcli;
	}
	public void setNumcli(E02_Clientes numcli) {
		this.numcli = numcli;
	}
	public int getUniven() {
		return univen;
	}
	public void setUniven(int univen) {
		this.univen = univen;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	} 

}
