package com.example.firebaseauth;

import static com.example.firebaseauth.R.layout.activity_dashboard;
import static com.example.firebaseauth.R.layout.activity_main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email , pass;
    Button button , button2;
    FirebaseAuth fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.ediTextTextPassword);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registeruser.class);
                startActivity(intent);
            }
        });

        if (fauth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), dashboard.class));
            finish();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String memail = email.getText().toString();
                final String mpass = pass.getText().toString();

                fauth.signInWithEmailAndPassword(memail,mpass).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Logged in Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),dashboard.class));
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}