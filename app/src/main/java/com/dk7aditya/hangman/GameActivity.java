package com.dk7aditya.hangman;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    Button letterA,letterB,letterC,letterD,letterE,letterF,letterG,letterH,letterI,letterJ,letterK,letterL,letterM,letterN,letterO,letterP,letterQ,letterR,letterS,letterT,letterU,letterV,letterW,letterX,letterY,letterZ;
    TextView guessTheWord;
    ImageView hangManImage;
    ImageView hintBulb;
    int hangManLives;
    String chosenWord;
    int difficultyChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity);
        setViewOfAllItems();
        String[] fileDifficulty = {"wordListEasy.txt","wordListMedium.txt","wordListHard.txt","wordListInsane.txt"};
        difficultyChosen = Integer.parseInt(getIntent().getExtras().getString("GAME_DIFFICULTY"));
        String fileName = fileDifficulty[difficultyChosen];
        Toast.makeText(GameActivity.this,"Good Luck!!",Toast.LENGTH_SHORT).show();
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(fileName), StandardCharsets.UTF_8))) {
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                words.add(mLine.toUpperCase());
            }
        } catch (IOException e) {
            Log.i("IOEXCEPTION",e.toString());
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(words.size());
        chosenWord = words.get(randomIndex);
        Log.i("randomIndex",Integer.toString(randomIndex));
        StringBuilder wordUnSeen = new StringBuilder();
        Log.i("wordFromArrayList",words.get(randomIndex));
        Log.i("wordFromArrayListLength",Integer.toString(words.get(randomIndex).length()));
        for(int i=0; i<words.get(randomIndex).length(); ++i){
            wordUnSeen.append("_");
            if(i!=words.get(randomIndex).length()-1){
                wordUnSeen.append(" ");
            }
        }
        hintBulb.setOnClickListener(v -> displayHintMessageByToast());
        guessTheWord.setText(wordUnSeen);
        letterA.setOnClickListener(v -> {
            letterA.setEnabled(false);
            letterA.setBackgroundColor(Color.WHITE);
            checkCharacter('A');
        });
        letterB.setOnClickListener(v -> {
            letterB.setEnabled(false);
            letterB.setBackgroundColor(Color.WHITE);
            checkCharacter('B');
        });
        letterC.setOnClickListener(v -> {
            letterC.setEnabled(false);
            letterC.setBackgroundColor(Color.WHITE);
            checkCharacter('C');
        });
        letterD.setOnClickListener(v -> {
            letterD.setEnabled(false);
            letterD.setBackgroundColor(Color.WHITE);
            checkCharacter('D');
        });
        letterE.setOnClickListener(v -> {
            letterE.setEnabled(false);
            letterE.setBackgroundColor(Color.WHITE);
            checkCharacter('E');
        });
        letterF.setOnClickListener(v -> {
            letterF.setEnabled(false);
            letterF.setBackgroundColor(Color.WHITE);
            checkCharacter('F');
        });
        letterG.setOnClickListener(v -> {
            letterG.setEnabled(false);
            letterG.setBackgroundColor(Color.WHITE);
            checkCharacter('G');
        });
        letterH.setOnClickListener(v -> {
            letterH.setEnabled(false);
            letterH.setBackgroundColor(Color.WHITE);
            checkCharacter('H');
        });
        letterI.setOnClickListener(v -> {
            letterI.setEnabled(false);
            letterI.setBackgroundColor(Color.WHITE);
            checkCharacter('I');
        });
        letterJ.setOnClickListener(v -> {
            letterJ.setEnabled(false);
            letterJ.setBackgroundColor(Color.WHITE);
            checkCharacter('J');
        });
        letterK.setOnClickListener(v -> {
            letterK.setEnabled(false);
            letterK.setBackgroundColor(Color.WHITE);
            checkCharacter('K');
        });
        letterL.setOnClickListener(v -> {
            letterL.setEnabled(false);
            letterL.setBackgroundColor(Color.WHITE);
            checkCharacter('L');
        });
        letterM.setOnClickListener(v -> {
            letterM.setEnabled(false);
            letterM.setBackgroundColor(Color.WHITE);
            checkCharacter('M');
        });
        letterN.setOnClickListener(v -> {
            letterN.setEnabled(false);
            letterN.setBackgroundColor(Color.WHITE);
            checkCharacter('N');
        });
        letterO.setOnClickListener(v -> {
            letterO.setEnabled(false);
            letterO.setBackgroundColor(Color.WHITE);
            checkCharacter('O');
        });
        letterP.setOnClickListener(v -> {
            letterP.setEnabled(false);
            letterP.setBackgroundColor(Color.WHITE);
            checkCharacter('P');
        });
        letterQ.setOnClickListener(v -> {
            letterQ.setEnabled(false);
            letterQ.setBackgroundColor(Color.WHITE);
            checkCharacter('Q');
        });
        letterR.setOnClickListener(v -> {
            letterR.setEnabled(false);
            letterR.setBackgroundColor(Color.WHITE);
            checkCharacter('R');
        });
        letterS.setOnClickListener(v -> {
            letterS.setEnabled(false);
            letterS.setBackgroundColor(Color.WHITE);
            checkCharacter('S');
        });
        letterT.setOnClickListener(v -> {
            letterT.setEnabled(false);
            letterT.setBackgroundColor(Color.WHITE);
            checkCharacter('T');
        });
        letterU.setOnClickListener(v -> {
            letterU.setEnabled(false);
            letterU.setBackgroundColor(Color.WHITE);
            checkCharacter('U');
        });
        letterV.setOnClickListener(v -> {
            letterV.setEnabled(false);
            letterV.setBackgroundColor(Color.WHITE);
            checkCharacter('V');
        });
        letterW.setOnClickListener(v -> {
            letterW.setEnabled(false);
            letterW.setBackgroundColor(Color.WHITE);
            checkCharacter('W');
        });
        letterX.setOnClickListener(v -> {
            letterX.setEnabled(false);
            letterX.setBackgroundColor(Color.WHITE);
            checkCharacter('X');
        });
        letterY.setOnClickListener(v -> {
            letterY.setEnabled(false);
            letterY.setBackgroundColor(Color.WHITE);
            checkCharacter('Y');
        });
        letterZ.setOnClickListener(v -> {
            letterZ.setEnabled(false);
            letterZ.setBackgroundColor(Color.WHITE);
            checkCharacter('Z');
        });
    }

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;
            try{
                url = new URL(urls[0]);
                httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while(data!=-1){
                    char current = (char) data;
                    result+=current;
                    data = reader.read();
                }
                return result;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                char ch[] = s.toCharArray();
                ch[0] = ' ';
                ch[s.length()-1] = ' ';
                s = String.valueOf(ch);

                JSONObject jsonObject = new JSONObject(s);
                String stuff = jsonObject.getString("meanings");
                JSONArray arr = new JSONArray(stuff);
                for(int i=0; i<arr.length(); ++i){
                    JSONObject jsonPart = arr.getJSONObject(i);
                    if(!jsonPart.get("definitions").toString().isEmpty()){
                        String definitionsFinal = jsonPart.getString("definitions");
                        JSONArray arr2 = new JSONArray(definitionsFinal);
                        for(int j=0; j<arr2.length();++j){
                            JSONObject jsonPart2 = arr2.getJSONObject(j);
                            if(!jsonPart2.get("definition").toString().isEmpty()) {
                                Toast.makeText(GameActivity.this, jsonPart2.get("definition").toString(), Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                        break;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }


    void displayHintMessageByToast(){
        DownloadTask download = new DownloadTask();
        String url = "https://api.dictionaryapi.dev/api/v2/entries/en/" + chosenWord;
        download.execute(url);
        Log.i("URL",url);

    }

    void checkCharacter(char pressedCharacter){
        StringBuilder newUpdatedWord = new StringBuilder(chosenWord);
        int flag = 0;
        for(int i=0; i<chosenWord.length(); ++i){
            if(pressedCharacter == newUpdatedWord.charAt(i)){
                flag = 1;
            }else{
                newUpdatedWord.setCharAt(i,'_');
            }
        }
        if(flag==0){
            //Toast.makeText(GameActivity.this, "Nopes.",Toast.LENGTH_SHORT).show();
            hangManLives--;
            switch(hangManLives){
                case 1:
                    hangManImage.setImageResource(R.drawable.hangman06);
                    break;
                case 2:
                    hangManImage.setImageResource(R.drawable.hangman05);
                    break;
                case 3:
                    hangManImage.setImageResource(R.drawable.hangman04);
                    break;
                case 4:
                    hangManImage.setImageResource(R.drawable.hangman03);
                    break;
                case 5:
                    hangManImage.setImageResource(R.drawable.hangman02);
                    break;
                default:
                    Intent loseActivity = new Intent(GameActivity.this,LoseActivity.class);

                    loseActivity.putExtra("STRING_CHOSEN_WORD",chosenWord);
                    loseActivity.putExtra("GAME_DIFFICULTY",String.valueOf(difficultyChosen));
                    loseActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    loseActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(loseActivity);
                    overridePendingTransition(0,0);
                    break;
            }

        }else{
            StringBuffer finalWordForUpdation = new StringBuffer();
            String guessWordFromView = guessTheWord.getText().toString();
            guessWordFromView = guessWordFromView.replaceAll("\\s","");
            for(int i=0; i<chosenWord.length(); ++i){
                if(guessWordFromView.charAt(i)>='A' && guessWordFromView.charAt(i)<='Z'){
                    finalWordForUpdation.append(guessWordFromView.charAt(i));
                }else if(guessWordFromView.charAt(i) == '_' && (newUpdatedWord.charAt(i) >='A' && newUpdatedWord.charAt(i) <='Z')){
                    finalWordForUpdation.append(newUpdatedWord.charAt(i));
                }else{
                    finalWordForUpdation.append("_");
                }
                if(i!=chosenWord.length()-1){
                    finalWordForUpdation.append(" ");
                }
            }

            if(chosenWord.equals(new String(finalWordForUpdation).replaceAll("\\s",""))){
                guessTheWord.setText(finalWordForUpdation);
                Intent winActivity = new Intent(GameActivity.this,WinActivity.class);
                winActivity.putExtra("GAME_DIFFICULTY",String.valueOf(difficultyChosen));
                winActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                winActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(winActivity);
                overridePendingTransition(0,0);

            }else {
                guessTheWord.setText(finalWordForUpdation);
            }
        }
    }

    void setViewOfAllItems(){
        hangManImage = findViewById(R.id.hangManImage);
        guessTheWord = findViewById(R.id.guessTheWord);
        hangManLives = 6;
        hintBulb = findViewById(R.id.hintBulb);
        letterA = findViewById(R.id.letterA);
        letterB = findViewById(R.id.letterB);
        letterC =findViewById(R.id.letterC);
        letterD =findViewById(R.id.letterD);
        letterE =findViewById(R.id.letterE);
        letterF =findViewById(R.id.letterF);
        letterG =findViewById(R.id.letterG);
        letterH =findViewById(R.id.letterH);
        letterI =findViewById(R.id.letterI);
        letterJ =findViewById(R.id.letterJ);
        letterK =findViewById(R.id.letterK);
        letterL =findViewById(R.id.letterL);
        letterM =findViewById(R.id.letterM);
        letterN =findViewById(R.id.letterN);
        letterO =findViewById(R.id.letterO);
        letterP =findViewById(R.id.letterP);
        letterQ =findViewById(R.id.letterQ);
        letterR =findViewById(R.id.letterR);
        letterS =findViewById(R.id.letterS);
        letterT =findViewById(R.id.letterT);
        letterU =findViewById(R.id.letterU);
        letterV =findViewById(R.id.letterV);
        letterW =findViewById(R.id.letterW);
        letterX =findViewById(R.id.letterX);
        letterY =findViewById(R.id.letterY);
        letterZ =findViewById(R.id.letterZ);
    }

}