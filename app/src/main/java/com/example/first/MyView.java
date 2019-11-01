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
    @Override
    protected void onDraw(Canvas canvas){
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x, 300, 40, paint);
        // готовим x для следущего кадра
        x += 2;
        invalidate();
    }
}
