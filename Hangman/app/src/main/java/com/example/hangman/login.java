package com.example.hangman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText user, password;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.textView);
        password = findViewById(R.id.textView2);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        login = findViewById(R.id.imageButton7);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

    }

    private void userLogin() {
        String email = user.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (email.isEmpty()) {
            user.setError("Full Name is Required");
            user.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            user.setError("Provide a Valid Email");
            user.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            password.setError("Provide a Valid Email");
            password.requestFocus();
            return;
        }

        if (pass.length() < 6) {
            password.setError("Minimum of Six Characters");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(login.this, loading_screen.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}


