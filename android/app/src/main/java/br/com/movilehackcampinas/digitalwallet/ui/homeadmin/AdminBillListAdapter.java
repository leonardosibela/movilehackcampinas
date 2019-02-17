package br.com.movilehackcampinas.digitalwallet.ui.homeadmin;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.R;
import br.com.movilehackcampinas.digitalwallet.model.Bill;
import br.com.movilehackcampinas.digitalwallet.util.MockUtil;
import br.com.movilehackcampinas.digitalwallet.util.StringUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminBillListAdapter extends RecyclerView.Adapter<AdminBillListAdapter.AdminBillItemViewHolder> {

    private List<Bill> billsList;

    public AdminBillListAdapter(List<Bill> billsList) {
        this.billsList = billsList;
    }

    @NonNull
    @Override
    public AdminBillItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_admin_bill, viewGroup, false);
        return new AdminBillItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminBillItemViewHolder holder, int i) {
        Bill bill = billsList.get(i);
        holder.billName.setText(bill.getName());
        holder.value.setText(StringUtil.doubleToCurrency(bill.getTotalAmount()));
        holder.payedAmount.setText(StringUtil.doubleToCurrency(bill.getPayedAmount()));

        AdminBillFragmentedAdapter adapter = new AdminBillFragmentedAdapter(bill.getProratedValues());
        holder.billFragmentedRecycler.setAdapter(adapter);

        holder.billFragmentedRecycler.setHasFixedSize(true);
        holder.billFragmentedRecycler.setLayoutManager(new LinearLayoutManager(holder.billFragmentedRecycler.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new AdminBillFragmentedAdapter(bill.getProratedValues());
        holder.billFragmentedRecycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return billsList.size();
    }

    static class AdminBillItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bill_name)
        TextView billName;

        @BindView(R.id.totalAmount)
        TextView value;

        @BindView(R.id.payed_amount)
        TextView payedAmount;

        @BindView(R.id.bill_fragmented_recycler)
        RecyclerView billFragmentedRecycler;

        public AdminBillItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
