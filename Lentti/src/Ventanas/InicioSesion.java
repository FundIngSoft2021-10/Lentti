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
public class InicioSesion extends javax.swing.JFrame {
    /**
     * Creates new form InicioSecion
     */
    public InicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    /*funcion para agregar icono del programa*/
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

        jButtonIniciarSesion = new javax.swing.JButton();
        jToggleBotonUsuarioCliente = new javax.swing.JToggleButton();
        jToggleBotonUsuarioAdmin = new javax.swing.JToggleButton();
        jToggleBotonUsuarioRestaurante = new javax.swing.JToggleButton();
        jToggleBotonUsuarioDomiciliario = new javax.swing.JToggleButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabelEtiquetaUsuario = new javax.swing.JLabel();
        jLabelEtiquetaContrasena = new javax.swing.JLabel();
        jTextFieldCampoUsuario = new javax.swing.JTextField();
        jButtonSalirApp = new javax.swing.JButton();
        jPasswordFieldCampoContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setUndecorated(true);

        jButtonIniciarSesion.setText("Iniciar sesión");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });

        jToggleBotonUsuarioCliente.setText("Cliente");
        jToggleBotonUsuarioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleBotonUsuarioClienteActionPerformed(evt);
            }
        });

        jToggleBotonUsuarioAdmin.setText("Administrador");
        jToggleBotonUsuarioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleBotonUsuarioAdminActionPerformed(evt);
            }
        });

        jToggleBotonUsuarioRestaurante.setText("Restaurante");
        jToggleBotonUsuarioRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleBotonUsuarioRestauranteActionPerformed(evt);
            }
        });

        jToggleBotonUsuarioDomiciliario.setText("Domiciliario");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lentti.png"))); // NOI18N

        jLabelEtiquetaUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEtiquetaUsuario.setText("Usuario");

        jLabelEtiquetaContrasena.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEtiquetaContrasena.setText("Contraseña");

        jButtonSalirApp.setText("Salir");
        jButtonSalirApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirAppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jButtonIniciarSesion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleBotonUsuarioCliente)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jToggleBotonUsuarioAdmin)
                                .addGap(35, 35, 35)
                                .addComponent(jToggleBotonUsuarioRestaurante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordFieldCampoContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCampoUsuario))
                                .addGap(95, 95, 95)))
                        .addComponent(jToggleBotonUsuarioDomiciliario)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEtiquetaContrasena)
                    .addComponent(jLabelEtiquetaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(38, 38, 38)
                .addComponent(jButtonSalirApp))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo))
                    .addComponent(jButtonSalirApp))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEtiquetaUsuario)
                    .addComponent(jTextFieldCampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEtiquetaContrasena)
                    .addComponent(jPasswordFieldCampoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleBotonUsuarioCliente)
                    .addComponent(jToggleBotonUsuarioAdmin)
                    .addComponent(jToggleBotonUsuarioRestaurante)
                    .addComponent(jToggleBotonUsuarioDomiciliario))
                .addGap(18, 18, 18)
                .addComponent(jButtonIniciarSesion)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        // TODO add your handling code here:
        consultasBaseDeDatos consulta = new BaseDeDatos();
        //si inicia sesión un cliente
        if(this.jToggleBotonUsuarioCliente.isSelected() && !(this.jToggleBotonUsuarioAdmin.isSelected() || this.jToggleBotonUsuarioRestaurante.isSelected() || this.jToggleBotonUsuarioDomiciliario.isSelected() ))
        {
            
            if(consulta.ValidarInicioSesion(this.jTextFieldCampoUsuario.getText(), this.jPasswordFieldCampoContrasena.getText(), "C"))
            {
                PantallaInicialCliente nuevoCliente= new PantallaInicialCliente();
                nuevoCliente.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario, Contraseña o Tipo de usuario incorrecto");
            }

        }
        //si inicia sesión un administrador
        else if (this.jToggleBotonUsuarioAdmin.isSelected()&& !(this.jToggleBotonUsuarioCliente.isSelected() || this.jToggleBotonUsuarioRestaurante.isSelected() || this.jToggleBotonUsuarioDomiciliario.isSelected() ))
        {
            
            if(consulta.ValidarInicioSesion(this.jTextFieldCampoUsuario.getText(), this.jPasswordFieldCampoContrasena.getText(), "A"))
            {
                PantallaInicialAdministrador nuevoAdmin = new PantallaInicialAdministrador(this.jTextFieldCampoUsuario.getText());
                nuevoAdmin.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario, Contraseña o Tipo de usuario incorrecto");
            }
            
        }
        //si inicia sesión un restaurante
        else if (this.jToggleBotonUsuarioRestaurante.isSelected() && !(this.jToggleBotonUsuarioAdmin.isSelected() || this.jToggleBotonUsuarioCliente.isSelected() || this.jToggleBotonUsuarioDomiciliario.isSelected() ))
        {
           
            if(consulta.ValidarInicioSesion(this.jTextFieldCampoUsuario.getText(), this.jPasswordFieldCampoContrasena.getText(), "R"))
            {
                PantallaInicialRestaurante nuevoResturante= new PantallaInicialRestaurante(this.jTextFieldCampoUsuario.getText());
                nuevoResturante.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario, Contraseña o Tipo de usuario incorrecto");
            }
            
        }
        //si inicia sesión un domiciliario
        else if (this.jToggleBotonUsuarioDomiciliario.isSelected() && !(this.jToggleBotonUsuarioAdmin.isSelected() || this.jToggleBotonUsuarioRestaurante.isSelected() || this.jToggleBotonUsuarioCliente.isSelected() ))
        {
            
            if(consulta.ValidarInicioSesion(this.jTextFieldCampoUsuario.getText(), this.jPasswordFieldCampoContrasena.getText(), "D"))
            {
                PantallaInicialDomiciliario nuevoDomiciliario = new PantallaInicialDomiciliario();
                nuevoDomiciliario.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario, Contraseña o Tipo de usuario incorrecto");
            }
            
        }
        //si no selecciona algun tipo de usuario
        else if(!this.jToggleBotonUsuarioAdmin.isSelected() && !this.jToggleBotonUsuarioRestaurante.isSelected() && !this.jToggleBotonUsuarioCliente.isSelected() && !this.jToggleBotonUsuarioDomiciliario.isSelected() )
        {
            JOptionPane.showMessageDialog(null, "Seleccione algun tipo de usuario");
        }
        //si selecciona mas de un tipo de usuario
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un solo tipo de usuario");
        }
            
        
        
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    private void jToggleBotonUsuarioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleBotonUsuarioClienteActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jToggleBotonUsuarioClienteActionPerformed

    private void jButtonSalirAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirAppActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirAppActionPerformed

    private void jToggleBotonUsuarioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleBotonUsuarioAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleBotonUsuarioAdminActionPerformed

    private void jToggleBotonUsuarioRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleBotonUsuarioRestauranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleBotonUsuarioRestauranteActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonSalirApp;
    private javax.swing.JLabel jLabelEtiquetaContrasena;
    private javax.swing.JLabel jLabelEtiquetaUsuario;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPasswordField jPasswordFieldCampoContrasena;
    private javax.swing.JTextField jTextFieldCampoUsuario;
    private javax.swing.JToggleButton jToggleBotonUsuarioAdmin;
    private javax.swing.JToggleButton jToggleBotonUsuarioCliente;
    private javax.swing.JToggleButton jToggleBotonUsuarioDomiciliario;
    private javax.swing.JToggleButton jToggleBotonUsuarioRestaurante;
    // End of variables declaration//GEN-END:variables
}
