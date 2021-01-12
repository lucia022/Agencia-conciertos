
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de Artista
public class Artista {
    
    private long id;
    private String nombre;  
    private char generomusical;
    private Actuacion idactuacion;

   //Getters y Setters de la clase Artista
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

    public Actuacion getIdactuacion() {
        return idactuacion;
    }

    public void setIdactuacion(Actuacion idactuacion) {
        this.idactuacion = idactuacion;
    }
    
    
    
    //Constructores de la clase Artista
    
     public Artista() {
      
    }
    
    public Artista(Artista a) {
       this.id = a.id;
       this.nombre = a.nombre;
       this.generomusical = a.generomusical;
       this.idactuacion = a.idactuacion;
      
    }
     
     public Artista(long id, String nombre, char generomusical, Actuacion idactuacion) {
        this.id = id;
        this.nombre = nombre;
        this.generomusical = generomusical;
        this.idactuacion = idactuacion;
        
    }
     
     //Metodo To String de la clase Artista

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", generomusical=" + generomusical + ", idactuacion=" + idactuacion + '}';
    }
     
    
    
    public static Artista nuevoArtista(){
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
    
        /*ret.setId(Utilidades.numArtistas + 1);*/
        
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
