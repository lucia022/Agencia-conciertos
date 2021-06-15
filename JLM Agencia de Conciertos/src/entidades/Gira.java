/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import ConexionBD.ConexionBD;
import dao.ConciertoDAO;
import dao.GiraDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import varios.Validacion;

/**
 *
 * @author lucia
 */
public class Gira {

    public static ArrayList<Gira> cargarGira() {
        ArrayList<Gira> giras = new ArrayList<Gira>();
        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();
        Gira giraPaso = new Gira();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Date FechaCierre = null;
        /*Utilidades.GIRAS[0].setFechacierra(sdf.parse("20/09/2019"));
        Utilidades.GIRAS[1].setFechacierra(sdf.parse("24/10/2020"));
        Utilidades.GIRAS[2].setFechacierra(sdf.parse("14/11/2020"));
        Utilidades.GIRAS[3].setFechacierra(sdf.parse("18/09/2020"));*/
        for (int i = 0; i < Utilidades.GIRAS.length; i++) {
            giraPaso = Utilidades.GIRAS[i];
            conciertos = new ArrayList<Concierto>();
            if (i == 0) {
                conciertos.add(Utilidades.CONCIERTOS[0]);
                conciertos.add(Utilidades.CONCIERTOS[1]);
            } else if (i == 1) {
                conciertos.add(Utilidades.CONCIERTOS[2]);
                conciertos.add(Utilidades.CONCIERTOS[3]);
            }
            if (i == 2) {
                conciertos.add(Utilidades.CONCIERTOS[4]);
            }
            if (i == 3) {
                conciertos.add(Utilidades.CONCIERTOS[5]);
            }
            giraPaso.setConciertos(conciertos);
            giras.add(giraPaso);
        }
        return giras;
    }

    static boolean validarIdGira(int idGira) {
        if (idGira != 0) {
            if (idGira < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarGira(Gira g) {
        if (g.getId() != 0) {
            if (g.getId() < 0) {
                return false;
            }
        }
        if (g.getNombre().isEmpty()) {
            return false;
        }
        return true;
    }

    private long id;
    private String nombre;
    private Date fechainicio;
    private Date fechacierra;
    private long idInforme;
    private long idConcierto;
    private ArrayList<Concierto> conciertos = new ArrayList<Concierto>(); //relacion "Compuesto" entre Concierto y Gira

    public Gira() {
    }

    public Gira(Gira g) {
        this.id = g.id;
        this.nombre = g.nombre;
        this.fechainicio = g.fechainicio;
        this.fechacierra = g.fechacierra;
        this.idInforme = g.idInforme;
    }

    public Gira(long id, String nombre, Date fechainicio, Date fechacierra, long idInforme) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechacierra = fechacierra;
        this.idInforme = idInforme;
    }

    public Gira(int idGira, String nombre) {
        this.id = idGira;
        this.nombre = nombre;
    }

    //Getters de la clase Gira
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechacierra() {
        return fechacierra;
    }

    public long getIdInforme() {
        return idInforme;
    }

    public ArrayList<Concierto> getConciertos() {
        return conciertos;
    }

    //Setters de la clase Gira
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechacierra(Date fechacierra) {
        this.fechacierra = fechacierra;
    }

    public void setInforme(long idInforme) {
        this.idInforme = idInforme;
    }

    public void setConciertos(ArrayList<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    public long getIdConcierto() {
        return idConcierto;
    }

    public void setIdConcierto(long idConcierto) {
        this.idConcierto = idConcierto;
    }

    //Arraylist de la clase Gira
    public static ArrayList<Gira> todasGiras() {
        ArrayList<Gira> todasGiras = new ArrayList<Gira>();
        todasGiras.addAll(Arrays.asList(Utilidades.GIRAS));
        return todasGiras;
    }

    //Aqui creo un metodo para ver las Giras
    public static void verGiras() {
        System.out.println("Lista de Giras actuales:");
        for (Gira g : Utilidades.GIRAS) {
            if (g.getId() > 0) {
                System.out.println(g.toString());
            }
        }
    }

    //Aqui creo un metodo para ver los Conciertos
    public static void verConciertos() {
        System.out.println("Lista de Conciertos de las Giras:");
        for (int i = 0; i < Utilidades.CONCIERTOS.length; i++) {
            Concierto c = Utilidades.CONCIERTOS[i];
            if (c.getId() > 0) {
                System.out.println(c.toString());
            }
        }
    }

//Función para buscar Giras y Conciertos
    public static Gira buscarGiraByIdArraylist(int id) {
        for (int i = 0; i < Utilidades.GIRAS.length; i++) {
            if (Utilidades.GIRAS[i].getId() == id) {
                return Utilidades.GIRAS[i];
            }
        }
        return null;
    }

    //Nuevo Metodo
    public static Gira nuevaGira() {
        long idGira;
        String nombreGira;
        Date fechaInicio, fechaCierre;
        Gira ret = new Gira();
        //ID DE LA GIRA
        //idGira = Gira.pedirIdGira();
        //System.out.println("El ID de la Gira será el " + idGira);
        ret.setId(0);
        //NOMBRE DE LA GIRA
        nombreGira = Gira.pedirNombreGira();
        ret.setNombre(nombreGira);
        //FECHA INICIO DE LA GIRA
        fechaInicio = Gira.pedirFechaInicio();
        ret.setFechainicio(fechaInicio);
        //FECHA CIERRE DE LA GIRA
        fechaCierre = Gira.pedirFechaCierre();
        ret.setFechacierra(fechaCierre);
        ret.setInforme(1);
        return ret;
    }

    public static long pedirIdGira() {
        long masalto = 0;
        if (Utilidades.GIRAS.length == 0) {

        } else {
            for (int i = 0; i < Utilidades.GIRAS.length; i++) {
                if (Utilidades.GIRAS[i].getId() > masalto) {
                    masalto = Utilidades.GIRAS[i].getId();
                }
            }
        }
        masalto++;
        return masalto;
    }

    public static String pedirNombreGira() {
        Scanner in = new Scanner(System.in);
        String nombreGira;
        boolean valido = false;
        do {
            System.out.println("Introduzca el NOMBRE DE LA GIRA: ");
            nombreGira = in.nextLine();
            valido = Validacion.validarNombre(nombreGira.trim());
        } while (!valido);
        return nombreGira;
    }

    public static Date pedirFechaInicio() {
        Scanner in = new Scanner(System.in);
        String strFecha;
        Date ret = new Date();
        Boolean valido = false;
        do {
            System.out.println("Introduzca la FECHA DE INICIO DE LA GIRA con el formato dd/MM/yyyy: ");
            strFecha = in.nextLine();
            valido = Validacion.validarFecha(strFecha.trim());
            if (valido) {
                ret = Validacion.ParseFecha(strFecha);
            }
        } while (!valido);
        return ret;
    }

    public static Date pedirFechaCierre() {
        Scanner in = new Scanner(System.in);
        String strFecha;
        Date ret = new Date();
        Boolean valido = false;
        do {
            System.out.println("Introduzca la FECHA DE CIERRE DE LA GIRA: ");
            strFecha = in.nextLine();
            valido = Validacion.validarFecha(strFecha.trim());
            if (valido) {
                ret = Validacion.ParseFecha(strFecha);
            }
        } while (!valido);
        return ret;
    }

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

    //Metodo tooString de la clase Gira
    @Override
    //public String toString() {
    //    return "Los datos de la Gira son:" + "\n" + "El id es: " + id + "\n" + " El nombre es: " + nombre + "\n" + "El inicio de la Gira se produjo el: " + fechainicio + "\n" + " La Gira se cerro el: " + fechacierra + "\n" + "Su informe corresponde a: " + idInforme + "\n" + "Los conciertos que se produjeron en la Gira fueron: " + conciertos;
    //}
    public String toString() {
        return(nombre);
    }

}
