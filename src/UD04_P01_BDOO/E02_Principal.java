package UD04_P01_BDOO;

import java.sql.*;
import java.util.HashSet;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class E02_Principal {
	
	static ODB odb;
	
	public static void main(String[] args) {
			odb = ODBFactory.open("src\\UD04_P01_BDOO\\ficheros\\ARTICULOS.DAT");
			//Consultas
			mostrarDatosVentas();
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
		    		" | Cod. artículo: " + venta.getCodarti().getCodarti() + 
		    		" | Denominación: " + venta.getCodarti().getDenom() + 
		    		" | Num. cliente: " + venta.getNumcli().getNumcli() +
		    		" | Nombre Cliente: " + venta.getNumcli().getNombre()+
		    		" | Fecha: " + venta.getFecha() + " | Unidades: " + venta.getUniven()+ 
		    	    " | Importe: " + (venta.getCodarti().getPvp()*venta.getUniven()));
		}
		System.out.println("--------------");
	}

} // fin clase
