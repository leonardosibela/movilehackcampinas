package br.com.movilehackcampinas.digitalwallet.ui.monthlybills;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.model.Bill;

public interface MonthlyBillsTask {

    interface View {
        void displayBills(List<Bill> allBills);
    }

    interface Presenter {

        void onViewReady();

    }
}