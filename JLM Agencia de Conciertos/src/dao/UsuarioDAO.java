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
                    Boolean admin = prs.getBoolean("administrador");
                    String contraseña = prs.getString("contrasena");
                    int iddireccion = prs.getInt("iddireccion");
                    int idbancario = prs.getInt("idbancario");
                    Usuario usu = new Usuario(id, nombre, apellido, email, nif, admin, contraseña,iddireccion,idbancario);
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
                Boolean administrador1 = u.getAdministrador();
                int administrador;
                if (administrador1) {
                    administrador = 1;
                } else {
                    administrador = 0;
                }
                String contraseña = u.getContraseña();
                int iddireccion = u.getIdDireccion();
                int idbancario = u.getIdBancario();

                String sql = "INSERT INTO usuario(nombre, apellido, email, nif, administrador,contrasena,idDireccion,idbancario) VALUES('" + nombre + "', '" + apellido + "', '" + email + "', '" + nif + "','" + administrador + "','" + contraseña +"','" + iddireccion +"','" + idbancario + "')";
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
                String apellido = u.getApellido();
                String email = u.getEmail();
                String nif = u.getNif();
                Boolean administrador1 = u.getAdministrador();
                int administrador;
                if (administrador1) {
                    administrador = 1;
                } else {
                    administrador = 0;
                }
                String contraseña = u.getContraseña();

                String sql = "UPDATE usuario SET ";
                sql += "nombre='" + nombre + "',";
                sql += "apellido='" + apellido + "',";
                sql += "email='" + email + "',";
                sql += "nif='" + nif + "',";
                sql += "administrador='" + administrador + "',";
                sql += "contrasena='" + contraseña + "'";

                sql += " WHERE idUsuario = " + u.getId();
                pstmt = conn.prepareStatement(sql);

                pstmt.executeUpdate(sql);
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
                pstmt = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario = "+idUsuario);
                pstmt.executeUpdate();
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
