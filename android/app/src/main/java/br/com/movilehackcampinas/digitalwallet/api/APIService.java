package br.com.movilehackcampinas.digitalwallet.api;

import br.com.movilehackcampinas.digitalwallet.api.services.GroupService;
import br.com.movilehackcampinas.digitalwallet.api.services.LoginService;
import br.com.movilehackcampinas.digitalwallet.api.services.UserService;
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

    public UserService getUserService(){
        return sInstance.create(UserService.class);
    }

    public LoginService getLoginService(){
        return sInstance.create(LoginService.class);
    }

    public GroupService getGroupService(){
        return sInstance.create(GroupService.class);
    }


}
