package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author marii
 */
//Clase Momento
public class Momento {

    //Atributos de la clase Momento
    
   // Valores Validos!! Estan permitodos todos los int/long cuyo valor sea entre 0 e infinito
   // Valores Invalidos!! Queda prohibido el uso de caracteres especiales, numeros negativos, tipos `char, tipo double, tipo booblean, basicamento todo aquello que no sea un int/long primitivo´
    private long id;
    
     // Valores Validos!! Sera valida toda aquella fecha con el formato comprendido como "dd/MM/yyy o dd-MM-yyy o "dd de "String"(Enero, Febrero...etc) de yyyy"
    // Valores Invalidos!! Todos aquellos que difieran con lo descrito anterior, fechas con formatos de otros paises, String que no hagan referencia al mes de la fecha, primitivos.
    private Date hora;
    
    // Valores Validos!! Por el momento solo se aceptan cadena de caracteres/String.
    // Valores Invalidos!! Quedan prohibidos el uso de primitivos, ya sea, int, long, double, char, short...etc QUEDAN PROHIBIDO TODO LO QUE NO SEA UNA CADENA DE CARACTERES
    private String descripcion;
    

    /*Relacion "capturar" entre Momento y Reportero la cual es 1:N y en este caso he decidido añadir 
    un atributo de tipo Reportero en la clase Momento,tambien hay que decir que seria obligatorio ya que la cardinalidad minima es superior a 0ç
    además esta clse Momento depende directamente de que exista reporteros ya que en caso contrario esta clase no existiria*/
    //Constructores de la clase Momento
    public Momento() {
    }

    public Momento(long id, Date hora, String descripcion) {
        this.id = id;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public Momento(Momento m) {
        this.id = m.id;
        this.hora = m.hora;
        this.descripcion = m.descripcion;
    }

    //Getters de la clase Momento
    public long getId() {
        return id;
    }

    public Date getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
    //Setters de la clase Momento
    public void setId(long id) {
        this.id = id;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

            public static ArrayList<Momento> convertir(Momento[] array) {
        ArrayList<Momento> ret = new ArrayList<Momento>();
        for (Momento m : array) {
            ret.add((Momento) m);
        }
        return ret;
    }
    
    public static ArrayList<Momento> arrayde(ArrayList<Momento> lista, int[] ids) {
        ArrayList<Momento> ret = new ArrayList<Momento>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getId() es propio de Entrada
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Momento) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    
    //Nuevo Metodo
    public static Momento nuevoMomento() {

        Momento ret = new Momento();
        Scanner in = new Scanner(System.in);

        long idNuevo;
        String descripcionNuevo = null;
        Reportero reporteroNuevo;
        boolean fallo = true;

        do {

            System.out.print("Introduzca el id del Informe");
            idNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idNuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);
        

         do {

            System.out.println("Introduzca la descripcion del momento");
            String descripcion = in.nextLine();
            ret.setDescripcion(descripcion);

            for (int i = 0; i < descripcionNuevo.length(); i++) {
                if (Character.isDigit(descripcionNuevo.charAt(i))) {
                    fallo = true;
                    System.out.println(" La descripcion que ha introducido contiene numeros,inntroduzcala sin ellos");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((descripcionNuevo.equals("")) || (descripcionNuevo.equals(" "))) {
                System.out.println("No has introducido ninguna descripcion, es necesario introducir alguna");
            }

        } while ((descripcionNuevo.equals("")) || (descripcionNuevo.equals(" ")) || (fallo == true));

        return ret;

    }

    //Metodo usado para la petición de fechas
    public static Date dameFecha() {

        Scanner in = new Scanner(System.in);
        Date Date = new Date();

        System.out.println("Introduce el año de la Gira");
        int year = in.nextInt();

        System.out.println("Introduce el mes de la Gira");
        int month = in.nextInt();

        System.out.println("Introduce el día del concierto");
        int day = in.nextInt();

        Date date = new GregorianCalendar(year, month, day).getTime();
        System.out.println("La fecha introducida es:" + date);

        return Date;

    }
    
    
    //Metodo toString de la clase Momento

    @Override
    public String toString() {
        return "Los datos de los momentos obtenidos corresponden a:" + "\n" + "El id del momento es: "  + id  + "\n" + " La hora en la que se obtuvo el momento fue: "  + hora + "\n" + " Descripción del momento: " + descripcion;
    }

}

