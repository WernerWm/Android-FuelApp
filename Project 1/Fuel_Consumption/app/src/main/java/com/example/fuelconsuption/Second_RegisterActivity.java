package com.example.fuelconsuption;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Second_RegisterActivity extends AppCompatActivity {

    EditText txtFamilyName;
    EditText txtFamilyPassword;
    EditText txtCarName;
    EditText txtCarModelYear;
    EditText txtCarFuelType;
    Button btnAddFamilyImage;
    Button btnAddCarImage;
    Button btnSave;
    Datahandler datahandler;
    //ImageView familyImage;
    //ImageView carImage;
    //private static final int RESULT_LOAD_IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        final Bundle extras = getIntent().getExtras();
        final String username = extras.getString("Key1");
        final String password = extras.getString("Key2");
        final String country = extras.getString("Key3");
        final Boolean yes = false;
        final Boolean no = false;
        txtFamilyName = (EditText)findViewById(R.id.editFamilyName);
        txtFamilyPassword = (EditText)findViewById(R.id.editFamilyPassword);
        txtCarName = (EditText)findViewById(R.id.editCarName);
        txtCarModelYear = (EditText)findViewById(R.id.editCarModelYear);
        txtCarFuelType = (EditText)findViewById(R.id.editCarFuelType);
        btnAddCarImage = (Button)findViewById(R.id.btnAddImage);
        btnAddFamilyImage = (Button)findViewById(R.id.btnAddFamilyImage);
        btnSave = (Button)findViewById(R.id.btnSave);
        datahandler = new Datahandler(this,null,null,1);

        if ((yes == extras.getBoolean("Key4")) && (no == extras.getBoolean("Key5")));
        {

            txtFamilyName.setEnabled(false);
            txtFamilyPassword.setEnabled(false);
            btnAddFamilyImage.setEnabled(false);
        }
        if ((yes == extras.getBoolean("Key7")) && (no == extras.getBoolean("Key6")))
        {

            txtFamilyName.setEnabled(true);
            txtFamilyPassword.setEnabled(true);
            btnAddFamilyImage.setEnabled(true);
        }
        /*btnAddCarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallaryOpener = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallaryOpener, RESULT_LOAD_IMAGE);
            }
        }
        );
        btnAddFamilyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallaryOpener = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallaryOpener, RESULT_LOAD_IMAGE);
            }
        });*/

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String familyName = txtFamilyName.getText().toString();
                String familyPassword = txtFamilyPassword.getText().toString();
                String carName = txtCarName.getText().toString();
                int carModelYear = Integer.parseInt(txtCarModelYear.getText().toString());
                String carFuelType = txtCarFuelType.getText().toString();
                if (yes == extras.getBoolean("Key7") && no == extras.getBoolean("Key6"));
                {

                    List<User> familyusers = new ArrayList();
                    User user = new User(username,password,country);
                    CarDetails carDetails = new CarDetails(carName,carModelYear,carFuelType);
                    datahandler.InsertData(user,carDetails);
                }
                if (yes == extras.getBoolean("Key4") && no == extras.getBoolean("Key5"))
                {

                    List<User> familyusers = new ArrayList();
                    User user = new User(familyName,familyPassword,familyusers,username,password,country);
                    CarDetails carDetails = new CarDetails(carName,carModelYear,carFuelType);
                    datahandler.InsertData(user,carDetails);
                }
                Intent i = new Intent(Second_RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && requestCode == RESULT_OK && data !=null)
        {
            if (btnAddFamilyImage.isPressed()) {
                Uri selectedImage = data.getData();
                familyImage.setImageURI(selectedImage);
            }
            else if (btnAddCarImage.isPressed()){
                Uri selectedImage = data.getData();
                carImage.setImageURI(selectedImage);
            }
        }
    }*/
}
