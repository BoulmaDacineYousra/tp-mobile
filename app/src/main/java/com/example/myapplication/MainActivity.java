package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String []data = {"Elamine","Elamine","Elamine"};
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> items= new LinkedList<>();


        RecyclerView recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.add).setOnClickListener(view -> {



            items.add(data[counter%3]);
            counter++;
            adapter.notifyItemInserted(items.size()-1);
        });
    }
}