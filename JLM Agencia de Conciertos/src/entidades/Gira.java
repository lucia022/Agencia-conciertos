package entidades;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//Clase Gira
public class Gira {

    //Atributos de la clase Gira
    private long id;
    private String nombre;
    private Date fechainicio;
    private Date fechacierra;
    private Informe idinforme;

    /*Relacion "tener" entre Informe y Gira la cual es 1:1 y he decidido en este caso meter un atributo de tipo Informe en la clase Gira
    en este caso el atrbuto seria necesario ya que la cardinalidad minima es superior a 0*/
 /*Hay que decir que sin la clase Gira no existiria la clase informe y es por eso que se trata de una dependencia*/
    //Constructores de la clase Gira
    public Gira() {
    }

    public Gira(long id, String nombre, Date fechainicio, Date fechacierra, Informe idinforme) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechacierra = fechacierra;
        this.idinforme = idinforme;
    }

    public Gira(Gira g) {
        this.id = g.id;
        this.nombre = g.nombre;
        this.fechainicio = g.fechainicio;
        this.fechacierra = g.fechacierra;
        this.idinforme = g.idinforme;
    }

    //Getters de la clase Gira
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechacierra() {
        return fechacierra;
    }

    public Informe getInforme() {
        return idinforme;
    }

    //Setters de la clase Gira
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechacierra(Date fechacierra) {
        this.fechacierra = fechacierra;
    }

    public void setInforme(Informe informe) {
        this.idinforme = informe;
    }

    //Nuevo Metodo
    public static Gira nuevaGira() {

        Gira ret = new Gira();
        Scanner in = new Scanner(System.in);

        long idNuevo;
        String nombreNuevo = null;
        long idInformeNuevo;
        boolean fallo = true;

        do {

            System.out.print("Introduzca el id de la Gira");
            idNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idNuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);

        do {

            System.out.println("Introduzca el nombre de la Gira");
            String nombre = in.nextLine();
            ret.setNombre(nombre);

            for (int i = 0; i < nombreNuevo.length(); i++) {
                if (Character.isDigit(nombreNuevo.charAt(i))) {
                    fallo = true;
                    System.out.println("El nombre introducido contiene numeros,inntroduzcalo de nuevo");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((nombreNuevo.equals("")) || (nombreNuevo.equals(" "))) {
                System.out.println("No has introducido ningun nombre,es necesario introducir uno");
            }

        } while ((nombreNuevo.equals("")) || (nombreNuevo.equals(" ")) || (fallo == true));

        do {

            System.out.print("Introduzca el id del informe de la Gira");
            idInformeNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idInformeNuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);

        return ret;

    }

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

    //Metodo tooString de la clase Gira
    @Override
    public String toString() {
        return "Gira{" + "id=" + id + ", nombre=" + nombre + ", fechainicio=" + fechainicio + ", fechacierra=" + fechacierra + ", informe=" + idinforme + '}';
    }

}
