package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    int sum;
    int firstNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = getIntent().getIntExtra("number", 0);
        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(firstNum));
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText = findViewById(R.id.number);
                int number = Integer.parseInt(editText.getText().toString());
                sum = number + firstNum;
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", sum);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}