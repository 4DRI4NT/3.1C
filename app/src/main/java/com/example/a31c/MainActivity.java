package com.example.a31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link elements to id
        editName = findViewById(R.id.editName);
        startButton = findViewById(R.id.startButton);

        // collect and use previous name if quiz is tried again
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        editName.setText(name);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // check for empty input
                if (TextUtils.isEmpty(editName.getText())) {
                    editName.setError(getString(R.string.emptyField));
                }
                else {  // transition to question activity with name value
                    Intent intent = new Intent(MainActivity.this, MainActivityQ1.class);
                    intent.putExtra("username", editName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}