/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import dao.UsuarioDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucia
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 92384220498345203L;
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
    private Boolean administrador;
    private String contraseña;
    private int idDireccion;
    private int idBancario;
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

    public Usuario(String nombre, String apellido, String email, String nif) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
    }

    public Usuario(String nombre, String apellido, String email, String nif, Boolean administrador, String contraseña) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.administrador = administrador;
        this.contraseña = contraseña;
    }
    public Usuario(String nombre, String apellido, String email, String nif, Boolean administrador, String contraseña,int iddireccion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.administrador = administrador;
        this.contraseña = contraseña;
        this.idDireccion = iddireccion;
    }
    public Usuario(String nombre, String apellido, String email, String nif, Boolean administrador, String contraseña,int iddireccion,int idbancario) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.administrador = administrador;
        this.contraseña = contraseña;
        this.idDireccion = iddireccion;
         this.idBancario = idbancario;
    }
    public Usuario(int id,String nombre, String apellido, String email, String nif, Boolean administrador, String contraseña,int iddireccion) {
        this.id= id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.administrador = administrador;
        this.contraseña = contraseña;
        this.idDireccion = iddireccion;
    }
    public Usuario(int id,String nombre, String apellido, String email, String nif, Boolean administrador, String contraseña,int iddireccion,int idbancario) {
        this.id= id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.administrador = administrador;
        this.contraseña = contraseña;
        this.idDireccion = iddireccion;
        this.idBancario = idbancario;
    }
    

    public Usuario(int id, String nombre, String apellido, String email, String nif, Boolean administrador, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.administrador = administrador;
        this.contraseña = contraseña;
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

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdBancario() {
        return idBancario;
    }

    public void setIdBancario(int idBancario) {
        this.idBancario = idBancario;
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
        //idusuario = Usuario.idUsuario(); //En idusuario se guardara lo que retorne de la funcion idUusairo 
       // System.out.println("Su id de usuario sera el " + idusuario);//Se le muestra por pantalla que id tiene
        nuevousuario.setId(2);//Se settea la variable idusuario en el objeto nuevousuario
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
        System.out.println("");
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
        if ((nombreusuario.length() > 3 && nombreusuario.length() < 13)) { //Se mirara que el nombre de usuario tenga un minimo de 3 letras y un maximo de 15  
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
        if ((apellidousuario.length() > 2 && apellidousuario.length() < 13)) { //Se mirara que el nombre de usuario tenga un minimo de 3 letras y un maximo de 15  
            //Una vez mirado que lalongitud del nombre sea corecta se miraraque solo contenga letras
            if (apellidousuario.matches(".*[^a-z-A-Z].*")) { //Buscara si el nombre de usuario tiene caracteres que son distintos a letras
                System.out.println("El apellido introducido contiene caracteres invalidos,inntroduzcalo de nuevo(Solo letras)");    //Si contiene caracteres distintos a letras muestra este mensaje 
                return false;//En caso de contener caracteres que no0 son solo letras mayusculas retornara false
            }
            return true;//En caso de que todo este corecto retornara true
        } else {
            if (apellidousuario.length() < 2) {//Si el apellido tiene menos de cuatro letras se muestra un mensaje
                System.out.println("El apellido introducido no contiene el minimo de 4 letras,por favor introduzcalo de nuevo");
            }
            if (apellidousuario.length() > 13) {//Si el apellido tiene mas de quince letras se muestra un mensaje
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

        //Mirando por internet encontre este metodo por el cual valida un email
        //Es un poco mas avanzado ya que usa patrones pero YO LO ENTIENDO, lo dejo comentado por si mas adelante me seria util
        Boolean valido = false;
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(emailusuario);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            valido = true;
        } else {
            System.out.println("El email ingresado es inválido.");
            valido = false;
        }
   
        return valido;
    }

    /**
     * Funcion que obtiene el id proximo al ultimo idusuario de nuestrta base de
     * datos
     *
     * @return long el cual es el id del usuario nuevo
     */
    /*public static long idUsuario() {//Metodo para conseguir el id de forma automatica(se le suma uno al numero mas grande de id que haya)
        long masalto = 0;
        if (Utilidades.USUARIOS.length == 0) {     //En caso de que no haya ningun objeto se empezara en uno

        } else {
            for (int i = 0; i < Utilidades.USUARIOS.length; i++) {//Busca el id mas grande que hay entre los objetos y le suma 1
                if (Utilidades.USUARIOS[i].getId() > masalto) {
                    masalto = Utilidades.USUARIOS[i].getId();
                }
            }
        }
        masalto++; //Sea cual sea se le suma 1,es decir si no hay usuarios aun retornara 1 y en caso de que hayaretornara qal siguiente del ultimo
        return masalto; //Se devuelve el nuevo id
    }*/

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
    /*public static ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//Creamos un array vacio llamado usaurios
        for (int i = 0; i < Utilidades.USUARIOS.length; i++) { //Recorremos el array encontrado en la clase utilidades
            usuarios.add(Utilidades.USUARIOS[i]);//Y vamos añadiendo cada usuario a nuestro nuevo array vacio
        }
        return usuarios;//Devuelve el array que declaramos al principio de la funcion
    }*/

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
        System.out.println("\nNOMBRE:" + verdetallado.getNombre() + "  APELLIDO:" + verdetallado.getApellido() + "  EMAIL:" + verdetallado.getEmail() + "  NIF:" + verdetallado.getNif());
        if (verdetallado.getCompras().size() > 0) {
            System.out.println("--COMPRAS realizadas--");
            for (i = 0; i < (verdetallado.getCompras().size()); i++) {
                System.out.println("  -Compra Nº " + (i + 1) + "  " + verdetallado.getCompras().get(i));
                System.out.println("   --ENTRADAS compradas--");
                for (int j = 0; j < verdetallado.getCompras().get(i).getEntradas().size(); j++) {
                    System.out.println("     -Entrada Nº " + (j + 1) + "  " + verdetallado.getCompras().get(i).getEntradas().get(j));
                }
            }
        } else {
            System.out.println("El usuario no ha realizado ninguna COMPRA aun");
        }
        if (verdetallado.getReservas().size() > 0) {
            System.out.println("--RESERVAS realizadas--");
            for (i = 0; i < (verdetallado.getReservas().size()); i++) {
                System.out.println("  -Reserva Nº " + (i + 1) + "  " + verdetallado.getReservas().get(i));
                System.out.println("   --ENTRADAS reservadas--");
                for (int j = 0; j < verdetallado.getReservas().get(i).getEntradas().size(); j++) {
                    System.out.println("     -Entrada Nº " + (j + 1) + "  " + verdetallado.getReservas().get(i).getEntradas().get(j));
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
    public static Usuario buscarUsuarioporID(ArrayList<Usuario> usuarios, long idbuscado) {//Esta funcion pedira un numero id el cual lo comparara con los id de todos los usuarios que hay registrados y si encuentra coincidencia retornara ese usuario
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

    public static Usuario editartuUsuario(Usuario usuariologeado) {

        Scanner in = new Scanner(System.in);
        Usuario usuarioeditado = new Usuario();
        String nombreusuario, apellidousuario, nifusuario, emailusuario;

        System.out.println("Introduzca de nuevo sus datos para poder editarlos");
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
        return usuarioeditado;
    }

    public String data() {
        return this.id + "|" + this.nombre + "|" + this.apellido + "|" + this.email + "|" + this.nif;
    }

    public void guardarUsuarioTexto() {

        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("UsuarioenTexto.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
        }

    }

    public static void guardarListaUsuariosTexto(ArrayList<Usuario> usuarios) {

        BufferedWriter bw = null;
        File f = new File("UsuariosenTexto.txt");
        try {
            FileWriter fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            for (Usuario u : usuarios) {
                bw.write(u.data());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Error");
            }

        }

    }

    public static ArrayList<Usuario> importarUsuariosTexto(String ruta) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario nuevo = new Usuario();
        String texto;
        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    nuevo.setId(Long.valueOf(array[0]));
                    nuevo.setNombre(array[1]);
                    nuevo.setApellido(array[2]);
                    nuevo.setNif(array[3]);
                    nuevo.setEmail(array[4]);
                    usuarios.add(nuevo);
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return usuarios;

    }

    public static ArrayList obtenerNIFs(String ruta) {

        ArrayList nifs = new ArrayList<>();
        String nuevo;
        String texto;
        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\\n");
                    nuevo = array[0];
                    nifs.add(nuevo);
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return nifs;

    }

    public static Usuario obtenerUsuarioPorID(long id) {
        Usuario nuevo = new Usuario();
        String texto;
        File f = new File("UsuariosenTexto.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    if (Long.valueOf(array[0]) == id) {
                        nuevo.setId(Long.valueOf(array[0]));
                        nuevo.setNombre(array[1]);
                        nuevo.setApellido(array[2]);
                        nuevo.setNif(array[3]);
                        nuevo.setEmail(array[4]);

                        return nuevo;
                    }
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
        return nuevo;
    }

    public void guardarUsuarioBinario() {

        ObjectOutputStream objetoSalida = null;
        try {
            String nombreFichero = "UsuarioenBinario.dat";
            FileOutputStream ficheroSalida = new FileOutputStream(nombreFichero);
            objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(this);

        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                objetoSalida.close();
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void guardarListaUsuariosBinario(ArrayList<Usuario> usuarios) {

        ObjectOutputStream out = null;
        try {
            OutputStream os = new FileOutputStream("UsuariosenBinario.txt");
            out = new ObjectOutputStream(os);
            out.writeObject(usuarios);
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("No se ha podido cerrar el Stream");
            }
        }

    }

    public static ArrayList<Usuario> importarUsuariosBinario(String ruta) {

        ArrayList<Usuario> ret = new ArrayList<Usuario>();
        try {
            InputStream is = new FileInputStream(ruta);
            ObjectInput oi = new ObjectInputStream(is);
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) oi.readObject();
            for (Usuario u : usuarios) {
                System.out.println("Se ha importado con exito el usuario: ");
                System.out.println(u.data());
                ret.add(u);
            }
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ret;

    }

    public static boolean buscarIniciodeSesion(String nifbuscado, String contraseñabuscada) {

        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        System.out.println(nifbuscado);
        System.out.println(contraseñabuscada);
        for (int i = 0; i < todosUsuarios.size(); i++) {
            System.out.println(todosUsuarios.get(i).getContraseña());
            System.out.println(todosUsuarios.get(i).getNif());
            if ((contraseñabuscada.equals(todosUsuarios.get(i).getContraseña())) && (nifbuscado.equals(todosUsuarios.get(i).getNif()))) {
                return true;
            }
        }
        return false;
    }

    public static Boolean buscarEmail(String emailbuscado) {
        Boolean ret = false;
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if (emailbuscado.equals(todosUsuarios.get(i).getEmail())) {
                ret = true;
            }
        }
        return ret;
    }

    public static Boolean buscarNIF(String nifbuscado) {
        Boolean ret = false;
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if (nifbuscado.equals(todosUsuarios.get(i).getNif())) {
                ret = true;
            }
        }
        return ret;
    }

    public static long buscarIDdadoemail(String email) {
        long idbuscado = 0;
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if (email.equalsIgnoreCase(todosUsuarios.get(i).getEmail())) {
                idbuscado = todosUsuarios.get(i).getId();
                break;
            }
        }
        return idbuscado;
    }

    public static Usuario buscarUsuarioporEmail(String emailusuario) {
        Usuario ret = new Usuario();
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if (emailusuario.equals(todosUsuarios.get(i).getEmail())) {
                ret = todosUsuarios.get(i);
                break;
            }
        }
        return ret;
    }
    
    public static Usuario buscarUsuarioporNIF(String nif) {
        Usuario ret = new Usuario();
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if (nif.equals(todosUsuarios.get(i).getNif())) {
                ret = todosUsuarios.get(i);
                System.out.println(ret.getAdministrador()+" "+ret.getIdDireccion());
                break;
            }
        }
        return ret;
    }

    public static Boolean contraseñaValida(String contraseña) {
        if (contraseña.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")) {
            return true;
        }
        return false;
    }

    public static Boolean esAdministrador(String nifusuario) {

        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if (nifusuario.equals(todosUsuarios.get(i).getNif())) {
                if (todosUsuarios.get(i).getAdministrador()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean validarContraseña(String contraseña) {

        if (contraseña.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")) {
            return true;
        }

        return false;
    }

    public static Boolean buscarUsuarioporNombreApellidoEmailNIF(String nombre, String apellido, String email, String nif) {
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        todosUsuarios = u.todosUsuarios();
        for (int i = 0; i < todosUsuarios.size(); i++) {
            if ((nombre.equalsIgnoreCase(todosUsuarios.get(i).getNombre())) && (apellido.equalsIgnoreCase(todosUsuarios.get(i).getApellido())) && (email.equalsIgnoreCase(todosUsuarios.get(i).getEmail())) && (nif.equalsIgnoreCase(todosUsuarios.get(i).getNif()))) {
                return true;
            }
        }
        return false;
    }

    /*metodo toString*/ @Override

    public String toString() {
        return " " + nombre + " " + apellido + "  email: " + email + "  NIF: " + nif + ".";
    }

}
