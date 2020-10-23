package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText editText;
    Button button;
    Integer firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.FirstNumber);
        editText = (EditText) findViewById(R.id.SecondNumber);
        button = (Button) findViewById(R.id.ToFirstActivity);

        Intent intent = getIntent();
        firstNumber = intent.getIntExtra("first_number", 0);

        textView.setText(firstNumber.toString());
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("result", editText.getText().length() != 0 ? firstNumber + Integer.parseInt(editText.getText().toString()) : firstNumber);
        startActivity(intent);
    }
}