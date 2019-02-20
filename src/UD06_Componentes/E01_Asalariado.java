package UD06_Componentes;

import java.awt.print.Printable;
import java.beans.*;
import java.io.Serializable;
import java.util.*;

public class E01_Asalariado implements Serializable{

       // Propiedades
       private PropertyChangeSupport propertySupport;
       private VetoableChangeSupport vetoableSupport;
       private int sueldo;
       private int horasExtra;

	   //Constructor
       public E01_Asalariado(){
             propertySupport = new PropertyChangeSupport(this);
             vetoableSupport = new VetoableChangeSupport(this);
             sueldo = 20;
             horasExtra = 0;
       }
      
       // Métodos
       public void addPropertyChangeListener(PropertyChangeListener listener){
             propertySupport.addPropertyChangeListener(listener);
       }
      
       public void removePropertyChangeListener(PropertyChangeListener listener){
             propertySupport.removePropertyChangeListener(listener);
       }
       
       public void addVetoableChangeListener(VetoableChangeListener listener){
    	   vetoableSupport.addVetoableChangeListener(listener);
     }
    
     public void removeVetoableChangeListener(VetoableChangeListener listener){
    	 vetoableSupport.addVetoableChangeListener(listener);
     }
       
       //////////
       public void setSueldo(int nuevoSueldo){
             int anteSueldo = sueldo;
             sueldo = nuevoSueldo;
             if (anteSueldo != nuevoSueldo){
                    propertySupport.firePropertyChange("sueldo", anteSueldo, sueldo);
             }
       }
      
       public int getSalario(){
             return sueldo;
       }
       
       public int getHorasExtra() {
   			return horasExtra;
   	   }

   		public void setHorasExtra(int horasExtraNuevo) {
   			int horasAnterior = horasExtra;
        	try {
               vetoableSupport.fireVetoableChange("horasExtra", horasAnterior, horasExtraNuevo);
               horasExtra = horasExtraNuevo;
        	}catch(PropertyVetoException e) {
        		System.out.println(e);
        	}
   		}
}
