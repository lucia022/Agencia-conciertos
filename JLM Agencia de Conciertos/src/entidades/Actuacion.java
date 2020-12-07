
package entidades;

import java.util.ArrayList;


public class Actuacion {
    
    private long id;
    private long numerosecuencia; 
    private double duracion;
    private Concierto concierto;
    private Artista artista;
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
    
      public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        this.concierto = concierto;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
      public Actuacion() {
        
    }

      public Actuacion(long id, long numerosecuencia, double duracion, Concierto concierto, Artista artista) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion;
        this.artista = artista;
        this.concierto = concierto;
    }
      
        public Actuacion(Actuacion a){
        this.id = a.id;
        this.numerosecuencia = a.numerosecuencia;
        this.duracion = a.duracion;
        this.artista = a.artista;
        this.concierto = a.concierto;
    }
      
      
    @Override
    public String toString() {
        return "Actuacion{" + "id=" + id + ", numerosecuencia=" + numerosecuencia + ", duracion=" + duracion + ", concierto=" + concierto + ", artista=" + artista + ", artistas=" + artistas + '}';
    }

}
