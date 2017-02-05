package com.myitschool.submarine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by lophtpicker on 05.02.2017.
 */

public class Submarine {
    int x, y, radius;
    final int COLOR_SUBMARINE = Color.RED;

    public Submarine (int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    public void draw(Canvas canvas) {
        Paint paint = new Paint();

        paint.setColor(COLOR_SUBMARINE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);


        canvas.drawCircle(x, y, radius, paint);
    }
}
