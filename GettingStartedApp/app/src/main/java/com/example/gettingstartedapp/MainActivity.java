package com.example.gettingstartedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private Button calculateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        getSetupButtonClickListener();
    }

    private void getViews() {
        resultText = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);



    }

    private void getSetupButtonClickListener() {

        calculateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
               double bmiResult =  calculateBmi();
               displayResult(bmiResult);
                
            }
            
        });
    }

    private double calculateBmi() {

        String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        double heightInMeters = totalInches * 0.0254;



        return         weight / (heightInMeters * heightInMeters);

    }

    private void displayResult(double bmi)
    {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString ;
        if(bmi < 18.5) {
            fullResultString = bmiTextResult + " - You are underweight";
        }
        else if (bmi > 25)
        {
            fullResultString = bmiTextResult + " - You are overweight";

        }
        else
        {

            fullResultString = bmiTextResult + " - You are  a healthy weight ";

        }
        resultText.setText(fullResultString);


    }
}