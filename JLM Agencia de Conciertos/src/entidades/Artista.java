
package entidades;

import java.util.ArrayList;


public class Artista {
    
    private long id;
    private String nombre;  
    private char generomusical;
    private Actuacion actuacion;
    private ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();

   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGeneromusical() {
        return generomusical;
    }

    public void setGeneromusical(char generomusical) {
        this.generomusical = generomusical;
    }
    
      public Actuacion getActuacion() {
        return actuacion;
    }

    public void setActuacion(Actuacion actuacion) {
        this.actuacion = actuacion;
    }
   
     public Artista() {
      
    }
    
    public Artista(Artista a) {
       this.id = a.id;
       this.nombre = a.nombre;
       this.generomusical = a.generomusical;
       this.actuacion = a.actuacion;
    }
     
     public Artista(long id, String nombre, char generomusical, Actuacion actuacion) {
        this.id = id;
        this.nombre = nombre;
        this.generomusical = generomusical;
        this.actuacion = actuacion;
    }
     
    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", generomusical=" + generomusical + ", actuacion=" + actuacion + ", actuaciones=" + actuaciones + '}';
    }
}
