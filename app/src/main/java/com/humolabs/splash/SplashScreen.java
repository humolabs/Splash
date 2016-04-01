package com.humolabs.splash;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    // Seteo la duración del splash screen en 3 segundos
    private static final long SPLASH_SCREEN_DELAY = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuro la pantalla con orientación vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Oculto la barra de título
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                // Inicia la siguiente actividad
                Intent mainIntent = new Intent().setClass(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);

                // Cierro la actividad para que el usuario no pueda volver atrás presionando el botón atrás
                finish();
            }
        }; // Cierra TimerTask

        // Simulo que la aplicación tarda en cargar
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    } // Cierra onCreate


} // Cierra Activity
