package com.example.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.share.Share;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText email, username, age, pass1;
    ImageButton submit;
    DatabaseReference jorutoDb;

    SharedPreferences sharedusername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        submit = (ImageButton) findViewById(R.id.register_btn);
        email = (EditText) findViewById(R.id.input_email);
        username = (EditText) findViewById(R.id.input_username);
        pass1 = (EditText) findViewById(R.id.input_password);
        age = (EditText) findViewById(R.id.input_age);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        jorutoDb = FirebaseDatabase.getInstance().getReference().child("Users");






        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                String UN = username.getText().toString().trim();
                String pass = pass1.getText().toString().trim();
                String ageee = age.getText().toString().trim();



 /*                sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                String str = sharedusername.getString("thisusername","");
                String str2 = sharedusername.getString("thisemail","");
             if(str == null && str2 == null){

                    sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedusername.edit();
                    editor.putString("thisusername", UN);
                    editor.putString("thisemail", mail);
                    editor.commit();

                    sharedusername = getSharedPreferences(mail+"myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedusername.edit();
                    editor2.putString("thisusername", UN);
                    editor2.putString("thisemail", mail);
                    editor2.commit();

                }else{*/
                    sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedusername.edit();
                    editor.remove("thisusername");
                    editor.remove("thisemail");
                    editor.commit();

                    sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = sharedusername.edit();
                    editor4.putString("thisusername", UN);
                    editor4.putString("thisemail", mail);
                    editor4.commit();

                    sharedusername = getSharedPreferences(mail+"myusername", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor5 = sharedusername.edit();
                    editor5.putString("thisusername", UN);
                    editor5.putString("thisemail", mail);
                    editor5.commit();
                //}

                //if (agee < 17) {
                if (mail.isEmpty() || UN.isEmpty() || pass.isEmpty() || ageee.isEmpty()) {
                    Toast.makeText(signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(mail)) {
                    email.setError("Email is Required!");
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    email.setError("Provide a valid Email!");
                }

                if (TextUtils.isEmpty(UN)) {
                    username.setError("Username is Required!");
                    return;
                }
                if (TextUtils.isEmpty(ageee)) {
                    age.setError("Age is Require!");
                    return;
                }

                if (Integer.valueOf(ageee) <= 17) {
                    age.setError("Hangman is Restricted to 17 and Below!");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    pass1.setError("Password is Required!");
                    return;
                }
                if (pass.length() < 6) {
                    pass1.setError("Password Must be below 6 characters!");
                    return;

                }
                    /*else {
                       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                        databaseReference.child(UN).setValue(UN);
                        databaseReference.child(UN).child("Username").setValue(UN);
                        databaseReference.child(UN).child("Password").setValue(pass);
                        databaseReference.child(UN).child("Age").setValue(agee);
                    }*/

                mAuth.createUserWithEmailAndPassword(mail,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(signup.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(signup.this, "Your Account Has been created!", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(signup.this, "Welcome to Hangman", Toast.LENGTH_SHORT).show();
                                    database();
                                    nextActivity();
                                }else{
                                    Toast.makeText(signup.this, "Email is already taken", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }


    //MAUTH ANG PROBLEM ROVIC, BURHAIN MO YUNG NASA DECLARATION OR PANOORIN MO ULIT SA YOUTUBE. KAYA YAN HEHE

    public void database(){
        String mail = email.getText().toString().trim();
        String UN = username.getText().toString().trim();
        String pass = pass1.getText().toString().trim();
        String ageee = age.getText().toString().trim();


        UserClass userClass = new UserClass(mail,UN,pass,ageee);
        jorutoDb.push().setValue(userClass);
        /*DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(UN).setValue(UN);
        databaseReference.child(UN).child("Username").setValue(UN);
        databaseReference.child(UN).child("Password").setValue(pass);
        databaseReference.child(UN).child("Age").setValue(agee);*/
    }


    private void nextActivity() {
        Intent intent = new Intent(signup.this, loading_screen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
