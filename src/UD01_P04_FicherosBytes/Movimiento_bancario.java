//clase que contiene movimientos de una cuenta corriente

package UD01_P04_FicherosBytes;

import java.io.Serializable;

public class Movimiento_bancario implements Serializable{
	
	private String fecha;
	private String concepto;
	private int cantidad;
	private boolean tipo;
	
	Movimiento_bancario(String vfecha, String vconcepto, int vcantidad, boolean vtipo)
	{
		fecha = vfecha;
		concepto = vconcepto;
		cantidad = vcantidad;
		tipo = vtipo;
	}
	

	//GETTERS Y SETTERS
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	
}
