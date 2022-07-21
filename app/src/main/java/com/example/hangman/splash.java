package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class splash extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img =  findViewById(R.id.img);
        TextView testt = (TextView) findViewById(R.id.test);
        Intent intent = getIntent();
        String easy = intent.getStringExtra(easy_done.easy);
        String hard = intent.getStringExtra(normal_done.normal);
        String test= intent.getStringExtra("same_key");

        testt.setText(test);
    }
}