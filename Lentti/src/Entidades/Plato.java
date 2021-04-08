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
public class Plato {
    
    String nombreRestaurante;
    String nombrePlato;
    float precio;
    String descripcion;
    String imagen;

    public Plato() {
    }

    public Plato(String nombreRestaurante, String nombrePlato, float precio, String descripcion, String imagen) {
        this.nombreRestaurante = nombreRestaurante;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
    

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public float getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
    
}
