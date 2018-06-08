package com.example.leica.learnapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceActivity extends ActionBarActivity {
    CustomSurfaceView cs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cs = new CustomSurfaceView(this);

        setContentView( cs );
    }
}


class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    Thread thread;
    boolean isSurfaceStandby = false;

    float screenWidth, screenHeight;

    public CustomSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isSurfaceStandby = true;
        thread = new Thread(this);
        thread.start();

        setup();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        screenWidth = width;
        screenHeight = height;
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isSurfaceStandby = false;
        thread = null;
    }

    @Override
    public void run() {
        while (thread != null) {
            draw(getHolder());
        }
    }

    // main code

    float rectWidth = 50, rectHeight = 50, dx = 10, dy = 10;
    float posX, posY;

    private void setup(){
        posX = 0;
        posY = 0;
    }

    private void draw(SurfaceHolder holder){
        Canvas c = holder.lockCanvas();

        if (!isSurfaceStandby) return;

        Paint p = new Paint();

        p.setColor(Color.GREEN);

        c.drawColor(Color.DKGRAY);
        c.drawRect(posX, posY, posX + rectWidth, posY + rectHeight, p);

        if (posX < 0 || posX + rectWidth > screenWidth)        dx *= -1;
        if (posY < 0 || posY + rectHeight > screenHeight)      dy *= -1;
        posX += dx;
        posY += dy;

        holder.unlockCanvasAndPost(c);
    }
}