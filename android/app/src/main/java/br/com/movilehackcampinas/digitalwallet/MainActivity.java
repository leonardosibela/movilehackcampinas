package br.com.movilehackcampinas.digitalwallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.movilehackcampinas.digitalwallet.ui.monthlybills.MonthlyBillsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MonthlyBillsFragment.newInstance())
                    .commitNow();
        }
    }
}