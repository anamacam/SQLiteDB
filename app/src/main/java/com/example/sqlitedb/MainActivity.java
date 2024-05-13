package com.example.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonInsert, buttonShow;
    EditText edName, edMobile;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonInsert = findViewById(R.id.bottomInsert);
        buttonShow = findViewById(R.id.resultShow);
        edName = findViewById(R.id.edName);
        edMobile = findViewById(R.id.edMobile);
        database = new Database(MainActivity.this);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edName.length()>0 && edMobile.length()>0){
                    database.insertdata(edName.getText().toString(), edMobile.getText().toString());
                }
            }
        });
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResultShow.class));
            }
        });

    }
}