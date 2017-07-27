package com.example.manvir.geo_quiz_update;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Questions[] questions = new Questions[5];
    private int qNum = 0;
    private final int IPC_ID = 1122;
    private boolean answer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initQuestions();
        initQuestionsText();
    }
    protected void onStart(){
        super.onStart();
        Log.i("lifecycle", "onStart() was start");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("lifecycle", "onResume() was start");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("lifecycle", "onPause() was start");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("lifecycle", "onStop() was start");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i("lifecycle", "onSaveInstance was called");
        outState.putInt("numclicks", qNum);

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("lifecycle", "onRestoreInstance was called");
        qNum = savedInstanceState.getInt("numclicks");
        initQuestionsText();

    }

    private void initQuestions(){
        questions[0] = new Questions("Are mice friendly?", false);
        questions[1] = new Questions("Is it freezing outside?", true);
        questions[2] = new Questions("Are cookies groose?", false);
        questions[3] = new Questions("Is fruit evil?", false);
        questions[4] = new Questions("Did it snow for the holidays?", true);
    }
    private void initQuestionsText(){
        TextView textView = (TextView)findViewById(R.id.questionText);
        textView.setText(questions[qNum].getQuery() );
    }
    private void initAnswerButton( final boolean answer) {

        if(questions[qNum].getAnswer() == answer){
            Toast.makeText(getBaseContext(), "Correct",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Incorrect",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void onTrue(View view) {
        initAnswerButton(true);
        answer = true;
    }

    public void onFalse(View view) {
        initAnswerButton(false);
        answer = false;
    }

    public void onCheat(View view) {
        Toast.makeText(this, "Cheating is Wrong", Toast.LENGTH_SHORT).show();
        Intent myIntentA1A2 = new Intent(MainActivity.this,
                CheatActivity.class);
        String question = questions[qNum].getQuery();
        Bundle myData = new Bundle();
        myData.putString("question", question);
        myData.putBoolean("Answer", questions[qNum].getAnswer());
        myIntentA1A2.putExtras(myData);

        startActivityForResult(myIntentA1A2, IPC_ID);
    }

    public void onNext(View view) {
        if(qNum >= questions.length - 1){
            qNum = 0;
        }else{
            qNum++;

        }
        initQuestionsText();
    }


}
