/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class PantallaVerPedidos extends javax.swing.JFrame {

    String cliente;
    String rest;
    String domdoc;
    DefaultListModel listaPedidosActivos = new DefaultListModel();
    DefaultListModel listaPedidosAnteriores = new DefaultListModel();
    /**
     * Creates new form PantallaVerPedidos
     */
    public PantallaVerPedidos() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    public PantallaVerPedidos(String Usuario) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = Usuario;
        consultasBaseDeDatos consulta = new BaseDeDatos();
        this.listaPedidosActivos = consulta.BuscarPedidosEnCurso(Usuario);
        this.jListPedidosEnCurso.setModel(listaPedidosActivos);
        this.listaPedidosAnteriores = consulta.BuscarPedidosAnteriores(cliente);
        this.jListPedidosEntregados.setModel(listaPedidosAnteriores);
        
        
    }
    public PantallaVerPedidos(String Usuario, String rest) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = Usuario;
        consultasBaseDeDatos consulta = new BaseDeDatos();
        this.listaPedidosActivos = consulta.BuscarPedidosEnCurso(Usuario);
        this.jListPedidosEnCurso.setModel(listaPedidosActivos);
        this.listaPedidosAnteriores = consulta.BuscarPedidosAnteriores(cliente);
        this.jListPedidosEntregados.setModel(listaPedidosAnteriores);
        res.setText(rest);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        res = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPedidosEnCurso = new javax.swing.JList();
        jButtonEstadoPedido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPedidosEntregados = new javax.swing.JList();
        jLabelPedidosEnCurso = new javax.swing.JLabel();
        jLabelPedidosEnCurso1 = new javax.swing.JLabel();
        jButtonAtras = new javax.swing.JButton();
        jButtonCalificar = new javax.swing.JButton();
        BotonAgregarFavorito = new javax.swing.JButton();
        BotonVerPedidosFavoritos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 690));
        setMinimumSize(new java.awt.Dimension(800, 690));

        jListPedidosEnCurso.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPedidosEnCurso);

        jButtonEstadoPedido.setText("Ver estado");
        jButtonEstadoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadoPedidoActionPerformed(evt);
            }
        });

        jListPedidosEntregados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListPedidosEntregados);

        jLabelPedidosEnCurso.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabelPedidosEnCurso.setText("Pedidos en curso");

        jLabelPedidosEnCurso1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabelPedidosEnCurso1.setText("Pedidos anteriores");

        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonCalificar.setText("Calificar");
        jButtonCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalificarActionPerformed(evt);
            }
        });

        BotonAgregarFavorito.setText("Agregar a favoritos");
        BotonAgregarFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarFavoritoActionPerformed(evt);
            }
        });

        BotonVerPedidosFavoritos.setText("Ver pedidos Favoritos");
        BotonVerPedidosFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerPedidosFavoritosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jButtonEstadoPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAtras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButtonCalificar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(231, 231, 231))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelPedidosEnCurso)
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelPedidosEnCurso1)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonVerPedidosFavoritos)
                        .addGap(154, 154, 154)
                        .addComponent(BotonAgregarFavorito, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAtras)
                .addGap(84, 84, 84)
                .addComponent(jLabelPedidosEnCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEstadoPedido)
                .addGap(49, 49, 49)
                .addComponent(jLabelPedidosEnCurso1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAgregarFavorito, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonVerPedidosFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEstadoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadoPedidoActionPerformed
        
        if(this.jListPedidosEnCurso.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un pedido");
        }
        else {
        EstadoPedido p = new EstadoPedido(Integer.parseInt(this.jListPedidosEnCurso.getSelectedValue().toString()), cliente, res.getText());
        p.setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_jButtonEstadoPedidoActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
       
        PantallaClienteInicio p = new PantallaClienteInicio(cliente);
        p.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalificarActionPerformed
        
        if(this.jListPedidosEntregados.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un pedido");
        }
        else {
        consultasBaseDeDatos consulta = new BaseDeDatos();
        rest = consulta.ObternerRestauranteDomicilio(Integer.parseInt(this.jListPedidosEntregados.getSelectedValue().toString()));
        domdoc = consulta.ObternerDomiciliarioDomicilio(Integer.parseInt(this.jListPedidosEntregados.getSelectedValue().toString()));
        PantallaSatisfacción p = new PantallaSatisfacción(rest, domdoc, cliente);
        p.setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_jButtonCalificarActionPerformed

    private void BotonAgregarFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarFavoritoActionPerformed
        // TODO add your handling code here:
        
        if(this.jListPedidosEnCurso.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un pedido");
        }
        else {
            consultasBaseDeDatos consulta = new BaseDeDatos();
            if(consulta.agregarPedidoAFavoritos(cliente,this.jListPedidosEnCurso.getSelectedValue().toString() )){
                JOptionPane.showMessageDialog(null, "Se agrego correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "error al agregar a favoritos");
            }
        
        
        }
        
    }//GEN-LAST:event_BotonAgregarFavoritoActionPerformed

    private void BotonVerPedidosFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerPedidosFavoritosActionPerformed
        // TODO add your handling code here:
        PedidosFavoritos p = new PedidosFavoritos(cliente);
        p.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_BotonVerPedidosFavoritosActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaVerPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarFavorito;
    private javax.swing.JButton BotonVerPedidosFavoritos;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonCalificar;
    private javax.swing.JButton jButtonEstadoPedido;
    private javax.swing.JLabel jLabelPedidosEnCurso;
    private javax.swing.JLabel jLabelPedidosEnCurso1;
    private javax.swing.JList jListPedidosEnCurso;
    private javax.swing.JList jListPedidosEntregados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel res;
    // End of variables declaration//GEN-END:variables
}
