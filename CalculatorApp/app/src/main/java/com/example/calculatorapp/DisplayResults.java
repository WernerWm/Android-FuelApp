package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Keep;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayResults extends Activity {

    TextView tvDisplayResutls;
    DataHandler dataHandler;
    List<KeepRecordClass> sums = new ArrayList<KeepRecordClass>();
    String calculations = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        tvDisplayResutls = (TextView)findViewById(R.id.txtDisplayResults);

        //Bundle exstra = getIntent().getExtras();

        //c = (ArrayList<KeepRecordClass>)exstra.getSerializable("Key1");
        dataHandler = new DataHandler(this,null,null,1);
        KeepRecordClass allCalculations = new KeepRecordClass();

        sums = dataHandler.SelectAllItems();
        for (KeepRecordClass item: sums)
        {
            calculations += item.getCalculations() + "\n";

        }
        tvDisplayResutls.setText(calculations);

    }

}
