package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de Artista
public class Artista {

    private long id;
    private String nombre;
    private char generomusical;
    private ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
    private ArrayList<Individual> individuales = new ArrayList<Individual>();
    private ArrayList<Colaboracion> colaboraciones = new ArrayList<Colaboracion>();

    public Artista() {
    }

    public Artista(long id, String nombre, char generomusical, ArrayList<Actuacion> actuaciones, ArrayList<Individual> individuales, ArrayList<Colaboracion> colaboraciones) {
        this.id = id;
        this.nombre = nombre;
        this.generomusical = generomusical;
        this.actuaciones = actuaciones;
        this.individuales = individuales;
        this.colaboraciones = colaboraciones;
    }

    public Artista(Artista ar) {
        this.id = ar.id;
        this.nombre = ar.nombre;
        this.generomusical = ar.generomusical;
        this.actuaciones = ar.actuaciones;
        this.individuales = ar.individuales;
        this.colaboraciones = ar.colaboraciones;
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

    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(ArrayList<Actuacion> actuaciones) {
        this.actuaciones = actuaciones;
    }

    public ArrayList<Individual> getIndividuales() {
        return individuales;
    }

    public void setIndividuales(ArrayList<Individual> individuales) {
        this.individuales = individuales;
    }

    public ArrayList<Colaboracion> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(ArrayList<Colaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", generomusical=" + generomusical + ", actuaciones=" + actuaciones + ", individuales=" + individuales + ", colaboraciones=" + colaboraciones + '}';
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
                //el método getCodigo() es propio de Producto
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
        } while (idartista <=0);
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
