/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ameli
 */
public class InformeDAO {

    private static Connection conn;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    Informe i;

    public InformeDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public InformeDAO(Informe i) {
        this.i = i;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Informe> todosInformes() {
        ArrayList<Informe> todosInformes = new ArrayList<Informe>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM informe");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idinforme");
                    String descripcion = prs.getString("descripcion");
                    Informe inf = new Informe(id, descripcion);
                    todosInformes.add(inf);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosInformes;
    }

    public static Informe buscarInformeById(long idInforme) {
        Informe i = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql = "SELECT * FROM informe WHERE idinforme =" + idInforme;
                //System.out.println(sql);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //pstmt.setString(1, String.valueOf(idInforme));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idinforme");
                    String descripcion = prs.getString("descripcion");
                    i = new Informe(id, descripcion);
                }

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

}
