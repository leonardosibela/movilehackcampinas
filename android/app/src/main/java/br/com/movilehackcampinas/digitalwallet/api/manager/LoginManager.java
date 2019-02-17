package br.com.movilehackcampinas.digitalwallet.api.manager;

import br.com.movilehackcampinas.digitalwallet.api.APIService;
import br.com.movilehackcampinas.digitalwallet.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginManager {

    public void login(String email, LoginManagerCallback callback){
        APIService.getService().getLoginService().login(email).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    callback.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    interface LoginManagerCallback {
        void onSuccess(User user);
        void onFailure();
    }
}
