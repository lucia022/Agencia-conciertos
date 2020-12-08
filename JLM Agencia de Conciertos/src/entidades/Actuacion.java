
package entidades;

import java.util.ArrayList;

//Clase y Atributos de Actuacion
public class Actuacion {
    
    private long id;
    private long numerosecuencia; 
    private double duracion;
    private Concierto idconcierto;
    private ArrayList<Artista> artistas = new ArrayList<Artista>(); /* Relacion "Documentar" entre Artista y Actuación, que es N:N, por lo que
    hemos decidido implementar ArrayList tanto en la clase Artista como en la clase Actuación, este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/

   
  //Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumerosecuencia() {
        return numerosecuencia;
    }

    public void setNumerosecuencia(long numerosecuencia) {
        this.numerosecuencia = numerosecuencia;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
      public Concierto getConcierto() {
        return idconcierto;
    }

    public void setConcierto(Concierto concierto) {
        this.idconcierto = concierto;
    }
    
    //Constructores de Actuación
      public Actuacion() {
        
    }

      public Actuacion(long id, long numerosecuencia, double duracion, Concierto concierto, Artista artista) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion; 
        this.idconcierto = idconcierto;
    }
      
        public Actuacion(Actuacion a){
        this.id = a.id;
        this.numerosecuencia = a.numerosecuencia;
        this.duracion = a.duracion;
        this.idconcierto = a.idconcierto;
    }
      
      //Metodo To Srting de la clase Actuación
    @Override
    public String toString() {
        return "Actuacion{" + "id=" + id + ", numerosecuencia=" + numerosecuencia + ", duracion=" + duracion + ", concierto=" + idconcierto + ", artistas=" + artistas + '}';
    }

}
