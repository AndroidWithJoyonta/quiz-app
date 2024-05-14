package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;

import io.github.muddz.styleabletoast.StyleableToast;

public class questionActivity3 extends AppCompatActivity implements View.OnClickListener{
    TextView questionTextView;
    TextView totalQuestionTextView;
    Button ansA,ansB,ansC,ansD;
    Button btn_submit;

    int score=0;
    int totalQuestion = QuestionAnswer.question3.length;
    int currentQuestionIndex =0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC= findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        btn_submit = findViewById(R.id.btn_submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        btn_submit.setOnClickListener(this);


        totalQuestionTextView.setText("Total question: "+totalQuestion);

        loadNewQuestion();
    }

    private void loadNewQuestion(){
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question3[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choicess3[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choicess3[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choicess3[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choicess3[currentQuestionIndex][3]);

        selectedAnswer="";

    }

    private void finishQuiz(){
        String passStatus;
        if(score >= totalQuestion*0.6){
            passStatus = "congratulations you Passed!";
        }else{
            passStatus = "You Failed try Again!";
        }
//        new AlertDialog.Builder(this)
//                .setTitle(passStatus)
//                .setMessage("Your Score is "+score+" Out of "+totalQuestion)
//                .setPositiveButton("Restart",((dialog, i) -> restartQuiz() ))
//                .setCancelable(false)
//                .show();
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("totalQuestion", totalQuestion);
        intent.putExtra("passStatus", passStatus);
        startActivity(intent);
        finish();
    }

    private void restartQuiz(){
        score = 0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.btn_submit) {
            if (!selectedAnswer.isEmpty()) {
                if (selectedAnswer.equals(QuestionAnswer.correctAnswerss3[currentQuestionIndex])) {
                    score++;
                    new StyleableToast
                            .Builder(questionActivity3.this)
                            .text("Correct Answer!")
                            .textColor(Color.WHITE)
                            .backgroundColor(Color.GREEN)
                            .show();
                } else {
                    clickedButton.setBackgroundColor(Color.CYAN);
                    new StyleableToast
                            .Builder(questionActivity3.this)
                            .text("Wrong")
                            .textColor(Color.WHITE)
                            .backgroundColor(Color.RED)
                            .show();

                }
                currentQuestionIndex++;
                loadNewQuestion();
            } else {

            }
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);
        }
    }}