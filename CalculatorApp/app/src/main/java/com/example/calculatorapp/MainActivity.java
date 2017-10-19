package com.example.calculatorapp;

import android.content.Intent;
import android.support.annotation.Keep;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplaySumDone;
    EditText txtDisplay;
    Button btnNumber1;
    Button btnNumber2;
    Button btnNumber3;
    Button btnNumber4;
    Button btnNumber5;
    Button btnNumber6;
    Button btnNumber7;
    Button btnNumber8;
    Button btnNumber9;
    Button btnNumber0;
    Button btnClear;
    Button btnPlus;
    Button btnEqual;
    Button btnMinus;
    Button btnMultiply;
    Button btnDevide;
    Button btnViewHistory;

    Boolean Clicked = false;
    DataHandler dataHandler;
    String otherNumbers = "",calculation = "";
    int total = 0,howManyTimePlusIsClicked = 0,howManyTimeMinusIsClicked = 0,howManyTimeMultiplyIsClicked = 0,howManyTimeDevideIsClicked = 0;
    String signs = "";
    ArrayList<KeepRecordClass> allCalculations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplaySumDone = (TextView)findViewById(R.id.txtShowSumDone);
        txtDisplay = (EditText)findViewById(R.id.editDisplay);
        btnNumber0 = (Button)findViewById(R.id.btnNumber0);
        btnNumber1 = (Button)findViewById(R.id.btnNumber1);
        btnNumber2 = (Button)findViewById(R.id.btnNumber2);
        btnNumber3 = (Button)findViewById(R.id.btnNumber3);
        btnNumber4 = (Button)findViewById(R.id.btnNumber4);
        btnNumber5 = (Button)findViewById(R.id.btnNumber5);
        btnNumber6 = (Button)findViewById(R.id.btnNumber6);
        btnNumber7 = (Button)findViewById(R.id.btnNumber7);
        btnNumber8 = (Button)findViewById(R.id.btnNumber8);
        btnNumber9 = (Button)findViewById(R.id.btnNumber9);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnDevide = (Button)findViewById(R.id.btnDevide);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnViewHistory = (Button)findViewById(R.id.button);
        dataHandler = new DataHandler(this,null,null,1);

        btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button button = (Button)view;
                String number = button.getText().toString();
                otherNumbers += number;
                txtDisplay.setText(otherNumbers);
                calculation += otherNumbers;
                tvDisplaySumDone.setText(calculation);
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Clicked = true;
                if ("+".equals(signs))
                {
                    total =  total + Integer.parseInt(otherNumbers);

                }
                else if ("-".equals(signs))
                {
                    total = total - Integer.parseInt(otherNumbers);

                }
                else if ("*".equals(signs))
                {
                    total = total * Integer.parseInt(otherNumbers);

                }
                else if ("/".equals(signs))
                {
                    total = total/Integer.parseInt(otherNumbers);
                }
                else
                {
                    total = total;
                }

                calculation += String.format(" = %s",total);
                tvDisplaySumDone.setText(calculation);
                txtDisplay.setText(String.valueOf(total));
                allCalculations.add(new KeepRecordClass(calculation));
                otherNumbers = "0";
                signs = "";
            }
        });
        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataHandler.InsertCalculations(allCalculations);
                Intent i = new Intent(MainActivity.this,DisplayResults.class);
                startActivity(i);
            }
        });
        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                howManyTimeDevideIsClicked++;
                Button button = (Button)view;
                signs = button.getText().toString();
                calculation += signs;
                tvDisplaySumDone.setText(calculation);
                if (howManyTimeDevideIsClicked == 1)
                {
                    total += Integer.parseInt(otherNumbers);
                }
                else
                {
                    if (Clicked == true)
                    {
                        total = Integer.parseInt(txtDisplay.getText().toString());
                        Clicked = false;
                    }
                    else
                    {
                        total += Integer.parseInt(otherNumbers);
                    }
                }
                otherNumbers = "";
                txtDisplay.setText("");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                howManyTimeMultiplyIsClicked++;
                signs = "*";
                calculation += signs;
                tvDisplaySumDone.setText(calculation);
                if (howManyTimeMultiplyIsClicked == 1)
                {
                    total += Integer.parseInt(otherNumbers);
                    if (Clicked == true)
                    {
                        total = Integer.parseInt(txtDisplay.getText().toString());
                        Clicked = false;
                    }
                }
                else
                {
                    if (Clicked == true)
                    {
                        total = Integer.parseInt(txtDisplay.getText().toString());
                        Clicked = false;
                    }
                    else
                    {
                        total = total * Integer.parseInt(otherNumbers);
                    }
                }

                otherNumbers = "";
                txtDisplay.setText("");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                howManyTimeMinusIsClicked++;
                Button button = (Button)view;
                signs = button.getText().toString();
                calculation += signs;
                tvDisplaySumDone.setText(calculation);
                if (howManyTimeMinusIsClicked == 1)
                {
                    total += Integer.parseInt(otherNumbers);
                    if (Clicked == true)
                    {
                        total = Integer.parseInt(txtDisplay.getText().toString());
                        Clicked = false;
                    }
                }
                else
                {
                    if (Clicked == true)
                    {
                        total = Integer.parseInt(txtDisplay.getText().toString());
                        Clicked = false;
                    }
                    else
                    {
                        total = total - Integer.parseInt(otherNumbers);
                    }
                }
                otherNumbers = "";
                txtDisplay.setText("");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                howManyTimePlusIsClicked++;
                Button button = (Button)view;
                signs = button.getText().toString();
                calculation += signs;
                tvDisplaySumDone.setText(calculation);
                if (howManyTimePlusIsClicked == 1)
                {
                    total += Integer.parseInt(otherNumbers);
                }
                else
                {
                    if (Clicked == true)
                    {
                        total = Integer.parseInt(txtDisplay.getText().toString());
                        Clicked = false;
                    }
                    else
                    {
                        total += Integer.parseInt(otherNumbers);
                    }
                }

                otherNumbers = "";
                txtDisplay.setText("");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculation = "";
                tvDisplaySumDone.setText("");
                Clicked = false;
                howManyTimeDevideIsClicked = 0;
                howManyTimePlusIsClicked = 0;
                howManyTimeMultiplyIsClicked = 0;
                howManyTimeMinusIsClicked = 0;
                total = 0;
                otherNumbers = "";
                txtDisplay.setText("");
            }
        });
    }
}
