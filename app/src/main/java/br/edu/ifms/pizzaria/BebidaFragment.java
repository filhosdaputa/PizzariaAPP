package br.edu.ifms.pizzaria;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.edu.ifms.pizzaria.model.Bebida;
import com.google.gson.Gson;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class BebidaFragment extends Fragment {

    private ArrayList<Bebida> bebidaList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BebidaFragment() {
    }

    public static BebidaFragment newInstance() {
        BebidaFragment fragment = new BebidaFragment();
        fragment.bebidaList = new ArrayList<>();

        fragment.bebidaList.add(new Bebida("Suco", "R$ 3,50"));
        fragment.bebidaList.add(new Bebida("Refrigerante", "R$ 3,50"));
        fragment.bebidaList.add(new Bebida("Cerveja", "R$ 3,50"));



        /*try {
            final OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://localhost") // TODO resolve essa url
                    .build();

            Gson gson = new Gson();
            Response response = client.newCall(request).execute();
            ArrayList<Bebida> bebidas = gson.fromJson(response.body().charStream(), ArrayList<Bebida>.class);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bebida_list, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Bebidas");

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new BebidaRecyclerViewAdapter(bebidaList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO testar essa bagaça
            }
        }));
        return view;
    }
}
