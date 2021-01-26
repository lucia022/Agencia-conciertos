
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de Actuacion
public class Actuacion {
    
    private long id;
    private long numerosecuencia; 
    private double duracion;
    private ArrayList<Artista> artistas = new ArrayList<Artista>();
    
     public Actuacion(){}

    public Actuacion(long id, long numerosecuencia, double duracion, ArrayList<Artista> artistas) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion;
        this.artistas = artistas;
    }
    
    public Actuacion(Actuacion a){
        this.id = a.id;
        this.duracion = a.duracion;
        this.artistas = a.artistas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumerosecuencia() {
        return numerosecuencia;
    }

    public void setNumerosecuencia(long numerosecuencia) {
        this.numerosecuencia = numerosecuencia;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Actuacion{" + "id=" + id + ", numerosecuencia=" + numerosecuencia + ", duracion=" + duracion + ", artistas=" + artistas + '}';
    }
    
    public static ArrayList<Actuacion> convertir(Actuacion[] array) {
        return new Actuacion().convertir(array);
    }
    
      public static ArrayList<Actuacion> arrayde(ArrayList<Actuacion> lista, int[] ids) {
        ArrayList<Actuacion> ret = new ArrayList<Actuacion>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getCodigo() es propio de Producto
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Actuacion) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

      public static ArrayList<Actuacion> todosActuaciones() {   //Metodo para copiar todos los objetos de utilidades en un arraylist y poder manipularlo

        ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
        for (int i = 0; i < Utilidades.USUARIOS.length; i++) {

            actuaciones.add(Utilidades.ACTUACIONES[i]);
        }
        return actuaciones;
    }

    public static Actuacion nuevoActuacion(){
        Actuacion ret = new Actuacion();
        Scanner in = new Scanner(System.in);
        long idactuacion;
        do {
            System.out.println("Introduzca el id de la actuacion:");
            idactuacion = in.nextLong();
            ret.setId(idactuacion);
            if (idactuacion <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (idactuacion <=0);
       
        //En caso de que no se quiera pedir por teclado, Se le suma uno a la cantidad de actuaciones que existan en utilidades
        /*ret.setId(Utilidades.numActuaciones + 1);*/
        
        System.out.println("Introduzca el número de secuencia de la actuación: ");
        long numerosecuencia = in.nextLong();
        ret.setNumerosecuencia(numerosecuencia);
        
        System.out.println("Introduzca la duración de la actuación:");
        double duracion = in.nextDouble();
        ret.setDuracion(duracion);
        return ret;
    }

}
