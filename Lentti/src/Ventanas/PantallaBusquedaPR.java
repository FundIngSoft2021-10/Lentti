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
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
/**
 *
 * @author Estefania
 */
public class PantallaBusquedaPR extends javax.swing.JFrame {
    
 
    String nombrePlatoS, descripcionPlatoS,nombreRestS, descripcionRestS, usuario;
    float costoEnvioRestS, precioPlatoS;
    
    public PantallaBusquedaPR() {
        initComponents();
        transparenciaDelBoton();
        inicioVentana();
        this.setLocationRelativeTo(null);   
    }
     public PantallaBusquedaPR(String pUsuario) {
        initComponents();
        transparenciaDelBoton();
        inicioVentana();
        usuario = pUsuario;
        this.setLocationRelativeTo(null);   
    }
    
    /*funcion para agregar icono del programa*/
    public Image getIconImage()
    {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/lentti.png"));
        return retValue;
    }
    public void inicioVentana(){
        // PANTALLA 1: BUSCADOR DE PRODUCTOS/RESTAURANTES
        FondoBuscador.setVisible(true);
        BotonBuscar.setVisible(true);
        EscribirConsulta.setVisible(true);
        BotonAtrasP1.setVisible(true);
        
        //Se desabilita pantalla 2
        FondoMostrarOpciones.setVisible(false);
        InfoBusqueda.setVisible(false);
        ListaBusquedaRestaurantes.setVisible(false);
        BotonRealizarOtra.setVisible(false);
        BotonVerRestaurante.setVisible(false);
        BotonAtrasP2.setVisible(false);
        FotoRestaurante.setVisible(false);
        NombreRestaurante.setVisible(false);
        DescripcionRestaurante.setVisible(false);
        TiempoRestaurante.setVisible(false);
        PrecioDRestaurante.setVisible(false);
        Tapar.setVisible(false);
        
        //Se desabilita pantalla 3
        FondoAgregarCarrito.setVisible(false);
        BotonAtrasBusqAnt.setVisible(false);
        BotonAgregarPlatoCC.setVisible(false);
        Confirmacion.setVisible(false);
        BotonOk.setVisible(false); 
        ListaDePlatos.setVisible(false);
        TextListaPlatos.setVisible(false);
        FotoPlato.setVisible(false);
        TextPrecio.setVisible(false);
        PrecioPlato.setVisible(false);
        NombrePlato.setVisible(false);
        DescripcionPlato.setVisible(false);
        PrecioP3.setVisible(false);
        NombreP3.setVisible(false);
        DescripcionPlatoP3.setVisible(false);
        Tapar2.setVisible(false);
        TextCostoE.setVisible(false);
    }
    
    public void mostrarPantalla2(){
        
        // PANTALLA 1: BUSCADOR DE PRODUCTOS/RESTAURANTES
        FondoBuscador.setVisible(false);
        BotonBuscar.setVisible(false);
        EscribirConsulta.setVisible(false);
        BotonAtrasP1.setVisible(false);
        
        //Se desabilita pantalla 2
        FondoMostrarOpciones.setVisible(true);
        InfoBusqueda.setVisible(true);
        ListaBusquedaRestaurantes.setVisible(true);
        BotonRealizarOtra.setVisible(true);
        BotonVerRestaurante.setVisible(true);
        BotonAtrasP2.setVisible(true);
        FotoRestaurante.setVisible(true);
        NombreRestaurante.setVisible(true);
        DescripcionRestaurante.setVisible(true);
        TiempoRestaurante.setVisible(true);
        PrecioDRestaurante.setVisible(true);
        Tapar.setVisible(true);
        

        
        //Se desabilita pantalla 3
        FondoAgregarCarrito.setVisible(false);
        BotonAtrasBusqAnt.setVisible(false);
        BotonAgregarPlatoCC.setVisible(false);
        Confirmacion.setVisible(false);
        BotonOk.setVisible(false);
        ListaDePlatos.setVisible(false);
        TextListaPlatos.setVisible(false);
        FotoPlato.setVisible(false);
        TextPrecio.setVisible(false);
        PrecioPlato.setVisible(false);
        NombrePlato.setVisible(false);
        DescripcionPlato.setVisible(false);
        PrecioP3.setVisible(false);
        NombreP3.setVisible(false);
        DescripcionPlatoP3.setVisible(false);
        Tapar2.setVisible(false);
        TextCostoE.setVisible(false);
        
    }
    
    public void mostrarPantalla3(){
         // PANTALLA 1: se desabilita
        FondoBuscador.setVisible(false);
        BotonBuscar.setVisible(false);
        EscribirConsulta.setVisible(false);
        BotonAtrasP1.setVisible(false);
        
        //PANTALLA 2: se desabilita 
        FondoMostrarOpciones.setVisible(false);
        InfoBusqueda.setVisible(false);
        ListaBusquedaRestaurantes.setVisible(false);
        BotonRealizarOtra.setVisible(false);
        BotonVerRestaurante.setVisible(false);
        BotonAtrasP2.setVisible(false);
        FotoRestaurante.setVisible(false);
        NombreRestaurante.setVisible(false);
        DescripcionRestaurante.setVisible(false);
        TiempoRestaurante.setVisible(false);
        PrecioDRestaurante.setVisible(false);
        Tapar.setVisible(false);
        
        //PANTALLA 3: se activa
        FondoAgregarCarrito.setVisible(true);
        BotonAtrasBusqAnt.setVisible(true);
        BotonAgregarPlatoCC.setVisible(false);
        Confirmacion.setVisible(false);
        BotonOk.setVisible(false);
        ListaDePlatos.setVisible(true);
        TextListaPlatos.setVisible(true);
        FotoPlato.setVisible(false);
        TextPrecio.setVisible(false);
        PrecioPlato.setVisible(false);
        NombrePlato.setVisible(false);
        DescripcionPlato.setVisible(false);
        PrecioP3.setVisible(true);
        NombreP3.setVisible(true);
        DescripcionPlatoP3.setVisible(true);
        Tapar2.setVisible(true);
        TextCostoE.setVisible(true);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrecioP3 = new javax.swing.JTextField();
        NombreP3 = new javax.swing.JTextField();
        TextCostoE = new javax.swing.JTextField();
        DescripcionPlatoP3 = new javax.swing.JTextField();
        BotonOk = new javax.swing.JButton();
        Confirmacion = new javax.swing.JTextField();
        Tapar2 = new javax.swing.JTextField();
        Tapar = new javax.swing.JTextField();
        NombrePlato = new javax.swing.JTextField();
        DescripcionPlato = new javax.swing.JTextField();
        PrecioPlato = new javax.swing.JTextField();
        TextPrecio = new javax.swing.JTextField();
        TextListaPlatos = new javax.swing.JTextField();
        ListaDePlatos = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        NombreRestaurante = new javax.swing.JTextField();
        DescripcionRestaurante = new javax.swing.JTextField();
        TiempoRestaurante = new javax.swing.JTextField();
        PrecioDRestaurante = new javax.swing.JTextField();
        BotonBuscar = new javax.swing.JButton();
        BotonAgregarPlatoCC = new javax.swing.JButton();
        BotonAtrasP2 = new javax.swing.JButton();
        BotonAtrasP1 = new javax.swing.JButton();
        BotonAtrasBusqAnt = new javax.swing.JButton();
        EscribirConsulta = new javax.swing.JTextField();
        ListaBusquedaRestaurantes = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        BotonVerRestaurante = new javax.swing.JButton();
        InfoBusqueda = new javax.swing.JTextField();
        BotonRealizarOtra = new javax.swing.JButton();
        FotoPlato = new javax.swing.JLabel();
        FotoRestaurante = new javax.swing.JLabel();
        FondoMostrarOpciones = new javax.swing.JLabel();
        FondoAgregarCarrito = new javax.swing.JLabel();
        FondoBuscador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PrecioP3.setEditable(false);
        PrecioP3.setBackground(new java.awt.Color(38, 75, 109));
        PrecioP3.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        PrecioP3.setForeground(new java.awt.Color(255, 255, 255));
        PrecioP3.setBorder(null);
        getContentPane().add(PrecioP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 140, 30));

        NombreP3.setEditable(false);
        NombreP3.setBackground(new java.awt.Color(38, 75, 109));
        NombreP3.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        NombreP3.setForeground(new java.awt.Color(255, 255, 255));
        NombreP3.setBorder(null);
        getContentPane().add(NombreP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 550, 40));

        TextCostoE.setBackground(new java.awt.Color(38, 75, 109));
        TextCostoE.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        TextCostoE.setForeground(new java.awt.Color(255, 255, 255));
        TextCostoE.setText("Costo envío:");
        TextCostoE.setBorder(null);
        getContentPane().add(TextCostoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, -1));

        DescripcionPlatoP3.setEditable(false);
        DescripcionPlatoP3.setBackground(new java.awt.Color(38, 75, 109));
        DescripcionPlatoP3.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        DescripcionPlatoP3.setForeground(new java.awt.Color(255, 255, 255));
        DescripcionPlatoP3.setBorder(null);
        getContentPane().add(DescripcionPlatoP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 540, 30));

        BotonOk.setBackground(new java.awt.Color(255, 255, 255));
        BotonOk.setFont(new java.awt.Font("Yu Gothic", 0, 36)); // NOI18N
        BotonOk.setText("Ok");
        BotonOk.setBorder(null);
        BotonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonOkMouseClicked(evt);
            }
        });
        getContentPane().add(BotonOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 140, 40));

        Confirmacion.setBackground(new java.awt.Color(114, 203, 131));
        Confirmacion.setFont(new java.awt.Font("Yu Gothic", 1, 36)); // NOI18N
        Confirmacion.setForeground(new java.awt.Color(255, 255, 255));
        Confirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Confirmacion.setText("SE AGREGÓ CORRECTAMENTE");
        Confirmacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Confirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmacionActionPerformed(evt);
            }
        });
        getContentPane().add(Confirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 600, 150));

        Tapar2.setEditable(false);
        Tapar2.setBackground(new java.awt.Color(246, 243, 243));
        Tapar2.setBorder(null);
        getContentPane().add(Tapar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 280, 70));

        Tapar.setBackground(new java.awt.Color(235, 235, 235));
        Tapar.setBorder(null);
        getContentPane().add(Tapar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 230, 60));

        NombrePlato.setEditable(false);
        NombrePlato.setBackground(new java.awt.Color(246, 243, 243));
        NombrePlato.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        NombrePlato.setBorder(null);
        getContentPane().add(NombrePlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 380, 30));

        DescripcionPlato.setEditable(false);
        DescripcionPlato.setBackground(new java.awt.Color(246, 243, 243));
        DescripcionPlato.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        DescripcionPlato.setBorder(null);
        getContentPane().add(DescripcionPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 480, 30));

        PrecioPlato.setEditable(false);
        PrecioPlato.setBackground(new java.awt.Color(246, 243, 243));
        PrecioPlato.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        PrecioPlato.setBorder(null);
        getContentPane().add(PrecioPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        TextPrecio.setEditable(false);
        TextPrecio.setBackground(new java.awt.Color(246, 243, 243));
        TextPrecio.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        TextPrecio.setText("Precio:");
        TextPrecio.setBorder(null);
        getContentPane().add(TextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 100, -1));

        TextListaPlatos.setEditable(false);
        TextListaPlatos.setBackground(new java.awt.Color(255, 254, 251));
        TextListaPlatos.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        TextListaPlatos.setText("Lista de platos disponibles:");
        TextListaPlatos.setBorder(null);
        getContentPane().add(TextListaPlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 440, -1));

        jList2.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        ListaDePlatos.setViewportView(jList2);

        getContentPane().add(ListaDePlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 660, 100));

        NombreRestaurante.setEditable(false);
        NombreRestaurante.setBackground(new java.awt.Color(235, 235, 235));
        NombreRestaurante.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        NombreRestaurante.setBorder(null);
        NombreRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreRestauranteActionPerformed(evt);
            }
        });
        getContentPane().add(NombreRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 550, -1));

        DescripcionRestaurante.setEditable(false);
        DescripcionRestaurante.setBackground(new java.awt.Color(235, 235, 235));
        DescripcionRestaurante.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        DescripcionRestaurante.setBorder(null);
        getContentPane().add(DescripcionRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 490, 70));

        TiempoRestaurante.setEditable(false);
        TiempoRestaurante.setBackground(new java.awt.Color(235, 235, 235));
        TiempoRestaurante.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        TiempoRestaurante.setBorder(null);
        getContentPane().add(TiempoRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 210, -1));

        PrecioDRestaurante.setEditable(false);
        PrecioDRestaurante.setBackground(new java.awt.Color(235, 235, 235));
        PrecioDRestaurante.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        PrecioDRestaurante.setBorder(null);
        getContentPane().add(PrecioDRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 210, -1));

        BotonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonBuscarMouseClicked(evt);
            }
        });
        getContentPane().add(BotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 40));

        BotonAgregarPlatoCC.setBorder(null);
        BotonAgregarPlatoCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAgregarPlatoCCMouseClicked(evt);
            }
        });
        getContentPane().add(BotonAgregarPlatoCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 260, 40));

        BotonAtrasP2.setBackground(new java.awt.Color(255, 254, 251));
        BotonAtrasP2.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        BotonAtrasP2.setText("<<  Atrás");
        BotonAtrasP2.setBorder(null);
        BotonAtrasP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAtrasP2MouseClicked(evt);
            }
        });
        getContentPane().add(BotonAtrasP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        BotonAtrasP1.setBackground(new java.awt.Color(255, 255, 255));
        BotonAtrasP1.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        BotonAtrasP1.setText("<<  Atrás");
        BotonAtrasP1.setBorder(null);
        BotonAtrasP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtrasP1ActionPerformed(evt);
            }
        });
        getContentPane().add(BotonAtrasP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        BotonAtrasBusqAnt.setBackground(new java.awt.Color(246, 243, 243));
        BotonAtrasBusqAnt.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        BotonAtrasBusqAnt.setText("<< Atrás");
        BotonAtrasBusqAnt.setBorder(null);
        BotonAtrasBusqAnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAtrasBusqAntMouseClicked(evt);
            }
        });
        getContentPane().add(BotonAtrasBusqAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, -1));

        EscribirConsulta.setBackground(new java.awt.Color(235, 235, 235));
        EscribirConsulta.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        EscribirConsulta.setBorder(null);
        getContentPane().add(EscribirConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 320, 40));

        ListaBusquedaRestaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaBusquedaRestaurantesMouseClicked(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        ListaBusquedaRestaurantes.setViewportView(jList1);

        getContentPane().add(ListaBusquedaRestaurantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 720, 100));

        BotonVerRestaurante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonVerRestauranteMouseClicked(evt);
            }
        });
        getContentPane().add(BotonVerRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 230, 40));

        InfoBusqueda.setEditable(false);
        InfoBusqueda.setBackground(new java.awt.Color(235, 235, 235));
        InfoBusqueda.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        InfoBusqueda.setText("jTextField1");
        InfoBusqueda.setBorder(null);
        InfoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoBusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(InfoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 360, 40));

        BotonRealizarOtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRealizarOtraMouseClicked(evt);
            }
        });
        getContentPane().add(BotonRealizarOtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 390, 50));
        getContentPane().add(FotoPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 230, 240));
        getContentPane().add(FotoRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, 150));

        FondoMostrarOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BusquedaPR2.png"))); // NOI18N
        getContentPane().add(FondoMostrarOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FondoAgregarCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarPedidos.png"))); // NOI18N
        getContentPane().add(FondoAgregarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FondoBuscador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BusquedaPR.png"))); // NOI18N
        getContentPane().add(FondoBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBuscarMouseClicked
        // TODO add your handling code here:
         mostrarPantalla2(); 
         //Se limpian los textField
         NombreRestaurante.setText(null);
         DescripcionRestaurante.setText(null);
         TiempoRestaurante.setText(null);
         PrecioDRestaurante.setText(null);
         
         if(!EscribirConsulta.getText().equals(null))
           InfoBusqueda.setText(EscribirConsulta.getText());
         else 
             System.out.println("ERROR");
        
        DefaultListModel restaurantes = new DefaultListModel<>();
        restaurantes.clear();
        consultasBaseDeDatos consulta = new BaseDeDatos();
        restaurantes= consulta.BuscarPalabrasClave(EscribirConsulta.getText());
        restaurantes.addElement("holaa");
        jList1.setModel(restaurantes); //Muestra los restaurantes que coinciden en la busqueda*/
       
    }//GEN-LAST:event_BotonBuscarMouseClicked

    private void InfoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InfoBusquedaActionPerformed
   
    private void BotonVerRestauranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVerRestauranteMouseClicked
        
        mostrarPantalla3();
        DefaultListModel platos = new DefaultListModel<>();
        platos.clear();
        consultasBaseDeDatos consulta = new BaseDeDatos();
        platos= consulta.darNombrePlatos(nombreRestS);
        platos.addElement("Pruebita");
        jList2.setModel(platos); //Muestra los platos de un restaurante seleccionado 
        //Muestra la informacion del restaurante en la pantalla3
        
        NombreP3.setText(nombreRestS);
        PrecioP3.setText(Float.toString(costoEnvioRestS));
        //FALTA PRECIO Y TIEMPO EN RESTAURANTE
        
    }//GEN-LAST:event_BotonVerRestauranteMouseClicked

    private void BotonAtrasBusqAntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAtrasBusqAntMouseClicked
        //BOTON ATRAS BUSQUEDA ANTERIOR CUANDO ESTA EN EL CARRITO
        mostrarPantalla2();
        Tapar.setVisible(false);
    }//GEN-LAST:event_BotonAtrasBusqAntMouseClicked

    private void BotonAtrasP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAtrasP2MouseClicked
        inicioVentana();
    }//GEN-LAST:event_BotonAtrasP2MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
       //A medida que se van seleccionando opciones de la lista se cambia la informacion
       NombreRestaurante.setText(jList1.getSelectedValue().toString());
       consultasBaseDeDatos consulta = new BaseDeDatos();
       
       nombreRestS = jList1.getSelectedValue().toString();
       descripcionRestS = consulta.darDescripcionRest(nombreRestS);
       costoEnvioRestS = consulta.darCostoEnvioRest(nombreRestS);
       DescripcionRestaurante.setText(descripcionRestS);
       PrecioDRestaurante.setText(Float.toString(costoEnvioRestS));
       Tapar.setVisible(false);
    }//GEN-LAST:event_jList1MouseClicked

    private void ConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmacionActionPerformed

    private void BotonAgregarPlatoCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarPlatoCCMouseClicked
        // SI AGREGAN UN PEDIDO
        Confirmacion.setVisible(true);
        BotonOk.setVisible(true);
        
        //TODAVIA NO PUEDO CREAR EL PEDIDO PORQUE NO SE COMO ACCEDER AL USUARIO ACTUAL XD
        consultasBaseDeDatos consulta = new BaseDeDatos();
        
        //boolean seCreo = consulta.agregarPedidoCC(nUsuario, restSeleccionado.getNombre(), platoSeleccionado);
    }//GEN-LAST:event_BotonAgregarPlatoCCMouseClicked

    private void BotonOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOkMouseClicked
        // TODO add your handling code here:
        Confirmacion.setVisible(false);
        BotonOk.setVisible(false);
    }//GEN-LAST:event_BotonOkMouseClicked

    private void ListaBusquedaRestaurantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaBusquedaRestaurantesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaBusquedaRestaurantesMouseClicked

    private void NombreRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreRestauranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreRestauranteActionPerformed

    private void BotonRealizarOtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRealizarOtraMouseClicked
        // TODO add your handling code here:
        //Boton realizar otra busqueda - MUESTRA PANTALLA 1
        inicioVentana();
    }//GEN-LAST:event_BotonRealizarOtraMouseClicked

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        //Hasta que le de click a algun plato no muestra la información
        FotoPlato.setVisible(true);
        TextPrecio.setVisible(true);
        PrecioPlato.setVisible(true);
        NombrePlato.setVisible(true);
        DescripcionPlato.setVisible(true);
        Tapar2.setVisible(false);
        BotonAgregarPlatoCC.setVisible(true);
        
        //Tengo que mostrar la información del plato
        nombrePlatoS = jList2.getSelectedValue().toString();       
        consultasBaseDeDatos consulta = new BaseDeDatos();
        //Se pide la informacion del plato
        descripcionPlatoS = consulta.darDescripcionPlato(nombreRestS, nombrePlatoS);
        precioPlatoS = consulta.darPrecioPlato(nombreRestS, nombrePlatoS);
        //Se muestran los datos en la interfaz
        NombrePlato.setText(nombrePlatoS);
        DescripcionPlato.setText(descripcionPlatoS);
        PrecioPlato.setText(Float.toString(precioPlatoS));
        
        //OJO: FALTA LA IMAGEN

    }//GEN-LAST:event_jList2MouseClicked

    private void BotonAtrasP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtrasP1ActionPerformed
        // TODO add your handling code here:
        PantallaInicialCliente pantalla = new PantallaInicialCliente(usuario);
                    pantalla.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_BotonAtrasP1ActionPerformed

    
    public void transparenciaDelBoton(){
        BotonBuscar.setOpaque(false);
        BotonBuscar.setBackground(new Color(0,0,0,0));
        BotonRealizarOtra.setOpaque(false);
        BotonRealizarOtra.setBackground(new Color(0,0,0,0));
        BotonVerRestaurante.setOpaque(false);
        BotonVerRestaurante.setBackground(new Color(0,0,0,0));
        BotonAgregarPlatoCC.setOpaque(false);
        BotonAgregarPlatoCC.setBackground(new Color(0,0,0,0));
    
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
            java.util.logging.Logger.getLogger(PantallaBusquedaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaBusquedaPR().setVisible(true);
            }
        });
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarPlatoCC;
    private javax.swing.JButton BotonAtrasBusqAnt;
    private javax.swing.JButton BotonAtrasP1;
    private javax.swing.JButton BotonAtrasP2;
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonOk;
    private javax.swing.JButton BotonRealizarOtra;
    private javax.swing.JButton BotonVerRestaurante;
    private javax.swing.JTextField Confirmacion;
    private javax.swing.JTextField DescripcionPlato;
    private javax.swing.JTextField DescripcionPlatoP3;
    private javax.swing.JTextField DescripcionRestaurante;
    private javax.swing.JTextField EscribirConsulta;
    private javax.swing.JLabel FondoAgregarCarrito;
    private javax.swing.JLabel FondoBuscador;
    private javax.swing.JLabel FondoMostrarOpciones;
    private javax.swing.JLabel FotoPlato;
    private javax.swing.JLabel FotoRestaurante;
    private javax.swing.JTextField InfoBusqueda;
    private javax.swing.JScrollPane ListaBusquedaRestaurantes;
    private javax.swing.JScrollPane ListaDePlatos;
    private javax.swing.JTextField NombreP3;
    private javax.swing.JTextField NombrePlato;
    private javax.swing.JTextField NombreRestaurante;
    private javax.swing.JTextField PrecioDRestaurante;
    private javax.swing.JTextField PrecioP3;
    private javax.swing.JTextField PrecioPlato;
    private javax.swing.JTextField Tapar;
    private javax.swing.JTextField Tapar2;
    private javax.swing.JTextField TextCostoE;
    private javax.swing.JTextField TextListaPlatos;
    private javax.swing.JTextField TextPrecio;
    private javax.swing.JTextField TiempoRestaurante;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    // End of variables declaration//GEN-END:variables
}
