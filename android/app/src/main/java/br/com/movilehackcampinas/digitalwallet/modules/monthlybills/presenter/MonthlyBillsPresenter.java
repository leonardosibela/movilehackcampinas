package br.com.movilehackcampinas.digitalwallet.modules.monthlybills.presenter;

import br.com.movilehackcampinas.digitalwallet.modules.monthlybills.task.MonthlyBillsTask;

public class MonthlyBillsPresenter implements MonthlyBillsTask.Presenter {

    private MonthlyBillsTask.View view;

    public MonthlyBillsPresenter(MonthlyBillsTask.View view) {
        this.view = view;
    }
}