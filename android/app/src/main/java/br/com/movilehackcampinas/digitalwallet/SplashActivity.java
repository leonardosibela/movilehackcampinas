package br.com.movilehackcampinas.digitalwallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.api.manager.LoginManager;
import br.com.movilehackcampinas.digitalwallet.model.Bill;
import br.com.movilehackcampinas.digitalwallet.ui.homeadmin.HomeAdminActivity;
import br.com.movilehackcampinas.digitalwallet.ui.homeuser.HomeUserActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.admin_user)
    public void registerButton(View v){
        startActivity(new Intent(SplashActivity.this, HomeAdminActivity.class));
        LoginManager loginManager = new LoginManager();
        loginManager.loginAdmin(new LoginManager.LoginManagerCallback() {
            @Override
            public void onSuccess(List<Bill> billList) {
                Log.d("","");
            }

            @Override
            public void onFailure() {
                Log.d("","");
            }
        });
    }

    @OnClick(R.id.common_user)
    public void openCommonUser(View v){
        startActivity(new Intent(SplashActivity.this, HomeUserActivity.class));
    }
}