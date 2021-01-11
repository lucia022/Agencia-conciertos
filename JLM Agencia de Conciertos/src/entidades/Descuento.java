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
public class Descuento {

    private long id;
    private String codigo;
    private Date fechavalidez;

    /*constructor por defecto*/
    public Descuento() {
    }

    /*constructor con parámetros*/
    public Descuento(long id, String codigo, Date fechavalidez) {
        this.id = id;
        this.codigo = codigo;
        this.fechavalidez = fechavalidez;
    }

    /*constructor de copia*/
    public Descuento(Descuento d) {
        this.id = d.id;
        this.codigo = d.codigo;
        this.fechavalidez = d.fechavalidez;
    }

    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechavalidez() {
        return fechavalidez;
    }

    public void setFechavalidez(Date fechavalidez) {
        this.fechavalidez = fechavalidez;
    }

    public static Descuento nuevoDescuento() throws ParseException {

        Descuento nuevodescuento = new Descuento();
        Scanner in = new Scanner(System.in);

        long iddescuento;
        String codigodescuento;
        Date fechavalidezdescuento;
        Boolean repetir;

        //En caso de que el id quiera ser pedido por teclado
        do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su descuento?: ");
            iddescuento = in.nextLong();

            System.out.print("¿" + iddescuento + " es el id del descuento?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();

            if (repetir == false) {
                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if ((iddescuento <= 0)) {
                System.out.println("El id introducido no es valido ya que " + iddescuento + " es menor que 1,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((iddescuento <= 0) || (repetir == false));
        nuevodescuento.setId(iddescuento);

        //En caso de que no se quiera pedir por teclado
        nuevodescuento.setId(Utilidades.numDescuentos + 1); //Se le suma uno a la cantidad de descuentos que existan en utilidades

        System.out.println("");

        do {
            in = new Scanner(System.in);

            System.out.print("¿Cual es el codigo del descuento?(7 digitos): "); //Se pedira el codigo de descuento
            codigodescuento = in.nextLine();

            System.out.print("¿" + codigodescuento + " es su codigo de descuento?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();

            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if (codigodescuento.length() != 7) {
                System.out.println("codigo de descuento invalido por no ser de 7 carazteres,por favor introduzcalo de nuevo");//En caso de tener mas de 9 o menos de 90 caracteres saldra el siguiente mensahje
            }

            if ((codigodescuento.equals("")) || (codigodescuento.equals(" "))) {
                System.out.println("No has introducido ningun codigo de descuento,es necesario introducir uno");//En caso de estar vacio se muestra este mensaje
            }

        } while ((codigodescuento.equals("")) || (codigodescuento.equals(" ")) || (codigodescuento.length() != 7) || (repetir == false)); //Si el NIF esta vacio o este tiene mas o menos de 9 caractertes se volvera a pedir al usuario el NIF
        nuevodescuento.setCodigo(codigodescuento);

        System.out.println("");

        System.out.println("A continuacion introduzca la fecha de validez del descuento:");
        fechavalidezdescuento = Utilidades.dameFecha();//Se llamara a la funcion damefecha de utilidades en la cual pedira un fecha y la validara.

        return nuevodescuento;
    }

    /*método toString*/
    @Override
    public String toString() {
        return "Descuento{" + "id=" + id + ", codigo=" + codigo + ", fechavalidez=" + fechavalidez + '}';
    }

}
