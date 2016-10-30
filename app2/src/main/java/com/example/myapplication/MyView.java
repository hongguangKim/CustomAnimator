package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

/**
 * Created by jinhongguang on 16/10/29.
 */
class MyView extends TextView {
    private String TAG = "MyView";
    private int sroke_width = 5;

    TranslateAnimation animation;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        ViewCompat.animate(this).setDuration(300).translationX(Math.abs(getLeft())).setInterpolator(new BounceInterpolator()).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStrokeWidth(sroke_width);
        //  将边框设为黑色
        paint.setColor(Color.WHITE);
        //  画TextView的4个边
        canvas.drawLine(sroke_width, sroke_width, this.getWidth()-sroke_width, sroke_width, paint);
        canvas.drawLine(sroke_width, sroke_width, sroke_width, this.getHeight()-sroke_width, paint);
        canvas.drawLine(this.getWidth()-sroke_width*2, sroke_width, this.getWidth()-sroke_width*2, this.getHeight()-sroke_width, paint);
        canvas.drawLine(sroke_width, this.getHeight()-sroke_width, this.getWidth()-sroke_width, this.getHeight()-sroke_width, paint);

    }
}
