package com.example.manvir.geo_quiz_update;

/**
 * Created by manvir on 2016-11-08.
 */
public class Questions {
    private String query;
    private boolean answer;

    public Questions(String query1, boolean answer1){
        this.query =query1;
        this.answer = answer1;
    }
    public String getQuery(){
        return query;
    }
    public boolean getAnswer(){
        return answer;
    }
}
