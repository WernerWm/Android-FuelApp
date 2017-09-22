package com.example.fuelconsuption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FillUpActivity extends AppCompatActivity {

    EditText txtLiters;
    EditText txtPrice;
    EditText txtOdometerReadings;
    Button btnBack;
    Button btnAddLocation;
    TextView tvAverageFuelConsuption;
    Datahandler datahandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up);

        txtLiters = (EditText)findViewById(R.id.editLiter);
        txtPrice = (EditText)findViewById(R.id.editPrice);
        txtOdometerReadings = (EditText)findViewById(R.id.editOdometer);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnAddLocation = (Button)findViewById(R.id.btnAddLocation);
        tvAverageFuelConsuption = (TextView)findViewById(R.id.txtAverageFuelUsed);
        datahandler = new Datahandler(this,null,null,1);


        btnAddLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final double liters = Double.parseDouble(txtLiters.getText().toString());
                final double price = Double.parseDouble(txtPrice.getText().toString());
                final double odometerReadings = Double.parseDouble(txtOdometerReadings.getText().toString());
                final double averageFuelConsumption = odometerReadings/liters;
                Intent i = new Intent(FillUpActivity.this,MapsActivity.class);
                i.putExtra("Key1",liters);
                i.putExtra("Key2",price);
                i.putExtra("Key3",odometerReadings);
                i.putExtra("Key4",averageFuelConsumption);
                startActivity(i);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FillUpActivity.this,MenuActivity.class);
                startActivity(i);
            }
        });
    }
}
