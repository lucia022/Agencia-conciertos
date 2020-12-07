/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author marii
 */
//Clase Informe
public class Informe {
    
    //Atributos de la clase Informe
    private long id;
    private String descripcion;

    //Constructores de la clase Informe
    public Informe() {
    }

    public Informe(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public Informe(Informe i) {
        this.id = i.id;
        this.descripcion = i.descripcion;
    }
    
    //Getters de la clase Informe
    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    //Setters de la clase Informe
    public void setId(long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Metodo toString de la clase Informe
    @Override
    public String toString() {
        return "Informe{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
}
