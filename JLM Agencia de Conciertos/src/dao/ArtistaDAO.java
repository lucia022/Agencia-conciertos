/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Artista;
import java.sql.Connection;
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
public class ArtistaDAO {

    private Artista ar;
    private static Connection conn;

    public ArtistaDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public ArtistaDAO(Artista arti) {
        this.ar = arti;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Artista> todosArtistas() {
        ArrayList<Artista> todosArtistas = new ArrayList<Artista>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM artista");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idArtista");
                    String nombre = prs.getString("nombre");
                    char generomusical = prs.getString("generomusical").charAt(0);
                    Artista artista = new Artista(id, nombre, generomusical);
                    todosArtistas.add(artista);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosArtistas;
    }

}
