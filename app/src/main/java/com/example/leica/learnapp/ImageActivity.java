package com.example.leica.learnapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.View;


public class ImageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

}

class ImageView extends View {
    private Bitmap image = null;

    public ImageView(Context context) {
        super(context);
        initial(context);
    }

    public ImageView(Context context, AttributeSet attrs){
        super(context, attrs);
        initial(context);
    }

    public ImageView(Context context, AttributeSet attrs, int defstyle){
        super(context, attrs, defstyle);
        initial(context);
    }

    public void initial(Context context){
        Resources res = context.getResources();
        image = BitmapFactory.decodeResource(res, R.drawable.bear); // select image in drawable
    }

    @SuppressLint("DrawAllocation")

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor( Color.rgb(0, 0, 100) );

        Paint paint = new Paint();

        if (image != null){
            canvas.drawBitmap(image, 0, 0, paint);
        }
    }



}
