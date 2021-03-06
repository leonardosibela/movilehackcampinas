package br.com.movilehackcampinas.digitalwallet.api.services;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.model.Bill;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {
    @GET("login/{id}")
    Call<List<Bill>> loginAdmin(@Path("id") String userId);

    @GET("login/{id}")
    Call<List<Bill>> loginUser(@Path("id") String userId);
}
