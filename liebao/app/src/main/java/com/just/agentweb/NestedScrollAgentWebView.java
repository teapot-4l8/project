package com.just.agentweb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.h.j;
import androidx.core.h.k;
import androidx.core.h.n;

/* loaded from: classes.dex */
public class NestedScrollAgentWebView extends AgentWebView implements k {
    private n mChildHelper;
    private int mLastMotionY;
    private int mNestedYOffset;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;

    public NestedScrollAgentWebView(Context context) {
        super(context);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        init();
    }

    public NestedScrollAgentWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        init();
    }

    private void init() {
        this.mChildHelper = new n(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[] iArr;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a2 = j.a(motionEvent);
        if (a2 == 0) {
            this.mNestedYOffset = 0;
        }
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.mNestedYOffset);
        if (a2 == 0) {
            this.mLastMotionY = y;
            startNestedScroll(2);
            return super.onTouchEvent(motionEvent);
        }
        if (a2 != 1) {
            if (a2 == 2) {
                int i = this.mLastMotionY - y;
                if (dispatchNestedPreScroll(0, i, this.mScrollConsumed, this.mScrollOffset)) {
                    i -= this.mScrollConsumed[1];
                    obtain.offsetLocation(0.0f, this.mScrollOffset[1]);
                    this.mNestedYOffset += this.mScrollOffset[1];
                }
                this.mLastMotionY = y - this.mScrollOffset[1];
                int scrollY = getScrollY();
                int max = Math.max(0, scrollY + i) - scrollY;
                if (dispatchNestedScroll(0, max, 0, i - max, this.mScrollOffset)) {
                    this.mLastMotionY = this.mLastMotionY - this.mScrollOffset[1];
                    obtain.offsetLocation(0.0f, iArr[1]);
                    this.mNestedYOffset += this.mScrollOffset[1];
                }
                boolean onTouchEvent = super.onTouchEvent(obtain);
                obtain.recycle();
                return onTouchEvent;
            } else if (a2 != 3 && a2 != 5) {
                return false;
            }
        }
        stopNestedScroll();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.a(z);
    }

    @Override // android.view.View, androidx.core.h.k
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.mChildHelper.b(i);
    }

    @Override // android.view.View, androidx.core.h.k
    public void stopNestedScroll() {
        this.mChildHelper.c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.b();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.a(f, f2);
    }
}
