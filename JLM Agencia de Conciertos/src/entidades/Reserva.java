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
public class Reserva {
     private long id;
    private Date fechamaxima;
    
    /*He tomado la decisión de incluir un atributo identificador de la clase Usuario, ya que nos interesa saber que usuarios han realizado una reserva*/
    private Usuario usuario;
    
    /*constructor por defecto*/
    public Reserva(){}
    
    /*constructor con parámetros*/
    public Reserva(long id, Date fechamaxima, Usuario usuario) {
        this.id = id;
        this.fechamaxima = fechamaxima;
        this.usuario = usuario;
    }
    
    /*constructor de copia*/
    public Reserva(Reserva res){
        this.id = res.id;
        this.fechamaxima = res.fechamaxima;
        this.usuario = res.usuario;
    }
    
    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechamaxima() {
        return fechamaxima;
    }

    public void setFechamaxima(Date fechamaxima) {
        this.fechamaxima = fechamaxima;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /*método toString*/
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechamaxima=" + fechamaxima + ", usuario=" + usuario + '}';
    }
}
