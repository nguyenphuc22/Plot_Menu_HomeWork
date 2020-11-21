package com.example.plot_homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Input_BarChart extends AppCompatActivity {
    RecyclerView recyclerViewX;
    EditText editText_CreateList;
    ArrayList<Integer> arrayList_valueX;
    AdapterValue adapterValueX;

    RecyclerView recyclerViewY;
    ArrayList<Integer> arrayList_valueY;
    AdapterValue adapterValueY;
    Button btnDraw;

    public void CreateList (View view) {

        int numberList = Integer.parseInt(editText_CreateList.getText().toString());

        if (numberList > 4 && numberList <= 10 ) {

            arrayList_valueY = new ArrayList<>();
            arrayList_valueX = new ArrayList<>();
            createData(numberList);


            adapterValueX = new AdapterValue(arrayList_valueX,this);

            LinearLayoutManager linearLayoutManagerX = new LinearLayoutManager
                    (this,LinearLayoutManager.HORIZONTAL,false);

            recyclerViewX.setLayoutManager(linearLayoutManagerX);
            recyclerViewX.setAdapter(adapterValueX);



            adapterValueY = new AdapterValue(arrayList_valueY,this);

            LinearLayoutManager linearLayoutManagerY = new LinearLayoutManager
                    (this,LinearLayoutManager.HORIZONTAL,false);

            recyclerViewY.setLayoutManager(linearLayoutManagerY);
            recyclerViewY.setAdapter(adapterValueY);

            btnDraw.setVisibility(View.VISIBLE);
        }

    }

    public void createData(Integer number) {

        for (int i = 0 ; i < number ; i++) {
            arrayList_valueX.add(0);
            arrayList_valueY.add(0);
        }

    }

    public void draw(View view) {
        Intent intent = new Intent(this,BarCharts.class);
        intent.putIntegerArrayListExtra("ListValueX",arrayList_valueX);
        intent.putIntegerArrayListExtra("ListValueY",arrayList_valueY);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__bar_chart);
        recyclerViewX = findViewById(R.id.recyclerValueX);
        editText_CreateList = findViewById(R.id.edtPoint);
        recyclerViewY = findViewById(R.id.recyclerValueY);
        btnDraw = findViewById(R.id.btnDraw);
    }
}