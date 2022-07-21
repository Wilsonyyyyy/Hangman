package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class normal_done extends AppCompatActivity {
    public static String normal;
    Button next,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_done);

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
        Intent intent = new Intent(this, hard_splash.class);
        recreate();
        startActivity(intent);
    }
    public void homee(){
        Intent class1 = new Intent(this,MainActivity.class);
        recreate();

        class1.putExtra("normal", normal);
        startActivity(class1);
    }


}
