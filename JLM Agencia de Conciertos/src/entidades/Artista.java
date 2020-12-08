
package entidades;

import java.util.ArrayList;

//Clase y Atributos de Artista
public class Artista {
    
    private long id;
    private String nombre;  
    private char generomusical;
    private ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>(); /* Relacion "Documentar" entre Artista y Actuación, que es N:N, por lo que
    hemos decidido implementar ArrayList tanto en la clase Artista como en la clase Actuación, este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/

   //Getters y Setters de la clase Artista
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
    
    //Constructores de la clase Artista
    
     public Artista() {
      
    }
    
    public Artista(Artista a) {
       this.id = a.id;
       this.nombre = a.nombre;
       this.generomusical = a.generomusical;
      
    }
     
     public Artista(long id, String nombre, char generomusical) {
        this.id = id;
        this.nombre = nombre;
        this.generomusical = generomusical;
        
    }
     
     //Metodo To String de la clase Artista
     
    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", generomusical=" + generomusical + ", actuaciones=" + actuaciones + '}';
    }
}
