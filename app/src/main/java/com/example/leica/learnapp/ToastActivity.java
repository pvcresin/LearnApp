package com.example.leica.learnapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ToastActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void button_onClick(View view){ // main button
        int id = view.getId();

        if ( id == R.id.toastButton ) {
            EditText edit = (EditText) this.findViewById(R.id.toastText); // get toast text input

            Editable s = edit.getText();

            Toast toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);   // Toast make text
            toast.show();
        }
    }

}