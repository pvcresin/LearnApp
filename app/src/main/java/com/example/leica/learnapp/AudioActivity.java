package com.example.leica.learnapp;

import android.app.ActionBar;
import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class AudioActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
    }

    MediaRecorder recorder;

    public void button_onClick(View v) {

        switch ( v.getId() ) {

            case R.id.recordStart:
                recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

                String filePath = Environment.getExternalStorageDirectory() + "/GeoMelody.3gp";                //保存先
                recorder.setOutputFile( filePath );

                try {
                    recorder.prepare();                    //録音準備＆録音開始

                } catch (Exception e) {
                    e.printStackTrace();
                }

                recorder.start();   //録音開始

                break;

            case R.id.recordStop:         //ストップボタン押下
                recorder.stop();
                recorder.reset();        //オブジェクトのリセット

                //release()前であればsetAudioSourceメソッドを呼び出すことで再利用可能
                recorder.release(); //Recorderオブジェクトの解放
                break;
        }
    }
}
