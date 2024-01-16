package com.example.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.miniprojectandroid.Adapter.TransactionAdapter;
import com.example.miniprojectandroid.Repo.TransactionRepo;
import com.example.miniprojectandroid.transaction_classes.Transaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecyclerViewTransaction;

    ArrayList<Transaction> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transactionList = TransactionRepo.getInstance().dummyData(1);


        RecyclerViewTransaction = findViewById(R.id.RecyclerViewTransaction);
        RecyclerViewTransaction.setLayoutManager(new LinearLayoutManager(this));
        TransactionAdapter transactionAdapter = new TransactionAdapter(transactionList);
        RecyclerViewTransaction.setAdapter(transactionAdapter);



}}