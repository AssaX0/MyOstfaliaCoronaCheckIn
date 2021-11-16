package com.example.myostfaliacoronacheckin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView eT = findViewById(R.id.textViewCount);
        RoomApi.getPeopleCount(this, "018096", data -> {
            eT.setText(data);
        });

        ImageView imageViewZr = findViewById(R.id.imageViewZahnRad);
        imageViewZr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CredentialActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageViewQr = findViewById(R.id.imageViewQRCode);
        imageViewQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QrCodeActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageViewQm = findViewById(R.id.imageViewQuestionMark);
        imageViewQm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "NotYetImplemented!", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(getApplicationContext(), CredentialActivity.class);
                //startActivity(intent);
            }
        });

        Button bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt.getText().equals("KOMMEN"))
                    bt.setText("GEHEN");
                else
                    bt.setText("KOMMEN");
            }
        });


    }


}