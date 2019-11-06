package com.example.first;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import static android.graphics.Color.rgb;

public class MyView extends View {
    int N = 6; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    //float f = 0;
    int re=255,gr=0,bl=0;
    float rad = 40;
    float max = 15;
    float min = 6;
    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }
    void addValues(float[] array , float[] values) {
        for (int i = 0; i < array.length; i++) {
            array[i] += values[i];
        }
    }
    void drawBalls(Canvas canvas)
    {
        Paint paint = new Paint();
        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(re,gr,bl));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x[i], y[i], rad, paint);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
            canvas.drawCircle(x[i], y[i], rad, paint);

        }
        if(re==255&&gr==0&&bl!=255){bl+=1;}
        else if(re==0&&gr!=255&&bl==255){gr+=1;}
        else if (re==0&&gr==255&&bl!=0){bl-=1;}
        else if (re!=255&&gr==255&&bl==0){re+=1;}
        else if (re==255&&gr!=0&&bl==0){gr-=1;}
        else if(re!=0&&gr==0&&bl==255){re-=1;}
        for (int i = 0; i < N - 1; i++) {

            canvas.drawLine(x[i], y[i], x[i + 1], y[i + 1], paint);

        }
    }


    public MyView(Context context) {
        super(context);


        /*for (int i = 0; i < N; i++){
            x[i] = (float)(Math.random() * 500);
            y[i] = (float)(Math.random() * 500);
            vx[i] = (float)(Math.random() * 9 - 3);
            vy[i] = (float)(Math.random() * 9 - 3);
        }*/
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 15);
        fillRandom(vy, 0,15);

        }


    long lastTime = System.currentTimeMillis();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBalls(canvas);
        //Здесь располагаются команды рисования
        ///...
        //Paint paint = new Paint();
        /*canvas.drawCircle(f, 300, 20, paint);
        // готовим x c учетом прошедшего времени
        // c момента последней перерисовки
        long nowTime = System.currentTimeMillis();
        f += 0.01f * (nowTime - lastTime);
        // сохраняем время последней перерисовки
        lastTime = nowTime;
        invalidate();*/
        // отрисовываем все шарики
        /*for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(re,gr,bl));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x[i], y[i], rad, paint);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
            canvas.drawCircle(x[i], y[i], rad, paint);
        }*/

        // готовим массивы x и у для следущего кадра
        /*for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
            if (x[i] < 0 || x[i] > this.getWidth()){

                vx[i] = - vx[i];

            }
            if (y[i] < 0 || y[i] > this.getHeight()){

                vy[i] = - vy[i];

            }
        }
        for (int i = 0; i < N; i++)
        {
            if (vx[i] > 0)
                rad += 0.08;
            else
                rad -= 0.08;
        }*/
        // готовим массивы x и у для следущего кадра
        addValues(x, vx);
        addValues(y, vy);
        for (int i = 0; i < N; i++) {
            if (x[i] < 0 || x[i] > this.getWidth()){

                vx[i] = - vx[i];

            }
            if (y[i] < 0 || y[i] > this.getHeight()){

                vy[i] = - vy[i];

            }
        }
        for (int i = 0; i < N; i++)
        {
            if (vx[i] > 0)
                rad += 0.08;
            else
                rad -= 0.08;
        }

        //запрашиваем перерисовку
        invalidate();
    }
}