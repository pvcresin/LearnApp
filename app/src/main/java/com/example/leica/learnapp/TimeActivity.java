package com.example.leica.learnapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeActivity extends ActionBarActivity {

    private Handler mHandler = new Handler();    // スレッドUI操作用ハンドラ

    private Runnable updateText, updateTime;                 // テキストオブジェクト

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);


        updateText = new Runnable() {            // count process
            int count = 0;

            @Override
            public void run() {
                TextView text = (TextView) findViewById( R.id.countText );

                count++;

                text.setText(count + "s");

                mHandler.removeCallbacks( updateText );
                mHandler.postDelayed( updateText, 1000 );   // 1000 ms cycle
            }
        };
        mHandler.postDelayed( updateText, 1000 );           // 1000 ms cycle


        updateTime = new Runnable() {            // Date process

            @Override
            public void run() {

                // Time Class !!
                TextView timeText = (TextView) findViewById( R.id.timeClassText );
                Time time = new Time("Asia/Tokyo");                                             // select time zone
                time.setToNow();
                String date_Time = time.year + " " + (time.month + 1) + "/" + time.monthDay + " " + time.hour + ":" + time.minute + " " + time.second;
                timeText.setText( date_Time + " by Time");


                // Date Class !!
                TextView dateText = (TextView) findViewById( R.id.dateClasssText );
                Date date_Date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyy' 'M'/'d' 'H':'mm' 'ss" );     // make format
                dateText.setText( sdf.format( date_Date ) + " by Date");


                // Calendar class
                TextView calendarText = (TextView) findViewById( R.id.calendarClassText );
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);
                String date_Calendar = year + " " + (month+1) + "/" + day + " " + hour + ":" + minute + " " + second;
                calendarText.setText( date_Calendar + " by Calendar" );


                mHandler.removeCallbacks( updateTime );
                mHandler.postDelayed( updateTime, 200 );    // 200 ms cycle
            }
        };
        mHandler.postDelayed( updateTime, 200 );            // 200 ms cycle


    }
}
