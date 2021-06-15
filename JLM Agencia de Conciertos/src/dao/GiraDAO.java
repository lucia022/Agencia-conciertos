/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Concierto;
import entidades.Gira;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucia
 */
public class GiraDAO {

    private static Connection conn;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private Gira g;

    public GiraDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public GiraDAO(Gira gi) {
        this.g = gi;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Gira> todasGiras() {
        ArrayList<Gira> todasGiras = new ArrayList<Gira>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM gira");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idGira");
                    String nombre = prs.getString("nombre");
                    Date fechainicio = prs.getDate("fechainicio");
                    Date fechacierra = prs.getDate("fechafinal");
                    int idInforme = prs.getInt("idInforme");
                    Gira gira = new Gira(id, nombre, fechainicio, fechacierra, idInforme);
                    todasGiras.add(gira);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasGiras;
    }

    public Gira insertarGira(Gira g) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombre = g.getNombre();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fi = sdf.format(g.getFechainicio());
                String fc = sdf.format(g.getFechacierra());
                String sql = "INSERT INTO gira(nombre, fechainicio, fechafinal, idInforme)";
                sql = sql + " VALUES ('" + nombre + "','" + fi + "','" + fc + "', 1)";
                //System.out.println(sql);
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM gira WHERE ";
                sqlRec += " nombre='" + nombre + "'";
                sqlRec += " ORDER BY idGira DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    int id = rs.getInt("idGira");
                    nombre = rs.getString("nombre");
                    Date fechainicio = rs.getDate("fechainicio");
                    Date fechacierra = rs.getDate("fechafinal");
                    int idInforme = rs.getInt("idInforme");
                    g = new Gira(id, nombre, fechainicio, fechacierra, idInforme);
                    return g;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
                g = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    public static Gira buscarGiraById(long idGira) {
        Gira g = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM gira WHERE idGira = ?");
                pstmt.setString(1, String.valueOf(idGira));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idGira");
                    String nombre = prs.getString("nombre");
                    Date fechainicio = prs.getDate("fechainicio");
                    Date fechacierra = prs.getDate("fechafinal");
                    int idInforme = prs.getInt("idInforme");
                    g = new Gira(id, nombre, fechainicio, fechacierra, idInforme);
                }
                prs.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    public void modificarGira(Gira g) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = g.getNombre();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fi = sdf.format(g.getFechainicio());
                String fc = sdf.format(g.getFechacierra());

                String sql = "UPDATE gira SET ";
                sql += "nombre='" + nombre + "'";
                sql += ", fechainicio='" + fi + "'";
                sql += ", fechafinal='" + fc + "'";
                sql += ", idInforme=" + g.getIdInforme();
                sql += " WHERE idGira=" + g.getId();

                System.out.println(sql);

                pstmt = conn.prepareStatement(sql);
                //pstmt.setString(1, String.valueOf(g.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarGira(int idGira) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM gira WHERE idGira = ?");
                pstmt.setString(1, String.valueOf(idGira));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado la GIRA de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado la GIRA de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verDetallesGira(Gira g) {
        System.out.println("DETALLES de Gira");
        System.out.println("------------------------");
        System.out.println("ID: " + g.getId());
        System.out.println("NOMBRE: " + g.getNombre());
        System.out.println("FECHA INICIO: " + g.getFechainicio());
        System.out.println("FECHA CIERRE: " + g.getFechacierra());
        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();
        conciertos = ConciertoDAO.buscarConciertosByIdGira((int) g.getId());
        for (Concierto conci : conciertos) {
            System.out.println("CONCIERTO: " + conci.getId() + " " + conci.getDiahora());
        }
        System.out.println("------------------------");
    }
}
