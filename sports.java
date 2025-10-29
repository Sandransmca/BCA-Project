package com.example.grievanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sports extends AppCompatActivity {

    EditText complaint;
    Spinner department,year;
    Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        complaint=findViewById(R.id.complaint);
        department=findViewById(R.id.department);
        year=findViewById(R.id.year);
        submit=findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(sports.this, "complaint registered", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void insertStudentData(){
        String suggestion=complaint.getText().toString();
        String dep=department.getSelectedItem().toString();
        String text=year.getSelectedItem().toString();



        
        Toast.makeText(this, "complaint registered ", Toast.LENGTH_SHORT).show();
    }




}
