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
public class Restaurante {
    private String nombre;
    private String direccion;
    private String descripcion;
    private float costoEnvio;
    private String foto;

    public Restaurante (){
    
   }
    public Restaurante(String nombre, String direccion, String descripcion, float costoEnvio, String foto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.costoEnvio = costoEnvio;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public String getFoto() {
        return foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCostoEnvio(float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
