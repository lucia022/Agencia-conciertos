/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

import dao.ActuacionDAO;
import dao.ArtistaDAO;
import dao.ConciertoDAO;
import dao.EntradaDAO;
import dao.GiraDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import entidades.Actuacion;
import entidades.Artista;
import entidades.Compra;
import entidades.Concierto;
import entidades.Descuento;
import entidades.Entrada;
import entidades.Fecha;
import entidades.Gira;
import entidades.Reserva;
import entidades.Usuario;
import entidades.Utilidades;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JLMAgenciaDeConciertos {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicio del MAIN
        ArrayList<Concierto> aLConcierto = new ArrayList<Concierto>();
        aLConcierto = Concierto.cargarConciertos();
        ArrayList<Artista> aLArtista = new ArrayList<Artista>();
        aLArtista = Artista.cargarArtistas();
        ArrayList<Actuacion> aLActuacion = new ArrayList<Actuacion>();
        aLActuacion = Actuacion.cargarActuaciones();
        ArrayList<Entrada> aLEntrada = new ArrayList<Entrada>();
        aLEntrada = Entrada.cargarEntradas();
        ArrayList<Gira> aLGira = new ArrayList<Gira>();
        aLGira = Gira.cargarGira();
        ArrayList<Reserva> aLReserva = new ArrayList<Reserva>();
        aLReserva = Reserva.cargarReservas();

        Calendar c = new GregorianCalendar();
        String diahoy = Integer.toString(c.get(Calendar.DATE));
        System.out.println(diahoy);

        Scanner in = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//Se cargan todos los usuarios que hay en utilidades en la variable usuarios(que es un arrayList que se puede modificar)
        UsuarioDAO u = new UsuarioDAO();
        usuarios = u.todosUsuarios();

        ArrayList<Entrada> entradas = new ArrayList<Entrada>();//Se cargan todos los usuarios que hay en utilidades en la variable usuarios(que es un arrayList que se puede modificar)
        EntradaDAO e = new EntradaDAO();
        entradas = e.todasEntradas();
        System.out.println(entradas);
        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();
        conciertos = Concierto.cargarConciertos();
        Usuario usuariologeado = new Usuario();//Creo dos variables para guardar en una los datos del usuario que inicia sesion para asi compararlo con la pseudo base de datos y ver que ese usuario ya tiene cuenta para poder iniciar sesion
        Usuario usuarioregistrado = new Usuario();//y en la otra el usuario registrado para posterior compararle con los que ya tenemos y asi ver que no exista ya un usuario con esos datos
        boolean sinusuario;//Variable en kla cual se guarda true en caso de que el usuario borre su usuario y false en caso de que el usuario siga existiendo
        int opcion = -1, opcion1 = -1, numerodeusuario = 0;//La variable opcion servira para moverse por todo el menu con los do while
        long idabuscar;

        //Aqui empieza el Registro de Usuario o Inicio de Sesion de Usuario
        do {
            opcion = menuRegistroIniciosesion();//Al usuario se le mostrara un menu para que elija que quiere hacer,registrarse,iniciar sesion o salir del menu
            do {//Este do while servira en caso de que uina vez haya registrado un nuevo usuario quiera iniciar sesion(le lleva directamente al inicio de sesion gracias a este do while)
                switch (opcion) {//Una vez se sepa que quiere hacer tendra tres opciones

                    case 0://El caso 0 es que se salga del programa y muestre el siguiente mensaje
                        System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.-.-");
                        return;

                    case 1://El caso 1 es que se registra con una nueva cuenta añadiendo esa cuenta a la lista de usuarios que ya tenemoS2
                        do {
                            boolean fallo = false;
                            System.out.println("\n--BIENVENIDO AL REGISTRO DE USUARIO--");//Le da la bienvenida al registro del usuario
                            usuarioregistrado = Usuario.nuevoUsuarioBasico();//Se le piden todos los datos basicos para realizar su registro
                            for (int i = 0; i < usuarios.size(); i++) {//Recorremos todos los usuarios de nuestra base de datos para ver si alguno coincide con nuestro usuario nuevo
                                System.out.println(i);
                                if (usuarioregistrado.getNif().equals(usuarios.get(i).getNif()) || usuarioregistrado.getEmail().equals(usuarios.get(i).getEmail())) {
                                    if (usuarioregistrado.getNif().equals(usuarios.get(i).getNif())) {
                                        System.out.println("Ese NIF ya esta siendo utilizado por otro usuario,por favor introduzca datos personales.");//Si coincide en el nif se muestra el siguiente mensaje
                                    }
                                    if (usuarioregistrado.getEmail().equals(usuarios.get(i).getEmail())) {
                                        System.out.println("Ese email ya esta siendo utilizado por otro usuario,por favor introduzca datos personales.");//Si coincide en el email se muestra el siguiente mensaje
                                    }
                                    System.out.println("");
                                    fallo = true;//Fallo sera declarado como verdadero
                                    break;//Se saldra del ciclo
                                }
                                opcion1 = 0;
                            }
                            if (fallo) {
                                opcion1 = falloRegistroUsuario();
                                if (opcion1 == 0) {
                                    System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.-.-");
                                    return;
                                }
                            }
                        } while (opcion1 == 1);//En caso de que un usuario ya exista se volvera a realizar una iteracion
                        //Aqui solo llegara en caso de que el usuario se haya registrado correctamente
                        System.out.println("Su USUARIO ha sido registrado correctamente");//Se muestra el siguiente mensaje y se añade el nuevo usuario al arrayList de usuairos
                        u.insertarUsuario(usuarioregistrado);
                        usuarios = u.todosUsuarios();
                        opcion = submenuRegistro();//Se le mostrara un submenu, el cual servira para preguntarle si quiere registrar otro usuairo,iniciar sesion o salir del programa
                        if (opcion == 0) {
                            System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.");
                            return;
                        }
                        break;

                    case 2://El caso dos es que inicie sesion por que el usuarion ya tiene una cuenta,bien por que se la acabe de crear o bien por que ya la tenia creada
                        String emailusuario,
                         nifusuario;
                        opcion = 0;
                        do {
                            System.out.println("\n--BIENVENIDO AL INICIO DE SESION--");//Se muestra el siguiente mensaje por pantalla
                            emailusuario = Usuario.pedirEmailValido();
                            System.out.println("");
                            nifusuario = Usuario.pedirNIFValido();
                            System.out.println("");
                            //Una vez tenemos el email y NIF los compararemos con los de la base de datos
                            int i;
                            for (i = 0; i < usuarios.size(); i++) {//Recorremos la base de datos
                                if ((emailusuario.equals(usuarios.get(i).getEmail())) && (nifusuario.equals(usuarios.get(i).getNif()))) {//Si el email y NIF coincide
                                    usuariologeado = usuarios.get(i);//Guardamos todos los datos bgasicos del usuairo de la base de datos en el nuevo objeto de usuario creado
                                    numerodeusuario = i;
                                    opcion1 = 0;
                                    break;
                                }
                            }
                            if (numerodeusuario != i) {
                                opcion1 = falloInicioSesion();
                                if (opcion1 == 0) {
                                    System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.-.-");
                                    return;
                                }
                            }
                        } while (opcion1 == 1);//Si es uno realiza una nueva iteracion intentando volver a meter los datos
                        System.out.println("Usuario encontrado,BIENVENIDO " + usuariologeado.getNombre().toUpperCase() + " " + usuariologeado.getApellido().toUpperCase());//Se le muestra su noimbre y apellido
                        break;
                }
            } while ((opcion == 1) || (opcion == 2));

            do {//Una vez se haya registrado o iniciado sesion , se le enselara el menu para que elija que desea
                sinusuario = false;
                opcion = menuInicio();//Se le muestra al usuairo un menu de inicio para que elija que desea hacer en el programa
                switch (opcion) {

                    case 0:
                        System.out.println("Ha sido un placer, hasta la proxima ·_· ");//En caso de la opcion ser 0 se saldra del programa mostrando el siguiente mensaje
                        return;

                    case 1://Gestion del usuario en la cual se podra ver el listado de usuarios registrados asi como buscar uno en concreto,ver su propio usuario pudiendo editarle o borrarle si quisiera
                        do {//Este do while es el menu de gestion de usuarios, cada vez que el usuario quiera volver a la gestion de usuarios se realizara entero
                            opcion = menuGestionUsuarios();//Se le muestra el menu de Gestion de Usuarios para que elija la opcion que prefiere
                            opcion1 = 1;
                            switch (opcion) {

                                case 0://Se volvera al menu principal
                                    opcion1 = 0;
                                    break;

                                case 1://En el caso 1 se le muestra todos los usuarios por pantalla con sus datos,asi como las compras y reservas que ha realizado
                                    Usuario.mostrarUsuariosbasico(usuarios);//Se le muestra por pantalla los datos basicos de todos los usuairos
                                    opcion = menuVerUsuarioDetallado();
                                    if (opcion == 1) {//En este caso se quiere ver los datos detallados
                                        do {
                                            Usuario verdetallado = new Usuario();
                                            idabuscar = idabuscar();
                                            verdetallado = Usuario.buscarUsuarioporID(usuarios, idabuscar);//Para ello buscamos por id el usuairo que queremos ver exactamente
                                            if (verdetallado == null) {//Si lo que retorna la anterior funcion es nulo significa que no se ha encontrado ninguna coincidencia y por lo tanto no hay ningun usuairo con ese id
                                                opcion = volverBuscarUsuarioporId();
                                            } else {//En caso de que no sea null sera que se ha encontrado el usuario buscado por id
                                                Usuario.mostrarUsuarioCompleto(verdetallado);//Y mediante la siguiente funcion se moistrara el usuario detallado
                                                opcion = buscarOtroUsuario();
                                            }
                                        } while (opcion == 1);//Si la opcion es 1 sera que quiere volver a buscar un usuario para verlo detallado
                                    }
                                    break;

                                case 2://En el caso 2 se le dara la opcion al usuario de buscar un usuario en concreto mediante su id o su nif
                                    do {//Este do while se realizara siempre que el usuario quiera buscar otro usuario
                                        opcion = menuBusquedaUsuario();//Se le pregunta si quiere realizar la busqueda por nif o por id
                                        switch (opcion) {

                                            case 1://El caso 1 busca un usuario por id
                                                idabuscar = idabuscar();
                                                Usuario usuariobuscadoporid = Usuario.buscarUsuarioporID(usuarios, idabuscar);//Se declara un usuario en el cual se guardara el usuario buscado,una vez hecho se llama a la funcion buscar por id
                                                if (usuariobuscadoporid == null) {//Si lo que retorna la anterior funcion es nulo significa que no se ha encontrado ninguna coincidencia y por lo tanto no hay ningun usuairo con ese id
                                                    opcion = volverBuscarUsuarioporId();
                                                } else {
                                                    System.out.println("\nEl usuario que buscas es " + usuariobuscadoporid);//Si lo que retorna no es nulo,significa que ha encontrado un usuario con ese id
                                                    opcion = buscarOtroUsuario();
                                                }
                                                break;

                                            case 2://idem al buscar por id pero con un NIF(string)
                                                String nifabuscar = Usuario.pedirNIFValido();
                                                Usuario usuariobuscadopornif = Usuario.buscarUsuarioporNIF(usuarios, nifabuscar);
                                                if (usuariobuscadopornif == null) {//Si lo que retorna la busqueda por nif es null,es que no existe ningun usuario con ese NIF
                                                    opcion = volverBuscarUsuarioporNIF();
                                                } else {//Si no retorna null es que si existe ese usuario con ese NIF
                                                    System.out.println("\nEl usuario que buscas es " + usuariobuscadopornif);//Se le mostrara el usuairo buscado
                                                    opcion = buscarOtroUsuario();//Se le pregunta si quiere buscar otro
                                                }
                                                break;
                                        }
                                    } while (opcion == 1);//Si el usuario una vez haya buscado introduce que quiere buscar otro usuario se volvera a realizar una busqueda
                                    break;

                                case 3://La opcion 3 sera la gestion de tu propio usuairo en la cual podras editarle y borrarle
                                    do {
                                        opcion = menuGestionartuUsuario(usuariologeado);//Se le muestra un minimenu preguntando si quiere editar o borrar
                                        switch (opcion) {

                                            case 1://En caso de querer editar
                                                Usuario usuarioeditado;
                                                do {
                                                    usuarioeditado = Usuario.editartuUsuario(usuariologeado);
                                                    opcion = datosCorrectosEditados(usuarioeditado);
                                                    if (opcion == 1) {
                                                        System.out.println("Su USUARIO se ha editado correctamente");
                                                        usuarios.set(numerodeusuario, usuarioeditado);
                                                    } else {
                                                        opcion = volverEditar();
                                                    }
                                                } while (opcion == 1);
                                                break;

                                            case 2://En caso de querer borrar
                                                opcion = menuEliminarUsuario();//Se le pregunta si esta seguro
                                                if (opcion == 1) {//Si es 1 es que si quiere
                                                    sinusuario = true;//sinusuario pasa a ser true por lo que no existira usuario para viajar por el menu y tendra que voilver al registro de usuario
                                                    usuarios.remove(numerodeusuario);//Se borra el usuario de la lista de usuarios
                                                } else {//Si la opcion es 0 es que no quiere borrar
                                                    sinusuario = false;//Y por lo tanto sinusuairo sera false
                                                }
                                                break;
                                        }
                                        if (!sinusuario) {
                                            opcion = volverGestionartuUsuario();
                                        }
                                    } while ((opcion == 1) && (!sinusuario));
                                    break;
                            }
                            if ((opcion1 != 0) && (!sinusuario)) {//Esto es para volver al menu de gestion de usuarios para ello el usuario no tiene que borrar su usuario y no le ha tenido que dar a volver al menu de inicio
                                opcion1 = volverGestionUusairos();//Se le muestra un menu para pregutarle si quiere volver a la gestion de usuairos o salir del programa
                                if (opcion1 == 0) {
                                    System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.");
                                    return;
                                }
                            }
                        } while ((opcion1 == 1) && (!sinusuario));//Si la opcion es 1 y existe usuario(no se ha borrado) se vuelve al menu de gestion de usuarios
                        break;

                    case 2:

                        int opcion2 = -1;
                        do {
                            mostrarMenuPrincipal();
                            System.out.println("Introduzca la seleccion: ");
                            opcion1 = in.nextInt();
                            if (opcion1 < 0 || opcion1 > 3) {
                                System.out.println("Opción incorrecta.");
                                continue;
                            }
                            switch (opcion1) {
                                case 0:
                                    System.out.println("\nHa pulsado SALIR.");
                                    break;
                                case 1: //--- GESTIÓN DE CONCIERTOS ---
                                    System.out.println("\n\tHa pulsado");
                                    do {
                                        menuGestionConciertos();
                                        System.out.println("\tIntroduzca la seleccion: ");
                                        //in = new Scanner(System.in);
                                        opcion2 = in.nextInt();
                                        if (opcion2 < 0 || opcion2 > 6) {
                                            System.out.println("Opción incorrecta.");
                                            continue;
                                        }
                                        gestionConciertos(aLConcierto, aLGira);
                                    } while (opcion2 != 0);
                                    break;
                                case 2: //--- GESTIÓN DE ENTRADAS ---
                                    System.out.println("\n\tHa pulsado");
                                    do {
                                        menuGestionEntradas();
                                        System.out.println("\tIntroduzca la seleccion: ");
                                        in = new Scanner(System.in);
                                        opcion2 = in.nextInt();
                                        if (opcion2 < 0 || opcion2 > 2) {
                                            System.out.println("Opción incorrecta.");
                                            continue;
                                        }
                                        gestionEntradas(aLEntrada);
                                    } while (opcion2 != 0);
                                    break;
                                case 3: //--- GESTIÓN DE UTILIDADES ---
                                    System.out.println("\n\tHa pulsado");
                                    do {
                                        menuGestionUtilidades();
                                        System.out.println("\tIntroduzca la seleccion: ");
                                        in = new Scanner(System.in);
                                        opcion2 = in.nextInt();
                                        if (opcion2 < 0 || opcion2 > 6) {
                                            System.out.println("Opción incorrecta.");
                                            continue;
                                        }
                                        gestionUtilidades(aLArtista, aLConcierto, aLGira, aLActuacion, aLEntrada, aLReserva);
                                    } while (opcion2 != 0);
                                    break;

                            }
                        } while (opcion1 != 0);
                        System.out.println("¡HASTA LA PRÓXIMA!");

                    case 3:
                        do {
                            opcion = menuEntradas();
                            switch (opcion) {

                                case 0:
                                    opcion1 = 0;
                                    break;

                                case 1:

                                    break;

                                case 2:
                                    System.out.println("--Bienvenido a RESERVAR ENTRADAS--");
                                    System.out.println("Los CONCIERTOS disponibles con sus ENTRADAS son los siguientes");
                                    for (int i = 0; i < conciertos.size(); i++) {
                                        System.out.println("ID del concierto:" + conciertos.get(i).getId() + " ");
                                        System.out.println("ENTRADAS disponinles:");
                                        if (conciertos.get(i).getEntradas().size() > 0) {
                                            int contador = 0;
                                            for (int j = 0; j < conciertos.get(i).getEntradas().size(); j++) {
                                                if (conciertos.get(i).getEntradas().get(j).isDisponible()) {
                                                    System.out.println(conciertos.get(i).getEntradas().get(j));
                                                    contador++;
                                                }
                                            }
                                            if (contador == 0) {
                                                System.out.println("ENTRADAS AGOTADAS");
                                            }
                                        } else {
                                            System.out.println("No existen entradas para este CONCIERTO");
                                        }
                                        System.out.println("");
                                    }
                                    System.out.println("Desea RESERVAR alguna de estas?");
                                    opcion = in.nextInt();
                                    if (opcion == 1) {
                                        System.out.println("Cual es el id del concierto que quiere reservar las entradas");
                                        int id = in.nextInt();
                                        System.out.println("Para ese concierto estan disponibles las siguientes ENTRADAS");
                                        for (int i = 0; i < conciertos.size(); i++) {
                                            if (id == conciertos.get(id).getId()) {
                                                if (conciertos.get(i).getEntradas().size() > 0) {
                                                    int contador = 0;
                                                    for (int j = 0; j < conciertos.get(i).getEntradas().size(); j++) {

                                                        if (conciertos.get(i).getEntradas().get(j).isDisponible()) {
                                                            System.out.println(conciertos.get(i).getEntradas().get(j));
                                                            contador++;
                                                        }
                                                    }
                                                    if (contador == 0) {
                                                        System.out.println("ENTRADAS AGOTADAS");
                                                    }
                                                    break;
                                                } else {
                                                    System.out.println("No existen entradas para este CONCIERTO");
                                                }
                                            }

                                        }
                                        break;

                                    }

                                    if ((opcion1 != 0)) {//Esto es para volver al menu de gestion de entradas
                                        opcion = volverGestionEntradas();//Se le muestra un menu para pregutarle si quiere volver a la gestion de entradas o salir del programa
                                        if (opcion == 0) {
                                            System.out.println("Sentimos no poder ayudarle,que tenga un buen dia.-.-");
                                            return;
                                        }
                                    }
                            }
                        } while (opcion == 1);
                        break;

                }
                volverIniciooRegistro(opcion1, sinusuario);//Son mensajes que se mostrtarian en pantalla dependiendo los parametros que se le pasen

            } while ((opcion1 == 0) && (!sinusuario));//Si la opcion es 0  y existe el usuairo se vuelve al menu principal
        } while (sinusuario);//Si no existe usuario se vuelve al registro de usuarios
    } //
    //

    private static int menuRegistroIniciosesion() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {//Antes de todo el programa el usuario tendra que identificarse para poder hacer todo lo que tiene que ver con el programa,en caso de que tenga cuenta solo tendra que introducir sus credenciales
            //y en caso de que no tenga cuenta tendra que crearse una reggistrandose para posteriormente iniciar sesion con esa cuenbta que ha creado
            System.out.println("´-Bienvenido a la AGENCIA CONCIERTOS JML-`");
            System.out.print("Para poder hacer una consulta necesitas ser usuario con cuenta.\nPulse 1 para CREAR CUENTA(registrarte) \nPulse 2 para INICIAR SESION\nPulse 0 para SALIR DEL PROGRAMA\n(0,1 o 2): ");
            opcion = in.nextInt();//Se le muestra al usuario el menu de registros e inicios de sesion y le obliga a introducir que quiere hacer
            if ((opcion < 0) || (opcion > 2)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");///En caso de valor invalido se muestra el siguiente mensaje
            }
        } while ((opcion < 0) || (opcion > 2));//En caso de que lo que meta el usuario por teclado sea diferente a 0,1 o 2 se le volvera a preguntar
        return opcion;
    }

    private static int falloInicioSesion() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        //En caso de que no coincidan el email y NIF proporcionados por teclaod, se realiza el siguiente do while
        do {//En caso de que no sea 0 o 1 se volvera a realizar otra iteracion
            System.out.print("Email o NIF incorrectos\nPulse 1 para VOLVER a INTENTARLO\nPulse 0 para SALIR DEL PROGRAMA\n(0 o 1):");//Se le muestra estas opciones la usuario
            opcion = in.nextInt();//El introduce la que mas le convenga
            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 0) && (opcion != 1));
        return opcion;
    }

    private static int menuEntradas() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n-Esta en GESTION DE ENTRADAS-");
            System.out.print("Pulse 1 para COMPRAR ENTRADA/S\nPulse 2 para RESERVAR ENTRADA/S\nPulse 0 para VOLVER AL MENU INICI0\n(0,1,2 o 3): ");//Se le muestra estas opciones la usuario
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 0) && (opcion != 2)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 0) && (opcion != 1) && (opcion != 2));
        return opcion;
    }

    private static int falloRegistroUsuario() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {//Y se le preguntara al usuario si quiere volver a intentar introducir un nuevo usuario
            System.out.print("Pulse 1 para intentar REGISTRARTE de NUEVO\nPulse 0 para SALIR DEL PROGRAMA\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion != 0) && (opcion != 1)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 0) && (opcion != 1));//Solo valdran las opciones 0 y 1 en cualquier optro caso se repitira otra iteracion
        return opcion;
    }

    private static int submenuRegistro() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {//Posteriormente s ele muestra otro minimenu en el cual le dan la opciuon al usuario de regitrar otra cuenta(por ejemplo la de un familiar),iniciar sesion o salir del programa
            System.out.print("Pulse 1 para REGISTRAR OTRO USUARIO\nPulse 2 para INICIAR SESION\nPulse 3 para SALIR DEL PROGRAMA\n(0,1 o 2): ");
            opcion = in.nextInt();
            if ((opcion < 0) || (opcion > 2)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");//Si la opcion no es ni 1,2 o 0 se mostrara el siguiente mensaje
            }
        } while ((opcion < 0) || (opcion > 2));//Si la opcion no es ninguna de esas tres se sale del programa
        return opcion;
    }

    private static int menuInicio() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n-Esta en el MENU PRINCIPAL-");
            System.out.print("Pulse 1 para GESTIONAR USUARIOS\nPulse 2 para GESTIONAR CONCIERTOS\nPulse 3 para GESTIONAR ENTRADAS\nPulse 0 para SALIR DEL PROGRAMA\n(0,1,2 o 3):");//Se le muestra al usuario el menu
            opcion = in.nextInt();//El usuario introducira la opcion que quiere
            if ((opcion < 0) || (opcion > 3)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");//Si la opcion no es ni 1,2 o 3 se mostrara el siguiente mensaje
            }
        } while ((opcion < 0) || (opcion > 3));
        return opcion;
    }

    private static int menuGestionUsuarios() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n-Esta en GESTION DE USUARIOS-");
            System.out.print("Pulse 1 para VER TODOS LOS USUARIOS\nPulse 2 para BUSCAR 1 USUARIO(por su NIF o id)\nPulse 3 para GESTIONAR TU USUARIO\nPulse 0 para VOLVER AL MENU INICI0\n(0,1,2 o 3): ");
            opcion = in.nextInt();
            if ((opcion < 0) || (opcion > 3)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");//Si la opcion no es ni 1,2 o 3 se mostrara el siguiente mensaje
            }
        } while ((opcion < 0) || (opcion > 3));
        return opcion;
    }

    private static int menuVerUsuarioDetallado() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\n¿Quiere ver INFORMACION mas detallada de algun USUARIO?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 0));
        return opcion;
    }

    private static int volverEditar() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n¿Quiere volver a intentar meter los datos para editar su usuario?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 0) && (opcion != 1));
        return opcion;
    }

    private static int volverBuscarUsuarioporId() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\nNO existe ningun USUARIO con ese ID,¿quiere buscar otro?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1):");//Se le dira al usuairo que no existe nadie con ese id y le pregunta que si quiere volver a buscar
            opcion = in.nextInt();
            if ((opcion != 0) && (opcion != 1)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");//Si la opcion es incorrecta se le muestra el siguiente mensaje
            }
        } while ((opcion != 0) && (opcion != 1));
        return opcion;
    }

    private static int volverBuscarUsuarioporNIF() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {//Y se le preguntara al usuario si quiere buscar otro
            in = new Scanner(System.in);
            System.out.print("\nNO existe ningun USUARIO con ese NIF,¿quiere buscar otro?\nPulse para 1 SI\nPulse 0 para NO\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion != 0) && (opcion != 1)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 0) && (opcion != 1));
        return opcion;
    }

    private static int buscarOtroUsuario() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            in = new Scanner(System.in);
            System.out.print("\n¿Desea realizar otra BUSQUEDA?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");//Se le pregutnara al usuairo si nquiere buscar algun otro usuairo
            opcion = in.nextInt();
            if ((opcion != 0) && (opcion != 1)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 0));
        return opcion;
    }

    private static int menuBusquedaUsuario() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\nLas opciones de BUSQUEDA son:\nPulse 1 para BUSCAR POR ID\nPulse 2 para BUSCAR POR NIF\n(1 o 2): ");
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 2)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 2));
        return opcion;
    }

    private static int datosCorrectosEditados(Usuario usuarioeditado) {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {//En caso de que no sea 1 o 0 se realizara otra iteracion
            System.out.print("\n¿Son estos los datos correctos?\n" + usuarioeditado + "\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 0));
        return opcion;
    }

    private static long idabuscar() {
        Scanner in = new Scanner(System.in);
        long idbuscado;
        do {
            System.out.print("Introduzca el ID del USUARIO a buscar: ");
            idbuscado = in.nextLong();
            if ((idbuscado <= 0)) {
                System.out.println("El valor introducido NO es VALIDO pusto que es menor que 0, por favor vuelva a introducirlo\n");
            }
        } while (idbuscado <= 0);
        return idbuscado;
    }

    private static int menuGestionartuUsuario(Usuario usuariologeado) {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\nSu usuario es " + usuariologeado.getId() + " " + usuariologeado);
            System.out.print("Pulse 1 para EDITAR SU USUARIO\nPulse 2 para ELIMINAR SU USUAIRO\n(1 o 2): ");
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 2)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 2));
        return opcion;
    }

    private static int menuEliminarUsuario() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\n¿Esta segiro de que quiere ELIMINAR su USUARIO?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
            opcion = in.nextInt();

            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 0));
        return opcion;
    }

    private static int volverGestionartuUsuario() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\n¿Desea realizar algo mas relacionado con su USUARIO?\nPulse 1 para SI\nPulse 0 para NO\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion != 1) && (opcion != 0)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion != 1) && (opcion != 0));
        if (opcion == 0) {
            opcion = 10;
        }
        return opcion;
    }

    private static int volverGestionUusairos() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\nPulse 1 para VOLVER MENU GESTION DE USUARIOS \nPulse 0 para SALIR DEL PROGRAMA\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion < 0) || (opcion > 1)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion < 0) || (opcion > 1));
        return opcion;
    }

    private static int volverGestionEntradas() {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\nPulse 1 para VOLVER MENU GESTION DE ENTRADAS \nPulse 0 para SALIR DEL PROGRAMA\n(0 o 1): ");
            opcion = in.nextInt();
            if ((opcion < 0) || (opcion > 1)) {
                System.out.println("La opcion introducida NO es VALIDA, por favor vuelva a introducirla\n");
            }
        } while ((opcion < 0) || (opcion > 1));
        return opcion;
    }

    private static void volverIniciooRegistro(int opcion, boolean sinusuario) {

        if (opcion == 0) {
            System.out.println("Has vuelto al menu principal");//Si se vuelve al menu desde cualquier submenu se mostrara el siguiente mensaje y volvera a mostrarle al usuario el menu principal
        } else if (sinusuario) {
            System.out.println("Le sera devuelto al menu de registro y de inicio de sesion ya que necesita ser usuario para estar en el programa.\n");
        }

    }

    private static void mostrarMenuPrincipal() {
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("Pulse 1 para GESTIÓN DE CONCIERTOS.");
        System.out.println("Pulse 2 para GESTIÓN DE ENTRADAS.");
        System.out.println("Pulse 3 para UTILIDADES.");
        System.out.println("Pulse 0 para SALIR.");

    }

    private static void menuGestionConciertos() {
        System.out.println("\t--- GESTIÓN DE CONCIERTOS ---");
        System.out.println("\tPulse 1 para VER GIRAS.");
        System.out.println("\tPulse 2 para NUEVO CONCIERTO.");
        System.out.println("\tPulse 3 para NUEVA GIRA.");
        System.out.println("\tPulse 4 para BUSCAR GIRA.");
        System.out.println("\tPulse 5 para MODIFICAR GIRA.");
        System.out.println("\tPulse 6 para ELIMINAR GIRA.");
        System.out.println("\tPulse 0 para VOLVER AL MENÚ PRINCIPAL.");

    }

    private static void menuGestionEntradas() {
        System.out.println("\t--- GESTIÓN DE ENTRADAS ---");
        System.out.println("\tPulse 1 para RESERVAR ENTRADAS.");
        System.out.println("\tPulse 2 para COMPRAR ENTRADAS.");
        System.out.println("\tPulse 0 para VOLVER AL MENÚ PRINCIPAL.");
    }

    private static void menuGestionUtilidades() {
        System.out.println("\t--- GESTIÓN DE UTILIDADES ---");
        System.out.println("\tPulse 1 para MOSTRAR ARTISTAS.");
        System.out.println("\tPulse 2 para MOSTRAR ACTUACIONES.");
        System.out.println("\tPulse 3 para MOSTRAR GIRAS.");
        System.out.println("\tPulse 4 para MOSTRAR CONCIERTOS.");
        System.out.println("\tPulse 5 para MOSTRAR ENTRADAS.");
        System.out.println("\tPulse 6 para MOSTRAR RESERVAS.");
        System.out.println("\tPulse 0 para VOLVER AL MENÚ PRINCIPAL.");
    }

    private static void gestionConciertos(ArrayList<Concierto> aLConcierto, ArrayList<Gira> aLGira) {
        int opcion3 = -1;
        int idGira = 0;
        Scanner in = new Scanner(System.in);
        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();
        ArrayList<Concierto> conciertosViejos = new ArrayList<Concierto>();
        do {
            opcion3 = in.nextInt();
            if (opcion3 < 0 || opcion3 > 6) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            switch (opcion3) {

                case 0:
                    break;
                case 1:
                    System.out.println("\tHa pulsado --- VER GIRAS ---");
                    aLGira = todasGiras();
                    mostrarTodasGiras(aLGira);
                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE CONCIERTOS.");
                    break;
                case 2:
                    System.out.println("\tHa pulsado --- NUEVO CONCIERTO ---");
                    Concierto conciertoAlta = Concierto.leerConciertoTeclado(aLGira);

                    //3º alta BBDD
                    Concierto c = insertarConcierto(conciertoAlta);
                    if (c != null) {
                        System.out.println("El CONCIERTO " + c.toString() + " se ha creado en la BD.");
                    } else {
                        System.out.println("Hubo un problema y NO se ha creado el nuevo CONCIERTO.");
                    }
                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE CONCIERTOS.");
                    break;
                case 3:
                    System.out.println("\tHa pulsado --- NUEVA GIRA ---");
                    //1º pedir y validar datos.
                    //2º guardar datos en instancia de tipo gira.
                    Gira giraAlta = Gira.nuevaGira();
                    //3º alta BBDD
                    if (insertarGira(giraAlta) != null) {
                        System.out.println("La GIRA " + giraAlta.toString() + " se ha creado en la BD.");
                    } else {
                        System.out.println("Hubo un problema y NO se ha creado la nueva GIRA.");
                    }

                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE CONCIERTOS.");
                    break;
                case 4:
                    System.out.println("\tHa pulsado --- BUSCAR UNA GIRA ---");
                    System.out.println("Leer detalles de GIRA:");
                    System.out.println("Seleccione el ID de la GIRA ");
                    aLGira = todasGiras();
                    mostrarTodasGiras(aLGira);
                    idGira = in.nextInt();
                    System.out.println("Los detalles de la GIRA con id=" + idGira + " son:");
                    verDetallesGira((int) idGira);
                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE CONCIERTOS.");
                    break;
                case 5:
                    System.out.println("\tHa pulsado --- MODIFICAR GIRA ---");
                    aLGira = todasGiras();
                    mostrarTodasGiras(aLGira);
                    idGira = in.nextInt();
                    modificarGira(idGira);
                    System.out.println("La GIRA con id=" + idGira + "se ha ,odificado en la BD.");
                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE CONCIERTOS.");
                    break;
                case 6:
                    System.out.println("\tHa pulsado --- ELIMINAR GIRA ---");
                    aLGira = todasGiras();
                    mostrarTodasGiras(aLGira);
                    idGira = in.nextInt();
                    //antes de ejecutar DELETE que exista
                    eliminarGira(idGira);
                    System.out.println("La GIRA con id=" + idGira + "se ha ,odificado en la BD.");
                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE CONCIERTOS.");
                    break;
                default:
                    break;
            }

        } while (opcion3
                != 0);
    }

    private static void gestionEntradas(ArrayList<Entrada> aLEntrada) {
        int opcion3 = -1;
        Scanner in = new Scanner(System.in);
        do {
            opcion3 = in.nextInt();
            if (opcion3 < 0 || opcion3 > 2) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            switch (opcion3) {
                case 0:
                    break;
                case 1:
                    System.out.println("\tHa pulsado --- RESERVAR ENTRADAS ---");

                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE ENTRADAS.");
                    break;
                case 2:
                    System.out.println("\tHa pulsado --- COMPRAR ENTRADAS ---");

                    System.out.println("\tPulse 0 para volver al MENÚ DE GESTIÓN DE ENTRADAS.");
                    break;
                default:
                    break;
            }
        } while (opcion3 != 0);

    }

    public static void mostrarTodosConciertos(ArrayList<Concierto> conci) {
        System.out.println("\t\tID    FECHA       GIRA");
        for (int i = 0; i < conci.size(); i++) {
            Concierto c = conci.get(i);
            if (c.getId() > 0) {
                //System.out.println(c.toString());
                System.out.printf("\t\t%-6s%-12s%-6s\n", c.getId(), c.getDiahora(), c.getIdGira());
            }
        }
    }

    public static void mostrarTodasActuaciones(ArrayList<Actuacion> actu) {
        System.out.println("\t\tID    SECUENCIA                               DURACIÓN CONCIERTO");
        for (int i = 0; i < actu.size(); i++) {
            Actuacion a = actu.get(i);
            if (a.getId() > 0) {
                //System.out.println(a.toString());
                System.out.printf("\t\t%-6s%-40s%-9s%-40s\n", a.getId(), a.getNumerosecuencia(), a.getDuracion(), a.getIdConcierto());
            }
        }
    }

    public static void mostrarTodosArtistas(ArrayList<Artista> arti) {
        System.out.println("\t\tID    NOMBRE                                  GENERO");
        for (int i = 0; i < arti.size(); i++) {
            Artista ar = arti.get(i);
            if (ar.getId() > 0) {
                //System.out.println(ar.toString());

                System.out.printf("\t\t%-6s%-40s%-6s\n", ar.getId(), ar.getNombre(), ar.getGeneromusical());
            }
        }
    }

    public static void mostrarTodasEntradas(ArrayList<Entrada> entra) {
        System.out.println("\t\tID    PRECIO                                  DISPONIBILIDAD");
        for (int i = 0; i < entra.size(); i++) {
            Entrada e = entra.get(i);
            if (e.getExistencias() > 0) {
                //System.out.println(e.toString());
                System.out.printf("\t\t%-6s%-40s%-6s\n", e.getId(), e.getPrecio(), e.getExistencias());
            }
        }
    }

    private static void mostrarTodasReservas(ArrayList<Reserva> res) {
        System.out.println("\t\tID    FECHAMÁXIMA                             USUARIO");
        for (int i = 0; i < res.size(); i++) {
            Reserva r = res.get(i);
            if (r.getId() > 0) {
                //System.out.println(ar.toString());

                System.out.printf("\t\t%-6s%-40s%-6s\n", r.getId(), r.getFechamaxima(), r.getIdUsuario());
            }
        }
    }

    private static void mostrarTodasGiras(ArrayList<Gira> gira) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Concierto> aLConciertos = new ArrayList<Concierto>();
        System.out.println("\t\tID    NOMBRE                                  FECHAINICIO FECHAFIN    CONCIERTOS");
        for (int i = 0; i < gira.size(); i++) {
            Gira g = gira.get(i);
            if (g.getId() >= 0) {
                System.out.printf("\t\t%-6s%-40s%-12s%-12s", g.getId(), g.getNombre(), g.getFechainicio(), g.getFechacierra());
                aLConciertos = g.getConciertos();
                for (int j = 0; j < aLConciertos.size(); j++) {
                    Concierto c = aLConciertos.get(j);
                    if (c.getId() > 0) {
                        System.out.printf("%-6s%-12s", c.getId(), c.getDiahora());
                    }
                }
            }
            System.out.println("");
        }
    }

    private static void gestionUtilidades(ArrayList<Artista> aLArtista, ArrayList<Concierto> aLConcierto, ArrayList<Gira> aLGira, ArrayList<Actuacion> aLActuacion, ArrayList<Entrada> aLEntrada, ArrayList<Reserva> aLReserva) {
        int opcion3 = -1;
        Scanner in = new Scanner(System.in);
        do {
            opcion3 = in.nextInt();
            if (opcion3 < 0 || opcion3 > 6) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            switch (opcion3) {
                case 0:
                    break;
                case 1:
                    System.out.println("\t\tHa pulsado --- MOSTRAR ARTISTAS ---");
                    //mostrarTodosArtistas(aLArtista);
                    aLArtista = todosArtistas();
                    mostrarTodosArtistas(aLArtista);
                    System.out.println("\t\tPulse 0 para volver al MENÚ DE GESTIÓN DE UTILIDADES.");
                    break;
                case 2:
                    System.out.println("\t\tHa pulsado --- MOSTRAR ACTUACIONES ---");
                    aLActuacion = todasActuaciones();
                    mostrarTodasActuaciones(aLActuacion);
                    System.out.println("\t\tPulse 0 para volver al MENÚ DE GESTIÓN DE UTILIDADES.");
                    break;
                case 3:
                    System.out.println("\t\tHa pulsado --- MOSTRAR GIRAS ---");
                    //2º EVALUACIÓN (ARRAYLIST)
                    //mostrarTodasGiras(aLGira);
                    aLGira = todasGiras();
                    mostrarTodasGiras(aLGira);
                    System.out.println("\t\tPulse 0 para volver al MENÚ DE GESTIÓN DE UTILIDADES.");
                    break;
                case 4:
                    System.out.println("\t\tHa pulsado --- MOSTRAR CONCIERTOS ---");
                    //mostrarTodosConciertos(aLConcierto);
                    aLConcierto = todosConciertos();
                    mostrarTodosConciertos(aLConcierto);
                    System.out.println("\t\tPulse 0 para volver al MENÚ DE GESTIÓN DE UTILIDADES.");
                    break;
                case 5:
                    System.out.println("\t\tHa pulsado --- MOSTRAR ENTRADAS ---");
                    aLEntrada = todasEntradas();
                    mostrarTodasEntradas(aLEntrada);
                    System.out.println("\t\tPulse 0 para volver al MENÚ DE GESTIÓN DE UTILIDADES.");
                    break;
                case 6:
                    System.out.println("\t\tHa pulsado --- MOSTRAR RESERVAS ---");
                    aLReserva = todasReservas();
                    mostrarTodasReservas(aLReserva);
                    System.out.println("\t\tPulse 0 para volver al MENÚ DE GESTIÓN DE UTILIDADES.");
                    break;
                default:
                    break;
            }
        } while (opcion3 != 0);
    }

    private static ArrayList<Concierto> todosConciertos() {
        ArrayList<Concierto> todosConciertos = new ArrayList<Concierto>();
        ConciertoDAO conciertoDAO = new ConciertoDAO();
        todosConciertos = conciertoDAO.todosConciertos();
        return todosConciertos;
    }

    private static ArrayList<Actuacion> todasActuaciones() {
        ArrayList<Actuacion> todasActuaciones = new ArrayList<Actuacion>();
        ActuacionDAO actuacionDAO = new ActuacionDAO();
        todasActuaciones = actuacionDAO.todasActuaciones();
        return todasActuaciones;
    }

    private static ArrayList<Artista> todosArtistas() {
        ArrayList<Artista> todosArtistas = new ArrayList<Artista>();
        ArtistaDAO artistaDAO = new ArtistaDAO();
        todosArtistas = artistaDAO.todosArtistas();
        return todosArtistas;
    }

    private static ArrayList<Gira> todasGiras() {
        ArrayList<Gira> todasGiras = new ArrayList<Gira>();
        GiraDAO giraDAO = new GiraDAO();
        todasGiras = giraDAO.todasGiras();
        return todasGiras;
    }

    private static ArrayList<Entrada> todasEntradas() {
        ArrayList<Entrada> mostrarTodasEntradas = new ArrayList<Entrada>();
        EntradaDAO entradaDAO = new EntradaDAO();
        mostrarTodasEntradas = entradaDAO.todasEntradas();
        return mostrarTodasEntradas;
    }

    private static ArrayList<Reserva> todasReservas() {
        ArrayList<Reserva> mostrarTodasReservas = new ArrayList<Reserva>();
        ReservaDAO reservaDAO = new ReservaDAO();
        mostrarTodasReservas = reservaDAO.todasReservas();
        return mostrarTodasReservas;
    }

    private static Gira insertarGira(Gira g) {
        GiraDAO giraDAO = new GiraDAO();
        return giraDAO.insertarGira(g);
    }

    private static Concierto insertarConcierto(Concierto c) {
        ConciertoDAO conciertoDAO = new ConciertoDAO();
        return conciertoDAO.insertarConcierto(c);
    }

    private static void verDetallesGira(int idGira) {
        if (idGira <= 0) {
            System.out.println("El id de la GIRA no puede ser <= 0.");
        } else {
            Gira g;
            GiraDAO giraDAO = new GiraDAO();
            g = GiraDAO.buscarGiraById(idGira);
            if (g == null) {
                System.out.println("No hay registros en la BD de GIRAS con id=" + idGira);
            } else {
                giraDAO.verDetallesGira(g);
            }
        }
    }

    private static void verDetallesConcierto(int idConcierto) {
        if (idConcierto <= 0) {
            System.out.println("El id del CONCIERTO no puede ser <= 0.");
        } else {
            Concierto c;
            ConciertoDAO conciertoDAO = new ConciertoDAO();
            c = ConciertoDAO.buscarConciertoById(idConcierto);
            if (c == null) {
                System.out.println("No hay registros en la BD de CONCIERTOS con id=" + idConcierto);
            } else {
                conciertoDAO.verDetallesConcierto(c);
            }
        }
    }

    private static void modificarGira(int idGira) {
        Scanner in = new Scanner(System.in);
        if (idGira <= 0) {
            System.out.println("El id de la GIRA no puede ser <= 0.");
        } else {
            System.out.println("?Seguro que desee modificar la GIRA de id=" + idGira + " ? (s/n)");
            char resp = in.nextLine().charAt(0);
            if (resp == 'n' || resp == 'N') {
                return;
            } else {
                System.out.println("Introduzca valor para el nombre:");
                String nombre = in.nextLine();
                Gira g = new Gira(idGira, nombre);
                if (!Gira.validarGira(g)) {
                    System.out.println("Los datos introducidos para la GIRA no son válidos.");
                    System.out.println("NO se ha modificado la GIRA en la BD.");
                    return;
                }
                GiraDAO giraDAO = new GiraDAO();
                giraDAO.modificarGira(g);
                System.out.println("Se ha modificado la GIRA en la BD.");
                System.out.println("Los nuevos datos de la GIRA son:" + g.toString());
            }
        }
    }

    private static void eliminarGira(int idGira) {
        Scanner in = new Scanner(System.in);
        if (idGira <= 0) {
            System.out.println("El id de la GIRA no puede ser <= 0.");
        } else {
            System.out.println("?Seguro que desee eliminar la GIRA de id=" + idGira + " ? (s/n)");
            char resp = in.nextLine().charAt(0);
            if (resp == 'n' || resp == 'N') {
                return;
            } else {
                Gira g = GiraDAO.buscarGiraById(idGira);
                if (g == null) {
                    System.out.println("La GIRA de id=" + idGira + " no existe.");
                    return;
                }
                GiraDAO giraDAO = new GiraDAO();
                giraDAO.eliminarGira(idGira);
            }
        }
    }
}
