
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de la clase Entrada
public class Entrada {
    
    private long id;
    private double precio;
    private boolean VIP = false;
    private Compra compra;
    
   
    public Entrada(){}
    
    
    public Entrada(long id, double precio, boolean VIP, Compra compra){
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + ", VIP=" + VIP + ", compra=" + compra + '}';
    }
    
    
    public static ArrayList<Entrada> convertir(Entrada[] array) {
        return new Entrada().convertir(array);
    }
    
    
    public static ArrayList<Entrada> arrayde(ArrayList<Entrada> lista, int[] ids) {
        ArrayList<Entrada> ret = new ArrayList<Entrada>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getCodigo() es propio de Producto
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Entrada) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }
        
     
    
    public static Entrada nuevoEntrada(){
        Entrada ret = new Entrada();
        Scanner in = new Scanner(System.in);
        
        long identrada;
        do {
            System.out.println("Introduzca el id de la entrada:");
            identrada = in.nextLong();
            ret.setId(identrada);
            if (identrada <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (identrada <=0);
    
        /*ret.setId(Utilidades.numEntradas + 1);*/
        
        double precio;
        System.out.println("Introduzca el precio de la entrada:");
        precio = in.nextDouble();
        ret.setPrecio(precio);
        
        boolean VIP;
        System.out.println("Introduzca la entrada:");
        VIP = in.nextBoolean();
        ret.setVIP(VIP);
        if (VIP == false) {
            System.out.println("La entrada no es VIP");
        }else{
            System.out.println("La entrada es VIP");
        }
            
        return ret;
        
  
    }

    
    
}
