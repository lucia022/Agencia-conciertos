/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String nif;
  

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
        return "Reportero{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", nif=" + nif + ", conciertos=" + '}';
    }

}
