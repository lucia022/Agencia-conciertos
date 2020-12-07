
package entidades;

import java.util.ArrayList;


public class Actuacion {
    
    private long id;
    private long numerosecuencia; 
    private double duracion;
    private ArrayList<Artista> artistas = new ArrayList<Artista>();

   
  
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
    
      public Actuacion() {
        
    }

      public Actuacion(long id, long numerosecuencia, double duracion) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion;
    }
      
        public Actuacion(Actuacion a){
        this.id = a.id;
        this.numerosecuencia = a.numerosecuencia;
        this.duracion = a.duracion;
    }
      
      @Override
      public String toString() {
        return "Actuacion{" + "id=" + id + ", numerosecuencia=" + numerosecuencia + ", duracion=" + duracion + '}';
    }

}
