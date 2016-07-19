package br.edu.ifms.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import br.edu.ifms.pizzaria.R;
import br.edu.ifms.pizzaria.model.Categoria;
import br.edu.ifms.pizzaria.model.Produto;
import br.edu.ifms.pizzaria.model.SubCategoria;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Categoria> categorias;
    public static List<SubCategoria> subCategorias;
    public static List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Display icon in the toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Intent i = getIntent();
        String json = i.getStringExtra("json");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, TelaInicial.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
