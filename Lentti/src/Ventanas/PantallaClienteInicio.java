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
import java.util.ArrayList;

/**
 *
 * @author samyf
 */
public class PantallaClienteInicio extends javax.swing.JFrame {

    String usuarioA;
    /**
     * Creates new form PantallaInicialCliente
     */
    public PantallaClienteInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        transparenciaDelBoton();
    }
    
    public PantallaClienteInicio(String pUsuario) {
        initComponents();
        String usuario = pUsuario;
        L_bienvenidoNombreUsuario.setText(usuario);
        usuarioA = pUsuario;
        this.setLocationRelativeTo(null);
        transparenciaDelBoton();
        colocarDireccion();
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

        Pedidos = new javax.swing.JButton();
        Direccion = new javax.swing.JLabel();
        jButtonCerrarSesion = new javax.swing.JButton();
        L_bienvenidoNombreUsuario = new javax.swing.JLabel();
        BotonCaritoCompra = new javax.swing.JButton();
        BotonBuscarAlgoParaPedir = new javax.swing.JButton();
        jButtonVerRestaurantesFavoritos = new javax.swing.JButton();
        B_IrAPerfilCliente = new javax.swing.JButton();
        B_realizarUtlimoPedido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pedidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Pedidos.setForeground(new java.awt.Color(255, 255, 255));
        Pedidos.setBorder(null);
        Pedidos.setContentAreaFilled(false);
        Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidosActionPerformed(evt);
            }
        });
        getContentPane().add(Pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 190, 170));

        Direccion.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Direccion.setText("direc");
        getContentPane().add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 290, 30));

        jButtonCerrarSesion.setBorder(null);
        jButtonCerrarSesion.setContentAreaFilled(false);
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 110, 90));

        L_bienvenidoNombreUsuario.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        L_bienvenidoNombreUsuario.setText("nombreUsuario");
        getContentPane().add(L_bienvenidoNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 290, 30));

        BotonCaritoCompra.setBorder(null);
        BotonCaritoCompra.setContentAreaFilled(false);
        BotonCaritoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCaritoCompraActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCaritoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 170, 170));

        BotonBuscarAlgoParaPedir.setBorder(null);
        BotonBuscarAlgoParaPedir.setContentAreaFilled(false);
        BotonBuscarAlgoParaPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarAlgoParaPedirActionPerformed(evt);
            }
        });
        getContentPane().add(BotonBuscarAlgoParaPedir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 170, 170));

        jButtonVerRestaurantesFavoritos.setBorder(null);
        jButtonVerRestaurantesFavoritos.setContentAreaFilled(false);
        jButtonVerRestaurantesFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerRestaurantesFavoritosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVerRestaurantesFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 310, 60));

        B_IrAPerfilCliente.setBorder(null);
        B_IrAPerfilCliente.setContentAreaFilled(false);
        B_IrAPerfilCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IrAPerfilClienteActionPerformed(evt);
            }
        });
        getContentPane().add(B_IrAPerfilCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 110, 90));

        B_realizarUtlimoPedido.setBorder(null);
        B_realizarUtlimoPedido.setContentAreaFilled(false);
        B_realizarUtlimoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_realizarUtlimoPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(B_realizarUtlimoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 300, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UltimaModif.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        // TODO add your handling code here:
        InicioSesion pantalla = new InicioSesion();
        pantalla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void BotonBuscarAlgoParaPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarAlgoParaPedirActionPerformed
        // TODO add your handling code here:
        PantallaBusquedaPR pantalla = new PantallaBusquedaPR(L_bienvenidoNombreUsuario.getText());
        pantalla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonBuscarAlgoParaPedirActionPerformed

    private void BotonCaritoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCaritoCompraActionPerformed
        // TODO add your handling code here:
        PantallaCarroCompras pantalla = new PantallaCarroCompras(L_bienvenidoNombreUsuario.getText());
        pantalla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonCaritoCompraActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        // TODO add your handling code here:
        PantallaVerPedidos p = new PantallaVerPedidos(L_bienvenidoNombreUsuario.getText());
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PedidosActionPerformed

    private void jButtonVerRestaurantesFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerRestaurantesFavoritosActionPerformed
        // TODO add your handling code here:
        ListaDeRestaurantesFavoritos lrf = new ListaDeRestaurantesFavoritos(L_bienvenidoNombreUsuario.getText());
        lrf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVerRestaurantesFavoritosActionPerformed

    private void B_IrAPerfilClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IrAPerfilClienteActionPerformed
        // TODO add your handling code here:
        
        PantallaPerfilCliente pantalla = new PantallaPerfilCliente(L_bienvenidoNombreUsuario.getText());
                    pantalla.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_B_IrAPerfilClienteActionPerformed

    private void B_realizarUtlimoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_realizarUtlimoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_realizarUtlimoPedidoActionPerformed


    
    
    public void transparenciaDelBoton()
    {
        BotonBuscarAlgoParaPedir.setOpaque(false);
        BotonBuscarAlgoParaPedir.setBackground(new Color(0,0,0,0));
        
        Pedidos.setOpaque(false);
        Pedidos.setBackground(new Color(0,0,0,0));
        
        BotonCaritoCompra.setOpaque(false);
        BotonCaritoCompra.setBackground(new Color(0,0,0,0));
        
        jButtonVerRestaurantesFavoritos.setOpaque(false);
        jButtonVerRestaurantesFavoritos.setBackground(new Color(0,0,0,0));
        
        jButtonCerrarSesion.setOpaque(false);
        jButtonCerrarSesion.setBackground(new Color(0,0,0,0));
        
        B_IrAPerfilCliente.setOpaque(false);
        B_IrAPerfilCliente.setBackground(new Color(0,0,0,0));
        
        B_realizarUtlimoPedido.setOpaque(false);
        B_realizarUtlimoPedido.setBackground(new Color(0,0,0,0));
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
            java.util.logging.Logger.getLogger(PantallaClienteInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaClienteInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaClienteInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaClienteInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaClienteInicio().setVisible(true);
            }
        });
    }
    
    public void colocarDireccion()
    {
        consultasBaseDeDatos consulta = new BaseDeDatos();
        ArrayList<String> datos = consulta.darCliente(usuarioA);
        Direccion.setText(datos.get(2));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_IrAPerfilCliente;
    private javax.swing.JButton B_realizarUtlimoPedido;
    private javax.swing.JButton BotonBuscarAlgoParaPedir;
    private javax.swing.JButton BotonCaritoCompra;
    private javax.swing.JLabel Direccion;
    private javax.swing.JLabel L_bienvenidoNombreUsuario;
    private javax.swing.JButton Pedidos;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonVerRestaurantesFavoritos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
