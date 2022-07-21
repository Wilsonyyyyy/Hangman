package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class hard_done extends AppCompatActivity {
    public static String easy;
    Button  home;
    ImageButton highscorebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_done);


        home = (Button) findViewById(R.id.home);
        highscorebutton = (ImageButton)  findViewById(R.id.highscorebutton2);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homee();
            }
        });
        highscorebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotohighcore();
            }
        });
    }

    private void gotohighcore() {
        Intent intent = new Intent(this, score.class);
        startActivity(intent);
    }

    public void nextdiff(){
        Intent intent = new Intent(this, landingpage.class);
        recreate();
        startActivity(intent);
    }
    public void homee(){
        Intent intent = new Intent(this,difficultypage.class);
        recreate();
        startActivity(intent);
    }
}