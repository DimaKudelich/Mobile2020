package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    EditText editText;
    Button button;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textView = (TextView) findViewById(R.id.Result);
        editText = (EditText) findViewById(R.id.FirstNumber);
        button = (Button) findViewById(R.id.ToSecondActivity);

        Intent intent = getIntent();
        result = intent.getIntExtra("result", 0);

        textView.setText(result.toString());

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("first_number", editText.getText().length() != 0 ? Integer.parseInt(editText.getText().toString()) : 0);
        startActivity(intent);
    }
}