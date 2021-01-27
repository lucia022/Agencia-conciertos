/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Utilidades {
    
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final Descuento DESCUENTOS[] = {
        new Descuento(1, "abcdefg", Date.valueOf(LocalDate.parse("20/02/2026", dateFormatter))),
        new Descuento(2, "iiiiaaa", Date.valueOf(LocalDate.parse("23/07/2027", dateFormatter))),
        new Descuento(3, "aaaaiii", Date.valueOf(LocalDate.parse("01/10/2026", dateFormatter)))
    };
    public static final int numDescuentos = DESCUENTOS.length;
    
    public static final Compra COMPRAS[] = {
        new Compra(1, 12.01, "Tarjeta",  DESCUENTOS[0]),
        new Compra(2, 432.1, "Tarjeta",  DESCUENTOS[0]),
        new Compra(20, 12.01, "Tarjeta",  DESCUENTOS[0]),
        new Compra(12, 12.01, "Tarjeta",  DESCUENTOS[0]),
        new Compra(11, 12.01, "Tarjeta",  DESCUENTOS[0]),
        new Compra(10, 12.01, "Tarjeta",  DESCUENTOS[0]),
        new Compra(16, 12.01, "Tarjeta", DESCUENTOS[0]),
        new Compra(4, 12.01, "Tarjeta", DESCUENTOS[0])
    };
    public static final int numCompras = COMPRAS.length;
    
    public static final Reserva RESERVAS[] = {
        new Reserva(1, Date.valueOf(LocalDate.parse("10/02/2023", dateFormatter))),
        new Reserva(2, Date.valueOf(LocalDate.parse("11/12/2023", dateFormatter))),
        new Reserva(3, Date.valueOf(LocalDate.parse("20/09/2024", dateFormatter)))

    };
    public static final int numReservas = RESERVAS.length;
    
    public static final Usuario USUARIOS[] = {
        
        new Usuario(1, "Mario", "Araujo", "@", "11111111A",Compra.arrayde(Compra.convertir(COMPRAS), new int[]{2}),Reserva.arrayde(Reserva.convertir(RESERVAS), new int[]{1})),
        new Usuario(12, "Lucia", "Rodriguez", "lucia@gmail.com", "22222222B",Compra.arrayde(Compra.convertir(COMPRAS), new int[]{2}),Reserva.arrayde(Reserva.convertir(RESERVAS), new int[]{2})),
        new Usuario(3, "Jonathan", "Caballero", "jony@hotmail.es", "33333333C",Compra.arrayde(Compra.convertir(COMPRAS), new int[]{2}),Reserva.arrayde(Reserva.convertir(RESERVAS), new int[]{1,2})),
        new Usuario(4, "Pepe", "Gonzalez", "pepe@hotmail.es", "44444444D",Compra.arrayde(Compra.convertir(COMPRAS), new int[]{3}),Reserva.arrayde(Reserva.convertir(RESERVAS), new int[]{1,2})),
        new Usuario(8, "Gaizka", "Patron", "gaizka@hotmail.es", "55555555E",Compra.arrayde(Compra.convertir(COMPRAS), new int[]{4}),Reserva.arrayde(Reserva.convertir(RESERVAS), new int[]{2})),
        //new Usuario(6, "Aitor", "Perez", "aitor@hotmail.es", "66666666F",null,null)
    };
    public static final int numUsuarios = USUARIOS.length;

    //Parte hecha por Jonathan...asi esta...(Escrito or el propio Jonathan....Si es que no se puede dejar todo para el ultimo día...)
    public static final Informe INFORMES[] = {
        new Informe(0, "InformeGiraEspaña"),
        new Informe(1, "InformeGiraEuropa"),
        new Informe(2, "InformeGiraLatinoamerica"),
        new Informe(3, "InformeGiraUK"),};

    //public static final int numInformes = INFORMES.length;

    public static final Gira GIRAS[] = {
        new Gira(0, "España", Date.valueOf(LocalDate.parse("20/03/2019", dateFormatter)), Date.valueOf(LocalDate.parse("20/09/2019", dateFormatter)), INFORMES[2]),
        new Gira(1, "Europea", Date.valueOf(LocalDate.parse("30/01/2020", dateFormatter)), Date.valueOf(LocalDate.parse("24/10/2020", dateFormatter)), INFORMES[2]),
        new Gira(2, "Latinoamericano", Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), Date.valueOf(LocalDate.parse("14/11/2020", dateFormatter)), INFORMES[1]),
        new Gira(3, "UK", Date.valueOf(LocalDate.parse("14/04/2020", dateFormatter)), Date.valueOf(LocalDate.parse("18/09/2020", dateFormatter)), INFORMES[1]),};
   
    //public static final int numGiras = GIRAS.length;

    public static final Reportero REPORTEROS[] = {
        new Reportero(0, "Maria", "Fernandez", "652145983", "73021645N"),
        new Reportero(1, "Juan", "Ruiz", "942851546", "72051486B"),
        new Reportero(2, "Ricardo", "Perez", "652148987", "10234568C"),
        new Reportero(3, "Ana", "Carrasco", "676963369", "78021645X")
    };
    
     public static final Individual INDIVIDUALES[] = {
        
    };
    
    public static final Colaboracion COLABORACIONES[] = {
        
    };
    
    public static final Artista ARTISTAS[] = {
        new Artista(1, "La Rosalia", 'F', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(2, "Ozuna", 'R', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(3, "Anuel", 'R', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(4, "j Balvin", 'U', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(5, "Prince Roice", 'S', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(6, "Maluma", 'R', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(7, "Becky G", 'P', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>()),
        new Artista(8, "Camilo", 'P', new ArrayList<Actuacion>(),new ArrayList<Individual>(), new ArrayList<Colaboracion>())
    };
    public static final int numArtistas = ARTISTAS.length;
    
    
    public static final Actuacion ACTUACIONES[] = {
        new Actuacion(1, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*0*/
        new Actuacion(2, 4, 130.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*1*/
        new Actuacion(3, 1, 50.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*2*/
        new Actuacion(4, 3, 45.50, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*3*/
        new Actuacion(5, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*4*/
        new Actuacion(6, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*5*/
        new Actuacion(7, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*6*/
        new Actuacion(8, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*7*/
        new Actuacion(9, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*8*/
        new Actuacion(10, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*9*/
        new Actuacion(11, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*10*/
        new Actuacion(12, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*11*/
        new Actuacion(13, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*12*/
        new Actuacion(14, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*13*/
        new Actuacion(15, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*14*/
        new Actuacion(16, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*15*/
        new Actuacion(17, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*16*/
        new Actuacion(18, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*17*/
        new Actuacion(19, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*18*/
        new Actuacion(20, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*19*/
        new Actuacion(21, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*20*/
        new Actuacion(22, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*21*/
        new Actuacion(23, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*22*/
        new Actuacion(24, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*23*/
        new Actuacion(25, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*24*/
        new Actuacion(26, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*25*/
        new Actuacion(27, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*26*/
        new Actuacion(28, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*27*/
        new Actuacion(29, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})), /*28*/
        new Actuacion(30, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 5})) /*29*/
            
    };
    public static final int numActuaciones = ACTUACIONES.length;
    
   
    public static final Entrada ENTRADAS[] = {
        new Entrada(1, 12.01, false, COMPRAS[3]),
        new Entrada(2, 432.1, true, COMPRAS[1]),
        new Entrada(3, 12.01, false, COMPRAS[5]),
        new Entrada(4, 432.1, true, COMPRAS[4]),
        new Entrada(5, 12.01, false, COMPRAS[3])
    };
    public static final int numEntradas = ENTRADAS.length;
    
    public static final Concierto CONCIERTOS[] = {
        new Concierto(1, Date.valueOf(LocalDate.parse("20/01/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{2, 11, 18, 24, 27}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{0, 5})),
        new Concierto(2, Date.valueOf(LocalDate.parse("19/02/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{5, 6, 12, 17, 22}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{0, 5})),
        new Concierto(3, Date.valueOf(LocalDate.parse("19/03/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{3, 8, 14, 20, 25}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{0, 5})),
        new Concierto(4, Date.valueOf(LocalDate.parse("1/04/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{1, 9, 16, 23, 28}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{0, 5})),
        new Concierto(5, Date.valueOf(LocalDate.parse("15/05/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{4, 10, 15, 19, 25}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{0, 5})),
        new Concierto(6, Date.valueOf(LocalDate.parse("18/06/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{0, 7, 13, 21, 29}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{0, 5}))
        
    };
    public static final int numConciertos = CONCIERTOS.length;
    
    public static final Momento MOMENTOS[] = {
        new Momento(0, Date.valueOf(LocalDate.parse("22:35", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS[1]),
        new Momento(1, Date.valueOf(LocalDate.parse("21:15", dateFormatter)), "DescripcionGiraUK", REPORTEROS[1]),
        new Momento(2, Date.valueOf(LocalDate.parse("23:23", dateFormatter)), "DescripcionGiraLationoamericana", REPORTEROS[1]),
        new Momento(3, Date.valueOf(LocalDate.parse("19:30", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS[1]),
        new Momento(4, Date.valueOf(LocalDate.parse("22:46", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS[1]),
        new Momento(5, Date.valueOf(LocalDate.parse("23:50", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS[1]),
        new Momento(6, Date.valueOf(LocalDate.parse("21:45", dateFormatter)), "DescripcionGiraEpañola", REPORTEROS[1]),
        new Momento(7, Date.valueOf(LocalDate.parse("21:25", dateFormatter)), "DescripcionGiraUK", REPORTEROS[1]),
        new Momento(8, Date.valueOf(LocalDate.parse("22:12", dateFormatter)), "DescripcionGiraUK", REPORTEROS[1]),
        new Momento(9, Date.valueOf(LocalDate.parse("22:36", dateFormatter)), "DescripcionGiraUK", REPORTEROS[1]),
        new Momento(10, Date.valueOf(LocalDate.parse("23:01", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS[1]),
        new Momento(11, Date.valueOf(LocalDate.parse("22:13", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS[1]),
        new Momento(12, Date.valueOf(LocalDate.parse("21:12", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS[1]),
        new Momento(13, Date.valueOf(LocalDate.parse("22:48", dateFormatter)), "DescripcionGiraLatinoamericanaa", REPORTEROS[1]),
        new Momento(14, Date.valueOf(LocalDate.parse("22:14", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS[1]),
        new Momento(15, Date.valueOf(LocalDate.parse("22:46", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS[1]),
        new Momento(16, Date.valueOf(LocalDate.parse("19:56", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS[1]),
        new Momento(17, Date.valueOf(LocalDate.parse("20:36", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS[1]),
        new Momento(18, Date.valueOf(LocalDate.parse("21:39", dateFormatter)), "DescripcionGiraUK", REPORTEROS[1]),
        new Momento(19, Date.valueOf(LocalDate.parse("22:02", dateFormatter)), "DescripcionGiraUK", REPORTEROS[1]),
        new Momento(20, Date.valueOf(LocalDate.parse("23:36", dateFormatter)), "DescripcionGiraLatinoamericana", REPORTEROS[1]),
        new Momento(21, Date.valueOf(LocalDate.parse("00:12", dateFormatter)), "DescripcionGiraEspañola", REPORTEROS[1]),
        new Momento(22, Date.valueOf(LocalDate.parse("21:56", dateFormatter)), "DescripcionGiraEuropea", REPORTEROS[1]),};

    //public static final int numMomenos = MOMENTOS.length;*/
    
     public static String removeDiacriticalMarks(String string) {
        //Form.NFC acepta ñ y distingue las tildes en español
        return Normalizer.normalize(string, Normalizer.Form.NFC)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
