package com.example.leica.learnapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;


public class VoiceActivity extends ActionBarActivity {
    private static final int REQUEST_CODE = 0;              // = 0 の部分は、適当な値に変更してください（とりあえず試すには問題ないですが）
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        button = (Button) findViewById(R.id.voiceButton);
    }

    public void onClick(View v) {
        try {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH

            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "VoiceRecognition");

            startActivityForResult(intent, REQUEST_CODE);

        } catch (ActivityNotFoundException e) {                    // このインテントに応答できるアクティビティがインストールされていない場合
            Toast.makeText(VoiceActivity.this, "ActivityNotFoundException", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {         // アクティビティ終了時に呼び出される

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {                       // 自分が投げたインテントであれば応答する
            String resultsString = "";

            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);            // 結果文字列リスト


            for (int i = 0; i< results.size(); i++) {                // 候補をすべて並べる
                resultsString += results.get(i) + "\n";
            }

            Toast.makeText(this, resultsString, Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
