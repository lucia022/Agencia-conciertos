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

//Clase Momento
public class Momento {
    
    //Atributos de la clase Momento
    private long id;
    private Date hora;
    private String descripcion;
    private Reportero reportero; //Relacion capturar" entre Momento y Reportero

    //Constructores de la clase Momento
    public Momento() {
    }

    public Momento(long id, Date hora, String descripcion, Reportero reportero) {
        this.id = id;
        this.hora = hora;
        this.descripcion = descripcion;
        this.reportero = reportero;
    }
    
    public Momento(Momento m) {
        this.id = m.id;
        this.hora = m.hora;
        this.descripcion = m.descripcion;
        this.reportero = m.reportero;
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

    public Reportero getReportero() {
        return reportero;
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

    public void setReportero(Reportero reportero) {
        this.reportero = reportero;
    }
   
    //Metodo toString de la clase Momento
    @Override
    public String toString() {
        return "Momento{" + "id=" + id + ", hora=" + hora + ", descripcion=" + descripcion + ", reportero=" + reportero + '}';
    }
    
    
    
    
}
