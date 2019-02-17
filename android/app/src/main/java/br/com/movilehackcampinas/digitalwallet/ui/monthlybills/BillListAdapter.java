package br.com.movilehackcampinas.digitalwallet.ui.monthlybills;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.model.Bill;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillViewHolder> {

    private List<Bill> bills;

    public BillListAdapter(List<Bill> bills) {
        this.bills = bills;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bill, viewGroup, false);
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder billViewHolder, int position) {
        Bill bill = bills.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class BillViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bill_name)
        TextView billName;

        @BindView(R.id.total_amount)
        TextView totalAmount;

        @BindView(R.id.percentage)
        TextView percentage;

        @BindView(R.id.payed_amount)
        TextView payedAmount;

        BillViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}