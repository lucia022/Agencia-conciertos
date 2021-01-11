/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Utilidades {

    public static java.util.Date dameFecha() throws ParseException {

        java.util.Date fechaDate;//En esta variable se pasara el String
        boolean fallo = false;

        do {    //Hay que decir que en caso de no introducir las / dara error y el prgrama cascara,sin embargo en caso de introducir las 3/ y estas estar incomploetas como 2/1/200 el programa volvera a pedir la fecha

            Scanner in = new Scanner(System.in);
            System.out.print("Introduzca la fecha con formato dd/mm/yyyy: "); //Se intriduce la fecha con el formato pedid y se guarda en un string
            String fechaString = in.nextLine();
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy"); //nueva fecha con formato simple

            fechaDate = dateformat.parse(fechaString); //Con el metodo parse se pasa de string a date

            if (!(dateformat.format(fechaDate).equals(fechaString))) {//Si el formato esta mal sera invalida
                System.out.println("Error,ese formato no es valido\nPor favor introduzcala de nuevo");
                continue;
            }

            System.out.println("La fecha es: " + fechaDate);//Nos dice cual es la fecha

            System.out.println("¿Es esta la fecha?(true en caso afirmativo,false en caso negativo)");//pregunta si la fecha es esa
            fallo = in.nextBoolean();

            if (fallo == false) {
                System.out.println("Vale,entonces introduzcala de nuevo");//En caso negativo mostrara este mensaje
            }
        } while (fallo == false);

        return fechaDate;
    }

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    public static final Compra COMPRAS[] = {
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(2, 432.1, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0]),
        new Compra(1, 12.01, "Tarjeta", USUARIOS[0], DESCUENTOS[0])
    };
    public static final int numCompras = COMPRAS.length;
    
    
    
    //Parte hecha por Jonathan...asi esta...(Escrito or el propio Jonathan....Si es que no se puede dejar todo para el ultimo día...)

    public static final Informe INFORMES[] = {
        new Informe(0, "InformeGiraEspaña"),
        new Informe(1, "InformeGiraEuropa"),
        new Informe(2, "InformeGiraLatinoamerica"),
        new Informe(3, "InformeGiraUK"),};

    public static final int numInformes = INFORMES.length;

    public static final Gira GIRAS[] = {
        new Gira(0, "España", Date.valueOf(LocalDate.parse("20/03/2019", dateFormatter)), Date.valueOf(LocalDate.parse("20/09/2019", dateFormatter)), INFORMES[2]),
        new Gira(1, "Europea", Date.valueOf(LocalDate.parse("30/01/2020", dateFormatter)), Date.valueOf(LocalDate.parse("24/10/2020", dateFormatter)), INFORMES[2]),
        new Gira(2, "Latinoamericano", Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), Date.valueOf(LocalDate.parse("14/11/2020", dateFormatter)), INFORMES[1]),
        new Gira(3, "UK", Date.valueOf(LocalDate.parse("14/04/2020", dateFormatter)), Date.valueOf(LocalDate.parse("18/09/2020", dateFormatter)), INFORMES[1]),
        
    public static final int numGiras = Giras.length;
    

    public static final Reportero REPORTEROS[] = {
        new Reportero(0, "Maria", "Fernandez", "652145983", "73021645N"),
        new Reportero(1, "Juan", "Ruiz", "942851546", "72051486B"),
        new Reportero(2, "Ricardo", "Perez", "652148987", "10234568C"),
        new Reportero(3, "Ana", "Carrasco", "676963369", "78021645X")
    };

    public static final int numReporteros = REPORTEROS.length;

    public static final Momento MOMENTOS[] = {
        new Momento(0, Date.valueOf(LocalDate.parse("22:35", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS [1]),
        new Momento(1, Date.valueOf(LocalDate.parse("21:15", dateFormatter)), "DescripcionGiraUK", REPORTEROS [1]),
        new Momento(2, Date.valueOf(LocalDate.parse("23:23", dateFormatter)), "DescripcionGiraLationoamericana", REPORTEROS [1]),
        new Momento(3, Date.valueOf(LocalDate.parse("19:30", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS [1]),
        new Momento(4, Date.valueOf(LocalDate.parse("22:46", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS [1]),
        new Momento(5, Date.valueOf(LocalDate.parse("23:50", dateFormatter)), "DescripcionGiraLatinoamericana",REPORTEROS [1]),
        new Momento(6, Date.valueOf(LocalDate.parse("21:45", dateFormatter)), "DescripcionGiraEpañola",REPORTEROS [1]),
        new Momento(7, Date.valueOf(LocalDate.parse("21:25", dateFormatter)), "DescripcionGiraUK", REPORTEROS [1]),
        new Momento(8, Date.valueOf(LocalDate.parse("22:12", dateFormatter)), "DescripcionGiraUK", REPORTEROS [1]),
        new Momento(9, Date.valueOf(LocalDate.parse("22:36", dateFormatter)), "DescripcionGiraUK", REPORTEROS [1]),
        new Momento(10, Date.valueOf(LocalDate.parse("23:01", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS [1]),
        new Momento(11, Date.valueOf(LocalDate.parse("22:13", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS [1]),
        new Momento(12, Date.valueOf(LocalDate.parse("21:12", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS [1]),
        new Momento(13, Date.valueOf(LocalDate.parse("22:48", dateFormatter)), "DescripcionGiraLatinoamericanaa", REPORTEROS [1]),
        new Momento(14, Date.valueOf(LocalDate.parse("22:14", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS [1]),
        new Momento(15, Date.valueOf(LocalDate.parse("22:46", dateFormatter)), "DescripcionGiraEspañola",REPORTEROS [1]),
        new Momento(16, Date.valueOf(LocalDate.parse("19:56", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS [1]),
        new Momento(17, Date.valueOf(LocalDate.parse("20:36", dateFormatter)), "DescripcionGiraEuropea",REPORTEROS [1]),
        new Momento(18, Date.valueOf(LocalDate.parse("21:39", dateFormatter)), "DescripcionGiraUK",REPORTEROS [1]),
        new Momento(19, Date.valueOf(LocalDate.parse("22:02", dateFormatter)), "DescripcionGiraUK",REPORTEROS [1]),
        new Momento(20, Date.valueOf(LocalDate.parse("23:36", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS [1]),
        new Momento(21, Date.valueOf(LocalDate.parse("00:12", dateFormatter)), "DescripcionGiraEspañola",REPORTEROS [1]),
        new Momento(22, Date.valueOf(LocalDate.parse("21:56", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS [1]),};

    public static final int numMomenos = MOMENTOS.length;

}
