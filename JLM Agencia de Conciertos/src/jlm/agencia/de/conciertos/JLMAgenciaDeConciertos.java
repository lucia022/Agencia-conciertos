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
     *
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//Se cargan todos los usuarios que hay en utilidades en la variable usuarios(que es un arrayList que se puede modificar)
        usuarios = Usuario.todosUsuarios();

        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();

        Usuario usuariologeado = new Usuario();//Creo dos variables para guardar en una los datos del usuario que inicia sesion para asi compararlo con la pseudo base de datos y ver que ese usuario ya tiene cuenta para poder iniciar sesion
        Usuario usuarioregistrado = new Usuario();//y en la otra el usuario registrado para posterior compararle con los que ya tenemos y asi ver que no exista ya un usuario con esos datos

        boolean sinusuario = false, encontrado = false;
        int opcion = -1, numerodeusuario = 0;//La variable opcion servira para moverse por todo el menu con los do while

        do {

            opcion = menuRegistroIniciosesion();//Al usuario se le mostrara un menu para que elija que quiere hacer,registrarse,iniciar sesion o salir del menu

            do {//Una vez se sepa que quiere hacer tendra tres opciones
                switch (opcion) {

                    case 0://El caso 0 es que se salga del programa y muestre el siguiente mensaje

                        System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.");

                        return;

                    case 1://El caso 1 es que se registra con una nueva cuenta añadiendo esa cuenta a la lista de usuarios que ya tenemos

                        usuarioregistrado = Usuario.registrousuario(usuarios);//Se crea un usuario dentro de los parametros establecidos

                        if (usuarioregistrado == null) {//Si lo que retorna de nuevousuario es null es por que desde la funcion nuevousuario el usuairo metio por teclado que queria salirse del programa y es lo que hara
                            return;

                        } else {//Sino retornara un objeto entero(un nuevo usuario con todos sus datos)
                            System.out.println("Su USUARIO ha sido registrado correctamente");//Se muestra el siguiente mensaje y se añade el nuevo usuario al arrayList de usuairos
                            usuarios.add(usuarioregistrado);

                            opcion = submenuRegistro();//Se le mostrara un submenu, el cual servira para preguntarle si quiere registrar otro usuairo,iniciar sesion o salir del programa

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
                            System.out.println("Usuario encontrado,BIENVENIDO " + usuariologeado.getNombre() + " " + usuariologeado.getApellido());
                            opcion = 20;//Se le pone una opcion que no sea 1 o 2 para que salga del menu de registro inicio de sesion

                        }
                        break;

                }
            } while ((opcion == 1) || (opcion == 2));

            do {//Una vez se haya registrado o iniciado sesion , se le enselara el menu para que elija que desea

                opcion = menuInicio();//Se le muestra al usuairo un menu de inicio para que elija que desea hacer en el programa

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

                                case 1://En el caso 1 se le muestra todos los usuarios por pantalla con sus datos,asi como las compras y reservas que ha realizado

                                    Usuario.mostrarUsuariosbasico(usuarios);

                                    System.out.print("¿Quiere ver informacion mas detallada de los usuario?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
                                    opcion = in.nextInt();

                                    if (opcion == 0) {
                                        opcion = 1;

                                    } else {

                                    do{    
                                        Usuario verdetallado = new Usuario();
                                        verdetallado = Usuario.buscarUsuariosID(usuarios);

                                        if (verdetallado == null) {//Si lo que retorna la anterior funcion es nulo significa que no se ha encontrado ninguna coincidencia y por lo tanto no hay ningun usuairo con ese id

                                            do {

                                                in = new Scanner(System.in);
                                                System.out.print("No existe ningun uduario con ese id,¿quiere buscar otro?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");//Se le dira al usuairo que no existe nadie con ese id y le pregunta que si quiere volver a buscar
                                                opcion = in.nextInt();

                                                if ((opcion != 0) && (opcion != 1)) {

                                                    System.out.println("Opcion no valida,por favor vuelve a introducirla");//Si la opcion es incorrecta se le muestra el siguiente mensaje
                                                }

                                            } while ((opcion != 0) && (opcion != 1));

                                            if (opcion == 0) {
                                                opcion = 2;
                                            }
                                        } else {

                                            Usuario.mostrarUsuariocompleto(verdetallado);

                                            do {

                                                in = new Scanner(System.in);
                                                System.out.print("¿Desea realizar otra busqueda?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");//Se le pregutnara al usuairo si nquiere buscar algun otro usuairo
                                                opcion = in.nextInt();

                                                if ((opcion != 0) && (opcion != 1)) {
                                                    System.out.println("Opcion no valida,por favor vuelve a introducirla");

                                                }

                                            } while ((opcion != 1) && (opcion != 0));

                                            if (opcion == 0) {
                                                opcion = 2;

                                            }
                                        }
                                    }while(opcion == 1);

                                    }
                                    break;

                                case 2://En el caso 2 se le dara la opcion al usuario de buscar un usuario en concreto mediante su id o su nif

                                    do {//Este do while se realizara siempre que el usuario quiera buscar otro usuario

                                        opcion = menuBusquedaUsuario();//Se le pregunta si quiere realizar la busqueda por nif o por id

                                        switch (opcion) {

                                            case 1://El caso 1 busca un usuario por id

                                                Usuario usuariobuscadoporid = Usuario.buscarUsuariosID(usuarios);//Se declara un usuario en el cual se guardara el usuario buscado,una vez hecho se llama a la funcion buscar por id

                                                if (usuariobuscadoporid == null) {//Si lo que retorna la anterior funcion es nulo significa que no se ha encontrado ninguna coincidencia y por lo tanto no hay ningun usuairo con ese id

                                                    do {

                                                        in = new Scanner(System.in);
                                                        System.out.print("No existe ningun uduario con ese id,¿quiere buscar otro?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");//Se le dira al usuairo que no existe nadie con ese id y le pregunta que si quiere volver a buscar
                                                        opcion = in.nextInt();

                                                        if ((opcion != 0) && (opcion != 1)) {

                                                            System.out.println("Opcion no valida,por favor vuelve a introducirla");//Si la opcion es incorrecta se le muestra el siguiente mensaje
                                                        }

                                                    } while ((opcion != 0) && (opcion != 1));

                                                    if (opcion == 0) {
                                                        opcion = 2;
                                                    }
                                                } else {

                                                    System.out.println("El usuario que buscas es " + usuariobuscadoporid);//Si lo que retorna no es nulo,significa que ha encontrado un usuario con ese id

                                                    do {

                                                        in = new Scanner(System.in);
                                                        System.out.print("¿Desea realizar otra busqueda?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");//Se le pregutnara al usuairo si nquiere buscar algun otro usuairo
                                                        opcion = in.nextInt();

                                                        if ((opcion != 0) && (opcion != 1)) {
                                                            System.out.println("Opcion no valida,por favor vuelve a introducirla");

                                                        }

                                                    } while ((opcion != 1) && (opcion != 0));

                                                    if (opcion == 0) {
                                                        opcion = 2;

                                                    }
                                                }

                                                break;

                                            case 2://idem al buscar por id pero con un NIF(string) 

                                                Usuario usuariobuscadopornif = Usuario.buscarUsuarioNIF(usuarios);

                                                if (usuariobuscadopornif == null) {
                                                    do {

                                                        in = new Scanner(System.in);
                                                        System.out.print("No existe ningun uduario con ese NIF,¿quiere buscar otro?\nPulse para 1 SI\nPulse 0 para NO\n(0 o 1): ");
                                                        opcion = in.nextInt();

                                                        if ((opcion != 0) && (opcion != 1)) {
                                                            System.out.println("Opcion no valida,por favor vuelve a introducirla");

                                                        }

                                                    } while ((opcion != 0) && (opcion != 1));

                                                    if (opcion == 0) {
                                                        opcion = 2;

                                                    }

                                                } else {

                                                    System.out.println("El usuario que buscas es " + usuariobuscadopornif);

                                                    do {

                                                        in = new Scanner(System.in);
                                                        System.out.print("¿Desea realizar otra busqueda?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
                                                        opcion = in.nextInt();

                                                        if ((opcion != 0) && (opcion != 1)) {
                                                            System.out.println("Opcion no valida,por favor vuelve a introducirla");

                                                        }

                                                    } while ((opcion != 1) && (opcion != 0));

                                                    if (opcion == 0) {
                                                        opcion = 2;

                                                    }
                                                }

                                                break;
                                        }
                                    } while (opcion == 1);//Si el usuario una vez haya buscado introduce que quiere buscar otro usuairo se volvera a realizar una busqueda
                                    break;

                                case 3://La opcion 3 sera la gestion de tu propio usuairo en la cual podras editarle y borrarle

                                    do {

                                        opcion = menuGestionartuUsuario(usuariologeado);//Se le muestra un minimenu preguntando si quiere editar o borrar

                                        switch (opcion) {

                                            case 1://En caso de querer editar

                                                Usuario usuarioeditado;

                                                do {

                                                    numerodeusuario = Usuario.numeroUsuariologeado(usuarios, usuariologeado);

                                                    System.out.println("Introduzca de nuevo sus datos para poder editarlos");
                                                    usuarioeditado = Usuario.usuarioEditado(usuariologeado);

                                                    do {

                                                        System.out.print("¿Son estos los datos correctos?\n" + usuarioeditado + "\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
                                                        opcion = in.nextInt();

                                                        if ((opcion != 1) && (opcion != 0)) {
                                                            System.out.println("Opcion no valida,por favor vuelve a introducirla");

                                                        }

                                                    } while ((opcion != 1) && (opcion != 0));

                                                    if (opcion == 1) {
                                                        System.out.println("Su usuario se ha editado correctamente");
                                                        usuarios.set(numerodeusuario, usuarioeditado);
                                                        opcion = 0;

                                                    } else {

                                                        do {
                                                            System.out.println("¿Quiere volver a intentar meter los datos para editar su usuario?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
                                                            opcion = in.nextInt();

                                                            if ((opcion != 1) && (opcion != 0)) {
                                                                System.out.println("Opcion no valida,por favor vuelve a introducirla");

                                                            }

                                                        } while ((opcion != 0) && (opcion != 1));

                                                    }

                                                } while (opcion == 1);

                                                break;

                                            case 2://En caso de querer borrar

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

                                            opcion = volverGestionartuUsuario();

                                        }

                                    } while ((opcion == 1) && (!sinusuario));
                                    break;

                            }

                            if ((opcion != 0) && (!sinusuario)) {//Esto es para volver al menu de gestion de usuarios para ello el usuario no tiene que borrar su usuario y no le ha tenido que dar a volver al menu de inicio

                                opcion = volverGestionUusairos();//Se le muestra un menu para pregutarle si quiere volver a la gestion de usuairos o salir del programa

                                if (opcion == 0) {
                                    return;

                                }
                            }
                        } while ((opcion == 1) && (!sinusuario));
                        break;

                    case 2: //AQUÍ COMIENZA LA GESTION DE CONCIERTOS
                        System.out.println("¿Qué desea?");
                        System.out.println("Pulse 1 para ver giras");
                        System.out.println("Pulse 2 para ver conciertos");
                        System.out.println("Pulse 3 para nuevo concierto");
                        opcion = in.nextInt();
                        
                        ArrayList<Concierto> todosconciertos = new ArrayList<Concierto>();
                        Concierto concierto;
                        
                        switch (opcion) {
                            case 1:
                                break;
                            case 2:
                                todosconciertos = Concierto.todosconciertos();
                                System.out.println(todosconciertos);
                                break;
                            case 3:
                                concierto = Concierto.nuevoConcierto();
                                break;
                        }
                        break;
                }

                volverIniciooRegistro(opcion, sinusuario);//Son mensajes que se mostrtarian en pantalla dependiendo los parametros que se le pasen

            } while ((opcion == 0) && (!sinusuario));//Si la opcion es 0  y existe el usuairo se vuelve al menu principal
        } while (sinusuario);//Si no existe usuario se vuelve al registro de usuarios
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
            System.out.println("Bienvenido a la AGENCIA CONCIERTOS JML");
            System.out.print("Para poder hacer una consulta necesitas ser usuario con cuenta.\nPulse 1 para CREAR CUENTA(registrarte) \nPulse 2 para INICIAR SESION\nPulse 0 para SALIR DEL PROGRAMA\n(0,1 o 2): ");
            opcion = in.nextInt();//Se le muestra al usuario el menu de registros e inicios de sesion y le obliga a introducir que quiere hacer
            System.out.println("");

            if ((opcion < 0) || (opcion > 2)) {
                System.out.println("Valor invalido,por favor introduzcalo de nuevo\n");///En caso de valor invalido se muestra el siguiente mensaje

            }

        } while ((opcion < 0) || (opcion > 2));//En caso de que lo que meta el usuario por teclado sea diferente a 0,1 o 2 se le volvera a preguntar
        return opcion;
    }

    public static int submenuRegistro() {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {//Posteriormente s ele muestra otro minimenu en el cual le dan la opciuon al usuario de regitrar otra cuenta(por ejemplo la de un familiar),iniciar sesion o salir del programa

            System.out.print("Pulse 1 para REGISTRAR OTRO USUARIO\nPulse 2 para INICIAR SESION\nPulse 3 para SALIR DEL PROGRAMA\n(0,1 o 2): ");
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

            System.out.println("Esta en el MENU PRINCIPAL");
            System.out.print("Pulse 1 para GESTIONAR USUARIOS\nPulse 2 para GESTIONAR CONCIERTOS\nPulse 3 para GESTIONAR ENTRADAS\nPulse 0 para SALIR DEL PROGRAMA\n(0,1,2 o 3):");//Se le muestra al usuario el menu
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
            System.out.print("Pulse 1 para VER TODOS LOS USUARIOS\nPulse 2 para BUSCAR 1 USUARIO(por su NIF o id)\nPulse 3 para GESTIONAR TU USUARIO\nPulse 0 para VOLVER AL MENU INICI0\n(0,1,2 o 3): ");
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

            System.out.print("Las opciones de busqueda son:\nPulse 1 para BUSCAR POR ID\nPulse 2 para BUSCAR POR NIF\n(1 o 2): ");
            opcion = in.nextInt();

            if ((opcion != 1) && (opcion != 2)) {

                System.out.println("La opcion introducida es inavalida, por favor vuelva a introducirla");
            }

        } while ((opcion != 1) && (opcion != 2));

        return opcion;
    }

    public static long idabuscar() {

        Scanner in = new Scanner(System.in);
        long idbuscado;

        do {

            System.out.println("Introduzca el id del usuario a buscar");
            idbuscado = in.nextLong();

            if ((idbuscado <= 0)) {
                System.out.println("El valor introducido no es valido pusto que es menor que 0");

            }

        } while (idbuscado <= 0);

        return idbuscado;
    }

    public static int menuGestionartuUsuario(Usuario usuariologeado) {

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {

            System.out.println("Su usuario es " + usuariologeado.getId() + " " + usuariologeado);
            System.out.print("Pulse 1 para EDITAR SU USUARIO\nPulse 2 para ELIMINAR SU USUAIRO\n(1 o 2): ");
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

            System.out.print("¿Esta segiro de que quiere eliminar su usuario?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
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

            System.out.print("¿Desea realizar algo mas relacionado con su usuario?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
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

            System.out.print("Pulse 1 para VOLVER MENU GESTION DE USUARIOS \nPulse 0 para SALIR DEL PROGRAMA\n(0 o 1): ");
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
