package entidades;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de la clase Concierto
public class Concierto {

    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    protected long id;
    //VALORES VÁLIDOS: fecha (Date) en el formato dd/mm/aaaa.
    //VALORES INVÁLIDOS: aquellas fechas (Date) que no contengan el formato dd/mm/aaaa
    protected Date diahora;
    protected ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();/*relación "formar" 10:1 entre Actuación y Concierto, introduciendo un ArrayList de Actuación en la clase concierto*/
    
    protected ArrayList<Entrada> entradas = new ArrayList<Entrada>(); /*relación "tener" N:1 entre e Entrada y Concierto, introduciendo un ArrayList de entrada en la clase concierto*/

    public Concierto() {
    }

    public Concierto(long id, Date diahora, ArrayList<Actuacion> actuaciones, ArrayList<Entrada> entradas) {
        this.id = id;
        this.diahora = diahora;
        this.actuaciones = actuaciones;
        this.entradas = entradas;
    }

    public Concierto(long id, Date diahora, ArrayList<Entrada> entradas) {
        this.id = id;
        this.diahora = diahora;
        this.entradas = entradas;

    }

    public Concierto(Concierto c) {
        this.id = c.id;
        this.diahora = c.diahora;
        this.actuaciones = c.actuaciones;
        this.entradas = c.entradas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDiahora() {
        return diahora;
    }

    public void setDiahora(Date diahora) {
        this.diahora = diahora;
    }

    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(ArrayList<Actuacion> actuaciones) {
        this.actuaciones = actuaciones;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<Entrada> entradas) {
        this.entradas = entradas;
    }

     //Metodo To String de la clase Conceirto
    @Override
    public String toString() {
        return "Concierto" + "\nId del concierto:" + id + "\nfecha del concieto:" + diahora + "\nContiene las siguientes actuaciones:" + actuaciones + "\nDispone de estas entradas:" + entradas;
    }
    
    //Parte Introducida por Jonathan
          public static ArrayList<Concierto> arrayde(ArrayList<Concierto> lista,int[] ids) {
       
        ArrayList<Concierto> ret = new ArrayList<Concierto>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Concierto) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Concierto> convertir(Concierto[] array) {
        ArrayList<Concierto> ret = new ArrayList<Concierto>();
        for (Concierto c : array) {
            ret.add((Concierto) c);
        }
        return ret;
    }
    //Hasta aqui
 


    public static Concierto nuevoConcierto() throws ParseException {
        Concierto ret = new Concierto();
        Scanner in = new Scanner(System.in);
        long idconcierto;
        do {
            System.out.println("Introduzca el id del concierto:");
            idconcierto = in.nextLong();
            ret.setId(idconcierto);
            if (idconcierto <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (idconcierto <= 0);
        /*ret.setId(Utilidades.numConciertos + 1);*/

        java.util.Date fecha = (java.util.Date) Fecha.dameFecha();
        return ret;

    }

    public static ArrayList<Concierto> todosconciertos() {
        ArrayList<Concierto> todosconciertos = new ArrayList<Concierto>();
        for (int i = 0; i < Utilidades.CONCIERTOS.length; i++) {
            todosconciertos.add(Utilidades.CONCIERTOS[i]);
        }
        return todosconciertos;
    }
    
    
    /*  Parte hecha por Jonathan
    
      
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
    
}
