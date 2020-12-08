/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lucia
 */
public class Compra {
    private long id;
    private double precio;
    private String metodopago;
    private Usuario idusuario; /*Relación "realiza" entre Usuario y Compra, la cual es N:1, he decidido añadir un atributo de Usuario en la clase Compra, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
                               /*Cabe destacar, que se trata de una asociación directa entre Usuario y Compra*/
    
    private Descuento iddescuento; /*Relación “se aplica” entre Descuento y Compra, la cual es 1:1, he decidido añadir un atributo de Descuento en la clase Compra, ya que en este caso, el atributo sería necesario, debido a que la cardinalidad mínima es superior a 0*/
                                   /*Cabe destacar, que sin la clase Compra no existiría la clase Descuento, por lo que se trata de una dependencia.*/
    
    /*constructor por defecto*/
    public Compra(){}
    
    /*constructor con parámetros*/
    public Compra(long id, double precio, String metodopago, Usuario idusuario, Descuento iddescuento) {
        this.id = id;
        this.precio = precio;
        this.metodopago = metodopago;
        this.idusuario = idusuario;
        this.iddescuento = iddescuento;
    }
    
    /*constructor de copia*/
    public Compra(Compra com){
         this.id = com.id;
        this.precio = com.precio;
        this.metodopago = com.metodopago;
        this.idusuario = com.idusuario;
        this.iddescuento = com.iddescuento;
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

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Descuento getIddescuento() {
        return iddescuento;
    }

    public void setIddescuento(Descuento iddescuento) {
        this.iddescuento = iddescuento;
    }
    
    /*método toString*/

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", precio=" + precio + ", metodopago=" + metodopago + ", idusuario=" + idusuario + ", iddescuento=" + iddescuento + '}';
    }
   
}
