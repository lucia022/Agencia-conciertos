/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Usuario {

    //Todos los atributos no podran quedar vacios
    //El id solo podra ser un numero mayor estricto que 0 es decir no podra ser ni 0 ni negativo
    private long id;
    //El nombre solo podra ser una cadena de caracteres(String) sin numeros
    private String nombre;
    //El nombre solo podra ser una cadena de caracteres(String) sin numeros
    private String apellido;
    //El email debera tener un arroba aunque sea
    private String email;
    //El NIF debera ser un conjunto de numeros y letras pero que solo podra tener 9 caracteres
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
        String nombreusuario, apellidousuario,nifusuario,emailusuario;
        boolean fallo = true,repetir;

        //En caso de que el id quiera ser pedido por teclado
        do {//Pedira un id(long) el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que sea mayor que cero

            System.out.print("¿Cual es el id de su usuario?: ");
            idusuario = in.nextLong();

            System.out.print("¿" + idusuario + " es su id?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();

            if (repetir == false) {
                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if ((idusuario <= 0)) {
                System.out.println("El id introducido no es valido ya que " + idusuario + " es menor que 1,introduzcalo de nuevo"); //En caso de que este sea menor igual que cero se mostrara un mensaje para advertir de que es erroneo.
            }

        } while ((idusuario <= 0) || (repetir == false));
        nuevousuario.setId(idusuario);
        
        //En caso de que no se quiera pedir por teclado
        nuevousuario.setId(Utilidades.numUsuarios + 1); //Se le suma uno a la cantidad de usuarios que existan en utilidades

        
        System.out.println("");

        
        do { //Pedira un nombre(String) pero este no podra tener numeros,ni estar vacio o tener un espacio ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior
            in = new Scanner(System.in);

            System.out.print("¿Cual es su nombre?: ");  //Se pide el nombre
            nombreusuario = in.nextLine();

            System.out.print("¿" + nombreusuario + " es su nombre?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();
            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            for (int i = 0; i < nombreusuario.length(); i++) {  //Se mira si contiene numeros
                if (Character.isDigit(nombreusuario.charAt(i))) {
                    fallo = true;
                    System.out.println("El nombre introducido contiene numeros,inntroduzcalo de nuevo");    //Si contiene numeros muestra este mensaje y sale del ciclo
                    break;
                } else {
                    fallo = false;
                }
            }
            if ((nombreusuario.equals("")) || (nombreusuario.equals(" "))) {
                System.out.println("No has introducido ningun nombre,es necesario introducir uno");//Si no se introduce nada muestra este mensaje
            }

        } while ((nombreusuario.equals("")) || (nombreusuario.equals(" ")) || (fallo == true) || (repetir == false));//Si esta vacio o contiene numeros vuelve a pedir el nombre
        nuevousuario.setNombre(nombreusuario);

        
        System.out.println("");

        
        do { //Pedira un apellido(String) pero este no podra tener numeros,ni estar vacio o tener un espacio ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior
            in = new Scanner(System.in);

            System.out.print("¿Cual es su apellido?: ");//Se pide el apellido
            apellidousuario = in.nextLine();

            System.out.print("¿" + apellidousuario + " es su apellido?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();
            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            for (int i = 0; i < apellidousuario.length(); i++) {//Se mira si contiene numeros
                if (Character.isDigit(apellidousuario.charAt(i))) {
                    fallo = true;
                    System.out.println("El apellido introducido contiene numeros,inntroduzcalo de nuevo");//Si contiene numeros muestra este mensaje
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((apellidousuario.equals("")) || (apellidousuario.equals(" "))) {
                System.out.println("No has introducido ningun apellido,es necesario introducir uno");//Si esta vacio muestra este mensaje
            }

        } while ((apellidousuario.equals("")) || (apellidousuario.equals(" ")) || (fallo == true) || (repetir == false));//En caso de estar vacio o contener numeros se volvera a pedir el apellido
        nuevousuario.setApellido(apellidousuario);

        
        System.out.println("");

        
        do { //Pedira un email(String) el cual  no podra quedar vacio y debera contener al menos un arroba, en caso contrario se volvera a pedir email hasta que esto se cumpla
            in = new Scanner(System.in);

            System.out.print("¿Cual es su email?: ");//Se pide el email
            emailusuario = in.nextLine();

            System.out.print("¿" + emailusuario + " es su email?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();
            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

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

        } while ((emailusuario.equals("")) || (emailusuario.equals(" ")) || (fallo == true) || (repetir == false)); //En caso de que este el email vacio o este no contenga un @ se le volvera a pedir al usuario
        nuevousuario.setEmail(emailusuario);

        
        System.out.println("");

        
        do {    //Pedira un nif(String) el cual no podra quedar vacio ni contener mas ni menos de 9 caracteres o se volvera a pdeir el nif hasta que esto sea cierto
            in = new Scanner(System.in);

            System.out.print("¿Cual es su nif?: "); //Se pedira el NIF
            nifusuario = in.nextLine();

            System.out.print("¿" + nifusuario + " es su NIF?(true en caso afirmativo y false en negativo): ");//Se le dice al usuario lo que ha introducido y le pregunta si esta bien
            repetir = in.nextBoolean();
            if (repetir == false) {

                System.out.println("Vale,entonces introduzcalo de nuevo");//En caso negativo vuelve a preguntar
                continue;
            }

            if (nifusuario.length() != 9) {
                System.out.println("NIF invalido por no ser 9 carazteres,por favor introduzcalo de nuevo");//En caso de tener mas de 9 o menos de 90 caracteres saldra el siguiente mensahje
            }

            if ((nifusuario.equals("")) || (nifusuario.equals(" "))) {
                System.out.println("No has introducido ningun NIF,es necesario introducir uno");//En caso de estar vacio se muestra este mensaje
            }
        } while ((nifusuario.equals("")) || (nifusuario.equals(" ")) || (nifusuario.length() != 9) || (repetir == false)); //Si el NIF esta vacio o este tiene mas o menos de 9 caractertes se volvera a pedir al usuario el NIF
        nuevousuario.setNif(nifusuario);

        return nuevousuario;
    }

    /*metodo toString*/
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", nif=" + nif + '}';
    }

}
