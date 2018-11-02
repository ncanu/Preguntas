package com.example.andre.preguntas.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.andre.preguntas.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class GraphActivity extends Activity {

    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Intent myIntent = getIntent(); // gets the previously created intent
        Integer firstKeyName = myIntent.getIntExtra("firstKeyName", 80); // will return "FirstKeyValue"
        Integer secondKeyName= myIntent.getIntExtra("secondKeyName", 80); // will return "SecondKeyValue"


        pieChartView = findViewById(R.id.chartPP);

        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(firstKeyName, Color.BLUE).setLabel("Respuestas Correctas: "+firstKeyName));
        pieData.add(new SliceValue(secondKeyName, Color.GRAY).setLabel("Respuestas Incorrectas: "+secondKeyName));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);



        pieChartView.setPieChartData(pieChartData);
//        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
//        pieChartData.setHasCenterCircle(true).setCenterText1("Resultado");

    }
}
