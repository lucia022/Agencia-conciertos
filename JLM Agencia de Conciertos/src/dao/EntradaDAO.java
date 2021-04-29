/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Entrada;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class EntradaDAO {
    private Entrada e;
    private static Connection conn;

    public EntradaDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public EntradaDAO(Entrada ent) {
        this.e = ent;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Entrada> todasEntradas() {
        ArrayList<Entrada> todasEntradas = new ArrayList<Entrada>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM entrada");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idEntrada");
                    double precio = prs.getDouble("precio");
                    boolean vip = prs.getBoolean("vip");
                    boolean disponible = prs.getBoolean("disponible");
                    long idConcierto = prs.getLong("idConcierto");
                    long idReserva = prs.getLong("idReserva");
                    long idCompra = prs.getLong("idCompra");
    
                    Entrada ent = new Entrada(id, precio, vip, disponible,idConcierto,idReserva,idCompra);
                    todasEntradas.add(ent);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasEntradas;
    }
}
