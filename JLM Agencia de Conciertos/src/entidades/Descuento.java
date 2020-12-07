/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author Lucia
 */
public class Descuento {
    private long id;
    private String codigo;
    private Date fechavalidez;
    
    /*constructor por defecto*/
    public Descuento(){}
    
    /*constructor con parámetros*/
    public Descuento(long id, String codigo, Date fechavalidez) {
        this.id = id;
        this.codigo = codigo;
        this.fechavalidez = fechavalidez;
    }
    
    /*constructor de copia*/
    public Descuento(Descuento d){
        this.id = d.id;
        this.codigo = d.codigo;
        this.fechavalidez = d.fechavalidez;
    }
    
    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
     public Date getFechavalidez() {
        return fechavalidez;
    }

    public void setFechavalidez(Date fechavalidez) {
        this.fechavalidez = fechavalidez;
    }
    
    /*método toString*/
    @Override
    public String toString() {
        return "Descuento{" + "id=" + id + ", codigo=" + codigo + ", fechavalidez=" + fechavalidez + '}';
    }
    
}
