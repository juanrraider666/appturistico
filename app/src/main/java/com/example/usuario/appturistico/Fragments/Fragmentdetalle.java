package com.example.usuario.appturistico.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.appturistico.Clases.extracciondesitios;
import com.example.usuario.appturistico.R;
import com.example.usuario.appturistico.mapas.sitio1;
import com.example.usuario.appturistico.mapas.sitio2;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragmentdetalle.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragmentdetalle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmentdetalle extends Fragment implements sitio1.OnFragmentInteractionListener , sitio2.OnFragmentInteractionListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    TextView textView ;
    public FloatingActionButton mapa,mapa2, mapa3;
    ImageView imageView;
    private  View view;
    public Fragmentdetalle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmentdetalle.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmentdetalle newInstance(String param1, String param2) {
        Fragmentdetalle fragment = new Fragmentdetalle();
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
   view =  inflater.inflate(R.layout.fragment_fragmentdetalle, container, false);

textView =(TextView)view.findViewById(R.id.idtextodetalle);
imageView = (ImageView)view.findViewById(R.id.idmiagendetalle);
mapa = (FloatingActionButton) view.findViewById(R.id.mapa) ;
mapa2 = (FloatingActionButton) view.findViewById(R.id.mapa2);
mapa3 = (FloatingActionButton) view.findViewById(R.id.mapa3);

try {
    mapa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new sitio1();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();



        }
    });

}catch (Exception ex){

}

try {
    mapa2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new sitio2();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
        }
    });

}catch (Exception ex){
    Toast.makeText(getContext(),"Mapa",Toast.LENGTH_SHORT).show();
}



    Bundle Objeto  = getArguments();
    extracciondesitios extracciondesitio=null;
 if(Objeto != null){
     extracciondesitio = (extracciondesitios) Objeto.getSerializable("objeto");
     asignarinformacion(extracciondesitio);

        }
   return  view;
    }

    public void asignarinformacion(extracciondesitios extracciondesitio) {
        imageView.setImageResource(extracciondesitio.getImagendetalle());

        textView.setText(extracciondesitio.getDescripcion());
try {

    if(textView.getText() == getResources().getString(R.string.descricion)){

        mapa2.setVisibility(View.INVISIBLE);
        mapa3.setVisibility(View.INVISIBLE);
        mapa.setVisibility(View.VISIBLE);



    }else if( textView.getText()== getResources().getString(R.string.descricion2)){

        mapa3.setVisibility(View.INVISIBLE);
        mapa2.setVisibility(View.VISIBLE);
        mapa.setVisibility(View.INVISIBLE);

    }

}catch (Exception ex){
    Toast.makeText(getContext(),""+ex,Toast.LENGTH_SHORT).show();
}
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






    @Override
    public void onFragmentInteraction(Uri uri) {

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
