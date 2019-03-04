package UD04_P02_BDOO;

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
			estadisticas();
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
		    		" | Cod. articulo: " + venta.getCodarti().getCodarti() + 
		    		" | Denominacion: " + venta.getCodarti().getDenom() + 
		    		" | Num. cliente: " + venta.getNumcli().getNumcli() +
		    		" | Nombre Cliente: " + venta.getNumcli().getNombre()+
		    		" | Fecha: " + venta.getFecha() + " | Unidades: " + venta.getUniven()+ 
		    	    " | Importe: " + (venta.getCodarti().getPvp()*venta.getUniven()));
		}
		System.out.println("--------------");
	}
	
	public static void mostrarDatosPorArticulo() {
		
		System.out.println("Datos de Ventas agrupados por ariculo");
		
		Values valorUnidades = odb.getValues(new ValuesCriteriaQuery(E02_Ventas.class).
				sum("univen").groupBy("codarti"));
		Values valorImporte = odb.getValues(new ValuesCriteriaQuery(E02_Ventas.class).
				count("codventas").groupBy("codarti"));
		
		while(valorUnidades.hasNext()) {
			
			ObjectValues ov = valorUnidades.nextValues();
			ObjectValues ov2 = valorImporte.nextValues();
			
			System.out.println("N. de uds. vendidas: " + ov.getByIndex(0) + 
					" | N.de ventas: " + ov2.getByIndex(0));
			
		}
		System.out.println("--------------");
	}
	
	public static void mostrarDatosClientes() {
		System.out.println("Datos de Clientes");
	
		Objects<E02_Clientes> clientes = odb.getObjects(E02_Clientes.class);
	
		while(clientes.hasNext()) {
			E02_Clientes cliente = clientes.next();
			
			//comprobar cuantas ventas tiene el cliente
			Objects<E02_Ventas> ventas = odb.getObjects(E02_Ventas.class);
			
			int numeroCompras = 0;
			float importeTotal = 0;
			
			while(ventas.hasNext()) {
				E02_Ventas venta = ventas.next();
				if(venta.getNumcli().getNumcli()==cliente.getNumcli()) {
					numeroCompras++;
					importeTotal += venta.getUniven() * venta.getCodarti().getPvp();
				}
			}
			/////////////
			
			System.out.println("Nº: " + cliente.getNumcli() + 
					" | Nombre: " + cliente.getNombre() + 
					" | Poblacion: " + cliente.getPobla() +
					" | Importe: " + importeTotal +
					" | Nº Compras: " + numeroCompras);
		}
		System.out.println("--------------");
	}

	public static void estadisticas() {
		System.out.println("Estadisticas");
		
		Values mediaImporte = odb.getValues(new ValuesCriteriaQuery(E02_Ventas.class)
				.avg("codarti.pvp", "media")
				.groupBy("codarti"));
		
		while(mediaImporte.hasNext()) {
			ObjectValues oValues = mediaImporte.nextValues();
			System.out.println(oValues.getByAlias("media"));
		}
	}
	
} // fin clase