/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

import entidades.Compra;
import entidades.Concierto;
import entidades.Descuento;
import entidades.Gira;
import entidades.Reserva;
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
        ArrayList<Compra> compras = new ArrayList<Compra>();//Se cargan todos los compras que hay en utilidades en la variable compras(que es un arrayList que se puede modificar)
        compras = Compra.todascompras();
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();//Se cargan todos los reservas que hay en utilidades en la variable reservas(que es un arrayList que se puede modificar)
        reservas = Reserva.todasReservas();
        ArrayList<Descuento> descuentos = new ArrayList<Descuento>();//Se cargan todos los descuentos que hay en utilidades en la variable descuentos(que es un arrayList que se puede modificar)
        usuarios = Usuario.todosUsuarios();

        
        
        Usuario usuariologeado = new Usuario();//Creo dos variables para guardar en una los datos del usuario que inicia sesion para asi compararlo con la pseudo base de datos y ver que ese usuario ya tiene cuenta para poder iniciar sesion
        Usuario usuarioregistrado = new Usuario();//y en la otra el usuario registrado para posterior compararle con los que ya tenemos y asi ver que no exista ya un usuario con esos datos

        boolean sinusuario = false;
        int opcion = -1, numerodeusuario = 0;//La variable opcion servira para moverse por todo el menu con los do while

        do {

            opcion = menuRegistroIniciosesion();

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

                            opcion = submenuRegistro();

                            if (opcion == 0) {//Si la opcion es salir del programa se saldra del programa
                                return;

                            }
                        }
                        break;

                    case 2://El caso dos es que inicie sesion por que el usuarion ya tiene una cuenta,bien por que se la acabe de crear o bien por que ya la tenia creada 

                        usuariologeado = Usuario.inicioSesion(usuarios);//En la variable usuariologeado se guardara un usuario nuevo el cual sera con el que se loguea por teclado
                        if (usuariologeado == null) {//Si esta variable devuelve null es por que el usuario quiere salirse del prgrama y es lo que conseguira
                            return;

                        } else {
                            System.out.println("Usuario encontrado,bienvenido " + usuariologeado.getNombre() + " " + usuariologeado.getApellido());
                            opcion = 20;//Se le pone una opcion que no sea 1 o 2 para que salga del menu de registro inicio de sesion

                        }
                        break;

                }
            } while ((opcion == 1) || (opcion == 2));

            do {//Una vez se haya registrado o iniciado sesion , se le enselara el menu para que elija que desea

                opcion = menuInicio();

                switch (opcion) {

                    case 0:

                        System.out.println("Ha sido un placer, hasta la proxima ·_· ");//En caso de la opcion ser 0 se saldra del programa mostrando el siguiente mensaje
                        return;

                    case 1://Gestion del usuario en la cual se podra ver el listado de usuarios registrados asi como buscar uno en concreto,ver su propio usuario pudiendo editarle o borrarle si quisiera

                        do {//Este do while es el menu de gestion de usuarios, cada vez que el usuario quiera volver a la gestion de usuairos se realizara entero

                            opcion = menuGestionUsuarios();

                            switch (opcion) {

                                case 0://Se volvera al menu principal

                                    opcion = 0;

                                    break;

                                case 1://En el caso 1 se le muestra todos los usuarios por pantalla con sus datos 

                                    Usuario.mostrarUsuarios(usuarios);

                                    break;

                                case 2:

                                    do {

                                        opcion = menuBusquedaUsuario();

                                        switch (opcion) {

                                            case 1:

                                                opcion = Usuario.buscarUsuariosID(usuarios);

                                                break;

                                            case 2:

                                                opcion = Usuario.buscarUsuarioNIF(usuarios);

                                                break;
                                        }
                                    } while (opcion == 1);
                                    break;

                                case 3:

                                    do {

                                        opcion = menuGestionartuUsuario(usuariologeado);

                                        switch (opcion) {

                                            case 1:

                                                opcion = Usuario.editartuUsuario(usuarios, usuariologeado);

                                                break;

                                            case 2:

                                                opcion = menuEliminarUsuario();

                                                if (opcion == 1) {
                                                    sinusuario = true;
                                                    usuarios.remove(numerodeusuario);

                                                } else {
                                                    sinusuario = false;

                                                }
                                                break;

                                        }

                                        if (!sinusuario) {

                                        }

                                    } while ((opcion == 1) && (!sinusuario));
                                    break;

                            }

                            if ((opcion != 0) && (!sinusuario)) {//Esto es para volver al menu de gestion de usuarios para ello el usuario no tiene que borrar su usuario y no le ha tenido que dar a volver al menu de inicio

                                opcion = volverGestionUusairos();

                                if (opcion == 0) {
                                    return;

                                }
                            }
                        } while ((opcion == 1) && (!sinusuario));
                        break;

                    case 2:

                        break;
                }

                volverIniciooRegistro(opcion, sinusuario);

            } while ((opcion == 0) && (!sinusuario));//Si la opcion es distinta a 1,2 o 3 se le volvera a preguntar al usuario
        } while (sinusuario);
    }

    //
    //
    //
    //
    public static int menuRegistroIniciosesion() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {//Antes de todo el programa el usuario tendra que identificarse para poder hacer todo lo que tiene que ver con el programa,en caso de que tenga cuenta solo tendra que introducir sus credenciales 
            //y en caso de que no tenga cuenta tendra que crearse una reggistrandose para posteriormente iniciar sesion con esa cuenbta que ha creado
            System.out.print("Para poder hacer una consulta necesitas ser usuario con cuenta.\nNo tiene cuenta y desea registrarse(pulse 1) \nYa tiene una cuenta y desea iniciar sesion(pulse 2)\nSalir del programa(pulse 0)\n(0,1 o 2): ");
            opcion = in.nextInt();//Se le muestra al usuario el menu de registros e inicios de sesion y le obliga a introducir que quiere hacer
            System.out.println("");

            if ((opcion < 0) || (opcion > 2)) {
                System.out.println("Valor invalido,por fsavor introduzcalo de nuevo\n");///En caso de valor invalido se muestra el siguiente mensaje

            }

        } while ((opcion < 0) || (opcion > 2));//En caso de que lo que meta el usuario por teclado sea diferente a 0,1 o 2 se le volvera a preguntar
        return opcion;
    }

    public static int submenuRegistro() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {//Posteriormente s ele muestra otro minimenu en el cual le dan la opciuon al usuario de regitrar otra cuenta(por ejemplo la de un familiar),iniciar sesion o salir del programa

            System.out.print("Desea registrar otro usuario(pulse 1),iniciar sesion(pulse 2) o desea salirse del programa(pulse 0)\n(0,1 o 2): ");
            opcion = in.nextInt();

            if ((opcion < 0) || (opcion > 2)) {
                System.out.println("Opcion no valida,vuelve a introducirla\n");//Si la opcion no es ni 1,2 o 0 se mostrara el siguiente mensaje

            }

        } while ((opcion < 0) || (opcion > 2));//Si la opcion no es ninguna de esas tres se sale del programa
        return opcion;
    }

    public static int menuInicio() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.println("¿Hola que desea?");
            System.out.print("1)Gestion de Usuarios\n2)Gestion de Conciertos\n3)Gestion de Entradas\n0)salir del programa\n(0,1,2 o 3):");//Se le muestra al usuario el menu
            opcion = in.nextInt();//El usuario introducira la opcion que quiere

            if ((opcion < 0) || (opcion > 3)) {
                System.out.println("Opcion no valida,vuelve a introducirla\n");//Si la opcion no es ni 1,2 o 3 se mostrara el siguiente mensaje

            }

        } while ((opcion < 0) || (opcion > 3));
        return opcion;
    }

    public static int menuGestionUsuarios() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.println("\nEstas en la opcion de gestion de usuarios,que desea");
            System.out.print("1)Ver todos los Usuarios registrados\n2)Buscar un usuario en concreto y verlo\n3)Gestionar tu usuario\n0)Volver al menu de inicio\n(0,1,2 o 3): ");
            opcion = in.nextInt();

            if ((opcion < 0) || (opcion > 3)) {
                System.out.println("Opcion no valida,vuelve a introducirla\n");//Si la opcion no es ni 1,2 o 3 se mostrara el siguiente mensaje

            }

        } while ((opcion < 0) || (opcion > 3));
        return opcion;
    }

    public static int menuBusquedaUsuario() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.print("Las opciones de busqueda son:\n1)Por el id de usuario\n2)Por el NIF\n(1 o 2): ");
            opcion = in.nextInt();

            if ((opcion != 1) && (opcion != 2)) {

                System.out.println("La opcion introducida es inavalida, por favor vuelva a introducirla");
            }

        } while ((opcion != 1) && (opcion != 2));

        return opcion;
    }

    public static int menuGestionartuUsuario(Usuario usuariologeado) {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.println("Su usuario es " + usuariologeado.getId() + " " + usuariologeado);
            System.out.println("Quiere editar su usuario(pulse 1)\nQuiere eliminar su usuario(pulse 2)");
            opcion = in.nextInt();

            if ((opcion != 1) && (opcion != 2)) {
                System.out.println("Opcion no valida,por favor vuelve a introducirla");

            }

        } while ((opcion != 1) && (opcion != 2));
        return opcion;
    }

    public static int menuEliminarUsuario() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.println("¿Esta segiro de que quiere eliminar su usuario? Si(pulse 1) o No(pulse 0)");
            opcion = in.nextInt();

            if ((opcion != 1) && (opcion != 0)) {

                System.out.println("Opcion no valida,por favor vuelve a introducirla");
            }

        } while ((opcion != 1) && (opcion != 0));
        return opcion;
    }

    public static int volverGestionartuUsuario() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.println("¿Desea realizar algo mas relacionado con su usuario?\nSi(Pulse 1) o No(Pulse 0): ");
            opcion = in.nextInt();

            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("Opcion no valida,por favor vuelve a introducirla");

            }

        } while ((opcion != 1) && (opcion != 0));

        if (opcion == 0) {
            opcion = 2;

        }
        return opcion;
    }

    public static int volverGestionUusairos() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.print("Desea volver al registro de usuarios(pulse 1) o desea salir del programa(pulse 0)\n(0 o 1): ");
            opcion = in.nextInt();

            if ((opcion < 0) || (opcion > 1)) {
                System.out.println("Valor invalido,Introduzcalo de nuevo");

            }

        } while ((opcion < 0) || (opcion > 1));
        return opcion;
    }

    public static void volverIniciooRegistro(int opcion, boolean sinusuario) {

        if (opcion == 0) {
            System.out.println("Has vuelto al menu principal");//Si se vuelve al menu desde cualquier submenu se mostrara el siguiente mensaje y volvera a mostrarle al usuario el menu principal

        } else if (sinusuario) {
            System.out.println("Le sera devuelto al menu de registro y de inicio de sesion ya que necesita ser usuario para estar en el programa");

        }

    }

}
