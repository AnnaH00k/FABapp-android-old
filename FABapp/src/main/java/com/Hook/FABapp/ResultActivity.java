package com.Hook.FABapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        score = findViewById(R.id.textView8);


        String score_str = getIntent().getStringExtra( "SCORE");
        score.setText(score_str);


    }



    public void launchMainActivity(View v) {
        //launch a new activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }

}