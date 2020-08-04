package com.example.rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView selectView1;
    ImageView selectView2;
    TextView winnerText;
    TextView score1;
    TextView score2;
    Button playAgain;
    Button winnerBtn;
    Button randomGameBtn;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectView1 = (ImageView) findViewById(R.id.selectView1);
        selectView2 = (ImageView) findViewById(R.id.selectView2);

        winnerText = (TextView) findViewById(R.id.winnerText);
        playAgain = (Button) findViewById(R.id.playAgainBtn);

        winnerBtn = (Button) findViewById(R.id.winnerBtn);
        randomGameBtn = (Button) findViewById(R.id.randomGameBtn);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);

        selectView1.setTag("empty");
        selectView2.setTag("empty");

        rand = new Random();
    }

    public void rockBtnOnClick(View view) {
        if (view.getId() == R.id.rockBtn1) {
            selectView1.setImageResource(R.drawable.rock);
            selectView1.setTag("rock");
        } else {
            selectView2.setImageResource(R.drawable.rock);
            selectView2.setTag("rock");
        }
    }

    public void paperBtnOnClick(View view) {
        if (view.getId() == R.id.paperBtn1) {
            selectView1.setImageResource(R.drawable.paper);
            selectView1.setTag("paper");
        } else {
            selectView2.setImageResource(R.drawable.paper);
            selectView2.setTag("paper");
        }
    }

    public void scissorsBtnOnClick(View view) {
        if (view.getId() == R.id.scissorsBtn1) {
            selectView1.setImageResource(R.drawable.scissors);
            selectView1.setTag("scissors");
        } else {
            selectView2.setImageResource(R.drawable.scissors);
            selectView2.setTag("scissors");
        }
    }

    public void randomBtnOnClick(View view) {
        int[] imgArray = new int[]{R.drawable.rock, R.drawable.paper, R.drawable.scissors};
        int randomInt = rand.nextInt(3);
        if (view.getId() == R.id.random1) {
            selectView1.setImageResource(imgArray[randomInt]);
            if (imgArray[randomInt] == 2131099758) {
                selectView1.setTag("rock");
            } else if (imgArray[randomInt] == 2131099759) {
                selectView1.setTag("scissors");
            } else {
                selectView1.setTag("paper");
            }
        } else {
            selectView2.setImageResource(imgArray[randomInt]);
            if (imgArray[randomInt] == 2131099758) {
                selectView2.setTag("rock");
            } else if (imgArray[randomInt] == 2131099759) {
                selectView2.setTag("scissors");
            } else {
                selectView2.setTag("paper");
            }
        }
        String backgroundImageName = String.valueOf(selectView1.getTag());
        Log.i("img1", backgroundImageName);

        String backgroundImageName2 = String.valueOf(selectView2.getTag());
        Log.i("img2", backgroundImageName2);
    }

    public void determineWinner(View view) {
        Log.i("msg", "HERE");
        Log.i("sv1", selectView1.getTag().toString());
        Log.i("sv2", selectView2.getTag().toString());

        int textColor = ContextCompat.getColor(this, R.color.colorAccent);
        winnerText.setTextColor(textColor);

        winnerText.setVisibility(View.VISIBLE);

        if (selectView1.getTag().toString().equals("rock")) {
            if (selectView2.getTag().toString().equals("rock")) {
                Log.i("winner", "tie");
                winnerText.setText("It's a tie!");
                playAgain.setVisibility(View.VISIBLE);

                winnerBtn.setEnabled(false);
                randomGameBtn.setEnabled(false);
            } else if (selectView2.getTag().toString().equals("scissors")) {
              playerOneWon();
            } else if (selectView2.getTag().toString().equals("paper")) {
               playerTwoWon();
            } else {
                Log.i("winner", "both players must be ready");
                textColor = ContextCompat.getColor(this, R.color.red);
                winnerText.setTextColor(textColor);
                winnerText.setText("Both players must be ready.");
            }
        } else if (selectView1.getTag().toString().equals("scissors")) {
            if (selectView2.getTag().toString().equals("rock")) {
                playerTwoWon();
            } else if (selectView2.getTag().toString().equals("scissors")) {
                Log.i("winner", "tie");
                winnerText.setText("It's a tie!");
                playAgain.setVisibility(View.VISIBLE);

                winnerBtn.setEnabled(false);
                randomGameBtn.setEnabled(false);
            } else if (selectView2.getTag().toString().equals("paper")) {
               playerOneWon();
            } else {
                Log.i("winner", "both players must be ready");
                textColor = ContextCompat.getColor(this, R.color.red);
                winnerText.setTextColor(textColor);
                winnerText.setText("Both players must be ready.");
            }
        } else if (selectView1.getTag() == "paper") {
            if (selectView2.getTag().toString().equals("rock")) {
                playerOneWon();
            } else if (selectView2.getTag().toString().equals("scissors")) {
               playerTwoWon();
            } else if (selectView2.getTag().toString().equals("paper")) {
                Log.i("winner", "tie");
                winnerText.setText("It's a tie!");
                playAgain.setVisibility(View.VISIBLE);

                winnerBtn.setEnabled(false);
                randomGameBtn.setEnabled(false);
            } else {
                Log.i("winner", "both players must be ready");
                textColor = ContextCompat.getColor(this, R.color.red);
                winnerText.setTextColor(textColor);
                winnerText.setText("Both players must be ready.");
            }
        } else {
            Log.i("winner", "both players must be ready");
            textColor = ContextCompat.getColor(this, R.color.red);
            winnerText.setTextColor(textColor);
            winnerText.setText("Both players must be ready.");
        }
    }

    public void playerOneWon() {
        Log.i("winner", "player1");
        winnerText.setText("Player 1 wins!");
        playAgain.setVisibility(View.VISIBLE);

        winnerBtn.setEnabled(false);
        randomGameBtn.setEnabled(false);

        int score1Int = Integer.parseInt(score1.getText().toString()) + 1;
        score1.setText("" + score1Int);
    }

    public void playerTwoWon() {
        Log.i("winner", "player2");
        winnerText.setText("Player 2 wins!");
        playAgain.setVisibility(View.VISIBLE);

        winnerBtn.setEnabled(false);
        randomGameBtn.setEnabled(false);

        int score2Int = Integer.parseInt(score2.getText().toString()) + 1;
        score2.setText("" + score2Int);
    }

    public void playAgain(View view) {
        winnerBtn.setEnabled(true);
        randomGameBtn.setEnabled(true);
        winnerText.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
    }
}
