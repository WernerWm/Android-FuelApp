package com.example.fuelconsuption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    EditText txtCountry;
    Button btnAddImage;
    Button btnNext;
    RadioButton rbtnYes;
    RadioButton rbtnNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = (EditText)findViewById(R.id.editUsername);
        txtPassword = (EditText)findViewById(R.id.editPassword);
        txtCountry = (EditText)findViewById(R.id.editCountry);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnAddImage = (Button)findViewById(R.id.btnAddImage);
        rbtnNo = (RadioButton)findViewById(R.id.rbtnNo);
        rbtnYes = (RadioButton)findViewById(R.id.rbtnYes);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String country = txtCountry.getText().toString();
                Boolean yes = false;
                Boolean no = false;

                Intent i = new Intent(RegisterActivity.this,Second_RegisterActivity.class);
                i.putExtra("Key1",name);
                i.putExtra("Key2",password);
                i.putExtra("Key3",country);

                if (rbtnYes.isChecked() == true)
                {
                    yes = true;
                    i.putExtra("Key4",yes);
                    i.putExtra("Key5",no);
                }
                else if (rbtnNo.isChecked() == true)
                {
                    no = true;
                    i.putExtra("Key6",no);
                    i.putExtra("Key7",yes);
                }
                startActivity(i);
            }
        });
    }
}
