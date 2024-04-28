package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mySppinerObj;
    String id, name, department;
    EditText userIdObj, userNameObj;
    final static String extraID = "extra id from main";
    final static String extraname = "Extra name from main ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySppinerObj = findViewById(R.id.sppinerID);
        userIdObj = findViewById(R.id.userIdEditTextID);
        userNameObj = findViewById(R.id.userNameEditTextID);
        /*For dropdown*/
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource
                (this, R.array.sppinerValues, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySppinerObj.setAdapter(myAdapter);
        mySppinerObj.setOnItemSelectedListener(this);
        /*---*/

    }

    public void goFuntion(View view) {

        id = userIdObj.getText().toString();
        name = userNameObj.getText().toString();
        if (department.equals("CSE")) {
            //load CSE Activity
            Intent myIntent = new Intent(this, cseActivity.class);
            /* for value pass*/
            myIntent.putExtra(extraID, id);
            myIntent.putExtra(extraname, name);
            startActivity(myIntent);
        } else if (department.equals("SWE")) {
            Intent myIntent = new Intent(this, sweActivity.class);
            /* for value pass*/
            myIntent.putExtra(extraID, id);
            myIntent.putExtra(extraname, name);
            startActivity(myIntent);
        } else {
            Toast.makeText(this, "Select your department First", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        department = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}