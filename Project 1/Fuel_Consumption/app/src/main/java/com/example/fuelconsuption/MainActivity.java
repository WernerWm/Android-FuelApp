package com.example.fuelconsuption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Datahandler datahandler;
    EditText txtUsername;
    EditText txtPassword;
    Button btnRegister;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = (Button)findViewById(R.id.button);
        btnSignIn = (Button)findViewById(R.id.button2);
        txtUsername = (EditText)findViewById(R.id.editText);
        txtPassword = (EditText)findViewById(R.id.editText2);
        datahandler = new Datahandler(this,null,null,1);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((txtUsername.getText().toString() == " ")  || (txtPassword.getText().toString() == " "))
                {
                    Toast.makeText(getApplicationContext(),"Please enter your username and pasword",Toast.LENGTH_SHORT).show();
                }
                else if (txtUsername.getText().toString() == " ")
                {
                    Toast.makeText(getApplicationContext(),"Please enter your username",Toast.LENGTH_SHORT).show();
                }
                else if (txtPassword.getText().toString() == " ")
                {
                    Toast.makeText(getApplicationContext(),"Please enter your pasword",Toast.LENGTH_SHORT).show();
                }
                else if (txtPassword.getText().toString().length() < 6)
                {
                    Toast.makeText(getApplicationContext(),"Password to short",Toast.LENGTH_SHORT).show();
                }
                else if (txtUsername.getText().toString().length() < 4)
                {
                    Toast.makeText(getApplicationContext(),"Username to short",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String username = txtUsername.getText().toString();
                    String password = txtPassword.getText().toString();
                    Boolean returnvalue = datahandler.FindUser(username,password);
                    if ( returnvalue == true )
                    {
                        Intent i = new Intent(MainActivity.this, MenuActivity.class);
                        i.putExtra("Key1", username);
                        i.putExtra("Key2", password);
                        startActivity(i);
                        /*Boolean haveFamily = datahandler.CheckingForFamily();
                        if ()
                        {

                            Intent i = new Intent(MainActivity.this, MenuActivity.class);
                            startActivity(i);
                        }*/

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"incorrect username or password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
