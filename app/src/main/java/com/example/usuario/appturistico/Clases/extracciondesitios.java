package com.example.usuario.appturistico.Clases;

import java.io.Serializable;

public class extracciondesitios  implements Serializable{
    private String Nombre;
    private String Descripcion;
    private String Ubicacion;
    private int imagen;

    private int Imagendetalle;


    public void sitios(){//alimentar lista con el recyclerview

    }

    public extracciondesitios(String nombre, String descripcion, String ubicacion, int imagen, int imagendetalle) {
       Nombre = nombre;
        Descripcion = descripcion;
        Ubicacion = ubicacion;
        Imagendetalle = imagendetalle;
        this.imagen = imagen;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


    public int getImagendetalle() {
        return Imagendetalle;
    }

    public void setImagendetalle(int imagendetalle) {
        Imagendetalle = imagendetalle;
    }
}
