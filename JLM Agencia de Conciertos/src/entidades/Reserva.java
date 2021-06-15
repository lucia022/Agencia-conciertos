/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Reserva {

    //Todos los atributos no podran quedar vacios
    ///VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VALIDOS: Date con el formato dd/mm/aaaa.
    //VALORES INVALIDOS: Todo lo que no sea Date o si el Date no tiene el formato dd/mm/aaaa.
    private Date fechamaxima;
    //Es una coleccion de objetos del tipo entrafas en el cual se guardaran todas las entradas realizadas en la reserva x
    private ArrayList<Entrada> entradas = new ArrayList<Entrada>();

    private long idUsuario;

    /*constructor por defecto*/
    public Reserva() {
    }

    //constructor con parámetros ain el array de entradas
    public Reserva(long id, Date fechamaxima) {
        this.id = id;
        this.fechamaxima = fechamaxima;
    }

    //constructor con parámetros con el array de entradas
    public Reserva(long id, Date fechamaxima, ArrayList<Entrada> entradas) {
        this.id = id;
        this.fechamaxima = fechamaxima;
        this.entradas = entradas;
    }

    /*constructor de copia*/
    public Reserva(Reserva res) {
        this.id = res.id;
        this.fechamaxima = res.fechamaxima;
        this.entradas = res.entradas;
    }

    public Reserva(int id, java.sql.Date fechamaxima, int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    /*getters y setters de cada atributo*/
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechamaxima() {
        return fechamaxima;
    }

    public void setFechamaxima(Date fechamaxima) {
        this.fechamaxima = fechamaxima;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<Entrada> entradas) {
        this.entradas = entradas;
    }

    /*public static Reserva nuevaReserva(){

        Reserva nuevareserva = new Reserva();
        long idreserva;
        //En caso de que quiera ser automatico
        idreserva = Reserva.idReserva(); //En idusuario se guardara lo que retorne de la funcion idUusairo
        System.out.println("Su id de reserva sera el " + idreserva);//Se le muestra por pantalla que id tiene
        nuevareserva.setId(idreserva);//Se settea la variable idusuario en el objeto nuevousuario
        System.out.println("");
        System.out.println("Esta fecha tendra validez hasta");
        System.out.println("Elija ");

        return nuevareserva;
    }*/

 /* public static ArrayList<Reserva> todasReservas() {   //Metodo para copiar todos los objetos de utilidades en un arraylist y poder manipularlo

        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        for (int i = 0; i < Utilidades.RESERVAS.length; i++) {

            reservas.add(Utilidades.RESERVAS[i]);
        }
        return reservas;
    }*/
    public static ArrayList<Reserva> arrayde(ArrayList<Reserva> reservas, int[] ids) {
        ArrayList<Reserva> ret = new ArrayList<Reserva>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < reservas.size(); j++) {
                if (reservas.get(j).getId() == ids[i]) {
                    ret.add((Reserva) reservas.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Reserva> convertir(Reserva[] array) {
        ArrayList<Reserva> ret = new ArrayList<Reserva>();
        for (Reserva t : array) {
            ret.add((Reserva) t);
        }
        return ret;
    }

    /**
     * Funcion que obtiene el id proximo al ultimo idresaerva de nuestrta base
     * de datos
     *
     * @return long el cual es el id de la reserva nuevo
     */
    /* public static long idReserva() {//Metodo para conseguir el id de forma automatica(se le suma uno al numero mas grande de id que haya)

        long masalto = 0;
        if (Utilidades.RESERVAS.length == 0) {     //En caso de que no haya ningun objeto se empezara en uno

        } else {
            for (int i = 0; i < Utilidades.RESERVAS.length; i++) {//Busca el id mas grande que hay entre los objetos y le suma 1

                if (Utilidades.RESERVAS[i].getId() > masalto) {
                    masalto = Utilidades.RESERVAS[i].getId();
                }
            }
        }
        masalto++; //Sea cual sea se le suma 1
        return masalto; //Se devuelve el nuevo id
    }*/

 /*método toString*/
    @Override
    public String toString() {
        return "ID de reserva:" + id + "  Fecha maxima para realizar la compra:" + fechamaxima;
    }

    public static ArrayList<Reserva> cargarReservas() {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        for (int i = 0; i < Utilidades.RESERVAS.length; i++) {
            reservas.add(Utilidades.RESERVAS[i]);
        }
        return reservas;
    }

}
