package com.dk7aditya.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        Button easyButton, mediumButton, hardButton, insaneButton;
        easyButton = findViewById(R.id.easyButton);
        mediumButton = findViewById(R.id.mediumButton);
        hardButton = findViewById(R.id.hardButton);
        insaneButton = findViewById(R.id.insaneButton);

        easyButton.setOnClickListener(v->{
            Intent startGameWithDifficulty = new Intent(DifficultyActivity.this,GameActivity.class);
            startGameWithDifficulty.putExtra("GAME_DIFFICULTY","0");
            startActivity(startGameWithDifficulty);
            overridePendingTransition(0,0);
        });

        mediumButton.setOnClickListener(v->{
            Intent startGameWithDifficulty = new Intent(DifficultyActivity.this,GameActivity.class);
            startGameWithDifficulty.putExtra("GAME_DIFFICULTY","1");
            startActivity(startGameWithDifficulty);
            overridePendingTransition(0,0);
        });

        hardButton.setOnClickListener(v->{
            Intent startGameWithDifficulty = new Intent(DifficultyActivity.this,GameActivity.class);
            startGameWithDifficulty.putExtra("GAME_DIFFICULTY","2");
            startActivity(startGameWithDifficulty);
            overridePendingTransition(0,0);
        });

        insaneButton.setOnClickListener(v->{
            Intent startGameWithDifficulty = new Intent(DifficultyActivity.this,GameActivity.class);
            startGameWithDifficulty.putExtra("GAME_DIFFICULTY","3");
            startActivity(startGameWithDifficulty);
            overridePendingTransition(0,0);
        });

    }
}