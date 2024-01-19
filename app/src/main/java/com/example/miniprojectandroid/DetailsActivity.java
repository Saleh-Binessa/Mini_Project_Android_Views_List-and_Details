package com.example.miniprojectandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniprojectandroid.transaction_classes.Transaction;

public class DetailsActivity extends AppCompatActivity {
    private TextView transactionID;
    private TextView transactionDate;
    private TextView accountNumber;
    private TextView accountBalance;
    private TextView transactionType;
    private TextView transactionAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        transactionID = findViewById(R.id.transactionIDTextView);
        transactionDate = findViewById(R.id.transactionDateTextView);
        accountNumber = findViewById(R.id.transactionAccountTextView);
        accountBalance = findViewById(R.id.transactionBalanceTextView);
        transactionType = findViewById(R.id.transactionTypeTextView);
        transactionAmount = findViewById(R.id.transactiomAmountTextView);

        Transaction transaction = (Transaction) getIntent().getSerializableExtra(MainActivity.TRANSACTION_KEY);
        transactionID.setText(String.valueOf(transaction.getId()));
        transactionDate.setText(String.valueOf(transaction.getDate()));
        accountNumber.setText(String.valueOf(transaction.getAccount()));
        accountBalance.setText(String.valueOf(transaction.getBalance()));
        transactionType.setText(String.valueOf(transaction.getType()));
        transactionAmount.setText(String.valueOf(transaction.getAmount()));

    }
}
