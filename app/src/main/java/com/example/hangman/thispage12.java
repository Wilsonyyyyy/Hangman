package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class thispage12 extends AppCompatActivity {
    TextView wordef, wordtitle;
    Button home, retry, next;
    Integer str = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thispage12);
        home = (Button) findViewById(R.id.btnhome);
        retry = (Button) findViewById(R.id.btnretry);
        next = (Button) findViewById(R.id.btnnext);
        wordef = findViewById(R.id.wordtitle);
        wordtitle = findViewById(R.id.wordef);





        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homebutton();
            }
        });

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrybutton();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextbutton();
            }
        });
    }
    public void homebutton(){
        Intent intent = new Intent(this, landingpage.class);
        recreate();
        startActivity(intent);
    }
    public void retrybutton(){
        Intent intent = new Intent(this, level12 .class);
        recreate();
        startActivity(intent);
    }
    public void nextbutton(){
        Intent intent = new Intent(this, level13.class);
        recreate();
        startActivity(intent);
    }
}