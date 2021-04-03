/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.DefaultListModel;

/**
 *
 * @author samyf
 */
public interface consultasBaseDeDatos {
    public abstract boolean ValidarInicioSesion(String pUsuario,String pContrasena, String pTipo);
    public abstract boolean CrearUsuario(String pUsuario, String pContrasena, String pTipo);
    public abstract boolean ModificarUsuario(String anteriorUsuario, String nuevoUsuario);
    public abstract boolean ModificarContrasena(String pUsuario, String nuevaContrasena);
    public abstract boolean CrearPlato(String restaurante, String nombrePlato,  String descripcion, float precio, String imagen );
    public abstract boolean EliminarPlato(String nombrePlato);
    public abstract boolean ModificarNombrePlato(String nombrePlato, String nuevoNombre);
    public abstract boolean ModificarPrecioPlato(String nombrePlato, String nuevoPrecio);
    public abstract boolean ModificarDescripcionPlato(String nombrePlato, String nuevaDescripcion);
    public abstract boolean ModificarImagenPlato(String nombrePlato, String nuevaImagen);
    public abstract boolean EliminarCuenta(String pUsuario, String pTipo);
    public abstract DefaultListModel LlenarListaUsuarios(String pTipo,String pUsurioActual);
}
