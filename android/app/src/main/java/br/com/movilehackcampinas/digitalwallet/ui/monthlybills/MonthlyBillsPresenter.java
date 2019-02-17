package br.com.movilehackcampinas.digitalwallet.ui.monthlybills;

public class MonthlyBillsPresenter implements MonthlyBillsTask.Presenter {

    private MonthlyBillsTask.View view;

    public MonthlyBillsPresenter(MonthlyBillsTask.View view) {
        this.view = view;
    }
}