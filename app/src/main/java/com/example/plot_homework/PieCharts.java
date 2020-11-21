package com.example.plot_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.androidplot.pie.PieChart;
import com.androidplot.pie.Segment;
import com.androidplot.pie.SegmentFormatter;

import java.util.ArrayList;

public class PieCharts extends AppCompatActivity {

    public static final int SELECTED_SEGMENT_OFFSET = 50;
    private TextView donutSizeTextView;
    private SeekBar donutSizeSeekBar;
    public PieChart pie;
    private Segment s1;
    private Segment s2;
    private Segment s3;
    private Segment s4;
    ArrayList<Integer> arrayList_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_charts);

        pie = findViewById(R.id.piePlot);
        arrayList_value = getIntent().getIntegerArrayListExtra("ListValueX");

        s1 = new Segment("s1",arrayList_value.get(0));
        s2 = new Segment("s2",arrayList_value.get(1));
        s3 = new Segment("s3",arrayList_value.get(2));
        s4 = new Segment("s4",arrayList_value.get(3));

        SegmentFormatter sf1 = new SegmentFormatter(this,R.xml.pie_segment_formatter1);
        SegmentFormatter sf2 = new SegmentFormatter(this,R.xml.pie_segment_formatter2);
        SegmentFormatter sf3 = new SegmentFormatter(this,R.xml.pie_segment_formatter3);
        SegmentFormatter sf4 = new SegmentFormatter(this,R.xml.pie_segment_formatter4);

        pie.addSegment(s1,sf1);
        pie.addSegment(s2,sf2);
        pie.addSegment(s3,sf3);
        pie .addSegment(s4,sf4);
    }
}