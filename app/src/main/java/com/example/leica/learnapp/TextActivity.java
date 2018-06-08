package com.example.leica.learnapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class TextActivity extends ActionBarActivity {

    Button fileSaveButton = null;
    EditText contentText, fileName;
    TextView fileLoadText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        fileName = (EditText)findViewById(R.id.fileNameEdit);

        contentText = (EditText)findViewById(R.id.contentText);

        fileSaveButton = (Button)findViewById(R.id.saveButton);

        fileLoadText = (TextView)findViewById(R.id.fileLoadText);
    }

    public void onClick(View v) {

        String path = Environment.getExternalStorageDirectory().getPath();

        switch ( v.getId() ) {

            case R.id.saveButton:

                try {
                    String s = contentText.getText().toString();

                    OutputStream out = openFileOutput("test.txt", MODE_PRIVATE );                    //OutputStream取得
                    PrintWriter writer = new PrintWriter( new OutputStreamWriter( out, "UTF-8" ) );

                    writer.append( s );
                    writer.close();

                    Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.loadButton :

                try {
                    FileInputStream input = this.openFileInput("test.txt");

                    BufferedReader reader = new BufferedReader( new InputStreamReader( input ) );
                    StringBuffer strBuffer = new StringBuffer();
                    String line;

                    while ( (line = reader.readLine()) != null) {
                        strBuffer.append(line);
                    }
                    reader.close();
                    fileLoadText.setText( strBuffer.toString() );


                    Toast.makeText(this, "loaded", Toast.LENGTH_SHORT);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

}