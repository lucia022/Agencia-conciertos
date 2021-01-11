
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de Actuacion
public class Actuacion {
    
    private long id;
    private long numerosecuencia; 
    private double duracion;
    private Concierto idconcierto;
     /* Relacion "Documentar" entre Artista y Actuación, que es N:N, por lo que
    hemos decidido implementar ArrayList tanto en la clase Artista como en la clase Actuación, este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/

   
  //Getters y Setters
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
    
      public Concierto getIdoncierto() {
        return idconcierto;
    }

    public void setIdoncierto(Concierto idconcierto) {
        this.idconcierto = idconcierto;
    }

   
    
    
    //Constructores de Actuación
      public Actuacion() {
        
    }

      public Actuacion(long id, long numerosecuencia, double duracion, Concierto idconcierto) {
        this.id = id;
        this.numerosecuencia = numerosecuencia;
        this.duracion = duracion; 
        this.idconcierto = idconcierto;
        
    }
      
        public Actuacion(Actuacion a){
        this.id = a.id;
        this.numerosecuencia = a.numerosecuencia;
        this.duracion = a.duracion;
        this.idconcierto = a.idconcierto;
        
    }
      
      //Metodo To Srting de la clase Actuación

    @Override
    public String toString() {
        return "Actuacion{" + "id=" + id + ", numerosecuencia=" + numerosecuencia + ", duracion=" + duracion + ", idconcierto=" + idconcierto + '}';
    }

    
    
    
    public Actuacion nuevoActuacion(){
        Actuacion ret = new Actuacion();
        Scanner in = new Scanner(System.in);
        long id;
        do {
            System.out.println("Introduzca el id de la actuacion:");
            id = in.nextLong();
            ret.setId(id);
            if (id <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (id <=0);
       
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
    
    public static ArrayList<Actuacion> convertir(Actuacion[] array) {
        return new Gen<Actuacion>().convertir(array);

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

}
