package br.com.movilehackcampinas.digitalwallet.api.manager;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.api.APIService;
import br.com.movilehackcampinas.digitalwallet.model.Bill;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginManager {

    public void loginAdmin(LoginManagerCallback callback){
        String userId = "5d1b6cd746c348fbabb46ad728bafabf";
        new APIService().getService().getLoginService().loginAdmin(userId).enqueue(new Callback<List<Bill>>() {
            @Override
            public void onResponse(Call<List<Bill>> call, Response<List<Bill>> response) {
                if (response.isSuccessful()) {
                    List<Bill> billList = response.body();
                    callback.onSuccess(billList);
                }
            }

            @Override
            public void onFailure(Call<List<Bill>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    public void loginUser(LoginManagerCallback callback){
        String userId = "5d1b6cd746c348fbabb46ad728bafabf";
        new APIService().getService().getLoginService().loginUser(userId).enqueue(new Callback<List<Bill>>() {
            @Override
            public void onResponse(Call<List<Bill>> call, Response<List<Bill>> response) {
                if (response.isSuccessful()) {
                    List<Bill> billList = response.body();
                    callback.onSuccess(billList);
                }
            }

            @Override
            public void onFailure(Call<List<Bill>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    public interface LoginManagerCallback {
        void onSuccess(List<Bill> billList);
        void onFailure();
    }
}
