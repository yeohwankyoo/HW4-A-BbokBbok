package com.example.yeohwankyoo.hw4_a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
public class BubblePop extends View{
    private Paint mPaint;
    private Bitmap bubble;         //bitmap image bubble 1
    private Bitmap bubble2;         //bitmap image bubble 2
    int pointX, pointY;             //current X point and Y point
    boolean[][] gridpop = new boolean[7][5];     //State of bubble

    //initial bitmap image
    public void init()
    {
        mPaint = new Paint();
        Resources res = getResources();
        bubble = BitmapFactory.decodeResource(res, R.drawable.bubble);   // Save bitmap
        bubble = Bitmap.createScaledBitmap(bubble, 220, 220, false);    //resizing
        bubble2 = BitmapFactory.decodeResource(res, R.drawable.bubble2);  //save bitmap
        bubble2 = Bitmap.createScaledBitmap(bubble2, 220, 220, false);//resizing
    }

    public BubblePop(Context c) {
        super(c);

        //initial state of bubble (false - not explosion, true - explosion)
        for(int i=0; i<7; i++)
            for(int j=0; j<5; j++)
                gridpop[i][j] = false;
        init();
    }
    public BubblePop(Context c, AttributeSet a) {
        super(c, a);
        init();
    }

    //Touch Event
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            pointX = (int)event.getX();              // Get current X
            pointY = (int)event.getY();              // Get current y
            gridpop[pointY/220][pointX/220] = true;        //Change state of bubble ( Explosion)
            invalidate();               //Call onDraw
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        int nowLocationx=0,nowLocaiony=0; //Location of x, y

        for(int i=0; i<7; i++)
        {
            for(int j = 0; j <5; j++)
            {
                if(gridpop[i][j]==false)
                    canvas.drawBitmap(bubble, nowLocationx, nowLocaiony, mPaint);    //Drawing image
                else
                    canvas.drawBitmap(bubble2, nowLocationx, nowLocaiony, mPaint);    //Drawing image (Explosion of bubble)
                nowLocationx+=220;
            }
            nowLocationx=0;
            nowLocaiony+=220;
        }

        canvas.save();
        canvas.restore();
    }
}