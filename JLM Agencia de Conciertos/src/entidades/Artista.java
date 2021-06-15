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
 * @author lucia
 */
public class Artista {

    private long id;
    private String nombre;
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
        return "Artista nº " + id + "; " + nombre + ", " + "cuyo género musical es " + generomusical;
    }

    public static ArrayList<Artista> convertir(Artista[] array) {
        ArrayList<Artista> ret = new ArrayList<Artista>();
        for (Artista t : array) {
            ret.add((Artista) t);
        }
        return ret;
    }

    public String data() {
        return this.id + "|" + this.nombre + "|" + this.generomusical;
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

    public static String pedirNombreArtista() {
        Scanner in = new Scanner(System.in);
        String nombreArtista;
        boolean valido = false;
        do {
            System.out.println("Introduzca el NOMBRE DEL ARTISTA: ");
            nombreArtista = in.nextLine();
            valido = Artista.validarNombre(nombreArtista);
        } while (!valido);
        return nombreArtista;
    }

    public static boolean validarNombre(String nombreArtista) {
        if ((nombreArtista.length() > 3 && nombreArtista.length() < 15)) {
            if (nombreArtista.matches(".*[^a-z-A-Z].*")) {
                System.out.println("El NOMBRE del Artista introducido es inválido.");
                return false;
            }
        }
        return true;
    }

    public static char pedirGeneroMusical() {
        Scanner in = new Scanner(System.in);
        char generomusical;
        boolean valido = false;
        do {
            System.out.println("Introduzca el GÉNERO MUSICAL DEL ARTISTA: ");
            generomusical = in.next().charAt(0);
            valido = Artista.validarGeneroMusical(generomusical);
        } while (!valido);
        return generomusical;
    }

    public static boolean validarGeneroMusical(char generomusical) {

        return false;
    }

    public static long pedirIdArtista() {
        long masalto = 0;
        if (Utilidades.ARTISTAS.length == 0) {

        } else {
            for (int i = 0; i < Utilidades.ARTISTAS.length; i++) {
                if (Utilidades.ARTISTAS[i].getId() > masalto) {
                    masalto = Utilidades.ARTISTAS[i].getId();
                }
            }
        }
        masalto++;
        return masalto;
    }

    public static Artista leerArtistaTeclado() {
        long idArtista;
        String nombreArtista;
        char generomusical;
        Artista ret = new Artista();
        //ID DEL ARTISTA
        idArtista = Artista.pedirIdArtista();
        System.out.println("El ID del Artista será el " + idArtista);
        ret.setId(idArtista);
        //NOMBRE DEL ARTISTA
        nombreArtista = Artista.pedirNombreArtista();
        ret.setNombre(nombreArtista);
        //GÉNERO MUSICAL DEL ARTISTA
        generomusical = Artista.pedirGeneroMusical();
        ret.setGeneromusical(generomusical);
        return ret;
    }

    public static ArrayList<Artista> cargarArtistas() {
        ArrayList<Artista> artistas = new ArrayList<Artista>();
        for (int i = 0; i < Utilidades.ARTISTAS.length; i++) {
            artistas.add(Utilidades.ARTISTAS[i]);
        }
        return artistas;
    }

}
