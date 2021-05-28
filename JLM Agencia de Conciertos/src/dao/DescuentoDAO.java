/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import entidades.Descuento;
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
public class DescuentoDAO {
    
    private Descuento p;
    private static Connection conn;

    public DescuentoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public DescuentoDAO(Descuento des) {
        this.p = des;
        conn = ConexionBD.establecerConexion();
    }
    
    
    
    
    public static ArrayList<Descuento> buscarDescuentoByIdUsuario(int idUsuariodado) {
        ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM descuento WHERE idusuario = "+idUsuariodado);
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idDescuento");
                    Date fechavalidez = prs.getDate("fechavalidez");
                    String codigo = prs.getString("codigo");
                    Double cantidad = prs.getDouble("cantidad");
                    int usado = prs.getInt("usado");
                    int idUsuario = prs.getInt("idUsuario");
                    Descuento descuento = new Descuento(id, codigo,fechavalidez, cantidad, usado, idUsuario);
                    descuentos.add(descuento);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(DescuentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DescuentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descuentos;
    }

}
