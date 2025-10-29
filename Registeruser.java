package com.example.grievanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class     Registeruser extends AppCompatActivity implements View.OnClickListener {
    private TextView male,female;
    private Button registeruser;
    Button backtologin;

    private EditText editTextname,editTextgender,editTextemail,editTextpassword;
    private FirebaseAuth mAuth;
    FirebaseFirestore firestore;
    String username,gender,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);
        backtologin=(Button)findViewById(R.id.backtologin);

        mAuth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        registeruser=(Button)findViewById(R.id.registeruser);
        registeruser.setOnClickListener(this);

        editTextname=(EditText)findViewById(R.id.name);
        editTextgender=(EditText)findViewById(R.id.gender);
        editTextemail=(EditText)findViewById(R.id.email);
        editTextpassword=(EditText)findViewById(R.id.password);
username=editTextname.getText().toString();
gender=editTextgender.getText().toString();
email=editTextemail.getText().toString();
password=editTextpassword.getText().toString();
backtologin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent=new Intent(Registeruser.this,MainActivity.class);
       startActivity(intent);
    }
});


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registeruser:
                registeruser();
                break;
        }

    }


    private void registeruser() {
        String name = editTextname.getText().toString().trim();
        String gender = editTextgender.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if (name.isEmpty()) {
            editTextname.setError("Name is required");
            editTextname.requestFocus();
            return;
        }
        if (gender.isEmpty()) {
            editTextgender.setError("Gender is required");
            editTextgender.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextemail.setError("Please provide valid email");
            editTextemail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextpassword.setError("Min password length should be 6 characters");
            editTextpassword.requestFocus();
            return;
        }

       /* if (gender.length() == 4) {
            startActivity(new Intent(this, grievance.class));
        }
        if (gender.length() == 6) {
            startActivity(new Intent(this, shebox.class));
        }*/

        register(name, gender, email, password);

     /*   mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(name, gender, email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user=mAuth.getCurrentUser();
                                        Toast.makeText(Registeruser.this, "User has been registered successfully", Toast.LENGTH_SHORT).show();
                                        DocumentReference df=firestore.collection("Users").document(user.getUid());
                                    }else{
                                        Toast.makeText(Registeruser.this, "Failed to register", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                        }else{
                            Toast.makeText(Registeruser.this, "Failed to register", Toast.LENGTH_SHORT).show();
                        }
                    }


                });
    }*/
    }

    private void register(String name, String gender, String email, String password) {
        APIINTERFACE api=APICLIENT.getClient().create(APIINTERFACE.class);
        Call<ResponseBody> ca=api.register(name,password,email,gender);
        ca.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    try{
                        String out=response.body().toString();
                        if(out.equals("success"))
                        {
                            Toast.makeText(Registeruser.this, "registered succesfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                            Toast.makeText(Registeruser.this, "registered successfully", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
