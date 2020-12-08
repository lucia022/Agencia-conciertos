
package entidades;

import java.util.ArrayList;

//Clase y Atributos de la clase Entrada
public class Entrada {
    
    private long id;
    private double precio;
    private boolean VIP;
    private Compra idcompra;
    private ArrayList<Concierto> conciertos = new ArrayList<Concierto>(); /* Relacion "Documentar" entre Entraday Concierto, que es N:N, por lo que
    hemos decidido implementar ArrayList tanto en la clase Entrada como en la clase Concierto, este atributo sera obligatorio ya que la cardinalidad minima es 
    mas de 0*/

   
    //Getterrs y Setters de la clase Entrada
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

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }
    
    public void setCompra(Compra compra) {
        this.idcompra = compra;
    }

    public Compra getCompra() {
        return idcompra;
    }
     
    //Constructores de la clase ENtrada
    
      public Entrada() {
       
    }
    
      public Entrada(long id, double precio, boolean VIP, Compra compra) {
        this.id = id;
        this.precio = precio;
        this.VIP = VIP;
        this.idcompra = compra;
    }
      
        public Entrada(Entrada e) {
        this.id = e.id;
        this.precio = e.precio;
        this.VIP = e.VIP;
        this.idcompra = e.idcompra;
    }
      
        //Metodo To String de la clase ENtrada
        
     @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + ", VIP=" + VIP + ", compra=" + idcompra + ", conciertos=" + conciertos + '}';
    }

}
