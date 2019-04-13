package br.com.urpaytestej.pokeapi;

import br.com.urpaytestej.models.PokemonResposta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonResposta> obterListapokemon();
}
