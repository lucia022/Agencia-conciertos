/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

/**
 *
 * @author Lucia
 */
public class Compra {
    private long id;
    private double precio;
    private String metodopago;
    /*He tomado la decisión de incluir un atributo identificador de la clase Usuario, ya que nos interesa saber que usuarios han realizado una compra*/
    private Usuario usuario;
    /*He tomado la decisión de incluir un atributo identificador de la clase Descuento, ya que nos interesa saber que descuentos se han aplicado en cada compra*/
    private Descuento descuento;
    
    /*constructor por defecto*/
    public Compra(){}
    
    /*constructor con parámetros*/
    public Compra(long id, double precio, String metodopago, Usuario usuario, Descuento descuento) {
        this.id = id;
        this.precio = precio;
        this.metodopago = metodopago;
        this.usuario = usuario;
        this.descuento = descuento;
    }
    
    /*constructor de copia*/
    public Compra(Compra com){
         this.id = com.id;
        this.precio = com.precio;
        this.metodopago = com.metodopago;
        this.usuario = com.usuario;
        this.descuento = com.descuento;
    }
    
    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
    
    /*método toString*/
    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", precio=" + precio + ", metodopago=" + metodopago + ", usuario=" + usuario + ", descuento=" + descuento + '}';
    }
}
