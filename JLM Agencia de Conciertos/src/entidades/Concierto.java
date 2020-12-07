package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Concierto {
    
    protected long id;
    protected Date diahora;
    protected Actuacion actuacion;  
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
    
     public void setActuacion(Actuacion actuacion) {
        this.actuacion = actuacion;
    }

    public Actuacion getActuacion() {
        return actuacion;
    }
  
     public Concierto() {
      
    }
    
     public Concierto(long id, Date diahora, Actuacion actuacion) {
        this.id = id;
        this.diahora = diahora;
        this.actuacion = actuacion;
    }
     
     public Concierto (Concierto c){
         this.id = c.id;
         this.diahora = c.diahora;
         this.actuacion = c.actuacion;
     }
     
    @Override
    public String toString() {
        return "Concierto{" + "id=" + id + ", diahora=" + diahora + ", actuacion=" + actuacion + ", entradas=" + entradas + ", reporteros=" + reporteros + '}';
    }
}
