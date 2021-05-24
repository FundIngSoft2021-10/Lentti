/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author samyf
 */
public interface consultasBaseDeDatos {
    public abstract boolean ValidarInicioSesion(String pUsuario,String pContrasena, String pTipo);
    public abstract boolean CrearUsuario(String pUsuario, String pContrasena, String pTipo, String pCorreo, String pFecha);
    public abstract boolean ModificarUsuario(String anteriorUsuario, String nuevoUsuario);
    public abstract boolean ModificarContrasena(String pUsuario, String nuevaContrasena);
    public abstract boolean ModificarCorreo(String pUsuario,String nuevoCorreo);
    public abstract boolean ModificarHorarioRestaurante(String nombreRestaurante, String nuevaHora);
    public abstract boolean CrearPlato(String restaurante, String nombrePlato,  String descripcion, float precio, JFileChooser archivo, String ingredientes );
    public abstract boolean EliminarPlato(String nombrePlato);
    public abstract boolean ModificarNombrePlato(String nombrePlato, String nuevoNombre);
    public abstract boolean ModificarPrecioPlato(String nombrePlato, String nuevoPrecio);
    public abstract boolean ModificarDescripcionPlato(String nombrePlato, String nuevaDescripcion);
    public abstract boolean ModificarImagenPlato(String nombrePlato, String nuevaImagen);
    public abstract boolean EliminarCuenta(String pUsuario, String pTipo);
    public abstract boolean CrearRestaurante(String nombreRestaurante, String password, String NIT, String direccion, String descripcion, float costoDeEnvio, JFileChooser archivo, String horario);
    public abstract boolean AlmacenarPalabrasClave (String nombreRestaurante, String palabrasClave);
    public abstract boolean EliminarRestaurante (String nombreRestaurante);
    public abstract ArrayList<String>  BuscarRestaurante (String pTipo,String pUsurioActual);
    public abstract DefaultListModel BuscarPlatosRestaurante (String usuario);
    public abstract DefaultListModel BuscarNombrePlato (String nombre,String usuario);
    public abstract DefaultListModel BuscarPrecioPlato (String nombre,String usuario);
    public abstract DefaultListModel BuscarDescripcionPlato (String nombre,String usuario);
    public abstract DefaultListModel BuscarIngredientesPlato (String nombre,String usuario);
    public abstract boolean ModificarUltimaFecha(String pUsuario, String fecha);
    
    public abstract DefaultListModel BuscarDomiciliariosRestaurante (String usuario);
    public abstract boolean ModificarNombreRestaurante (String nombreRestaurante, String nuevoNombre);
    public abstract boolean ModificarDireccionRestaurante (String nombreRestaurante, String nuevaDireccion);
    public abstract boolean ModificarDescripcionRestaurante (String nombreRestaurante, String nuevaDescripcion);
    public abstract boolean ModificarCostoDeEnvioRestaurante (String nombreRestaurante, String nuevoCostoDeEnvio);
    public abstract boolean ModificarImagenRestaurante (String nombreRestaurante, JFileChooser nuevaImagen);
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
    public abstract String darFechaCreacionLenttiUsuario(String nUsuario);
    public abstract boolean ModificarApellidoCliente(String pUsuario, String pApellido);
    public abstract boolean ModificarDireccionCliente(String pUsuario, String pDireccion);
    public abstract boolean ModificarCorreoCliente(String pUsuario, String pDireccion);
    public boolean ModificarTarjetaCliente(String pUsuario, String pTarjeta);
    public abstract ArrayList<String> darCliente(String nUsuario);
    public abstract boolean ModificarCantidad(String pUsuario, String pRestaurante, String pPlato, float cantidad);
    public abstract boolean VaciarCarrito ( String nombreUsuario);
    public abstract boolean EliminarPedido( String pUsuario, String pRestaurante, String pPlato);
    public abstract boolean EliminarCliente( String pUsuario);
    public abstract boolean calificarRestaurante(int idPedido, String clienteUsuario, String restauranteUsuario, int calif, String comentario, String pFecha);
    public abstract boolean calificarDomiciliario(int idPedido, String clienteUsuario, String domiciliarioUsuario, int calif, String comentario, String pFecha);
    public abstract boolean CrearPedido(String cliente, String domiciliario, float Total, String estado);
    public abstract DefaultListModel BuscarPedidosEnCurso(String Pusuario);
    public abstract DefaultListModel BuscarPedidosAnteriores(String Pusuario);
    public abstract boolean EliminarPedido(int id, String Pusuario);
    public abstract boolean EliminarPedido(String Pusuario);
    public boolean ModificarEstadoPedido(String estado, int id);
    public abstract String DarDomiciliario(int id);
    public abstract String DarEstado(int id);
    public abstract String DarNombreDomiciliario(String documento);
    public abstract float DarTotalPedido(int id);
    public abstract boolean CrearPxP(int id,String restaurante, String plato, int cantidad, float total);
    public abstract int DarIdPedido(String Pusuario);
    public boolean CrearPxP2(String restaurante, String plato, int cantidad, float total);
    public boolean ModificarPxP(int id);
    public String DarRestPedido(int id);
    public abstract String ObtenerRestauranteDomicilio(int domid);
    public abstract String ObtenerDomiciliarioDomicilio(int domid);
    public abstract ImageIcon ImagenRestaurante (String nombreRestaurante);
    public abstract ImageIcon ImagenPlato (String plato, String nombreRestaurante);
    public abstract String ObtenerCorreo(String pUsuario);
    public abstract boolean ValidarDifRest(String nUsuario);
    public abstract String darRestaurantePedido(String nUsuario);
    public boolean RelacionarPedidoDomiciliario(int id,String doc);
    
    public abstract String darHorarioRest(String nRestaurante);
    //public abstract ArrayList<String> darPedido(int serial);
    
    //prueba imagen
    public abstract boolean GuardarImagen(int id, JFileChooser Imagen);
    public abstract ImageIcon PedirImagen(int id);
    //
    public abstract boolean AgregarRestauranteFavorito (String cliente, String restaurante);
    public abstract boolean EliminarRestauranteFavorito (String cliente, String restaurante);
    public abstract ArrayList <String> MostrarRestaurantesFavoritos (String cliente);
    public abstract ArrayList<String> darClientesActivos(String nRestaurante);
    public abstract boolean flagearCliente (String cliente, String restaurante);
    
    
    public abstract boolean agregarPedidoAFavoritos(String pUsuario, String pPedido);
    public abstract int[] darPedidoAFavoritos(String pUsuario);
    public abstract ArrayList<String> darPlatoSegunPedido(String pPedido);
    public abstract ArrayList<String> darInfoPlatoSegunPedido(String pPedido);
    
    public abstract ArrayList<Object> ObtenerDatosDomiciliario(String pUsuario);
    
    public abstract boolean VincularVehiculo(String pUsuario, String placa);
    
    public abstract String darHoraResena(int idPedido);
    public abstract String darHoraResena2(int idPedido);

    public abstract String darNombrePlato(String nRest, String desc);

    public abstract ArrayList<ArrayList<Object>> ObtenerVehiculosDisponibles();
    
    public boolean calificarRestauranteAc(int idPedido, String clienteUsuario, String restauranteUsuario, int calif, String comentario, String pFecha);
    public boolean calificarDomiciliarioAc(int idPedido, String clienteUsuario, String restauranteUsuario, int calif, String comentario, String pFecha);
    

}
