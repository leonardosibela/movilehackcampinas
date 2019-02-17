package br.com.movilehackcampinas.digitalwallet.api.manager;

import br.com.movilehackcampinas.digitalwallet.api.APIService;
import br.com.movilehackcampinas.digitalwallet.model.ProratedValue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProratedValueManager {

    public void payProratedBill(ProratedValue proratedValue, ProratedValueManagerCallback callback) {
        new APIService().getService().getProratedValueService().payProratedValue(proratedValue).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure();
            }
        });

    }

    interface ProratedValueManagerCallback{
        void onSuccess();
        void onFailure();
    }
}
