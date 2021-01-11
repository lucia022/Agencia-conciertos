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
public class Compra {

    private long id;
    private double precio;
    private String metodopago;
    private Usuario idusuario;
    /*Relación "realiza" entre Usuario y Compra, la cual es N:1, he decidido añadir un atributo de Usuario en la clase Compra, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
 /*Cabe destacar, que se trata de una asociación directa entre Usuario y Compra*/

    private Descuento iddescuento;

    /*Relación “se aplica” entre Descuento y Compra, la cual es 1:1, he decidido añadir un atributo de Descuento en la clase Compra, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
 /*Cabe destacar, que sin la clase Compra no existiría la clase Descuento, por lo que se trata de una dependencia.*/

 /*constructor por defecto*/
    public Compra() {
    }

    /*constructor con parámetros*/
    public Compra(long id, double precio, String metodopago, Usuario idusuario, Descuento iddescuento) {
        this.id = id;
        this.precio = precio;
        this.metodopago = metodopago;
        this.idusuario = idusuario;
        this.iddescuento = iddescuento;
    }

    /*constructor de copia*/
    public Compra(Compra com) {
        this.id = com.id;
        this.precio = com.precio;
        this.metodopago = com.metodopago;
        this.idusuario = com.idusuario;
        this.iddescuento = com.iddescuento;
    }


    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Descuento getIddescuento() {
        return iddescuento;
    }

    public void setIddescuento(Descuento iddescuento) {
        this.iddescuento = iddescuento;
    }

    public static Compra nuevaCompra() throws ParseException {

        Compra nuevacompra = new Compra();
        Scanner in = new Scanner(System.in);

        long idcompra;
        String metodopagocompra;

        boolean repetir;

        //En caso de que el id quiera ser pedido por teclado
        do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su compra?: ");
            idcompra = in.nextLong();

            System.out.print("¿" + idcompra + " es su id de compra?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();

            if (repetir == false) {
                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if ((idcompra <= 0)) {
                System.out.println("El id introducido no es valido ya que " + idcompra + " es menor que 1,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((idcompra <= 0) || (repetir == false));
        nuevacompra.setId(idcompra);

        //En caso de que no se quiera pedir por teclado
        nuevacompra.setId(Utilidades.numReservas + 1); //Se le suma uno a la cantidad de reservas que existan en utilidades

        
        System.out.println("");
        
        /*
        do {
            in = new Scanner(System.in);

            System.out.print("¿Cual es su metodo de pago?"); //Se pregunta por el metodo de pago


            System.out.print("¿" + metodopagocompra + " es su metodo de pago?(true en caso afirmativo y false en negativo): ");//
            repetir = in.nextBoolean();

            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

        } while ((repetir == false)); //Si el NIF esta vacio o este tiene mas o menos de 9 caractertes se volvera a pedir al usuario el NIF
        */
        
        
        
        return nuevacompra;
    }

    /*método toString*/
    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", precio=" + precio + ", metodopago=" + metodopago + ", idusuario=" + idusuario + ", iddescuento=" + iddescuento + '}';
    }

}
