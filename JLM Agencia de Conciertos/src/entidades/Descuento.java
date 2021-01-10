/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author Lucia
 */
public class Descuento {
    private long id;
    private String codigo;
    private Date fechavalidez;
    
    /*constructor por defecto*/
    public Descuento(){}
    
    /*constructor con parámetros*/
    public Descuento(long id, String codigo, Date fechavalidez) {
        this.id = id;
        this.codigo = codigo;
        this.fechavalidez = fechavalidez;
    }
    
    /*constructor de copia*/
    public Descuento(Descuento d){
        this.id = d.id;
        this.codigo = d.codigo;
        this.fechavalidez = d.fechavalidez;
    }
    
    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
     public Date getFechavalidez() {
        return fechavalidez;
    }

    public void setFechavalidez(Date fechavalidez) {
        this.fechavalidez = fechavalidez;
    }
    
    public static Descuento nuevoDescuento(){
        
        Descuento nuevo = new Descuento();
        Scanner in = new Scanner(System.in);
        
        long idnuevo;
        String codigonuevo;
        Date fechavalideznuevo;
        
        do{         //Pedira un id el cual no podra ser menor igual que 0 o este se volvera a pedir hasta que se mayor que cero
        //En caso de que el id quiera ser pedido por teclado
        System.out.print("¿Cual es el id de su descuento?: "); //Se pide el id
        idnuevo = in.nextLong();
        nuevo.setId(idnuevo);
        if(idnuevo <= 0){
            System.out.println("El id introducido no es valido,introduzcalo de nuevo"); //En caso de que sea menor igual que 0 se mopstrara este mensaje
        }
        }while(idnuevo <= 0); //Si el id es menor igual que cero se volvera a pedir el id
        //En caso de que no se quiera pedir por teclado
        nuevo.setId(Utilidades.numDescuentos + 1); //Se le suma uno a la cantidad de descuentos que existan en utilidades
        
        System.out.println("");
        
        do{
        in = new Scanner(System.in);
        
        System.out.print("¿Cual es su codigo?: "); //Se pide el codigo del descuento
        codigonuevo = in.nextLine();
        nuevo.setCodigo(codigonuevo);  
        
        if((codigonuevo.equals(""))||(codigonuevo.equals(" "))){
            System.out.println("No has introducido ningun codigo,es necesario introducir uno"); //En caso de que este codigo sea vacio se mostrara este mensaje
        }
        }while((codigonuevo.equals(""))||(codigonuevo.equals(" "))); //Si el codigo esta vacio se vuelve a pedir el codigo
        
        return nuevo;
    }
    
    
    
    /*método toString*/
    @Override
    public String toString() {
        return "Descuento{" + "id=" + id + ", codigo=" + codigo + ", fechavalidez=" + fechavalidez + '}';
    }
    
}
