package br.edu.ifms.pizzaria;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.edu.ifms.pizzaria.model.Bebida;

import java.util.ArrayList;

public class BebidaRecyclerViewAdapter extends RecyclerView.Adapter<BebidaRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Bebida> bebidaArrayList;
    private View.OnClickListener listener;

    public BebidaRecyclerViewAdapter(ArrayList<Bebida> bebidaArrayList, View.OnClickListener listener) {
        this.bebidaArrayList = bebidaArrayList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_bebida, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Bebida bebida = bebidaArrayList.get(position);
        holder.textViewNome.setText(bebida.getNome());
        holder.textViewPreco.setText(bebida.getPreco());
    }

    @Override
    public int getItemCount() {
        return bebidaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNome;
        private TextView textViewPreco;

        public ViewHolder(View itemView, View.OnClickListener listener) {
            super(itemView);

            textViewNome = (TextView) itemView.findViewById(R.id.textViewNome);
            textViewPreco = (TextView) itemView.findViewById(R.id.textViewPreco);

            itemView.setOnClickListener(listener);
        }
    }
}
