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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Hernández Guerrero
 */
public class ListaDeRestaurantesFavoritos extends javax.swing.JFrame
{
    String usuario = "";
    DefaultListModel listaRestaurantesFavoritos = new DefaultListModel();

    public ListaDeRestaurantesFavoritos() 
    {
        initComponents();
        Transparencia();
    }
    
    public ListaDeRestaurantesFavoritos (String pUsuario) 
    {
       consultasBaseDeDatos consulta = new BaseDeDatos();
       initComponents();
       Transparencia();
       usuario = pUsuario;
       this.setLocationRelativeTo(null);
       
       for (String restaurante : consulta.MostrarRestaurantesFavoritos(pUsuario)) 
       {
           listaRestaurantesFavoritos.addElement(restaurante);
       }
       
       this.jListListaRestaurantes.setModel(listaRestaurantesFavoritos);
    }
        
    public Image getIconImage()
    {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/lentti.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListListaRestaurantes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonAgregarRestauranteFavorito = new javax.swing.JButton();
        jButtonEliminarRestauranteFavorito = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jListListaRestaurantes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 300, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ListaDeRestaurantesFavoritos.png"))); // NOI18N
        jLabel1.setText("Lista de restaurantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jButtonAgregarRestauranteFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarRestauranteFavoritoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarRestauranteFavorito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 40));

        jButtonEliminarRestauranteFavorito.setBorder(null);
        jButtonEliminarRestauranteFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarRestauranteFavoritoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarRestauranteFavorito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 370, 40));

        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 110, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        PantallaClienteInicio iniciador = new PantallaClienteInicio(usuario);
        iniciador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAgregarRestauranteFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarRestauranteFavoritoActionPerformed
        // TODO add your handling code here:
        AgregarRestauranteFavorito arf = new AgregarRestauranteFavorito(usuario);
        arf.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_jButtonAgregarRestauranteFavoritoActionPerformed

    private void jButtonEliminarRestauranteFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarRestauranteFavoritoActionPerformed
        // TODO add your handling code here:
        EliminarRestauranteFavorito erf = new EliminarRestauranteFavorito(usuario);
        erf.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_jButtonEliminarRestauranteFavoritoActionPerformed

    public void Transparencia ()
    {
        jListListaRestaurantes.setOpaque(false);
        jListListaRestaurantes.setBackground(new Color(0, 0, 0, 0));
        jButtonAgregarRestauranteFavorito.setOpaque(false);
        jButtonAgregarRestauranteFavorito.setBackground(new Color(0, 0, 0, 0));
        jButtonEliminarRestauranteFavorito.setOpaque(false);
        jButtonEliminarRestauranteFavorito.setBackground(new Color(0, 0, 0, 0));
        jButtonSalir.setOpaque(false);
        jButtonSalir.setBackground(new Color(0, 0, 0, 0));
    }
    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(ListaDeRestaurantesFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDeRestaurantesFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDeRestaurantesFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDeRestaurantesFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new ListaDeRestaurantesFavoritos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarRestauranteFavorito;
    private javax.swing.JButton jButtonEliminarRestauranteFavorito;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListListaRestaurantes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
