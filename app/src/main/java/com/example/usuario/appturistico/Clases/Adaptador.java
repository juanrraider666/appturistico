package com.example.usuario.appturistico.Clases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.appturistico.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos> implements  View.OnClickListener{//escribir esta linea primero, deespues implementar clase

ArrayList<extracciondesitios>datos  = new ArrayList<>(); //ddimplementamos y despues implementamos en constructor de abajo
private View.OnClickListener onClickListener;


    public Adaptador(ArrayList<extracciondesitios> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      int layout;
       if(Utilidades.VISUALIZACION == Utilidades.LIST){
           layout = R.layout.item_list;  //para lista
        }else {
            layout = R.layout.modo_grid;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,null,false);//se implementa



        view.setOnClickListener(this);


        return new ViewHolderDatos( view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) { //comunicacion entre nuestro adaptador y la clase ViewHolderDatos
         holder.Nombre.setText(datos.get(position).getNombre());


        if(Utilidades.VISUALIZACION == Utilidades.LIST){
            holder.Descripcion.setText(datos.get(position).getDescripcion());
        }else {

            holder.Ubicacion.setText(datos.get(position).getUbicacion());
            holder.imagen.setImageResource(datos.get(position).getImagen());
        }





    }

    @Override
    public int getItemCount() {
        return datos.size(); //retornar el tamaño de la lista
    }



    public void setOnClickListener(View.OnClickListener listener) {
        this.onClickListener = listener;
    }//para maestro detalle




    @Override
    public void onClick(View v) {
        if(onClickListener !=null){
            onClickListener.onClick(v);
        }
    }



    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView Nombre,Descripcion,Ubicacion;
        ImageView imagen;

        // implementar el textview que esta en el layout item_list.xml
        public ViewHolderDatos(View itemView) {

            super(itemView);

            Nombre = (TextView)itemView.findViewById(R.id.idnombre);
            if(Utilidades.VISUALIZACION == Utilidades.LIST){
                Descripcion = (TextView)itemView.findViewById(R.id.iddescripcion);
            }

            Ubicacion = (TextView)itemView.findViewById(R.id.idubicacion);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);

        }


//YA NO UTLIZAMOS ESTE METODO PORQUE CREAMOS LA CLASE EXTRACCIONDEDATOS  DE AHI VAMOS  SACAR LOS DATOS
        /*public void asignardatos(String datoinformacion) {

Nombre.setText(datoinformacion);
            Descripcion.setText(datoinformacion);
            Ubicacion.setText(datoinformacion);
            imagen.setBackgroundResource();*/
       }

    }




