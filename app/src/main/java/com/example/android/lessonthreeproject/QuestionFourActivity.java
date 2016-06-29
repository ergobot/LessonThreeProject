package com.example.android.lessonthreeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFourActivity extends AppCompatActivity {

    boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        ((TextView)findViewById(R.id.question_textview)).setText(R.string.question_four);

    }



    public void completeQuestion(View view){

        Button button = (Button)view;
        if(button.getText().equals(getString(R.string.button_checkanswer))){
                evaluateAnswer();
                button.setText(R.string.button_nextquestion);
                Toast.makeText(
                        this,
                        R.string.error_noselection,
                        Toast.LENGTH_LONG).show();
        }else{
            nextQuestion();
        }

    }

    public void evaluateAnswer(){

        CheckBox checkBoxOne = (CheckBox)findViewById(R.id.checkbox_one);
        CheckBox checkBoxTwo = (CheckBox)findViewById(R.id.checkbox_two);
        CheckBox checkBoxThree = (CheckBox)findViewById(R.id.checkbox_three);
        CheckBox checkBoxFour = (CheckBox)findViewById(R.id.checkbox_four);

        if(checkBoxOne.isChecked() &&
           checkBoxTwo.isChecked() &&
           checkBoxThree.isChecked() &&
           checkBoxFour.isChecked()){
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
        Intent nextQuestionIntent = new Intent(this,QuestionFiveActivity.class);
        nextQuestionIntent.putExtra("score",score);
        startActivity(nextQuestionIntent);
    }


}
