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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author gato
 */
public class PantallaCrearCliente extends javax.swing.JFrame {

    /**
     * Creates new form PantallaCrearCliente
     */
    public PantallaCrearCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        transparenciaDelBoton();
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        TF_nombreUsuario = new javax.swing.JTextField();
        TF_contraseñaUsuario = new javax.swing.JTextField();
        TF_nombreDelCliente = new javax.swing.JTextField();
        TF_apellidoCliente = new javax.swing.JTextField();
        TF_direccionCliente = new javax.swing.JTextField();
        TF_correoCliente = new javax.swing.JTextField();
        TF_tarjetaCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BotonRegistrarUsuario = new javax.swing.JButton();
        BotonRegresarAPantallaInico = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TF_nombreUsuario.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        TF_nombreUsuario.setToolTipText("");
        TF_nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_nombreUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(TF_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 420, 40));
        getContentPane().add(TF_contraseñaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 420, 40));
        getContentPane().add(TF_nombreDelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 420, 40));
        getContentPane().add(TF_apellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 420, 40));
        getContentPane().add(TF_direccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 420, 40));
        getContentPane().add(TF_correoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 420, 40));
        getContentPane().add(TF_tarjetaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 420, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroCliente.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        BotonRegistrarUsuario.setBorder(null);
        BotonRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarCliente(evt);
            }
        });
        getContentPane().add(BotonRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 170, 60));

        BotonRegresarAPantallaInico.setBorder(null);
        BotonRegresarAPantallaInico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarAPantallaInicoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonRegresarAPantallaInico, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 110, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistrarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarCliente
        // TODO add your handling code here:
        //agregar cliente a las tablas
        
        // validar que los espacios esten llenos
       
        if(TF_nombreUsuario.getText() == null || TF_nombreUsuario.getText().equals("") ||
           TF_contraseñaUsuario.getText() == null || TF_contraseñaUsuario.getText().equals("") ||
           TF_nombreDelCliente.getText() == null || TF_nombreDelCliente.getText().equals("") ||
           TF_apellidoCliente.getText() == null || TF_apellidoCliente.getText().equals("") ||
           TF_direccionCliente.getText() == null || TF_direccionCliente.getText().equals("") ||
           TF_correoCliente.getText() == null || TF_correoCliente.getText().equals("")
           
                
               )
        {
            JOptionPane.showMessageDialog(null, "Tiene que llenar todos los espacios");
            return;
        }
        else
        {
            
            
            if(!TF_tarjetaCliente.getText().equals(""))
            {
                if(TF_tarjetaCliente.getText().length() < 13 || TF_tarjetaCliente.getText().length() > 19){
                     JOptionPane.showMessageDialog(null, "la tarjeta no es valida (min 13 digitos)");
                     return;
                }
                
                if(!tarjetaCorrecta()){
                    JOptionPane.showMessageDialog(null, "la tarjeta no es valida");
                    return;
                }
                
            }
            //verificar tarjeta tamaño
            
            
            
                    
             //
            //verificar tarjeta digitos
            
            
            consultasBaseDeDatos consulta = new BaseDeDatos();
            //
            //verificar correo
            if(!consulta.correoCorrecto(TF_correoCliente.getText())){
                JOptionPane.showMessageDialog(null, "el correo no es valido");
            return;
            }
            
        
        
        LocalDate fecha = LocalDate.now();
        String fechaCreacion = String.valueOf(fecha.getDayOfMonth())+"/"+String.valueOf(fecha.getMonthValue())+"/"+String.valueOf(fecha.getYear());
        //ACA ESTEFANIA 
            if( consulta.CrearUsuario(TF_nombreUsuario.getText(), TF_contraseñaUsuario.getText(), "C", "correoparacambiar@hotmail.com",fechaCreacion) == true )
            {
                if(consulta.CrearCliente(TF_nombreUsuario.getText(), TF_nombreDelCliente.getText(), TF_apellidoCliente.getText(), TF_direccionCliente.getText()) == true)
                {
                    InicioSesion nuevaInicioSesion = new InicioSesion();
                    nuevaInicioSesion.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Se creo el usuario con exito");
                    
                }
                else
                {
                    InicioSesion nuevaInicioSesion = new InicioSesion();
                    nuevaInicioSesion.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Error al crear el cliente");
                }
                           
            }
            else
            {
                InicioSesion nuevaInicioSesion = new InicioSesion();
                    nuevaInicioSesion.setVisible(true);
                    this.dispose();
                JOptionPane.showMessageDialog(null, "Error al crear el usuario");
            }
            
        }
    }//GEN-LAST:event_BotonRegistrarCliente

    private void TF_nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_nombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_nombreUsuarioActionPerformed

    private void BotonRegresarAPantallaInicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarAPantallaInicoActionPerformed
        // TODO add your handling code here:
        
        InicioSesion nuevaInicioSesion = new InicioSesion();
                    nuevaInicioSesion.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_BotonRegresarAPantallaInicoActionPerformed

    public void transparenciaDelBoton(){
        BotonRegistrarUsuario.setOpaque(false);
        BotonRegistrarUsuario.setBackground(new Color(0,0,0,0));
        
        BotonRegresarAPantallaInico.setOpaque(false);
        BotonRegresarAPantallaInico.setBackground(new Color(0,0,0,0));
        
     
    }
    
    
    
    public boolean tarjetaCorrecta(){
     //verificar tarjeta digitos
            
            String str = TF_tarjetaCliente.getText();
            String reg = "\\s*([0-9])*";
            String[] res = str.split(reg);
            Boolean bien =true;
            for (String out : res) {
                if (!"".equals(out)) {
                   // System.out.print(out);
                   // System.out.println("");
                    bien =false;
                    
                }
            }
            if(!bien)
            {
                JOptionPane.showMessageDialog(null, "la tarjeta no es valida (solo numeros)");
                return bien;
            }
            return bien;
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
            java.util.logging.Logger.getLogger(PantallaCrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCrearCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegistrarUsuario;
    private javax.swing.JButton BotonRegresarAPantallaInico;
    private javax.swing.JTextField TF_apellidoCliente;
    private javax.swing.JTextField TF_contraseñaUsuario;
    private javax.swing.JTextField TF_correoCliente;
    private javax.swing.JTextField TF_direccionCliente;
    private javax.swing.JTextField TF_nombreDelCliente;
    private javax.swing.JTextField TF_nombreUsuario;
    private javax.swing.JTextField TF_tarjetaCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
