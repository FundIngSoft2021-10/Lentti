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
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Hernández Guerrero
 */
public class PantallaAgregarPlato extends javax.swing.JFrame 
{
    String usuario = "";
    /**
     * Creates new form CrearRestaurante
     */
    public PantallaAgregarPlato() 
    {
        initComponents();
        Transparencia();
        this.setLocationRelativeTo(null);
    }
    
    public PantallaAgregarPlato(String usuario) 
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

        jLabel1 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonAgregarPlato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PantallaAgregarPlato.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 180, 60));

        jButtonAgregarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPlatoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 293, 360, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPlatoActionPerformed
        PantallaCrearPlato iniciador = new PantallaCrearPlato (usuario);
        iniciador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAgregarPlatoActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        InicioSesion pantallaGestion = new InicioSesion ();
        pantallaGestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void Transparencia ()
    {
        jButtonAgregarPlato.setOpaque(false);
        jButtonAgregarPlato.setBackground(new Color(0, 0, 0, 0));
        jButtonFinalizar.setOpaque(false);
        jButtonFinalizar.setBackground(new Color(0, 0, 0, 0));
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
            java.util.logging.Logger.getLogger(PantallaAgregarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAgregarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAgregarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAgregarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAgregarPlato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarPlato;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
