package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.w;
import androidx.customview.b.c;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.e.b;
import com.lxj.xpopup.f.k;

/* loaded from: classes2.dex */
public class PhotoViewContainer extends FrameLayout {
    private static final String TAG = "PhotoViewContainer";
    private int HideTopThreshold;
    c.a cb;
    private b dragChangeListener;
    private c dragHelper;
    public boolean isReleasing;
    boolean isVertical;
    private int maxOffset;
    private float touchX;
    private float touchY;
    public ViewPager viewPager;

    public PhotoViewContainer(Context context) {
        this(context, null);
    }

    public PhotoViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.HideTopThreshold = 80;
        this.isReleasing = false;
        this.isVertical = false;
        this.cb = new c.a() { // from class: com.lxj.xpopup.widget.PhotoViewContainer.1
            @Override // androidx.customview.b.c.a
            public int getViewVerticalDragRange(View view) {
                return 1;
            }

            @Override // androidx.customview.b.c.a
            public boolean tryCaptureView(View view, int i2) {
                return !PhotoViewContainer.this.isReleasing;
            }

            @Override // androidx.customview.b.c.a
            public int clampViewPositionVertical(View view, int i2, int i3) {
                int top = PhotoViewContainer.this.viewPager.getTop() + (i3 / 2);
                return top >= 0 ? Math.min(top, PhotoViewContainer.this.maxOffset) : -Math.min(-top, PhotoViewContainer.this.maxOffset);
            }

            @Override // androidx.customview.b.c.a
            public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
                super.onViewPositionChanged(view, i2, i3, i4, i5);
                if (view != PhotoViewContainer.this.viewPager) {
                    PhotoViewContainer.this.viewPager.offsetTopAndBottom(i5);
                }
                float abs = (Math.abs(i3) * 1.0f) / PhotoViewContainer.this.maxOffset;
                float f = 1.0f - (0.2f * abs);
                PhotoViewContainer.this.viewPager.setScaleX(f);
                PhotoViewContainer.this.viewPager.setScaleY(f);
                view.setScaleX(f);
                view.setScaleY(f);
                if (PhotoViewContainer.this.dragChangeListener != null) {
                    PhotoViewContainer.this.dragChangeListener.a(i5, f, abs);
                }
            }

            @Override // androidx.customview.b.c.a
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                if (Math.abs(view.getTop()) > PhotoViewContainer.this.HideTopThreshold) {
                    if (PhotoViewContainer.this.dragChangeListener != null) {
                        PhotoViewContainer.this.dragChangeListener.b();
                        return;
                    }
                    return;
                }
                PhotoViewContainer.this.dragHelper.a((View) PhotoViewContainer.this.viewPager, 0, 0);
                PhotoViewContainer.this.dragHelper.a(view, 0, 0);
                w.e(PhotoViewContainer.this);
            }
        };
        init();
    }

    private void init() {
        this.HideTopThreshold = dip2px(this.HideTopThreshold);
        this.dragHelper = c.a(this, this.cb);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.viewPager = (ViewPager) getChildAt(0);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.maxOffset = getHeight() / 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.touchX = motionEvent.getX();
            this.touchY = motionEvent.getY();
        } else {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.touchX;
                    float y = motionEvent.getY() - this.touchY;
                    this.viewPager.dispatchTouchEvent(motionEvent);
                    this.isVertical = Math.abs(y) > Math.abs(x);
                    this.touchX = motionEvent.getX();
                    this.touchY = motionEvent.getY();
                }
            }
            this.touchX = 0.0f;
            this.touchY = 0.0f;
            this.isVertical = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean isTopOrBottomEnd() {
        k currentPhotoView = getCurrentPhotoView();
        return currentPhotoView != null && (currentPhotoView.f5489a.f5491a || currentPhotoView.f5489a.f5492b);
    }

    private k getCurrentPhotoView() {
        ViewPager viewPager = this.viewPager;
        return (k) viewPager.getChildAt(viewPager.getCurrentItem());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean a2 = this.dragHelper.a(motionEvent);
        if (motionEvent.getPointerCount() <= 1 || motionEvent.getAction() != 2) {
            if (isTopOrBottomEnd() && this.isVertical) {
                return true;
            }
            return a2 && this.isVertical;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        try {
            this.dragHelper.b(motionEvent);
        } catch (Exception unused) {
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.a(false)) {
            w.e(this);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setOnDragChangeListener(b bVar) {
        this.dragChangeListener = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isReleasing = false;
    }
}
