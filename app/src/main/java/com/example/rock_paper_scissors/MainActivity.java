package com.example.rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView selectView1;
    ImageView selectView2;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectView1 = (ImageView) findViewById(R.id.selectView1);
        selectView2 = (ImageView) findViewById(R.id.selectView2);
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
                selectView1.setTag("rock");
            } else if (imgArray[randomInt] == 2131099759) {
                selectView1.setTag("scissors");
            } else {
                selectView1.setTag("paper");
            }
        }
        String backgroundImageName = String.valueOf(selectView1.getTag());
        Log.i("img", backgroundImageName);
    }

}
