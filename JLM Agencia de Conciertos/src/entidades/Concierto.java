package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Concierto {
    
    protected long id;
    protected Date diahora;
    private ArrayList<Entrada> entradas = new ArrayList<Entrada>();
    private ArrayList<Reportero> reporteros = new ArrayList<Reportero>();
    

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
  
     public Concierto() {
      
    }
    
     public Concierto(long id, Date diahora) {
        this.id = id;
        this.diahora = diahora;
    }
     
     public Concierto (Concierto c){
         this.id = c.id;
         this.diahora = c.diahora;
     }
     
     @Override
    public String toString() {
        return "Concierto{" + "id=" + id + ", diahora=" + diahora + '}';
    }
}
