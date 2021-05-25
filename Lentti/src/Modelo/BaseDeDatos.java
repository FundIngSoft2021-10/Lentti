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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    public boolean CrearUsuario(String pUsuario, String pContrasena, String pTipo, String pCorreo, String pFecha) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "insert into lenttiUsuario values ( '" + pUsuario + "' , '" + pContrasena + "', '" + pTipo + "', '" + pCorreo + "', '" + pFecha + "' );";
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
    public boolean ModificarCorreo(String pUsuario, String nuevoCorreo) {
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

    public String ObtenerCorreo(String pUsuario) {
        String resultado = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT correo FROM lenttiusuario WHERE usuario='" + pUsuario + "';";
            ResultSet result = st.executeQuery(consulta);
            while (result.next()) {

                resultado = result.getString("correo");

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
    public boolean CrearPlato(String restaurante, String nombrePlato, String descripcion, float precio, JFileChooser archivo, String ingredientes) {
        boolean resultado = false;
        FileInputStream imagen = null;
        try {
            imagen = new FileInputStream(archivo.getSelectedFile());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);

            String consulta = "INSERT INTO plato (restaurante ,nombrePlato ,precio,descripcion, imagen, ingredientes)  VALUES (?,?,?,?,?,?);";
            PreparedStatement st = conexion.prepareStatement(consulta);

            st.setString(1, restaurante);
            st.setString(2, nombrePlato);
            st.setFloat(3, precio);
            st.setString(4, descripcion);
            st.setBinaryStream(5, imagen, archivo.getSelectedFile().length());
            st.setString(6, ingredientes);
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
    public boolean CrearDomiciliario(String restaurante, String documento, String nombre, String telefono, File imagen, String contrasenau) {
        boolean resultado = false;
        String path = imagen.getAbsolutePath();      
        FileInputStream imgDom = null;
        LocalDate fecha = LocalDate.now();
        String fechaCreacion = String.valueOf(fecha.getDayOfMonth()) + "/" + String.valueOf(fecha.getMonthValue()) + "/" + String.valueOf(fecha.getYear());
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            imgDom = new FileInputStream(path);
            java.sql.Statement st = conexion.createStatement();
            String consulta1 = "INSERT INTO lenttiusuario VALUES ('" + nombre + "', '" + contrasenau + "', 'D', '" + fechaCreacion + "')";
            st.execute(consulta1);
            String consulta = "INSERT INTO domiciliario VALUES ('" + restaurante + "','" + documento + "','" + nombre + "', '" + telefono + "', null, null, 0, Default, null)";
            st.execute(consulta);
            st.close();
            String consulta2 = "UPDATE domiciliario SET imagen = ? WHERE documento = '" + documento + "'";
            PreparedStatement st2 = conexion.prepareStatement(consulta2);
            st2.setBinaryStream(1, imgDom);
            st2.execute();
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

    public boolean CrearRestaurante(String nombreRestaurante, String password, String NIT, String direccion, String descripcion, float costoDeEnvio, JFileChooser archivo, String horario) {
        boolean resultado = false;
        LocalDate fecha = LocalDate.now();
        String fechaCreacion = String.valueOf(fecha.getDayOfMonth()) + "/" + String.valueOf(fecha.getMonthValue()) + "/" + String.valueOf(fecha.getYear());
        boolean cuenta = CrearUsuario(nombreRestaurante, password, "R", "Correoparacambiar@correo.com", fechaCreacion);
        FileInputStream imagen = null;
        try {
            imagen = new FileInputStream(archivo.getSelectedFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            String consulta = "INSERT INTO restaurante (nombreRestaurante,NIT,direccion,descripcion,costoEnvio,imagen, Horario)  VALUES (?,?,?,?,?,?,?);";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, nombreRestaurante);
            st.setString(2, NIT);
            st.setString(3, direccion);
            st.setString(4, descripcion);
            st.setFloat(5, costoDeEnvio);
            st.setBinaryStream(6, imagen, archivo.getSelectedFile().length());
            st.setString(7, horario);
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
            java.sql.Statement st3 = conexion.createStatement();
            String consulta3 = "DELETE FROM restaurantesFavoritos WHERE restaurante = '" + nombreRestaurante + "';";
            st3.execute(consulta3);
            st3.close();
            conexion.close();
            boolean eliminado = EliminarCuenta(nombreRestaurante, "R");
            resultado = true;

        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
            resultado = false;
        }

        return resultado;
    }

    @Override
    public ArrayList<String> BuscarRestaurante(String pTipo, String pUsurioActual) {
        //DefaultListModel lista = new DefaultListModel();
        ArrayList<String> lista = new ArrayList<>();

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
    public DefaultListModel BuscarNombrePlato(String nombre, String rusuario) {
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
    public DefaultListModel BuscarPrecioPlato(String nombre, String rusuario) {
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
    public DefaultListModel BuscarIngredientesPlato(String nombre, String rusuario) {
        DefaultListModel lista = new DefaultListModel();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT ingredientes FROM plato WHERE restaurante = '" + rusuario + "' AND nombreplato = '" + nombre + "' ";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.addElement(result.getString("ingredientes"));
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
    public DefaultListModel BuscarDescripcionPlato(String nombre, String rusuario) {
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
        FileInputStream archivo = null;
        try {
            archivo = new FileInputStream(nuevaImagen.getSelectedFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            //java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET imagen = ? WHERE nombreRestaurante = '" + nombreRestaurante + "';";
            PreparedStatement st = conexion.prepareStatement(consulta);
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

    public boolean ModificarHorarioRestaurante(String nombreRestaurante, String nuevoHorario) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE restaurante SET Horario = '" + nuevoHorario + "' WHERE nombreRestaurante = '" + nombreRestaurante + "';";
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

    public boolean ModificarCorreoCliente(String pUsuario, String pCorreo) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE lenttiusuario SET correo = '" + pCorreo + "' WHERE usuario = '" + pUsuario + "';";
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

    public boolean ModificarTarjetaCliente(String pUsuario, String pTarjeta) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE cliente SET tarjetaCredito = '" + pTarjeta + "' WHERE usuario = '" + pUsuario + "';";
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
        
        boolean validacion = ValidarExistenciaProductoCC(nUsuario, nRestaurante, nPlato);
        if(validacion == true){
          nCantidad += darCantidad(nUsuario, nRestaurante, nPlato);
          resultado = ModificarCantidad(nUsuario, nRestaurante, nPlato, nCantidad);
        }
        else{
            
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
    public boolean calificarRestaurante(int idPedido, String clienteUsuario, String restauranteUsuario, int calif, String comentario, String pFecha) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "insert into resenhapedidorestaurante values(" + idPedido + ", '" + clienteUsuario + "' , '" + restauranteUsuario + "', " + calif + ", '" + comentario + "', '" + pFecha + "')";
            st.execute(consulta);
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return resultado;
    }

    public boolean calificarRestauranteAc(int idPedido, String clienteUsuario, String restauranteUsuario, int calif, String comentario, String pFecha) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE resenhapedidorestaurante SET calificacion = '" + calif + "', comentario = '" + comentario + "', fecha = '" + pFecha + "'  WHERE idpedido = '" + idPedido + "' ;";
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

    public boolean calificarDomiciliarioAc(int idPedido, String clienteUsuario, String restauranteUsuario, int calif, String comentario, String pFecha) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE resenhapedidodomiciliario SET calificacion = '" + calif + "', comentario = '" + comentario + "', fecha = '" + pFecha + "'  WHERE idpedido = '" + idPedido + "' ;";
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
    public boolean calificarDomiciliario(int idPedido, String clienteUsuario, String domiciliarioUsuario, int calif, String comentario, String pFecha) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "insert into resenhapedidodomiciliario values(" + idPedido + ", '" + clienteUsuario + "' , '" + domiciliarioUsuario + "', " + calif + ", '" + comentario + "', '" + pFecha + "')";
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
        Date date = new Date();
        int hora = date.getMinutes();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO pedido VALUES ( default ,'" + cliente + "','" + domiciliario + "', '" + total + "', '" + estado + "', '" + hora + "');";
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
        Date date = new Date();
        int horaActual = date.getMinutes();
        int horaAlmacenada;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE pedido SET estado = '" + estado + "' WHERE pedido_id = '" + id + "';";
            st.execute(consulta);
            st.close();

            if (estado == "cancelado") {
                java.sql.Statement s = conexion.createStatement();
                String c = "SELECT hora FROM pedido WHERE pedido_id = '" + id + "'";
                ResultSet result = s.executeQuery(c);

                while (result.next()) {
                    horaAlmacenada = result.getInt("hora");

                    if (horaActual - horaAlmacenada <= 1) {
                        resultado = true;
                    }
                }

                s.close();
            } else {
                resultado = true;
            }

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
    public String ObtenerRestauranteDomicilio(int domid) {
        String resultado = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "select distinct restaurante from pedidoxplato where pedido_id = '" + domid + "'";
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

    public int DarIdPedido(String Pusuario) {
        int id = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT MAX(pedido_id) as idpedido FROM pedido WHERE cliente = '" + Pusuario + "' ;";
            ResultSet result = st.executeQuery(consulta);
            while (result.next()) {
                id = result.getInt("idpedido");
            }

        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return id;
    }

    @Override
    public String ObtenerDomiciliarioDomicilio(int domid) {
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
        boolean resultado = false;
        FileInputStream archivo = null;
        try {
            archivo = new FileInputStream(Imagen.getSelectedFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            //java.sql.Statement st = conexion.createStatement();

            String consulta = "INSERT INTO imagenTabla (numero,imagen) VALUES (?,?);";
            PreparedStatement st = conexion.prepareStatement(consulta);
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
        ImageIcon archivo = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT imagen FROM restaurante WHERE nombrerestaurante = 'hola'";
            //PreparedStatement st=conexion.prepareStatement(consulta);

            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                //System.out.println("lo que trae el archivo ->" +result.getBlob("imagen").getBinaryStream().toString() );
                InputStream is = result.getBinaryStream("imagen");
                BufferedImage img = ImageIO.read(is);
                archivo = new ImageIcon(img);
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
        ImageIcon archivo = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT imagen FROM restaurante WHERE nombrerestaurante = '" + nombreRestaurante + "';";
            //PreparedStatement st=conexion.prepareStatement(consulta);

            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                //System.out.println("lo que trae el archivo ->" +result.getBlob("imagen").getBinaryStream().toString() );
                InputStream is = result.getBinaryStream("imagen");
                BufferedImage img = ImageIO.read(is);
                archivo = new ImageIcon(img);
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
    public ImageIcon ImagenPlato(String plato, String rusuario) {
        ImageIcon archivo = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT imagen FROM plato WHERE restaurante = '" + rusuario + "' AND nombreplato = '" + plato + "' ";
            //WHERE restaurante = '" + rusuario + "' AND nombreplato = '" + plato + "' ";
            //PreparedStatement st=conexion.prepareStatement(consulta);

            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                //System.out.println("lo que trae el archivo ->" +result.getBlob("imagen").getBinaryStream().toString() );
                InputStream is = result.getBinaryStream("imagen");
                BufferedImage img = ImageIO.read(is);
                archivo = new ImageIcon(img);
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return archivo;
    }

    public boolean ValidarDifRest(String nUsuario) {
        ArrayList<String> listP = new ArrayList<>();
        boolean respuesta = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante FROM carritoCompras WHERE usuario = '" + nUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                listP.add(result.getString("nombreRestaurante"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        String nombreR = null;
        if (listP.size() > 0) {
            nombreR = listP.get(0);
        }

        for (int i = 1; i < listP.size(); i++) {

            if (!(nombreR.equals(listP.get(i)))) {
                respuesta = true;
            }

        }

        return respuesta;
    }

    @Override
    public boolean AgregarRestauranteFavorito(String cliente, String restaurante) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            String consulta = "INSERT INTO restaurantesFavoritos (cliente, restaurante)  VALUES (?, ?);";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, cliente);
            st.setString(2, restaurante);
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
    public boolean EliminarRestauranteFavorito(String cliente, String restaurante) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "DELETE FROM restaurantesFavoritos WHERE restaurante = '" + restaurante + "'; ";
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
    public ArrayList<String> MostrarRestaurantesFavoritos(String cliente) {
        ArrayList<String> lista = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT restaurante FROM restaurantesFavoritos WHERE cliente = '" + cliente + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                lista.add(result.getString("restaurante"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return lista;
    }

    /*public boolean EliminarPedido(int id, String Pusuario) {

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

    }*/
    public ArrayList<String> darClientesActivos(String nRestaurante) {

        ArrayList listaClientes = new ArrayList();
        ArrayList<String> listaNombres = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT pedido_id FROM pedidoxplato WHERE restaurante = '" + nRestaurante + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                listaClientes.add(result.getInt("pedido_id"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        for (int i = 0; i < listaClientes.size(); i++) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
                java.sql.Statement st = conexion.createStatement();
                String consulta = "SELECT cliente FROM pedido WHERE pedido_id = '" + listaClientes.get(i) + "'";
                ResultSet result = st.executeQuery(consulta);

                while (result.next()) {
                    listaNombres.add(result.getString("cliente"));
                }

                result.close();
                st.close();
                conexion.close();
            } catch (Exception exc) {
                System.out.println("Errorx:" + exc.getMessage());
            }

        }

        return listaNombres;
    }

    public boolean flagearCliente(String cliente, String restaurante) {
        boolean flageado = false;
        int cancelados = 0;
        boolean primerPedido = true;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT cancelados FROM bandera WHERE cliente = '" + cliente + "' AND restaurante = '" + restaurante + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                cancelados = result.getInt("cancelados");
                primerPedido = false;
                System.out.println("Cancelados si si encontro datos en la tabla bandera pero antes de sumar: " + cancelados);
            }

            result.close();
            st.close();

            if (primerPedido == true) {
                java.sql.Statement s = conexion.createStatement();
                System.out.println("Cancelados si no encontro datos en la tabla bandera: " + cancelados);
                String c = "INSERT INTO bandera VALUES ('" + cliente + "' , '" + restaurante + "', '" + cancelados + "');";
                s.execute(c);
                s.close();
                flageado = true;
            } else {
                cancelados = cancelados + 1;
                System.out.println("Cancelados si si encontro datos en la tabla bandera pero despues de sumar: " + cancelados);
                java.sql.Statement s2 = conexion.createStatement();
                String co = "UPDATE bandera SET cancelados = '" + cancelados + "';";
                s2.execute(co);
                s2.close();
                flageado = true;
            }

            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return flageado;
    }

    public String darHorarioRest(String nRestaurante) {
        String horario = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT Horario FROM restaurante WHERE nombreRestaurante = '" + nRestaurante + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                horario = result.getString("Horario");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return horario;
    }

    public String darRestaurantePedido(String nUsuario) {

        String nRest = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombreRestaurante FROM carritoCompras WHERE usuario = '" + nUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                nRest = result.getString("nombreRestaurante");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return nRest;
    }

    public boolean agregarPedidoAFavoritos(String pUsuario, String pPedido) {
        boolean sePudo = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "INSERT INTO pedidoFavorito VALUES ('" + pUsuario + "','" + pPedido + "');";
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

    public ArrayList<String> darPlatoSegunPedido(String pPedido) {
        ArrayList<String> nRest = new ArrayList<String>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT plato FROM pedidoxplato WHERE pedido_id = '" + pPedido + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                nRest.add(result.getString("plato"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return nRest;
    }

    public ArrayList<String> darInfoPlatoSegunPedido(String pPedido) {
        ArrayList<String> nRest = new ArrayList<String>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT restaurante, plato, cantidad FROM pedidoxplato WHERE pedido_id = '" + pPedido + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                nRest.add(result.getString("restaurante"));
                nRest.add(result.getString("plato"));
                nRest.add(result.getString("cantidad"));
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return nRest;
    }

    public int[] darPedidoAFavoritos(String pUsuario) {

        int[] nRest = new int[100];
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT IDpedido FROM pedidoFavorito WHERE cliente = '" + pUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            int i = 0;
            while (result.next()) {
                nRest[i] = (result.getInt("IDpedido"));
                i++;
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return nRest;
    }

    public ArrayList<Object> ObtenerDatosDomiciliario(String pUsuario) {

        ArrayList<Object> InformacionDomiciliario = new ArrayList<>();
        String sNombre;
        String sDocumento;
        String sTelefono;
        Double sDomiEntregados;
        String sPlacaVehiculo;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombre, documento, telefono, domiciliosentregados, placavehiculo FROM domiciliario WHERE nombre = '" + pUsuario + "' ";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                sNombre = result.getString("nombre");
                sDocumento = result.getString("documento");
                sTelefono = result.getString("telefono");
                sDomiEntregados = result.getDouble("domiciliosentregados");
                sPlacaVehiculo = result.getString("placavehiculo");
                InformacionDomiciliario.add(sNombre);
                InformacionDomiciliario.add(sDocumento);
                InformacionDomiciliario.add(sTelefono);
                InformacionDomiciliario.add(sDomiEntregados);
                InformacionDomiciliario.add(sPlacaVehiculo);
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return InformacionDomiciliario;

    }

    public boolean VincularVehiculo(String pUsuario, String placa) {
        boolean estado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "Update domiciliario set placavehiculo = '" + placa + "' where nombre = '" + pUsuario + "'";
            st.execute(consulta);
            st.close();
            conexion.close();
            estado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return estado;
    }

    public String darHoraResena(int npedido) {
        String horario = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT fecha FROM resenhapedidorestaurante WHERE idpedido = " + npedido;
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                horario = result.getString("fecha");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return horario;
    }

    public String darHoraResena2(int npedido) {
        String horario = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT fecha FROM resenhapedidodomiciliario WHERE idpedido = " + npedido;
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                horario = result.getString("fecha");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return horario;
    }

    @Override
    public boolean RelacionarPedidoDomiciliario(int id, String doc) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE pedido SET domiciliario_documento  = '" + doc + "' WHERE pedido_id = '" + id + "';";
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

    public String darNombrePlato(String nRest, String desc) {
        String descripcion = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT nombrePlato FROM plato WHERE restaurante = '" + nRest + "' and descripcion = '" + desc + "'";
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

    public ArrayList<ArrayList<Object>> ObtenerVehiculosDisponibles() {

        ArrayList<ArrayList<Object>> resultado = new ArrayList<>();
        String placa;
        String tipo;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT placavehiculo, tipovehiculo FROM vehiculo WHERE estado = 'disponible'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {

                placa = result.getString("placavehiculo");
                tipo = result.getString("tipovehiculo");
                ArrayList<Object> Aux = new ArrayList<>();
                Aux.add(placa);
                Aux.add(tipo);
                resultado.add(Aux);

            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }

    public String darFechaCreacionLenttiUsuario(String nUsuario) {
        String fecha = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT ultimacontrasena FROM lenttiusuario WHERE usuario = '" + nUsuario + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                fecha = result.getString("ultimacontrasena");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return fecha;
    }

    public boolean ModificarUltimaFecha(String pUsuario, String fecha) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "UPDATE lenttiusuario  SET ultimacontrasena= '" + fecha + "' WHERE usuario='" + pUsuario + "';";
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

    public boolean CrearInconveniente(String cliente, String rest, String mensaje, int pedidoid, String domiuser) {
        boolean estado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "Insert into inconvenientes values('" + cliente + "', '" + rest + "', '" + mensaje + "', " + pedidoid + ", '" + domiuser + "')";
            st.execute(consulta);
            st.close();
            conexion.close();
            estado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return estado;
    }

    public String ObtenerClienteDomicilio(int domid) {
        String resultado = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "select cliente from pedido where pedido_id =" + domid;
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                resultado = result.getString("cliente");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }

    public ArrayList<ArrayList<Object>> ObtenerTablaDomiciliosEnCursoDomiciliario(String domi) {

        ArrayList<ArrayList<Object>> resultado = new ArrayList<>();
        int pedidoid;
        String platos = "";
        String cliente;
        String domidoc = "";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT documento FROM domiciliario WHERE nombre = '" + domi + "'";
            ResultSet result1 = st.executeQuery(consulta);
            while (result1.next()) {

                domidoc = result1.getString("documento");

            }
            result1.close();
            String consulta1 = "SELECT pedido_id, cliente FROM pedido WHERE estado = 'en curso' and domiciliario_documento = '" + domidoc + "'";
            ResultSet result2 = st.executeQuery(consulta1);
            while (result2.next()) {

                pedidoid = result2.getInt("pedido_id");
                cliente = result2.getString("cliente");
                String consulta2 = "SELECT plato FROM pedidoxplato WHERE pedido_id = '" + pedidoid + "'";
                ResultSet result3 = st.executeQuery(consulta2);
                String aux = "";
                int cont = 0;
                int size;
                result3.last();    // moves cursor to the last row
                size = result3.getRow(); // get row id 
                result3.beforeFirst();   // moves cursor to the first row
                while (result3.next()) {

                    cont++;
                    if (cont == size) {
                        platos = aux + result3.getString("plato");
                    } else {
                        aux = aux + result3.getString("plato") + ", ";
                        platos = aux;
                    }

                }
                ArrayList<Object> Aux = new ArrayList<>();
                Aux.add(pedidoid);
                Aux.add(platos);
                Aux.add(cliente);
                resultado.add(Aux);

            }
            result1.close();
            result2.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }
    
    public boolean ValidarExistenciaProductoCC(String nUsuario, String nRestaurante, String nPlato) {
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT usuario,nombreRestaurante,nombrePlato FROM carritoCompras";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                if (nUsuario.equals(result.getString("usuario")) && nRestaurante.equals(result.getString("nombreRestaurante")) && nPlato.equals(result.getString("nombrePlato")) ) {
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
    
    public float obtenerCantidadPedido(String nUsuario, String nRestaurante, String nPlato) {
        float resultado = 0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT cantidad FROM carritoCompras WHERE usuario = '" + nUsuario + "' and nombreRestaurante = '" + nRestaurante + "' and  nombrePlato = '" + nPlato + "'";
            ResultSet result = st.executeQuery(consulta);

            while (result.next()) {
                resultado = result.getFloat("cantidad");
            }

            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }
    
    public ImageIcon VerImagenDomiciliario(String userDomi) {
        ImageIcon imagen = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            java.sql.Statement st = conexion.createStatement();
            String consulta = "SELECT imagen FROM domiciliario WHERE nombre = '" + userDomi + "'";
            ResultSet result = st.executeQuery(consulta);
            while (result.next()) {
                InputStream is = result.getBinaryStream("imagen");
                BufferedImage img = ImageIO.read(is);
                imagen = new ImageIcon(img);
            }
            result.close();
            st.close();
            conexion.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
        return imagen;
    }
    
    public boolean ModificarImagenDomiciliario(String docDomi, File imagen) {
        boolean resultado = false;
        String path = imagen.getAbsolutePath();      
        FileInputStream imgDom = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(host, usuario, contrasena);
            imgDom = new FileInputStream(path);
            String consulta = "UPDATE domiciliario SET imagen = ? WHERE documento = '" + docDomi + "'";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setBinaryStream(1, imgDom);
            st.execute();
            st.close();
            conexion.close();
            resultado = true;
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        return resultado;
    }
    
    public boolean correoCorrecto(String pCorreo)
    {
        boolean correcto =false;
        String correo = pCorreo;
        String [] partes;
        partes = correo.split("@");
        
        if(partes.length == 2)
        {
            if(partes[1].equals("hotmail.com") ||partes[1].equals("gmail.com") )
            {
                correcto = true;
            }
        }
        
        
        return correcto;
    }

}
