/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Camilo Hernández Guerrero
 */
public class PantallaCrearRestaurante extends javax.swing.JFrame 
{
    String usuario = "";
    File Imagen;
    String apertura = "", cierre = "";
    JFileChooser buscador;
    /**
     * Creates new form CrearRestaurante
     */
    public PantallaCrearRestaurante() 
    {
        initComponents();
        Transparencia();
        this.setLocationRelativeTo(null);
    }
    
    public PantallaCrearRestaurante(String usuario) 
    {
        initComponents();
        Transparencia();
        this.setLocationRelativeTo(null);
        this.usuario = usuario;
    }
    
    public Image getIconImage()
    {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/lentti.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCampoDescripcion = new javax.swing.JTextArea();
        jTextFieldCampoNIT = new javax.swing.JTextField();
        jTextFieldCampoCostoDeEnvio = new javax.swing.JTextField();
        jTextFieldCampoPassword = new javax.swing.JTextField();
        jTextFieldCampoDireccion = new javax.swing.JTextField();
        jTextFieldCampoPalabrasClave = new javax.swing.JTextField();
        jTextFieldCampoNombre = new javax.swing.JTextField();
        Cierre = new javax.swing.JComboBox<>();
        Apertura = new javax.swing.JComboBox<>();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelCampoImagen = new javax.swing.JLabel();
        jButtonAgregarImagen = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(800, 690));
        setMinimumSize(new java.awt.Dimension(800, 690));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextAreaCampoDescripcion.setColumns(20);
        jTextAreaCampoDescripcion.setRows(5);
        jTextAreaCampoDescripcion.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaCampoDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 450, 60));

        jTextFieldCampoNIT.setBorder(null);
        jTextFieldCampoNIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoNITActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCampoNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 202, 190, 30));

        jTextFieldCampoCostoDeEnvio.setBorder(null);
        jTextFieldCampoCostoDeEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoCostoDeEnvioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCampoCostoDeEnvio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 382, 190, 30));

        jTextFieldCampoPassword.setBorder(null);
        jTextFieldCampoPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCampoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 152, 190, 30));

        jTextFieldCampoDireccion.setBorder(null);
        jTextFieldCampoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCampoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 252, 190, 30));

        jTextFieldCampoPalabrasClave.setBorder(null);
        jTextFieldCampoPalabrasClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoPalabrasClaveActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCampoPalabrasClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 602, 450, 30));

        jTextFieldCampoNombre.setBorder(null);
        jTextFieldCampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 190, 40));

        Cierre.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        Cierre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));
        Cierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CierreMouseClicked(evt);
            }
        });
        getContentPane().add(Cierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 110, 30));

        Apertura.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        Apertura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));
        Apertura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AperturaMouseClicked(evt);
            }
        });
        getContentPane().add(Apertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 110, 30));

        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 630, 50, 50));

        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 60, 60));
        getContentPane().add(jLabelCampoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 130, 120));

        jButtonAgregarImagen.setText("Agregar Imagen");
        jButtonAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarImagenActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 160, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PantallaRestauranteCreacion.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoNombreActionPerformed

    }//GEN-LAST:event_jTextFieldCampoNombreActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        PantallaInicialAdministrador pantallaGestion = new PantallaInicialAdministrador(usuario);
        pantallaGestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        consultasBaseDeDatos consulta = new BaseDeDatos();
        String horario = apertura+"/"+cierre;
        boolean resultado = false;
        
        if(this.jTextFieldCampoNombre.getText().isEmpty() || this.jTextFieldCampoPassword.getText().isEmpty()|| this.jTextFieldCampoNIT.getText().isEmpty() || this.jTextAreaCampoDescripcion.getText().isEmpty() || this.jTextFieldCampoCostoDeEnvio.getText().isEmpty() || this.Imagen==null)//AAAAAAAAAAAAAAAAAAAAAAAAAA
        {
            JOptionPane.showMessageDialog(null, "Hay un campo vacio.");
        }
        else if (consulta.ValidarExistenciaRestaurante(this.jTextFieldCampoNombre.getText()))
        {
            JOptionPane.showMessageDialog(null, "El restaurante ya existe.");
            PantallaCrearRestaurante pantallaGestion = new PantallaCrearRestaurante(usuario);
            pantallaGestion.setVisible(true);
            this.dispose();
        }
        else
        {
            float costoDeEnvio = Float.parseFloat(this.jTextFieldCampoCostoDeEnvio.getText());
            resultado = consulta.CrearRestaurante(this.jTextFieldCampoNombre.getText(), this.jTextFieldCampoPassword.getText(), this.jTextFieldCampoNIT.getText(), this.jTextFieldCampoDireccion.getText(), this.jTextAreaCampoDescripcion.getText(), costoDeEnvio, this.buscador, horario);
            consulta.AlmacenarPalabrasClave (this.jTextFieldCampoNombre.getText(), this.jTextFieldCampoPalabrasClave.getText());
            PantallaAgregarPlato pantallaGestion = new PantallaAgregarPlato(jTextFieldCampoNombre.getText());
            pantallaGestion.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTextFieldCampoNITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoNITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCampoNITActionPerformed

    private void jTextFieldCampoCostoDeEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoCostoDeEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCampoCostoDeEnvioActionPerformed

    private void jTextFieldCampoPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCampoPasswordActionPerformed

    private void jTextFieldCampoDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCampoDireccionActionPerformed

    private void jTextFieldCampoPalabrasClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoPalabrasClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCampoPalabrasClaveActionPerformed

    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    private void jButtonAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarImagenActionPerformed
        buscador =new JFileChooser(); 
        buscador.setMultiSelectionEnabled(false);
        buscador.setDialogTitle("Buscar Imagen restaurante");
        if(buscador.showOpenDialog(this) == JFileChooser.APPROVE_OPTION && !buscador.isDirectorySelectionEnabled())
        {   
            if(buscador.getSelectedFile().toString().endsWith(".jpg") ||buscador.getSelectedFile().toString().endsWith(".png") )
            {
                this.Imagen = new File ( buscador.getSelectedFile().toString());
                ImageIcon imagenPoner = new ImageIcon( buscador.getSelectedFile().toString());
                Icon Etiqueta = new ImageIcon(imagenPoner.getImage().getScaledInstance(this.jLabelCampoImagen.getWidth(), this.jLabelCampoImagen.getHeight(), Image.SCALE_SMOOTH));
                this.jLabelCampoImagen.setIcon(Etiqueta);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No es un formato aceptado, debe ser jpg o png");
            }
            
             
            //this.jLabel1.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_jButtonAgregarImagenActionPerformed

    private void AperturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AperturaMouseClicked
        // TODO add your handling code here:
        //Almacenar apertura
        apertura = Apertura.getSelectedItem().toString();

    }//GEN-LAST:event_AperturaMouseClicked

    private void CierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CierreMouseClicked
        // TODO add your handling code here:
        cierre = Cierre.getSelectedItem().toString();
    }//GEN-LAST:event_CierreMouseClicked

    /**
     * @param args the command line arguments
     */
    
    public void Transparencia ()
    {
        jTextFieldCampoNombre.setOpaque(false);
        jTextFieldCampoNombre.setBackground(new Color(0, 0, 0, 0));
        jTextFieldCampoPassword.setOpaque(false);
        jTextFieldCampoPassword.setBackground(new Color(0, 0, 0, 0));
        jTextFieldCampoNIT.setOpaque(false);
        jTextFieldCampoNIT.setBackground(new Color(0, 0, 0, 0));
        jTextFieldCampoDireccion.setOpaque(false);
        jTextFieldCampoDireccion.setBackground(new Color(0, 0, 0, 0));
        jTextAreaCampoDescripcion.setOpaque(false);
        jTextAreaCampoDescripcion.setBackground(new Color(0, 0, 0, 0));
        jTextFieldCampoCostoDeEnvio.setOpaque(false);
        jTextFieldCampoCostoDeEnvio.setBackground(new Color(0, 0, 0, 0));
        jTextFieldCampoPalabrasClave.setOpaque(false);
        jTextFieldCampoPalabrasClave.setBackground(new Color(0, 0, 0, 0));
        jButtonAceptar.setOpaque(false);
        jButtonAceptar.setBackground(new Color(0, 0, 0, 0));
        jButtonCancelar.setOpaque(false);
        jButtonCancelar.setBackground(new Color(0, 0, 0, 0));
    }
    
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
            java.util.logging.Logger.getLogger(PantallaCrearRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCrearRestaurante().setVisible(true);
                
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PantallaCrearRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Apertura;
    private javax.swing.JComboBox<String> Cierre;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAgregarImagen;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCampoImagen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCampoDescripcion;
    private javax.swing.JTextField jTextFieldCampoCostoDeEnvio;
    private javax.swing.JTextField jTextFieldCampoDireccion;
    private javax.swing.JTextField jTextFieldCampoNIT;
    private javax.swing.JTextField jTextFieldCampoNombre;
    private javax.swing.JTextField jTextFieldCampoPalabrasClave;
    private javax.swing.JTextField jTextFieldCampoPassword;
    // End of variables declaration//GEN-END:variables
}
