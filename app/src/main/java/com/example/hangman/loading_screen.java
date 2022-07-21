package com.example.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class loading_screen extends AppCompatActivity {

    private ProgressBar progressBar;
    private Timer timer;
    private int i=0;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    TextView tv_username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        tv_username = findViewById(R.id.tv_username);
        SharedPreferences sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
        String str = sharedusername.getString("thisusername","");
        tv_username.setText(str);
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
                    Intent intent = new Intent(loading_screen.this, landingpage.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 0, 50);
    }
}