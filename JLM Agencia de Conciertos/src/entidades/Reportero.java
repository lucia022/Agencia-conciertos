/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


import java.util.ArrayList;

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
    private ArrayList<Concierto> conciertos = new ArrayList<Concierto>(); /*Relacion "Documentar" entre Reportero y Concierto la cual es N:N por lo que
    hemos decidido implementar ArrayList tanto en la clase Reportero como en la clase Concierto,este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/

    //Constructores de la clase Reportero
    public Reportero() {
    }

    public Reportero(long id, String nombre, String apellido, String telefono, String nif, ArrayList<Concierto> conciertos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nif = nif;
        this.conciertos = conciertos;
    }
    
    public Reportero(Reportero r) {
        this.id = r.id;
        this.nombre = r.nombre;
        this.apellido = r.apellido;
        this.telefono = r.telefono;
        this.nif = r.nif;
        this.conciertos = r.conciertos;
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

    public ArrayList<Concierto> getConciertos() {
        return conciertos;
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

    public void setConciertos(ArrayList<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    //Metodo toString de la clase Reportero
    @Override
    public String toString() {
        return "Reportero{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", nif=" + nif + ", conciertos=" + conciertos + '}';
    }
    
    
    
}
