package entidades;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de la clase Concierto
public class Concierto {

    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    protected long id;
    //VALORES VÁLIDOS: fecha (Date) en el formato dd/mm/aaaa.
    //VALORES INVÁLIDOS: aquellas fechas (Date) que no contengan el formato dd/mm/aaaa
    protected Date diahora;
    protected ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();/*relación "formar" 10:1 entre Actuación y Concierto, introduciendo un ArrayList de Actuación en la clase concierto*/
    
    protected ArrayList<Entrada> entradas = new ArrayList<Entrada>(); /*relación "tener" N:1 entre e Entrada y Concierto, introduciendo un ArrayList de entrada en la clase concierto*/

    public Concierto() {
    }

    public Concierto(long id, Date diahora, ArrayList<Actuacion> actuaciones, ArrayList<Entrada> entradas) {
        this.id = id;
        this.diahora = diahora;
        this.actuaciones = actuaciones;
        this.entradas = entradas;
    }

    public Concierto(long id, Date diahora, ArrayList<Entrada> entradas) {
        this.id = id;
        this.diahora = diahora;
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
        return "Concierto" + "\nId del concierto:" + id + "\nfecha del concieto:" + diahora + "\nContiene las siguientes actuaciones:" + actuaciones + "\nDispone de estas entradas:" + entradas;
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

    public static ArrayList<Concierto> todosconciertos() {
        ArrayList<Concierto> todosconciertos = new ArrayList<Concierto>();
        for (int i = 0; i < Utilidades.CONCIERTOS.length; i++) {
            todosconciertos.add(Utilidades.CONCIERTOS[i]);
        }
        return todosconciertos;
    }
}
