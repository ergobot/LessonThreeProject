package com.example.android.lessonthreeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFiveActivity extends AppCompatActivity {

    boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        ((TextView)findViewById(R.id.question_textview)).setText(R.string.question_five);

    }



    public void completeQuestion(View view){

        Button button = (Button)view;
        if(button.getText().equals(getString(R.string.button_checkanswer))){
                evaluateAnswer();
                button.setText(R.string.button_finish);
        }else{
            nextQuestion();
        }

    }

    public void evaluateAnswer(){

        EditText inputView = (EditText)findViewById(R.id.input_answer);
        String input = inputView.getText().toString().trim();
        if(input.equals(getString(R.string.answer_textview))){
            correct = true;
        }

        if(correct){
            Toast.makeText(
                    this,
                    R.string.response_positive,
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(
                    this,
                    R.string.response_negative,
                    Toast.LENGTH_LONG).show();
        }

    }

    public void nextQuestion(){
        Intent previousQuestionIntent = getIntent();
        int score = previousQuestionIntent.getIntExtra("score", 0);

        if(correct){score++;}
        Intent nextQuestionIntent = new Intent(this,CompleteActivity.class);
        nextQuestionIntent.putExtra("score",score);
        startActivity(nextQuestionIntent);
    }


}
