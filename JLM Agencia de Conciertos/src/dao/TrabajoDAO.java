/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Trabajo;
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
public class TrabajoDAO {

    private Trabajo p;
    private static Connection conn;

    public TrabajoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public TrabajoDAO(Trabajo tra) {
        this.p = tra;
        conn = ConexionBD.establecerConexion();
    }

    public Trabajo insertarCandidato(Trabajo t) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombre = t.getNombre();
                String apellido = t.getApellido();
                String email = t.getEmail();
                String nif = t.getNif();
                String telefono = t.getTelefono();
                String sexo = t.getSexo();
                String estudios = t.getEstudios();
                int edad = t.getEdad();
                int carnet = t.getCarnet();
                String tipoestudios = t.getTipoestudios();
                String cualidades = t.getCualidades();

                String sql = "INSERT INTO trabajo(nombre, apellido, email, nif, telefono,sexo,edad,carnet,estudios,tipoestudios,cualidades) VALUES('" + nombre + "', '" + apellido + "', '" + email + "', '" + nif + "','" + telefono + "','" + sexo + "','" + edad + "','" + carnet + "','" + estudios + "','" + tipoestudios + "','" + cualidades + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(TrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
                p = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public ArrayList<Trabajo> todosCandidatos() {
        ArrayList<Trabajo> todosCandidatos = new ArrayList<Trabajo>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM usuario");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idTrabajo");
                    String nombre = prs.getString("nombre");
                    String apellido = prs.getString("apellido");
                    String email = prs.getString("email");
                    String nif = prs.getString("nif");
                    String telefono = prs.getString("telefono");
                    String sexo = prs.getString("sexo");
                    String estudios = prs.getString("estudios");
                    int edad = prs.getInt("edad");
                    int carnet = prs.getInt("carnet");
                    String tipoestudios = prs.getString("tipoestudios");
                    String cualidades = prs.getString("cualidades");
                    Trabajo trab = new Trabajo(id, nombre, apellido, email, nif, telefono, sexo, estudios, tipoestudios, edad, carnet, cualidades);
                    todosCandidatos.add(trab);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(TrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosCandidatos;
    }
}
