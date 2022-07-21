package com.example.hangman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
   ImageButton submit;
   EditText username,password,confirmation;
   ProgressBar progressBar;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUser = mAuth.getCurrentUser();
        submit = findViewById(R.id.register_btn);
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        confirmation = findViewById(R.id.input_confirm_password);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if (mAuth.getCurrentUser() == null) {
            startActivity(new Intent(signup.this, MainActivity.class));
            finish();
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUserToAuth();
            }
        });


        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UN = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(UN)){
                    username.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password.setError("Password is Required.");
                    return;
                }
                if(pass.length() < 6){
                    password.setError("Password Must be below 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(UN,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                           Toast.makeText(signup.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), loading_screen.class));
                        }else{
                            Toast.makeText(signup.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }*/

    }

    private void createUserToAuth() {
        String email = username.getText().toString();
        String password1 = password.getText().toString();
        String reTypePass = confirmation.getText().toString();

        if(email.isEmpty()){
            username.setError("Full Name is Required");
            username.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            username.setError("Provide a Valid Email");
            username.requestFocus();
            return;
        }

        if(password1.isEmpty()){
            password.setError("Provide a Valid Email");
            password.requestFocus();
            return;
        }

        if(password1.length()< 6){
            password.setError("Minimum of Six Characters");
            password.requestFocus();
            return;
        }

        if(!password1.equals(reTypePass)){
            confirmation.setError("Password not matched");
            confirmation.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "Your Account has successfully created", Toast.LENGTH_SHORT).show();
                            Toast.makeText(signup.this, "Welcome to Hangman", Toast.LENGTH_SHORT).show();
                            nextActivity();
                        } else {
                            Toast.makeText(signup.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void nextActivity() {
        Intent intent = new Intent(signup.this, loading_screen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}