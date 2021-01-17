package com.dk7aditya.hangman;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.HangmanTheme);
        setContentView(R.layout.activity_main);
        Button newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(v -> {
            Intent newGameIntent = new Intent(MainActivity.this, DifficultyActivity.class);
            newGameIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            newGameIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newGameIntent);
            overridePendingTransition(0,0);
        });
    }
}