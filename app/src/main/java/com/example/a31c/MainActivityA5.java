package com.example.a31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivityA5 extends AppCompatActivity {

    int[] givenAnswers = new int[5];
    Button nextButton;
    ToggleButton answer1, answer2, answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a5);

        nextButton = findViewById(R.id.nextButton);
        answer1 = findViewById(R.id.toggleAnswer1);
        answer2 = findViewById(R.id.toggleAnswer2);
        answer3 = findViewById(R.id.toggleAnswer3);

        // collect name and previous answers
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        givenAnswers = intent.getIntArrayExtra("givenAnswers");
        int answer = intent.getIntExtra("answer", 0);

        // set given answer to red
        if (answer == 1) {
            answer1.setBackgroundColor(Color.RED);
        }
        else if (answer == 2) {
            answer2.setBackgroundColor(Color.RED);
        }
        else if (answer == 4) {
            answer3.setBackgroundColor(Color.RED);
        }
        // set correct answer to green, overriding if given answer is correct
        answer1.setBackgroundColor(Color.GREEN);

        // copy answer to given answer list
        givenAnswers[4] = answer;

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // transition to next question activity with given answer list
                Intent intent = new Intent(MainActivityA5.this, MainActivityFinal.class);
                intent.putExtra("username", name);
                intent.putExtra("givenAnswers", givenAnswers);
                startActivity(intent);
            }
        });
    }
}