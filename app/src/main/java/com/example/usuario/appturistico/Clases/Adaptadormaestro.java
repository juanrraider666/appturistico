package com.example.usuario.appturistico.Clases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.usuario.appturistico.R;

import java.util.ArrayList;

public class Adaptadormaestro extends RecyclerView.Adapter<Adaptadormaestro.myviewholder> {//4

    private ArrayList<extracciondesitios> listamenu;
    private onClickrecycler listener;

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        myviewholder viewHolder =new myviewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        extracciondesitios extraccion = listamenu.get(position);
        holder.bind(extraccion,listener);

    }

    @Override
    public int getItemCount() {
        return listamenu.size();
    }

    //1
    public interface onClickrecycler{

        void onCLickItemRecycler(extracciondesitios extraccion);
    }
    //2
    public Adaptadormaestro(ArrayList<extracciondesitios> listamenu, onClickrecycler listener) {
        this.listamenu = listamenu;
        this.listener = listener;
    }

    //3
    public static class  myviewholder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public myviewholder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imagen);
        }

        public  void bind(final extracciondesitios extraccion, final onClickrecycler listener){
//Glide.with(imageView.getContext()).load(extraccion.getImagen()).into(imageView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCLickItemRecycler(extraccion);
                }
            });
        }
    }
}

