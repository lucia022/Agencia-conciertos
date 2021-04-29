/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
    //VALORES VALIDOS:Numeros mayores que 0.00
    //VALORES INVALIDOS: numeros que sean menores o iguales que 0.00
    private double cantidad;
    
    private long idUsuario;
    
    /*constructor por defecto*/
    public Descuento() {
    }

    /*constructor con parámetros*/
    public Descuento(long id, String codigo, Date fechavalidez) {
        this.id = id;
        this.codigo = codigo;
        this.fechavalidez = fechavalidez;
    }

    public Descuento(long id, String codigo, Date fechavalidez, double cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.fechavalidez = fechavalidez;
        this.cantidad = cantidad;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public static Descuento nuevoDescuentoparaNuevosUsuarios() {//Este metodo seria en caso de que se quiera pedir al usuario los datos del descuento pero lo normal es que estos datos vengan ya dados
        Descuento nuevodescuento = new Descuento();
        long iddescuento;
        String codigodescuento;
        double cantidaddescontada = 5.00;
        //Descuento autocalculado
        iddescuento = Descuento.iddescuento();
        nuevodescuento.setId(iddescuento);
        System.out.println("");
        codigodescuento = Descuento.codigoDescuentoAleatorio();
        nuevodescuento.setCodigo(codigodescuento);
        System.out.println("");
        nuevodescuento.setCantidad(cantidaddescontada);
        return nuevodescuento;
    }

    public static long iddescuento() {//Metodo para conseguir el id de forma automatica(se le suma uno al numero mas grande de id que haya)

        long masalto = 0;
        if (Utilidades.DESCUENTOS.length == 0) {     //En caso de que no haya ningun objeto se empezara en uno

        } else {
            for (int i = 0; i < Utilidades.DESCUENTOS.length; i++) {//Busca el id mas grande que hay entre los objetos y le suma 1

                if (Utilidades.DESCUENTOS[i].getId() > masalto) {
                    masalto = Utilidades.DESCUENTOS[i].getId();
                }
            }
        }
        masalto++;
        return masalto;
    }

    public static ArrayList<Descuento> arrayde(ArrayList<Descuento> descuentos, int[] ids) {
        ArrayList<Descuento> ret = new ArrayList<Descuento>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < descuentos.size(); j++) {
                if (descuentos.get(j).getId() == ids[i]) {
                    ret.add((Descuento) descuentos.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Descuento> convertir(Descuento[] array) {
        ArrayList<Descuento> ret = new ArrayList<Descuento>();
        for (Descuento t : array) {
            ret.add((Descuento) t);
        }
        return ret;
    }

    public static String codigoDescuentoAleatorio() {
        // El banco de caracteres
        String valoresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String codigo = "";
        for (int x = 0; x < 7; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, valoresValidos.length() - 1);
            char caracterAleatorio = valoresValidos.charAt(indiceAleatorio);
            codigo += caracterAleatorio;
        }
        return codigo;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }


    /*método toString*/
    @Override
    public String toString() {
        return "ID del descuento:" + id + "  Codigo del descuento:" + codigo + "  Cantidad descontada:" + cantidad + "€";
    }

}
