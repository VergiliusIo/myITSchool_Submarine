package com.myitschool.submarine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by lophtpicker on 05.02.2017.
 */

public class MyDraw extends View {
    static Submarine submarine = new Submarine(50, 50, 50);

    public MyDraw(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        submarine.draw(canvas);
    }
}
