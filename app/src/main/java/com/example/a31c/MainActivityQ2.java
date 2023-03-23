package com.example.a31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivityQ2 extends AppCompatActivity {

    int answer;
    int[] givenAnswers = new int[5];
    Button submitButton;
    ToggleButton answer1, answer2 ,answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_q2);

        //link buttons to id
        submitButton = findViewById(R.id.submitButton);
        answer1 = findViewById(R.id.toggleAnswer1);
        answer2 = findViewById(R.id.toggleAnswer2);
        answer3 = findViewById(R.id.toggleAnswer3);

        // collect name and previous answers
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        givenAnswers = intent.getIntArrayExtra("givenAnswers");

        // answer buttons add and subtract unique values
        answer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    answer++;
                }
                else {
                    answer--;
                }
            }
        });
        answer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    answer += 2;
                }
                else {
                    answer -= 2;
                }
            }
        });
        answer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    answer += 4;
                }
                else {
                    answer -= 4;
                }
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer == 0 | answer == 3 | answer > 4) {  // check for empty input or multiple
                    Toast.makeText(MainActivityQ2.this, getString(R.string.invalidAnswer), Toast.LENGTH_LONG).show();
                }
                else {  // transition to answer activity with answer value
                    Intent intent = new Intent(MainActivityQ2.this, MainActivityA2.class);
                    intent.putExtra("username", name);
                    intent.putExtra("givenAnswers", givenAnswers);
                    intent.putExtra("answer", answer);
                    startActivity(intent);
                }
            }
        });
    }
}