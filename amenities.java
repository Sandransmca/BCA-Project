package com.example.grievanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

public class amenities extends AppCompatActivity {
    EditText complaint;
    Spinner department,year;
    Button submit;
    DatabaseReference studentDbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenities);
        complaint=findViewById(R.id.complaint);
        department=findViewById(R.id.department);
        year=findViewById(R.id.year);
        submit=findViewById(R.id.submit);
        studentDbRef=FirebaseDatabase.getInstance().getReference().child("Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStudentData();

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
