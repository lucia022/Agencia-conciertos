/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class JLMAgenciaDeConciertos {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        int opcion;

        do {
            Scanner in = new Scanner(System.in);
            System.out.println("¿Hola que desea?");
            System.out.print("1)Gestion de Usuarios\n2)Gestion de Conciertos\n3)Gestion de Entradas\n0)salir del programa\n(0,1,2 o 3):");//Se le muestra al usuario el menu
            opcion = in.nextInt();//El usuario introducira la opcion que quiere

            switch (opcion) {

                case 0:
                    System.out.println("Ha sido un placer, hasta la proxima ·_· ");//En caso de la opcion ser 0 se saldra del programa mostrando el siguiente mensaje
                    return;

                case 1://Gestion del usuario en la cual se podra ver el listado de usuarios registrados asi como buscar uno en concreto

                    do {
                        
                        System.out.println("\nEstas en la opcion de gestion de usuarios,que desea");
                        System.out.println("1)Ver todos los Usuarios registrados\n2)Buscar un usuario en concreto\n0)Volver al menu de inicio");
                        opcion = in.nextInt();

                        switch (opcion) {

                            case 0://Se volvera al menu principal
                                break;

                            case 1:
                                
                                break;

                            case 2:

                                break;
                        }

                        if ((opcion != 1) && (opcion != 2) && (opcion != 0)) {
                            System.out.println("Opcion no valida,vuelve a introducirla\n");

                        }

                    } while ((opcion != 1) && (opcion == 2) && (opcion == 0));

                    break;

                case 2://Gestion de los conciertos

                    break;
                case 3://Gestion de las entradas

                    break;

            }
            if (opcion == 0) {
                System.out.println("Has vuelto al menu principal");//Si se vuelve al menu desde cualquier submenu se mostrara el siguiente mensaje y volvera a mostrarle al usuario el menu principal
                continue;
            }
            if ((opcion != 1) && (opcion != 2) && (opcion != 3) && (opcion != 0)) {
                System.out.println("Opcion no valida,vuelve a introducirla\n");//Si la opcion no es ni 1,2 o 3 se mostrara el siguiente mensaje

            }

        } while ((opcion != 1) && (opcion != 2) && (opcion != 3));//Si la opcion es distinta a 1,2 o 3 se le volvera a preguntar al usuario

    }
}
