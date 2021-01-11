package entidades;

import java.sql.Date;
import java.util.ArrayList;


//Clase y Atributos de la clase Concierto
public class Concierto {
    
    protected long id;
    protected Date diahora;
    private ArrayList<Entrada> entradas = new ArrayList<Entrada>(); /* Relacion "Documentar" entre Concierto y Entrada, que es N:N, por lo que
    hemos decidido implementar ArrayList tanto en la clase Concierto como en la clase Entrada, este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/
    private ArrayList<Reportero> reporteros = new ArrayList<Reportero>();/* Relacion "Documentar" entre Concierto y Reportero, que es N:N, por lo que
    hemos decidido implementar ArrayList tanto en la clase Concierto como en la clase Reportero, este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/
    
//Getter y Setters de la clase Concierto
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDiahora() {
        return diahora;
    }

    public void setDiahora(Date diahora) {
        this.diahora = diahora;
    }
    
  
  
    //Constructores de la clase Concierto
     public Concierto() {
      
    }
    
     public Concierto(long id, Date diahora, Actuacion actuacion) {
        this.id = id;
        this.diahora = diahora;
    }
     
     public Concierto (Concierto c){
         this.id = c.id;
         this.diahora = c.diahora;
     }
     
     //Metodo To String de la clase Conceirto

    @Override
    public String toString() {
        return "Concierto{" + "id=" + id + ", diahora=" + diahora + ", entradas=" + entradas + ", reporteros=" + reporteros + '}';
    }
     
   
}
