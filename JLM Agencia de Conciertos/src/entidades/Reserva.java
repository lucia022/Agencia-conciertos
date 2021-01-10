/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Reserva {
     private long id;
    private Date fechamaxima;
    private Usuario idusuario; /*Relación "realiza" entre Usuario y Reserva, la cual es N:1, he decidido añadir un atributo de Usuario en la clase Reserva, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
                               /*Cabe destacar, que se trata de una asociación directa entre Usuario y Reserva*/
    
    /*constructor por defecto*/
    public Reserva(){}
    
    /*constructor con parámetros*/
    public Reserva(long id, Date fechamaxima, Usuario idusuario) {
        this.id = id;
        this.fechamaxima = fechamaxima;
        this.idusuario = idusuario;
    }
    
    /*constructor de copia*/
    public Reserva(Reserva res){
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
    
    
    public static Reserva nuevaReserva(){
    //En caso de que el id quiera ser pedido por teclado
        Reserva nueva = new Reserva();
        Scanner in = new Scanner(System.in);

        long idnuevo;
    
    do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que se mayor que cero

            System.out.print("¿Cual es el id de su usuario?: ");
            idnuevo = in.nextLong();
            nueva.setId(idnuevo);
            if (idnuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while (idnuevo <= 0);

        //En caso de que no se quiera pedir por teclado
        nueva.setId(Utilidades.numReservas + 1); //Se le suma uno a la cantidad de reservas que existan en utilidades
    
        return nueva;
    }
    
    
    /*método toString*/

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechamaxima=" + fechamaxima + ", idusuario=" + idusuario + '}';
    }
    
}
