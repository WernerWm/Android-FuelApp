package com.example.fuelconsuption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    Button btnViewHistory;
    Button btnViewGoogleMaps;
    Button btnFillUp;
    Spinner carsUserCanUse;
    Datahandler dataHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dataHandler = new Datahandler(this,null,null,1);
        btnViewHistory = (Button)findViewById(R.id.btnViewHistory);
        btnViewGoogleMaps = (Button)findViewById(R.id.btnViewGoogleMaps);
        btnFillUp = (Button)findViewById(R.id.btnFillUp);
        carsUserCanUse = (Spinner)findViewById(R.id.spinnerShowCars);
        ImageView IMViewCar;

        Bundle usernameAndPassword = getIntent().getExtras();

        String username = usernameAndPassword.getString("Key1");
        String password = usernameAndPassword.getString("Key2");
        String familyName = dataHandler.CheckingForFamily(username,password);
        if (familyName == null)
        {
            List<CarDetails> familyCars = dataHandler.UsersCars(familyName,username,password);
            List<CarDetails> carNames = new ArrayList<>();
            for (CarDetails item: familyCars) {

                carNames.add(new CarDetails(item.getName()));
            }
            ArrayAdapter<CarDetails> adapter = new ArrayAdapter<CarDetails>(this,
                    android.R.layout.simple_spinner_item,carNames);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            carsUserCanUse.setAdapter(adapter);
        }
        else
        {
            List<CarDetails> familyCars = dataHandler.UsersCars(familyName,username,password);
            List<CarDetails> carNames = new ArrayList<>();
            for (CarDetails item: familyCars) {

                carNames.add(new CarDetails(item.getName()));
            }
            ArrayAdapter<CarDetails> adapter = new ArrayAdapter<CarDetails>(this,
                    android.R.layout.simple_spinner_item,carNames);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            carsUserCanUse.setAdapter(adapter);
        }

        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,ViewHistoryActivity.class);
                startActivity(i);
            }
        });
        btnFillUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,FillUpActivity.class);
                startActivity(i);
            }
        });
        btnViewGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,MapsActivity.class);
                startActivity(i);
            }
        });
    }

}
