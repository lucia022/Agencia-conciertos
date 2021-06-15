/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucia
 */
public class ReservaDAO {

    private static Connection conn;
    private Reserva r;

    public ReservaDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public ReservaDAO(Reserva res) {
        this.r = res;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Reserva> todasReservas() {
        ArrayList<Reserva> todasReservas = new ArrayList<Reserva>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM reserva");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idReserva");
                    Date fechamaxima = prs.getDate("fechamaxima");
                    int idUsuario = prs.getInt("idUsuario");
                    Reserva reserva = new Reserva(id, fechamaxima, idUsuario);
                    todasReservas.add(reserva);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasReservas;
    }

}
