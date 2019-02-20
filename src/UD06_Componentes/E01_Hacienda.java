package UD06_Componentes;

import java.beans.*;
import java.io.Serializable;
import java.util.*;

public class E01_Hacienda implements Serializable, PropertyChangeListener, VetoableChangeListener{
      
       // Constructor
       public E01_Hacienda(){}
      
       // Métodos listeners
       public void propertyChange(PropertyChangeEvent evt){
    	   if(evt.getPropertyName().equals("sueldo")) {
             System.out.println("Hacienda: nuevo sueldo " + evt.getNewValue());
             System.out.println("Hacienda: sueldo anterior " + evt.getOldValue());
    	   }
       }

		public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
			if((Integer) evt.getNewValue() > 12) {
				System.out.println("No se pueden establecer más de 12 horas extra, tu has puesto "+evt.getNewValue());
				throw new PropertyVetoException(null, null);
			}
			else {
				System.out.println("Hacienda: nuevas horas extra " + evt.getNewValue());
		        System.out.println("Hacienda: horas extra anteriores " + evt.getOldValue());
			}
		}
}