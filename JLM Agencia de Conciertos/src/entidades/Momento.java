/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author marii
 */
//Clase Momento
public class Momento {

    //Atributos de la clase Momento
    private long id;
    private Date hora;
    private String descripcion;
    private Reportero reportero;

    /*Relacion "capturar" entre Momento y Reportero la cual es 1:N y en este caso he decidido añadir 
    un atributo de tipo Reportero en la clase Momento,tambien hay que decir que seria obligatorio ya que la cardinalidad minima es superior a 0ç
    además esta clse Momento depende directamente de que exista reporteros ya que en caso contrario esta clase no existiria*/
    //Constructores de la clase Momento
    public Momento() {
    }

    public Momento(long id, Date hora, String descripcion, Reportero reportero) {
        this.id = id;
        this.hora = hora;
        this.descripcion = descripcion;
        this.reportero = reportero;
    }

    public Momento(Momento m) {
        this.id = m.id;
        this.hora = m.hora;
        this.descripcion = m.descripcion;
        this.reportero = m.reportero;
    }

    //Getters de la clase Momento
    public long getId() {
        return id;
    }

    public Date getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Reportero getReportero() {
        return reportero;
    }

    //Setters de la clase Momento
    public void setId(long id) {
        this.id = id;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setReportero(Reportero reportero) {
        this.reportero = reportero;
    }

    //Nuevo Metodo
    public static Momento nuevoMomento() {

        Momento ret = new Momento();
        Scanner in = new Scanner(System.in);

        long idNuevo;
        String descripcionNuevo = null;
        Reportero reporteroNuevo;
        boolean fallo = true;

        do {

            System.out.print("Introduzca el id del Informe");
            idNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idNuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);
        

         do {

            System.out.println("Introduzca la descripcion del momento");
            String descripcion = in.nextLine();
            ret.setDescripcion(descripcion);

            for (int i = 0; i < descripcionNuevo.length(); i++) {
                if (Character.isDigit(descripcionNuevo.charAt(i))) {
                    fallo = true;
                    System.out.println(" La descripcion que ha introducido contiene numeros,inntroduzcala sin ellos");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((descripcionNuevo.equals("")) || (descripcionNuevo.equals(" "))) {
                System.out.println("No has introducido ninguna descripcion, es necesario introducir alguna");
            }

        } while ((descripcionNuevo.equals("")) || (descripcionNuevo.equals(" ")) || (fallo == true));

         
         /* No se si habia que pedir estos datos, además me estaba dando fallo, a si que no lo borro, lo comento y lo dejamos para un futuro por si fuese necesario.
        do {

            System.out.println("Introduzca el Reportero");
            String Reportero = in.nextLine();
            ret.setReportero(reportero);

            for (int i = 0; i < Reportero.length(); i++) {
                if (Character.isDigit(Reportero.charAt(i))) {
                    fallo = true;
                    System.out.println(" La Reportero que ha introducido contiene numeros,inntroduzcalo sin ellos");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((Reportero.equals("")) || (Reportero.equals(" "))) {
                System.out.println("No has introducido ningun Reportero, es necesario introducir alguno");
            }

        } while ((Reportero.equals("")) || (Reportero.equals(" ")) || (fallo == true));

        */

     
         
        return ret;

    }

    //Metodo usado para la petición de fechas
    public static Date dameFecha() {

        Scanner in = new Scanner(System.in);
        Date Date = new Date();

        System.out.println("Introduce el año de la Gira");
        int year = in.nextInt();

        System.out.println("Introduce el mes de la Gira");
        int month = in.nextInt();

        System.out.println("Introduce el día del concierto");
        int day = in.nextInt();

        Date date = new GregorianCalendar(year, month, day).getTime();
        System.out.println("La fecha introducida es:" + date);

        return Date;

    }
    
    
    //Metodo toString de la clase Momento

    @Override
    public String toString() {
        return "Momento{" + "id=" + id + ", hora=" + hora + ", descripcion=" + descripcion + ", reportero=" + reportero + '}';
    }

}
