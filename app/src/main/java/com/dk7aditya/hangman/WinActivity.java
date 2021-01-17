package com.dk7aditya.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        Button playAgain, changeDifficultyFromWin;
        String difficultyChosen = getIntent().getExtras().getString("GAME_DIFFICULTY");
        playAgain = findViewById(R.id.playAgain);
        changeDifficultyFromWin = findViewById(R.id.changeDifficultyFromWin);
        playAgain.setOnClickListener(v -> {
            Intent playGameAgain = new Intent(WinActivity.this, GameActivity.class);
            playGameAgain.putExtra("GAME_DIFFICULTY",difficultyChosen);
            playGameAgain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            playGameAgain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(playGameAgain);
            overridePendingTransition(0,0);
        });
        changeDifficultyFromWin.setOnClickListener(v -> {
            Intent changeDifficultyFromWinIntent = new Intent(WinActivity.this, DifficultyActivity.class);
            changeDifficultyFromWinIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            changeDifficultyFromWinIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(changeDifficultyFromWinIntent);
            overridePendingTransition(0,0);
        });

    }
}