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

        Scanner in = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//Se cargan todos los usuarios que hay en utilidades en la variable usuarios(que es un arrayList que se puede modificar)
        usuarios = Usuario.todosUsuarios();
        
        
        
        

        Usuario usuariologeado = new Usuario();//Creo dos variables para guardar en una los datos del usuario que inicia sesion para asi compararlo con la pseudo base de datos y ver que ese usuario ya tiene cuenta para poder iniciar sesion
        Usuario usuarioregistrado = new Usuario();//y en la otra el usuario registrado para posterior compararle con los que ya tenemos y asi ver que no exista ya un usuario con esos datos
        int opcion;//La variable opcion servira para moverse por todo el menu con los do while

        do {//Antes de todo el programa el usuario tendra que identificarse para poder hacer todo lo que tiene que ver con el programa,en caso de que tenga cuenta solo tendra que introducir sus credenciales 
            //y en caso de que no tenga cuenta tendra que crearse una reggistrandose para posteriormente iniciar sesion con esa cuenbta que ha creado
            System.out.print("Para poder hacer una consulta necesitas ser usuario con cuenta.\nNo tiene cuenta y desea registrarse(pulse 1) \nYa tiene una cuenta y desea iniciar sesion(pulse 2)\nSalir del programa(pulse 0)\n(0,1 o 2): ");
            opcion = in.nextInt();//Se le muestra al usuario el menu de registros e inicios de sesion y le obliga a introducir que quiere hacer
            System.out.println("");

            if ((opcion < 0) || (opcion > 2)) {
                System.out.println("Valor invalido,por fsavor introduzcalo de nuevo\n");///En caso de valor invalido se muestra el siguiente mensaje

            }

        } while ((opcion < 0) || (opcion > 2));//En caso de que lo que meta el usuario por teclado sea diferente a 0,1 o 2 se le volvera a preguntar

        do {//Una vez se sepa que quiere hacer tendra tres opciones
            switch (opcion) {

                case 0://El caso 0 es que se salga del programa y muestre el siguiente mensaje

                    System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.");

                    return;

                case 1://El caso 1 es que se registra con una nueva cuenta añadiendo esa cuenta a la lista de usuarios que ya tenemos

                    usuarioregistrado = Usuario.registrousuario(usuarios);//Se crea un usuario que nos servira para todo el prgrama

                    if (usuarioregistrado == null) {//Si lo que retorna de nuevousuario es null es por que desde la funcion nuevousuario el usuairo metio por teclado que queria salirse del programa y es lo que hara
                        return;

                    } else {//Sino retornara un objeto entero(un nuevo usuario con todos sus datos)
                        System.out.println("Su usuario ha sido registrado correctamente");//Se muestra el siguiente mensaje y se añade el nuevo usuario al arrayList de usuairos
                        usuarios.add(usuarioregistrado);

                        do {//Posteriormente s ele muestra otro minimenu en el cual le dan la opciuon al usuario de regitrar otra cuenta(por ejemplo la de un familiar),iniciar sesion o salir del programa
                            System.out.println("Desea registrar otro usuario(pulse 1),iniciar sesion(pulse 2) o desea salirse del programa(pulse 0)");
                            opcion = in.nextInt();

                        } while ((opcion != 0) && (opcion != 1) && (opcion != 2));//Si la opcion no es ninguna de esas tres se sale del programa

                        if (opcion == 0) {//Si la opcion es salir del programa se saldra del programa
                            return;
                            
                        }
                    }
                    break;

                case 2://El caso dos es que inicie sesion por que el usuarion ya tiene una cuenta,bien por que se la acabe de crear o bien por que ya la tenia creada 

                    usuariologeado = Usuario.inicioSesion(usuarios);//En la variable usuariologeado se guardara un usuario nuevo el cual sera con el que se loguea por teclado
                    if (usuariologeado == null) {//Si esta variable devuelve null es por que el usuario quiere salirse del prgrama y es lo que conseguira

                        return;
                    } 
                    System.out.println("Usuario encontrado,bienvenido " + usuariologeado.getNombre() + " " + usuariologeado.getApellido());
                    opcion = 20;
                    break;

            }
        } while ((opcion == 1) || (opcion == 2));


        /*do {
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
         */
    }
}
