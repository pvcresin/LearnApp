package com.example.leica.learnapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class PlayActivity extends ActionBarActivity {
    private MediaPlayer mp;

    Uri URL = Uri.parse( "http://mloa.net/openhacku/files/GeoMelody.3gp" );

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        mp = MediaPlayer.create( this, URL );        //リソースファイルから再生
        mp.start();
    }
}
