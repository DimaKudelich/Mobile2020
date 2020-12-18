package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Converting converting;
    boolean isServiceBounded = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Converting.ServiceBinder serviceBinder = (Converting.ServiceBinder) service;
            converting = serviceBinder.getService();
            isServiceBounded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceBounded = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,Converting.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        isServiceBounded = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textView = findViewById(R.id.result);
        EditText editText = findViewById(R.id.number);

        switch (item.getItemId()){
            case R.id.bin:
                textView.setText(Converting.fromDecToBin(Integer.parseInt(editText.getText().toString())));
                return true;
            case R.id.oct:
                textView.setText(Converting.fromDecToOct(Integer.parseInt(editText.getText().toString())));
                return true;
            case R.id.hex:
                textView.setText(Converting.fromDecToHex(Integer.parseInt(editText.getText().toString())));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}