/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Controlador.consultasBaseDeDatos;
import Modelo.BaseDeDatos;
import Modelo.CorreoElectronico;
import javax.mail.MessagingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samyf
 */
public class PruebasLentti {
    
    public PruebasLentti() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //test de ValidarUsuarioCorreo
  /*  @Test 
   public void ValidarUsuarioCorreo() throws MessagingException
   {
        System.out.println("ValidarUsuarioCorreo");
        String a = "admin1";
        consultasBaseDeDatos consulta = new BaseDeDatos();
        CorreoElectronico nuevo= new CorreoElectronico();
        boolean resultado= nuevo.enviarCorreoRecuperar(1232, consulta.ObtenerCorreo(a));
        boolean expResult = true;
        assertEquals(expResult, resultado);
   }
   //test de TiempoRecuperarCuenta
    @Test 
   public void TiempoRecuperarCuenta() throws MessagingException
   {
       Long Tinicio, Tfinal;
       boolean resultado=false;
       Tinicio= System.currentTimeMillis();
        System.out.println("TiempoRecuperarCuenta");
        String a = "admin1";
        String b ="1";
        int codigo =1234;
        consultasBaseDeDatos consulta = new BaseDeDatos();
        CorreoElectronico nuevo= new CorreoElectronico();
        nuevo.enviarCorreoRecuperar(codigo, consulta.ObtenerCorreo(a));
        consulta.ModificarContrasena(a, b);
        Tfinal=System.currentTimeMillis();
        if(((Tfinal-Tinicio)/1000) < 60)
        {
            resultado= true;
            
        }
        boolean expResult = true;
        assertEquals(expResult, resultado);
   }*/
    
   @Test 
     public void AgregarPlatoAlCarroCompras() throws MessagingException
   {
        
        String u = "estefaniaAristizabal";
        String r= "Dominos";
        String p = "Pizza pepperoni mediana";
        float cantidad = 1;
        consultasBaseDeDatos consulta = new BaseDeDatos();
        boolean resultado= consulta.agregarPedidoCC(u, r, p, cantidad);
        System.out.println("result" + resultado);
        boolean expResult = true;
        assertEquals(expResult, resultado);
   }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
