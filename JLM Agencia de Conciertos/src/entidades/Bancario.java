/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author usuario
 */
public class Bancario {

    private int id;
    private String titular;
    private String numtarjeta;
    private String codigotarjeta;

    public Bancario() {
    }

    
    
    public Bancario(int id, String titular, String numtarjeta, String codigotarjeta) {
        this.id = id;
        this.titular = titular;
        this.numtarjeta = numtarjeta;

        this.codigotarjeta = codigotarjeta;
    }
    
    public Bancario( String titular, String numtarjeta,  String codigotarjeta) {
        this.titular = titular;
        this.numtarjeta = numtarjeta;

        this.codigotarjeta = codigotarjeta;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumtarjeta() {
        return numtarjeta;
    }

    public void setNumtarjeta(String numtarjeta) {
        this.numtarjeta = numtarjeta;
    }

    public String getCodigotarjeta() {
        return codigotarjeta;
    }

    public void setCodigotarjeta(String codigotarjeta) {
        this.codigotarjeta = codigotarjeta;
    }

    
    
}
