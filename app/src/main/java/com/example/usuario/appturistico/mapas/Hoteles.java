package com.example.usuario.appturistico.mapas;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.appturistico.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Hoteles.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Hoteles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Hoteles extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootview;
    private GoogleMap googleMap;
    private GoogleMap googleMap1;
    private  GoogleMap googleMap2;
    private MapView mapView;
    private TextView btnprueba;
    private List<Address> address;
    private Geocoder geocoder;

    private OnFragmentInteractionListener mListener;


    public Hoteles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Hoteles.
     */
    // TODO: Rename and change types and number of parameters
    public static Hoteles newInstance(String param1, String param2) {
        Hoteles fragment = new Hoteles();
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
      rootview =  inflater.inflate(R.layout.fragment_hoteles, container, false);


      return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView   = (MapView)rootview.findViewById(R.id.maps);
        if(mapView !=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        googleMap1 = googleMap;
        googleMap2 = googleMap;




            CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

            LatLng Bogota = new LatLng(5.755128,-72.908522);
            googleMap.addMarker(new MarkerOptions().position(Bogota).title("Estoy aqui").snippet("cra 12").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_logo)).draggable(true));



            LatLng sitio2 = new LatLng(5.757749, -72.906590);
            googleMap.addMarker(new MarkerOptions().position(sitio2).title("sitio 2").snippet("cra 13").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_sitio3)).draggable(true));
            googleMap2.moveCamera(CameraUpdateFactory.newLatLng(sitio2));


            LatLng sitio3 = new LatLng(5.758165, -72.907631);
            googleMap.addMarker(new MarkerOptions().position(sitio3).title("sitio 3").snippet("cra 14").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_sitio2)).draggable(true));
            googleMap1.moveCamera(CameraUpdateFactory.newLatLng(sitio3));



            googleMap.animateCamera(zoom);
            googleMap.setOnMarkerDragListener(this);

            geocoder = new Geocoder(getContext(), Locale.getDefault());







//PRUEBA GIT


    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
double latitud = 0;
double longitud = 0;

latitud =  marker.getPosition().latitude;
longitud = marker.getPosition().longitude;


        try {
            address =  geocoder.getFromLocation(latitud, longitud, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String adrees  = address.get(0).getAddressLine(0);
        String city = address.get(0).getLocality();
        String estado = address.get(0).getAdminArea();
        String country = address.get(0).getCountryName();
        String postalcode = address.get(0).getPostalCode();



        Toast.makeText(getContext(),"Direccion"+adrees+"\n" +
                "Ciudad:"+city+"\n" +
                "estado:"+estado+"\n" +
                "Country"+country+"\n" +
                "posta code"+postalcode,Toast.LENGTH_SHORT).show();

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
