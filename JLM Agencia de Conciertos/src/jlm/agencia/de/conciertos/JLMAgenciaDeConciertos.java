/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

import entidades.Usuario;
import entidades.Utilidades;
import java.text.ParseException;
import java.util.ArrayList;
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

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//Se cargan todos los usuarios que hay en utilidades en la variable usuarios
        usuarios = Usuario.todosUsuarios();

        Scanner in = new Scanner(System.in);
        Usuario usuariologeado = new Usuario();
        int opcion;

        do {
            System.out.print("Para poder hacer una consulta necesitas ser usuario con cuenta.\nNo tiene cuenta y desea registrarse(1) \nYa tiene una cuenta y desea iniciar sesion(2)\nSalir del programa(0)\n(0,1 o 2): ");
            opcion = in.nextInt();
            System.out.println("");

            switch (opcion) {

                case 0:
                    System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.");
                    return;

                case 1:

                    boolean fallo = false;
                    do {
                        System.out.println("Bienvenido al registro de usuario,para registrarse de la siguiente informacion");
                        usuariologeado = Usuario.nuevoUsuario();
                        
                        for (int i = 0; i < usuarios.size(); i++) {

                            
                            fallo = false;
                            if (usuariologeado.getNif().equals(usuarios.get(i).getNif())) {
                                fallo = true;
                                System.out.println("Ese NIF ya esta siendo utilizado por otro usuario,por favor introduzca datos verdaderos");
                            }

                            if (usuariologeado.getEmail().equals(usuarios.get(i).getEmail())) {
                                fallo = true;
                                System.out.println("Ese email ya esta siendo utilizado por otro usuario,por favor introduzca datos verdaderos");
                            }

                        }
                    } while (fallo);
                    System.out.println("Su usuario ha sido registrado correctamente");
                    usuarios.add(usuariologeado);
                    break;

                case 2:
                    
                    System.out.println("Bienvenido al inicio de sesion de usuario,introduzca sus datos");
                    Usuario iniciodesesion = new Usuario();
                    iniciodesesion = Usuario.inicioSesion();
                    
                    
                    
                    break;

            }
        } while ((opcion < 0) || (opcion > 2));

        do {
            in = new Scanner(System.in);
            System.out.println("¿Hola que desea?");
            System.out.print("1)Gestion de Usuarios\n2)Gestion de Conciertos\n3)Gestion de Entradas\n0)salir del programa\n(0,1,2 o 3):");//Se le muestra al usuario el menu
            opcion = in.nextInt();//El usuario introducira la opcion que quiere

            switch (opcion) {

                case 0:
                    System.out.println("Ha sido un placer, hasta la proxima ·_· ");//En caso de la opcion ser 0 se saldra del programa mostrando el siguiente mensaje
                    return;

                case 1://Gestion del usuario en la cual se podra ver el listado de usuarios registrados asi como buscar uno en concreto

                    do {
                        in = new Scanner(System.in);
                        System.out.println("\nEstas en la opcion de gestion de usuarios,que desea");
                        System.out.println("1)Ver todos los Usuarios registrados\n2)Buscar un usuario en concreto\n0)Volver al menu de inicio");
                        opcion = in.nextInt();

                        switch (opcion) {

                            case 0://Se volvera al menu principal
                                break;

                            case 1:

                                System.out.println("El total de usuario es de " + Utilidades.USUARIOS.length + " y son los siguientes:");
                                for (int i = 0; i < usuarios.size(); i++) {

                                    System.out.println("Usuario Nº" + (i + 1) + " " + usuarios.get(i));

                                }

                                do {
                                    in = new Scanner(System.in);
                                    System.out.println("Desea volver al menu principal(0) o desea salir del programa(1)");
                                    opcion = in.nextInt();

                                    if ((opcion < 0) || (opcion > 1)) {

                                        System.out.println("Valor invalido,Introduzcalo de nuevo");
                                    }
                                } while ((opcion < 0) || (opcion > 1));

                                break;

                            case 2:

                                do {
                                    in = new Scanner(System.in);
                                    System.out.print("Las opciones de busqueda son:\n1)El id de usuario\n2)El NIF\n");
                                    opcion = in.nextInt();
                                    switch (opcion) {

                                        case 1:
                                            in = new Scanner(System.in);
                                            int idbuscado;
                                            boolean encontradoid = false;
                                            System.out.println("Introduzca el id del usuario a buscar");
                                            idbuscado = in.nextInt();

                                            for (int i = 0; i < usuarios.size(); i++) {

                                                if (usuarios.get(i).getId() == idbuscado) {
                                                    System.out.println("El usuario que buscas es " + usuarios.get(i));
                                                    encontradoid = true;
                                                    break;

                                                }

                                            }
                                            if (!encontradoid) {
                                                do {
                                                    in = new Scanner(System.in);
                                                    System.out.print("No existe ningun uduario con ese id,¿quiere buscar otro?(0.SI/1.NO): ");
                                                    opcion = in.nextInt();
                                                } while ((opcion < 0) || (opcion > 1));
                                            }
                                            break;

                                        case 2:
                                            in = new Scanner(System.in);
                                            String nifusuario = "";
                                            boolean encontradonif = false,
                                             fallo;

                                            do {    //Pedira un nif(String) el cual no podra quedar vacio nI contener mas ni menos de 9 caracteres o se volvera a pdeir el nif hasta que esto sea cierto
                                                //Ademas tendra que ser de la siguiente manera 8 numeros y 1 letra en mayusculas o volvera a pedir al usuario
                                                in = new Scanner(System.in);
                                                String numeros = "", letra = "";

                                                System.out.print("Introduzca el NIF del usuario a buscar: "); //Se pedira el NIF
                                                nifusuario = in.nextLine();//El usuario introduce el NIF

                                                if (nifusuario.length() != 9) {
                                                    fallo = true;
                                                    System.out.println("NIF invalido por no ser de 9 caracteres,por favor introduzcalo de nuevo");//En caso de tener mas de 9 o menos de 90 caracteres saldra el siguiente mensaje
                                                    continue;

                                                } else {//Una vez se sabe que tiene 9 caracteres se mirara si el formato es el correcto teniendo 8 numeros y despues una letra mayuscula

                                                    //Para empezar separamos en dos String uno en el que deberian estar los numeros y el otro la letra
                                                    for (int i = 0; i < nifusuario.length() - 1; i++) {//Con un ciclo metemos los priemros 8 caractertes en la variable numeros
                                                        numeros += nifusuario.charAt(i);

                                                    }
                                                    letra += nifusuario.charAt(8);//Y el ultimo caracter lo añadimos a letra
                                                    nifusuario = numeros + letra;//Componemos el nif con estos dos variables

                                                    if ((numeros.matches("[0-9]*")) && (letra.matches(".*[A-Z].*"))) {//Y nos aseguramos que en la variable numeros solo haya numeros y en la letra una letra mayuscula.
                                                        fallo = false;   //En caso positivo se saldra del ciclo y continuara el programa

                                                    } else {
                                                        System.out.println("El formato indicado no es correcto,introduzcalo de nuevo con formato valido(8 numeros y 1 letra mayuscula,ejemplo 12345678L)");
                                                        fallo = true;   //Pero en caso de ser erroeno se volvera a pedir el NIF

                                                    }
                                                }
                                            } while (fallo); //Si el NIF esta vacio o este tiene mas o menos de 9 caractertes o tiene esos carcteres pero el formato no es el valido se volvera a pedir al usuario el NIF

                                            for (int i = 0; i < usuarios.size(); i++) {

                                                if (nifusuario.equals(usuarios.get(i).getNif())) {
                                                    System.out.println("El usuario que buscas es " + usuarios.get(i));
                                                    encontradonif = true;
                                                    break;

                                                }

                                            }
                                            if (!encontradonif) {
                                                do {
                                                    in = new Scanner(System.in);
                                                    System.out.print("No existe ningun uduario con ese NIF,¿quiere buscar otro?(0.SI/1.NO): ");
                                                    opcion = in.nextInt();
                                                } while ((opcion < 0) || (opcion > 1));
                                            }
                                            break;

                                    }
                                } while ((opcion < 1) || (opcion > 2));

                                do {
                                    System.out.println("Desea volver al menu principal(0) o desea salir del programa(1)");
                                    opcion = in.nextInt();

                                    if ((opcion < 0) || (opcion > 1)) {

                                        System.out.println("Valor invalido,Introduzcalo de nuevo");
                                    }
                                } while ((opcion < 0) || (opcion > 1));

                                break;
                        }

                        if ((opcion != 1) && (opcion != 2) && (opcion != 0)) {
                            System.out.println("Opcion no valida,vuelve a introducirla\n");

                        }

                    } while ((opcion != 1) && (opcion != 2) && (opcion != 0));

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
