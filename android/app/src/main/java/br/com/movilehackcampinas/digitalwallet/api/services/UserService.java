package br.com.movilehackcampinas.digitalwallet.api.services;

import br.com.movilehackcampinas.digitalwallet.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("users/new")
    Call<Void> createUser(@Body User user);
}
