package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Registeruser extends AppCompatActivity {

    EditText email , password;
    Button btn2 , backtologin;
    FirebaseAuth Auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);

        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword2);
        btn2 = findViewById(R.id.button3);
        backtologin = findViewById(R.id.button4);

        Auth = FirebaseAuth.getInstance();

        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registeruser.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String memail = email.getText().toString();
                final String mpassword = password.getText().toString();

                Auth.createUserWithEmailAndPassword(memail , mpassword).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(Registeruser.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), dashboard.class));
                    }

                    else {
                        Toast.makeText(Registeruser.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                });
                
            }
        });

    }
}