package com.test.myapplication;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends Activity {

    private SeekBar seekBar;
    private View view;
    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(1000);
        view = (View)findViewById(R.id.view);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //System.out.println("OnSeekBarChangeListener-change-"+seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                System.out.println("OnSeekBarChangeListener-start-"+seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("OnSeekBarChangeListener-stop-"+seekBar.getProgress());
            }
        });
        mGestureDetector = new GestureDetector(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mGestureDetector.onTouchEvent(event))
            return true;
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                System.out.println("ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        int progress = 0;
        @Override
        public void onShowPress(MotionEvent motionEvent) {
            System.out.println("onShowPress");
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            System.out.println("onLongPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            System.out.println("onSingleTapUp");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

            float oldx = motionEvent.getX();
            float x = motionEvent1.getX();
            seekBar.setProgress(progress+(int) ((x - oldx)/2));
            System.out.println("onScroll-"+(int) (x - oldx));
            return false;
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            System.out.println("onFling");
            return false;
        }

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            System.out.println("onDown");
            progress = seekBar.getProgress();
            return false;
        }
    }
}
