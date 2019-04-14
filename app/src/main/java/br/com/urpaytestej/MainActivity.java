package br.com.urpaytestej;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.urpaytestej.models.Pokemon;
import br.com.urpaytestej.models.PokemonResposta;
import br.com.urpaytestej.pokeapi.AdapterPokemon;
import br.com.urpaytestej.pokeapi.PokeapiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit; // Criado uma variável do tipo retrofit
    private RecyclerView recyclerView;
    private AdapterPokemon adapterPokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapterPokemon = new AdapterPokemon();
        recyclerView.setAdapter(adapterPokemon);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        Toast.makeText(getApplicationContext(),"Role o campo branco para baixo",Toast.LENGTH_SHORT).show();

        retrofit = new Retrofit.Builder() //
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        obterDados();
    }
    private  void obterDados(){
        PokeapiService service = retrofit.create(PokeapiService.class); // Utilizando a interface
        final Call<PokemonResposta> pokemonRespostaCall = service.obterListapokemon();
        pokemonRespostaCall.enqueue(new Callback<PokemonResposta>() {
            @Override
            public void onResponse(Call<PokemonResposta> call, Response<PokemonResposta> response) {
                if (response.isSuccessful()) {
                    PokemonResposta pokemonResposta = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonResposta.getResults();

                    adapterPokemon.Adicionar(listaPokemon);

                    Log.i("Teste","" + listaPokemon);
                    for (int i = 0; i < listaPokemon.size(); i++) {// Verifica o tamanho e incrementa a procura na lista
                   Pokemon p = listaPokemon.get(i); // Adiciona a uma instância da classe pokemon um elemento do tipo pokemon
                        String teste = p.getName().toString();
                        System.out.println("POKEMON"+" " + teste);
                    Log.i("","Pokemon" + p.getName());
                    }
                }
                else {
                    Log.e("", "onResponse" + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonResposta> call, Throwable t) {
            Log.e("","onFailure" + t.getMessage());
            }
        }); // fila de requisição
    }
}
