package com.example.plot_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PanZoom;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;

public class LinesPlot extends AppCompatActivity {
    XYPlot xyPlot;
    ArrayList<Integer> arrayList_valueX;
    ArrayList<Integer> arrayList_valueY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines_plot2);
        xyPlot = findViewById(R.id.XYPlot);

        arrayList_valueX = new ArrayList<>();
        arrayList_valueY = new ArrayList<>();


        arrayList_valueX = getIntent().getIntegerArrayListExtra("ListValueX");
        arrayList_valueY = getIntent().getIntegerArrayListExtra("ListValueY");


        // create a couple arrays of y-values to plot:
        final ArrayList<Number> domainLabels = new ArrayList<>();
        for (int i = 0 ; i < arrayList_valueX.size() ; i++) {
            domainLabels.add(i * 2);
        }
        ArrayList<Number> series1Numbers = new ArrayList<>();
        for (int i = 0 ; i < arrayList_valueX.size() ; i++) {
            series1Numbers.add(arrayList_valueX.get(i));
        }
        ArrayList<Number> series2Numbers = new ArrayList<>();
        for (int i = 0 ; i < arrayList_valueY.size() ; i++) {
            series2Numbers.add(arrayList_valueY.get(i));
        }

        // turn the above arrays into XYSeries':
        // (Y_VALS_ONLY means use the element index as the x value)
        XYSeries series1 = new SimpleXYSeries(
                series1Numbers, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");
        XYSeries series2 = new SimpleXYSeries(
                series2Numbers, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter series1Format =
                new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels);

        LineAndPointFormatter series2Format =
                new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels_2);

        // add an "dash" effect to the series2 line:
        series2Format.getLinePaint().setPathEffect(new DashPathEffect(new float[] {

                // always use DP when specifying pixel sizes, to keep things consistent across devices:
                PixelUtils.dpToPix(20),
                PixelUtils.dpToPix(15)}, 0));

        // just for fun, add some smoothing to the lines:
        // see: http://androidplot.com/smooth-curves-and-androidplot/
        series1Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        series2Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        // add a new series' to the xyplot:
        xyPlot.addSeries(series1, series1Format);
        xyPlot.addSeries(series2, series2Format);

        xyPlot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(domainLabels.get(i));
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });

        PanZoom.attach(xyPlot);
    }
}