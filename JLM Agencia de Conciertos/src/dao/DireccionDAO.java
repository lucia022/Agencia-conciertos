/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Direccion;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class DireccionDAO {

    private Direccion p;
    private static Connection conn;

    public DireccionDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public DireccionDAO(Direccion dir) {
        this.p = dir;
        conn = ConexionBD.establecerConexion();
    }

    public Direccion insertarDireccion(Direccion d) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String calle = d.getCalle();
                String municipio = d.getMunicipio();
                String codigopostal = d.getCodigoPostal();
                String pais = d.getPais();
                String ciudad = d.getCiudad();

                String sql = "INSERT INTO direccion(pais, ciudad, calle, municipio, codigo_postal) VALUES('" + pais + "', '" + ciudad + "', '" + calle + "', '" + municipio + "','" + codigopostal + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                p = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public static int buscarIDByCalle(String calle) {
        int idbuscado = 0;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT idDireccion FROM direccion WHERE calle = '" + calle + "'");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idDireccion");
                    idbuscado = id;

                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idbuscado;
    }
    
    public  Direccion buscarDireccionById(int idDireccion) {
        Direccion direccion = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM direccion WHERE idDireccion = "+idDireccion);
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idDireccion");
                    String pais = prs.getString("pais");
                    String ciudad = prs.getString("ciudad");
                    String calle = prs.getString("Calle");
                    String municipio = prs.getString("municipio");
                    String codigopostal = prs.getString("codigo_postal");
                    direccion = new Direccion(id, calle,codigopostal,pais,ciudad,municipio);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return direccion;
    }

    
     public void modificarDireccion(Direccion d) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String calle = d.getCalle();
                String municipio = d.getMunicipio();
                String codigopostal = d.getCodigoPostal();
                String pais = d.getPais();
                String ciudad = d.getCiudad();

                String sql = "UPDATE direccion SET ";
                sql += "pais='" + pais + "',";
                sql += "ciudad='" + ciudad + "',";
                sql += "Calle='" + calle + "',";
                sql += "municipio='" + municipio + "',";
                sql += "codigo_postal='" + codigopostal + "'";
    

                sql += " WHERE idDireccion = " + d.getId();
                pstmt = conn.prepareStatement(sql);

                pstmt.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado la localización de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
