package br.com.movilehackcampinas.digitalwallet.api;

import br.com.movilehackcampinas.digitalwallet.api.services.LoginService;
import br.com.movilehackcampinas.digitalwallet.api.services.PayProratedValue;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    private static Retrofit sInstance;

    public static APIService getService() {
        if (sInstance == null) {
            sInstance= new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sInstance.create(APIService.class);
    }
    public LoginService getLoginService(){
        return sInstance.create(LoginService.class);
    }

    public PayProratedValue getProratedValueService(){
        return sInstance.create(PayProratedValue.class);
    }
}
