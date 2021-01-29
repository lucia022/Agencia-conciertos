package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de Actuacion
public class Actuacion { 

    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VÁLIDOS: son los valores correscpondientes al orden de la actución en el concierto.
    //VALORES INVÁLIDOS: aquellos valores que no siguen el orden de la actuación en el concierto.
    private long numerosecuencia;
    //VALORES VÁLIDOS: solo se aceptan valores 00.00 correspondientes a las duraciones de las actuaciones en minutos.
    //VALORES INVÁLIDOS: aquellas duraciones que no sean introducidas con el formato 00.00, y cuya duración no sea en minutos.
    private double duracion;
    private ArrayList<Artista> artistas = new ArrayList<Artista>();/*relación "intervenir" N:N entre Artista y Actuación*/
    private ArrayList<Reportero> reporteros = new ArrayList<Reportero>();/*relación "documentar 1:N entre Reporetero y Actuación, introduciendo un ArrayList de Reportero dentro de la clase Actuación*/
   
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
    

     /*método toString de la clase Actuación*/
    @Override
    public String toString() {
        return "Actuacion" +"\nId de la actuación:" + id + "\nNúmero de secuencia:" + numerosecuencia + "\nDuración en minutos de la actuación:" + duracion + "\nActuan los siguientes artistas:" + artistas + "\nLos reporteros que documentan esta actuación:" + reporteros;
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
}
