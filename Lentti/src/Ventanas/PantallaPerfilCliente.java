/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;

/**
 *
 * @author gato
 */
public class PantallaPerfilCliente extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPerfilCliente
     */
    String usuarioCliente;
    
    public PantallaPerfilCliente() {
        initComponents();
    }
    public PantallaPerfilCliente(String pUsuario)
    {
        initComponents();
        this.setLocationRelativeTo(null);
        usuarioCliente = pUsuario;
       // LabelNombreUsuario.setText(pUsuario);
        transparenciaDelBoton();
    
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B_ModificarperfilCliente = new javax.swing.JButton();
        B_CerrarSesionCliente = new javax.swing.JButton();
        B_VolverPantallaInicioCliente = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        B_ModificarperfilCliente.setBorder(null);
        getContentPane().add(B_ModificarperfilCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 370, 60));

        B_CerrarSesionCliente.setBorder(null);
        getContentPane().add(B_CerrarSesionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 610, 120, 80));

        B_VolverPantallaInicioCliente.setBorder(null);
        B_VolverPantallaInicioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_VolverPantallaInicioClienteActionPerformed(evt);
            }
        });
        getContentPane().add(B_VolverPantallaInicioCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 100, 90));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("info cliente");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 740, 430));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pantallaPerfilCliente.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_VolverPantallaInicioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_VolverPantallaInicioClienteActionPerformed
        // TODO add your handling code here:
        PantallaClienteInicio pantalla = new PantallaClienteInicio(usuarioCliente);
                    pantalla.setVisible(true);
                    this.dispose();
        
    }//GEN-LAST:event_B_VolverPantallaInicioClienteActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPerfilCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPerfilCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPerfilCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPerfilCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPerfilCliente().setVisible(true);
            }
        });
    }
    
    public void transparenciaDelBoton()
    {
        B_CerrarSesionCliente.setOpaque(false);
        B_CerrarSesionCliente.setBackground(new Color(0,0,0,0));
        
        B_ModificarperfilCliente.setOpaque(false);
        B_ModificarperfilCliente.setBackground(new Color(0,0,0,0));
        
        B_VolverPantallaInicioCliente.setOpaque(false);
        B_VolverPantallaInicioCliente.setBackground(new Color(0,0,0,0));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_CerrarSesionCliente;
    private javax.swing.JButton B_ModificarperfilCliente;
    private javax.swing.JButton B_VolverPantallaInicioCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
