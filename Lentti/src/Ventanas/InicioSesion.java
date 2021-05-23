/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import Modelo.CorreoElectronico;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
        this.Transparencia();
        
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
        jTextFieldCampoUsuario = new javax.swing.JTextField();
        jButtonSalirApp = new javax.swing.JButton();
        jPasswordFieldCampoContrasena = new javax.swing.JPasswordField();
        jButtonCrearCliente = new javax.swing.JButton();
        jButtonOlvidoContra = new javax.swing.JButton();
        jComboBoxTipoPerfil = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonIniciarSesion.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 220, 50));

        jTextFieldCampoUsuario.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        getContentPane().add(jTextFieldCampoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 170, 40));

        jButtonSalirApp.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonSalirApp.setBorderPainted(false);
        jButtonSalirApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirAppActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalirApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 110, 60));

        jPasswordFieldCampoContrasena.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        getContentPane().add(jPasswordFieldCampoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 170, 40));

        jButtonCrearCliente.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButtonCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearCliente(evt);
            }
        });
        getContentPane().add(jButtonCrearCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 170, 40));

        jButtonOlvidoContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOlvidoContraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOlvidoContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 170, 40));

        jComboBoxTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Restaurante", "Administrador", "Domiciliario" }));
        getContentPane().add(jComboBoxTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PantallaInicioSesion.png"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        // TODO add your handling code here:
        //Validacion cambio contra
        
        String[] partes;
        String dia, mes, anio;
        consultasBaseDeDatos consulta = new BaseDeDatos();
        String seleccion=this.jComboBoxTipoPerfil.getSelectedItem().toString();
        String fecha =  null;
        partes = fecha.split("/");
        dia = partes[0];
        mes = partes[1];
        anio =  partes[2];
        
        
        if(seleccion.equals("Cliente"))
        {
            if(consulta.ValidarInicioSesion(this.jTextFieldCampoUsuario.getText(), this.jPasswordFieldCampoContrasena.getText(), "C"))
            {
                PantallaClienteInicio nuevoCliente= new PantallaClienteInicio(this.jTextFieldCampoUsuario.getText());
                nuevoCliente.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario, Contraseña o Tipo de usuario incorrecto");
            }
        }
        else if(seleccion.equals("Restaurante"))
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
        else if(seleccion.equals("Administrador"))
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
        else if(seleccion.equals("Domiciliario"))
        {
            if(consulta.ValidarInicioSesion(this.jTextFieldCampoUsuario.getText(), this.jPasswordFieldCampoContrasena.getText(), "D"))
            {
                PantallaInicialDomiciliario nuevoDomiciliario = new PantallaInicialDomiciliario(this.jTextFieldCampoUsuario.getText());
                nuevoDomiciliario.setVisible(true);
                this.dispose();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario, Contraseña o Tipo de usuario incorrecto");
            }
        }
            
        
        
        
        
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    private void jButtonSalirAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirAppActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirAppActionPerformed

    private void BotonCrearCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearCliente
            // TODO add your handling code here:
            //crear cliente
            PantallaCrearCliente crearCliente = new PantallaCrearCliente();
            crearCliente.setVisible(true);
            this.dispose();

            
            
    }//GEN-LAST:event_BotonCrearCliente

    private void jButtonOlvidoContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOlvidoContraActionPerformed
        // TODO add your handling code here:
        PantallaRecuperarContrasena iniciador =new PantallaRecuperarContrasena();
        iniciador.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_jButtonOlvidoContraActionPerformed

    private void Transparencia()
    {
        this.jButtonIniciarSesion.setOpaque(false);
        this.jButtonIniciarSesion.setBackground(new Color(0, 0, 0, 0));
        this.jButtonIniciarSesion.setBorderPainted(false);
        this.jButtonCrearCliente.setOpaque(false);
        this.jButtonCrearCliente.setBackground(new Color(0, 0, 0, 0));
        this.jButtonCrearCliente.setBorderPainted(false);
        this.jButtonSalirApp.setOpaque(false);
        this.jButtonSalirApp.setBackground(new Color(0, 0, 0, 0));
        this.jButtonSalirApp.setBorderPainted(false);
        this.jButtonOlvidoContra.setOpaque(false);
        this.jButtonOlvidoContra.setBackground(new Color(0, 0, 0, 0));
        this.jButtonOlvidoContra.setBorderPainted(false);
    }
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
    private javax.swing.JButton jButtonCrearCliente;
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonOlvidoContra;
    private javax.swing.JButton jButtonSalirApp;
    private javax.swing.JComboBox<String> jComboBoxTipoPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordFieldCampoContrasena;
    private javax.swing.JTextField jTextFieldCampoUsuario;
    // End of variables declaration//GEN-END:variables
}
