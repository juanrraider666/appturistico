package com.example.usuario.appturistico;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.usuario.appturistico.Clases.Adaptador;
import com.example.usuario.appturistico.Clases.Utilidades;
import com.example.usuario.appturistico.Clases.extracciondesitios;
import com.example.usuario.appturistico.Fragments.Fragmentdetalle;
import com.example.usuario.appturistico.interfaces.comunicacion;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link sitios.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link sitios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sitios extends Fragment  implements  comunicacion, Fragmentdetalle.OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ArrayList<extracciondesitios> listadedatos; //para lista
    RecyclerView recyclerView; //para lista
    Button btnlist,btngrid;
    ImageView imageView;
    TextView textView;

    Fragmentdetalle  fragmentdetalle;

    private View v;

    private  View.OnClickListener listener;
 FloatingActionButton mapa,mapa2,mapa3;

    Activity activity;
    comunicacion interfacecomunicacion;
    MenuItem menuItem;
    Toolbar toolbar;
    public sitios() {
        // Required empty public constructor
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sitios.
     */
    // TODO: Rename and change types and number of parameters
    public static sitios newInstance(String param1, String param2) {

        sitios fragment = new sitios();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);




        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



   v  =inflater.inflate(R.layout.fragment_sitios, container, false);
  textView =(TextView)v.findViewById(R.id.idtextodetalle);
        imageView = (ImageView)v.findViewById(R.id.idmiagendetalle);

try {

    listadedatos = new ArrayList<>();
    recyclerView = (RecyclerView) v.findViewById(R.id.Recyclerid);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
 /*  btnlist = (Button)view.findViewById(R.id.idlist);
        btngrid = (Button)view.findViewById(R.id.idgrid);*/
    seleccionbotonlista();
    alimentarlista();

    //   logicaderecycler();


      /*  btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               seleccionbotonlista();
            }
        });



        btngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               seleccionbotongrid();
            }
        });
        logicaderecycler();

      //  for (int i = 0;  i<=50; i++){
          //  listadedatos.add("Dato: "+i+"");//para lista
       // }

       // Adaptador adaptador = new Adaptador(listadedatos);//para lista
      //  recyclerView.setAdapter(adaptador);

/*/



    Adaptador adaptador = new Adaptador(listadedatos);//para lista
    recyclerView.setAdapter(adaptador);
    adaptador.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {

                interfacecomunicacion.enviarsitio(listadedatos.get(recyclerView.getChildAdapterPosition(v)));
            }catch (Exception ex){
                String exx = "Solo vista ";
                Toast.makeText(getContext()," "+exx,Toast.LENGTH_LONG).show();
            }
        }
    });

}catch (Exception ex){

}

        return  v;
    }



/*public  void onClick(View v){ // metodo para el cambio de lista a grid


    seleccionboton();

        switch (v.getId()){
            case R.id.idlist :

                Utilidades.VISUALIZACION = Utilidades.LIST;
                break;

            case R.id.idgrid:
                Utilidades.VISUALIZACION = Utilidades.GRID;
                break;
default:

        }


    logicaderecycler();


}*/

    public boolean seleccionbotonlista() {
        Utilidades.VISUALIZACION = Utilidades.LIST;
        logicaderecycler();


        return true;
    }
     /*   public boolean seleccionbotongrid() {
            Utilidades.VISUALIZACION = Utilidades.GRID;
            logicaderecycler();


            return true;


    }*/





    public void logicaderecycler() {

         //para lista
        listadedatos = new ArrayList<>();//para lista

        if(Utilidades.VISUALIZACION == Utilidades.LIST){
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));  //para lista
        }/*else {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));   //para lista  con columnas
        }*/






        alimentarlista();

        Adaptador adaptador = new Adaptador(listadedatos);
        recyclerView.setAdapter(adaptador);

    }


    public void alimentarlista() {


        listadedatos.add(new extracciondesitios("la palma",getResources().getString(R.string.descricion),"madrid",R.drawable.sitio3,R.drawable.sitio3));
        listadedatos.add(new extracciondesitios("Wh helpe",getResources().getString(R.string.descricion2),"madrid",R.drawable.sitio4,R.drawable.sitio4));
        listadedatos.add(new extracciondesitios("Cortos","es  el mejor sitio para ir de vaciones","madrid",R.drawable.sitio5,R.drawable.sitio5));
        listadedatos.add(new extracciondesitios("ResULA","disfruta,  \"baila\" , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio6,R.drawable.sitio6));
        listadedatos.add(new extracciondesitios("Trivago","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio7,R.drawable.sitio7));
        listadedatos.add(new extracciondesitios("enMast","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio8,R.drawable.sitio8));
        listadedatos.add(new extracciondesitios("Travel","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio9,R.drawable.sitio9));
        listadedatos.add(new extracciondesitios("No fake","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio10,R.drawable.sitio10));
        listadedatos.add(new extracciondesitios("yks 23","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio11,R.drawable.sitio11));
        listadedatos.add(new extracciondesitios("yks 23","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio11,R.drawable.sitio11));



    }


    public void setonclik(View.OnClickListener listener){
        this.listener = listener;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfacecomunicacion = (comunicacion) this.activity;
        }//PARA FRAGMENT DETALLE


        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void enviarsitio(extracciondesitios extracciondesitios) {





            Bundle bundle = new Bundle();
            bundle.putSerializable("objeto", extracciondesitios);
            fragmentdetalle.setArguments(bundle);

            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentdetalle).addToBackStack(null).commit();



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
