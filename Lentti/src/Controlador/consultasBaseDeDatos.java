/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.util.ArrayList;
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
    public abstract boolean CrearRestaurante (String nombreRestaurante, String password, String NIT, String direccion, String descripcion, float costoDeEnvio, String imagen);
    public abstract boolean AlmacenarPalabrasClave (String nombreRestaurante, String palabrasClave);
    public abstract boolean EliminarRestaurante (String nombreRestaurante);
    public abstract DefaultListModel BuscarRestaurante (String pTipo,String pUsurioActual);
    public abstract DefaultListModel BuscarPlatosRestaurante (String usuario);
    public abstract DefaultListModel BuscarDomiciliariosRestaurante (String usuario);
    public abstract boolean ModificarNombreRestaurante (String nombreRestaurante, String nuevoNombre);
    public abstract boolean ModificarDireccionRestaurante (String nombreRestaurante, String nuevaDireccion);
    public abstract boolean ModificarDescripcionRestaurante (String nombreRestaurante, String nuevaDescripcion);
    public abstract boolean ModificarCostoDeEnvioRestaurante (String nombreRestaurante, String nuevoCostoDeEnvio);
    public abstract boolean ModificarImagenRestaurante (String nombreRestaurante, String nuevaImagen);
    public abstract boolean ModificarNITRestaurante (String nombreRestaurante, String nuevoNIT);
    public abstract boolean ModificarPalabrasClaveRestaurante (String nombreRestaurante, String nuevasPalabrasClave);
    public abstract boolean ValidarExistenciaRestaurante (String nombreRestaurante);
    public abstract boolean CrearCliente(String pUsuario, String pNombre, String pApellido, String pDireccion);
    public abstract boolean ModificarNombreCliente(String pUsuario, String pNombre);
    public abstract DefaultListModel BuscarPalabrasClave (String pClave);
    public abstract boolean CrearDomiciliario(String restaurante, String documento, String nombre, String telefono, String placaVehiculo , Float puntuacion, Float domiciliosEntregados, String contrasenau );
    public abstract boolean EliminarDomiciliario(String documento);
    public abstract boolean ModificarDocumentoDomiciliario(String documento, String nuevoDocumento);
    public abstract boolean ModificarNombreDomiciliario(String documento, String nuevoNombre);
    public abstract boolean ModificarTelefonoDomiciliario(String documento, String nuevoTelefono);
    public abstract boolean ModificarPlacaVehiculoDomiciliario(String documento, String nuevaPlacaVehiculo);
    public abstract DefaultListModel darNombrePlatos (String pRest);
    public abstract boolean agregarPedidoCC(String nUsuario, String nRestaurante, String nPlato, float nCantidad);
    public abstract ArrayList<String> darCarroCompras(String nUsuario);
    public abstract String darDescripcionRest (String nRestaurante);
    public abstract float darCostoEnvioRest (String nRestaurante);
    public abstract String darDireccionRest (String nRestaurante);
    public abstract String darDescripcionPlato(String nRest, String nPlato);
    public abstract float darPrecioPlato(String nRest, String nPlato);
    public abstract float darCantidad(String nUsuario, String nRest, String nPlato);
    public abstract boolean ModificarApellidoCliente(String pUsuario, String pApellido);
    public abstract boolean ModificarDireccionCliente(String pUsuario, String pDireccion);
    public abstract ArrayList<String> darCliente(String nUsuario);
    public abstract boolean ModificarCantidad(String pUsuario, String pRestaurante, String pPlato, float cantidad);
    public abstract boolean VaciarCarrito ( String nombreUsuario);
    public abstract boolean EliminarPedido( String pUsuario, String pRestaurante, String pPlato);
    public abstract boolean EliminarCliente( String pUsuario);
    public abstract boolean calificarRestaurante(String pUsuario, int calif, String comentario);
    public abstract boolean calificarDomiciliario(String pUsuario, int calif, String comentario);
    public abstract boolean CrearPedido(String cliente, String domiciliario, float Total, String estado);
    
}
