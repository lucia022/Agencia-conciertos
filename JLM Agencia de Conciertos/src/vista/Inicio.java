/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import varios.TextPrompt;
import entidades.Usuario;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author usuario
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio_Registro
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt usuario = new TextPrompt("Usuario", jTextField_Usuario);
        TextPrompt contraseña = new TextPrompt("Contraseña", jPasswordField_Contraseña);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_Usuario = new javax.swing.JTextField();
        jButton2_iniciar_sesion = new javax.swing.JButton();
        jLabel_Usuario = new javax.swing.JLabel();
        jLabel_Contraseña = new javax.swing.JLabel();
        jPasswordField_Contraseña = new javax.swing.JPasswordField();
        jLabel_Registrarse = new javax.swing.JLabel();
        jButton_Forgot_Password = new javax.swing.JButton();
        jButton_Registrarse = new javax.swing.JButton();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_Candado_Inicio = new javax.swing.JLabel();
        jButton_Salir = new javax.swing.JButton();
        jLabel_FondoInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 50));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_Usuario.setBackground(new java.awt.Color(0, 0, 0));
        jTextField_Usuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_UsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 200, 32));

        jButton2_iniciar_sesion.setBackground(new java.awt.Color(255, 51, 51));
        jButton2_iniciar_sesion.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        jButton2_iniciar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        jButton2_iniciar_sesion.setText("Iniciar Sesión");
        jButton2_iniciar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2_iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_iniciar_sesionActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 160, 40));

        jLabel_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuario_Inicio.png"))); // NOI18N
        jPanel1.add(jLabel_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        jLabel_Contraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Contraseña_Inicio.png"))); // NOI18N
        jPanel1.add(jLabel_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jPasswordField_Contraseña.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField_Contraseña.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPasswordField_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_Contraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPasswordField_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_ContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 200, 32));

        jLabel_Registrarse.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel_Registrarse.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Registrarse.setText("En caso de querer registrarte pincha ");
        jPanel1.add(jLabel_Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jButton_Forgot_Password.setFont(new java.awt.Font("Cambria Math", 3, 14)); // NOI18N
        jButton_Forgot_Password.setText("Olvidé la Contraseña");
        jButton_Forgot_Password.setContentAreaFilled(false);
        jButton_Forgot_Password.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Forgot_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Forgot_PasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Forgot_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, 30));

        jButton_Registrarse.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Registrarse.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 20)); // NOI18N
        jButton_Registrarse.setForeground(new java.awt.Color(255, 51, 51));
        jButton_Registrarse.setText("AQUÍ");
        jButton_Registrarse.setToolTipText("");
        jButton_Registrarse.setContentAreaFilled(false);
        jButton_Registrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, 40));

        jLabel_Logo.setFont(new java.awt.Font("Mistral", 1, 140)); // NOI18N
        jLabel_Logo.setText("JLM");
        jPanel1.add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel_Candado_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Candado_Inicio.png"))); // NOI18N
        jPanel1.add(jLabel_Candado_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jButton_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cruz.png"))); // NOI18N
        jButton_Salir.setContentAreaFilled(false);
        jButton_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 60, 50));

        jLabel_FondoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_Inicio.jpg"))); // NOI18N
        jPanel1.add(jLabel_FondoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-280, -100, 830, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2_iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_iniciar_sesionActionPerformed

        String usuario = this.jTextField_Usuario.getText();
        String contraseña = "";
        char[] paswrd = this.jPasswordField_Contraseña.getPassword();
        for (int i = 0; i < paswrd.length; i++) {
            contraseña += paswrd[i];
        }
        if ((this.jTextField_Usuario.getText().isEmpty()) || (contraseña.isEmpty())) {
            if ((this.jTextField_Usuario.getText().isEmpty()) && (contraseña.isEmpty())) {
                JOptionPane.showConfirmDialog(this, "Los campos no pueden quedar vacios", "Información", JOptionPane.CLOSED_OPTION);
            } else {
                if (this.jTextField_Usuario.getText().isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Usuario no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (contraseña.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Contraseña no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
            }
        } else {
            Boolean inicioVerdadero = Usuario.buscarIniciodeSesion(usuario, contraseña);
            if (!inicioVerdadero) {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos(intentelo de nuevo)", "Error", JOptionPane.ERROR_MESSAGE);
                this.jTextField_Usuario.setText("");
            } else {
                Boolean esAdministrador = Usuario.esAdministrador(usuario);
                if (esAdministrador) {
              
                    this.dispose();
                } else {
                    Usuario usuario1 = new Usuario();
                    usuario1 = Usuario.buscarUsuarioporNIF(usuario);
                    MenuPrincipal menu = new MenuPrincipal(usuario1);
                    menu.setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jButton2_iniciar_sesionActionPerformed

    private void jTextField_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_UsuarioActionPerformed

    private void jPasswordField_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField_ContraseñaActionPerformed

    private void jButton_Forgot_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Forgot_PasswordActionPerformed
        JOptionPane.showConfirmDialog(this, "Para intentar recuperar la contraseña rellene los siguientes campos", "Información", JOptionPane.CLOSED_OPTION);
        OlvidoContraseña olvidolacontraseña = new OlvidoContraseña();
        olvidolacontraseña.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_Forgot_PasswordActionPerformed

    private void jButton_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarseActionPerformed
        RegistroUsuario registrarusuario = new RegistroUsuario();
        registrarusuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_RegistrarseActionPerformed

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_iniciar_sesion;
    private javax.swing.JButton jButton_Forgot_Password;
    private javax.swing.JButton jButton_Registrarse;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel_Candado_Inicio;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_FondoInicio;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Registrarse;
    private javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_Contraseña;
    private javax.swing.JTextField jTextField_Usuario;
    // End of variables declaration//GEN-END:variables
}
