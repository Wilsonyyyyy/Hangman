package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class easy_done extends AppCompatActivity {
    public static String easy;
    Button next, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_done);

        next = (Button) findViewById(R.id.next);
        home = (Button) findViewById(R.id.home);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextdiff();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homee();
            }
        });
    }
        public void nextdiff(){
            Intent intent = new Intent(this, normal_splash.class);
            recreate();
            startActivity(intent);
    }
    public void homee(){
        Intent intent = new Intent(this,landingpage.class);
        recreate();
        startActivity(intent);
    }


}

