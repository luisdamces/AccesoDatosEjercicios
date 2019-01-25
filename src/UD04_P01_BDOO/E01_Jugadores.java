package UD04_P01_BDOO;

public class E01_Jugadores {
    
    // Propiedades
    private String nombre;
    private String deporte;
    private String ciudad;
    private int edad;
   
    // Constructores
    public E01_Jugadores(){};
   
    public E01_Jugadores(String nombre, String deporte, String ciudad, int edad) {
          super();
          this.nombre = nombre;
          this.deporte = deporte;
          this.ciudad = ciudad;
          this.edad = edad;
    }
   
    // Métodos
    public String getNombre() {
          return nombre;
    }
    public void setNombre(String nombre) {
          this.nombre = nombre;
    }
    public String getDeporte() {
          return deporte;
    }
    public void setDeporte(String deporte) {
          this.deporte = deporte;
    }
    public String getCiudad() {
          return ciudad;
    }
    public void setCiudad(String ciudad) {
          this.ciudad = ciudad;
    }
    public int getEdad() {
          return edad;
    }
    public void setEdad(int edad) {
          this.edad = edad;
    }
} // Fin clase Jugadores

