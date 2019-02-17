package br.com.movilehackcampinas.digitalwallet.ui.homeuser;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.movilehackcampinas.digitalwallet.R;
import br.com.movilehackcampinas.digitalwallet.ui.homeadmin.AdminBillFragmentedAdapter;
import br.com.movilehackcampinas.digitalwallet.ui.homeadmin.AdminBillListAdapter;
import br.com.movilehackcampinas.digitalwallet.util.MockUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeUserActivity extends Activity {

    @BindView(R.id.recycler_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        ButterKnife.bind(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        //recyclerView.addItemDecoration(new SimpleItemDecoration(getBaseContext()));
        mRecyclerView.setAdapter(new UserBillAdapter(MockUtil.getSomeUserBills()));

    }

}
