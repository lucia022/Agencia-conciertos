/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Reserva {

    private long id;
    private Date fechamaxima;
    private Usuario idusuario;

    /*Relación "realiza" entre Usuario y Reserva, la cual es N:1, he decidido añadir un atributo de Usuario en la clase Reserva, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
 /*Cabe destacar, que se trata de una asociación directa entre Usuario y Reserva*/

 /*constructor por defecto*/
    public Reserva() {
    }

    /*constructor con parámetros*/
    public Reserva(long id, Date fechamaxima, Usuario idusuario) {
        this.id = id;
        this.fechamaxima = fechamaxima;
        this.idusuario = idusuario;
    }

    /*constructor de copia*/
    public Reserva(Reserva res) {
        this.id = res.id;
        this.fechamaxima = res.fechamaxima;
        this.idusuario = res.idusuario;
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

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public static Reserva nuevaReserva() throws ParseException {

        Reserva nuevareserva = new Reserva();
        Scanner in = new Scanner(System.in);

        long idreserva;
        Date fechamaximareserva;
        boolean repetir;

        //En caso de que el id quiera ser pedido por teclado
        do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su reserva?: ");
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
        nuevareserva.setId(Utilidades.numReservas + 1); //Se le suma uno a la cantidad de reservas que existan en utilidades

        
        System.out.println("");

        
        fechamaximareserva = Utilidades.dameFecha();
        System.out.println(fechamaximareserva);

        return nuevareserva;
    }

    /*método toString*/
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechamaxima=" + fechamaxima + ", idusuario=" + idusuario + '}';
    }

}
