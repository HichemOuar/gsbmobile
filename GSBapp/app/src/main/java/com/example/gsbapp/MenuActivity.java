package com.example.gsbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button buttonPrat;
    Button buttonProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonPrat = (Button) findViewById(R.id.button);
        buttonProd = (Button) findViewById(R.id.button2);

        buttonPrat.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("key");

                Intent i = new Intent(MenuActivity.this, PratActivity.class);
                i.putExtra("key",value);
                startActivity(i);
            }}
        });

        buttonProd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ProdActivity.class);
                startActivity(intent);
            }
        });
    }
}

