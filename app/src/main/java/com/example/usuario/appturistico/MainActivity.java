package com.example.usuario.appturistico;



import android.content.Context;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.usuario.appturistico.Clases.Utilidades;
import com.example.usuario.appturistico.Clases.extracciondesitios;
import com.example.usuario.appturistico.Fragments.Fragmentdetalle;
import com.example.usuario.appturistico.mapas.Hoteles;
import com.example.usuario.appturistico.Fragments.Presentacion;
import com.example.usuario.appturistico.Fragments.Restaurantes;
import com.example.usuario.appturistico.Fragments.inicio;
import com.example.usuario.appturistico.mapas.sitio1;
import com.example.usuario.appturistico.mapas.sitio2;
import com.example.usuario.appturistico.interfaces.comunicacion;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,inicio.OnFragmentInteractionListener, sitios.OnFragmentInteractionListener,Presentacion.OnFragmentInteractionListener, Restaurantes.OnFragmentInteractionListener, Hoteles.OnFragmentInteractionListener,Fragmentdetalle.OnFragmentInteractionListener,sitio1.OnFragmentInteractionListener, sitio2.OnFragmentInteractionListener, fragmentmaestr.OnFragmentInteractionListener, View.OnClickListener, comunicacion {


    sitios fragments = new sitios();

    MenuItem menuItem;
    private View v;

      sitios  sitios;


//RecyclerView Personalizado en Android video visto
    //Como Usar RecyclerView en Android
//Como usar CardView en Android
    //Part 2. Crear Fragment Detalle - (Patron Maestro Detalle)
    //RecyclerView Dinamico en Android - Modo List a Modo Grid



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Context themeWrapper =
                new ContextThemeWrapper(getApplication(), R.style.AppTheme);



   /*  if(findViewById(R.id.contenedor)!=null) {
         if (savedInstanceState != null) {
             return;
         }

         sitios = new sitios();
         getSupportFragmentManager().beginTransaction().replace(R.id.contenedor , sitios).commit();

     }*/






       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


 if(Utilidades.VALIDAPANTALLA == true) { //Control de rotacion
    Fragment fragment = null;
    fragment = new Presentacion();
    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();

    Utilidades.VALIDAPANTALLA = false;


}










    }



    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);



        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        sitios fragment = new sitios();



        Fragment fragmentsss  = null;

       try {

           switch (item.getItemId()){

               case R.id.list:


                   fragmentsss = new sitios();



                   break;

               case R.id.search:


                   fragmentsss = new Restaurantes();

                   break;

           }

       }catch (Exception ese){
           Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();

       }

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentsss).commit();
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
      //  FragmentManager fragmentManager = getFragmentManager();



        Fragment fragment  = null;
        boolean fragmentselecion = false;




        if (id == R.id.nav_camera) {

            fragment = new Presentacion();
            fragmentselecion = true;

        } else if (id == R.id.nav_gallery) {

            fragment = new sitios();
            fragmentselecion = true;
         //   fragmentManager.beginTransaction().replace(R.id.contenedor,new sitios()).commit();
        } else if (id == R.id.nav_slideshow) {
            fragment = new Hoteles();
            fragmentselecion = true;
        } else if (id == R.id.nav_send) {

            fragment = new Restaurantes();
            fragmentselecion = true;

        }

        if (fragmentselecion==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);






    }

    @Override
    public void onClick(View v) {
       // fragments.seleccionbotongrid();
    }

    @Override
    public void enviarsitio(extracciondesitios extracciondesitios) {

     /*   Fragmentdetalle fragmentdetalle;
        //PARA EL FRAGMENT DETALLE
fragmentdetalle = (Fragmentdetalle) this.getSupportFragmentManager().findFragmentById(R.id.fragdetlle);
if(fragmentdetalle != null && findViewById(R.id.contenedor)==null){
    fragmentdetalle.asignarinformacion(extracciondesitios);

}else {*/

    Fragmentdetalle fragmentdetalle1 = new Fragmentdetalle();

    Bundle bundle = new Bundle();
    bundle.putSerializable("objeto", extracciondesitios);
    fragmentdetalle1.setArguments(bundle);

    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentdetalle1).addToBackStack(null).commit();










    }
}
