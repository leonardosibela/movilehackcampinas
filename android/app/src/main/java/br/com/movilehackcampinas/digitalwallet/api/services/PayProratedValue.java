package br.com.movilehackcampinas.digitalwallet.api.services;

import br.com.movilehackcampinas.digitalwallet.model.ProratedValue;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PayProratedValue {
    @POST("login/{id}")
    Call<Void> payProratedValue(@Body ProratedValue proratedValue);
}
