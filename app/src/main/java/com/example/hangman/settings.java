package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class settings extends AppCompatActivity {
    EditText editTextUN;
    ImageButton dictionary, back, settings, reset;
    Button save;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    DatabaseReference myRef;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editTextUN = (EditText) findViewById(R.id.editTextUN);
        back = (ImageButton) findViewById(R.id.back);
        settings = (ImageButton) findViewById(R.id.settings);
        reset = (ImageButton) findViewById(R.id.reset);
        myRef = FirebaseDatabase.getInstance().getReference().child("Users");
        save=(Button) findViewById(R.id.save);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        uid = mUser.getUid();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoback();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gosave();
            }
        });

    }

    private void gosave() {

        SharedPreferences sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
        String UserE = sharedusername.getString("thisemail","");

        sharedusername = getSharedPreferences(UserE+"myusername", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedusername.edit();
        editor.remove("thisusername");
        editor.commit();
        String str = editTextUN.getText().toString();
        sharedusername = getSharedPreferences(UserE+"myusername", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedusername.edit();
        editor2.putString("thisusername", str);
        editor2.commit();

        sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedusername.edit();
        editor3.remove("thisusername");
        editor3.commit();
        sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor4 = sharedusername.edit();
        editor4.putString("thisusername", str);
        editor4.commit();

        myRef = FirebaseDatabase.getInstance().getReference("User Highscores");
        myRef.child(uid).child("un").setValue(str);

        editTextUN.setText("");

        Toast.makeText(this, "username saved", Toast.LENGTH_SHORT).show();


    }


    private void gotodictionary() {
        Intent intent = new Intent(settings.this, menu.class);
        startActivity(intent);
    }
    private void gotoback() {
        Intent intent = new Intent(settings.this, landingpage.class);
        startActivity(intent);
    }
}