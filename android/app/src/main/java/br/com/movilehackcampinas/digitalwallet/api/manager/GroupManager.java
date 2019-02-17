package br.com.movilehackcampinas.digitalwallet.api.manager;

import android.support.annotation.Nullable;

import br.com.movilehackcampinas.digitalwallet.api.APIService;
import br.com.movilehackcampinas.digitalwallet.model.Group;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupManager {

    public void createGroup(Group group, GroupManagerCallback callback) {
        APIService.getService().getGroupService().createGroup(group).enqueue(new Callback<Group>() {
            @Override
            public void onResponse(Call<Group> call, Response<Group> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Group> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    public void updateGroup(Group group, GroupManagerCallback callback){
        APIService.getService().getGroupService().updateGroup(group).enqueue(getServiceVoidCallback(callback));
    }

    public void deleteGroup(Group group, GroupManagerCallback callback){
        APIService.getService().getGroupService().deleteGroup(group).enqueue(getServiceVoidCallback(callback));
    }

    private Callback<Void> getServiceVoidCallback(GroupManagerCallback callback){
        return new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                callback.onSuccess(null);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure();
            }
        };
    }

    interface GroupManagerCallback {
        void onSuccess(@Nullable Group user);
        void onFailure();
    }
}
