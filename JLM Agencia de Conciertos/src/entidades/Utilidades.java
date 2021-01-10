/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Utilidades {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /*public static Date dameFecha(){
        
        Scanner in = new Scanner(System.in);
        Date Date = new Date();
        System.out.print("Dame mes: ");
        int mes = in.nextInt();
        System.out.print("Dame año: ");
        int ano = in.nextInt();
        System.out.print("Dame dia: ");
        int dia = in.nextInt();
        Date date = new GregorianCalendar(ano,mes,dia).getTime();
        
        return Date;
    }*/

    public static final Usuario USUARIOS[] = {
        new Usuario(1, "Mario", "Araujo", "maraujoe01@educantabria.es", "11111111A"),
        new Usuario(2, "Lucia", "Rodriguez", "lucia@gmail.com", "22222222B"),
        new Usuario(3, "Jonathan", "Caballero", "jony@hotmail.es", "33333333C"),
        new Usuario(4, "Pepe", "Gonzalez", "pepe@hotmail.es", "44444444D"),
        new Usuario(5, "Gaizka", "Patron", "gaizka@hotmail.es", "55555555E"),
        new Usuario(6, "Aitor", "Perez", "aitor@hotmail.es", "66666666F")
    };
    public static final int numUsuarios = USUARIOS.length;

    public static final Descuento DESCUENTOS[] = {
        new Descuento(1, "abcdefg", Date.valueOf(LocalDate.parse("20/02/2026", dateFormatter))),
        new Descuento(2, "iiiiaaa", Date.valueOf(LocalDate.parse("23/07/2027", dateFormatter))),
        new Descuento(3, "aaaaiii", Date.valueOf(LocalDate.parse("01/10/2026", dateFormatter)))
    };
    public static final int numDescuentos = DESCUENTOS.length;

    public static final Reserva RESERVAS[] = {
        new Reserva(1, Date.valueOf(LocalDate.parse("10/02/2023", dateFormatter)), USUARIOS[0]),
        new Reserva(2, Date.valueOf(LocalDate.parse("11/12/2023", dateFormatter)), USUARIOS[5]),
        new Reserva(3, Date.valueOf(LocalDate.parse("20/09/2024", dateFormatter)), USUARIOS[3])
                                
        
    };
    public static final int numReservas = RESERVAS.length;

    /*public static final Compra COMPRAS[] = {
       
        new Compra(1, 12.01, "Tarjeta",),
        new Compra(2, 432.1, "Tarjeta",),
        new Compra(1, 12.01, "Tarjeta",),
        new Compra(1, 12.01, "Tarjeta",),
        new Compra(1, 12.01, "Tarjeta",),
        new Compra(1, 12.01, "Tarjeta",),
        new Compra(1, 12.01, "Tarjeta",),
        new Compra(1, 12.01, "Tarjeta",)
    }*/
    
    
}
