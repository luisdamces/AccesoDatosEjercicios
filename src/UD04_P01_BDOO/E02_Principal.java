package UD04_P01_BDOO;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class E02_Principal {
	
	static ODB odb;
	
	public static void main(String[] args) {
			odb = ODBFactory.open("src\\UD04_P01_BDOO\\ficheros\\ARTICULOS.DAT");
			//Consultas
			mostrarDatosVentas();
			mostrarDatosPorArticulo();
			mostrarDatosClientes();
			//
			odb.close();
	}
	
	public static void mostrarDatosVentas() {
		
		Objects<E02_Ventas> ventas = odb.getObjects(E02_Ventas.class);
		
		int i = 1;
		
		System.out.println("Datos de Ventas");
		
		while(ventas.hasNext()){
			E02_Ventas venta = ventas.next();
		     
		    System.out.println((i++) + " | Cod. venta: " + venta.getCodventa() + 
		    		" | Cod. art�culo: " + venta.getCodarti().getCodarti() + 
		    		" | Denominaci�n: " + venta.getCodarti().getDenom() + 
		    		" | Num. cliente: " + venta.getNumcli().getNumcli() +
		    		" | Nombre Cliente: " + venta.getNumcli().getNombre()+
		    		" | Fecha: " + venta.getFecha() + " | Unidades: " + venta.getUniven()+ 
		    	    " | Importe: " + (venta.getCodarti().getPvp()*venta.getUniven()));
		}
		System.out.println("--------------");
	}
	
	public static void mostrarDatosPorArticulo() {
		
		System.out.println("Datos de Ventas agrupados por artículo");
		
		Values valorUnidades = odb.getValues(new ValuesCriteriaQuery(E02_Ventas.class).
				sum("univen").groupBy("codarti"));
		Values valorImporte = odb.getValues(new ValuesCriteriaQuery(E02_Ventas.class).
				count("codventas").groupBy("codarti"));
		
		while(valorUnidades.hasNext()) {
			
			ObjectValues ov = valorUnidades.nextValues();
			ObjectValues ov2 = valorImporte.nextValues();
			
			System.out.println("Nº de uds. vendidas: " + ov.getByIndex(0) + 
					" | Nº de ventas: " + ov2.getByIndex(0));
			
		}
		System.out.println("--------------");
	}
	
	public static void mostrarDatosClientes() {
		System.out.println("Datos de Clientes");
	
		Objects<E02_Clientes> clientes = odb.getObjects(E02_Clientes.class);
		
		int i = 0;
		while(clientes.hasNext()) {
			E02_Clientes cliente = clientes.next();
			
			System.out.println("Nº cliente: " + cliente.getNumcli() + 
					" | Nombre: " + cliente.getNombre() + 
					" | Población: " + cliente.getPobla());
			
			i++;
		}
		System.out.println("--------------");
	}

} // fin clase
