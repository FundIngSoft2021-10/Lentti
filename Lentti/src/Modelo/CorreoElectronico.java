/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Panel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author samyf
 */
public class CorreoElectronico {
    final String cuenta="lenttiapp@gmail.com";
    final String contra="Cuentalentti123";

    public CorreoElectronico() {
    }
    
    
    
    public boolean enviarCorreoRecuperar(int codigo, String enviarA) throws AddressException, MessagingException
    {
        boolean resultado=false;
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        String receptor = enviarA;
        String asunto = "Recuperación contraseña lentti ";
        String mensaje="Hola, querido usuario.\n\n"+
                       "Hemos recibido una confirmación de solicitud para cambio de contraseña en nuestros servidores. Su código de recuperación de cuenta es:\n" + 
                       Integer.toString(codigo)+"\n "+
                       "Debe ingresar este código en el espacio que le sigue en donde escribio su usuario. Después de ingresar al sistema se le pedirá que ingrese una nueva contraseña.\n\n"+
                       "Atentamente,\n"+"Lentti App.";
        
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (cuenta));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(cuenta,contra);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            resultado= true;
            JOptionPane.showMessageDialog(null, "Se ha enviado codigo de seguridad");
            
            
        } catch (AddressException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
