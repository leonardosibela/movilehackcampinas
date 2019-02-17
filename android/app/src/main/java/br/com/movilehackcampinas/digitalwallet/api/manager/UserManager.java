package br.com.movilehackcampinas.digitalwallet.api.manager;

import br.com.movilehackcampinas.digitalwallet.api.APIService;
import br.com.movilehackcampinas.digitalwallet.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserManager {

    private void createUser(User user, UserManagerCallback callback) {
        APIService.getService().getUserService().createUser(user).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                callback.onSuccess();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    interface UserManagerCallback {
        void onSuccess();
        void onFailure();
    }
}
