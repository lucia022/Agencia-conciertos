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

    /*Relación "realiza" entre Usuario y Reserva, la cual es N:1, he decidido añadir un atributo de Usuario en la clase Reserva, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
 /*Cabe destacar, que se trata de una asociación directa entre Usuario y Reserva*/

 /*constructor por defecto*/
    public Reserva() {
    }

    /*constructor con parámetros*/
    public Reserva(long id, Date fechamaxima) {
        this.id = id;
        this.fechamaxima = fechamaxima;
    }

    /*constructor de copia*/
    public Reserva(Reserva res) {
        this.id = res.id;
        this.fechamaxima = res.fechamaxima;
    }

    /*getters y setters de cada atributo*/
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

    public static Reserva nuevaReserva() throws ParseException {

        Reserva nuevareserva = new Reserva();
        Scanner in = new Scanner(System.in);

        long idreserva;
        boolean repetir;

        //En caso de que el id quiera ser pedido por teclado
        do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su reserva?: ");//Pide por teclado el id
            idreserva = in.nextLong();

            System.out.print("¿" + idreserva + " es su id de reserva?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();

            if (repetir == false) {
                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if ((idreserva <= 0)) {
                System.out.println("El id introducido no es valido ya que " + idreserva + " es menor que 1,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((idreserva <= 0) || (repetir == false));
        nuevareserva.setId(idreserva);

        //En caso de que no se quiera pedir por teclado
        //nuevareserva.setId(Utilidades.numReservas + 1); Se le suma uno a la cantidad de reservas que existan en utilidades
        
        
        System.out.println("");

        
        System.out.println("Introduzca la fecha maxima de reserva");
        Date fechamaximareserva = Fecha.dameFecha();//Se llama a la funcion dame fecha y se setea la fecha dada
        nuevareserva.setFechamaxima(fechamaximareserva);
        

        return nuevareserva;
    }

    public static ArrayList<Reserva> todasReservas() {   //Metodo para copiar todos los objetos de utilidades en un arraylist y poder manipularlo

        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        for (int i = 0; i < Utilidades.RESERVAS.length; i++) {

            reservas.add(Utilidades.RESERVAS[i]);
        }
        return reservas;
    }
    
    public static ArrayList<Reserva> arrayde(ArrayList<Reserva> reservas, int[] ids) {
        ArrayList<Reserva> ret = new ArrayList<Reserva>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < reservas.size(); j++) {
                if (reservas.get(j).getId() == ids[i]) {
                    ret.add((Reserva) reservas.get(ids[i]));
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
    
    
    /*método toString*/

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechamaxima=" + fechamaxima + '}';
    }
   
}
