package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de Artista
public class Artista {

    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VÁLIDOS: solo será válido las cadenas de carácteres comprendidas entre 2 y 40 carácteres
    //VALORES INVÁLIDOS: Cadena de caracteres con caracteres no permitidos: '_', '&', '#' , ',' ':', ';' '?', '¿', '!','¡', '+', '*', '/', '\', '', cadenas de carácteres mayores de 40 y menores de 2.                       
    private String nombre;
    //VALORES VÁLIDOS: solo están permitidos los valores de tipo char, cuyo valor solo puede ser una letra comprendida entre [A-Z] en mayúscula.
    //VALORES INVÁLIDOS: valores que no sean de tipo char, valores en minúsculas, o la introducción de carácteres no permitidos como: '_', '&', '#' , ',' ':', ';' '?', '¿', '!','¡', '+', '*', '/', '\', ''
    private char generomusical;

    public Artista() {
    }

    public Artista(long id, String nombre, char generomusical) {
        this.id = id;
        this.nombre = nombre;
        this.generomusical = generomusical;
    }

    public Artista(Artista ar) {
        this.id = ar.id;
        this.nombre = ar.nombre;
        this.generomusical = ar.generomusical;
    }

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

    public char getGeneromusical() {
        return generomusical;
    }

    public void setGeneromusical(char generomusical) {
        this.generomusical = generomusical;
    }

    @Override
    public String toString() {
        return "Artista" + "\nId del artista:" + id + "\nNombre del artista:" + nombre + "\nGénero musical del artista:" + generomusical;
    }

    public static ArrayList<Artista> convertir(Artista[] array) {
        ArrayList<Artista> ret = new ArrayList<Artista>();
        for (Artista t : array) {
            ret.add((Artista) t);
        }
        return ret;
    }

    public static ArrayList<Artista> arrayde(ArrayList<Artista> lista, int[] ids) {
        ArrayList<Artista> ret = new ArrayList<Artista>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getId() es propio de Artista
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Artista) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    public static Artista nuevoArtista() {
        Artista ret = new Artista();
        Scanner in = new Scanner(System.in);
        long idartista;
        do {
            System.out.println("Introduzca el id del artista:");
            idartista = in.nextLong();
            ret.setId(idartista);
            if (idartista <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (idartista <= 0);
        String nombreartista;
        boolean fallo = true;
        do { //Pedira un nombre(String) pero este no podra tener numeros,ni estar vacio o tener un espacio ya que en ese caso lo volvera a pedir hasta que este sea correcto con lo anterior

            System.out.print("Introduzca el nombre del artista: ");  //Se pide el nombre
            nombreartista = in.next();
            ret.setNombre(nombreartista);

            for (int i = 0; i < nombreartista.length(); i++) {  //Se mira si contiene numeros
                if (Character.isDigit(nombreartista.charAt(i))) {
                    fallo = true;
                    System.out.println("El nombre introducido contiene numeros,inntroduzcalo de nuevo");    //Si contiene numeros muestra este mensaje
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((nombreartista.equals("")) || (nombreartista.equals(" "))) {
                System.out.println("No has introducido ningun nombre,es necesario introducir uno");//Si no se introduce nada muestra este mensaje
            }

        } while ((nombreartista.equals("")) || (nombreartista.equals(" ")) || (fallo == true));//Si esta vacio o contiene numeros vuelve a pedir el nombre

        System.out.println("");

        System.out.println("Introduzca el genero musical del artista");
        char generomusical = in.next().charAt(0);
        ret.setGeneromusical(generomusical);
        return ret;
    }
}
