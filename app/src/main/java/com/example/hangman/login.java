package com.example.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText user, password;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton login;
    TextInputLayout input, input1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.textView);
        password = findViewById(R.id.textView2);
        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.imageButton7);
        input = findViewById(R.id.text_input_email);
        input1 = findViewById(R.id.text_input_password);
        mUser = mAuth.getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        if(mUser !=null){
            Intent intent = new Intent(login.this, landingpage.class);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = user.getText().toString().trim();
                String pass = password.getText().toString().trim();

                SharedPreferences sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedusername.edit();
                editor.remove("thisusername");
                editor.remove("thisemail");
                editor.commit();
                /*String str = sharedusername.getString("thisusername","");
                String str2 = sharedusername.getString("thisemail","");
                 if(str == null && str2 == null){
                    sharedusername = getSharedPreferences(email+"myusername", Context.MODE_PRIVATE);
                    String logUn = sharedusername.getString("thisusername","");
                    String logEm = sharedusername.getString("thisemail","");

                    sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedusername.edit();
                    editor.putString("thisusername", logUn);
                    editor.putString("thisemail", logEm);
                    editor.commit();

                }else{*/
                    sharedusername = getSharedPreferences(email+"myusername", Context.MODE_PRIVATE);
                    String logUn = sharedusername.getString("thisusername","");
                    String logEm = sharedusername.getString("thisemail","");

                 /*   sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedusername.edit();
                    editor2.clear();
                    editor2.commit();*/
                    sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = sharedusername.edit();
                    editor3.putString("thisusername", logUn);
                    editor3.putString("thisemail", logEm);
                    editor3.commit();


                //}

                if (email.isEmpty()) {
                    user.setError("Email is Required");
                    user.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    user.setError("Provide a Valid Email");
                    user.requestFocus();
                    return;
                }

                if (pass.isEmpty()) {
                    password.setError("Password is required");
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
                            nextToGame();
                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(login.this, "Login Failed ", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });
}
    private void nextToGame() {
        Intent intent = new Intent(login.this, loading_screen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}


