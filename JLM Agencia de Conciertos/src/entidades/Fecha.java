/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Fecha {
    
    public static java.util.Date dameFecha() throws ParseException {

        java.util.Date fechaDate;//En esta variable se pasara el String
        boolean fallo = false;

        do {    //Hay que decir que en caso de no introducir las / dara error y el prgrama cascara,sin embargo en caso de introducir las 3/ y estas estar incomploetas como 2/1/200 el programa volvera a pedir la fecha

            Scanner in = new Scanner(System.in);
            System.out.print("Introduzca la fecha con formato dd/mm/yyyy: "); //Se intriduce la fecha con el formato pedid y se guarda en un string
            String fechaString = in.nextLine();
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy"); //nueva fecha con formato simple

            fechaDate = dateformat.parse(fechaString); //Con el metodo parse se pasa de string a date

            if (!(dateformat.format(fechaDate).equals(fechaString))) {//Si el formato esta mal sera invalida
                System.out.println("Error,ese formato no es valido\nPor favor introduzcala de nuevo");
                continue;
            }

            System.out.println("La fecha es: " + fechaDate);//Nos dice cual es la fecha

            System.out.println("¿Es esta la fecha?(true en caso afirmativo,false en caso negativo)");//pregunta si la fecha es esa
            fallo = in.nextBoolean();

            if (fallo == false) {
                System.out.println("Vale,entonces introduzcala de nuevo");//En caso negativo mostrara este mensaje
            }
        } while (fallo == false);

        return fechaDate;
    }
}
