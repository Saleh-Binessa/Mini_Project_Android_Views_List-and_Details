package com.example.miniprojectandroid.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniprojectandroid.R;
import com.example.miniprojectandroid.listener.TransactionItemListener;
import com.example.miniprojectandroid.transaction_classes.Transaction;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionHolder> {
    private static ArrayList<Transaction> transactions;
    private static TransactionItemListener transactionItemListener;

    public TransactionAdapter(ArrayList<Transaction> transactions, TransactionItemListener transactionItemListener) {
        this.transactions = transactions;
        this.transactionItemListener = transactionItemListener;
    }

    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_card, parent, false);
        return new TransactionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        holder.transactionIDTextView.setText(String.valueOf(transactions.get(position).getId()));
        holder.transactionAccountTextView.setText(String.valueOf(transactions.get(position).getAccount()));
        holder.transactionBalanceTextView.setText(String.valueOf(transactions.get(position).getBalance()));
        holder.transactionDateTextView.setText(String.valueOf(transactions.get(position).getDate()));
        holder.transactionTypeTextView.setText(String.valueOf(transactions.get(position).getType()));
        holder.transactiomAmountTextView.setText(String.valueOf(transactions.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class TransactionHolder extends RecyclerView.ViewHolder {
        TextView transactionIDTextView;
        TextView transactionDateTextView;
        TextView transactionTypeTextView;
        TextView transactiomAmountTextView;
        TextView transactionBalanceTextView;
        TextView transactionAccountTextView;

        public TransactionHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> {
                transactionItemListener.onTransactionItemClicked(transactions.get(getAdapterPosition()));
            });
            transactionIDTextView = itemView.findViewById(R.id.transactionIDTextView);
            transactionDateTextView = itemView.findViewById(R.id.transactionDateTextView);
            transactionTypeTextView = itemView.findViewById(R.id.transactionTypeTextView);
            transactiomAmountTextView = itemView.findViewById(R.id.transactiomAmountTextView);
            transactionBalanceTextView = itemView.findViewById(R.id.transactionBalanceTextView);
            transactionAccountTextView = itemView.findViewById(R.id.transactionAccountTextView);
        }
    }
}
