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

public class opinion extends AppCompatActivity {
    EditText complaint;
    Spinner department,year;
    Button submit;
    DatabaseReference studentDbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
        complaint=findViewById(R.id.complaint);
        department=findViewById(R.id.department);
        year=findViewById(R.id.year);
        submit=findViewById(R.id.submit);
        studentDbRef= FirebaseDatabase.getInstance().getReference().child("Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(opinion.this, "complaint registered", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void insertStudentData(){
        String suggestion=complaint.getText().toString();
        String dep=department.getSelectedItem().toString();
        String text=year.getSelectedItem().toString();

        User user=new User(suggestion,dep,text);

        studentDbRef.push().setValue(user);
        Toast.makeText(this, "complaint registered ", Toast.LENGTH_SHORT).show();
    }






}
