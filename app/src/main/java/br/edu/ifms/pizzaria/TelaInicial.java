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
import android.widget.ImageButton;

public class TelaInicial extends Fragment {

    private View vInflate;
    private Button btnCardapio;
    private ImageButton imageButtonInformacao;

    public TelaInicial() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TelaInicial.
     */
    public static TelaInicial newInstance() {
        return new TelaInicial();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vInflate = inflater.inflate(R.layout.fragment_tela_inicial, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(" Projeto Pizzaria");

        btnCardapio = (Button) vInflate.findViewById(R.id.btnCardapio);
        imageButtonInformacao = (ImageButton) vInflate.findViewById(R.id.imageButtonInformacao);

        btnCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, Cardapio.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        imageButtonInformacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return vInflate;
    }
}
