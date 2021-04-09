/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Estefania
 */
public class CarroCompras {
    String nombreUsuario;
    String nombreRestaurante;
    String nombrePlato;
    int cantidad;

    public CarroCompras() {
    }

    public CarroCompras(String nombreUsuario, String nombreRestaurante, String nombrePlato, int cantidad) {
        this.nombreUsuario = nombreUsuario;
        this.nombreRestaurante = nombreRestaurante;
        this.nombrePlato = nombrePlato;
        this.cantidad = cantidad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
