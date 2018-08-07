package com.example.usuario.appturistico.Clases;

import com.example.usuario.appturistico.R;

import java.io.Serializable;
import java.util.ArrayList;

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
    public  extracciondesitios(){
        imagen =0;
        Nombre = "";
        Descripcion = "";
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

    public ArrayList<extracciondesitios> listademenu(){

        extracciondesitios Extraccion;
        ArrayList<extracciondesitios>lista= new ArrayList<extracciondesitios>();
        Integer[]idImagen=new Integer[]{R.drawable.sitio3,R.drawable.sitio4,R.drawable.sitio5};
        String[]Nombre = new String[]{"sitio1 ","sitio2","sitio3"};
        String[]descripcion = new String[]{"el mejor sitio para vivir ","el segundo mejor sitio para vivir","el tercer mejor sitio para vivir"};
        String[]ubicacion = new String[]{"1","2","3"};

        for (int i = 0 ; i<idImagen.length; i++){
            Extraccion = new extracciondesitios(Nombre[i],ubicacion[i],descripcion[i],idImagen[i],1);

            lista.add(Extraccion);
        }

        return lista;
    }
}
