package com.example.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.miniprojectandroid.Adapter.TransactionAdapter;
import com.example.miniprojectandroid.Repo.TransactionRepo;
import com.example.miniprojectandroid.listener.TransactionItemListener;
import com.example.miniprojectandroid.transaction_classes.Transaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TransactionItemListener {
    RecyclerView RecyclerViewTransaction;
    ArrayList<Transaction> transactionList;
    public static final String TRANSACTION_KEY = "TRANSACTION_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String transactionId = getIntent().getStringExtra("ID");
        Log.i(TRANSACTION_KEY, "onCreate: " + transactionId);

        transactionList = TransactionRepo.getInstance().dummyData(1);
        RecyclerViewTransaction = findViewById(R.id.RecyclerViewTransaction);
        RecyclerViewTransaction.setLayoutManager(new LinearLayoutManager(this));
        TransactionAdapter transactionAdapter = new TransactionAdapter(transactionList, transaction -> {
            onTransactionItemClicked(transaction);
        });
        RecyclerViewTransaction.setAdapter(transactionAdapter);
    }

    @Override
    public void onTransactionItemClicked(Transaction transaction) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(TRANSACTION_KEY, transaction);
        startActivity(intent);
    }
}