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
import java.util.ArrayList;
import java.util.StringTokenizer;
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
    public boolean CrearPlato( String restaurante, String nombrePlato, String descripcion, float precio, String imagen) {
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
    public boolean CrearDomiciliario( String restaurante, String documento, String nombre, String telefono, String placaVehiculo , Float puntuacion, Float domiciliosEntregados) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO domiciliario VALUES ('"+ restaurante +"','"+ documento + "','"+ nombre +"', '" + telefono +"', '"+ placaVehiculo +"', "+ puntuacion + ","+ domiciliosEntregados +");";
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
    public boolean EliminarDomiciliario( String documento) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM domiciliario WHERE documento = '"+ documento +"'; ";
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

    public boolean CrearRestaurante (String nombreRestaurante, String password, String NIT, String direccion, String descripcion, float costoDeEnvio, String imagen) 
    {
       boolean resultado = false;
       boolean cuenta = CrearUsuario(nombreRestaurante, password, "R");
      
       try 
       {
           Class.forName("org.postgresql.Driver");
           Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
           java.sql.Statement st = conexion.createStatement();
           String consulta = "INSERT INTO restaurante VALUES ('"+ nombreRestaurante +"', '"+ NIT +"', '"+ direccion +"', '"+ descripcion +"', '"+ costoDeEnvio +"', '"+ imagen +"');";
           st.execute(consulta);
           st.close();
           conexion.close();
           resultado = true;
       }
       catch (Exception exc)
       {
           System.out.println("Errorx:"+exc.getMessage());
           resultado = false;
       }
       
       return resultado;
    }
    
    @Override
    public boolean AlmacenarPalabrasClave (String nombreRestaurante, String palabrasClave)
    {
       boolean resultado = false;
      
       try 
       {
           Class.forName("org.postgresql.Driver");
           Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
           StringTokenizer palabra = new StringTokenizer(palabrasClave);
          
           while (palabra.hasMoreTokens())
           {
               java.sql.Statement st = conexion.createStatement();
               String consulta = "INSERT INTO palabrasClave VALUES ('"+ nombreRestaurante +"', '"+ palabra.nextToken() +"');";
               st.execute(consulta);
               st.close();
           }
           
           conexion.close();
           resultado = true;
       }
       catch (Exception exc)
       {
           System.out.println("Errorx:"+exc.getMessage());
           resultado = false;
       }
       
       return resultado;
    }
    
    @Override
    public boolean EliminarRestaurante (String nombreRestaurante) 
    {
        boolean resultado = false;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM restaurante WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            //Tal vez toque eliminar cada plato del restaurante a eliminar.
            st.execute(consulta);
            st.close();
            java.sql.Statement st2 = conexion.createStatement();
            String consulta2 = "DELETE FROM palabrasClave WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            st2.execute(consulta2);
            st2.close();
            conexion.close();
            resultado = true;
            boolean eliminado = EliminarCuenta(nombreRestaurante, "R");
            
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    } 
    
    @Override
    public DefaultListModel BuscarRestaurante (String pTipo, String pUsurioActual) 
    {
        DefaultListModel lista = new DefaultListModel();
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT usuario FROM lenttiusuario WHERE tipo = '" + pTipo + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                lista.addElement(result.getString("usuario")); 
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return lista;
    }
    @Override
    public DefaultListModel BuscarPlatosRestaurante (String rUsuario) 
    {
        DefaultListModel lista = new DefaultListModel();
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombrePlato FROM plato WHERE restaurante = '" + rUsuario + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                lista.addElement(result.getString("nombrePlato")); 
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return lista;
    }
    @Override
    public DefaultListModel BuscarDomiciliariosRestaurante (String rUsuario) 
    {
        DefaultListModel lista = new DefaultListModel();
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT Nombre FROM domiciliario WHERE nombreRestaurante = '" + rUsuario + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                lista.addElement(result.getString("Nombre")); 
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return lista;
    }
    @Override
    public boolean ModificarNombreRestaurante (String nombreRestaurante, String nuevoNombre) 
    {
        boolean resultado = false;
        boolean modificado = ModificarUsuario(nombreRestaurante, nuevoNombre);
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET nombreRestaurante = '"+ nuevoNombre + "' WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    @Override
    public boolean ModificarDireccionRestaurante (String nombreRestaurante, String nuevaDireccion) 
    {
        boolean resultado = false;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET direccion = '"+ nuevaDireccion + "' WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    @Override
    public boolean ModificarDescripcionRestaurante (String nombreRestaurante, String nuevaDescripcion) 
    {
        boolean resultado = false;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET descripcion = '"+ nuevaDescripcion + "' WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    @Override
    public boolean ModificarCostoDeEnvioRestaurante (String nombreRestaurante, String nuevoCostoDeEnvio) 
    {
        boolean resultado = false;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            Float costoDeEnvio = Float.parseFloat(nuevoCostoDeEnvio);
            String consulta = "UPDATE restaurante SET costoDeEnvio = "+ nuevoCostoDeEnvio + " WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    @Override
    public boolean ModificarImagenRestaurante (String nombreRestaurante, String nuevaImagen) 
    {
        boolean resultado = false;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET imagen = '"+ nuevaImagen + "' WHERE nombreRestaurante = '"+ nombreRestaurante +"';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    @Override
    public boolean ModificarDocumentoDomiciliario(String documento, String nuevoDocumento){
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET documento = '"+ nuevoDocumento + "' WHERE documento = '"+ documento +"';";
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
    public boolean ModificarNombreDomiciliario(String documento, String nuevoNombre) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET Nombre = '"+ nuevoNombre + "' WHERE documento = '"+ documento +"';";
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
    public boolean ModificarTelefonoDomiciliario(String documento, String nuevoTelefono) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET telefono = '"+ nuevoTelefono + "' WHERE documento = '"+ documento +"';";
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
    public boolean ModificarPlacaVehiculoDomiciliario(String documento, String nuevaPlacaVehiculo) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET placaVehiculo = '"+ nuevaPlacaVehiculo + "' WHERE documento = '"+ documento +"';";
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
    public boolean ValidarExistenciaRestaurante (String nombreRestaurante)
    {
        boolean resultado = false;
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante FROM restaurante";
            ResultSet result = st.executeQuery(consulta);

            while(result.next()) 
            {
                if(nombreRestaurante.equals(result.getString("nombreRestaurante")))
                {
                    resultado = true;
                }  
            }

            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return resultado;
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
    
    public boolean ModificarNombreCliente(String pUsuario, String pNombre)
    {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE cliente SET nombre = '"+ pNombre + "' WHERE usuario = '"+ pUsuario +"';";
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
    
 
    public DefaultListModel BuscarPalabrasClave (String pClave) 
    {
        DefaultListModel listRestaurantes= new DefaultListModel();
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante FROM palabrasClave WHERE palabra = '" + pClave + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                listRestaurantes.addElement(result.getString("nombreRestaurante")); 
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return listRestaurantes;
    }
    
    public String darDescripcionRest (String nRestaurante) 
    {
        String descripcion = null;
      
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT descripcion FROM restaurante WHERE nombreRestaurante = '" + nRestaurante+ "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) {
                descripcion = result.getString("descripcion");
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return descripcion;
    }
    public float darCostoEnvioRest (String nRestaurante) 
    {
        float costoEnvio = 0 ;
      
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT costoEnvio FROM restaurante WHERE nombreRestaurante = '" + nRestaurante+ "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) {
                costoEnvio = result.getFloat("costoEnvio");
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return costoEnvio;
    }
    public String darDireccionRest (String nRestaurante) 
    {
        String direccion = null;
      
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT direccion FROM restaurante WHERE nombreRestaurante = '" + nRestaurante+ "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) {
                direccion = result.getString("direccion");
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return direccion;
    }
    
    
     public DefaultListModel darNombrePlatos (String pRest) 
    {
        DefaultListModel listPlatos= new DefaultListModel();
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombrePlato FROM plato WHERE restaurante = '" + pRest + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                listPlatos.addElement(result.getString("nombreRestaurante")); 
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return listPlatos;
    }
     
     public float darPrecioPlato(String nRest, String nPlato) 
    {
        float precio = 0;
        
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT precio FROM plato WHERE restaurante = '" + nRest + "' and nombrePlato = '" + nPlato + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                precio = result.getFloat("precio");
                
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return precio;
    }
     
     public String darDescripcionPlato(String nRest, String nPlato) 
    {
        String descripcion = null;
        
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT descripcion FROM plato WHERE restaurante = '" + nRest + "' and nombrePlato = '" + nPlato + "'";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) {
                descripcion = result.getString("descripcion"); 
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return descripcion;
    }
     
    
    
      
      public boolean agregarPedidoCC(String nUsuario, String nRestaurante, String nPlato) 
    {
       boolean resultado = false;
      
       try 
       {
           Class.forName("org.postgresql.Driver");
           Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
           java.sql.Statement st = conexion.createStatement();
           String consulta = "INSERT INTO carritoCompras VALUES ('"+ nUsuario +"', '"+ nRestaurante +"', '"+ nPlato +"');";
           st.execute(consulta);
           st.close();
           conexion.close();
           resultado = true;
       }
       catch (Exception exc)
       {
           System.out.println("Errorx:"+exc.getMessage());
           resultado = false;
       }
       
       return resultado;
    }
      
      public ArrayList<String> darCarroCompras(String nUsuario) 
    {
        ArrayList<String> listPedidos = new ArrayList<>();
        String var;
     
                
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante, nombrePlato FROM carritoCompras WHERE usuario = '" + nUsuario + "' ";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                var = result.getString("nombreRestaurante")+","+result.getString("nombrePlato");
                listPedidos.add(var);
       
                // C.setCantidad(result.getInt("imagen"));
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return listPedidos;
    }
      
       public float darCantidad(String nUsuario, String nRest, String nPlato) 
    {
        float cantidad = 0;

        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT cantidad FROM carritoCompras WHERE usuario = '" + nUsuario + "' and nombreRestaurante = '" + nRest + "' and nombrePlato = '" + nPlato + "' ";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                cantidad = result.getFloat("cantidad");
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return cantidad;
    }
       
       
    public boolean ModificarApellidoCliente(String pUsuario, String pApellido)
    {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE cliente SET apellido = '"+ pApellido + "' WHERE usuario = '"+ pUsuario +"';";
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
    
    
    public boolean ModificarDireccionCliente(String pUsuario, String pDireccion)
    {
        boolean sePudo = false;
        try {
                  Class.forName("org.postgresql.Driver");
                  Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
                  java.sql.Statement st = conexion.createStatement();
                  String consulta = "UPDATE cliente SET direccion = '"+ pDireccion + "' WHERE usuario = '"+ pUsuario +"';";
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
    
    
    public ArrayList<String> darCliente(String nUsuario) 
    {
        ArrayList<String> InformacionCliente = new ArrayList<>();
        String sNombre;
        String sApellido;
        String sDireccion;
     
                
        
        try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombre, apellido, direccion FROM cliente WHERE usuario = '" + nUsuario + "' ";
            ResultSet result = st.executeQuery(consulta);
                  
            while(result.next()) 
            {
                sNombre = result.getString("nombre");
                sApellido = result.getString("apellido");
                sDireccion = result.getString("direccion");
                InformacionCliente.add(sNombre);
                InformacionCliente.add(sApellido);
                InformacionCliente.add(sDireccion);
       
                // C.setCantidad(result.getInt("imagen"));
            }
            
            result.close();
            st.close();
            conexion.close();
        }
        catch (Exception exc)
        {
            System.out.println("Errorx:"+exc.getMessage());
        }
        
        return InformacionCliente;
    }
    
    public boolean ModificarCantidad(String pUsuario, String pRestaurante, String pPlato, float cantidad)
    {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE carritoCompras SET cantidad = '"+ cantidad+ "' WHERE usuario = '"+ pUsuario +"' and nombreRestaurante = '"+ pRestaurante +"' and nombrePlato = '"+ pPlato +"' ;";
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
    
    
    public boolean VaciarCarrito ( String nombreUsuario) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM carritoCompras WHERE usuario = '"+ nombreUsuario +"'; ";
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
    
    public boolean EliminarPedido( String pUsuario, String pRestaurante, String pPlato) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM carritoCompras WHERE  usuario = '"+ pUsuario +"' and nombreRestaurante = '"+ pRestaurante +"' and nombrePlato = '"+ pPlato +"' ;";
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
    
    public boolean EliminarCliente(String pUsuario) {
        boolean resultado= false;
       try 
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host,usuario,contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM cliente WHERE  usuario = '"+ pUsuario +"'  ;";
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
    
    
    
    
}
