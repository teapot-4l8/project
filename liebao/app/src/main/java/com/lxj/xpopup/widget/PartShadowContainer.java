package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.lxj.xpopup.e.a;
import com.lxj.xpopup.g.c;

/* loaded from: classes2.dex */
public class PartShadowContainer extends FrameLayout {
    public boolean isDismissOnTouchOutside;
    private a listener;
    private float x;
    private float y;

    public PartShadowContainer(Context context) {
        super(context);
        this.isDismissOnTouchOutside = true;
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDismissOnTouchOutside = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (!c.a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.x = motionEvent.getX();
                this.y = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.x, 2.0d) + Math.pow(motionEvent.getY() - this.y, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.isDismissOnTouchOutside && (aVar = this.listener) != null) {
                    aVar.a();
                }
                this.x = 0.0f;
                this.y = 0.0f;
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(a aVar) {
        this.listener = aVar;
    }
}
