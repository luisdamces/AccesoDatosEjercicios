package UD06_Componentes;

import java.beans.PropertyVetoException;

public class E01_Principal{
       public static void main(String[] args) throws PropertyVetoException{
            
             E01_Hacienda funcionario1 = new E01_Hacienda();
             E01_Asalariado empleado = new E01_Asalariado();
             
             empleado.addPropertyChangeListener(funcionario1);
             empleado.addVetoableChangeListener(funcionario1);
             
             System.out.println("----------PROPIEDADES LIGADAS------------");
             empleado.setSueldo(50);
             
             System.out.println("----------PROPIEDADES RESTRINGIDAS-------");
             empleado.setHorasExtra(15);
             System.out.println(empleado.getHorasExtra());
       }
       
       /*Para crear el jar introuduces en el cmd-> C:\Users\ifc\git\AccesoDatos\bin\P01_Introduccion_JavaBean>
       jar cvf ej_1_componentes.jar EJ_1_1_Asalariado.class EJ_1_2_Hacienda.class EJ_1_3_Principal.class
       
       Ejecutar el jar-> java -jar ej_1_componentes.jar*/
}