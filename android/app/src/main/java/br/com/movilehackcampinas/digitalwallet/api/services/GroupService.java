package br.com.movilehackcampinas.digitalwallet.api.services;

import br.com.movilehackcampinas.digitalwallet.model.Group;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

public interface GroupService {
    @POST("xyza")
    Call<Group> createGroup(Group group);

    @POST
    Call<Void> updateGroup(Group group);

    @DELETE
    Call<Void> deleteGroup(Group groupId);
}
