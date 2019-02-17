package br.com.movilehackcampinas.digitalwallet.ui.monthlybills;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.model.Bill;
import br.com.movilehackcampinas.digitalwallet.util.MockUtil;

public class MonthlyBillsPresenter implements MonthlyBillsTask.Presenter {

    private MonthlyBillsTask.View view;

    public MonthlyBillsPresenter(MonthlyBillsTask.View view) {
        this.view = view;
    }

    @Override
    public void onViewReady() {
        // FIXME: ASK SERVER FOR BILLS

        List<Bill> bills = MockUtil.getSomeBills();
        view.displayBills(bills);
    }
}