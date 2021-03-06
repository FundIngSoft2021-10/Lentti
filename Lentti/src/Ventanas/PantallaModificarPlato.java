/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author juank
 */
public class PantallaModificarPlato extends javax.swing.JFrame {
    String usuario="";
    /**
     * Creates new form PantallaModificarPlato
     */
    public PantallaModificarPlato() {
        initComponents();
        Transparencia();
        this.setLocationRelativeTo(null);
    }
    public PantallaModificarPlato(String usuario) {
        initComponents();
        Transparencia();
        this.setLocationRelativeTo(null);
        this.usuario=usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNombrePlato = new javax.swing.JTextField();
        jTextFieldModNombre = new javax.swing.JTextField();
        jTextFieldModPrecio = new javax.swing.JTextField();
        jTextFieldModDescripcion = new javax.swing.JTextField();
        jTextFieldModImagen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonModNombre = new javax.swing.JButton();
        jButtonModPrecio = new javax.swing.JButton();
        jButtonModImagen = new javax.swing.JButton();
        jButtonModDescripcion = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNombrePlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombrePlatoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombrePlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 270, 50));
        getContentPane().add(jTextFieldModNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 192, 260, 40));
        getContentPane().add(jTextFieldModPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 270, 40));
        getContentPane().add(jTextFieldModDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 382, 270, 40));
        getContentPane().add(jTextFieldModImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 482, 260, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IPantallaModificarPlato.png"))); // NOI18N
        jLabel2.setText("Nombre del plato");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 690));

        jButtonModNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 110, 40));

        jButtonModPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 110, 40));

        jButtonModImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModImagenActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 480, 110, 40));

        jButtonModDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 110, 40));

        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 130, 60));

        jLabel1.setText("Modificar plato");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModPrecioActionPerformed
        consultasBaseDeDatos consulta = new BaseDeDatos();
        boolean resultado= false;
        if(this.jTextFieldModPrecio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo está vacio.");
        }
        else{
            resultado = consulta.ModificarPrecioPlato(this.jTextFieldNombrePlato.getText(), this.jTextFieldModPrecio.getText());
        } 
    }//GEN-LAST:event_jButtonModPrecioActionPerformed

    private void jButtonModNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModNombreActionPerformed
        consultasBaseDeDatos consulta = new BaseDeDatos();
        boolean resultado= false;
        if(this.jTextFieldModNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo está vacio.");
        }
        else{
            resultado = consulta.ModificarNombrePlato(this.jTextFieldNombrePlato.getText(), this.jTextFieldModNombre.getText());
        } 
    }//GEN-LAST:event_jButtonModNombreActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        PantallaGestionPlatos pantallaGestion = new PantallaGestionPlatos(usuario);
        pantallaGestion.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonModDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModDescripcionActionPerformed
        consultasBaseDeDatos consulta = new BaseDeDatos();
        boolean resultado= false;
        if(this.jTextFieldModDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo está vacio.");
        }
        else{
            resultado = consulta.ModificarDescripcionPlato(this.jTextFieldNombrePlato.getText(), this.jTextFieldModDescripcion.getText());
        }        
    }//GEN-LAST:event_jButtonModDescripcionActionPerformed

    private void jButtonModImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModImagenActionPerformed
        consultasBaseDeDatos consulta = new BaseDeDatos();
        boolean resultado= false;
        if(this.jTextFieldModImagen.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo está vacio.");
        }
        else{
            resultado = consulta.ModificarImagenPlato(this.jTextFieldNombrePlato.getText(), this.jTextFieldModImagen.getText());
        }       
    }//GEN-LAST:event_jButtonModImagenActionPerformed

    private void jTextFieldNombrePlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombrePlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombrePlatoActionPerformed

    /**
     * @param args the command line arguments
     */
    public void Transparencia ()
    {
        jButtonAtras.setOpaque(false);
        jButtonAtras.setBackground(new Color(0, 0, 0, 0));
        jButtonModDescripcion.setOpaque(false);
        jButtonModDescripcion.setBackground(new Color(0, 0, 0, 0));  
        jButtonModImagen.setOpaque(false);
        jButtonModImagen.setBackground(new Color(0, 0, 0, 0));
        jButtonModNombre.setOpaque(false);
        jButtonModNombre.setBackground(new Color(0, 0, 0, 0)); 
        jButtonModPrecio.setOpaque(false);
        jButtonModPrecio.setBackground(new Color(0, 0, 0, 0)); 
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
            java.util.logging.Logger.getLogger(PantallaModificarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaModificarPlato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonModDescripcion;
    private javax.swing.JButton jButtonModImagen;
    private javax.swing.JButton jButtonModNombre;
    private javax.swing.JButton jButtonModPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldModDescripcion;
    private javax.swing.JTextField jTextFieldModImagen;
    private javax.swing.JTextField jTextFieldModNombre;
    private javax.swing.JTextField jTextFieldModPrecio;
    private javax.swing.JTextField jTextFieldNombrePlato;
    // End of variables declaration//GEN-END:variables
}
