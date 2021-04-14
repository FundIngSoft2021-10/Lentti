/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author samyf
 */
public class PantallaGestionarAdmin extends javax.swing.JFrame {

    /**
     * Creates new form PantallaGestionarAdmin
     */
    String usuario;
    
    public PantallaGestionarAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public PantallaGestionarAdmin(String pUsuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.usuario=pUsuario;
        this.jLabelMensajeInicial.setText(usuario);
        
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

        jButtonRegistrarAdmin = new javax.swing.JButton();
        jButtonModificarUsuario = new javax.swing.JButton();
        jButtonEliminarPerfil = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelMensajeInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistrarAdmin.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonRegistrarAdmin.setText("Registrar Administrador");
        jButtonRegistrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarAdminActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 220, 50));

        jButtonModificarUsuario.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonModificarUsuario.setText("Modificar Usuario");
        jButtonModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 220, 50));

        jButtonEliminarPerfil.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonEliminarPerfil.setText("Eliminar perfil");
        jButtonEliminarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 220, 50));

        jButtonSalir.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 110, 40));

        jLabelMensajeInicial.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(jLabelMensajeInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IPantallaGestionarAdmin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarAdminActionPerformed
        PantallaRegistroAdmin iniciador= new PantallaRegistroAdmin();
        iniciador.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarAdminActionPerformed

    private void jButtonModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarUsuarioActionPerformed
        PantallaModificarAdmin iniciador = new PantallaModificarAdmin(usuario);
        iniciador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonModificarUsuarioActionPerformed

    private void jButtonEliminarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPerfilActionPerformed
        consultasBaseDeDatos consulta = new BaseDeDatos();
        
        if(consulta.EliminarCuenta(usuario, "A"))
        {
            InicioSesion iniciador = new InicioSesion();
            JOptionPane.showMessageDialog(null, "Administrador eliminado.");
            this.dispose();
            iniciador.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El administrador no se pudo eliminar.");
        }
    }//GEN-LAST:event_jButtonEliminarPerfilActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        PantallaInicialAdministrador iniciador = new PantallaInicialAdministrador(usuario);
        iniciador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaGestionarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaGestionarAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminarPerfil;
    private javax.swing.JButton jButtonModificarUsuario;
    private javax.swing.JButton jButtonRegistrarAdmin;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMensajeInicial;
    // End of variables declaration//GEN-END:variables
}
