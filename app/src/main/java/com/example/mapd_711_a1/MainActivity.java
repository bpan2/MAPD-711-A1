package com.example.mapd_711_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button toAssignmentBtn;
    private EditText fullNameEditText;
    private Spinner provinceSpinner;
    private EditText hobbyEditText;
    private EditText dreamJobEditText;

    private RadioGroup qualificationRadioGroup;
    private RadioButton qualificationRadioBtn;

    private String radioBtnValue;
    private String spinnerItemValue;
    private String fullName;
    private String hobby;
    private String dreamJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullNameEditText = (EditText) findViewById(R.id.fullNameEditText);


        provinceSpinner = (Spinner) findViewById(R.id.provinceSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.provinceList,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinceSpinner.setAdapter(adapter);
        provinceSpinner.setOnItemSelectedListener(this);

        qualificationRadioGroup = (RadioGroup) findViewById(R.id.qualificationRadioGroup);

        hobbyEditText = (EditText) findViewById(R.id.hobbyEditText);
        dreamJobEditText = (EditText) findViewById(R.id.dreamJobEditText);

        toAssignmentBtn = (Button) findViewById(R.id.toAssignmentBtn);
        toAssignmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAssignmentPage();
            }
        });
    }

    private void toAssignmentPage() {
        Intent sendDataToAssignmentPage = new Intent(this, Assignment_1.class);

        fullName = fullNameEditText.getText().toString().trim();
        hobby = hobbyEditText.getText().toString().trim();
        dreamJob = dreamJobEditText.getText().toString().trim();

        //retrieve the value of the selected Radio button
        int radioId = qualificationRadioGroup.getCheckedRadioButtonId();
        qualificationRadioBtn = findViewById(radioId);
        radioBtnValue = qualificationRadioBtn.getText().toString();

        sendDataToAssignmentPage.putExtra("fullName", fullName);
        sendDataToAssignmentPage.putExtra("province", spinnerItemValue);
        sendDataToAssignmentPage.putExtra("qualification", radioBtnValue);
        sendDataToAssignmentPage.putExtra("hobby", hobby);
        sendDataToAssignmentPage.putExtra("dreamJob", dreamJob);

        startActivity(sendDataToAssignmentPage);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinnerItemValue = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinnerItemValue = "Alberta";
    }

}

