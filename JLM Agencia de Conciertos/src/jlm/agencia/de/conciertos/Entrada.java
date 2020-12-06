
package jlm.agencia.de.conciertos;

import java.util.ArrayList;


public class Entrada {
    
    private long id;
    private double precio;
    private boolean VIP;
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
        
      public Entrada() {
       
    }
    
      public Entrada(long id, double precio, boolean VIP) {
        this.id = id;
        this.precio = precio;
        this.VIP = VIP;
    }
      
       @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + ", VIP=" + VIP + '}';
    }

}
