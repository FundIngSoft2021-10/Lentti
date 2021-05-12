/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.consultasBaseDeDatos;
//import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author samyf
 */
public class BaseDeDatos implements consultasBaseDeDatos {

    String host = "jdbc:postgresql://by7snyowz8hpiul0czun-postgresql.services.clever-cloud.com:5432/by7snyowz8hpiul0czun";
    String usuario = "ukq1feptpfh0wdl7wm7b";
    String contrasena = "k1A1ESjjj11G0Ti9aCma";

    public BaseDeDatos() {
    }

    //Implementación de la interface consultasBaseDeDatos
    @Override
    public boolean ValidarInicioSesion(String pUsuario, String pContrasena, String pTipo) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta
                    = "SELECT usuario,contrasena,tipo FROM lenttiusuario ";
            ResultSet result = st.executeQuery(consulta);
            while (result.next()) {

                if (pUsuario.equals(result.getString("usuario")) && pContrasena.equals(result.getString("contrasena")) && pTipo.equals(result.getString("tipo"))) {
                    resultado = true;
                }

            }
            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean CrearUsuario(String pUsuario, String pContrasena, String pTipo, String pCorreo) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "insert into lenttiUsuario values ( '" + pUsuario + "' , '" + pContrasena + "', '" + pTipo + "', '"+ pCorreo +"' );";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarUsuario(String anteriorUsuario, String nuevoUsuario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE lenttiusuario  SET usuario= '" + nuevoUsuario + "' WHERE usuario='" + anteriorUsuario + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarContrasena(String pUsuario, String nuevaContrasena) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE lenttiusuario  SET contrasena= '" + nuevaContrasena + "' WHERE usuario='" + pUsuario + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }
    @Override
    public boolean ModificarCorreo(String pUsuario, String nuevoCorreo)
    {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE lenttiusuario  SET correo= '" + nuevoCorreo + "' WHERE usuario='" + pUsuario + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }
    public String ObtenerCorreo(String pUsuario)
    {
        String resultado="";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta= "SELECT correo FROM lenttiusuario WHERE usuario='"+ pUsuario +"';";
            ResultSet result = st.executeQuery(consulta);
            while (result.next()) {

                resultado=result.getString("correo");

            }
            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean CrearPlato(String restaurante, String nombrePlato, String descripcion, float precio, JFileChooser archivo) {
        boolean resultado = false;
        FileInputStream imagen=null;
        try {
            imagen= new FileInputStream(archivo.getSelectedFile());
            
        } catch (FileNotFoundException ex){
             Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            
            String consulta ="INSERT INTO plato (restaurante ,nombrePlato ,precio,descripcion, imagen)  VALUES (?,?,?,?,?);";
            PreparedStatement st = conexion.prepareStatement(consulta);
            
            st.setString(1, restaurante);
            st.setString(2, nombrePlato);
            st.setFloat(3, precio);
            st.setString(4, descripcion);
            st.setBinaryStream(5, imagen, archivo.getSelectedFile().length());
            st.execute();
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
 

    @Override
    public boolean CrearDomiciliario(String restaurante, String documento, String nombre, String telefono, String placaVehiculo, Float puntuacion, Float domiciliosEntregados, String contrasenau) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st1 = conexion.createStatement();
            String consulta1 = "INSERT INTO lenttiusuario VALUES ('" + nombre + "', '" + contrasenau + "'," + "'D'" + ");";
            st1.execute(consulta1);
            st1.close();
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO domiciliario VALUES ('" + restaurante + "','" + documento + "','" + nombre + "', '" + telefono + "', '" + placaVehiculo + "', " + puntuacion + "," + domiciliosEntregados + ");";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean EliminarPlato(String nombrePlato) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM plato WHERE nombrePlato = '" + nombrePlato + "'; ";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean EliminarDomiciliario(String documento) {
        boolean resultado = false;
        String nombre = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st1 = conexion.createStatement();
            String consulta1 = "SELECT Nombre FROM domiciliario WHERE documento = '" + documento + "'; ";
            ResultSet rs = st1.executeQuery(consulta1);
            System.out.println("llegue1");
            if (rs.next()) {
                System.out.println("entra");

                nombre = rs.getString("Nombre");
                System.out.println(nombre);
            }
            st1.close();
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM domiciliario WHERE documento = '" + documento + "'; ";
            st.execute(consulta);
            st.close();
            java.sql.Statement st2 = conexion.createStatement();
            String consulta2 = "DELETE FROM lenttiusuario WHERE usuario = '" + nombre + "'; ";
            st2.execute(consulta2);
            st2.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarNombrePlato(String nombrePlato, String nuevoNombre) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE plato SET nombrePlato = '" + nuevoNombre + "' WHERE nombrePlato = '" + nombrePlato + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarPrecioPlato(String nombrePlato, String nuevoPrecio) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            Float precio = Float.parseFloat(nuevoPrecio);
            String consulta = "UPDATE plato SET precio = " + nuevoPrecio + " WHERE nombrePlato = '" + nombrePlato + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarDescripcionPlato(String nombrePlato, String nuevaDescripcion) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE plato SET descripcion = '" + nuevaDescripcion + "' WHERE nombrePlato = '" + nombrePlato + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarImagenPlato(String nombrePlato, String nuevaImagen) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE plato SET imagen = '" + nuevaImagen + "' WHERE nombrePlato = '" + nombrePlato + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean EliminarCuenta(String pUsuario, String pTipo) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM lenttiusuario WHERE usuario='" + pUsuario + "'AND tipo='" + pTipo + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean CrearRestaurante(String nombreRestaurante, String password, String NIT, String direccion, String descripcion, float costoDeEnvio, JFileChooser archivo) {
        boolean resultado = false;
        boolean cuenta = CrearUsuario(nombreRestaurante, password, "R", "Correoparacambiar@correo.com");
        FileInputStream imagen=null;
        try {
            imagen= new FileInputStream(archivo.getSelectedFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            String consulta = "INSERT INTO restaurante (nombreRestaurante,NIT,direccion,descripcion,costoEnvio,imagen)  VALUES (?,?,?,?,?,?);";
            PreparedStatement st= conexion.prepareStatement(consulta);
            st.setString(1, nombreRestaurante);
            st.setString(2, NIT);
            st.setString(3, direccion);
            st.setString(4, descripcion);
            st.setFloat(5, costoDeEnvio);
            st.setBinaryStream(6, imagen, archivo.getSelectedFile().length());
            st.execute();
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean AlmacenarPalabrasClave(String nombreRestaurante, String palabrasClave) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            StringTokenizer palabra = new StringTokenizer(palabrasClave);

            while (palabra.hasMoreTokens()) {
                java.sql.Statement st = conexion.createStatement();
                String consulta = "INSERT INTO palabrasClave VALUES ('" + nombreRestaurante + "', '" + palabra.nextToken() + "');";
                st.execute(consulta);
                st.close();
            }

            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean EliminarRestaurante(String nombreRestaurante) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM restaurante WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            //Tal vez toque eliminar cada plato del restaurante a eliminar.
            st.execute(consulta);
            st.close();
            java.sql.Statement st2 = conexion.createStatement();
            String consulta2 = "DELETE FROM palabrasClave WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st2.execute(consulta2);
            st2.close();
            conexion.close();
            resultado = true;
            boolean eliminado = EliminarCuenta(nombreRestaurante, "R");

        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public ArrayList<String> BuscarRestaurante(String pTipo, String pUsurioActual) {
        //DefaultListModel lista = new DefaultListModel();
        ArrayList<String>lista = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT usuario FROM lenttiusuario WHERE tipo = '" + pTipo + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.add(result.getString("usuario"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }

    @Override
    public DefaultListModel BuscarPlatosRestaurante(String rUsuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombrePlato FROM plato WHERE restaurante = '" + rUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("nombrePlato"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }
    @Override
    public DefaultListModel BuscarNombrePlato (String nombre,String rusuario) {
        DefaultListModel lista = new DefaultListModel();
        System.out.println(usuario + nombre);
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombrePlato FROM plato WHERE restaurante = '" + rusuario + "' AND nombreplato = '" + nombre + "' ";
            System.out.println(usuario + nombre);
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("nombrePlato"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }
    @Override
    public DefaultListModel BuscarPrecioPlato (String nombre,String rusuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT precio FROM plato WHERE restaurante = '" + rusuario + "' AND nombreplato = '" + nombre + "' ";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("precio"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }
    @Override
    public DefaultListModel BuscarDescripcionPlato (String nombre,String rusuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT descripcion FROM plato WHERE restaurante = '" + rusuario + "' AND nombreplato = '" + nombre + "' ";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("descripcion"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }
    
    
    @Override
    public DefaultListModel BuscarDomiciliariosRestaurante(String rUsuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT Nombre FROM domiciliario WHERE nombreRestaurante = '" + rUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("Nombre"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }

    @Override
    public boolean ModificarNombreRestaurante(String nombreRestaurante, String nuevoNombre) {
        boolean resultado = false;
        boolean modificado = ModificarUsuario(nombreRestaurante, nuevoNombre);

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET nombreRestaurante = '" + nuevoNombre + "' WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarDireccionRestaurante(String nombreRestaurante, String nuevaDireccion) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET direccion = '" + nuevaDireccion + "' WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarDescripcionRestaurante(String nombreRestaurante, String nuevaDescripcion) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET descripcion = '" + nuevaDescripcion + "' WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarCostoDeEnvioRestaurante(String nombreRestaurante, String nuevoCostoDeEnvio) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            Float costoDeEnvio = Float.parseFloat(nuevoCostoDeEnvio);
            String consulta = "UPDATE restaurante SET costoDeEnvio = " + nuevoCostoDeEnvio + " WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarImagenRestaurante(String nombreRestaurante, JFileChooser nuevaImagen) {
        boolean resultado = false;
        FileInputStream archivo=null;
        try {
            archivo= new FileInputStream(nuevaImagen.getSelectedFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            //java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET imagen = ? WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            PreparedStatement st= conexion.prepareStatement(consulta);
            st.setBinaryStream(1, archivo, nuevaImagen.getSelectedFile().length());
            st.execute();
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarNITRestaurante(String nombreRestaurante, String nuevoNIT) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET NIT = '" + nuevoNIT + "' WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarPalabrasClaveRestaurante(String nombreRestaurante, String nuevasPalabrasClave) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM palabrasClave WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            AlmacenarPalabrasClave(nombreRestaurante, nuevasPalabrasClave);
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean ModificarDocumentoDomiciliario(String documento, String nuevoDocumento) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET documento = '" + nuevoDocumento + "' WHERE documento = '" + documento + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarNombreDomiciliario(String documento, String nuevoNombre) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET Nombre = '" + nuevoNombre + "' WHERE documento = '" + documento + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarTelefonoDomiciliario(String documento, String nuevoTelefono) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET telefono = '" + nuevoTelefono + "' WHERE documento = '" + documento + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean ModificarPlacaVehiculoDomiciliario(String documento, String nuevaPlacaVehiculo) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE domiciliario SET placaVehiculo = '" + nuevaPlacaVehiculo + "' WHERE documento = '" + documento + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean ValidarExistenciaRestaurante(String nombreRestaurante) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante FROM restaurante";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                if (nombreRestaurante.equals(result.getString("nombreRestaurante"))) {
                    resultado = true;
                }
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }

    public boolean CrearCliente(String pUsuario, String pNombre, String pApellido, String pDireccion) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO cliente VALUES ('" + pUsuario + "','" + pNombre + "','" + pApellido + "', '" + pDireccion + "');";
            st.execute(consulta);
            st.close();
            conexion.close();
            sePudo = true;

        } catch (Exception e) {
            System.out.println("Errorx:" + e.getMessage());
            sePudo = false;
        }

        return sePudo;
    }

    public boolean ModificarNombreCliente(String pUsuario, String pNombre) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE cliente SET nombre = '" + pNombre + "' WHERE usuario = '" + pUsuario + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            sePudo = true;

        } catch (Exception e) {
            System.out.println("Errorx:" + e.getMessage());
            sePudo = false;
        }

        return sePudo;
    }

    public DefaultListModel BuscarPalabrasClave(String pClave) {
        DefaultListModel listRestaurantes = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante FROM palabrasClave WHERE palabra like '%" + pClave + "%'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                listRestaurantes.addElement(result.getString("nombreRestaurante"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return listRestaurantes;
    }

    public String darDescripcionRest(String nRestaurante) {
        String descripcion = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT descripcion FROM restaurante WHERE nombreRestaurante = '" + nRestaurante + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                descripcion = result.getString("descripcion");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return descripcion;
    }

    public float darCostoEnvioRest(String nRestaurante) {
        float costoEnvio = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT costoEnvio FROM restaurante WHERE nombreRestaurante = '" + nRestaurante + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                costoEnvio = result.getFloat("costoEnvio");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return costoEnvio;
    }

    public String darDireccionRest(String nRestaurante) {
        String direccion = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT direccion FROM restaurante WHERE nombreRestaurante = '" + nRestaurante + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                direccion = result.getString("direccion");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return direccion;
    }

    public DefaultListModel darNombrePlatos(String pRest) {
        DefaultListModel listPlatos = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreplato FROM plato WHERE restaurante = '" + pRest + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                listPlatos.addElement(result.getString("nombreplato"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return listPlatos;
    }

    public float darPrecioPlato(String nRest, String nPlato) {
        float precio = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT precio FROM plato WHERE restaurante = '" + nRest + "' and nombrePlato = '" + nPlato + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                precio = result.getFloat("precio");

            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return precio;
    }

    public String darDescripcionPlato(String nRest, String nPlato) {
        String descripcion = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT descripcion FROM plato WHERE restaurante = '" + nRest + "' and nombrePlato = '" + nPlato + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                descripcion = result.getString("descripcion");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return descripcion;
    }

    public boolean agregarPedidoCC(String nUsuario, String nRestaurante, String nPlato, float nCantidad) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO carritoCompras VALUES ('" + nUsuario + "', '" + nRestaurante + "', '" + nPlato + "', '" + nCantidad + "');";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;

    }

    public ArrayList<String> darCarroCompras(String nUsuario) {

        ArrayList<String> listPedidos = new ArrayList<>();
        String var, rest, plat;


        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante,nombrePlato FROM carritoCompras WHERE usuario = '" + nUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                rest = result.getString("nombreRestaurante");
                plat = result.getString("nombrePlato");
                var = rest + "," + plat;
                listPedidos.add(var);
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return listPedidos;
    }

    public float darCantidad(String nUsuario, String nRest, String nPlato) {
        float cantidad = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT cantidad FROM carritoCompras WHERE usuario = '" + nUsuario + "' and nombreRestaurante = '" + nRest + "' and nombrePlato = '" + nPlato + "' ";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                cantidad = result.getFloat("cantidad");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return cantidad;
    }

    public boolean ModificarApellidoCliente(String pUsuario, String pApellido) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE cliente SET apellido = '" + pApellido + "' WHERE usuario = '" + pUsuario + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            sePudo = true;

        } catch (Exception e) {
            System.out.println("Errorx:" + e.getMessage());
            sePudo = false;
        }

        return sePudo;
    }

    public boolean ModificarDireccionCliente(String pUsuario, String pDireccion) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE cliente SET direccion = '" + pDireccion + "' WHERE usuario = '" + pUsuario + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            sePudo = true;

        } catch (Exception e) {
            System.out.println("Errorx:" + e.getMessage());
            sePudo = false;
        }

        return sePudo;
    }

    public ArrayList<String> darCliente(String nUsuario) {
        ArrayList<String> InformacionCliente = new ArrayList<>();
        String sNombre;
        String sApellido;
        String sDireccion;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombre, apellido, direccion FROM cliente WHERE usuario = '" + nUsuario + "' ";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
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
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return InformacionCliente;
    }

    public boolean ModificarCantidad(String pUsuario, String pRestaurante, String pPlato, float cantidad) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE carritoCompras SET cantidad = '" + cantidad + "' WHERE usuario = '" + pUsuario + "' and nombreRestaurante = '" + pRestaurante + "' and nombrePlato = '" + pPlato + "' ;";
            st.execute(consulta);
            st.close();
            conexion.close();
            sePudo = true;
        } catch (Exception e) {
            System.out.println("Errorx:" + e.getMessage());
            sePudo = false;
        }

        return sePudo;
    }

    public boolean VaciarCarrito(String nombreUsuario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM carritoCompras WHERE usuario = '" + nombreUsuario + "'; ";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean EliminarPedido(String pUsuario, String pRestaurante, String pPlato) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM carritoCompras WHERE  usuario = '" + pUsuario + "' and nombreRestaurante = '" + pRestaurante + "' and nombrePlato = '" + pPlato + "' ;";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean EliminarCliente(String pUsuario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM cliente WHERE  usuario = '" + pUsuario + "'  ;";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean calificarRestaurante(String pUsuario, int calif, String comentario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta
                    = "insert into resenharestaurante values('" + pUsuario + "' , " + calif + ", '" + comentario + "')";
            st.execute(consulta);
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean calificarDomiciliario(String pUsuario, int calif, String comentario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta
                    = "insert into resenhadomiciliario values('" + pUsuario + "' , " + calif + ", '" + comentario + "')";
            st.execute(consulta);
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return resultado;
    }

    public boolean CrearPedido(String cliente, String domiciliario, float total, String estado) {

        boolean sePudo = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO pedido VALUES ( default ,'" + cliente + "','" + domiciliario + "', '" + total + "', '" + estado + "');";
            st.execute(consulta);
            st.close();
            conexion.close();
            sePudo = true;

        } catch (Exception e) {
            System.out.println("Errorx:" + e.getMessage());
            sePudo = false;
        }

        return sePudo;
    }

    @Override
    public DefaultListModel BuscarPedidosEnCurso(String Usuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT pedido_id FROM pedido WHERE cliente = '" + Usuario + "' and estado = 'en curso'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("pedido_id"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }

    @Override
    public DefaultListModel BuscarPedidosAnteriores(String Usuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT pedido_id FROM pedido WHERE cliente = '" + Usuario + "' and estado = 'entregado'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("pedido_id"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }

    public boolean EliminarPedido(int id, String Pusuario) {

        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM pedido WHERE  pedido_id = '" + id + "' and cliente = '" + Pusuario + "' ;";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;

    }
    
    public boolean EliminarPedido(String Pusuario) {

        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM pedido WHERE  cliente = '" + Pusuario + "' ;";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;

    }

    public boolean ModificarEstadoPedido(String estado, int id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE pedido SET estado = '" + estado + "' WHERE pedido_id = '" + id + "';";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public String DarDomiciliario(int id) {
        String documento = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT domiciliario_documento FROM pedido WHERE pedido_id = '" + id + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                documento = result.getString("domiciliario_documento");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return documento;
    }

    public String DarEstado(int id) {
        String estado = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT estado FROM pedido WHERE pedido_id = '" + id + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                estado = result.getString("estado");
            }
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return estado;
    }

    @Override
    public String ObternerRestauranteDomicilio(int domid) {
        String resultado = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "select distinct restaurante from pedidoxplato where pedido_id =" + domid;
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                resultado = result.getString("restaurante");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }

    public String DarNombreDomiciliario(String documento) {
        String nombre = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT Nombre FROM domiciliario WHERE documento = '" + documento + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                nombre = result.getString("nombre");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return nombre;
    }

    public float DarTotalPedido(int id) {
        float total = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT total FROM pedido WHERE pedido_id = '" + id + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                total = result.getFloat("total");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return total;
    }

    public boolean CrearPxP(int id, String restaurante, String plato, int cantidad, float total) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO pedidoxplato VALUES ('" + id + "','" + restaurante + "','" + plato + "', '" + cantidad + "', '" + total + "');";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public int DarIdPedido(String Pusuario, String estado, float total, String domiciliario) {
        int id = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT pedido_id FROM pedido WHERE cliente = '" + Pusuario + "' and domiciliario_documento = '" + domiciliario + "' and total = '" + total + "' and estado = '" + estado + "' ;";
            ResultSet result = st.executeQuery(consulta);

            id = result.getInt("pedido_id");
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return id;
    }

    @Override
    public String ObternerDomiciliarioDomicilio(int domid) {
        String resultado = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "select domiciliario_documento from pedido where pedido_id =" + domid;
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                resultado = result.getString("domiciliario_documento");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }

    public boolean CrearPxP2(String restaurante, String plato, int cantidad, float total) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO pedidoxplato (restaurante,plato,cantidad,totalplato) VALUES ('" + restaurante + "','" + plato + "', '" + cantidad + "', '" + total + "');";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean ModificarPxP(int id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO pedidoxplato (pedido_id) VALUES ('" + id + "');";
            st.execute(consulta);
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public String DarRestPedido(int id) {
        String nombre = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT restaurante FROM pedidoxplato WHERE pedido_id = '" + id + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                nombre = result.getString("restaurante");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return nombre;
    }

    @Override
    public boolean GuardarImagen(int id, JFileChooser Imagen) {
        boolean resultado=false;
        FileInputStream archivo=null;
        try {
            archivo= new FileInputStream(Imagen.getSelectedFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            //java.sql.Statement st = conexion.createStatement();
            
            String consulta = "INSERT INTO imagenTabla (numero,imagen) VALUES (?,?);";
            PreparedStatement st= conexion.prepareStatement(consulta);
            st.setInt(1, 1);
            st.setBinaryStream(2, archivo, Imagen.getSelectedFile().length());
            st.execute();
            st.close();
            conexion.close();
            resultado = true;
            
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public ImageIcon PedirImagen(int id) {
        ImageIcon archivo=null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT imagen FROM restaurante WHERE nombrerestaurante = 'hola'";
            //PreparedStatement st=conexion.prepareStatement(consulta);
            
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                //System.out.println("lo que trae el archivo ->" +result.getBlob("imagen").getBinaryStream().toString() );
                InputStream is= result.getBinaryStream("imagen");
                BufferedImage img = ImageIO.read(is);
                archivo = new ImageIcon(img) ;
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return archivo;
    }

    @Override
    public ImageIcon ImagenRestaurante(String nombreRestaurante) {
        ImageIcon archivo=null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT imagen FROM restaurante WHERE nombrerestaurante = '"+nombreRestaurante+"';";
            //PreparedStatement st=conexion.prepareStatement(consulta);
            
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                //System.out.println("lo que trae el archivo ->" +result.getBlob("imagen").getBinaryStream().toString() );
                InputStream is= result.getBinaryStream("imagen");
                BufferedImage img = ImageIO.read(is);
                archivo = new ImageIcon(img) ;
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return archivo;
    }
    
    
    

}
