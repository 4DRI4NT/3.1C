package com.example.a31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityFinal extends AppCompatActivity {

    int score = 0;
    int[] givenAnswers = new int[5], correctAnswers = new int[]{1, 1, 1, 1, 1};
    Button redoButton, finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_final);

        // link elements to id
        redoButton = findViewById(R.id.redoButton);
        finishButton = findViewById(R.id.finishButton);
        TextView congratsText = findViewById(R.id.congratsText);
        TextView scoreText = findViewById(R.id.scoreText);

        // collect name and previous answers
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        givenAnswers = intent.getIntArrayExtra("givenAnswers");

        // use name for congrats text
        congratsText.setText(getString(R.string.congrats) + name + "!");

        // cycle through answers
        for (int i = 0; i < givenAnswers.length; i++) {
            //compare given and correct answers, incrementing score if match
            if (givenAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }

        // display score value
        scoreText.setText(score + "/5");

        // loop back to beginning with name
        redoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityFinal.this, MainActivity.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });

        // close app
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });
    }
}