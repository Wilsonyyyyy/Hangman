package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class titlescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titlescreen);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Chewy-Regular.ttf");
        TextView diff = findViewById(R.id.diff);
        diff.setTypeface(tf);
    }
}