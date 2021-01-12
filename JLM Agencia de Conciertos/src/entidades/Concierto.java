package entidades;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


//Clase y Atributos de la clase Concierto
public class Concierto {
    
    protected long id;
    protected Date diahora;
    protected Entrada identrada;
    protected Reportero idreportero;
    
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

    public Entrada getIdentrada() {
        return identrada;
    }

    public void setIdentrada(Entrada identrada) {
        this.identrada = identrada;
    }

    public Reportero getIdreportero() {
        return idreportero;
    }

    public void setIdreportero(Reportero idreportero) {
        this.idreportero = idreportero;
    }
    
    
  
    //Constructores de la clase Concierto
     public Concierto() {
      
    }
    
     public Concierto(long id, Date diahora, Entrada identrada, Reportero idreportero) {
        this.id = id;
        this.diahora = diahora;
        this.identrada = identrada;
        this.idreportero = idreportero;
    }
     
     public Concierto (Concierto c){
         this.id = c.id;
         this.diahora = c.diahora;
         this.identrada = c.identrada;
         this.idreportero = c.idreportero;
     }
     
     //Metodo To String de la clase Conceirto

    @Override
    public String toString() {
        return "Concierto{" + "id=" + id + ", diahora=" + diahora + ", identrada=" + identrada + ", idreportero=" + idreportero + '}';
    }

    
     
   public static Concierto nuevoConcierto() throws ParseException {
        Concierto ret = new Concierto();
        Scanner in = new Scanner(System.in);
        long idconcierto;
        do {
            System.out.println("Introduzca el id del concierto:");
            idconcierto = in.nextLong();
            ret.setId(idconcierto);
            if (idconcierto <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (idconcierto <= 0);
        /*ret.setId(Utilidades.numConciertos + 1);*/

        java.util.Date fecha = (java.util.Date) Fecha.dameFecha();
        return ret;
    }
}
