/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.consultasBaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author samyf
 */
public class BaseDeDatos implements consultasBaseDeDatos {
    String host= "jdbc:postgresql://by7snyowz8hpiul0czun-postgresql.services.clever-cloud.com:5432/by7snyowz8hpiul0czun";
    String usuario ="ukq1feptpfh0wdl7wm7b";
    String contrasena="k1A1ESjjj11G0Ti9aCma";

    public BaseDeDatos() {
    }
    
    //Implementación de la interface consultasBaseDeDatos

    @Override
    public boolean ValidarInicioSesion(String pUsuario, String pContrasena, String pTipo) {
        boolean resultado=false;
        try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta =
                      "SELECT usuario,contrasena,tipo FROM lenttiusuario ";
                  ResultSet result = st.executeQuery(consulta);
                  while(result.next()) 
                  {
                       
                      if(pUsuario.equals(result.getString("usuario")) && pContrasena.equals(result.getString("contrasena")) && pTipo.equals(result.getString("tipo")))
                      {
                          resultado=true;
                      }
                      
                  }
                  result.close();
                  st.close();
                  conexion.close();
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        return resultado;
    }
    
}
