package br.com.movilehackcampinas.digitalwallet.ui.homeadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import br.com.movilehackcampinas.digitalwallet.R;
import br.com.movilehackcampinas.digitalwallet.util.MockUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdminActivity extends AppCompatActivity {

    @BindView(R.id.bills_admin_recycler)
    RecyclerView recyclerView;

    private AdminBillListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Saldo: R$5.000,00");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        adapter = new AdminBillListAdapter(MockUtil.getSomeBills());
        recyclerView.setAdapter(adapter);

    }
}