/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Actuacion;
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
public class ActuacionDAO {

    private Actuacion ac;
    private static Connection conn;

    public ActuacionDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public ActuacionDAO(Actuacion actu) {
        this.ac = actu;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Actuacion> todasActuaciones() {
        ArrayList<Actuacion> todasActuaciones = new ArrayList<Actuacion>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM actuacion");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idActuacion");
                    int numerosecuencia = prs.getInt("numerosecuencia");
                    double duracion = prs.getDouble("duracion");
                    int idConcierto = prs.getInt("Concierto_idConcierto");
                    Actuacion actuacion = new Actuacion(id, numerosecuencia, duracion, idConcierto);
                    todasActuaciones.add(actuacion);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ActuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasActuaciones;
    }

}
