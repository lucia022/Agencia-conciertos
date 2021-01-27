package entidades;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de la clase Concierto
public class Concierto {

    protected long id;
    protected Date diahora;
    protected ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
    protected ArrayList<Entrada> entradas = new ArrayList<Entrada>();

    public Concierto() {
    }

    public Concierto(long id, Date diahora, ArrayList<Actuacion> actuaciones, ArrayList<Entrada> entradas) {
        this.id = id;
        this.diahora = diahora;
        this.actuaciones = actuaciones;
        this.entradas = entradas;
    }

    public Concierto(Concierto c) {
        this.id = c.id;
        this.diahora = c.diahora;
        this.actuaciones = c.actuaciones;
        this.entradas = c.entradas;
    }

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

    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(ArrayList<Actuacion> actuaciones) {
        this.actuaciones = actuaciones;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<Entrada> entradas) {
        this.entradas = entradas;
    }

    //Metodo To String de la clase Conceirto
    @Override
    public String toString() {
        return "Concierto{" + "id=" + id + ", diahora=" + diahora + ", actuaciones=" + actuaciones + ", entradas=" + entradas + '}';
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
