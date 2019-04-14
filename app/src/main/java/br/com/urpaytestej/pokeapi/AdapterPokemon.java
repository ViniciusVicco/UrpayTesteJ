package br.com.urpaytestej.pokeapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.urpaytestej.R;
import br.com.urpaytestej.models.Pokemon;

public class AdapterPokemon extends RecyclerView.Adapter<AdapterPokemon.ViewHolder> {
    private ArrayList<Pokemon> dataset;
    public AdapterPokemon(){
        dataset = new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pokemon, viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Pokemon p = dataset.get(position);
    holder.nomepoke.setText(p.getName()); // Passando pro holder o atributo nome trago do dataset
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void Adicionar(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView portraitpoke ;
        private TextView nomepoke;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            portraitpoke = (ImageView) itemView.findViewById(R.id.pokeportrait);
            nomepoke = (TextView) itemView.findViewById(R.id.pokename);
        }
    }
}
