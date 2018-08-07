package com.example.usuario.appturistico.Clases;

import com.example.usuario.appturistico.R;

import java.util.ArrayList;

public class extraccionmaestro {
    private String Nombre;
    private String Descripcion;
    private int imagen;


    public  extraccionmaestro(){
        imagen =0;
        Nombre = "";
        Descripcion = "";
    }






    public extraccionmaestro(String nombre, String descripcion, int imagen) {
        Nombre = nombre;
        Descripcion = descripcion;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }




    public ArrayList<extraccionmaestro> listademenu(){

        extraccionmaestro Extraccion;
        ArrayList<extraccionmaestro>lista= new ArrayList<extraccionmaestro>();
        Integer[]idImagen=new Integer[]{R.drawable.sitio3,R.drawable.sitio4,R.drawable.sitio5};
        String[]titulo = new String[]{"sitio1 ","sitio2","sitio3"};
        String[]descripcion = new String[]{"el mejor sitio para vivir ","el segundo mejor sitio para vivir","el tercer mejor sitio para vivir"};

        for (int i = 0 ; i<idImagen.length; i++){
            Extraccion = new extraccionmaestro(titulo[i],descripcion[i],idImagen[i]);

            lista.add(Extraccion);
        }

        return lista;
    }
}
