package com.example.usuario.appturistico;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent(Splash.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animacionentrada, R.anim.animacionsalida);
        finish();
    }
},1000);





    }

}
