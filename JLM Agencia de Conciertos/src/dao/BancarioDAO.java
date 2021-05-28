/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Bancario;
import entidades.Direccion;
import entidades.Usuario;
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
 * @author usuario
 */
public class BancarioDAO {

    private Bancario p;
    private static Connection conn;

    public BancarioDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public BancarioDAO(Bancario ban) {
        this.p = ban;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Bancario> todosTarjetas() {
        ArrayList<Bancario> todasTarjetas = new ArrayList<Bancario>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM bancario");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idbancario");
                    String nombretitular = prs.getString("nombretitular");
                    String numtarjeta = prs.getString("numtarjeta");
                    String codigotarjeta = prs.getString("codigotarjeta");
                    Bancario ban = new Bancario(id, nombretitular, numtarjeta, codigotarjeta);
                    todasTarjetas.add(ban);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasTarjetas;
    }

    public Bancario insertarTarjeta(Bancario b) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombretitular = b.getTitular();
                String numtarjeta = b.getNumtarjeta();
                String codigotarjeta = b.getCodigotarjeta();

                String sql = "INSERT INTO bancario(nombretitular,numtarjeta,codigotarjeta) VALUES('" + nombretitular + "', '" + numtarjeta + "', '" + codigotarjeta + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                p = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public static int buscarIDBynumTarjeta(String numtarjeta) {
        int idbuscado = 0;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT idbancario FROM bancario WHERE numtarjeta = '" + numtarjeta + "'");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idbancario");
                    idbuscado = id;

                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idbuscado;
    }
    
    public  Bancario buscarBancarioById(int idBancario) {
        Bancario bancario = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM bancario WHERE idBancario = "+idBancario);
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idbancario");
                    String nombretitular = prs.getString("nombretitular");
                    String numtarjeta = prs.getString("numtarjeta");
                    String codigotarjeta = prs.getString("codigotarjeta");
                    bancario = new Bancario(id, nombretitular, numtarjeta, codigotarjeta);
                    
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bancario;
    }
    
     public void modificarBancario(Bancario b) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombretitular = b.getTitular();
                String numtarjeta = b.getNumtarjeta();
                String codigotarjeta = b.getCodigotarjeta();
 
                String sql = "UPDATE bancario SET ";
                sql += "nombretitular='" + nombretitular + "',";
                sql += "numtarjeta='" + numtarjeta + "',";
                sql += "codigotarjeta='" + codigotarjeta + "'";
        
    

                sql += " WHERE idBancario = " + b.getId();
                pstmt = conn.prepareStatement(sql);

                pstmt.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado la localización de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}
