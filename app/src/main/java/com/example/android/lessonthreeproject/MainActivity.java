package com.example.android.lessonthreeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void startQuiz(View view){
        Intent startQuizIntent = new Intent(this,QuestionOneActivity.class);
        startActivity(startQuizIntent);
    }
}
