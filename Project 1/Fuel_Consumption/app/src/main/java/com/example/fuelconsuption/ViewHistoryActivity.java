package com.example.fuelconsuption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewHistoryActivity extends AppCompatActivity {

    EditText txtDisplayHistory1;
    EditText txtDisplayHistory2;
    EditText txtDisplayHistory3;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtDisplayHistory1 = (EditText)findViewById(R.id.editDisplayHistory);
        txtDisplayHistory2 = (EditText)findViewById(R.id.editDisplayHistory2);
        txtDisplayHistory3 = (EditText)findViewById(R.id.editDisplayHistory3);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewHistoryActivity.this,MenuActivity.class);
                startActivity(i);
            }
        });
    }
}
