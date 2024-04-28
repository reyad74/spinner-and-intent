package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class sweActivity extends AppCompatActivity {

    TextView outputView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swe);
        outputView=findViewById(R.id.sweoutputId);
        Intent mygetIntent= getIntent();
        String recId,recName;
        recId=mygetIntent.getStringExtra(MainActivity.extraID);
        recName=mygetIntent.getStringExtra(MainActivity.extraname);
        outputView.setText("Welcome"+recId+" "+recName);
    }
}