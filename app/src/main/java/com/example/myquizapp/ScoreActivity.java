package com.example.myquizapp;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ScoreActivity extends AppCompatActivity {

    RelativeLayout animations;
    LottieAnimationView  animationView;

    ImageButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        TextView myScore = findViewById(R.id.myScore);
        TextView pass_mark = findViewById(R.id.pass_mark);
        TextView totalQue = findViewById(R.id.totalQue);
        TextView total_score = findViewById(R.id.total_score);
        animations = findViewById(R.id.animations);
        animationView = findViewById(R.id.animationView);
        back_btn = findViewById(R.id.back_btn);


        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));
        String totalQuestion = String.valueOf(intent.getIntExtra("totalQuestion", 0));
        String passStatus = String.valueOf(intent.getStringExtra("passStatus"));

        totalQue.setText("Your Total Question "+totalQuestion);
        myScore.setText(scores);
        pass_mark.setText(setStatus(scores));

        backButton();

    }
    private String setStatus(String scores){
        int score = Integer.parseInt(scores);

        if(score >= 4){
            return "congratulations you Passed!";
        }

        if (score >= 1){

            return "done well Try again";

        }


        return "To do better:) ";
    }

    public void backButton(){

        back_btn.setOnClickListener(v -> {
            Intent  intent= new Intent(ScoreActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }
}