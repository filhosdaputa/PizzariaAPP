package br.edu.ifms.pizzaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Cardapio extends Fragment {

    private View vInflate;
    private Button btnBebidas;
    private Button btnPizzas;

    public Cardapio() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Cardapio.
     */
    public static Cardapio newInstance() {
        return new Cardapio();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vInflate = inflater.inflate(R.layout.fragment_cardapio, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Cardápio");

        btnBebidas = (Button) vInflate.findViewById(R.id.btnBebidas);
        btnPizzas = (Button) vInflate.findViewById(R.id.btnPizzas);

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, BebidaFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnPizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return vInflate;
    }
}
