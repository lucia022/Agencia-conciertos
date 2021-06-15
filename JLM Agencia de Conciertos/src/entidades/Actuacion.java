/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class Actuacion {

    private long id;
    private long numerosecuencia;
    private double duracion;
    private long idConcierto;
    private ArrayList<Artista> artistas = new ArrayList<Artista>();
    private ArrayList<Reportero> reporteros = new ArrayList<Reportero>();

    public Actuacion() {
    }

    public Actuacion(long id, long numerosecuencia, double duracion, ArrayList<Artista> artistas, ArrayList<Reportero> reporteros) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion;
        this.artistas = artistas;
        this.reporteros = reporteros;
    }

    public Actuacion(Actuacion a) {
        this.id = a.id;
        this.duracion = a.duracion;
        this.artistas = a.artistas;
        this.reporteros = a.reporteros;
    }

    public Actuacion(long id, long numerosecuencia, double duracion, long idConcierto) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion;
        this.idConcierto = idConcierto;
    }

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

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public ArrayList<Reportero> getReporteros() {
        return reporteros;
    }

    public void setReporteros(ArrayList<Reportero> reporteros) {
        this.reporteros = reporteros;
    }

    public long getIdConcierto() {
        return idConcierto;
    }

    public void setIdConcierto(long idConcierto) {
        this.idConcierto = idConcierto;
    }

    /*método toString de la clase Actuación*/
    @Override
    public String toString() {
        return "Actuacion nº " + id + "; " + "con número de secuencia " + numerosecuencia + ", " + "tiene una duración de " + duracion + "minutos, " + "y actuan los siguientes artistas " + "\n\t" + artistas /*+ "\nLos reporteros que documentan esta actuación:" + reporteros*/;
    }

    public static ArrayList<Actuacion> convertir(Actuacion[] array) {
        ArrayList<Actuacion> ret = new ArrayList<Actuacion>();
        for (Actuacion t : array) {
            ret.add((Actuacion) t);
        }
        return ret;
    }

    public static ArrayList<Actuacion> arrayde(ArrayList<Actuacion> lista, int[] ids) {
        ArrayList<Actuacion> ret = new ArrayList<Actuacion>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getId() es propio de Actuacion
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Actuacion) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static Actuacion nuevoActuacion() {
        Actuacion ret = new Actuacion();
        Scanner in = new Scanner(System.in);
        long idactuacion;
        do {
            System.out.println("Introduzca el id de la actuacion:");
            idactuacion = in.nextLong();
            ret.setId(idactuacion);
            if (idactuacion <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (idactuacion <= 0);

        System.out.println("Introduzca el número de secuencia de la actuación: ");
        long numerosecuencia = in.nextLong();
        ret.setNumerosecuencia(numerosecuencia);

        System.out.println("Introduzca la duración de la actuación:");
        double duracion = in.nextDouble();
        ret.setDuracion(duracion);
        return ret;
    }

    public String data() {
        return this.id + "|" + this.numerosecuencia + "|" + this.duracion;
    }

    public static ArrayList<Actuacion> cargarActuaciones() {
        ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
        for (int i = 0; i < Utilidades.ACTUACIONES.length; i++) {
            actuaciones.add(Utilidades.ACTUACIONES[i]);
        }
        return actuaciones;
    }
}
