package br.com.movilehackcampinas.digitalwallet.ui.homeuser;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.movilehackcampinas.digitalwallet.R;
import br.com.movilehackcampinas.digitalwallet.model.UserBill;
import br.com.movilehackcampinas.digitalwallet.util.StringUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserBillAdapter extends RecyclerView.Adapter<UserBillAdapter.UserBillViewHolder> {

    private List<UserBill> userBills;

    public UserBillAdapter(List<UserBill> userBills) {
        this.userBills = userBills;
    }

    @NonNull
    @Override
    public UserBillViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_bill, viewGroup, false);
        return new UserBillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBillViewHolder holder, int i) {
        UserBill userBill = userBills.get(i);
        holder.billName.setText(userBill.getName());
        holder.totalAmount.setText(StringUtil.doubleToCurrency(userBill.getValue()));
        holder.loader.setVisibility(View.INVISIBLE);

        if (userBill.isPayed()) {
            holder.payButton.setVisibility(View.INVISIBLE);
            holder.payedImage.setVisibility(View.VISIBLE);
        } else {
            holder.payButton.setVisibility(View.VISIBLE);
            holder.payedImage.setVisibility(View.INVISIBLE);
        }

        holder.payButton.setOnClickListener(view -> {
            holder.loader.setVisibility(View.VISIBLE);
            holder.payButton.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(() -> {
                holder.payedImage.setVisibility(View.VISIBLE);
                holder.loader.setVisibility(View.INVISIBLE);
            }, 2000);
        });
    }

    @Override
    public int getItemCount() {
        return userBills.size();
    }

    static class UserBillViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bill_name)
        TextView billName;

        @BindView(R.id.totalAmount)
        TextView totalAmount;

        @BindView(R.id.pay_button)
        Button payButton;

        @BindView(R.id.payedImage)
        ImageView payedImage;

        @BindView(R.id.loader)
        ProgressBar loader;

        public UserBillViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
