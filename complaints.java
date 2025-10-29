package com.example.grievanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class complaints extends AppCompatActivity {
    TextView teaching;
    TextView sports;
    TextView others;
    TextView amenities;
    TextView opinion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);

        teaching = (TextView) findViewById(R.id.teaching);
        sports = (TextView) findViewById(R.id.sports);
        others = (TextView) findViewById(R.id.others);
        amenities = (TextView) findViewById(R.id.amenities);
        opinion = (TextView) findViewById(R.id.opinion);

        teaching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complaints.this, teaching.class);
                startActivity(intent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complaints.this, sports.class);
                startActivity(intent);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complaints.this, others.class);
                startActivity(intent);
            }

        });
        amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complaints.this, amenities.class);
                startActivity(intent);
            }
        });
        opinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complaints.this, opinion.class);
                startActivity(intent);
            }
        });
    }
}







