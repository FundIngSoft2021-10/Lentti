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
import javax.swing.DefaultListModel;

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
    public boolean ValidarInicioSesion(String pUsuario, String pContrasena, String pTipo) 
    {
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

    @Override
    public boolean CrearUsuario(String pUsuario, String pContrasena, String pTipo) 
    {
       boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "insert into lenttiUsuario values ( '"+ pUsuario + "' , '"+pContrasena + "', '" + pTipo + "');";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }

    @Override
    public boolean ModificarUsuario(String anteriorUsuario, String nuevoUsuario) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "UPDATE lenttiusuario  SET usuario= '"+ nuevoUsuario + "' WHERE usuario='"+anteriorUsuario+"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }

    @Override
    public boolean ModificarContrasena(String pUsuario, String nuevaContrasena) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "UPDATE lenttiusuario  SET contrasena= '"+ nuevaContrasena + "' WHERE usuario='"+pUsuario+"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }
    
    @Override
    public boolean CrearPlato( String restaurante, String nombrePlato,  String descripcion,float precio, String imagen) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "INSERT INTO plato VALUES ('"+ restaurante +"','"+ nombrePlato + "',"+ precio +", '" + descripcion +"', '"+ imagen +"');";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }
    @Override
    public boolean EliminarPlato( String nombrePlato) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "DELETE FROM plato WHERE nombrePlato = '"+ nombrePlato +"'; ";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }
    @Override
    public boolean ModificarNombrePlato(String nombrePlato, String nuevoNombre) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "UPDATE plato SET nombrePlato = '"+ nuevoNombre + "' WHERE nombrePlato = '"+ nombrePlato +"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }
    @Override
    public boolean ModificarPrecioPlato(String nombrePlato, String nuevoPrecio) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  Float precio = Float.parseFloat(nuevoPrecio);
                  String consulta = "UPDATE plato SET precio = "+ nuevoPrecio + " WHERE nombrePlato = '"+ nombrePlato +"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }
    @Override
    public boolean ModificarDescripcionPlato(String nombrePlato, String nuevaDescripcion) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "UPDATE plato SET descripcion = '"+ nuevaDescripcion + "' WHERE nombrePlato = '"+ nombrePlato +"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }
    @Override
    public boolean ModificarImagenPlato(String nombrePlato, String nuevaImagen) {
        boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "UPDATE plato SET imagen = '"+ nuevaImagen + "' WHERE nombrePlato = '"+ nombrePlato +"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }

    @Override
    public boolean EliminarCuenta(String pUsuario, String pTipo) {
       boolean resultado= false;
       try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "DELETE FROM lenttiusuario WHERE usuario='"+ pUsuario + "'AND tipo='" + pTipo +"';";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  resultado=true;
        }
        catch(Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado=false;
        }
       return resultado;
    }

    //Recibe un tipo de usario que quiere llenar la lista y el usuario actual para no listarlo
    @Override
    public DefaultListModel LlenarListaUsuarios(String pTipo,String pUsurioActual) {
        DefaultListModel lista=new DefaultListModel();
        
        try 
        {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta =
                      "SELECT usuario FROM lenttiusuario WHERE tipo='" + pTipo + "'";
                  ResultSet result = st.executeQuery(consulta);
                  while(result.next()) 
                  {
                      if(!result.getString("usuario").equals(pUsurioActual))
                      {
                          lista.addElement(result.getString("usuario"));
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
        
        return lista;
    }
    
    public boolean CrearCliente(String pUsuario, String pNombre, String pApellido, String pDireccion)
    {
        boolean sePudo = false;
        try {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "INSERT INTO cliente VALUES ('"+ pUsuario +"','"+ pNombre + "','"+ pApellido +"', '" + pDireccion +"');";
                  st.execute(consulta);
                  st.close();
                  conexion.close();
                  sePudo=true;
            
        } 
        catch (Exception e) {
             System.out.println("Errorx:"+e.getMessage());
            sePudo = false;
        }
        
        
        return sePudo;
    }
}
