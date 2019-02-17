package br.com.movilehackcampinas.digitalwallet.api.services;

import br.com.movilehackcampinas.digitalwallet.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface LoginService {
    @POST("users/new")
    Call<User> login(@Field("email") String email);
}
