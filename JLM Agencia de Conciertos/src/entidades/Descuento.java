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

    ///Todos los atributos no podran quedar vacios
    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) y aquellas cadenas que contengan mas o menos de 7 caracteres.
    private String codigo;
    //VALORES VALIDOS: Date con el formato dd/mm/aaaa.
    //VALORES INVALIDOS: Todo lo que no sea Date o si el Date no tiene el formato dd/mm/aaaa y si la fecha de validez introducida es inferior a la actual(Esto lo hare para la proxima practica ya que no me dio tiempo).
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

    public static Descuento nuevoDescuento() throws ParseException {//Este metodo seria en caso de que se quiera pedir al usuario los datos del descuento pero lo normal es que estos datos vengan ya dados

        Descuento nuevodescuento = new Descuento();
        Scanner in = new Scanner(System.in);

        long iddescuento;
        String codigodescuento;
        Boolean fallo = false;
        
        //En caso de que el id quiera ser pedido por teclado
        /*do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su descuento?: ");//Pide el id de usuario
            idusuario = in.nextLong();

            if ((idusuario <= 0)) {
                System.out.println("El id introducido no es valido ya que " + iddescuento + " es menor que 1,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((iddescuento <= 0));//Se pedira otra vez el id siempre que este sea menor que 1
        nuevodescuento.setId(iddescuento);//Se setea el id del descuento*/
        //En caso de que quiera ser automatico
        iddescuento = Descuento.iddescuento();
        System.out.println("Su id de descuento sera el " + iddescuento);
        nuevodescuento.setId(iddescuento);

        System.out.println("");

        do {
            
            in = new Scanner(System.in);

            System.out.print("¿Cual es el codigo del descuento?(7 digitos): "); //Se pedira el codigo de descuento
            codigodescuento = in.nextLine();

            if (codigodescuento.length() != 7) {
                fallo = true;
                System.out.println("codigo de descuento invalido por no ser de 7 carazteres,por favor introduzcalo de nuevo");//En caso de tener mas de 9 o menos de 90 caracteres saldra el siguiente mensahje
            }

        } while (fallo); //Si el NIF esta vacio o este tiene mas o menos de 9 caractertes se volvera a pedir al usuario el NIF
        nuevodescuento.setCodigo(codigodescuento);

        System.out.println("");

        System.out.println("A continuacion introduzca la fecha de validez del descuento:");
        Date fechavalidezdescuento = Fecha.dameFecha();//Se llamara a la funcion damefecha de utilidades en la cual pedira un fecha y la validara.
        nuevodescuento.setFechavalidez(fechavalidezdescuento);

        return nuevodescuento;
    }

    public static long iddescuento() {//Metodo para conseguir el id de forma automatica(se le suma uno al numero mas grande de id que haya)

        long masalto = 0;
        if (Utilidades.DESCUENTOS.length == 0) {     //En caso de que no haya ningun objeto se empezara en uno

        } else {
            for (int i = 0; i < Utilidades.numDescuentos; i++) {//Busca el id mas grande que hay entre los objetos y le suma 1

                if (Utilidades.DESCUENTOS[i].getId() > masalto) {
                    masalto = Utilidades.DESCUENTOS[i].getId();
                }
            }
        }
        masalto++;
        return masalto;
    }

    /*método toString*/
    @Override
    public String toString() {
        return "Descuento{" + "id=" + id + ", codigo=" + codigo + ", fechavalidez=" + fechavalidez + '}';
    }

}
