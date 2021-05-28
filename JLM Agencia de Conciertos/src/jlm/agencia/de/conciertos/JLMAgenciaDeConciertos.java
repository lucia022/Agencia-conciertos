/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

import dao.EntradaDAO;
import dao.UsuarioDAO;
import entidades.Compra;
import entidades.Concierto;
import entidades.Descuento;
import entidades.Entrada;
import entidades.Fecha;
import entidades.Gira;
import entidades.Reserva;
import entidades.Usuario;
import entidades.Utilidades;
import java.text.ParseException;
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
                            case 3: {
                                try {
                                    concierto = Concierto.nuevoConcierto();
                                } catch (ParseException ex) {
                                    Logger.getLogger(JLMAgenciaDeConciertos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                        }
                        break;

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
}
