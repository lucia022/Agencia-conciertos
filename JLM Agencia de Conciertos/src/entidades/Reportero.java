package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author marii
 */
//Clase Reportero
public class Reportero {

    //Atributos de la clase Reportero
    
   // Valores Validos!! Estan permitodos todos los int/long cuyo valor sea entre 0 e infinito
   // Valores Invalidos!! Queda prohibido el uso de caracteres especiales, numeros negativos, tipos `char, tipo double, tipo booblean, basicamento todo aquello que no sea un int/long primitivo´
  private long id;
    
     /* Valores Validos!! Todas aquellas cadenas de caracteres que esten formadas por un número de caracteres inferior a 2 hasta un máximo de 40 caracteres, 
         estan permitidas las Dieresis ("ü")y las cerdillas ("Ç")
         Valores Invalidos! Nombres o cadena de caracteres inferior a 2 letras, y superiores a 40 letras, quedan prohido todos los caracteres especiales (EXCEPTO LA DIERESIS ("ü") y la CERDILLA ("ç")),
         numeros, primitivos tipo char, bueno, todo los primitivos estan prohibidos. */
    private String nombre;
    
     /*  Valores Validos!! Todas aquellas cadenas de caracteres que esten formadas por un número de caracteres inferior a 2 hasta un máximo de 80 caracteres,
         estan permitidas las Dieresis ("ü")y las cerdillas ("Ç")
         Valores Invalidos! Cadenas de caracteres inferior a 3 letras, y superiores a 60 letras, quedan prohido todos los caracteres especiales,
          numeros, primitivos tipo char, bueno, todo los primitivos estan prohibidos. */
    private String apellido;
    
     // Valores Validos!! Todas aquellas cadenas de caracteres que esten formadas por un número comprendido entre 9 y 12 caracteres (por si son llamadas con prefijo al extranjero) 
    /*Valores Invalidos! Todas aquellas cadenas de caracteres superiores a 12 o inferiores a 9 caracteres, quedan prohibido todos los tipos primitivos,
                          sean cuales sean y todos los caracteres especiales*/
    private String telefono;
    
     // Valores Validos!! Seran validas todas aquella cadenas de caracteres comprendidas por un total de 9 caracteres
     //Valores Invalidos! Queda invalidado introducir cadenas de caracteres con menos de 9 caracteres o mas de esos 9. tampoco estara permitido la introduccion de primitivos o caracteres especiales.
    private String nif;
    private ArrayList<Momento> momentos = new ArrayList<Momento>(); //relacion "Documentar" entre Reportero y Momento

    /*Relacion "Documentar" entre Reportero y Concierto la cual es N:N por lo que
    hemos decidido implementar ArrayList tanto en la clase Reportero como en la clase Concierto,este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/
    //Constructores de la clase Reportero
    public Reportero() {
    }

    public Reportero(long id, String nombre, String apellido, String telefono, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nif = nif;
    }

    public Reportero(long id, String nombre, String apellido, String telefono, String nif, ArrayList<Momento> momentos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nif = nif;
        this.momentos = momentos;
    }

    public Reportero(Reportero r) {
        this.id = r.id;
        this.nombre = r.nombre;
        this.apellido = r.apellido;
        this.telefono = r.telefono;
        this.nif = r.nif;
    }

    //Getters de la clase Reportero
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNif() {
        return nif;
    }

    public ArrayList<Momento> getMomentoss() {
        return momentos;
    }

    //Setters de la clase Reportero
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setMomentoss(ArrayList<Momento> momentoss) {
        this.momentos = momentoss;
    }
    
    
    
    
    
         public static ArrayList<Reportero> convertir(Reportero[] array) {
        ArrayList<Reportero> ret = new ArrayList<Reportero>();
        for (Reportero r : array) {
            ret.add((Reportero) r);
        }
        return ret;
    }
    
    public static ArrayList<Reportero> arrayde(ArrayList<Reportero> lista, int[] ids) {
        ArrayList<Reportero> ret = new ArrayList<Reportero>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getId() es propio de Entrada
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Reportero) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }


    //Nuevo Metodo
    public static Reportero nuevoReportero() {

        Reportero ret = new Reportero();
        Scanner in = new Scanner(System.in);

        long idNuevo;
        String nombreNuevo = null;
        String apellidoNuevo = null;
        String nifNuevo = null;
        String telefonoNuevo = null;
        boolean fallo = true;
        
            
        

        
        //Este campo deberá ser autocompletado
        
        do {

            System.out.print("Introduzca el id del Informe");
            idNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idNuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);

        do {

            System.out.println("Introduzca el nombre del Reportero");
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

            System.out.println("Introduzca el apellido del Reportero");
            String appelidoNuevo = in.nextLine();
            ret.setApellido(apellidoNuevo);

            for (int i = 0; i < apellidoNuevo.length(); i++) {
                if (Character.isDigit(apellidoNuevo.charAt(i))) {
                    fallo = true;
                    System.out.println("El apellido introducido contiene numeros,inntroduzcalo de nuevo sin ellos.");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((apellidoNuevo.equals("")) || (apellidoNuevo.equals(" "))) {
                System.out.println("No has introducido ningun apellido,es necesario introducir uno");
            }

        } while ((apellidoNuevo.equals("")) || (apellidoNuevo.equals(" ")) || (fallo == true));

        do {

            System.out.println("Introduzca el telefono del Reportero");
            String telefono = in.nextLine();
            ret.setTelefono(telefono);

            for (int i = 0; i < telefonoNuevo.length(); i++) {
                if (Character.isDigit(telefonoNuevo.charAt(i))) {
                    fallo = true;
                    System.out.println("El telefono introducido no es valido.");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((telefonoNuevo.equals("")) || (telefonoNuevo.equals(" "))) {
                System.out.println("No has introducido ningun telefono,es necesario introducir uno");
            }

        } while ((telefonoNuevo.equals("")) || (telefonoNuevo.equals(" ")) || (fallo == true));

        do {

            System.out.println("Introduzca el nif del Reportero");
            String nif = in.nextLine();
            ret.setNif(nif);

            for (int i = 0; i < nif.length(); i++) {
                if (Character.isDigit(nif.charAt(i))) {
                    fallo = true;
                    System.out.println("El nif introducido no es valido, vuelva a intertarlo.");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((nif.equals("")) || (nif.equals(" "))) {
                System.out.println("No has introducido ningun nif,es necesario introducir uno");
            }

        } while ((nifNuevo.equals("")) || (nifNuevo.equals(" ")) || (fallo == true));

        return ret;

    }

    //Metodo toString de la clase Reportero
    @Override
    public String toString() {
        return "Los datos del Reportero son:" +  "\n" +  "El id del Reportero es:" + id + "\n" + " El nombre es: " + nombre + "\n" + " El apellido es: " + apellido +  "\n" + " El número de telefono es: " + telefono + "\n" + " El DNI corresponde a: " + nif + "\n" + "Los momentos obtenidos por este reportero han sido: " + momentos;
    } 

}
