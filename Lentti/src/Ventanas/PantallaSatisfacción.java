/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javax.swing.JOptionPane;
import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Tony
 */
public class PantallaSatisfacción extends javax.swing.JFrame {

    String prestaurante;
    String pdomiciliario;
    String clientep;
    String pedido;

    /**
     * Creates new form PantallaSatisfacción
     */
    public PantallaSatisfacción() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public PantallaSatisfacción(String restaurante, String domiDoc, String cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.prestaurante = restaurante;
        this.pdomiciliario = domiDoc;
        this.clientep = cliente;
    }
    
    public PantallaSatisfacción(String restaurante, String domiDoc, String cliente, String idPedido) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.prestaurante = restaurante;
        this.pdomiciliario = domiDoc;
        this.clientep = cliente;
        this.pedido = idPedido;
        
        System.out.println("restaurante: " + this.prestaurante);
        System.out.println("domiciliaroi: " + this.pdomiciliario);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jComboBox3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jComboBox3.setMaximumRowCount(5);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4", "5" }));
        jComboBox3.setToolTipText("");
        jComboBox3.setAlignmentX(1.0F);
        jComboBox3.setAlignmentY(1.0F);
        jComboBox3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 690));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel2.setText("Calificar restaurante:");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel3.setText("Calificar domiciliario:");

        jComboBox1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jComboBox1.setMaximumRowCount(6);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4", "5" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setAlignmentX(1.0F);
        jComboBox1.setAlignmentY(1.0F);
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jComboBox4.setMaximumRowCount(6);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4", "5" }));
        jComboBox4.setToolTipText("");
        jComboBox4.setAlignmentX(1.0F);
        jComboBox4.setAlignmentY(1.0F);
        jComboBox4.setBorder(null);
        jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(240, 0, 0));
        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enviar");
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setText("Añadir comentario (opcional)");

        jLabel4.setText("Añadir comentario (opcional)");

        jButton2.setBackground(new java.awt.Color(240, 0, 0));
        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(327, 327, 327))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(329, 329, 329))
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jButton1)
                .addGap(54, 54, 54)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (this.jComboBox1.getSelectedItem() == "Seleccionar" && this.jComboBox4.getSelectedItem() != "Seleccionar") {
            JOptionPane.showMessageDialog(null, "Por favor seleccione la calificacion para restaurante");
        }
        if (this.jComboBox4.getSelectedItem() == "Seleccionar" && this.jComboBox1.getSelectedItem() != "Seleccionar") {
            JOptionPane.showMessageDialog(null, "Por favor seleccione la calificacion para domiciliario");
        }
        if (this.jComboBox1.getSelectedItem() == "Seleccionar" && this.jComboBox4.getSelectedItem() == "Seleccionar") {
            JOptionPane.showMessageDialog(null, "Por favor seleccione la calificacion para restaurante y domiciliario");
        }
        if (this.jComboBox1.getSelectedItem() != "Seleccionar" && this.jComboBox4.getSelectedItem() != "Seleccionar") {
            
            String fecha;
            LocalDateTime registro = LocalDateTime.now();
            int dia,mes,year;
            dia = registro.getDayOfMonth();
            mes = registro.getMonthValue();
            year = registro.getYear();
            fecha = dia+"/"+mes+"/"+year;
            System.out.println("fecha actual  "+ fecha);
            
            
            consultasBaseDeDatos consulta = new BaseDeDatos();
            
            //ver si tiene fecha el pedido, si no tiene se pone la fecha actual, si tiene se comparan
            String fechaResena = consulta.darHoraResena(pedido);
            
            if (fechaResena == null)
            {
              // se crea normalmente
                System.out.println("se crea normalmente");
                consulta.calificarRestaurante(pedido, clientep, prestaurante, Integer.parseInt(this.jComboBox1.getSelectedItem().toString()),this.jTextArea2.getText() , fecha);
                consulta.calificarDomiciliario(pedido, clientep, pdomiciliario, Integer.parseInt(this.jComboBox1.getSelectedItem().toString()),this.jTextArea2.getText() , fecha);
                JOptionPane.showMessageDialog(null, "Gracias por sus calificaciones");
                PantallaVerPedidos p = new PantallaVerPedidos(clientep);
                p.setVisible(true);
                this.dispose();
            }
            else
            {
                String[] partes = fechaResena.split("/");
                if( partes[0].equals(  Integer.toString(dia)  ) && partes[1].equals(  Integer.toString(dia)  ) && partes[2].equals(  Integer.toString(dia)  )   ){
                    System.out.println("se crea por la fecha");
                    consulta.calificarRestaurante(pedido, clientep, prestaurante, Integer.parseInt(this.jComboBox1.getSelectedItem().toString()),this.jTextArea2.getText() , fecha);
                    consulta.calificarDomiciliario(pedido, clientep, pdomiciliario, Integer.parseInt(this.jComboBox1.getSelectedItem().toString()),this.jTextArea2.getText() , fecha);
                    JOptionPane.showMessageDialog(null, "Gracias por sus calificaciones");
                    PantallaVerPedidos p = new PantallaVerPedidos(clientep);
                    p.setVisible(true);
                    this.dispose();
                }
                else
                {
                    System.out.println("no se pudo");
                    JOptionPane.showMessageDialog(null, "ya no puede modificar su calificacion");
                    PantallaVerPedidos p = new PantallaVerPedidos(clientep);
                    p.setVisible(true);
                    this.dispose();
                }
            }
            

            
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        PantallaVerPedidos p = new PantallaVerPedidos(clientep);
        p.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaSatisfacción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaSatisfacción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaSatisfacción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaSatisfacción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaSatisfacción().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
