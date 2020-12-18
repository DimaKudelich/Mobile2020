package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    int sum;
    int firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        firstNumber = Integer.parseInt(textView.getText().toString());
        textView.setText(String.valueOf(firstNumber));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText = findViewById(R.id.number);

                int number = Integer.parseInt(editText.getText().toString());
                sum = number + firstNumber;

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("number", sum);
                startActivityForResult(intent, 10);
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 10){
            if (resultCode == Activity.RESULT_OK){
                int res = data.getIntExtra("result",0);
                textView.setText(String.valueOf(res));
                firstNumber = Integer.parseInt(textView.getText().toString());
            }
        }
    }
}