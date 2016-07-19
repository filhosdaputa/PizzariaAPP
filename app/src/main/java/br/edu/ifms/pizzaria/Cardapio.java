package br.edu.ifms.pizzaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import br.edu.ifms.pizzaria.model.Categoria;
import br.edu.ifms.pizzaria.model.SubCategoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static br.edu.ifms.pizzaria.MainActivity.subCategorias;

public class Cardapio extends Fragment {

    private View vInflate;
    private Spinner spCategoria;
    private Spinner spSubCategoria;

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

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(" Cardápio");

        spCategoria = (Spinner) vInflate.findViewById(R.id.spCategoria);
        spSubCategoria = (Spinner) vInflate.findViewById(R.id.spSubCategoria);

        List<String> selecione2 = new ArrayList<String>();
        selecione2.add("Selecione");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, selecione2);
        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spCategoria.setAdapter(dataAdapter2);

        List<String> selecione = new ArrayList<String>();
        selecione.add("Selecione");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, selecione);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spSubCategoria.setAdapter(dataAdapter);

        spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<SubCategoria> subCategoriaList = new ArrayList<>();
                subCategoriaList.add(new SubCategoria("Selecione"));

                if (position > 0) {
                    Categoria categoria = (Categoria) parent.getItemAtPosition(position);

                    for (SubCategoria subCategoria : MainActivity.subCategorias) {
                        if (subCategoria.getCatId().equals(categoria.getCatId())) {
                            subCategoriaList.add(subCategoria);
                        }
                    }
                }

                ArrayAdapter<SubCategoria> subCategoriaArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, subCategoriaList);
                subCategoriaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSubCategoria.setAdapter(subCategoriaArrayAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spSubCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    SubCategoria subCategoria = (SubCategoria) parent.getItemAtPosition(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return vInflate;
    }
}
