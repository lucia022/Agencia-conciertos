/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Compra {

    //Todos los atributos no podran quedar vacios
    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VALIDOS: Todos aquellos double que sean mayores que 0.01.
    //VALORES INVALIDOS: Todo aquello que no sea double o los doubles menores que cero.
    private double precio;
    //VALORES VALIDOS: Los metodos de pago solo podran ser los dados por la consola y habra que elegir entre ellos,en este caso son cadena de caracteres(String).
    //VALORES INVALIDOS: Todo aquello que no sean String.
   
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

    public static Compra nuevaCompra()  {

        Compra nuevacompra = new Compra();
        Scanner in = new Scanner(System.in);

        long idcompra;
        double preciocompra;
        String metodopagocompra = "";

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
        //nuevacompra.setId(Utilidades.numReservas + 1); Se le suma uno a la cantidad de reservas que existan en utilidades

        
        System.out.println("");
        
        
        do {//Pedira un precio(double) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el precio de su compra?(La separacion de decimales va con comas): ");//Se pide el precio
            preciocompra = in.nextDouble();

            System.out.print("¿" + preciocompra + " es su precio de la compra?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();

            if (repetir == false) {
                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if ((preciocompra <= 00.00)) {
                System.out.println("El precio introducido no es valido ya que " + preciocompra + " es menor que 00.01,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((preciocompra <= 00.00) || (repetir == false));
        nuevacompra.setPrecio(preciocompra);
        
     
        System.out.println("");

        
        do {//Se repetira mientras el usuario diga que lo que introducio no es correcto

            in = new Scanner(System.in);

            System.out.print("¿Cual es su metodo de pago?\n1:Tarjeta de credito  2:Contrarembolso  3:PayPal  4:Bizum  5:Otra\n(1,2,3,4 o 5): "); //Se dicen los metodos de pagos
            int eleccion = in.nextInt();//Se pide la eleccion
            switch (eleccion) {
                case 1:
                    metodopagocompra = "Tarjeta de credito";
                    break;

                case 2:
                    metodopagocompra = "Contrarembolso";
                    break;

                case 3:
                    metodopagocompra = "PayPal";//Los 4 primeros casos se guarda el elegido en la variable de metododepagocompra
                    break;
                    
                case 4:
                    metodopagocompra = "Bizum";
                    break;
                    
                case 5:
                    in = new Scanner(System.in);//En el 5 se pide al usuario que pregunte cual es  la otra
                    
                    System.out.print("Introduzca cual es la Otra: ");
                    String otra = in.nextLine();
                    metodopagocompra = otra;
                    break;
            }

            System.out.print("¿" + metodopagocompra + " es su metodo de pago?(true en caso afirmativo y false en negativo): ");//Se pregunta al usuario si esta es su forma de pago
            repetir = in.nextBoolean();

            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

        } while ((repetir == false)); //Si usuario dice que es falso lo que introducio se hara otra iteracion
        nuevacompra.setMetodopago(metodopagocompra);
        
        return nuevacompra;
    }

    /*método toString*/
    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", precio=" + precio + ", metodopago=" + metodopago + ", idusuario=" + idusuario + ", iddescuento=" + iddescuento + '}';
    }

}
