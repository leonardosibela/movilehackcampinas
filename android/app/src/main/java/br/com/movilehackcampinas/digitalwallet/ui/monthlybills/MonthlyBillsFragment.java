package br.com.movilehackcampinas.digitalwallet.ui.monthlybills;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.movilehackcampinas.digitalwallet.R;

public class MonthlyBillsFragment extends Fragment implements MonthlyBillsTask.View {

    private MonthlyBillsTask.Presenter presenter;

    public static MonthlyBillsFragment newInstance() {
        return new MonthlyBillsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.monthly_bills_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new MonthlyBillsPresenter(this);
    }
}