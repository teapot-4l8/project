package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.g.c;

/* loaded from: classes2.dex */
public class LoadingView extends View {
    private ArgbEvaluator argbEvaluator;
    float avgAngle;
    float centerX;
    float centerY;
    private int endColor;
    private Runnable increaseTask;
    int lineCount;
    private Paint paint;
    private float radius;
    private float radiusOffset;
    private int startColor;
    private float stokeWidth;
    int time;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.stokeWidth = 2.0f;
        this.argbEvaluator = new ArgbEvaluator();
        this.startColor = Color.parseColor("#CCCCCC");
        this.endColor = Color.parseColor("#333333");
        this.lineCount = 12;
        this.avgAngle = 360.0f / 12;
        this.time = 0;
        this.increaseTask = new Runnable() { // from class: com.lxj.xpopup.widget.LoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingView.this.time++;
                LoadingView.this.invalidate();
            }
        };
        this.paint = new Paint(1);
        float a2 = c.a(context, this.stokeWidth);
        this.stokeWidth = a2;
        this.paint.setStrokeWidth(a2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float measuredWidth = getMeasuredWidth() / 2;
        this.radius = measuredWidth;
        this.radiusOffset = measuredWidth / 2.5f;
        this.centerX = getMeasuredWidth() / 2;
        this.centerY = getMeasuredHeight() / 2;
        float measuredWidth2 = this.stokeWidth * ((getMeasuredWidth() * 1.0f) / c.a(getContext(), 30.0f));
        this.stokeWidth = measuredWidth2;
        this.paint.setStrokeWidth(measuredWidth2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        for (int i2 = this.lineCount - 1; i2 >= 0; i2--) {
            int abs = Math.abs(this.time + i2);
            this.paint.setColor(((Integer) this.argbEvaluator.evaluate((((abs % i) + 1) * 1.0f) / this.lineCount, Integer.valueOf(this.startColor), Integer.valueOf(this.endColor))).intValue());
            float f = this.centerX + this.radiusOffset;
            float f2 = (this.radius / 3.0f) + f;
            float f3 = this.centerY;
            canvas.drawLine(f, f3, f2, f3, this.paint);
            canvas.drawCircle(f, this.centerY, this.stokeWidth / 2.0f, this.paint);
            canvas.drawCircle(f2, this.centerY, this.stokeWidth / 2.0f, this.paint);
            canvas.rotate(this.avgAngle, this.centerX, this.centerY);
        }
        postDelayed(this.increaseTask, 80L);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.increaseTask);
    }
}
