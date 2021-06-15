/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import dao.*;
import varios.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author lucia
 */
public class Concierto {

    protected long id;
    protected Date diahora;
    protected ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
    protected ArrayList<Entrada> entradas = new ArrayList<Entrada>();
    protected long idGira;

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

    //CONSTRUCTOR DE CONCIERTODAO
    public Concierto(long id, Date diahora, long idGira) {
        this.id = id;
        this.diahora = diahora;
        this.idGira = idGira;
    }

    public Concierto(long id, Date diahora) {
        this.id = id;
        this.diahora = diahora;

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

    public long getIdGira() {
        return idGira;
    }

    public void setIdGira(long idGira) {
        this.idGira = idGira;
    }

    //Metodo To String de la clase Conceirto
    @Override
    public String toString() {
        return "Concierto{" + "id=" + id + ", diahora=" + diahora + ", actuaciones=" + actuaciones + ", entradas=" + entradas + ", idGira=" + idGira + '}';
    }

    public static ArrayList<Concierto> arrayde(ArrayList<Concierto> lista, int[] ids) {

        ArrayList<Concierto> ret = new ArrayList<Concierto>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Concierto) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static Concierto leerConciertoTeclado(ArrayList<Gira> aLGira) {
        boolean correcto = false;
        //long idConcierto;
        Date diahora;
        Concierto ret = new Concierto();
        //ID DEL CONCIERTO
        //idConcierto = Concierto.pedirIdConcierto();
        //System.out.println("El ID del CONCIERTO será el" + idConcierto);
        //ret.setId(idConcierto);
        ret.setId(0);
        //FECHA DEL CONCIERTO
        diahora = Concierto.pedirDiaHora();
        ret.setDiahora(diahora);
        //ID GIRA
        Scanner in = new Scanner(System.in);
        int idGira = 0;
        Gira gi;
        do {
            System.out.println("Introduzca el ID de la GIRA");
            idGira = in.nextInt();
            correcto = Gira.validarIdGira(idGira);
            //que idGira coincide con uno de la BBDD
            if (correcto) {
                gi = GiraDAO.buscarGiraById(idGira);
            } else {
                gi = null;
            }
        } while (gi == null);

        ret.setIdGira(idGira);
        return ret;
    }

    public static Date pedirDiaHora() {
        Scanner in = new Scanner(System.in);
        String strFecha;
        Date ret = new Date();
        Boolean valido = false;
        do {
            System.out.println("Introduzca la FECHA del CONCIERTO con el formato dd/MM/yyyy: ");
            strFecha = in.nextLine();
            valido = Validacion.validarFecha(strFecha.trim());
            if (valido) {
                ret = Validacion.ParseFecha(strFecha);
            }
        } while (!valido);
        return ret;
    }

    public static long pedirIdGira(ArrayList<Gira> gira) {
        Scanner in = new Scanner(System.in);
        boolean valido = false;
        long ret = 0;
        do {
            System.out.println("Introduzca el ID DE LA GIRA: ");
            //validar que es numero
            ret = in.nextLong();
            //que este dentro de los validos
            for (int i = 0; i < gira.size(); i++) {
                if (ret == gira.get(i).getId()) {
                    valido = true;
                }
            }
        } while (!valido);
        return ret;
    }

    public static ArrayList<Concierto> convertir(Concierto[] array) {
        ArrayList<Concierto> ret = new ArrayList<Concierto>();
        for (Concierto c : array) {
            ret.add((Concierto) c);
        }
        return ret;
    }

    public static long pedirIdConciertoArraylist() {
        long masalto = 0;
        if (Utilidades.CONCIERTOS.length == 0) {

        } else {
            for (int i = 0; i < Utilidades.CONCIERTOS.length; i++) {
                if (Utilidades.CONCIERTOS[i].getId() > masalto) {
                    masalto = Utilidades.CONCIERTOS[i].getId();
                }
            }
        }
        masalto++;
        return masalto;
    }

    public static ArrayList<Concierto> cargarConciertos() {
        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();
        for (int i = 0; i < Utilidades.CONCIERTOS.length; i++) {
            conciertos.add(Utilidades.CONCIERTOS[i]);
        }
        return conciertos;
    }

}
