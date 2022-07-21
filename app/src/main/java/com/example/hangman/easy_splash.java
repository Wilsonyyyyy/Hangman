package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class easy_splash extends AppCompatActivity {
    private ProgressBar progressBar;
    private Timer timer;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_splash);

        progressBar = findViewById(R.id.progressBar);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }else{
                    timer.cancel();
                    Intent intent = new Intent(easy_splash.this, level1.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 0, 20);
    }
}