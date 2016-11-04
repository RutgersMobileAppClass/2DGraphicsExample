package com.example.instructor.a2dgraphicsexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by instructor on 11/4/2016.
 */


public class CustomView extends View {

    // for the rectangle
    int rectX = 20;
    final static int RECT_WIDTH = 180;
    final static int RECT_VELOCITY = 100;

    // for the bouncing ball
    int x = 10;
    int y = 10;
    final static int BALL_SIZE = 30;
    int X_VELOCITY = 100;
    int Y_VELOCITY = 100;





    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        drawBouncingBall(canvas);

        // Animated rectangle
        //Paint redPaint = new Paint();
        //redPaint.setARGB(255,255,0,0);

       // canvas.drawRect(rectX,20,rectX+RECT_WIDTH,200,redPaint);
        //rectX += RECT_VELOCITY;




        // Typeface Example
        /*Paint p = new Paint();
        p.setTypeface(
                Typeface.create(Typeface.MONOSPACE, Typeface.BOLD));
        p.setTextSize(40);
        p.setARGB(255, 0, 0, 255);

        canvas.drawText("Rutgers Mobile App Class!",100,100,p);*/


        /*
        // Target Example
        Paint red = new Paint();
        red.setARGB(255,255,0,0);
        Paint white = new Paint();
        white.setARGB(255,255,255,255);

        int height = canvas.getHeight();
        int width = canvas.getWidth();

        canvas.drawOval(0,0,width,height,red);
        canvas.drawOval(width/10,height/10,width*9/10,height*9/10,white);
        canvas.drawOval(width*2/10,height*2/10,width*8/10,height*8/10,red);
        canvas.drawOval(width*3/10,height*3/10,width*7/10,height*7/10,white);
        canvas.drawOval(width*4/10,height*4/10,width*6/10,height*6/10,red);
        */

    }

    private void drawBouncingBall(Canvas canvas) {
        Paint redPaint = new Paint();
        redPaint.setARGB(255,255,0,0);

        canvas.drawOval(x,y,x+BALL_SIZE,y+BALL_SIZE,redPaint);

        if(x + BALL_SIZE > canvas.getWidth() || x <= 0){
            X_VELOCITY = -X_VELOCITY;
        }

        if(y + BALL_SIZE > canvas.getHeight() || y <= 0){
            Y_VELOCITY = -Y_VELOCITY;
        }


        x = x + X_VELOCITY;
        y = y + Y_VELOCITY;



    }

    public void startTheAnimation(){
        try {
            Thread.sleep(0*1000);
            postInvalidate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        /*if(event.getAction() == MotionEvent.ACTION){
            System.out.println(x + "" + y);
        }*/




        return super.onTouchEvent(event);
    }
}
