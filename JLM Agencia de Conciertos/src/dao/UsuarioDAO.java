/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class UsuarioDAO {

    private Usuario p;
    private static Connection conn;

    public UsuarioDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public UsuarioDAO(Usuario usu) {
        this.p = usu;
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Usuario> todosUsuarios() {
        ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM usuario");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idUsuario");
                    String nombre = prs.getString("nombre");
                    String apellido = prs.getString("apellido");
                    String email = prs.getString("email");
                    String nif = prs.getString("nif");
                    Usuario usu = new Usuario(id, nombre, apellido, email, nif);
                    todosUsuarios.add(usu);
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
        return todosUsuarios;
    }

    public Usuario insertarUsuario(Usuario u) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombre = u.getNombre();
                String apellido = u.getApellido();
                String email = u.getEmail();
                String nif = u.getNif();

                String sql = "INSERT INTO usuario(nombre, apellido, email, nif) VALUES('" + nombre + "', '" + apellido + "', '" + email + "', '" + nif + "')";
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
        return u;
    }
    
      public void modificarUsuario(Usuario u) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombre = u.getNombre();
                String apellido = u.getNombre();
                String email = u.getNombre();
                String nif = u.getNombre();

                String sql = "UPDATE usuario SET ";
                sql += "nombre='" + nombre + "',";
                sql += "apellido='" + apellido + "',";
                sql += "email='" + email + "',";
                sql += "nif='" + nif + "'";

                sql += " WHERE idUsuario = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(u.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado la localización de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      public void eliminarUsuario(int idUsuario) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
                pstmt.setString(1, String.valueOf(idUsuario));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el usuario de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el usuario de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public static Usuario buscarUsuarioById(int idUsuario) {
        Usuario usuario = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
                pstmt.setString(1, String.valueOf(idUsuario));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idUsuario");
                    String nombre = prs.getString("nombre");
                    String apellido = prs.getString("apellido");
                    String email = prs.getString("email");
                    String nif = prs.getString("nif");
                    usuario = new Usuario(id, nombre, apellido, email, nif);
                }
                prs.close();
                pstmt.close();

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
        return usuario;
    }

      
}
