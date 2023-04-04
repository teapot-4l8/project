package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.h.o;
import androidx.core.h.w;
import com.lxj.xpopup.a;
import com.lxj.xpopup.a.e;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.g.c;

/* loaded from: classes2.dex */
public class SmartDragLayout extends FrameLayout implements o {
    private static final String TAG = "SmartDragLayout";
    e bgAnimator;
    private View child;
    boolean dismissOnTouchOutside;
    boolean enableDrag;
    boolean hasShadowBg;
    boolean isScrollUp;
    boolean isUserClose;
    int lastHeight;
    private OnCloseListener listener;
    int maxY;
    int minY;
    OverScroller scroller;
    b status;
    float touchX;
    float touchY;
    VelocityTracker tracker;

    /* loaded from: classes2.dex */
    public interface OnCloseListener {
        void onClose();

        void onOpen();
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgAnimator = new e();
        this.enableDrag = true;
        this.dismissOnTouchOutside = true;
        this.hasShadowBg = true;
        this.isUserClose = false;
        this.status = b.Close;
        if (this.enableDrag) {
            this.scroller = new OverScroller(context);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.child = view;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.maxY = this.child.getMeasuredHeight();
        this.minY = 0;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.child.getMeasuredWidth() / 2);
        if (this.enableDrag) {
            this.child.layout(measuredWidth, getMeasuredHeight(), this.child.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.maxY);
            if (this.status == b.Open) {
                scrollTo(getScrollX(), getScrollY() - (this.lastHeight - this.maxY));
            }
        } else {
            this.child.layout(measuredWidth, getMeasuredHeight() - this.child.getMeasuredHeight(), this.child.getMeasuredWidth() + measuredWidth, getMeasuredHeight());
        }
        this.lastHeight = this.maxY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.isUserClose = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scroller.computeScrollOffset()) {
            this.touchX = 0.0f;
            this.touchY = 0.0f;
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.enableDrag) {
                this.tracker = VelocityTracker.obtain();
            }
            this.touchX = motionEvent.getX();
            this.touchY = motionEvent.getY();
        } else {
            if (action != 1) {
                if (action == 2) {
                    if (this.enableDrag) {
                        this.tracker.addMovement(motionEvent);
                        this.tracker.computeCurrentVelocity(1000);
                        scrollTo(getScrollX(), getScrollY() - ((int) (motionEvent.getY() - this.touchY)));
                        this.touchY = motionEvent.getY();
                    }
                }
            }
            Rect rect = new Rect();
            this.child.getGlobalVisibleRect(rect);
            if (!c.a(motionEvent.getRawX(), motionEvent.getRawY(), rect) && this.dismissOnTouchOutside && ((float) Math.sqrt(Math.pow(motionEvent.getX() - this.touchX, 2.0d) + Math.pow(motionEvent.getY() - this.touchY, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                performClick();
            }
            if (this.enableDrag) {
                if (this.tracker.getYVelocity() > 1500.0f) {
                    close();
                } else {
                    finishScroll();
                }
                this.tracker.clear();
                this.tracker.recycle();
            }
        }
        return true;
    }

    private void finishScroll() {
        if (this.enableDrag) {
            this.scroller.startScroll(getScrollX(), getScrollY(), 0, (getScrollY() > (this.isScrollUp ? this.maxY - this.minY : (this.maxY - this.minY) * 2) / 3 ? this.maxY : this.minY) - getScrollY(), a.b());
            w.e(this);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        int i3 = this.maxY;
        if (i2 > i3) {
            i2 = i3;
        }
        int i4 = this.minY;
        if (i2 < i4) {
            i2 = i4;
        }
        int i5 = this.minY;
        float f = ((i2 - i5) * 1.0f) / (this.maxY - i5);
        this.isScrollUp = i2 > getScrollY();
        if (this.hasShadowBg) {
            setBackgroundColor(this.bgAnimator.a(f));
        }
        if (this.listener != null) {
            if (this.isUserClose && f == 0.0f && this.status != b.Close) {
                this.status = b.Close;
                this.listener.onClose();
            } else if (f == 1.0f && this.status != b.Open) {
                this.status = b.Open;
                this.listener.onOpen();
            }
        }
        super.scrollTo(i, i2);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            w.e(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isScrollUp = false;
        this.isUserClose = false;
        setTranslationY(0.0f);
    }

    public void open() {
        this.status = b.Opening;
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.1
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                smartDragLayout.smoothScroll(smartDragLayout.maxY - SmartDragLayout.this.getScrollY());
            }
        });
    }

    public void close() {
        this.isUserClose = true;
        this.status = b.Closing;
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.2
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                smartDragLayout.smoothScroll(smartDragLayout.minY - SmartDragLayout.this.getScrollY());
            }
        });
    }

    public void smoothScroll(final int i) {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.3
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout.this.scroller.startScroll(SmartDragLayout.this.getScrollX(), SmartDragLayout.this.getScrollY(), 0, i, a.b());
                w.e(SmartDragLayout.this);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return i == 2 && this.enableDrag;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.scroller.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onStopNestedScroll(View view) {
        finishScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY() + i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            int scrollY = getScrollY() + i2;
            if (scrollY < this.maxY) {
                iArr[1] = i2;
            }
            scrollTo(getScrollX(), scrollY);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if ((getScrollY() > this.minY && getScrollY() < this.maxY) && f2 < -1500.0f) {
            close();
        }
        return false;
    }

    public void enableDrag(boolean z) {
        this.enableDrag = z;
    }

    public void dismissOnTouchOutside(boolean z) {
        this.dismissOnTouchOutside = z;
    }

    public void hasShadowBg(boolean z) {
        this.hasShadowBg = z;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.listener = onCloseListener;
    }
}
