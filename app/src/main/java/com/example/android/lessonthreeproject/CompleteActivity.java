package com.example.android.lessonthreeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CompleteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        Intent previousQuestionIntent = getIntent();
        int score = previousQuestionIntent.getIntExtra("score", 0);

        ((TextView)findViewById(R.id.totalscore)).setText(String.valueOf(score) + "/5");

    }



    public void reStartQuiz(View view){
        Intent reStartQuizIntent = new Intent(this,MainActivity.class);
        startActivity(reStartQuizIntent);
    }
}
