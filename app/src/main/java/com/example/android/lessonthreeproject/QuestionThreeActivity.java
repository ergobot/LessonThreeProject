package com.example.android.lessonthreeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionThreeActivity extends AppCompatActivity {

    boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);

        ((TextView)findViewById(R.id.question_textview)).setText(R.string.question_three);

    }



    public void completeQuestion(View view){

        Button button = (Button)view;
        if(button.getText().equals(getString(R.string.button_checkanswer))){
            RadioGroup group = (RadioGroup)findViewById(R.id.radiogroup);
            if(group.getCheckedRadioButtonId() != -1) {
                evaluateAnswer();
                button.setText(R.string.button_nextquestion);
            }else{
                Toast.makeText(
                        this,
                        R.string.error_noselection,
                        Toast.LENGTH_LONG).show();
            }
        }else{
            nextQuestion();
        }

    }

    public void evaluateAnswer(){

        RadioGroup group = (RadioGroup)findViewById(R.id.radiogroup);
        RadioButton radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
        if (radioButton.getText().equals(getString(R.string.answer_linearlayout))) {
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
        Intent nextQuestionIntent = new Intent(this,QuestionFourActivity.class);
        nextQuestionIntent.putExtra("score",score);
        startActivity(nextQuestionIntent);
    }


}
