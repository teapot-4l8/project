package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.core.h.w;
import androidx.customview.b.c;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.a;
import com.lxj.xpopup.a.e;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.c.d;

/* loaded from: classes2.dex */
public class PopupDrawerLayout extends FrameLayout {
    ArgbEvaluator argbEvaluator;
    e bgAnimator;
    c.a callback;
    boolean canChildScrollLeft;
    int defaultColor;
    c dragHelper;
    public boolean enableShadow;
    float fraction;
    boolean hasLayout;
    public boolean isCanClose;
    public boolean isDrawStatusBarShadow;
    boolean isIntercept;
    boolean isToLeft;
    private OnCloseListener listener;
    View mChild;
    Paint paint;
    View placeHolder;
    public d position;
    Rect shadowRect;
    b status;
    float ty;
    float x;
    float y;

    /* loaded from: classes2.dex */
    public interface OnCloseListener {
        void onClose();

        void onDismissing(float f);

        void onOpen();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = null;
        this.position = d.Left;
        this.bgAnimator = new e();
        this.argbEvaluator = new ArgbEvaluator();
        this.defaultColor = 0;
        this.isDrawStatusBarShadow = false;
        this.fraction = 0.0f;
        this.enableShadow = true;
        this.hasLayout = false;
        this.isIntercept = false;
        c.a aVar = new c.a() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.1
            @Override // androidx.customview.b.c.a
            public int getViewHorizontalDragRange(View view) {
                return 1;
            }

            @Override // androidx.customview.b.c.a
            public boolean tryCaptureView(View view, int i2) {
                return !PopupDrawerLayout.this.dragHelper.a(true);
            }

            @Override // androidx.customview.b.c.a
            public int clampViewPositionHorizontal(View view, int i2, int i3) {
                return view == PopupDrawerLayout.this.placeHolder ? i2 : PopupDrawerLayout.this.fixLeft(i2);
            }

            @Override // androidx.customview.b.c.a
            public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
                super.onViewPositionChanged(view, i2, i3, i4, i5);
                if (view == PopupDrawerLayout.this.placeHolder) {
                    PopupDrawerLayout.this.placeHolder.layout(0, 0, PopupDrawerLayout.this.placeHolder.getMeasuredWidth(), PopupDrawerLayout.this.placeHolder.getMeasuredHeight());
                    PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                    int fixLeft = popupDrawerLayout.fixLeft(popupDrawerLayout.mChild.getLeft() + i4);
                    PopupDrawerLayout.this.mChild.layout(fixLeft, PopupDrawerLayout.this.mChild.getTop(), PopupDrawerLayout.this.mChild.getMeasuredWidth() + fixLeft, PopupDrawerLayout.this.mChild.getBottom());
                    calcFraction(fixLeft);
                    return;
                }
                calcFraction(i2);
            }

            private void calcFraction(int i2) {
                if (PopupDrawerLayout.this.position == d.Left) {
                    PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                    popupDrawerLayout.fraction = ((popupDrawerLayout.mChild.getMeasuredWidth() + i2) * 1.0f) / PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    if (i2 == (-PopupDrawerLayout.this.mChild.getMeasuredWidth()) && PopupDrawerLayout.this.listener != null && PopupDrawerLayout.this.status != b.Close) {
                        PopupDrawerLayout.this.status = b.Close;
                        PopupDrawerLayout.this.listener.onClose();
                    }
                } else if (PopupDrawerLayout.this.position == d.Right) {
                    PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                    popupDrawerLayout2.fraction = ((popupDrawerLayout2.getMeasuredWidth() - i2) * 1.0f) / PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    if (i2 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.listener != null && PopupDrawerLayout.this.status != b.Close) {
                        PopupDrawerLayout.this.status = b.Close;
                        PopupDrawerLayout.this.listener.onClose();
                    }
                }
                if (PopupDrawerLayout.this.enableShadow) {
                    PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                    popupDrawerLayout3.setBackgroundColor(popupDrawerLayout3.bgAnimator.a(PopupDrawerLayout.this.fraction));
                }
                if (PopupDrawerLayout.this.listener != null) {
                    PopupDrawerLayout.this.listener.onDismissing(PopupDrawerLayout.this.fraction);
                    if (PopupDrawerLayout.this.fraction != 1.0f || PopupDrawerLayout.this.status == b.Open) {
                        return;
                    }
                    PopupDrawerLayout.this.status = b.Open;
                    PopupDrawerLayout.this.listener.onOpen();
                }
            }

            @Override // androidx.customview.b.c.a
            public void onViewReleased(View view, float f, float f2) {
                int measuredWidth;
                int measuredWidth2;
                super.onViewReleased(view, f, f2);
                if (view == PopupDrawerLayout.this.placeHolder && f == 0.0f) {
                    PopupDrawerLayout.this.close();
                } else if (view == PopupDrawerLayout.this.mChild && PopupDrawerLayout.this.isToLeft && !PopupDrawerLayout.this.canChildScrollLeft && f < -500.0f) {
                    PopupDrawerLayout.this.close();
                } else {
                    if (PopupDrawerLayout.this.position == d.Left) {
                        if (f < -1000.0f) {
                            measuredWidth2 = PopupDrawerLayout.this.mChild.getMeasuredWidth();
                        } else {
                            if (PopupDrawerLayout.this.mChild.getLeft() < (-PopupDrawerLayout.this.mChild.getMeasuredWidth()) / 2) {
                                measuredWidth2 = PopupDrawerLayout.this.mChild.getMeasuredWidth();
                            } else {
                                measuredWidth = 0;
                            }
                        }
                        measuredWidth = -measuredWidth2;
                    } else if (f > 1000.0f) {
                        measuredWidth = PopupDrawerLayout.this.getMeasuredWidth();
                    } else {
                        measuredWidth = view.getLeft() < PopupDrawerLayout.this.getMeasuredWidth() - (PopupDrawerLayout.this.mChild.getMeasuredWidth() / 2) ? PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.mChild.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth();
                    }
                    PopupDrawerLayout.this.dragHelper.a(PopupDrawerLayout.this.mChild, measuredWidth, view.getTop());
                    w.e(PopupDrawerLayout.this);
                }
            }
        };
        this.callback = aVar;
        this.isCanClose = true;
        this.dragHelper = c.a(this, aVar);
    }

    public void setDrawerPosition(d dVar) {
        this.position = dVar;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.placeHolder = getChildAt(0);
        this.mChild = getChildAt(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ty = getTranslationY();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.placeHolder;
        view.layout(0, 0, view.getMeasuredWidth(), this.placeHolder.getMeasuredHeight());
        if (!this.hasLayout) {
            if (this.position == d.Left) {
                View view2 = this.mChild;
                view2.layout(-view2.getMeasuredWidth(), 0, 0, getMeasuredHeight());
            } else {
                this.mChild.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.mChild.getMeasuredWidth(), getMeasuredHeight());
            }
            this.hasLayout = true;
            return;
        }
        View view3 = this.mChild;
        view3.layout(view3.getLeft(), this.mChild.getTop(), this.mChild.getRight(), this.mChild.getBottom());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.isToLeft = motionEvent.getX() < this.x;
        this.x = motionEvent.getX();
        this.y = motionEvent.getY();
        this.canChildScrollLeft = canScroll(this, motionEvent.getX(), motionEvent.getY(), 1);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.x = 0.0f;
            this.y = 0.0f;
        }
        boolean a2 = this.dragHelper.a(motionEvent);
        this.isIntercept = a2;
        if (!this.isToLeft || this.canChildScrollLeft) {
            if (!canScroll(this, motionEvent.getX(), motionEvent.getY())) {
                return this.isIntercept;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return a2;
    }

    private boolean canScroll(ViewGroup viewGroup, float f, float f2, int i) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            if (com.lxj.xpopup.g.c.a(f, f2, new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight())) && (childAt instanceof ViewGroup)) {
                if (childAt instanceof ViewPager) {
                    ViewPager viewPager = (ViewPager) childAt;
                    if (i == 0) {
                        return viewPager.canScrollHorizontally(-1) || viewPager.canScrollHorizontally(1);
                    }
                    return viewPager.canScrollHorizontally(i);
                } else if (childAt instanceof HorizontalScrollView) {
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) childAt;
                    if (i == 0) {
                        return horizontalScrollView.canScrollHorizontally(-1) || horizontalScrollView.canScrollHorizontally(1);
                    }
                    return horizontalScrollView.canScrollHorizontally(i);
                } else {
                    return canScroll((ViewGroup) childAt, f, f2, i);
                }
            }
        }
        return false;
    }

    private boolean canScroll(ViewGroup viewGroup, float f, float f2) {
        return canScroll(viewGroup, f, f2, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dragHelper.a(true)) {
            return true;
        }
        this.dragHelper.b(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fixLeft(int i) {
        if (this.position == d.Left) {
            if (i < (-this.mChild.getMeasuredWidth())) {
                i = -this.mChild.getMeasuredWidth();
            }
            if (i > 0) {
                return 0;
            }
            return i;
        } else if (this.position == d.Right) {
            if (i < getMeasuredWidth() - this.mChild.getMeasuredWidth()) {
                i = getMeasuredWidth() - this.mChild.getMeasuredWidth();
            }
            return i > getMeasuredWidth() ? getMeasuredWidth() : i;
        } else {
            return i;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.a(false)) {
            w.e(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.isDrawStatusBarShadow) {
            if (this.paint == null) {
                this.paint = new Paint();
                this.shadowRect = new Rect(0, 0, getMeasuredHeight(), com.lxj.xpopup.g.c.a());
            }
            this.paint.setColor(((Integer) this.argbEvaluator.evaluate(this.fraction, Integer.valueOf(this.defaultColor), Integer.valueOf(a.f5367a))).intValue());
            canvas.drawRect(this.shadowRect, this.paint);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.status = null;
        this.fraction = 0.0f;
        setTranslationY(this.ty);
    }

    public void open() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.2
            @Override // java.lang.Runnable
            public void run() {
                PopupDrawerLayout.this.dragHelper.a(PopupDrawerLayout.this.mChild, PopupDrawerLayout.this.position == d.Left ? 0 : PopupDrawerLayout.this.mChild.getLeft() - PopupDrawerLayout.this.mChild.getMeasuredWidth(), 0);
                w.e(PopupDrawerLayout.this);
            }
        });
    }

    public void close() {
        if (!this.dragHelper.a(true) && this.isCanClose) {
            post(new Runnable() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    PopupDrawerLayout.this.dragHelper.a(PopupDrawerLayout.this.mChild, PopupDrawerLayout.this.position == d.Left ? -PopupDrawerLayout.this.mChild.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth(), 0);
                    w.e(PopupDrawerLayout.this);
                }
            });
        }
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.listener = onCloseListener;
    }
}
