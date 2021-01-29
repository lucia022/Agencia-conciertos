
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

//Clase y Atributos de la clase Entrada
public class Entrada {
    
    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VÁLIDOS: solo se aceptan los valores con formato 0.00, correspondiendo al precio de las entradas en euros.
    //VALORES INVÁLIDOS: aquellos valores que no sean introducidos con el fomato 0.00, y el valor del precio de las entradas no sea en euros.
    private double precio;
    
    private boolean VIP = false;
    private Compra compra; /*relación 1:1 entre compra y entrada, en la que introducimos un objeto de compra dentro de la clase Ebtrada.*/
    
   
    public Entrada(){}
    
    
    public Entrada(long id, double precio, boolean VIP){
        this.id = id;
        this.precio = precio;
        this.VIP = VIP;
    }
    
    public Entrada(Entrada e) {
        this.id = e.id;
        this.precio = e.precio;
        this.VIP = e.VIP;
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

    /*Método toString de la clase Entrada*/
    @Override
    public String toString() {
        return "Entrada" + "\nId de la entrada:" + id + "\nEl precio en euros de la entrada es:" + precio + "\nLa entrada es VIP?" + VIP + "\ncompra:" + compra;
    }
    
    public static ArrayList<Entrada> convertir(Entrada[] array) {
        ArrayList<Entrada> ret = new ArrayList<Entrada>();
        for (Entrada t : array) {
            ret.add((Entrada) t);
        }
        return ret;
    }
    
    
    public static ArrayList<Entrada> arrayde(ArrayList<Entrada> lista, int[] ids) {
        ArrayList<Entrada> ret = new ArrayList<Entrada>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getId() es propio de Entrada
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Entrada) lista.get(j));
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
