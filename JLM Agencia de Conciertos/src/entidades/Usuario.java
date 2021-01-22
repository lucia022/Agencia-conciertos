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
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) , aquellas cadenas que contengan cualquier caracter distinto a letras y cadenas que no contengan un minimo de  3 caracteres.
    private String nombre;
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) , aquellas cadenas que contengan cualquier caracter distinto a letras y cadenas que no contengan un minimo de  4 caracteres.
    private String apellido;
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) y aquellas cadenas que no contengan un @ al menos,ya que se trata de un email.
    private String email;
    //VALORES VALIDOS: Cadenas de caracteres(String).
    //VALORES NO VALIDOS: Todo lo que no sean cadenas de caracteres(String) y aquellas cadenas que contengan mas o menos de 9 caracteres,ya que se trata de un NIF.Ademas debe de tener el formato correcto que es 8 numeros y 1 letra mayuscula
    private String nif;

    /*constructor por defecto*/
    public Usuario() {
    }

    /*constructor con parámetros*/
    public Usuario(long id, String nombre, String apellido, String email, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
    }

    /*constructor de copia*/
    public Usuario(Usuario u) {
        this.id = u.id;
        this.nombre = u.nombre;
        this.apellido = u.apellido;
        this.email = u.email;
        this.nif = u.nif;
    }

    /*getters y setters de cada atributo*/
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

    public static Usuario nuevoUsuario() {

        Usuario nuevousuario = new Usuario();
        Scanner in = new Scanner(System.in);

        long idusuario;
        String nombreusuario, apellidousuario, nifusuario, emailusuario;
        boolean fallo = true;

        //En caso de que el id quiera ser pedido por teclado
        /*do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su usuario?: ");//Pide el id de usuario
            idusuario = in.nextLong();

            if ((idusuario <= 0)) {
                System.out.println("El id introducido no es valido ya que " + idusuario + " es menor que 1,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((idusuario <= 0));//Se pedira otra vez el id siempre que este sea menor que 1
        nuevousuario.setId(idusuario);//Se setea el id del usuario*/
        
        //En caso de que quiera ser automatico
        idusuario = Usuario.idUsuario();
        System.out.println("Su id de usuario sera el "+idusuario);
        nuevousuario.setId(idusuario);
        

        System.out.println("");

        do { //Pedira un nombre(String) pero este no podra tener caracteres que no sean letras,ni tener menos de tres caracteres ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior
            in = new Scanner(System.in);

            System.out.print("¿Cual es su nombre?: ");  //Se pide el nombre
            nombreusuario = in.nextLine();  //El usuario lo introduce

            if ((nombreusuario.matches(".*[^a-z-A-Z].*"))) { //Buscara si el nombre de usuario tiene caracteres que son distintos a letras
                fallo = true;
                System.out.println("El nombre introducido contiene caracteres invalidos,inntroduzcalo de nuevo");    //Si contiene caracteres distintos a letras muestra este mensaje y sale del ciclo
                continue;  //Tras ver que el nombre del usuario contiene caracteres distintos a letras pasara a la siguiente iteracion           

            } else {
                fallo = false;
         
            }

            if ((nombreusuario.length() < 3)) { //Se mirara que el nombre de usuario tenga un minimo de 3 letras
                fallo = true;
                System.out.println("El nombre introducido no contiene el minimo de 3 letras,por favor introduzcalo de nuevo");//En caso de tener m,enos de tres se mostrara el siguiente mensaje

            }
            if ((nombreusuario.length() > 15)) { //Se mirara que el nombre de usuario no tenga mas de 15 letras
                fallo = true;
                System.out.println("El nombre introducido contiene mas del maximo de letras permitidasa(15),por favor introduzcalo de nuevo");//En caso de tener m,enos de tres se mostrara el siguiente mensaje

            }

        } while (fallo);//Si contiene caracteres de menos de tres letras el nombre sera pedido de nuevo al usuario
        nuevousuario.setNombre(nombreusuario);//Se setea el nombre del usuario

        System.out.println("");

        do { //Pedira un apellido(String) pero este no podra tener caracteres que no sean letras,ni tener menos de cuatro caracteres ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior
            in = new Scanner(System.in);

            System.out.print("¿Cual es su apellido?: ");  //Se pide el apellido
            apellidousuario = in.nextLine();  //El usuario lo introduce

            if ((apellidousuario.matches(".*[^a-z-A-Z].*"))) { //Buscara si el apellido de usuario tiene caracteres que son distintos a letras
                fallo = true;
                System.out.println("El apellido introducido contiene caracteres invalidos,inntroduzcalo de nuevo");    //Si contiene caracteres distintos a letras muestra este mensaje y sale del ciclo
                continue;  //Tras ver que el apellido del usuario contiene caracteres distintos a letras pasara a la siguiente iteracion           

            } else {
                fallo = false;
         
            }

            if ((apellidousuario.length() < 4)) { //Se mirara que el apellido de usuario tenga un minimo de 4 letras
                fallo = true;
                System.out.println("El apellido introducido no contiene el minimo de 4 letras,por favor introduzcalo de nuevo");//En caso de tener menos de cuatro letras se mostrara el siguiente mensaje

            }
            if ((apellidousuario.length() > 15)) { //Se mirara que el apellido de usuario no tenga mas de 15 letras
                fallo = true;
                System.out.println("El apellido introducido contiene mas del maximo de letras permitidasa(15),por favor introduzcalo de nuevo");//En caso de tener m,enos de tres se mostrara el siguiente mensaje

            }

        } while (fallo);//Si contiene caracteres de  menos de tres letras el apellido sera pedido de nuevo al usuario
        nuevousuario.setApellido(apellidousuario);//Se setea el apellido del usuario

        System.out.println("");

          do { //Pedira un email(String) el cual  no podra quedar vacio y debera contener al menos un arroba, en caso contrario se volvera a pedir email hasta que esto se cumpla
            in = new Scanner(System.in);

            System.out.print("¿Cual es su email?: ");//Se pide el email
            emailusuario = in.nextLine();

            for (int i = 0; i < emailusuario.length(); i++) {//Se mira si contiene arroba y si lo tiene sale del ciclo
                if (emailusuario.charAt(i) == '@') {
                    fallo = false;
                    break;
                } else {
                    fallo = true;
                }
            }

            if ((emailusuario.equals("")) || (emailusuario.equals(" "))) {//En caso de estar vacio se mostrara el siguiente mesaje
                System.out.println("No has introducido ningun email,es necesario introducir uno");//En caso de estar vacio se muestra este mensaje
            }

            if (fallo == true) {//En caso de no contener un @ se mostrara el siguiente mensaje
                System.out.println("falta el @, por favor introduzcalo de nuevo");
            }

        } while (fallo); //En caso de que este el email vacio o este no contenga un @ se le volvera a pedir al usuario
        nuevousuario.setEmail(emailusuario);

      
        System.out.println("");

        
        do {    //Pedira un nif(String) el cual no podra quedar vacio nI contener mas ni menos de 9 caracteres o se volvera a pdeir el nif hasta que esto sea cierto
            //Ademas tendra que ser de la siguiente manera 8 numeros y 1 letra en mayusculas o volvera a pedir al usuario
            in = new Scanner(System.in);
            String numeros = "", letra = "";

            System.out.print("¿Cual es su nif?: "); //Se pedira el NIF
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
        nuevousuario.setNif(nifusuario);//Se setea el nif

        return nuevousuario;
    }

    public static long idUsuario() {//Metodo para conseguir el id de forma automatica(se le suma uno al numero mas grande de id que haya)

        long masalto = 0;
        if(Utilidades.USUARIOS.length == 0){     //En caso de que no haya ningun objeto se empezara en uno
            
        }
        else{
        for (int i = 0; i < Utilidades.numUsuarios; i++) {//Busca el id mas grande que hay entre los objetos y le suma 1

            if (Utilidades.USUARIOS[i].getId() > masalto) {
                masalto = Utilidades.USUARIOS[i].getId(); 
            }
        }
        }
        masalto++;   
        return masalto;
    }

    
    public static ArrayList<Usuario> todosUsuarios(){   //Metodo para copiar todos los objetos de utilidades en un arraylist y poder manipularlo
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        for(int i = 0;i< Utilidades.USUARIOS.length;i++){
            
            usuarios.add(Utilidades.USUARIOS[i]);
        }
        return usuarios;
    }
    
    
    public static Usuario inicioSesion(){
        
        Usuario iniciodesesion = new Usuario();
        Scanner in = new Scanner(System.in);
        String emailusuario,nifusuario;
        Boolean fallo = true;
        
        do { //Pedira un email(String) el cual  no podra quedar vacio y debera contener al menos un arroba, en caso contrario se volvera a pedir email hasta que esto se cumpla
            

            System.out.print("¿Cual es su email?: ");//Se pide el email
            emailusuario = in.nextLine();

            for (int i = 0; i < emailusuario.length(); i++) {//Se mira si contiene arroba y si lo tiene sale del ciclo
                if (emailusuario.charAt(i) == '@') {
                    fallo = false;
                    break;
                } else {
                    fallo = true;
                }
            }

            if ((emailusuario.equals("")) || (emailusuario.equals(" "))) {//En caso de estar vacio se mostrara el siguiente mesaje
                System.out.println("No has introducido ningun email,es necesario introducir uno");//En caso de estar vacio se muestra este mensaje
            }

            if (fallo == true) {//En caso de no contener un @ se mostrara el siguiente mensaje
                System.out.println("falta el @, por favor introduzcalo de nuevo");
            }

        } while (fallo); //En caso de que este el email vacio o este no contenga un @ se le volvera a pedir al usuario
        iniciodesesion.setEmail(emailusuario);

      
        System.out.println("");

        
        do {    //Pedira un nif(String) el cual no podra quedar vacio nI contener mas ni menos de 9 caracteres o se volvera a pdeir el nif hasta que esto sea cierto
            //Ademas tendra que ser de la siguiente manera 8 numeros y 1 letra en mayusculas o volvera a pedir al usuario
            in = new Scanner(System.in);
            String numeros = "", letra = "";

            System.out.print("¿Cual es su nif?: "); //Se pedira el NIF
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
        iniciodesesion.setNif(nifusuario);//Se setea el nif

        return iniciodesesion;
        
        
    }
    
    
    
    /*metodo toString*/
    @Override
    public String toString() {
        return " "+ nombre + " " + apellido + "  email:" + email + "  NIF:" + nif + "\n";
    }
    

}
