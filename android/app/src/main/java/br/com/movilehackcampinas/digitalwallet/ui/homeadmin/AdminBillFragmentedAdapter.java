package br.com.movilehackcampinas.digitalwallet.ui.homeadmin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.R;
import br.com.movilehackcampinas.digitalwallet.model.ProratedValue;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminBillFragmentedAdapter extends RecyclerView.Adapter<AdminBillFragmentedAdapter.AdminBillFragmentedViewHolder> {

    private List<ProratedValue> proratedValues;

    public AdminBillFragmentedAdapter(List<ProratedValue> proratedValues) {
        this.proratedValues = proratedValues;
    }

    @NonNull
    @Override
    public AdminBillFragmentedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_admin_bill_fragmented, viewGroup, false);
        return new AdminBillFragmentedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminBillFragmentedViewHolder holder, int i) {
        ProratedValue proratedValue = proratedValues.get(i);
        holder.userName.setText(proratedValue.getUser().getFirstName());
        holder.value.setText(String.valueOf(proratedValue.getValue()));
        holder.billStatus.setBackgroundResource(proratedValue.isPayed() ? R.drawable.ic_payed :R.drawable.ic_not_payed);
    }

    @Override
    public int getItemCount() {
        return proratedValues.size();
    }

    static class AdminBillFragmentedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bill_name)
        TextView userName;

        @BindView(R.id.bill_value)
        TextView value;

        @BindView(R.id.bill_status)
        ImageView billStatus;

        public AdminBillFragmentedViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}