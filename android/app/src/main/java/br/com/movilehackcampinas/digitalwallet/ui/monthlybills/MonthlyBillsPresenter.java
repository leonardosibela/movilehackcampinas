package br.com.movilehackcampinas.digitalwallet.ui.monthlybills;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.model.Bill;

public class MonthlyBillsPresenter implements MonthlyBillsTask.Presenter {

    private MonthlyBillsTask.View view;

    public MonthlyBillsPresenter(MonthlyBillsTask.View view) {
        this.view = view;
    }

    @Override
    public void onViewReady() {
        view.displayBills(getAllBills());
    }

    private List<Bill> getAllBills() {
        return null;
    }
}