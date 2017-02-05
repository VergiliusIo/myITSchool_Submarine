package com.myitschool.submarine;

import android.graphics.Canvas;
import android.icu.util.TimeUnit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static com.myitschool.submarine.MyDraw.submarine;

public class MainActivity extends AppCompatActivity {
    MyThread myThread;
    Button btn_locate;
    TextView textView;
    MyDraw m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m = new MyDraw(this);
        setContentView(m);

        btn_locate = (Button) findViewById(R.id.locate);
        textView = (TextView) findViewById(R.id.textView);

        myThread = new MyThread();
        myThread.start();
    }

    public void onClickButton(View view) {
        String submarineX = String.valueOf(submarine.x);
        String submarineY = String.valueOf(submarine.y);

        String location = String.format("%s : %s", submarineX, submarineY);

        textView.setText(location);

        long endTime = System.currentTimeMillis() + 5 * 1000;
        try {
            myThread.sleep((long) 5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (endTime - System.currentTimeMillis() != 0) {
            m.invalidate();
        }
        textView.setText("");
    }

    class MyThread extends Thread {
        Random random = new Random();
        @Override
        public void run() {
            int newX = random.nextInt(m.getWidth() - submarine.radius);
            int newY = random.nextInt(m.getHeight() - submarine.radius);

            submarine.x = newX;
            submarine.y = newY;

            String submarineX = String.valueOf(submarine.x);
            String submarineY = String.valueOf(submarine.y);

            String location = String.format("%s : %s", submarineX, submarineY);

            textView.setText(location);
        }
    }
}
