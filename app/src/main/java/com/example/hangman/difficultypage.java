package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class difficultypage extends AppCompatActivity {
    ImageButton easy, normal, hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficultypage);
        easy = (ImageButton) findViewById(R.id.easy);
        normal = (ImageButton) findViewById(R.id.normal);
        hard = (ImageButton) findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golevel1();
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golevel6();
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golevel11();
            }
        });


    }

    private void golevel1() {
        Intent intent = new Intent(this, easy_splash.class);
        recreate();
        startActivity(intent);
    }
    private void golevel6() {
        Intent intent = new Intent(this, normal_splash.class);
        recreate();
        startActivity(intent);
    }
    private void golevel11() {
        Intent intent = new Intent(this, hard_splash.class);
        recreate();
        startActivity(intent);
    }

}