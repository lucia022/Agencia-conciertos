/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlm.agencia.de.conciertos;

import entidades.Compra;
import entidades.Descuento;
import entidades.Fecha;
import entidades.Reserva;
import entidades.Usuario;
import entidades.Utilidades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class JLMAgenciaDeConciertos {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here


       Date fecha = Fecha.dameFecha();

        Usuario usuario = new Usuario();
        usuario = Usuario.nuevoUsuario();

        Compra compra = new Compra();
        compra = Compra.nuevaCompra();

        Descuento descuento = new Descuento();
        descuento = Descuento.nuevoDescuento();

        Reserva reserva = new Reserva();
        reserva = Reserva.nuevaReserva();

       
       
       
      

    
        
    }
}
