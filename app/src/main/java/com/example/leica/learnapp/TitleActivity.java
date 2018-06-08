package com.example.leica.learnapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class TitleActivity extends ActionBarActivity {

    final Activity activity = this;
    int num = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        activity.setTitle( "TitleActivity " + num);  // default num = 5
    }

    public void button_onClick(View view) {

        int id = view.getId();

        if (id == R.id.add) {
            num++;
            activity.setTitle("TitleActivity " + num);
        } else if (id == R.id.mul){
            num *= 2;
            activity.setTitle("TitleActivity " + num);
        } else if (id == R.id.div){
            num %= 5;
            activity.setTitle("TitleActivity " + num);
        }

    }

}
