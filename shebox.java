package com.example.grievanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shebox extends AppCompatActivity {
    Button shebox;
    Button grievance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebox);
        grievance=(Button) findViewById(R.id.grievance);
        shebox=(Button) findViewById(R.id.shebox);
        grievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(shebox.this,complaints.class);
                startActivity(intent);
            }
        });
        shebox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(shebox.this,womenscell.class);
                startActivity(intent);
            }
        });
    }
}
