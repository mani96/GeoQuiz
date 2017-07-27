package com.example.manvir.geo_quiz_update;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {
       TextView question1;
       TextView ansView;
       boolean ans;
    String ansPrint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cheat);

        question1 = (TextView)findViewById(R.id.questionShow);

        Intent myLocalIntent = getIntent();
        Bundle myBundle = myLocalIntent.getExtras();
        String str1 = myBundle.getString("question");
        ans = myBundle.getBoolean("Answer");
        question1.setText(str1);
    }

    public void onShow(View view) {
          ansView = (TextView)findViewById(R.id.answerTextView);
        if(ans == true){
            ansPrint = "True";
        }
        else{
            ansPrint ="False";
        }
        ansView.setText(ansPrint);
    }

    protected void onSaveInstanceState(Bundle save) {
        super.onSaveInstanceState(save);
        save.putBoolean("Answer", ans);
    }

    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
         ans = saveInstanceState.getBoolean("Answer");
        if(ans) {
            ansView.setText("True");
        }else {
            ansView.setText("False");
        }

        ansView.setText("");
    }
    protected  void onStart() {
        super.onStart();
        ansView = (TextView)findViewById(R.id.answerTextView);
        ansView.setText("");
    }

}
