package com.example.leica.learnapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class AlertActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    public void button_onClick(View view){
        int id = view.getId();

        if (id == R.id.alertButton) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this); // dialog builder

            builder.setTitle("Alert Dialog Builder");
            builder.setMessage("Choose !!");

            builder.setPositiveButton("GOOD", new DialogInterface.OnClickListener() { // positive
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Button alertButton = (Button) findViewById(R.id.alertButton);   // recognize button
                    alertButton.setText("Let's Alert !! GOOD");                     // button set text
                }
            });

            builder.setNeutralButton("SO SO", new DialogInterface.OnClickListener() { // neutral
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Button alertButton = (Button) findViewById(R.id.alertButton);
                    alertButton.setText("Let's Alert !! SO SO");
                }
            });

            builder.setNegativeButton("BAD", new DialogInterface.OnClickListener() { // negative
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                    Button alertButton = (Button) findViewById(R.id.alertButton);
                    alertButton.setText("Let's Alert !! BAD");
                }
            });

            builder.show();
        }

    }

}
