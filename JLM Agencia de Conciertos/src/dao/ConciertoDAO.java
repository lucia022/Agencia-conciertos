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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucia
 */
public class ConciertoDAO {

    private Concierto c;
    private static Connection conn;

    public ConciertoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public ConciertoDAO(Concierto conci) {
        this.c = conci;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Concierto> todosConciertos() {
        ArrayList<Concierto> todosConciertos = new ArrayList<Concierto>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM concierto");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idConcierto");
                    Date diahora = prs.getDate("fechayhora");
                    int idGira = prs.getInt("idGira");
                    Concierto concierto = new Concierto(id, diahora, idGira);
                    todosConciertos.add(concierto);
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
            Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosConciertos;
    }

    public static ArrayList<Concierto> buscarConciertosByIdGira(int idGira) {
        ArrayList<Concierto> conciertos = new ArrayList<Concierto>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from concierto where idGira=" + idGira;
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("idConcierto");
                    Date diahora = rs.getDate("fechayhora");
                    Concierto conci = new Concierto(id, diahora, idGira);
                    conciertos.add(conci);
                }
                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conciertos;
    }

    public Concierto insertarConcierto(Concierto c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String diahora = sdf.format(c.getDiahora());
                long idGira = c.getIdGira();
                String sql = "INSERT INTO concierto(fechayhora, idGira)";
                sql = sql + " VALUES ('" + diahora + "'," + idGira + ")";
                //System.out.println(sql);
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM concierto WHERE ";
                sqlRec += " fechayhora='" + diahora + "'";
                sqlRec += " AND idGira=" + idGira;
                sqlRec += " ORDER BY idConcierto DESC";
                //System.out.println(sqlRec);
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    int id = rs.getInt("idConcierto");
                    Date dh = rs.getDate("fechayhora");
                    idGira = rs.getInt("idGira");
                    c = new Concierto(id, dh, idGira);
                    //System.out.println(c);
                    return c;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
                c = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public void modificarConcierto(Concierto c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String fechahora = sdf.format(c.getDiahora());

                String sql = "UPDATE concierto SET ";
                sql += " fechayhora='" + fechahora + "'";
                sql += ", idGira=" + c.getIdGira();
                sql += " WHERE idConcierto=" + c.getId();

                //System.out.println(sql);
                pstmt = conn.prepareStatement(sql);

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

    public static Concierto buscarConciertoById(int idConcierto) {
        Concierto c = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM concierto WHERE id = ?");
                pstmt.setString(1, String.valueOf(idConcierto));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idConcierto");
                    Date diahora = prs.getDate("fechayhora");
                    c = new Concierto(id, diahora);
                }
                prs.close();
                pstmt.close();
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
        return c;
    }

    public void verDetallesConcierto(Concierto c) {
        System.out.println("DETALLES de CONCIERTO");
        System.out.println("------------------------");
        System.out.println("ID: " + c.getId());
        System.out.println("FECHA: " + c.getDiahora());
        System.out.println("------------------------");
    }

    public void eliminarConcierto(int idConcierto) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM concierto WHERE idConcierto = ?");
                pstmt.setString(1, String.valueOf(idConcierto));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el CONCIERTO de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el CONCIERTO de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConciertoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public void modificarConceirto(Concierto c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = c.getNombre();

                String sql = "UPDATE plantas SET ";
                sql += "nombre='" + nombre + "'";

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(p.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(PlantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlantaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
}
