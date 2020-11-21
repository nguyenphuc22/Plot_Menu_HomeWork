package com.example.plot_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void LinesPlot(View view) {

        Intent intent = new Intent(this,Input_LinesPlot.class);
        startActivity(intent);

    }

    public void BarCharts(View view) {

        Intent intent = new Intent(this,BarCharts.class);
        startActivity(intent);

    }

    public void PieCharts(View view) {

        Intent intent = new Intent(this,Input_PieChart.class);
        startActivity(intent);

    }

    public void Exit(View view) {

        System.exit(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}