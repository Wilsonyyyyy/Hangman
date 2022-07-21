package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class landingpage extends AppCompatActivity {
    ImageButton playbutton,settingsbutton, volumebutton, highscorebutton, btn_logout, settings, reset;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    String uid;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        uid = mUser.getUid();
        settings = (ImageButton) findViewById(R.id.settings);
        reset = (ImageButton) findViewById(R.id.reset);
        playbutton = (ImageButton)  findViewById(R.id.playbutton);
        highscorebutton = (ImageButton)  findViewById(R.id.highscorebutton);
        btn_logout = (ImageButton) findViewById(R.id.logout);
        reset = (ImageButton) findViewById(R.id.reset);



        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotomain();
            }
        });

        highscorebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotohighcore();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotosettings();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goreset();
            }
        });


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(btn_logout.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("want to logout Hangman?");

                builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAuth.signOut();
                        sigOutUser();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(btn_logout.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }

        });
    }

    private void gotosettings() {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }


    private void sigOutUser() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void gotomain() {
        Intent intent = new Intent(this, difficultypage.class);
        startActivity(intent);
    }
    public void gotohighcore() {
        Intent intent = new Intent(this, score.class);
        startActivity(intent);
    }
    public void goreset() {
        SharedPreferences sp1 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp1.edit();
        editor.clear();
        editor.commit();
        SharedPreferences sp2 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();
        editor2.clear();
        editor2.commit();
        SharedPreferences sp3 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sp3.edit();
        editor3.clear();
        editor3.commit();
        SharedPreferences sp4 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor4 = sp4.edit();
        editor4.clear();
        editor4.commit();
        SharedPreferences sp5 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor5 = sp5.edit();
        editor5.clear();
        editor5.commit();
        SharedPreferences sp6 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor6 = sp6.edit();
        editor6.clear();
        editor6.commit();
        SharedPreferences sp7 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor7 = sp7.edit();
        editor7.clear();
        editor7.commit();
        SharedPreferences sp8 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor8 = sp8.edit();
        editor8.clear();
        editor8.commit();
        SharedPreferences sp9 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor9 = sp9.edit();
        editor9.clear();
        editor9.commit();
        SharedPreferences sp10 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor10 = sp10.edit();
        editor10.clear();
        editor10.commit();
        SharedPreferences sp11 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor11 = sp11.edit();
        editor11.clear();
        editor11.commit();
        SharedPreferences sp12 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor12 = sp12.edit();
        editor12.clear();
        editor12.commit();
        SharedPreferences sp13 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor13 = sp13.edit();
        editor13.clear();
        editor13.commit();
        SharedPreferences sp14 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor14 = sp14.edit();
        editor14.clear();
        editor14.commit();
        SharedPreferences sp15 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor15 = sp15.edit();
        editor15.clear();
        editor15.commit();

        //SharedPreferences sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
        //String str = sharedusername.getString("thisusername", "");

        SharedPreferences scorebox = getSharedPreferences(uid+"myusername", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorscore = scorebox.edit();
        editorscore.remove("thisusername");
        editorscore.remove("thisemail");
        editorscore.commit();

        myRef = FirebaseDatabase.getInstance().getReference().child("User Highscores");
        myRef.child(uid).child("highscore").setValue(null);
        myRef.child(uid).child("date").setValue(null);

        Toast.makeText(this, "your data has been erased", Toast.LENGTH_SHORT).show();



    }
}