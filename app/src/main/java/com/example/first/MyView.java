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

    Paint paint = new Paint();
    int x = 0;
    long lastTime = System.currentTimeMillis();
    @Override
    protected void onDraw(Canvas canvas){
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x, 300, 40, paint);
        // готовим x для следущего кадра
        long nowTime = System.currentTimeMillis();
        x += 2;
        lastTime = nowTime;
        invalidate();
    }
}
