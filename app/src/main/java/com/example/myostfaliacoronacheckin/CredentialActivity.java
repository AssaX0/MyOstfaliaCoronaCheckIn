package com.example.myostfaliacoronacheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CredentialActivity extends AppCompatActivity {

    EditText vname, lname, address, city, phoneNumber;
    SharedPreferences sp;
    String strVName, strLName, strAddress, strCity, strPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential);

        vname = findViewById(R.id.editTextFirstName);
        lname= findViewById(R.id.editTextLastName);
        address = findViewById(R.id.editTextAddress);
        city = findViewById(R.id.editTextCityName);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        strVName = sp.getString("vname","Vorname");
        strLName = sp.getString("lname","Nachname");
        strAddress = sp.getString("address","Adresse");
        strCity = sp.getString("city","Stadt");
        strPhoneNumber = sp.getString("phoneNumber","Telefonnummer");

        vname.setText(strVName);
        lname.setText(strLName);
        address.setText(strAddress);
        city.setText(strCity);
        phoneNumber.setText(strPhoneNumber);

        ImageView imageViewAr = findViewById(R.id.imageViewArrow);
        imageViewAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivityAndSave();
            }
        });

        TextView imageViewQm = findViewById(R.id.textView);
        imageViewQm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivityAndSave();
            }
        });

    }

    void changeActivityAndSave() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        strVName = vname.getText().toString();
        strLName = lname.getText().toString();
        strAddress = address.getText().toString();
        strCity = city.getText().toString();
        strPhoneNumber = phoneNumber.getText().toString();
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("vname", strVName);
        editor.putString("lname", strLName);
        editor.putString("address", strAddress);
        editor.putString("city", strCity);
        editor.putString("phoneNumber", strPhoneNumber);
        editor.commit();
    }

}