/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;


import java.util.Date;

/**
 *
 * @author marii
 */
//Clase Gira
public class Gira {
    
    //Atributos de la clase Gira
    private long id;
    private String nombre;
    private Date fechainicio;
    private Date fechacierra;
    private Informe informe; //Relacion "tener" entre Informe y Gira
    
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

    //Metodo tooString de la clase Gira
    @Override
    public String toString() {
        return "Gira{" + "id=" + id + ", nombre=" + nombre + ", fechainicio=" + fechainicio + ", fechacierra=" + fechacierra + ", informe=" + informe + '}';
    }
    
    
}
