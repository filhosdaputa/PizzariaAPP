package br.edu.ifms.pizzaria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SplashActivity extends Activity {

    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        new BackgroundWebRunner().execute("http://10.2.2.8:8080/pizzaria/services/CardapioWS");

        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        i.putExtra("produtos", "teste");
        i.putExtra("categorias", "teste");
        i.putExtra("subcategorias", "teste");
        i.putExtra("preco", "teste");
        startActivity(i);

        finish();
    }
}