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

    public static final Entrada ENTRADAS[] = {
        new Entrada(1, 12.01, false, 4), /*0*/
        new Entrada(2, 432.1, true, 20), /*1*/
        new Entrada(3, 12.01, false, 2), /*2*/
        new Entrada(4, 432.1, true, 10), /*3*/
        new Entrada(5, 12.01, false, 9), /*4*/
        new Entrada(6, 432.1, true, 2), /*5*/
        new Entrada(7, 12.01, false, 1), /*6*/
        new Entrada(8, 432.1, true, 5), /*7*/
        new Entrada(9, 12.01, false, 10), /*8*/
        new Entrada(10, 432.1, true, 8), /*9*/
        new Entrada(11, 12.01, false, 0), /*10*/
        new Entrada(12, 432.1, true, 7) /*11*/};
    public static final int numEntradas = ENTRADAS.length;

    //Parte hecha por Jonathan...asi esta...(Escrito or el propio Jonathan....Si es que no se puede dejar todo para el ultimo día...)
    public static final Informe INFORMES[] = {
        new Informe(0, "InformeGiraEspaña"),
        new Informe(1, "InformeGiraEuropa"),
        new Informe(2, "InformeGiraLatinoamerica"),
        new Informe(3, "InformeGiraUK"),};

    //public static final int numInformes = INFORMES.length;
    public static final Gira GIRAS[] = {
        new Gira(0, "España", Date.valueOf(LocalDate.parse("20/03/2019", dateFormatter)), Date.valueOf(LocalDate.parse("20/09/2019", dateFormatter)), 0),
        new Gira(1, "Europea", Date.valueOf(LocalDate.parse("30/01/2020", dateFormatter)), Date.valueOf(LocalDate.parse("24/10/2020", dateFormatter)), 1),
        new Gira(2, "Latinoamericano", Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), Date.valueOf(LocalDate.parse("14/11/2020", dateFormatter)), 2),
        new Gira(3, "UK", Date.valueOf(LocalDate.parse("14/04/2020", dateFormatter)), Date.valueOf(LocalDate.parse("18/09/2020", dateFormatter)), 3)
    };
    public static final int numGiras = GIRAS.length;
    public static final Momento MOMENTOS[] = {
        new Momento(0, Date.valueOf(LocalDate.parse("20/03/2019", dateFormatter)), "DescripcionGiraEspañola"),
        new Momento(1, Date.valueOf(LocalDate.parse("14/04/2020", dateFormatter)), "DescripcionGiraUK"),
        new Momento(2, Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), "DescripcionGiraLationoamericana"),
        new Momento(3, Date.valueOf(LocalDate.parse("30/01/2020", dateFormatter)), "DescripcionGiraEuropea"),
        new Momento(4, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraLatinoamericana"),
        new Momento(5, Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), "DescripcionGiraLatinoamericana"),
        new Momento(6, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEpañola"),
        new Momento(7, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraUK"),
        new Momento(8, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraUK"),
        new Momento(9, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraUK"),
        new Momento(10, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEspañola"),
        new Momento(11, Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), "DescripcionGiraLatinoamericana"),
        new Momento(12, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEuropea"),
        new Momento(13, Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), "DescripcionGiraLatinoamericanaa"),
        new Momento(14, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEspañola"),
        new Momento(15, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEspañola"),
        new Momento(16, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEuropea"),
        new Momento(17, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEuropea"),
        new Momento(18, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraUK"),
        new Momento(19, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraUK"),
        new Momento(20, Date.valueOf(LocalDate.parse("03/03/2020", dateFormatter)), "DescripcionGiraLatinoamericana"),
        new Momento(21, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEspañola"),
        new Momento(22, Date.valueOf(LocalDate.parse("12/12/2000", dateFormatter)), "DescripcionGiraEuropea"),};

    public static final Reportero REPORTEROS[] = {
        new Reportero(0, "Maria", "Fernandez", "652145983", "73021645N", Momento.arrayde(Momento.convertir(MOMENTOS), new int[]{1})),
        new Reportero(1, "Juan", "Ruiz", "942851546", "72051486B"),
        new Reportero(2, "Ricardo", "Perez", "652148987", "10234568C"),
        new Reportero(3, "Ana", "Carrasco", "676963369", "78021645X")
    };

    public static final Artista ARTISTAS[] = {
        new Artista(1, "La Rosalia", 'F'), /*0*/
        new Artista(2, "Ozuna", 'R'), /*1*/
        new Artista(3, "Anuel", 'R'), /*2*/
        new Artista(4, "j Balvin", 'U'), /*3*/
        new Artista(5, "Prince Roice", 'S'), /*4*/
        new Artista(6, "Maluma", 'R'), /*5*/
        new Artista(7, "Becky G", 'P'), /*6*/
        new Artista(8, "Camilo", 'P') /*7*/};
    public static final int numArtistas = ARTISTAS.length;

    public static final Individual INDIVIDUALES[] = {
        new Individual(ARTISTAS[3]),
        new Individual(ARTISTAS[7]),
        new Individual(ARTISTAS[1]),
        new Individual(ARTISTAS[6]),
        new Individual(ARTISTAS[2]),
        new Individual(ARTISTAS[5]),
        new Individual(ARTISTAS[0]),
        new Individual(ARTISTAS[4])
    };
    public static final int numIndividuales = INDIVIDUALES.length;

    public static final Colaboracion COLABORACIONES[] = {
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 3})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 5})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1, 6})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7, 4})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{5, 6})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{3, 4})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 1})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 3})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 7})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4, 6})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 2})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7, 5})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1, 7})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4, 0})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 6})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1, 5})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{3, 7})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 4})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4, 1})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{5, 0})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7, 6})),
        new Colaboracion(Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{6, 3}))
    };
    public static final int numColaboraciones = COLABORACIONES.length;

    public static final Actuacion ACTUACIONES[] = {
        new Actuacion(1, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 3}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*0*/
        new Actuacion(2, 4, 130.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 5}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*1*/
        new Actuacion(3, 1, 50.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1, 6}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*2*/
        new Actuacion(4, 3, 45.50, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7, 4}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*3*/
        new Actuacion(5, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{5, 6}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*4*/
        new Actuacion(6, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{3, 4}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*5*/
        new Actuacion(7, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 1}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*6*/
        new Actuacion(8, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 3}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*7*/
        new Actuacion(9, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 7}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*8*/
        new Actuacion(10, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4, 6}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*9*/
        new Actuacion(11, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0, 2}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*10*/
        new Actuacion(12, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7, 5}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*11*/
        new Actuacion(13, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1, 7}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*12*/
        new Actuacion(14, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4, 0}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*13*/
        new Actuacion(15, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 6}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*14*/
        new Actuacion(16, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1, 5}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*15*/
        new Actuacion(17, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{3, 7}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*16*/
        new Actuacion(18, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2, 4}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*17*/
        new Actuacion(19, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4, 1}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*18*/
        new Actuacion(20, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{5, 0}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*19*/
        new Actuacion(21, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7, 6}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*20*/
        new Actuacion(22, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{6, 3}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*21*/
        new Actuacion(23, 2, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{3}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*22*/
        new Actuacion(24, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{7}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*23*/
        new Actuacion(25, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{1}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*24*/
        new Actuacion(26, 3, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{6}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*25*/
        new Actuacion(27, 5, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{2}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*26*/
        new Actuacion(28, 1, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{5}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*27*/
        new Actuacion(29, 4, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{0}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})), /*28*/
        new Actuacion(30, 6, 240.00, Artista.arrayde(Artista.convertir(ARTISTAS), new int[]{4}), Reportero.arrayde(Reportero.convertir(REPORTEROS), new int[]{0, 3})) /*29*/};

    public static final int numActuaciones = ACTUACIONES.length;

    public static final Concierto CONCIERTOS[] = {
        new Concierto(1, Date.valueOf(LocalDate.parse("20/01/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{2, 11, 18, 24, 27}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{1, 2, 3})),
        new Concierto(2, Date.valueOf(LocalDate.parse("19/02/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{5, 6, 12, 17, 22}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{4, 6})),
        new Concierto(3, Date.valueOf(LocalDate.parse("19/03/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{3, 8, 14, 20, 25}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{5, 7, 8})),
        new Concierto(4, Date.valueOf(LocalDate.parse("11/04/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{1, 9, 16, 23, 28}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{9})),
        new Concierto(5, Date.valueOf(LocalDate.parse("15/05/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{4, 10, 15, 19, 25}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{10, 11})),
        new Concierto(6, Date.valueOf(LocalDate.parse("18/06/2026", dateFormatter)), Actuacion.arrayde(Actuacion.convertir(ACTUACIONES), new int[]{0, 7, 13, 21, 29}), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{12, 13, 14}))

    };

    public static final Reserva RESERVAS[] = {
        new Reserva(1, Date.valueOf(LocalDate.parse("10/02/2023", dateFormatter)), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{10, 11})),
        new Reserva(2, Date.valueOf(LocalDate.parse("11/12/2023", dateFormatter)), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{8, 9})),
        new Reserva(3, Date.valueOf(LocalDate.parse("20/09/2024", dateFormatter)), Entrada.arrayde(Entrada.convertir(ENTRADAS), new int[]{5}))
    };
    public static final int numReservas = RESERVAS.length;

}
