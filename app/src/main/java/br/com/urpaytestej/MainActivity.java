package br.com.urpaytestej;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import br.com.urpaytestej.models.Pokemon;
import br.com.urpaytestej.models.PokemonResposta;
import br.com.urpaytestej.pokeapi.PokeapiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit; // Criado uma variável do tipo retrofit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    ArrayList<Pokemon> listapokemon = pokemonResposta.getResults();
                    for (int i = 0; i < listapokemon.size(); i++) {// Verifica o tamanho e incrementa a procura na lista
                    }
                }
                else {
                    Log.e("", "Resposta" + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonResposta> call, Throwable t) {
            Log.e("","Falha" + t.getMessage());
            }
        }); // fila de requisição
    }
}
