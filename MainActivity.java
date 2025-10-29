package com.example.grievanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.AbstractSequentialList;
import java.util.logging.LogRecord;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView register;
    private TextView editTextemail, editTextpassword;
    private Button login;
    String gender;
    private FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    public static String st_emails,st_password,st_gender;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




            register = (TextView) findViewById(R.id.register);
            register.setOnClickListener(this);

            login = (Button) findViewById(R.id.login);
            login.setOnClickListener(this);

            editTextemail = (TextView) findViewById(R.id.email);
            editTextpassword = (TextView) findViewById(R.id.password);
            mAuth = FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();


        }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, Registeruser.class));
                break;
            case R.id.login:
                userLogin();
                break;
        }
    }

    private void userLogin() {



      /*  if(email.isEmpty()){
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextpassword.setError("Please provide valid email");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextpassword.setError("Min password length is 6 characters!");
            editTextpassword.requestFocus();
            return;
        }*/
        String checkemail = editTextemail.getText().toString().trim();
        String checkpassword = editTextpassword.getText().toString().trim();
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Users");



        Login(checkemail,checkpassword);
        

    }

    private void Login(String checkemail, String checkpassword) {
        APIINTERFACE ap= APICLIENT.getClient().create(APIINTERFACE.class);

        Call<ResponseBody> ca =ap.login(checkemail,checkpassword);
        ca.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                }
                try {
                    String out = null;
                    try {
                        out = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (out.equals("null")) {
                        Toast.makeText(MainActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                    } else {
                        String split[] = out.split(",");

                        st_emails = split[0];
                        st_password = split[1];
                        st_gender = split[2];
                        if(st_gender.equals("female")||st_gender.equals("FEMALE")||st_gender.equals("Female"))
                        {
                            startActivity(new Intent(MainActivity.this,shebox.class));
                           /* Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();*/
                        }
                        else if(st_gender.equals("male")||st_gender.equals("MALE")||st_gender.equals("Male"))
                        {
                            startActivity(new Intent(MainActivity.this,grievance.class));

                        }else{
                            Toast.makeText(MainActivity.this, "User is invalid to login", Toast.LENGTH_SHORT).show();
                        }

                       /* if(st_role.equals("Admin"))
                        {
                            startActivity(new Intent(Login.this,hdhhd.class));
                        }*/
                    }


                    JSONArray json = null;
                    try {
                        json = new JSONArray(out);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    /*for (int i = 0; i < json.length(); i++) {
                        try {
                            JSONObject on = json.getJSONObject(i);
                            st_id = String.valueOf(on.getJSONObject("user_id"));
                           st_name = String.valueOf(on.getJSONObject("username"));
                            st_role = String.valueOf(on.getJSONObject("Role"));
                            if (st_role.equals("Admin")) {
                                startActivity(new Intent(Login.this, hdhhd.class));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {

                }*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
        







