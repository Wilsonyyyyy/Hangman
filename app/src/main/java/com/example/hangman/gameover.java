package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameover extends AppCompatActivity {
    Button retry, quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        retry = (Button) findViewById(R.id.retry);
        quit = (Button) findViewById(R.id.quit);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrymethod();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quitmethod();
            }
        });
    }

    private void retrymethod() {
        Intent intent = new Intent(this, difficultypage.class);
        startActivity(intent);
    }

    private void quitmethod() {
        Intent intent = new Intent(this, landingpage.class);
        startActivity(intent);
    }

}