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
    private Usuario idusuario; /*Relación "realiza" entre Usuario y Reserva, la cual es N:1, he decidido añadir un atributo de Usuario en la clase Reserva, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
                               /*Cabe destacar, que se trata de una asociación directa entre Usuario y Reserva*/
    
    /*constructor por defecto*/
    public Reserva(){}
    
    /*constructor con parámetros*/
    public Reserva(long id, Date fechamaxima, Usuario idusuario) {
        this.id = id;
        this.fechamaxima = fechamaxima;
        this.idusuario = idusuario;
    }
    
    /*constructor de copia*/
    public Reserva(Reserva res){
        this.id = res.id;
        this.fechamaxima = res.fechamaxima;
        this.idusuario = res.idusuario;
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

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }
    
    /*método toString*/

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechamaxima=" + fechamaxima + ", idusuario=" + idusuario + '}';
    }
    
}
