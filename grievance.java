package com.example.grievanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class grievance extends AppCompatActivity  {
    Button grievance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grievance);
        grievance=(Button) findViewById(R.id.grievance);
        grievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(grievance.this,complaints.class);
                startActivity(intent);
            }
        });

    }


}
