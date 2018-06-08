package com.example.leica.learnapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.View;


public class DrawActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        /*
        DrawView view = new DrawView( getApplication() );  //  preview only DrawView
        setContentView( view );
        */
    }

}

class DrawView extends View { // drawing class

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defstyle){
        super(context, attrs, defstyle);
    }

    @Override
    public void onDraw(Canvas canvas) {              // drawing!!
        Paint paint = new Paint();
        paint.setAntiAlias( true );

        setBackgroundColor(Color.rgb(0, 0, 100));

        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.BLUE);
        canvas.drawRect(100, 100f, 200f, 200f, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawOval( new RectF(0f, 0f, 100f, 100f), paint );

        canvas.drawCircle(200, 400, 200, paint);


        paint.setColor(Color.GRAY);
        paint.setTextSize(100);
        canvas.drawText("Hell", 400, 400, paint);

        paint.setStrokeWidth(10);
        canvas.drawLine( 200, 0, 0, 300, paint );

        paint.setStyle(Paint.Style.STROKE); // no fill
        paint.setStrokeWidth(5);
        for(int i=0; i<50; i++ ){
            int A = (int)( 255*Math.random() ), R = (int)( 255*Math.random() ), G = (int)( 255*Math.random() ), B = (int)( 255*Math.random() );
            float x = (float)( 1000*Math.random() ), y = (float)( 2000*Math.random() ), r = (float)( 100*Math.random() );

            paint.setARGB( A, R, G, B );
            canvas.drawCircle( x, y, r, paint );
        }
    }
}
