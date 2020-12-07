
package entidades;

import java.util.ArrayList;


public class Entrada {
    
    private long id;
    private double precio;
    private boolean VIP;
    private Compra compra;
    private ArrayList<Concierto> conciertos = new ArrayList<Concierto>();

   
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
        this.compra = compra;
    }

    public Compra getCompra() {
        return compra;
    }
        
      public Entrada() {
       
    }
    
      public Entrada(long id, double precio, boolean VIP, Compra compra) {
        this.id = id;
        this.precio = precio;
        this.VIP = VIP;
        this.compra = compra;
    }
      
        public Entrada(Entrada e) {
        this.id = e.id;
        this.precio = e.precio;
        this.VIP = e.VIP;
        this.compra = e.compra;
    }
      
     @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + ", VIP=" + VIP + ", compra=" + compra + ", conciertos=" + conciertos + '}';
    }

}
