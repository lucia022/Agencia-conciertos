/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


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
    private Informe idinforme; /*Relacion "tener" entre Informe y Gira la cual es 1:1 y he decidido en este caso meter un atributo de tipo Informe en la clase Gira
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

    //Metodo tooString de la clase Gira
    @Override
    public String toString() {
        return "Gira{" + "id=" + id + ", nombre=" + nombre + ", fechainicio=" + fechainicio + ", fechacierra=" + fechacierra + ", informe=" + idinforme + '}';
    }
    
    
}
