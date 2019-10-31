package com.example.first;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Здесь располагаются команды рисования
        ///...
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10);
        canvas.drawLine(0, 0, canvas.getWidth(),canvas.getHeight(),paint);
        int y = 0;
        while (y < canvas.getHeight()) {
            canvas.drawLine(0, y,
                    this.getWidth(), y, paint);
            y += 60;
        }
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        y = 0;
        while (y < canvas.getHeight()){
            canvas.drawLine(0, y, this.getWidth(), y, paint);
            y += 100;
        }
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(1000, 100, 500, 300, paint);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(300, 300, 1000, 100, paint);
        /*Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(300, 300, 200, paint);*/
        /*Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(100, 100, 300, 300, paint);*/
    }
}
