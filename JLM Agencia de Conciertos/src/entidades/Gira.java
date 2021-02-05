package entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//Clase Gira
public class Gira {

    //Atributos de la clase Gira
    // Valores Validos!! Estan permitodos todos los int/long cuyo valor sea entre 0 e infinito
    // Valores Invalidos!! Queda prohibido el uso de caracteres especiales, numeros negativos, tipos `char, tipo double, tipo booblean, basicamento todo aquello que no sea un int/long primitivo´ 
    private long id;

    /*  Valores Validos!! Todas aquellas cadenas de caracteres que esten formadas por un número de caracteres inferior a 2 hasta un máximo de 80 caracteres,
         estan permitidas las Dieresis ("ü")y las cerdillas ("Ç")
         Valores Invalidos! Cadenas de caracteres inferior a 3 letras, y superiores a 60 letras, quedan prohido todos los caracteres especiales,
          numeros, primitivos tipo char, bueno, todo los primitivos estan prohibidos. */
    private String nombre;

    //
    //
    private Date fechainicio;

    //
    //
    private Date fechacierra;

    // Valores Validos!! Por el momento solo se aceptan cadena de caracteres/String, caracteres del tipo char y guiones bajos ("_")por si hubiera menciones a correos electronicos
    /* Valores Invalidos!! Quedan prohibidos el uso de primitivos, excepto el ´char´, ya que en el informe puede hacerse referencia a correos electronicos,
     y el guión bajo ("_") por el mismo motivo*/
    private Informe informe;

    private ArrayList<Concierto> conciertos = new ArrayList<Concierto>(); //relacion "Compuesto" entre Concierto y Gira

    /*Relacion "tener" entre Informe y Gira la cual es 1:1 y he decidido en este caso meter un atributo de tipo Informe en la clase Gira
    en este caso el atrbuto seria necesario ya que la cardinalidad minima es superior a 0*/
 /*Hay que decir que sin la clase Gira no existiria la clase informe y es por eso que se trata de una dependencia*/
    //Constructores de la clase Gira
    public Gira() {
    }

    public Gira(long id, String nombre, Date fechainicio, Date fechacierra, Informe informe) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechacierra = fechacierra;
        this.informe = informe;
    }

    public Gira(long id, String nombre, Date fechainicio, Date fechacierra, Informe informe, ArrayList<Concierto> conciertos) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechacierra = fechacierra;
        this.informe = informe;
        this.conciertos = conciertos;

    }

    public Gira(Gira g) {
        this.id = g.id;
        this.nombre = g.nombre;
        this.fechainicio = g.fechainicio;
        this.fechacierra = g.fechacierra;
        this.informe = g.informe;
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
        return informe;
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
        this.informe = informe;
    }

    //Arraylist de la clase Gira
    public static ArrayList<Gira> todasGiras() {
        ArrayList<Gira> todasGiras = new ArrayList<Gira>();
        todasGiras.addAll(Arrays.asList(Utilidades.GIRAS));
        return todasGiras;
    }

    //Aqui creo un metodo para ver las Giras
    public static void verGiras() {
        System.out.println("Lista de Giras actuales:");
        for (Gira g : Utilidades.GIRAS) {
            if (g.getId() > 0) {
                System.out.println(g.toString());
            }
        }
    }

    //Aqui creo un metodo para ver los Conciertos
    public static void verConciertos() {
        System.out.println("Lista de Conciertos de las Giras:");
        for (int i = 0; i < Utilidades.CONCIERTOS.length; i++) {
            Concierto c = Utilidades.CONCIERTOS[i];
            if (c.getId() > 0) {
                System.out.println(c.toString());
            }
        }
    }
    
    

    //Función para buscar Giras y Conciertos
    public static Gira buscarGiraById(int id) {
        for (int i = 0; i < Utilidades.GIRAS.length; i++) {
            if (Utilidades.GIRAS[i].getId() == id) {
                return Utilidades.GIRAS[i];
            }
        }
        return null;
    }
    

/*
    
      
        public static Concierto buscarConciertos(ArrayList<Concierto> conciertos) {
        Concierto deseado;
        ArrayList<Concierto> encontrados;
        Scanner in;
        int option = -1;
    
        do {
            deseado = null;
            encontrados = new ArrayList<Concierto>();
            in = new Scanner(System.in, "Elija una de estas opciones segun sus preferencias");
            System.out.println("Pulse 1 para buscar el Concierto por su ID.");
            System.out.println("Pulse 2 para buscar el Concierto por su Día de realización.");
            System.out.println("Pulse 3 para buscar el Concierto por sus Actuaciones.");
            System.out.println("Pulse 0 para VOLVER.");
              option = in.nextInt();
            if (option < 0 || option > 3) {
                System.out.println("Opción incorrecta.");
                continue;
        }
            
            in = new Scanner(System.in, "Elija una de estas opciones segun sus preferencias");
             switch (option) {
                case 0:
                    break;
                    
                case 1:
                     System.out.println("Introduzca el ID del concierto que desee encontrar:");
                    int idConcierto = in.nextInt();
                    deseado = Concierto.buscarConciertoPorId(idConcierto, conciertos);
                    if (deseado != null) {
                        System.out.print("Concierto localizado: ");
                        System.out.println(deseado.getId() + ". " + deseado.getDiahora());
                    } else {
                        System.out.println("Empleado con id:" + idConcierto + " NO ENCONTRADO.");
                    }
                    break;
    
    
                    
                    // Este caso lo comento, puesto que estoy haciendo este ejemplo con conciertos por quie tengo que buscarlos yo junto con las giras
                      y no se como hacer para pedir una fecha.
                    
                case 2:
                        System.out.println("Introduzca el día del concierto que desee encontrar:");
                    Date diaConcierto = in.n();
                    deseado = Concierto.buscarConciertoPorId(idConcierto, conciertos);
                    if (deseado != null) {
                        System.out.print("Concierto localizado: ");
                        System.out.println(deseado.getId() + ". " + deseado.getDiahora());
                    } else {
                        System.out.println("Empleado con id:" + idConcierto + " NO ENCONTRADO.");
                    }
                    break;
                   // 
    
    
                    
                case 3:
                        System.out.println("Introduzca la Actuación del concierto que desee encontrar:");
                    int actConcierto = in.nextInt();
                    deseado = Concierto.buscarConciertoPorId(actConcierto, conciertos);
                    if (deseado != null) {
                        System.out.print("Actuacion Encontrada: ");
                        System.out.println(deseado.getId() + ". " + deseado.getActuaciones());
                    } else {
                        System.out.println("Actuacion:" + actConcierto + " NO ENCONTRADa.");
                    }
                    break;
    
         
                default:
                    break;
            }
        } while (option != 0);
        
       }   
    
    
      
    public static Concierto buscarConciertoPorId(int idConcierto, ArrayList<Concierto> conciertos) {
        Concierto ret = null;
        for (Concierto c : conciertos) {
            if (c.getId() == idConcierto) {
                ret = c;
                break;
            }
        }
        return ret;
    }
    
      
    public static Concierto buscarConciertoPorDia(Date diaConcierto, ArrayList<Concierto> conciertos) {
        Concierto ret = null;
        for (Concierto c : conciertos) {
            if (c.getDiahora() == diaConcierto) {
                ret = c;
                break;
            }
        }
        return ret;
    }
    
    */

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
        return "Los datos de la Gira son:" + "\n" + "El id es: " + id + "\n" + " El nombre es: " + nombre + "\n" + "El inicio de la Gira se produjo el: " + fechainicio + "\n" + " La Gira se cerro el: " + fechacierra + "\n" + "Su informe corresponde a: " + informe + "\n" + "Los conciertos que se produjeron en la Gira fueron: " + conciertos;
    }

}
