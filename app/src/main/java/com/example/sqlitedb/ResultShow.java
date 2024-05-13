package com.example.sqlitedb;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResultShow extends AppCompatActivity {

    Database database;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_show);

        textView = findViewById(R.id.textView);
        database = new Database(ResultShow.this);

        textView.setText("");

        Cursor cursor = database.getAllData();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String mobile = cursor.getString(2);

            textView.append("Name: "+name+ "Mobile "+mobile+ "\n\n");
        }

    }
}