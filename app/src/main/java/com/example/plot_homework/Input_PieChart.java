package com.example.plot_homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.androidplot.pie.PieChart;

import java.util.ArrayList;

public class Input_PieChart extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Integer> arrayList_value;
    AdapterValue adapterValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__pie_chart);
        recyclerView = findViewById(R.id.recyclerValue);
        arrayList_value = new ArrayList<>();

        createData(4);

        adapterValue = new AdapterValue(arrayList_value,this);

        LinearLayoutManager linearLayoutManagerX = new LinearLayoutManager
                (this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(linearLayoutManagerX);
        recyclerView.setAdapter(adapterValue);

    }

    public void createData(Integer number) {

        for (int i = 0 ; i < number ; i++) {
            arrayList_value.add(0);
        }

    }

    public void draw(View view) {
        Intent intent = new Intent(this, PieCharts.class);
        intent.putIntegerArrayListExtra("ListValueX",arrayList_value);
        startActivity(intent);

    }

}