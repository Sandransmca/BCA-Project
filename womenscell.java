package com.example.grievanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class womenscell extends AppCompatActivity {
    TextView immediateaction;
    TextView getacall;
    TextView counselling;
    TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womenscell);

        immediateaction=(TextView)findViewById(R.id.immediateaction);
        getacall=(TextView)findViewById(R.id.getacall);
        counselling=(TextView)findViewById(R.id.counselling);
        about=(TextView)findViewById(R.id.about);

        immediateaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(womenscell.this,immediateaction.class);
                startActivity(intent);
            }
        });
        getacall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(womenscell.this,getacall.class);
                startActivity(intent);
            }
        });
        counselling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(womenscell.this,counselling.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(womenscell.this,about.class);
                startActivity(intent);
            }
        });

    }
}
