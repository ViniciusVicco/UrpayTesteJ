package br.com.urpaytestej.models;

import java.util.ArrayList;

public class PokemonResposta {
    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }

    private ArrayList<Pokemon> results;
}
