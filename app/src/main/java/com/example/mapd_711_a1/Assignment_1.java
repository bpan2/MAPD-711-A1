package com.example.mapd_711_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.TextView;

public class Assignment_1 extends AppCompatActivity {
    private TextView fullNameA1TextView;
    private TextView provinceA1TextView;
    private TextView qualificationA1TextView;
    private TextView hobbyA1TextView;
    private TextView dreamJobA1TextView;

    private String fullName = null;
    private String province = null;
    private String qualification = null;
    private String hobby = null;
    private String dreamJob = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1);

        fullNameA1TextView = (TextView) findViewById(R.id.fullNameA1TextView);
        provinceA1TextView = (TextView) findViewById(R.id.provinceA1TextView);
        qualificationA1TextView = (TextView) findViewById(R.id.qualificationA1TextView);
        hobbyA1TextView = (TextView) findViewById(R.id.hobbyA1TextView);
        dreamJobA1TextView = (TextView) findViewById(R.id.dreamJobA1TextView);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            fullName = extras.getString("fullName");
            province = extras.getString("province");
            qualification = extras.getString("qualification");
            hobby = extras.getString("hobby");
            dreamJob = extras.getString("dreamJob");
        }

        fullNameA1TextView.setText(fullName);
        provinceA1TextView.setText(province);
        qualificationA1TextView.setText(qualification);
        hobbyA1TextView.setText(hobby);
        dreamJobA1TextView.setText(dreamJob);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.a1menu, menu);
        return true;
    }


}