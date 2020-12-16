package com.example.serviceandmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }

    public void onStart(MenuItem item){
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        startService(new Intent(MainActivity.this,MyService.class));
    }

    public void onStop(MenuItem item){
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        stopService(new Intent(MainActivity.this,MyService.class));
    }

    public void onExit(MenuItem item){
        Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
        stopService(new Intent(MainActivity.this,MyService.class));
        System.exit(0);
    }
}