package com.dk7aditya.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        String difficultyChosen = getIntent().getExtras().getString("GAME_DIFFICULTY");
        String getWord = getIntent().getExtras().getString("STRING_CHOSEN_WORD");
        TextView wordToGuess = findViewById(R.id.wordToGuess);
        String setWord = "Word: " + getWord;
        wordToGuess.setText(setWord);
        Button playAgain, chooseDifficulty;
        playAgain = findViewById(R.id.playAgainLose);
        chooseDifficulty = findViewById(R.id.changeDifficulty);
        playAgain.setOnClickListener(v -> {
            Intent playGameAgain = new Intent(LoseActivity.this, GameActivity.class);
            playGameAgain.putExtra("GAME_DIFFICULTY",difficultyChosen);
            playGameAgain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            playGameAgain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(playGameAgain);
            overridePendingTransition(0,0);
        });
        chooseDifficulty.setOnClickListener(v -> {
            Intent changeDifficultyFromLose = new Intent(LoseActivity.this, DifficultyActivity.class);
            changeDifficultyFromLose.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            changeDifficultyFromLose.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(changeDifficultyFromLose);
            overridePendingTransition(0,0);
        });
    }
}