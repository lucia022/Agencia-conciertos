/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.BancarioDAO;
import dao.DescuentoDAO;
import dao.DireccionDAO;
import dao.TrabajoDAO;
import dao.UsuarioDAO;
import entidades.Bancario;
import entidades.Descuento;
import entidades.Direccion;
import entidades.Trabajo;
import entidades.Usuario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.URISyntax;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import varios.TextPrompt;

/**
 *
 * @author usuario
 */
public class MenuPrincipal extends javax.swing.JFrame {

    Usuario usuario;
    JFileChooser chooser;
    DefaultTableModel modelodescuento;
      DefaultTableModel modelousuario;


    /**
     * Creates new form NewJFrame
     */
    public MenuPrincipal(Usuario usuario) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.usuario = usuario;
        
        //this.jLabel_Tu_Nombre.setText(usuario.getNombre().toUpperCase()+" "+usuario.getApellido().toUpperCase());
        this.jLabel_Tu_Nombre.setText(usuario.getNombre() + " " + usuario.getApellido());
        this.jTextField_Trabaja_aqui_Nombre.setText(usuario.getNombre());
        this.jTextField_Trabaja_aqui_Apellido.setText(usuario.getApellido());
        this.jTextField_Trabaja_aqui_Email.setText(usuario.getEmail());
        this.jTextField_Trabaja_aqui_NIF.setText(usuario.getNif());
        this.jTextField_Tu_Usuario_Nombre.setText(usuario.getNombre());
        this.jTextField_Tu_Usuario_Apellido.setText(usuario.getApellido());
        this.jTextField_Tu_Usuario_Email.setText(usuario.getEmail());
        this.jTextField_Tu_Usuario_NIF.setText(usuario.getNif());
        this.jPanel_Inicio.setVisible(true);
        this.jPanel_Inicio.setEnabled(true);
        this.jPanel_Trabaja_Aqui.setVisible(false);
        this.jPanel_Trabaja_Aqui.setEnabled(false);
        this.jPanel_Mi_Usuario.setVisible(false);
        this.jPanel_Mi_Usuario.setEnabled(false);

        this.jLabel_Tu_Usuario_NombreyApellido1.setText(usuario.getNombre().toUpperCase() + " " + usuario.getApellido().toUpperCase());
        this.jLabel_Tu_Usuario_Nif1.setText(usuario.getNif());
        this.jLabel_Tu_Usuario_Email1.setText(usuario.getEmail());
        this.jLabel_Tu_Usuario_Contraseña1.setText(usuario.getContraseña());

        DireccionDAO d = new DireccionDAO();
        Direccion direccion = new Direccion();
        direccion = d.buscarDireccionById(usuario.getIdDireccion());
        this.jLabel_Tu_Usuario_Calle1.setText(direccion.getCalle());
        this.jLabel_Tu_Usuario_Ciudad1.setText(direccion.getCiudad());
        this.jLabel_Tu_Usuario_Codigo_Postal1.setText(direccion.getCodigoPostal());
        this.jLabel_Tu_Usuario_Municipio1.setText(direccion.getMunicipio());
        this.jLabel_Tu_Usuario_País1.setText(direccion.getPais());
        this.jTextField_Tu_Usuario_Calle.setText(direccion.getCalle());
        this.jTextField_Tu_Usuario_Ciudad.setText(direccion.getCiudad());
        this.jTextField_Tu_Usuario_Codigo_Postal.setText(direccion.getCodigoPostal());
        this.jTextField_Tu_Usuario_Municipio.setText(direccion.getMunicipio());
        this.jTextField_Tu_Usuario_País.setText(direccion.getPais());

        BancarioDAO b = new BancarioDAO();
        Bancario bancario = new Bancario();
        bancario = b.buscarBancarioById(usuario.getIdBancario());
        this.jLabel_Tu_Usuario_Tarjeta1.setText(bancario.getNumtarjeta());
        this.jLabel_Tu_Usuario_Codigo1.setText(bancario.getCodigotarjeta());
        this.jLabel_Tu_Usuario_Titular1.setText(bancario.getTitular());
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setText(bancario.getCodigotarjeta());
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setText(bancario.getTitular());
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setText(bancario.getNumtarjeta());

        TextPrompt tipo = new TextPrompt("Ej-Peluquería", jTextField_Tipo_Trabaja_aqui_Estudios);
        this.jTextField_Tu_Usuario_Nombre.setVisible(false);
        this.jTextField_Tu_Usuario_Nombre.setEnabled(false);
        this.jTextField_Tu_Usuario_Apellido.setVisible(false);
        this.jTextField_Tu_Usuario_Apellido.setEnabled(false);
        this.jTextField_Tu_Usuario_Email.setVisible(false);
        this.jTextField_Tu_Usuario_Email.setEnabled(false);
        this.jTextField_Tu_Usuario_NIF.setVisible(false);
        this.jTextField_Tu_Usuario_NIF.setEnabled(false);
        this.jTextField_Tu_Usuario_Calle.setVisible(false);
        this.jTextField_Tu_Usuario_Calle.setEnabled(false);
        this.jTextField_Tu_Usuario_Ciudad.setVisible(false);
        this.jTextField_Tu_Usuario_Ciudad.setEnabled(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setVisible(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setEnabled(false);
        this.jTextField_Tu_Usuario_País.setVisible(false);
        this.jTextField_Tu_Usuario_País.setEnabled(false);
        this.jTextField_Tu_Usuario_Municipio.setVisible(false);
        this.jTextField_Tu_Usuario_Municipio.setEnabled(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setEnabled(false);

        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setEnabled(false);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setEnabled(false);

        this.jCheckBox_Tu_Usuario_Editar1.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar1.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar2.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar2.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar3.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar3.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar4.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar4.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar5.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar5.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar6.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar6.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar7.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar7.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar8.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar8.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar9.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar9.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar10.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar10.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar11.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar11.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_Carnet = new javax.swing.ButtonGroup();
        buttonGroup_Sexo = new javax.swing.ButtonGroup();
        jDialog_Tu_Usuario_Descuentos = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Mis_Descuentos = new javax.swing.JTable();
        jDialog_Practica = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel_Arriba = new javax.swing.JPanel();
        jLabel_Empresa = new javax.swing.JLabel();
        jPanel_Izquierda = new javax.swing.JPanel();
        jButton_Inicio = new javax.swing.JButton();
        jButton_Ver_Conciertos = new javax.swing.JButton();
        jButton_Mi_Usuario = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        jButton_Trabaja_Aqui = new javax.swing.JButton();
        jButton_Cambiar_Usuario = new javax.swing.JButton();
        jLabel_Tu_Nombre = new javax.swing.JLabel();
        jPanel_Mi_Usuario = new javax.swing.JPanel();
        jTextField_Tu_Usuario_Municipio = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Codigo_Postal = new javax.swing.JTextField();
        jTextField_Tu_Usuario_País = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Nombre = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Ciudad = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Apellido = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Email = new javax.swing.JTextField();
        jTextField_Tu_Usuario_NIF = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Titulat_Tarjeta = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Numero_Tarjeta = new javax.swing.JTextField();
        jTextField_Tu_Usuario_CVV_Tarjeta = new javax.swing.JTextField();
        jTextField_Tu_Usuario_Calle = new javax.swing.JTextField();
        jCheckBox_Tu_Usuario_Editar1 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar2 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar3 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar4 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar5 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar6 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar7 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar8 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar9 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar10 = new javax.swing.JCheckBox();
        jCheckBox_Tu_Usuario_Editar11 = new javax.swing.JCheckBox();
        jButton_Tu_Usuario_Cambiar_Contraseña = new javax.swing.JButton();
        jLabel_Tu_Usuario_NombreyApellido1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Email1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Datos_Personales = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Direccion = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Datos_Bancarios = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Nif1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_NombreyApellido = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Contraseña = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Email = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Nif = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Contraseña1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Municipio = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Codigo_Postal = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Ciudad = new javax.swing.JLabel();
        jLabel_Tu_Usuario_País = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Calle = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Calle1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Municipio1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Codigo_Postal1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_País1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Ciudad1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Titular = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Titular1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Tarjeta1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Codigo1 = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Tarjeta = new javax.swing.JLabel();
        jLabel_Tu_Usuario_Codigo = new javax.swing.JLabel();
        jButton_Tu_Usuario_Aceptar_Editar_Datos = new javax.swing.JButton();
        jButton_Tu_Usuario_Cancelar_Editar_Datos = new javax.swing.JButton();
        jButton_Tu_Usuario_Editar_Datos = new javax.swing.JButton();
        jButton_Tu_Usuario_Eliminar_Usuario = new javax.swing.JButton();
        jButton_Tu_Usuario_Reservas = new javax.swing.JButton();
        jButton_Tu_Usuario_Lo_Que_Pide_La_Practica = new javax.swing.JButton();
        jButton_Tu_Usuario_Mis_Descuentos = new javax.swing.JButton();
        jPanel_Trabaja_Aqui = new javax.swing.JPanel();
        jLabel_Trabaja_aqui_Titulo = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Nombre = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Apellido = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Email = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Nif = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Telefono = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Sexo = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Edad = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Carnet = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Estudios = new javax.swing.JLabel();
        jLabel_Tipo_Trabaja_aqui_Estudios = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_Cualidades = new javax.swing.JLabel();
        jLabel_Trabaja_aqui_CV = new javax.swing.JLabel();
        jTextField_Trabaja_aqui_Nombre = new javax.swing.JTextField();
        jTextField_Trabaja_aqui_Apellido = new javax.swing.JTextField();
        jTextField_Trabaja_aqui_Email = new javax.swing.JTextField();
        jTextField_Trabaja_aqui_NIF = new javax.swing.JTextField();
        jTextField_Tipo_Trabaja_aqui_Estudios = new javax.swing.JTextField();
        jTextField_Trabaja_aqui_Telefono = new javax.swing.JTextField();
        jCheckBox_Trabaja_aqui_Editar_Nombre = new javax.swing.JCheckBox();
        jCheckBox_Trabaja_aqui_Editar_Apellido = new javax.swing.JCheckBox();
        jCheckBox_Trabaja_aqui_Editar_Email = new javax.swing.JCheckBox();
        jCheckBox_Trabaja_aqui_Editar_NIF = new javax.swing.JCheckBox();
        jRadioButtonTrabaja_aqui_Otro = new javax.swing.JRadioButton();
        jRadioButtonTrabaja_aqui_Masculino = new javax.swing.JRadioButton();
        jRadioButtonTrabaja_aqui_Femenino = new javax.swing.JRadioButton();
        jRadioButton_Trabaja_aqui_NoCarnet = new javax.swing.JRadioButton();
        jRadioButton_Trabaja_aqui_SiCarnet = new javax.swing.JRadioButton();
        jSpinner_Trabaja_aqui_Edad = new javax.swing.JSpinner();
        jScrollPaneTrabaja_aqui_Cualidades = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox_Trabaja_aqui_Estudios = new javax.swing.JComboBox<>();
        jButton_Trabaja_aqui_Curriculum = new javax.swing.JButton();
        jCheckBox_Trabaja_aqui_Permiso = new javax.swing.JCheckBox();
        jButton_Trabaja_aqui_Enviar = new javax.swing.JButton();
        jPanel_Inicio = new javax.swing.JPanel();
        jLabel_Inicio_linea1 = new javax.swing.JLabel();
        jLabel_Inicio_linea2 = new javax.swing.JLabel();
        jLabel_Inicio_linea3 = new javax.swing.JLabel();
        jLabel_Inicio_linea4 = new javax.swing.JLabel();
        jLabel_Inicio_Empresa = new javax.swing.JLabel();
        jLabel_Inicio_linea5 = new javax.swing.JLabel();
        jLabel_Inicio_linea6 = new javax.swing.JLabel();
        jLabel_Inicio_linea7 = new javax.swing.JLabel();
        jButton_Inicio_Insta = new javax.swing.JButton();
        jButton_Inicio_YouTube = new javax.swing.JButton();
        jButton_Inicio_Twitter = new javax.swing.JButton();
        jButton_Inicio_Correo = new javax.swing.JButton();

        jTable_Mis_Descuentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_Mis_Descuentos);

        javax.swing.GroupLayout jDialog_Tu_Usuario_DescuentosLayout = new javax.swing.GroupLayout(jDialog_Tu_Usuario_Descuentos.getContentPane());
        jDialog_Tu_Usuario_Descuentos.getContentPane().setLayout(jDialog_Tu_Usuario_DescuentosLayout);
        jDialog_Tu_Usuario_DescuentosLayout.setHorizontalGroup(
            jDialog_Tu_Usuario_DescuentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        jDialog_Tu_Usuario_DescuentosLayout.setVerticalGroup(
            jDialog_Tu_Usuario_DescuentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        javax.swing.GroupLayout jDialog_PracticaLayout = new javax.swing.GroupLayout(jDialog_Practica.getContentPane());
        jDialog_Practica.getContentPane().setLayout(jDialog_PracticaLayout);
        jDialog_PracticaLayout.setHorizontalGroup(
            jDialog_PracticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jDialog_PracticaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addGap(100, 100, 100)
                .addComponent(jButton3)
                .addGap(74, 74, 74)
                .addComponent(jButton4)
                .addGap(80, 80, 80)
                .addComponent(jButton5)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jDialog_PracticaLayout.setVerticalGroup(
            jDialog_PracticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_PracticaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jDialog_PracticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(34, 34, 34))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Arriba.setBackground(new java.awt.Color(53, 74, 99));

        jLabel_Empresa.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel_Empresa.setText("JML Conciertos");

        javax.swing.GroupLayout jPanel_ArribaLayout = new javax.swing.GroupLayout(jPanel_Arriba);
        jPanel_Arriba.setLayout(jPanel_ArribaLayout);
        jPanel_ArribaLayout.setHorizontalGroup(
            jPanel_ArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ArribaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_Empresa)
                .addContainerGap(686, Short.MAX_VALUE))
        );
        jPanel_ArribaLayout.setVerticalGroup(
            jPanel_ArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ArribaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel_Arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 50));

        jPanel_Izquierda.setBackground(new java.awt.Color(34, 49, 68));
        jPanel_Izquierda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Inicio.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jButton_Inicio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Inicio.setText("INICIO");
        jButton_Inicio.setContentAreaFilled(false);
        jButton_Inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InicioActionPerformed(evt);
            }
        });
        jPanel_Izquierda.add(jButton_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 281, -1, -1));

        jButton_Ver_Conciertos.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jButton_Ver_Conciertos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Ver_Conciertos.setText("VER CONCIERTOS");
        jButton_Ver_Conciertos.setContentAreaFilled(false);
        jButton_Ver_Conciertos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Izquierda.add(jButton_Ver_Conciertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 338, -1, -1));

        jButton_Mi_Usuario.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jButton_Mi_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Mi_Usuario.setText("MI USUARIO");
        jButton_Mi_Usuario.setContentAreaFilled(false);
        jButton_Mi_Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Mi_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Mi_UsuarioActionPerformed(evt);
            }
        });
        jPanel_Izquierda.add(jButton_Mi_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 395, -1, -1));

        jButton_Salir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_Salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salir.png"))); // NOI18N
        jButton_Salir.setContentAreaFilled(false);
        jButton_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });
        jPanel_Izquierda.add(jButton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 48, 44));

        jButton_Trabaja_Aqui.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jButton_Trabaja_Aqui.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Trabaja_Aqui.setText("TRABAJA CON NOSOTROS");
        jButton_Trabaja_Aqui.setContentAreaFilled(false);
        jButton_Trabaja_Aqui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Trabaja_Aqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Trabaja_AquiActionPerformed(evt);
            }
        });
        jPanel_Izquierda.add(jButton_Trabaja_Aqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 452, -1, -1));

        jButton_Cambiar_Usuario.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton_Cambiar_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cambiar_Usuario.setText("Cambiar de Usuario");
        jButton_Cambiar_Usuario.setContentAreaFilled(false);
        jButton_Cambiar_Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cambiar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cambiar_UsuarioActionPerformed(evt);
            }
        });
        jPanel_Izquierda.add(jButton_Cambiar_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, -1, -1));

        jLabel_Tu_Nombre.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel_Tu_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Tu_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_Izquierda.add(jLabel_Tu_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 229, 348, 34));

        jPanel1.add(jPanel_Izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 560));

        jPanel_Mi_Usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_Tu_Usuario_Municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Tu_Usuario_MunicipioActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Municipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 140, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Codigo_Postal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 140, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_País, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 140, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 80, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 140, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 90, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 170, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_NIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 170, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Titulat_Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 150, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Numero_Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 150, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_CVV_Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 150, 30));
        jPanel_Mi_Usuario.add(jTextField_Tu_Usuario_Calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 140, 30));

        jCheckBox_Tu_Usuario_Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar1ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, -1, 30));

        jCheckBox_Tu_Usuario_Editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar2ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, -1, 30));

        jCheckBox_Tu_Usuario_Editar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar3ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, 30));

        jCheckBox_Tu_Usuario_Editar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar4ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, 30));

        jCheckBox_Tu_Usuario_Editar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar5ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, 30));

        jCheckBox_Tu_Usuario_Editar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar6ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, 30));

        jCheckBox_Tu_Usuario_Editar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar7ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 30));

        jCheckBox_Tu_Usuario_Editar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar8ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, 30));

        jCheckBox_Tu_Usuario_Editar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar9ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, 30));

        jCheckBox_Tu_Usuario_Editar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar10ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, 30));

        jCheckBox_Tu_Usuario_Editar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Tu_Usuario_Editar11ActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jCheckBox_Tu_Usuario_Editar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, 30));

        jButton_Tu_Usuario_Cambiar_Contraseña.setText("Cambiar");
        jButton_Tu_Usuario_Cambiar_Contraseña.setContentAreaFilled(false);
        jButton_Tu_Usuario_Cambiar_Contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Tu_Usuario_Cambiar_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Cambiar_ContraseñaActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Cambiar_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, 30));

        jLabel_Tu_Usuario_NombreyApellido1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_NombreyApellido1.setText("MARIO ARAUJO");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_NombreyApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 170, 34));

        jLabel_Tu_Usuario_Email1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Email1.setText("mario@gmail.com   ");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 170, 34));

        jLabel_Tu_Usuario_Datos_Personales.setFont(new java.awt.Font("Engravers MT", 1, 21)); // NOI18N
        jLabel_Tu_Usuario_Datos_Personales.setText("Datos Personales");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Datos_Personales, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, 35));

        jLabel_Tu_Usuario_Direccion.setFont(new java.awt.Font("Engravers MT", 1, 21)); // NOI18N
        jLabel_Tu_Usuario_Direccion.setText("Dirección");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel_Tu_Usuario_Datos_Bancarios.setFont(new java.awt.Font("Engravers MT", 1, 21)); // NOI18N
        jLabel_Tu_Usuario_Datos_Bancarios.setText("Datos Bancarios");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Datos_Bancarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jLabel_Tu_Usuario_Nif1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Nif1.setText("72261166L");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Nif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 170, 34));

        jLabel_Tu_Usuario_NombreyApellido.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_NombreyApellido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_NombreyApellido.setText("Nombre y Apellido:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_NombreyApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 150, 34));

        jLabel_Tu_Usuario_Contraseña.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Contraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Contraseña.setText("Contraseña:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 130, 34));

        jLabel_Tu_Usuario_Email.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Email.setText("Email:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 130, 34));

        jLabel_Tu_Usuario_Nif.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Nif.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Nif.setText("NIF(Usuario):");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Nif, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 130, 34));

        jLabel_Tu_Usuario_Contraseña1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Contraseña1.setText("aaaaa");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 170, 34));

        jLabel_Tu_Usuario_Municipio.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Municipio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Municipio.setText("Municipio:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Municipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 34));

        jLabel_Tu_Usuario_Codigo_Postal.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Codigo_Postal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Codigo_Postal.setText("Código Postal:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Codigo_Postal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 110, 34));

        jLabel_Tu_Usuario_Ciudad.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Ciudad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Ciudad.setText("Ciudad:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 60, 34));

        jLabel_Tu_Usuario_País.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_País.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_País.setText("País:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_País, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 40, 34));

        jLabel_Tu_Usuario_Calle.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Calle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Calle.setText("Calle:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 50, 34));

        jLabel_Tu_Usuario_Calle1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Calle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Calle1.setText("aaa");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Calle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 160, 34));

        jLabel_Tu_Usuario_Municipio1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Municipio1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Municipio1.setText("aaa");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Municipio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 160, 34));

        jLabel_Tu_Usuario_Codigo_Postal1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Codigo_Postal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Codigo_Postal1.setText("aaa");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Codigo_Postal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 150, 34));

        jLabel_Tu_Usuario_País1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_País1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_País1.setText("aaa");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_País1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 160, 34));

        jLabel_Tu_Usuario_Ciudad1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Ciudad1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Ciudad1.setText("aaa");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Ciudad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 150, 34));

        jLabel_Tu_Usuario_Titular.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Titular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Titular.setText("Nombre del titular:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Titular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 150, 34));

        jLabel_Tu_Usuario_Titular1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Titular1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Titular1.setText("MARIO ARAUJO");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Titular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 160, 34));

        jLabel_Tu_Usuario_Tarjeta1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Tarjeta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Tarjeta1.setText("1234-56789-3456-7654");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Tarjeta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 170, 34));

        jLabel_Tu_Usuario_Codigo1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel_Tu_Usuario_Codigo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Tu_Usuario_Codigo1.setText("345");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 170, 34));

        jLabel_Tu_Usuario_Tarjeta.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Tarjeta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Tarjeta.setText("Múmero de la tarjeta:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 170, 34));

        jLabel_Tu_Usuario_Codigo.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jLabel_Tu_Usuario_Codigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tu_Usuario_Codigo.setText("CVV:");
        jPanel_Mi_Usuario.add(jLabel_Tu_Usuario_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 130, 34));

        jButton_Tu_Usuario_Aceptar_Editar_Datos.setBackground(new java.awt.Color(35, 49, 68));
        jButton_Tu_Usuario_Aceptar_Editar_Datos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_Tu_Usuario_Aceptar_Editar_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Aceptar_Editar_Datos.setText("Aceptar Datos");
        jButton_Tu_Usuario_Aceptar_Editar_Datos.setToolTipText("");
        jButton_Tu_Usuario_Aceptar_Editar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Aceptar_Editar_DatosActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Aceptar_Editar_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 140, 50));

        jButton_Tu_Usuario_Cancelar_Editar_Datos.setBackground(new java.awt.Color(35, 49, 68));
        jButton_Tu_Usuario_Cancelar_Editar_Datos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_Tu_Usuario_Cancelar_Editar_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Cancelar_Editar_Datos.setText("Cancelar Datos");
        jButton_Tu_Usuario_Cancelar_Editar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Cancelar_Editar_DatosActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Cancelar_Editar_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 160, 50));

        jButton_Tu_Usuario_Editar_Datos.setBackground(new java.awt.Color(35, 49, 68));
        jButton_Tu_Usuario_Editar_Datos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_Tu_Usuario_Editar_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Editar_Datos.setText("Editar Datos");
        jButton_Tu_Usuario_Editar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Editar_DatosActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Editar_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 140, 50));

        jButton_Tu_Usuario_Eliminar_Usuario.setBackground(new java.awt.Color(35, 49, 68));
        jButton_Tu_Usuario_Eliminar_Usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_Tu_Usuario_Eliminar_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Eliminar_Usuario.setText("Eliminar Usuario");
        jButton_Tu_Usuario_Eliminar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Eliminar_UsuarioActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Eliminar_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 160, 50));

        jButton_Tu_Usuario_Reservas.setBackground(new java.awt.Color(34, 48, 66));
        jButton_Tu_Usuario_Reservas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_Tu_Usuario_Reservas.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Reservas.setText("jButton1");
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Reservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 170, 50));

        jButton_Tu_Usuario_Lo_Que_Pide_La_Practica.setBackground(new java.awt.Color(34, 48, 66));
        jButton_Tu_Usuario_Lo_Que_Pide_La_Practica.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_Tu_Usuario_Lo_Que_Pide_La_Practica.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Lo_Que_Pide_La_Practica.setText("Practica");
        jButton_Tu_Usuario_Lo_Que_Pide_La_Practica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Lo_Que_Pide_La_PracticaActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Lo_Que_Pide_La_Practica, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 170, 50));

        jButton_Tu_Usuario_Mis_Descuentos.setBackground(new java.awt.Color(34, 48, 66));
        jButton_Tu_Usuario_Mis_Descuentos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_Tu_Usuario_Mis_Descuentos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Tu_Usuario_Mis_Descuentos.setText("Mis Descuentos");
        jButton_Tu_Usuario_Mis_Descuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tu_Usuario_Mis_DescuentosActionPerformed(evt);
            }
        });
        jPanel_Mi_Usuario.add(jButton_Tu_Usuario_Mis_Descuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 170, 50));

        jPanel1.add(jPanel_Mi_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 650, 510));

        jPanel_Trabaja_Aqui.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Trabaja_aqui_Titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel_Trabaja_aqui_Titulo.setText("TRABAJA AQUÍ");
        jLabel_Trabaja_aqui_Titulo.setFocusable(false);
        jLabel_Trabaja_aqui_Titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 270, 44));

        jLabel_Trabaja_aqui_Nombre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_Trabaja_aqui_Nombre.setText("Nombre");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel_Trabaja_aqui_Apellido.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_Trabaja_aqui_Apellido.setText("Apellido");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel_Trabaja_aqui_Email.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_Trabaja_aqui_Email.setText("Email");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel_Trabaja_aqui_Nif.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_Trabaja_aqui_Nif.setText("NIF");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Nif, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 40, -1));

        jLabel_Trabaja_aqui_Telefono.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_Trabaja_aqui_Telefono.setText("Teléfono");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel_Trabaja_aqui_Sexo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Trabaja_aqui_Sexo.setText("Sexo");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 314, -1, 30));

        jLabel_Trabaja_aqui_Edad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Trabaja_aqui_Edad.setText("Edad");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel_Trabaja_aqui_Carnet.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Trabaja_aqui_Carnet.setText("Carnet Condicir");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Carnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel_Trabaja_aqui_Estudios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Trabaja_aqui_Estudios.setText("Estudios maximos");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 170, -1));

        jLabel_Tipo_Trabaja_aqui_Estudios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel_Tipo_Trabaja_aqui_Estudios.setText("Tipo");
        jPanel_Trabaja_Aqui.add(jLabel_Tipo_Trabaja_aqui_Estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        jLabel_Trabaja_aqui_Cualidades.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Trabaja_aqui_Cualidades.setText("Cuentanos algo sobre ti:");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_Cualidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jLabel_Trabaja_aqui_CV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Trabaja_aqui_CV.setText("Añada su CV aquí:");
        jPanel_Trabaja_Aqui.add(jLabel_Trabaja_aqui_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));

        jTextField_Trabaja_aqui_Nombre.setBackground(new java.awt.Color(0, 102, 102));
        jTextField_Trabaja_aqui_Nombre.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jTextField_Trabaja_aqui_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Trabaja_aqui_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Trabaja_aqui_Nombre.setEnabled(false);
        jTextField_Trabaja_aqui_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Trabaja_aqui_NombreActionPerformed(evt);
            }
        });
        jTextField_Trabaja_aqui_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Trabaja_aqui_NombreKeyReleased(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jTextField_Trabaja_aqui_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 160, 30));

        jTextField_Trabaja_aqui_Apellido.setBackground(new java.awt.Color(0, 102, 102));
        jTextField_Trabaja_aqui_Apellido.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jTextField_Trabaja_aqui_Apellido.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Trabaja_aqui_Apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Trabaja_aqui_Apellido.setEnabled(false);
        jTextField_Trabaja_aqui_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Trabaja_aqui_ApellidoActionPerformed(evt);
            }
        });
        jTextField_Trabaja_aqui_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Trabaja_aqui_ApellidoKeyReleased(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jTextField_Trabaja_aqui_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 160, 30));

        jTextField_Trabaja_aqui_Email.setBackground(new java.awt.Color(0, 102, 102));
        jTextField_Trabaja_aqui_Email.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jTextField_Trabaja_aqui_Email.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Trabaja_aqui_Email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Trabaja_aqui_Email.setEnabled(false);
        jTextField_Trabaja_aqui_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Trabaja_aqui_EmailActionPerformed(evt);
            }
        });
        jTextField_Trabaja_aqui_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Trabaja_aqui_EmailKeyReleased(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jTextField_Trabaja_aqui_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 160, 30));

        jTextField_Trabaja_aqui_NIF.setBackground(new java.awt.Color(0, 102, 102));
        jTextField_Trabaja_aqui_NIF.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jTextField_Trabaja_aqui_NIF.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Trabaja_aqui_NIF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Trabaja_aqui_NIF.setEnabled(false);
        jTextField_Trabaja_aqui_NIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Trabaja_aqui_NIFActionPerformed(evt);
            }
        });
        jTextField_Trabaja_aqui_NIF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Trabaja_aqui_NIFKeyReleased(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jTextField_Trabaja_aqui_NIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 160, 30));

        jTextField_Tipo_Trabaja_aqui_Estudios.setBackground(new java.awt.Color(0, 102, 102));
        jTextField_Tipo_Trabaja_aqui_Estudios.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jTextField_Tipo_Trabaja_aqui_Estudios.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Tipo_Trabaja_aqui_Estudios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Tipo_Trabaja_aqui_Estudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Tipo_Trabaja_aqui_EstudiosActionPerformed(evt);
            }
        });
        jTextField_Tipo_Trabaja_aqui_Estudios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Tipo_Trabaja_aqui_EstudiosKeyReleased(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jTextField_Tipo_Trabaja_aqui_Estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 170, 30));

        jTextField_Trabaja_aqui_Telefono.setBackground(new java.awt.Color(0, 102, 102));
        jTextField_Trabaja_aqui_Telefono.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jTextField_Trabaja_aqui_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Trabaja_aqui_Telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_Trabaja_aqui_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Trabaja_aqui_TelefonoActionPerformed(evt);
            }
        });
        jTextField_Trabaja_aqui_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Trabaja_aqui_TelefonoKeyReleased(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jTextField_Trabaja_aqui_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 160, 30));

        jCheckBox_Trabaja_aqui_Editar_Nombre.setText("Editar");
        jCheckBox_Trabaja_aqui_Editar_Nombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_Trabaja_aqui_Editar_NombreStateChanged(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jCheckBox_Trabaja_aqui_Editar_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, 30));

        jCheckBox_Trabaja_aqui_Editar_Apellido.setText("Editar");
        jCheckBox_Trabaja_aqui_Editar_Apellido.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_Trabaja_aqui_Editar_ApellidoStateChanged(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jCheckBox_Trabaja_aqui_Editar_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, 30));

        jCheckBox_Trabaja_aqui_Editar_Email.setText("Editar");
        jCheckBox_Trabaja_aqui_Editar_Email.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_Trabaja_aqui_Editar_EmailStateChanged(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jCheckBox_Trabaja_aqui_Editar_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, 30));

        jCheckBox_Trabaja_aqui_Editar_NIF.setText("Editar");
        jCheckBox_Trabaja_aqui_Editar_NIF.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_Trabaja_aqui_Editar_NIFStateChanged(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jCheckBox_Trabaja_aqui_Editar_NIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, 30));

        buttonGroup_Sexo.add(jRadioButtonTrabaja_aqui_Otro);
        jRadioButtonTrabaja_aqui_Otro.setText("Otro");
        jPanel_Trabaja_Aqui.add(jRadioButtonTrabaja_aqui_Otro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        buttonGroup_Sexo.add(jRadioButtonTrabaja_aqui_Masculino);
        jRadioButtonTrabaja_aqui_Masculino.setText("Masculino");
        jPanel_Trabaja_Aqui.add(jRadioButtonTrabaja_aqui_Masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        buttonGroup_Sexo.add(jRadioButtonTrabaja_aqui_Femenino);
        jRadioButtonTrabaja_aqui_Femenino.setSelected(true);
        jRadioButtonTrabaja_aqui_Femenino.setText("Femenino");
        jPanel_Trabaja_Aqui.add(jRadioButtonTrabaja_aqui_Femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        buttonGroup_Carnet.add(jRadioButton_Trabaja_aqui_NoCarnet);
        jRadioButton_Trabaja_aqui_NoCarnet.setSelected(true);
        jRadioButton_Trabaja_aqui_NoCarnet.setText("No");
        jPanel_Trabaja_Aqui.add(jRadioButton_Trabaja_aqui_NoCarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        buttonGroup_Carnet.add(jRadioButton_Trabaja_aqui_SiCarnet);
        jRadioButton_Trabaja_aqui_SiCarnet.setText("Si");
        jPanel_Trabaja_Aqui.add(jRadioButton_Trabaja_aqui_SiCarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));
        jPanel_Trabaja_Aqui.add(jSpinner_Trabaja_aqui_Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 50, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPaneTrabaja_aqui_Cualidades.setViewportView(jTextArea1);

        jPanel_Trabaja_Aqui.add(jScrollPaneTrabaja_aqui_Cualidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 190, 110));

        jComboBox_Trabaja_aqui_Estudios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_Trabaja_aqui_Estudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Educacion Secundaria(ESO)", "Grado Básico", "Grado Medio", "Grado Superior", "Bachillerato", "Grado Universitario" }));
        jPanel_Trabaja_Aqui.add(jComboBox_Trabaja_aqui_Estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, 32));

        jButton_Trabaja_aqui_Curriculum.setText("Examinar");
        jButton_Trabaja_aqui_Curriculum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Trabaja_aqui_CurriculumActionPerformed(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jButton_Trabaja_aqui_Curriculum, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, 40));

        jCheckBox_Trabaja_aqui_Permiso.setText("Aceptolos terminos y condiciones de uso");
        jCheckBox_Trabaja_aqui_Permiso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_Trabaja_aqui_PermisoStateChanged(evt);
            }
        });
        jCheckBox_Trabaja_aqui_Permiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Trabaja_aqui_PermisoActionPerformed(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jCheckBox_Trabaja_aqui_Permiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        jButton_Trabaja_aqui_Enviar.setText("Enviar");
        jButton_Trabaja_aqui_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Trabaja_aqui_EnviarActionPerformed(evt);
            }
        });
        jPanel_Trabaja_Aqui.add(jButton_Trabaja_aqui_Enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 121, 36));

        jPanel1.add(jPanel_Trabaja_Aqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 53, 650, 510));

        jPanel_Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Inicio_linea1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea1.setText("JML conciertos es una compañia internacional dirigida por 3 amigos a los cuales");
        jPanel_Inicio.add(jLabel_Inicio_linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 575, -1));

        jLabel_Inicio_linea2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea2.setText("les fascinan los conciertos y es por eso que crearon esta mini compañia ya dispo-");
        jPanel_Inicio.add(jLabel_Inicio_linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 575, -1));

        jLabel_Inicio_linea3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea3.setText("nible en mas de 7 paises para poder llevar a cabo su sueño de hacer llegar a todo");
        jPanel_Inicio.add(jLabel_Inicio_linea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 16));

        jLabel_Inicio_linea4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea4.setText("el mundo la posibilidad de pasar un buen rato con la música que les gusta.");
        jPanel_Inicio.add(jLabel_Inicio_linea4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 575, -1));

        jLabel_Inicio_Empresa.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel_Inicio_Empresa.setText("JML CONCIERTOS");
        jPanel_Inicio.add(jLabel_Inicio_Empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 80));

        jLabel_Inicio_linea5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea5.setText("Además como sabemos que la gran mayoria de nuestros clientes son jovenes,");
        jPanel_Inicio.add(jLabel_Inicio_linea5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 575, -1));

        jLabel_Inicio_linea6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea6.setText("desde la organizacion,intentamos inculcar unos valores basados en el respeto ");
        jPanel_Inicio.add(jLabel_Inicio_linea6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 575, -1));

        jLabel_Inicio_linea7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Inicio_linea7.setText("y en la libertad.");
        jPanel_Inicio.add(jLabel_Inicio_linea7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 575, -1));

        jButton_Inicio_Insta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Instagram.png"))); // NOI18N
        jButton_Inicio_Insta.setText("JMLConciertos");
        jButton_Inicio_Insta.setContentAreaFilled(false);
        jButton_Inicio_Insta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Inicio_Insta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Inicio_InstaActionPerformed(evt);
            }
        });
        jPanel_Inicio.add(jButton_Inicio_Insta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        jButton_Inicio_YouTube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/YouTube.png"))); // NOI18N
        jButton_Inicio_YouTube.setText("JMLConciertos");
        jButton_Inicio_YouTube.setContentAreaFilled(false);
        jButton_Inicio_YouTube.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Inicio_YouTube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Inicio_YouTubeActionPerformed(evt);
            }
        });
        jPanel_Inicio.add(jButton_Inicio_YouTube, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        jButton_Inicio_Twitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Twitter.png"))); // NOI18N
        jButton_Inicio_Twitter.setText("JMLFestivales");
        jButton_Inicio_Twitter.setContentAreaFilled(false);
        jButton_Inicio_Twitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Inicio_Twitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Inicio_TwitterActionPerformed(evt);
            }
        });
        jPanel_Inicio.add(jButton_Inicio_Twitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));

        jButton_Inicio_Correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Correo.png"))); // NOI18N
        jButton_Inicio_Correo.setText("JML@conciertos.com");
        jButton_Inicio_Correo.setContentAreaFilled(false);
        jButton_Inicio_Correo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Inicio_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Inicio_CorreoActionPerformed(evt);
            }
        });
        jPanel_Inicio.add(jButton_Inicio_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

        jPanel1.add(jPanel_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 650, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_SalirActionPerformed

    private void jButton_Inicio_InstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Inicio_InstaActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI url = new java.net.URI("https://www.instagram.com/");
                    desktop.browse(url);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton_Inicio_InstaActionPerformed

    private void jButton_Inicio_TwitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Inicio_TwitterActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI url = new java.net.URI("https://twitter.com/");
                    desktop.browse(url);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton_Inicio_TwitterActionPerformed

    private void jButton_Inicio_YouTubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Inicio_YouTubeActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI url = new java.net.URI("https://www.youtube.com/");
                    desktop.browse(url);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton_Inicio_YouTubeActionPerformed

    private void jButton_Inicio_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Inicio_CorreoActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI url = new java.net.URI("https://mail.google.com/");
                    desktop.browse(url);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton_Inicio_CorreoActionPerformed

    private void jButton_Cambiar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cambiar_UsuarioActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();    }//GEN-LAST:event_jButton_Cambiar_UsuarioActionPerformed

    private void jTextField_Trabaja_aqui_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_NombreActionPerformed

    private void jTextField_Trabaja_aqui_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_NombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_NombreKeyReleased

    private void jTextField_Trabaja_aqui_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_ApellidoActionPerformed

    private void jTextField_Trabaja_aqui_ApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_ApellidoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_ApellidoKeyReleased

    private void jTextField_Trabaja_aqui_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_EmailActionPerformed

    private void jTextField_Trabaja_aqui_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_EmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_EmailKeyReleased

    private void jTextField_Trabaja_aqui_NIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_NIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_NIFActionPerformed

    private void jTextField_Trabaja_aqui_NIFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_NIFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_NIFKeyReleased

    private void jTextField_Tipo_Trabaja_aqui_EstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Tipo_Trabaja_aqui_EstudiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Tipo_Trabaja_aqui_EstudiosActionPerformed

    private void jTextField_Tipo_Trabaja_aqui_EstudiosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Tipo_Trabaja_aqui_EstudiosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Tipo_Trabaja_aqui_EstudiosKeyReleased

    private void jButton_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InicioActionPerformed
        this.jPanel_Inicio.setVisible(true);
        this.jPanel_Inicio.setEnabled(true);
        this.jPanel_Trabaja_Aqui.setVisible(false);
        this.jPanel_Trabaja_Aqui.setEnabled(false);
        this.jPanel_Mi_Usuario.setVisible(false);
        this.jPanel_Mi_Usuario.setEnabled(false);
    }//GEN-LAST:event_jButton_InicioActionPerformed

    private void jButton_Trabaja_AquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Trabaja_AquiActionPerformed
        this.jPanel_Trabaja_Aqui.setVisible(true);
        this.jPanel_Trabaja_Aqui.setEnabled(true);
        this.jPanel_Inicio.setVisible(false);
        this.jPanel_Inicio.setEnabled(false);
        this.jPanel_Mi_Usuario.setVisible(false);
        this.jPanel_Mi_Usuario.setEnabled(false);
    }//GEN-LAST:event_jButton_Trabaja_AquiActionPerformed

    private void jButton_Trabaja_aqui_CurriculumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Trabaja_aqui_CurriculumActionPerformed
        chooser = new JFileChooser();
        chooser.showOpenDialog(jPanel1);
    }//GEN-LAST:event_jButton_Trabaja_aqui_CurriculumActionPerformed

    private void jCheckBox_Trabaja_aqui_PermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Trabaja_aqui_PermisoActionPerformed
        String nombre = this.jTextField_Trabaja_aqui_Nombre.getText();
        String apellido = this.jTextField_Trabaja_aqui_Apellido.getText();
        String email = this.jTextField_Trabaja_aqui_Email.getText();
        String nif = this.jTextField_Trabaja_aqui_NIF.getText();
        String telefono = this.jTextField_Trabaja_aqui_Telefono.getText();
        int edad = (int) this.jSpinner_Trabaja_aqui_Edad.getValue();
        String tipoestudios = this.jTextField_Tipo_Trabaja_aqui_Estudios.getText();
        String estudios = (String) this.jComboBox_Trabaja_aqui_Estudios.getSelectedItem();
        if ((nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty()) || (nif.isEmpty()) || (telefono.isEmpty()) || (edad == 0) || (estudios.equalsIgnoreCase("--Seleccionar--")) || (tipoestudios.isEmpty())) {
            this.jCheckBox_Trabaja_aqui_Permiso.setSelected(false);
            JOptionPane.showConfirmDialog(this, "Antes debes rellenar todos los campos", "Información", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_jCheckBox_Trabaja_aqui_PermisoActionPerformed

    private void jTextField_Trabaja_aqui_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_TelefonoActionPerformed

    private void jTextField_Trabaja_aqui_TelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Trabaja_aqui_TelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Trabaja_aqui_TelefonoKeyReleased

    private void jCheckBox_Trabaja_aqui_Editar_NombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_Trabaja_aqui_Editar_NombreStateChanged
        if (this.jCheckBox_Trabaja_aqui_Editar_Nombre.isSelected()) {
            this.jTextField_Trabaja_aqui_Nombre.setEnabled(true);
        } else {
            this.jTextField_Trabaja_aqui_Nombre.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox_Trabaja_aqui_Editar_NombreStateChanged

    private void jButton_Mi_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Mi_UsuarioActionPerformed
        this.jPanel_Mi_Usuario.setVisible(true);
        this.jPanel_Mi_Usuario.setEnabled(true);
        this.jPanel_Trabaja_Aqui.setVisible(false);
        this.jPanel_Trabaja_Aqui.setEnabled(false);
        this.jPanel_Inicio.setVisible(false);
        this.jPanel_Inicio.setEnabled(false);
    }//GEN-LAST:event_jButton_Mi_UsuarioActionPerformed

    private void jButton_Tu_Usuario_Eliminar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Eliminar_UsuarioActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que desea borrar su usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            confirmar = JOptionPane.showConfirmDialog(this, "No habrá vuelta atras ,una vez eliminado su usuario le sera devuelto al inicio de sesion\n¿Esta seguro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmar == 0) {
                UsuarioDAO u = new UsuarioDAO();
                u.eliminarUsuario((int) usuario.getId());
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                this.dispose();
            }
        }


    }//GEN-LAST:event_jButton_Tu_Usuario_Eliminar_UsuarioActionPerformed

    private void jButton_Tu_Usuario_Mis_DescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Mis_DescuentosActionPerformed


        this.jDialog_Tu_Usuario_Descuentos.setSize(500, 250);
                this.jDialog_Tu_Usuario_Descuentos.setLocationRelativeTo(null);
        jDialog_Tu_Usuario_Descuentos.setVisible(true);
        modelodescuento = new DefaultTableModel();
        modelodescuento.addColumn("Fecha validez");
        modelodescuento.addColumn("Codigo");
        modelodescuento.addColumn("Cantidad descontada");
        modelodescuento.addColumn("usado");
        this.jTable_Mis_Descuentos.setModel(modelodescuento);
        ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
        descuentos = DescuentoDAO.buscarDescuentoByIdUsuario((int) usuario.getId());
        for(int i = 0;i<descuentos.size();i++){
            String usado="";
            if(descuentos.get(i).getUsado()==0){
                usado = "No";
            }else{
                 usado = "Si";
            }
            modelodescuento.addRow(new Object []{descuentos.get(i).getFechavalidez(),descuentos.get(i).getCodigo(),descuentos.get(i).getCantidad()+" €",usado}); 
        }
        
    }//GEN-LAST:event_jButton_Tu_Usuario_Mis_DescuentosActionPerformed

    private void jTextField_Tu_Usuario_MunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Tu_Usuario_MunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Tu_Usuario_MunicipioActionPerformed

    private void jCheckBox_Trabaja_aqui_Editar_ApellidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_Trabaja_aqui_Editar_ApellidoStateChanged
        if (this.jCheckBox_Trabaja_aqui_Editar_Apellido.isSelected()) {
            this.jTextField_Trabaja_aqui_Apellido.setEnabled(true);
        } else {
            this.jTextField_Trabaja_aqui_Apellido.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Trabaja_aqui_Editar_ApellidoStateChanged

    private void jCheckBox_Trabaja_aqui_Editar_EmailStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_Trabaja_aqui_Editar_EmailStateChanged
        if (this.jCheckBox_Trabaja_aqui_Editar_Email.isSelected()) {
            this.jTextField_Trabaja_aqui_Email.setEnabled(true);
        } else {
            this.jTextField_Trabaja_aqui_Email.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Trabaja_aqui_Editar_EmailStateChanged

    private void jCheckBox_Trabaja_aqui_Editar_NIFStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_Trabaja_aqui_Editar_NIFStateChanged
        if (this.jCheckBox_Trabaja_aqui_Editar_NIF.isSelected()) {
            this.jTextField_Trabaja_aqui_NIF.setEnabled(true);
        } else {
            this.jTextField_Trabaja_aqui_NIF.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Trabaja_aqui_Editar_NIFStateChanged

    private void jButton_Trabaja_aqui_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Trabaja_aqui_EnviarActionPerformed
        String nombre = this.jTextField_Trabaja_aqui_Nombre.getText();
        String apellido = this.jTextField_Trabaja_aqui_Apellido.getText();
        String email = this.jTextField_Trabaja_aqui_Email.getText();
        String nif = this.jTextField_Trabaja_aqui_NIF.getText();
        String telefono = this.jTextField_Trabaja_aqui_Telefono.getText();
        String sexo;
        if (this.jRadioButtonTrabaja_aqui_Masculino.isSelected()) {
            sexo = "Masculino";
        } else if (this.jRadioButtonTrabaja_aqui_Femenino.isSelected()) {
            sexo = "Femenino";
        } else {
            sexo = "otro";
        }
        int edad = (int) this.jSpinner_Trabaja_aqui_Edad.getValue();
        int carnet;
        if (this.jRadioButton_Trabaja_aqui_SiCarnet.isSelected()) {
            carnet = 1;
        } else {
            carnet = 0;
        }
        String tipoestudios = this.jTextField_Tipo_Trabaja_aqui_Estudios.getText();
        String estudios = (String) this.jComboBox_Trabaja_aqui_Estudios.getSelectedItem();
        String cualidades = this.jTextArea1.getText();
        if ((nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty()) || (nif.isEmpty()) || (telefono.isEmpty()) || (edad == 0) || (estudios.equalsIgnoreCase("--Seleccionar--")) || (tipoestudios.isEmpty())) {
            if ((nombre.isEmpty()) && (apellido.isEmpty()) && (email.isEmpty()) && (nif.isEmpty()) && (telefono.isEmpty()) && (edad == 0) && (estudios.equalsIgnoreCase("--Seleccionar--")) && (tipoestudios.isEmpty())) {
                JOptionPane.showConfirmDialog(this, "Todos los campos son obligatorios", "Información", JOptionPane.CLOSED_OPTION);
            } else {
                if (nombre.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Nombre no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (apellido.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Apellido no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (email.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Email no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (nif.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo NIF no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (telefono.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Teléfono no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (edad == 0) {
                    JOptionPane.showConfirmDialog(this, "El campo edad no puede ser 0", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (estudios.equalsIgnoreCase("--Seleccionar--")) {
                    JOptionPane.showConfirmDialog(this, "Hay que seleccionar los estudios maximos", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (tipoestudios.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo tipo de estudios no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }

            }
        } else if (!jCheckBox_Trabaja_aqui_Permiso.isSelected()) {
            JOptionPane.showConfirmDialog(this, "Debe aceptar los terminos y las condiciones de uso", "Información", JOptionPane.CLOSED_OPTION);
        } else {
            Boolean nombrevalido = Usuario.validarNombre(nombre);
            Boolean apellidovalido = Usuario.validarApellido(apellido);
            Boolean emailvalido = Usuario.validarEmail(email);
            Boolean nifvalido = Usuario.validarNIF(nif);

            if ((!emailvalido) || (!nifvalido) || (!nombrevalido) || (!apellidovalido) || (edad < 18)) {
                if (!nombrevalido) {
                    JOptionPane.showMessageDialog(this, "El formato del nombre no es correcto(letras sin numeros ni caracteres especiales)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!apellidovalido) {
                    JOptionPane.showMessageDialog(this, "El formato del apellido no es correcto(letras sin numeros ni caracteres especiales)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!emailvalido) {
                    JOptionPane.showMessageDialog(this, "El formato del email no es correcto(debe contener al menos un @)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!nifvalido) {
                    JOptionPane.showMessageDialog(this, "El formato del NIF no es correcto(debe contener 8 números y una letra mayuscula)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (edad < 18) {
                    JOptionPane.showMessageDialog(this, "Debes de ser mayor de edad para enviar este cuestionario", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                Boolean emailbuscado = Usuario.buscarEmail(email);
                Boolean nifbuscado = Usuario.buscarNIF(nif);
                if ((emailbuscado) || (nifbuscado)) {
                    JOptionPane.showMessageDialog(this, "Usted ya ha sido inscrito en nuestra base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    this.jTextField_Trabaja_aqui_Email.setText("");
                } else {

                    int confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro de querer inscribirse en nuestra base de datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirmar == 0) {
                        Trabajo nuevocandidato = new Trabajo(nombre, apellido, email, nif, telefono, sexo, estudios, tipoestudios, edad, carnet, cualidades);
                        TrabajoDAO t = new TrabajoDAO();
                        t.insertarCandidato(nuevocandidato);

                    }
                }
            }
        }
    }//GEN-LAST:event_jButton_Trabaja_aqui_EnviarActionPerformed

    private void jCheckBox_Trabaja_aqui_PermisoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_Trabaja_aqui_PermisoStateChanged

    }//GEN-LAST:event_jCheckBox_Trabaja_aqui_PermisoStateChanged

    private void jButton_Tu_Usuario_Editar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Editar_DatosActionPerformed
        this.jTextField_Tu_Usuario_Nombre.setVisible(true);
        this.jTextField_Tu_Usuario_Nombre.setEnabled(false);
        this.jTextField_Tu_Usuario_Apellido.setVisible(true);
        this.jTextField_Tu_Usuario_Apellido.setEnabled(false);
        this.jTextField_Tu_Usuario_Email.setVisible(true);
        this.jTextField_Tu_Usuario_Email.setEnabled(false);
        this.jTextField_Tu_Usuario_NIF.setVisible(true);
        this.jTextField_Tu_Usuario_NIF.setEnabled(false);
        this.jTextField_Tu_Usuario_Calle.setVisible(true);
        this.jTextField_Tu_Usuario_Calle.setEnabled(false);
        this.jTextField_Tu_Usuario_Ciudad.setVisible(true);
        this.jTextField_Tu_Usuario_Ciudad.setEnabled(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setVisible(true);
        this.jTextField_Tu_Usuario_Codigo_Postal.setEnabled(false);
        this.jTextField_Tu_Usuario_País.setVisible(true);
        this.jTextField_Tu_Usuario_País.setEnabled(false);
        this.jTextField_Tu_Usuario_Municipio.setVisible(true);
        this.jTextField_Tu_Usuario_Municipio.setEnabled(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setVisible(true);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setVisible(true);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setVisible(true);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setEnabled(false);

        this.jLabel_Tu_Usuario_Titular1.setVisible(false);
        this.jLabel_Tu_Usuario_Calle1.setVisible(false);
        this.jLabel_Tu_Usuario_Email1.setVisible(false);
        this.jLabel_Tu_Usuario_Ciudad1.setVisible(false);
        this.jLabel_Tu_Usuario_Codigo1.setVisible(false);
        this.jLabel_Tu_Usuario_Codigo_Postal1.setVisible(false);
        this.jLabel_Tu_Usuario_Municipio1.setVisible(false);
        this.jLabel_Tu_Usuario_Nif1.setVisible(false);
        this.jLabel_Tu_Usuario_NombreyApellido1.setVisible(false);
        this.jLabel_Tu_Usuario_País1.setVisible(false);
        this.jLabel_Tu_Usuario_Tarjeta1.setVisible(false);

        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setVisible(true);
        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setEnabled(true);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setVisible(true);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setEnabled(true);
        this.jButton_Tu_Usuario_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Editar_Datos.setEnabled(false);
        this.jButton_Tu_Usuario_Eliminar_Usuario.setVisible(false);
        this.jButton_Tu_Usuario_Eliminar_Usuario.setEnabled(false);

        this.jCheckBox_Tu_Usuario_Editar1.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar1.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar2.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar2.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar3.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar3.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar4.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar4.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar5.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar5.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar6.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar6.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar7.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar7.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar8.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar8.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar9.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar9.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar10.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar10.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar11.setVisible(true);
        this.jCheckBox_Tu_Usuario_Editar11.setEnabled(true);
        

    }//GEN-LAST:event_jButton_Tu_Usuario_Editar_DatosActionPerformed

    private void jButton_Tu_Usuario_Aceptar_Editar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Aceptar_Editar_DatosActionPerformed
        System.out.println(usuario.getIdDireccion());
        String nombre = this.jTextField_Tu_Usuario_Nombre.getText();
        String apellido = this.jTextField_Tu_Usuario_Apellido.getText();
        String email = this.jTextField_Tu_Usuario_Email.getText();
        String nif = this.jTextField_Tu_Usuario_NIF.getText();
        String calle = this.jTextField_Tu_Usuario_Calle.getText();
        String ciudad = this.jTextField_Tu_Usuario_Ciudad.getText();
        String codigopostal = this.jTextField_Tu_Usuario_Codigo_Postal.getText();
        String municipio = this.jTextField_Tu_Usuario_Municipio.getText();
        String pais = this.jTextField_Tu_Usuario_País.getText();
        String codigotarjeta = this.jTextField_Tu_Usuario_CVV_Tarjeta.getText();
        String titulartarjeta = this.jTextField_Tu_Usuario_Titulat_Tarjeta.getText();
        String numerotarjeta = this.jTextField_Tu_Usuario_Numero_Tarjeta.getText();

        if ((nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty()) || (nif.isEmpty()) || (pais.isEmpty()) || (municipio.isEmpty()) || (calle.isEmpty()) || (ciudad.isEmpty()) || (codigopostal.isEmpty())) {
            if ((nombre.isEmpty()) && (apellido.isEmpty()) && (email.isEmpty()) && (nif.isEmpty()) && (municipio.isEmpty()) && (calle.isEmpty()) && (codigopostal.isEmpty()) && (ciudad.isEmpty()) && (pais.isEmpty())) {
                JOptionPane.showConfirmDialog(this, "Todos los campos son obligatorios(Excepto la direccion bancaria)", "Información", JOptionPane.CLOSED_OPTION);
            } else {
                if (nombre.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Nombre no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (apellido.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Apellido no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (email.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Email no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (nif.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo NIF no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (calle.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Calle no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (municipio.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Municipio no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (codigopostal.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Codigo Postal no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (pais.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo País no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }
                if (ciudad.isEmpty()) {
                    JOptionPane.showConfirmDialog(this, "El campo Ciudad no puede quedar vacío", "Información", JOptionPane.CLOSED_OPTION);
                }

            }
        } else if (((titulartarjeta.isEmpty()) && (numerotarjeta.isEmpty()) && (codigotarjeta.isEmpty())) || ((!titulartarjeta.isEmpty()) && (!numerotarjeta.isEmpty()) && (!codigotarjeta.isEmpty()))) {
            Boolean nombrevalido = Usuario.validarNombre(nombre);
            Boolean apellidovalido = Usuario.validarApellido(apellido);
            Boolean emailvalido = Usuario.validarEmail(email);
            Boolean nifvalido = Usuario.validarNIF(nif);
            if ((!emailvalido) || (!nifvalido) || (!nombrevalido) || (!apellidovalido)) {

                if (!nombrevalido) {
                    JOptionPane.showMessageDialog(this, "El formato del nombre no es correcto(letras sin numeros ni caracteres especiales)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!apellidovalido) {
                    JOptionPane.showMessageDialog(this, "El formato del apellido no es correcto(letras sin numeros ni caracteres especiales)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!emailvalido) {
                    JOptionPane.showMessageDialog(this, "El formato del email no es correcto(debe contener al menos un @)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!nifvalido) {
                    JOptionPane.showMessageDialog(this, "El formato del NIF no es correcto(debe contener 8 números y una letra mayuscula)", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                Boolean emailbuscado = Usuario.buscarEmail(email);
                Boolean nifbuscado = Usuario.buscarNIF(nif);
                if (((emailbuscado) || (nifbuscado)) && ((this.jCheckBox_Tu_Usuario_Editar8.isSelected())||(this.jCheckBox_Tu_Usuario_Editar9.isSelected()))) {
                    if (emailbuscado) {
                        JOptionPane.showMessageDialog(this, "El Email introducido ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                        this.jTextField_Tu_Usuario_Email.setText("");
                    }
                    if (nifbuscado) {
                        JOptionPane.showMessageDialog(this, "El NIF introducido ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                        this.jTextField_Tu_Usuario_NIF.setText("");
                    }

                } else {

                    int confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro de querer editar su usauario?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirmar == 0) {
                        Usuario usuariomodificado = new Usuario((int) usuario.getId(), nombre, apellido, email, nif, usuario.getAdministrador(), usuario.getContraseña(), usuario.getIdDireccion(), usuario.getIdBancario());
                        UsuarioDAO u = new UsuarioDAO();
                        u.modificarUsuario(usuariomodificado);
                        Direccion direccionmodificada = new Direccion(usuario.getIdDireccion(), calle, codigopostal, pais, ciudad, municipio);
                        DireccionDAO d = new DireccionDAO();
                        d.modificarDireccion(direccionmodificada);
                        Bancario bancariomodificado = new Bancario(usuario.getIdBancario(), titulartarjeta, numerotarjeta, codigotarjeta);
                        BancarioDAO b = new BancarioDAO();
                        b.modificarBancario(bancariomodificado);
                    }

                }
            }
        } else {
            JOptionPane.showConfirmDialog(this, "En caso de introducir un dato bancario,tienes que introducir todos", "Información", JOptionPane.CLOSED_OPTION);
        }
          this.jLabel_Tu_Usuario_NombreyApellido1.setText(usuario.getNombre().toUpperCase() + " " + usuario.getApellido().toUpperCase());
        this.jLabel_Tu_Usuario_Nif1.setText(usuario.getNif());
        this.jLabel_Tu_Usuario_Email1.setText(usuario.getEmail());
        this.jLabel_Tu_Usuario_Contraseña1.setText(usuario.getContraseña());
        DireccionDAO d = new DireccionDAO();
        Direccion direccion = new Direccion();
        direccion = d.buscarDireccionById(usuario.getIdDireccion());
           this.jLabel_Tu_Usuario_Calle1.setText(direccion.getCalle());
        this.jLabel_Tu_Usuario_Ciudad1.setText(direccion.getCiudad());
        this.jLabel_Tu_Usuario_Codigo_Postal1.setText(direccion.getCodigoPostal());
        this.jLabel_Tu_Usuario_Municipio1.setText(direccion.getMunicipio());
        this.jLabel_Tu_Usuario_País1.setText(direccion.getPais());
         BancarioDAO b = new BancarioDAO();
        Bancario bancario = new Bancario();
        bancario = b.buscarBancarioById(usuario.getIdBancario());
        this.jLabel_Tu_Usuario_Tarjeta1.setText(bancario.getNumtarjeta());
        this.jLabel_Tu_Usuario_Codigo1.setText(bancario.getCodigotarjeta());
        this.jLabel_Tu_Usuario_Titular1.setText(bancario.getTitular());
        this.jTextField_Tu_Usuario_Nombre.setVisible(false);
        this.jTextField_Tu_Usuario_Nombre.setEnabled(false);
        this.jTextField_Tu_Usuario_Apellido.setVisible(false);
        this.jTextField_Tu_Usuario_Apellido.setEnabled(false);
        this.jTextField_Tu_Usuario_Email.setVisible(false);
        this.jTextField_Tu_Usuario_Email.setEnabled(false);
        this.jTextField_Tu_Usuario_NIF.setVisible(false);
        this.jTextField_Tu_Usuario_NIF.setEnabled(false);
        this.jTextField_Tu_Usuario_Calle.setVisible(false);
        this.jTextField_Tu_Usuario_Calle.setEnabled(false);
        this.jTextField_Tu_Usuario_Ciudad.setVisible(false);
        this.jTextField_Tu_Usuario_Ciudad.setEnabled(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setVisible(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setEnabled(false);
        this.jTextField_Tu_Usuario_País.setVisible(false);
        this.jTextField_Tu_Usuario_País.setEnabled(false);
        this.jTextField_Tu_Usuario_Municipio.setVisible(false);
        this.jTextField_Tu_Usuario_Municipio.setEnabled(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setEnabled(false);
         this.jLabel_Tu_Usuario_Titular1.setVisible(true);
        this.jLabel_Tu_Usuario_Calle1.setVisible(true);
        this.jLabel_Tu_Usuario_Email1.setVisible(true);
        this.jLabel_Tu_Usuario_Ciudad1.setVisible(true);
        this.jLabel_Tu_Usuario_Codigo1.setVisible(true);
        this.jLabel_Tu_Usuario_Codigo_Postal1.setVisible(true);
        this.jLabel_Tu_Usuario_Municipio1.setVisible(true);
        this.jLabel_Tu_Usuario_Nif1.setVisible(true);
        this.jLabel_Tu_Usuario_NombreyApellido1.setVisible(true);
        this.jLabel_Tu_Usuario_País1.setVisible(true);
        this.jLabel_Tu_Usuario_Tarjeta1.setVisible(true);
        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setEnabled(false);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setEnabled(false);
         this.jButton_Tu_Usuario_Editar_Datos.setVisible(true);
        this.jButton_Tu_Usuario_Editar_Datos.setEnabled(true);
        this.jButton_Tu_Usuario_Eliminar_Usuario.setVisible(true);
        this.jButton_Tu_Usuario_Eliminar_Usuario.setEnabled(true);
        this.jCheckBox_Tu_Usuario_Editar1.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar1.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar2.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar2.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar3.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar3.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar4.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar4.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar5.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar5.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar6.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar6.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar7.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar7.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar8.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar8.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar9.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar9.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar10.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar10.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar11.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar11.setEnabled(false);
        
    }//GEN-LAST:event_jButton_Tu_Usuario_Aceptar_Editar_DatosActionPerformed

    private void jButton_Tu_Usuario_Cancelar_Editar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Cancelar_Editar_DatosActionPerformed
       
        this.jCheckBox_Tu_Usuario_Editar1.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar1.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar2.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar2.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar3.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar3.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar4.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar4.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar5.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar5.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar6.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar6.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar7.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar7.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar8.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar8.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar9.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar9.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar10.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar10.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar11.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar11.setEnabled(false);
        
        this.jButton_Tu_Usuario_Editar_Datos.setVisible(true);
        this.jButton_Tu_Usuario_Editar_Datos.setEnabled(true);
        this.jButton_Tu_Usuario_Eliminar_Usuario.setVisible(true);
        this.jButton_Tu_Usuario_Eliminar_Usuario.setEnabled(true);

        this.jLabel_Tu_Usuario_Titular1.setVisible(true);
        this.jLabel_Tu_Usuario_Calle1.setVisible(true);
        this.jLabel_Tu_Usuario_Email1.setVisible(true);
        this.jLabel_Tu_Usuario_Ciudad1.setVisible(true);
        this.jLabel_Tu_Usuario_Codigo1.setVisible(true);
        this.jLabel_Tu_Usuario_Codigo_Postal1.setVisible(true);
        this.jLabel_Tu_Usuario_Municipio1.setVisible(true);
        this.jLabel_Tu_Usuario_Nif1.setVisible(true);
        this.jLabel_Tu_Usuario_NombreyApellido1.setVisible(true);
        this.jLabel_Tu_Usuario_País1.setVisible(true);
        this.jLabel_Tu_Usuario_Tarjeta1.setVisible(true);

        this.jLabel_Tu_Usuario_NombreyApellido1.setText(usuario.getNombre().toUpperCase() + " " + usuario.getApellido().toUpperCase());
        this.jLabel_Tu_Usuario_Nif1.setText(usuario.getNif());
        this.jLabel_Tu_Usuario_Email1.setText(usuario.getEmail());
        this.jLabel_Tu_Usuario_Contraseña1.setText(usuario.getContraseña());

        DireccionDAO d = new DireccionDAO();
        Direccion direccion = new Direccion();
        direccion = d.buscarDireccionById(usuario.getIdDireccion());
        this.jLabel_Tu_Usuario_Calle1.setText(direccion.getCalle());
        this.jLabel_Tu_Usuario_Ciudad1.setText(direccion.getCiudad());
        this.jLabel_Tu_Usuario_Codigo_Postal1.setText(direccion.getCodigoPostal());
        this.jLabel_Tu_Usuario_Municipio1.setText(direccion.getMunicipio());
        this.jLabel_Tu_Usuario_País1.setText(direccion.getPais());
        this.jTextField_Tu_Usuario_Calle.setText(direccion.getCalle());
        this.jTextField_Tu_Usuario_Ciudad.setText(direccion.getCiudad());
        this.jTextField_Tu_Usuario_Codigo_Postal.setText(direccion.getCodigoPostal());
        this.jTextField_Tu_Usuario_Municipio.setText(direccion.getMunicipio());
        this.jTextField_Tu_Usuario_País.setText(direccion.getPais());

        BancarioDAO b = new BancarioDAO();
        Bancario bancario = new Bancario();
        bancario = b.buscarBancarioById(usuario.getIdBancario());
        this.jLabel_Tu_Usuario_Tarjeta1.setText(bancario.getNumtarjeta());
        this.jLabel_Tu_Usuario_Codigo1.setText(bancario.getCodigotarjeta());
        this.jLabel_Tu_Usuario_Titular1.setText(bancario.getTitular());
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setText(bancario.getCodigotarjeta());
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setText(bancario.getTitular());
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setText(bancario.getNumtarjeta());

        TextPrompt tipo = new TextPrompt("Ej-Peluquería", jTextField_Tipo_Trabaja_aqui_Estudios);
        this.jTextField_Tu_Usuario_Nombre.setVisible(false);
        this.jTextField_Tu_Usuario_Nombre.setEnabled(false);
        this.jTextField_Tu_Usuario_Apellido.setVisible(false);
        this.jTextField_Tu_Usuario_Apellido.setEnabled(false);
        this.jTextField_Tu_Usuario_Email.setVisible(false);
        this.jTextField_Tu_Usuario_Email.setEnabled(false);
        this.jTextField_Tu_Usuario_NIF.setVisible(false);
        this.jTextField_Tu_Usuario_NIF.setEnabled(false);
        this.jTextField_Tu_Usuario_Calle.setVisible(false);
        this.jTextField_Tu_Usuario_Calle.setEnabled(false);
        this.jTextField_Tu_Usuario_Ciudad.setVisible(false);
        this.jTextField_Tu_Usuario_Ciudad.setEnabled(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setVisible(false);
        this.jTextField_Tu_Usuario_Codigo_Postal.setEnabled(false);
        this.jTextField_Tu_Usuario_País.setVisible(false);
        this.jTextField_Tu_Usuario_País.setEnabled(false);
        this.jTextField_Tu_Usuario_Municipio.setVisible(false);
        this.jTextField_Tu_Usuario_Municipio.setEnabled(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_CVV_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_Titulat_Tarjeta.setEnabled(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setVisible(false);
        this.jTextField_Tu_Usuario_Numero_Tarjeta.setEnabled(false);

        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Aceptar_Editar_Datos.setEnabled(false);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setVisible(false);
        this.jButton_Tu_Usuario_Cancelar_Editar_Datos.setEnabled(false);

        this.jCheckBox_Tu_Usuario_Editar1.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar1.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar2.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar2.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar3.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar3.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar4.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar4.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar5.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar5.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar6.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar6.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar7.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar7.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar8.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar8.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar9.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar9.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar10.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar10.setEnabled(false);
        this.jCheckBox_Tu_Usuario_Editar11.setVisible(false);
        this.jCheckBox_Tu_Usuario_Editar11.setEnabled(false);
    }//GEN-LAST:event_jButton_Tu_Usuario_Cancelar_Editar_DatosActionPerformed

    private void jCheckBox_Tu_Usuario_Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar1ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar1.isSelected()) {
            this.jTextField_Tu_Usuario_Numero_Tarjeta.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Numero_Tarjeta.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar1ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar2ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar2.isSelected()) {
            this.jTextField_Tu_Usuario_Titulat_Tarjeta.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Titulat_Tarjeta.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar2ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar3ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar3.isSelected()) {
            this.jTextField_Tu_Usuario_Ciudad.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Ciudad.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar3ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar4ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar4.isSelected()) {
            this.jTextField_Tu_Usuario_País.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_País.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar4ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar5ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar5.isSelected()) {
            this.jTextField_Tu_Usuario_Codigo_Postal.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Codigo_Postal.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar5ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar6ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar6.isSelected()) {
            this.jTextField_Tu_Usuario_Municipio.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Municipio.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar6ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar7ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar7.isSelected()) {
            this.jTextField_Tu_Usuario_Calle.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Calle.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar7ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar8ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar8.isSelected()) {
            this.jTextField_Tu_Usuario_NIF.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_NIF.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar8ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar9ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar9.isSelected()) {
            this.jTextField_Tu_Usuario_Email.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Email.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar9ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar10ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar10.isSelected()) {
            this.jTextField_Tu_Usuario_Nombre.setEnabled(true);
            this.jTextField_Tu_Usuario_Apellido.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_Nombre.setEnabled(false);
            this.jTextField_Tu_Usuario_Apellido.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar10ActionPerformed

    private void jCheckBox_Tu_Usuario_Editar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Tu_Usuario_Editar11ActionPerformed
        if (jCheckBox_Tu_Usuario_Editar11.isSelected()) {
            this.jTextField_Tu_Usuario_CVV_Tarjeta.setEnabled(true);
        } else {
            this.jTextField_Tu_Usuario_CVV_Tarjeta.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_Tu_Usuario_Editar11ActionPerformed

    private void jButton_Tu_Usuario_Cambiar_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Cambiar_ContraseñaActionPerformed
        NuevaContraseña nuevacontra = new NuevaContraseña(this,true,usuario);
        this.dispose();
        nuevacontra.setVisible(true);
        
    }//GEN-LAST:event_jButton_Tu_Usuario_Cambiar_ContraseñaActionPerformed

    private void jButton_Tu_Usuario_Lo_Que_Pide_La_PracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tu_Usuario_Lo_Que_Pide_La_PracticaActionPerformed
        this.jDialog_Practica.setSize(500, 500);
        this.jDialog_Practica.setLocationRelativeTo(null);
        jDialog_Practica.setVisible(true);
        modelousuario = new DefaultTableModel();
        modelousuario.addColumn("nombre");
        modelousuario.addColumn("apellido");
        modelousuario.addColumn("email");
        modelousuario.addColumn("nif");
        modelousuario.addColumn("Administrador");
        modelousuario.addColumn("Contraseña");
        this.jTable1.setModel(modelousuario);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        UsuarioDAO u = new UsuarioDAO();
        usuarios = u.todosUsuarios();
        for(int i = 0;i<usuarios.size();i++){
            String admin="";
            if(usuarios.get(i).getAdministrador()){
                admin = "Si";
            }else{
                 admin = "No";
            }
            modelousuario.addRow(new Object []{usuarios.get(i).getNombre(),usuarios.get(i).getApellido(),usuarios.get(i).getEmail(),usuarios.get(i).getNif(),admin,usuarios.get(i).getContraseña()}); 
        }
    }//GEN-LAST:event_jButton_Tu_Usuario_Lo_Que_Pide_La_PracticaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new MenuPrincipal(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_Carnet;
    private javax.swing.ButtonGroup buttonGroup_Sexo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_Cambiar_Usuario;
    private javax.swing.JButton jButton_Inicio;
    private javax.swing.JButton jButton_Inicio_Correo;
    private javax.swing.JButton jButton_Inicio_Insta;
    private javax.swing.JButton jButton_Inicio_Twitter;
    private javax.swing.JButton jButton_Inicio_YouTube;
    private javax.swing.JButton jButton_Mi_Usuario;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JButton jButton_Trabaja_Aqui;
    private javax.swing.JButton jButton_Trabaja_aqui_Curriculum;
    private javax.swing.JButton jButton_Trabaja_aqui_Enviar;
    private javax.swing.JButton jButton_Tu_Usuario_Aceptar_Editar_Datos;
    private javax.swing.JButton jButton_Tu_Usuario_Cambiar_Contraseña;
    private javax.swing.JButton jButton_Tu_Usuario_Cancelar_Editar_Datos;
    private javax.swing.JButton jButton_Tu_Usuario_Editar_Datos;
    private javax.swing.JButton jButton_Tu_Usuario_Eliminar_Usuario;
    private javax.swing.JButton jButton_Tu_Usuario_Lo_Que_Pide_La_Practica;
    private javax.swing.JButton jButton_Tu_Usuario_Mis_Descuentos;
    private javax.swing.JButton jButton_Tu_Usuario_Reservas;
    private javax.swing.JButton jButton_Ver_Conciertos;
    private javax.swing.JCheckBox jCheckBox_Trabaja_aqui_Editar_Apellido;
    private javax.swing.JCheckBox jCheckBox_Trabaja_aqui_Editar_Email;
    private javax.swing.JCheckBox jCheckBox_Trabaja_aqui_Editar_NIF;
    private javax.swing.JCheckBox jCheckBox_Trabaja_aqui_Editar_Nombre;
    private javax.swing.JCheckBox jCheckBox_Trabaja_aqui_Permiso;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar1;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar10;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar11;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar2;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar3;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar4;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar5;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar6;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar7;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar8;
    private javax.swing.JCheckBox jCheckBox_Tu_Usuario_Editar9;
    private javax.swing.JComboBox<String> jComboBox_Trabaja_aqui_Estudios;
    private javax.swing.JDialog jDialog_Practica;
    private javax.swing.JDialog jDialog_Tu_Usuario_Descuentos;
    private javax.swing.JLabel jLabel_Empresa;
    private javax.swing.JLabel jLabel_Inicio_Empresa;
    private javax.swing.JLabel jLabel_Inicio_linea1;
    private javax.swing.JLabel jLabel_Inicio_linea2;
    private javax.swing.JLabel jLabel_Inicio_linea3;
    private javax.swing.JLabel jLabel_Inicio_linea4;
    private javax.swing.JLabel jLabel_Inicio_linea5;
    private javax.swing.JLabel jLabel_Inicio_linea6;
    private javax.swing.JLabel jLabel_Inicio_linea7;
    private javax.swing.JLabel jLabel_Tipo_Trabaja_aqui_Estudios;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Apellido;
    private javax.swing.JLabel jLabel_Trabaja_aqui_CV;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Carnet;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Cualidades;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Edad;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Email;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Estudios;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Nif;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Nombre;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Sexo;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Telefono;
    private javax.swing.JLabel jLabel_Trabaja_aqui_Titulo;
    private javax.swing.JLabel jLabel_Tu_Nombre;
    private javax.swing.JLabel jLabel_Tu_Usuario_Calle;
    private javax.swing.JLabel jLabel_Tu_Usuario_Calle1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Ciudad;
    private javax.swing.JLabel jLabel_Tu_Usuario_Ciudad1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Codigo;
    private javax.swing.JLabel jLabel_Tu_Usuario_Codigo1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Codigo_Postal;
    private javax.swing.JLabel jLabel_Tu_Usuario_Codigo_Postal1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Contraseña;
    private javax.swing.JLabel jLabel_Tu_Usuario_Contraseña1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Datos_Bancarios;
    private javax.swing.JLabel jLabel_Tu_Usuario_Datos_Personales;
    private javax.swing.JLabel jLabel_Tu_Usuario_Direccion;
    private javax.swing.JLabel jLabel_Tu_Usuario_Email;
    private javax.swing.JLabel jLabel_Tu_Usuario_Email1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Municipio;
    private javax.swing.JLabel jLabel_Tu_Usuario_Municipio1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Nif;
    private javax.swing.JLabel jLabel_Tu_Usuario_Nif1;
    private javax.swing.JLabel jLabel_Tu_Usuario_NombreyApellido;
    private javax.swing.JLabel jLabel_Tu_Usuario_NombreyApellido1;
    private javax.swing.JLabel jLabel_Tu_Usuario_País;
    private javax.swing.JLabel jLabel_Tu_Usuario_País1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Tarjeta;
    private javax.swing.JLabel jLabel_Tu_Usuario_Tarjeta1;
    private javax.swing.JLabel jLabel_Tu_Usuario_Titular;
    private javax.swing.JLabel jLabel_Tu_Usuario_Titular1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Arriba;
    private javax.swing.JPanel jPanel_Inicio;
    private javax.swing.JPanel jPanel_Izquierda;
    private javax.swing.JPanel jPanel_Mi_Usuario;
    private javax.swing.JPanel jPanel_Trabaja_Aqui;
    private javax.swing.JRadioButton jRadioButtonTrabaja_aqui_Femenino;
    private javax.swing.JRadioButton jRadioButtonTrabaja_aqui_Masculino;
    private javax.swing.JRadioButton jRadioButtonTrabaja_aqui_Otro;
    private javax.swing.JRadioButton jRadioButton_Trabaja_aqui_NoCarnet;
    private javax.swing.JRadioButton jRadioButton_Trabaja_aqui_SiCarnet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneTrabaja_aqui_Cualidades;
    private javax.swing.JSpinner jSpinner_Trabaja_aqui_Edad;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable_Mis_Descuentos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField_Tipo_Trabaja_aqui_Estudios;
    private javax.swing.JTextField jTextField_Trabaja_aqui_Apellido;
    private javax.swing.JTextField jTextField_Trabaja_aqui_Email;
    private javax.swing.JTextField jTextField_Trabaja_aqui_NIF;
    private javax.swing.JTextField jTextField_Trabaja_aqui_Nombre;
    private javax.swing.JTextField jTextField_Trabaja_aqui_Telefono;
    private javax.swing.JTextField jTextField_Tu_Usuario_Apellido;
    private javax.swing.JTextField jTextField_Tu_Usuario_CVV_Tarjeta;
    private javax.swing.JTextField jTextField_Tu_Usuario_Calle;
    private javax.swing.JTextField jTextField_Tu_Usuario_Ciudad;
    private javax.swing.JTextField jTextField_Tu_Usuario_Codigo_Postal;
    private javax.swing.JTextField jTextField_Tu_Usuario_Email;
    private javax.swing.JTextField jTextField_Tu_Usuario_Municipio;
    private javax.swing.JTextField jTextField_Tu_Usuario_NIF;
    private javax.swing.JTextField jTextField_Tu_Usuario_Nombre;
    private javax.swing.JTextField jTextField_Tu_Usuario_Numero_Tarjeta;
    private javax.swing.JTextField jTextField_Tu_Usuario_País;
    private javax.swing.JTextField jTextField_Tu_Usuario_Titulat_Tarjeta;
    // End of variables declaration//GEN-END:variables
}
