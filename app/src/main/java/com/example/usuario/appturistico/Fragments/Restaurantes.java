package com.example.usuario.appturistico.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.appturistico.Clases.Adaptador;
import com.example.usuario.appturistico.Clases.Utilidades;
import com.example.usuario.appturistico.Clases.extracciondesitios;
import com.example.usuario.appturistico.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Restaurantes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Restaurantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Restaurantes extends Fragment {
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
    public Restaurantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Restaurantes.
     */
    // TODO: Rename and change types and number of parameters
    public static Restaurantes newInstance(String param1, String param2) {
        Restaurantes fragment = new Restaurantes();
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
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_sitios, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.Recyclerid);

        seleccionbotongrid();
        logicaderecycler();


        return view;
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

    public boolean seleccionbotongrid() {
        Utilidades.VISUALIZACION = Utilidades.GRID;
        logicaderecycler();


        return true;


    }

    public void logicaderecycler() {

        //para lista
        listadedatos = new ArrayList<>();//para lista


            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));   //para lista  con columnas







        alimentarlista();

        Adaptador adaptador = new Adaptador(listadedatos);
        recyclerView.setAdapter(adaptador);

    }


    public void alimentarlista() {


        listadedatos.add(new extracciondesitios("la palma",getResources().getString(R.string.descricion),"madrid",R.drawable.sitio3,R.drawable.sitio3));
        listadedatos.add(new extracciondesitios("Wh helpe","disfruta, baila , rie con nuestro sitio turistico de hotles ","madrid",R.drawable.sitio4,R.drawable.sitio4));
        listadedatos.add(new extracciondesitios("Cortos","es  el mejor sitio para ir de vaciones","madrid",R.drawable.sitio5,1));
        listadedatos.add(new extracciondesitios("ResULA","disfruta,  \"baila\" , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio6,R.drawable.sitio6));
        listadedatos.add(new extracciondesitios("Trivago","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio7,R.drawable.sitio7));
        listadedatos.add(new extracciondesitios("enMast","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio8,R.drawable.sitio8));
        listadedatos.add(new extracciondesitios("Travel","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio9,R.drawable.sitio9));
        listadedatos.add(new extracciondesitios("No fake","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio10,R.drawable.sitio10));
        listadedatos.add(new extracciondesitios("yks 23","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio11,R.drawable.sitio11));
        listadedatos.add(new extracciondesitios("yks 23","disfruta, baila , rie con nuestro sitio turistico de hotles","madrid",R.drawable.sitio11,R.drawable.sitio11));

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
