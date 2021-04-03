/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
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
        this.setLocationRelativeTo(null);
    }
    public PantallaModificarPlato(String usuario) {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombrePlato = new javax.swing.JTextField();
        jButtonModNombre = new javax.swing.JButton();
        jButtonModPrecio = new javax.swing.JButton();
        jButtonModDescripcion = new javax.swing.JButton();
        jButtonModImagen = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jTextFieldModNombre = new javax.swing.JTextField();
        jTextFieldModPrecio = new javax.swing.JTextField();
        jTextFieldModDescripcion = new javax.swing.JTextField();
        jTextFieldModImagen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modificar plato");

        jLabel2.setText("Nombre del plato");

        jButtonModNombre.setText("Modificar nombre");
        jButtonModNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModNombreActionPerformed(evt);
            }
        });

        jButtonModPrecio.setText("Modificar precio");
        jButtonModPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModPrecioActionPerformed(evt);
            }
        });

        jButtonModDescripcion.setText("Modificar descripción");
        jButtonModDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModDescripcionActionPerformed(evt);
            }
        });

        jButtonModImagen.setText("Modificar imagen");
        jButtonModImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModImagenActionPerformed(evt);
            }
        });

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAtras))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jTextFieldNombrePlato, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonModNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldModNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonModPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldModPrecio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonModImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldModImagen))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonModDescripcion)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldModDescripcion)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonAtras))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombrePlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModNombre)
                    .addComponent(jTextFieldModNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModPrecio)
                    .addComponent(jTextFieldModPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModDescripcion)
                    .addComponent(jTextFieldModDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModImagen)
                    .addComponent(jTextFieldModImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

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