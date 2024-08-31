package com.Hook.FABapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Fachangestellte für Bäderbetriebe");
    }

    public void launchRES(View v) {
        //launch a new activity
        Intent i = new Intent(this, RESActivity.class);
        startActivity (i);
    }

    public void launchBad(View v) {
        Intent i = new Intent(this,BadActivity.class);
        startActivity (i);
    }

    public void launchBaed(View v) {
        Intent i = new Intent (this,BaedActivity.class);
        startActivity (i);
    }

    public void launchWirt(View v) {
        Intent i = new Intent (this,WirtActivity.class);
        startActivity (i);
    }
}