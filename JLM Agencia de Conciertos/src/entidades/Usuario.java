/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Usuario {

    //Todos los atributos no podran quedar vacios
    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VALIDOS: Cadenas de caracteres(String)(Solo letras).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) , aquellas cadenas que contengan cualquier caracter distinto a letras y cadenas que no contengan un minimo de  3 caracteres.
    private String nombre;
    //VALORES VALIDOS: Cadenas de caracteres(String)(solo letras).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) , aquellas cadenas que contengan cualquier caracter distinto a letras y cadenas que no contengan un minimo de  4 caracteres.
    private String apellido;
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) y aquellas cadenas que no contengan un @ al menos,ya que se trata de un email.
    private String email;
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) y aquellas cadenas que contengan mas o menos de 9 caracteres,ya que se trata de un NIF.Ademas debe de tener el formato correcto que es 8 numeros y 1 letra mayuscula
    private String nif;
    //Es una coleccion de objetos del tipo descuentos en el cual se guardaran todos los descuentos que puede usar el usuario x
    private ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
    //Es una coleccion de objetos del tipo compras en el cual se guardaran todas las compras realizadas por el usuario x
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    //Es una coleccion de objetos del tipo reservas en el cual se guardaran todas las reservas realizadas por el usuario x
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    /*constructor por defecto*/
    public Usuario() {
    }

    //constructor con parámetros,solo con los datos basicos del usuario
    public Usuario(long id, String nombre, String apellido, String email, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
    }

    //Constructor con parametros,con todos los atributos posibles como los arrays de compra,reserva y descuento
    public Usuario(long id, String nombre, String apellido, String email, String nif, ArrayList<Compra> compras, ArrayList<Reserva> reservas, ArrayList<Descuento> descuentos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.compras = compras;
        this.reservas = reservas;
        this.descuentos = descuentos;
    }

    /*constructor de copia con todos los parametros*/
    public Usuario(Usuario u) {
        this.id = u.id;
        this.nombre = u.nombre;
        this.apellido = u.apellido;
        this.email = u.email;
        this.nif = u.nif;
        this.compras = u.compras;
        this.reservas = u.reservas;
        this.descuentos = u.descuentos;
    }

    //getters & setters de cada atributo
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public ArrayList<Descuento> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(ArrayList<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     *
     * Funcion en la cual se piden al usuario datos basicos del usuario y
     * posteriormente se validan para que todos los campos sean correctos.Hay
     * que destacar que ningun campo podra quedar vacio.
     *
     * @return devuelve un objeto de tipo usuario con datos
     * basicos(Id,Nombre,Apellido,Email y NIF)
     *
     */
    public static Usuario nuevoUsuarioBasico() {

        Usuario nuevousuario = new Usuario();//Se crea un nuevo objeto de tipo usuario en el cual se guardara sus atributos basicos(Nombre,Apellido,Email y DNI) ademas del id pero ese se autocalculara
        long idusuario;
        String nombreusuario, apellidousuario, nifusuario, emailusuario;//Declarados los campos basicos 
        //El id sera autocalculado
        idusuario = Usuario.idUsuario(); //En idusuario se guardara lo que retorne de la funcion idUusairo 
        System.out.println("Su id de usuario sera el " + idusuario);//Se le muestra por pantalla que id tiene
        nuevousuario.setId(idusuario);//Se settea la variable idusuario en el objeto nuevousuario
        System.out.println("");
        nombreusuario = Usuario.pedirNombreValido();//Nos da el nombre ya validado
        nuevousuario.setNombre(nombreusuario);//Se setea el nombre del usuario en el objeto nuevousuario
        System.out.println("");
        apellidousuario = Usuario.pedirApellidoValido();//Nos da el apellido ya validado
        nuevousuario.setApellido(apellidousuario);//Se setea el apellido del usuario en el objeto nuevousuario
        System.out.println("");
        emailusuario = Usuario.pedirEmailValido();//Nos da el email ya validado
        nuevousuario.setEmail(emailusuario);//Se setea el email en el objeto nuevousuario
        System.out.println("");
        nifusuario = Usuario.pedirNIFValido();//Nos da un nif ya validado
        nuevousuario.setNif(nifusuario);//Se setea el nif en el objeto nuevousuario
        return nuevousuario;//Delvuelve el objeto completo nuevousuario con los campos basicos de id,nombre,apellido,email y nif
    }

    public static String pedirNombreValido() {
        Scanner in = new Scanner(System.in);
        String nombreusuario;
        boolean valido = false; //Declarado un boolean el cual usare en toda la funcion y servira para los do while se repitan o no en funcin de si hay fallos o no
        do { //Pedira un nombre(String) pero este no podra tener caracteres que no sean letras,ni tener menos de cuatro caracteres ni mas de quince ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior
            System.out.print("¿Cual es su nombre?: ");  //Se pide el nombre
            nombreusuario = in.nextLine();  //El usuario lo introduce     
            //A partir de aqui se verifica que lo que ha introducido el usuairo es valido
            valido = Usuario.validarNombre(nombreusuario);
        } while (!valido);//En caso de que haya algun fallo en las validaciones se realizara otra iteracion
        return nombreusuario;
    }

    public static String pedirApellidoValido() {
        Scanner in = new Scanner(System.in);
        String apellidousuario;
        boolean valido = false; //Declarado un boolean el cual usare en toda la funcion y servira para los do while se repitan o no en funcin de si hay fallos o no
        do { //Pedira un apellido(String) pero este no podra tener caracteres que no sean letras,ni tener menos de cuatro caracteres ni mas de quince ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior
            System.out.print("¿Cual es su apellido?: ");  //Se pide el apellido
            apellidousuario = in.nextLine();  //El usuario lo introduce
            //A partir de aqui se verifica que lo que ha introducido el usuairo es valido
            valido = Usuario.validarApellido(apellidousuario);
        } while (!valido);//En caso de que haya algun fallo en las validaciones se realizara otra iteracion
        return apellidousuario;
    }

    public static String pedirEmailValido() {
        Scanner in = new Scanner(System.in);
        String emailusuario;
        boolean valido = false; //Declarado un boolean el cual usare en toda la funcion y servira para los do while se repitan o no en funcin de si hay fallos o no
        do { //Pedira un email(String) el cual tendra que tener el formato correcto xxx@dominio.com/es, en caso contrario se volvera a pedir email hasta que esto se cumpla
            System.out.print("¿Cual es su email?: ");//Se pide el email
            emailusuario = in.nextLine();//El usuario lo introduce
            //Algo basico que hice solo comprueba que tenga un @
            //A partir de aqui se verifica que lo que ha introducido el usuairo es valido
            valido = Usuario.validarEmail(emailusuario);
        } while (!valido); //En caso de que este el email vacio o este no contenga un @ se le volvera a pedir al usuario
        return emailusuario;
    }

    public static String pedirNIFValido() {
        Scanner in = new Scanner(System.in);
        String nifusuario;
        boolean valido = false; //Declarado un boolean el cual usare en toda la funcion y servira para los do while se repitan o no en funcin de si hay fallos o no
        do { //Pedira un nif(String) el cual no podra contener mas ni menos de 9 caracteres asi como tendra que tener el formato 11111111A 8 numeros y 1 letra mayuscula o se volvera a pdeir el nif hasta que esto sea cierto
            System.out.print("¿Cual es su nif?: "); //Se pedira el NIF
            nifusuario = in.nextLine();//El usuario introduce el NIF
            //A partir de aqui se verifica que lo que ha introducido el usuairo es valido
            valido = Usuario.validarNIF(nifusuario);
        } while (!valido); //En caso de que haya algun fallo ya sea de longitud o de formato,realizara otra iteracion  
        return nifusuario;
    }

    /**
     * Funcion que valida un nombre pasado como parametro como un String el cual
     * se validara mirando que solo sean caracteres del alfabeto
     *
     * @param nombreusuario
     * @return True en caso de que el email sea valido y False en caso de que
     * sea invalido
     */
    public static boolean validarNombre(String nombreusuario) {
        if ((nombreusuario.length() > 3 && nombreusuario.length() < 15)) { //Se mirara que el nombre de usuario tenga un minimo de 3 letras y un maximo de 15  
            //Una vez mirado que lalongitud del nombre sea corecta se miraraque solo contenga letras
            if (nombreusuario.matches(".*[^a-z-A-Z].*")) { //Buscara si el nombre de usuario tiene caracteres que son distintos a letras
                System.out.println("El nombre introducido contiene caracteres invalidos,inntroduzcalo de nuevo(Solo letras)");    //Si contiene caracteres distintos a letras muestra este mensaje 
                return false;
            }
            return true;
        } else {
            if (nombreusuario.length() < 3) {//Si el nombre tiene menos de cuatro letras se muestra un mensaje
                System.out.println("El nombre introducido no contiene el minimo de 3 letras,por favor introduzcalo de nuevo");
            }
            if (nombreusuario.length() > 15) {//Si el nombre tiene menos de cuatro letras se muestra un mensaje
                System.out.println("El nombre introducido contiene mas del maximo de letras permitidasa(15),por favor introduzcalo de nuevo");
            }
            return false;
        }
    }

    /**
     * Funcion que valida un apellido pasado como parametro como un String el
     * cual se validara mirando que solo sean caracteres del alfabeto
     *
     * @param apellidousuario
     * @return True en caso de que el apellido sea valido y False en caso de que
     * sea invalido
     */
    public static boolean validarApellido(String apellidousuario) {
        if ((apellidousuario.length() > 4 && apellidousuario.length() < 15)) { //Se mirara que el nombre de usuario tenga un minimo de 3 letras y un maximo de 15  
            //Una vez mirado que lalongitud del nombre sea corecta se miraraque solo contenga letras
            if (apellidousuario.matches(".*[^a-z-A-Z].*")) { //Buscara si el nombre de usuario tiene caracteres que son distintos a letras
                System.out.println("El apellido introducido contiene caracteres invalidos,inntroduzcalo de nuevo(Solo letras)");    //Si contiene caracteres distintos a letras muestra este mensaje 
                return false;//En caso de contener caracteres que no0 son solo letras mayusculas retornara false
            }
            return true;//En caso de que todo este corecto retornara true
        } else {
            if (apellidousuario.length() < 4) {//Si el apellido tiene menos de cuatro letras se muestra un mensaje
                System.out.println("El apellido introducido no contiene el minimo de 4 letras,por favor introduzcalo de nuevo");
            }
            if (apellidousuario.length() > 15) {//Si el apellido tiene mas de quince letras se muestra un mensaje
                System.out.println("El apellido introducido contiene mas del maximo de letras permitidasa(15),por favor introduzcalo de nuevo");
            }
            return false;//En caso de no estar dentro del numero de caracteres validos retornara false
        }
    }

    /**
     * Funcion que valida un NIF pasado como parametro como un String el cual se
     * validara mirando que temga el formato valido 8 numeros y 1 letra
     * mayuscula
     *
     * @param nifusuario
     * @return True en caso de que el email sea valido y False en caso de que
     * sea invalido
     */
    public static boolean validarNIF(String nifusuario) {
        if (nifusuario.length() != 9) {//Primero mirara que tenga 9 caracteres exactamente,en caso de que no se realiza el siguiente if
            System.out.println("NIF invalido por no ser de 9 caracteres,por favor introduzcalo de nuevo");//En caso de tener mas de 9 o menos de 9 caracteres saldra el siguiente mensaje
            return false;//Fallo sera true y se volvera a hacer otra iteraccion            
        } else {//Una vez se sabe que tiene 9 caracteres se mirara si el formato es el correcto teniendo 8 numeros y despues una letra mayuscula
            String numeros = "", letra = "";
            //Para empezar separamos en dos String uno en el que deberian estar los numeros y el otro la letra
            for (int i = 0; i < nifusuario.length() - 1; i++) {//Recorremos los primeros 8 caracteres del NIF introduiccido por el usuario
                numeros += nifusuario.charAt(i);//En la variable numeros añadimos los primeros 8 caracteres 
            }
            letra += nifusuario.charAt(8);//Y el ultimo caracter lo añadimos a la variable letra
            //Tras separarlos nos aseguraremos de que este bien lo que el usuario ha introducido
            if ((numeros.matches("[0-9]*")) && (letra.matches(".*[A-Z].*"))) {//Mirara que los numeros sean todos numeros y la letra se asegurara de que sea una letra mayuscula
                return true;  //En caso de que todo sea correcto se devfuelve true
            } else {//En caso de que el formato no este bien hara el siguiente else
                System.out.println("El formato indicado no es correcto,introduzcalo de nuevo con formato valido(8 numeros y 1 letra mayuscula,ejemplo 12345678L)");//Mostrara el siguiente mensaje diciendo que lo que ha introducido no es valido
                return false;//En caso de que haya algun fallo devolvera false
            }
        }
    }

    /**
     * Funcion que valida un email pasado como parametro como un String el cual
     * se validara mirando que contenga un arroba por lo menos
     *
     * @param emailusuario
     * @return True en caso de que el email sea valido y False en caso de que
     * sea invalido
     */
    public static boolean validarEmail(String emailusuario) {
        for (int i = 0; i < emailusuario.length(); i++) {//Se mira si contiene arroba y si lo tiene sale del ciclo
            if (emailusuario.charAt(i) == '@') {
                return true;
            }
        }
        //Mirando por internet encontre este metodo por el cual valida un email
        //Es un poco mas avanzado ya que usa patrones pero YO LO ENTIENDO, lo dejo comentado por si mas adelante me seria util
//            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//
//            Matcher mather = pattern.matcher(emailusuario);
//
//            if (mather.find() == true) {
//                System.out.println("El email ingresado es válido.");
//                fallo = false;
//            } else {
//                System.out.println("El email ingresado es inválido.");
//                fallo = true;
//            }
        System.out.println("El email ingresado es válido,debe cobntener al menos un arroba.");
        return false;
    }

    /**
     * Funcion que obtiene el id proximo al ultimo idusuario de nuestrta base de
     * datos
     *
     * @return long el cual es el id del usuario nuevo
     */
    public static long idUsuario() {//Metodo para conseguir el id de forma automatica(se le suma uno al numero mas grande de id que haya)
        long masalto = 0;
        if (Utilidades.USUARIOS.length == 0) {     //En caso de que no haya ningun objeto se empezara en uno

        } else {
            for (int i = 0; i < Utilidades.numUsuarios; i++) {//Busca el id mas grande que hay entre los objetos y le suma 1
                if (Utilidades.USUARIOS[i].getId() > masalto) {
                    masalto = Utilidades.USUARIOS[i].getId();
                }
            }
        }
        masalto++; //Sea cual sea se le suma 1,es decir si no hay usuarios aun retornara 1 y en caso de que hayaretornara qal siguiente del ultimo
        return masalto; //Se devuelve el nuevo id
    }

    /**
     * Funcion mediante la cual conseguimos el numero del array en el que se
     * encuentra exactamente el usuario que se pasa como parametro logeado
     *
     * @param usuarios
     * @param usuariologeado
     * @return retorna el numero exacto en el que se encuentra el usuario en la
     * base de datos
     */
    public static int numeroUsuarioLogeado(ArrayList<Usuario> usuarios, Usuario usuariologeado) {
        int numerodeusuario = 0;
        for (int i = 0; i < usuarios.size(); i++) {//Recorremos todos los usuarios que hay en nuestra base de datos
            if (usuarios.get(i).getId() == usuariologeado.getId()) {//En caso de que el id del usuario que le pasamos y el id de la base de datos coincida 
                numerodeusuario = i; //Guardamos ese numero de posicion en una variable
            }
        }
        return numerodeusuario;//esa variable es la que retorna
    }

    /**
     * Metodo para copiar todos los objetos de utilidades en un arraylist para
     * poder manipularlo
     *
     * @return Un array con todos los usuarios de nuestra base de datos
     */
    public static ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//Creamos un array vacio llamado usaurios
        for (int i = 0; i < Utilidades.USUARIOS.length; i++) { //Recorremos el array encontrado en la clase utilidades
            usuarios.add(Utilidades.USUARIOS[i]);//Y vamos añadiendo cada usuario a nuestro nuevo array vacio
        }
        return usuarios;//Devuelve el array que declaramos al principio de la funcion
    }

    /**
     * Funcion que muestra los datos basicos de un usuario
     *
     * @param usuarios
     */
    public static void mostrarUsuariosbasico(ArrayList<Usuario> usuarios) {
        System.out.println("\nEl total de usuario/s es de " + usuarios.size() + " y son los siguientes:");//Se le muestra cuantos usuarios hay
        for (int i = 0; i < usuarios.size(); i++) {//A continuacion se rocorren uno a uno
            System.out.println(usuarios.get(i).getId() + "." + usuarios.get(i));//Se le muestran los datos basicos de cada usuario
        }
    }

    /**
     * Funcion que muestra el usuario que quiera el usuario mas detallado
     *
     * @param verdetallado
     */
    public static void mostrarUsuarioCompleto(Usuario verdetallado) {
        int i;
        System.out.println("NOMBRE:" + verdetallado.getNombre() + "  APELLIDO:" + verdetallado.getApellido() + "  EMAIL:" + verdetallado.getEmail() + "  NIF:" + verdetallado.getNif());
        if (verdetallado.getCompras().size() > 0) {
            System.out.println("COMPRAS realizadas " + verdetallado.getCompras().size());
            for (i = 0; i < (verdetallado.getCompras().size()); i++) {

                System.out.println("Compra Nº" + (i + 1) + "  " + verdetallado.getCompras().get(i));
                System.out.println("Entradas compradas " + verdetallado.getCompras().get(i).getEntradas().size());
                for (int j = 0; j < verdetallado.getCompras().get(i).getEntradas().size(); j++) {

                    System.out.println("  Entrada Nº" + (j + 1) + verdetallado.getCompras().get(i).getEntradas().get(j));

                }

            }
        } else {
            System.out.println("El usuario no ha realizado ninguna COMPRA aun");
        }
        if (verdetallado.getReservas().size() > 0) {
            System.out.println("RESERVAS realizadas " + verdetallado.getReservas().size());
            for (i = 0; i < (verdetallado.getReservas().size()); i++) {

                System.out.println("Reserva Nº" + (i + 1) + "  " + verdetallado.getReservas().get(i));
                System.out.println("Entradas reservadas " + verdetallado.getReservas().get(i).getEntradas().size());
                for (int j = 0; j < verdetallado.getReservas().get(i).getEntradas().size(); j++) {

                    System.out.println("  Entrada Nº" + (j + 1) + "  " + verdetallado.getReservas().get(i).getEntradas().get(j));

                }
            }
        } else {
            System.out.println("El usuario no ha realizado ninguna RESERVA aun");

        }
    }

    /**
     * Funcion que busca un usuario dado un id que lo 9introduce el usuario en
     * la misma funcion
     *
     * @param usuarios
     * @return el usuario completo que tenga ese id
     */
    public static Usuario buscarUsuarioporID(ArrayList<Usuario> usuarios,long idbuscado) {//Esta funcion pedira un numero id el cual lo comparara con los id de todos los usuarios que hay registrados y si encuentra coincidencia retornara ese usuario
        //En caso de que no encuentre ninguno igual retornara el objeto nulo
        Usuario usuariobuscado;
        for (int i = 0; i < usuarios.size(); i++) {//Una vez sabido ese id a buscar recorrera todos los usuarios uno por uno
            if (usuarios.get(i).getId() == idbuscado) {//Y comparando sus id , en caso de haber una coincidencia retornara ese usuario completo
                usuariobuscado = usuarios.get(i);
                return usuariobuscado;
            }
        }
        return null;//En caso de que no encuentre una coincidencia retornara el obejto nulo
    }

    /**
     * Funcion que busca un usuario dado un NIF que lo introduce el usuario en
     * la misma funcion
     *
     * @param usuarios
     * @return el usuario completo que tenga ese nif
     */
    public static Usuario buscarUsuarioporNIF(ArrayList<Usuario> usuarios, String nifusuario) {//Esta funcion pedira un NIF el cual lo comparara con los NIF de todos los usuarios que hay registrados y si encuentra coincidencia retornara ese usuario
        //En caso de que no encuentre ninguno igual retornara el objeto nulo
        Usuario usuariobuscado;
        for (int i = 0; i < usuarios.size(); i++) {//Recorrera todos los usuairos 
            if (nifusuario.equals(usuarios.get(i).getNif())) {//Y comparara los nif de los distintos usuarios con el nif a buscar
                usuariobuscado = usuarios.get(i);
                return usuariobuscado;//En caso de haber coincidencia,retorna ese usuario completo
            }
        }
        return null;//En caso de que no haya coincidencia,retornara el objeto nulo
    }

    public static int editartuUsuario(ArrayList<Usuario> usuarios, Usuario usuariologeado) {

        Scanner in = new Scanner(System.in);
        int numerodeusuario = 0, opcion = -1;
        Usuario usuarioeditado = null;

        do {

            numerodeusuario = Usuario.numeroUsuarioLogeado(usuarios, usuariologeado);//Conseguimos el numero de lista en el que esta el usuario para luego añadir ahi el editado

            System.out.println("Introduzca de nuevo sus datos para poder editarlos");

            String nombreusuario, apellidousuario, nifusuario, emailusuario;

            usuarioeditado.setId(usuariologeado.getId());//El id sera igual al anterior

            System.out.println("");

            System.out.print("¿Cual es su nombre?: ");  //Se pide el nombre
            nombreusuario = in.nextLine();  //El usuario lo introduce

            //En caso de que el campo quede vacio,supondremos que es el mismo al antes de editarlo
            if (nombreusuario.length() == 0) {
                usuarioeditado.setNombre(usuariologeado.getNombre());
            } else {
                usuarioeditado.setNombre(nombreusuario);
            }

            System.out.println("");

            System.out.print("¿Cual es su apellido?: ");  //Se pide el apellido
            apellidousuario = in.nextLine();  //El usuario lo introduce

            //En caso de que el campo quede vacio,supondremos que es el mismo al antes de editarlo
            if (apellidousuario.length() == 0) {
                usuarioeditado.setApellido(usuariologeado.getApellido());
            } else {
                usuarioeditado.setApellido(apellidousuario);
            }

            System.out.println("");

            System.out.print("¿Cual es su email?: ");//Se pide el email
            emailusuario = in.nextLine();

            //En caso de que el campo quede vacio,supondremos que es el mismo al antes de editarlo
            if (emailusuario.length() == 0) {
                usuarioeditado.setEmail(usuariologeado.getEmail());
            } else {
                usuarioeditado.setEmail(emailusuario);
            }

            System.out.println("");

            System.out.print("¿Cual es su nif?: "); //Se pedira el NIF
            nifusuario = in.nextLine();//El usuario introduce el NIF

            //En caso de que el campo quede vacio,supondremos que es el mismo al antes de editarlo
            if (nifusuario.length() == 0) {
                usuarioeditado.setNif(usuariologeado.getNif());

            } else {
                usuarioeditado.setNif(nifusuario);

            }

            do {//En caso de que no sea 1 o 0 se realizara otra iteracion

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
        return opcion;
    }

    /*metodo toString*/ @Override

    public String toString() {
        return " " + nombre + " " + apellido + "  email: " + email + "  NIF: " + nif + ".";
    }

}
