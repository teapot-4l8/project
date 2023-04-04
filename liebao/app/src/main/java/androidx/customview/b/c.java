package androidx.customview.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.h.w;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class c {
    private static final Interpolator v = new Interpolator() { // from class: androidx.customview.b.c.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f1797a;

    /* renamed from: b  reason: collision with root package name */
    private int f1798b;

    /* renamed from: d  reason: collision with root package name */
    private float[] f1800d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f1801e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private OverScroller f1802q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;

    /* renamed from: c  reason: collision with root package name */
    private int f1799c = -1;
    private final Runnable w = new Runnable() { // from class: androidx.customview.b.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.b(0);
        }
    };

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public static c a(ViewGroup viewGroup, a aVar) {
        return new c(viewGroup.getContext(), viewGroup, aVar);
    }

    public static c a(ViewGroup viewGroup, float f, a aVar) {
        c a2 = a(viewGroup, aVar);
        a2.f1798b = (int) (a2.f1798b * (1.0f / f));
        return a2;
    }

    private c(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1798b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1802q = new OverScroller(context, v);
    }

    public int a() {
        return this.f1797a;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.f1799c = i;
        this.r.onViewCaptured(view, i);
        b(1);
    }

    public int b() {
        return this.f1798b;
    }

    public void c() {
        this.f1799c = -1;
        d();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public boolean a(View view, int i, int i2) {
        this.s = view;
        this.f1799c = -1;
        boolean a2 = a(i, i2, 0, 0);
        if (!a2 && this.f1797a == 0 && this.s != null) {
            this.s = null;
        }
        return a2;
    }

    public boolean a(int i, int i2) {
        if (!this.t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return a(i, i2, (int) this.l.getXVelocity(this.f1799c), (int) this.l.getYVelocity(this.f1799c));
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1802q.abortAnimation();
            b(0);
            return false;
        }
        this.f1802q.startScroll(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        b(2);
        return true;
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int b2 = b(i3, (int) this.n, (int) this.m);
        int b3 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b2);
        int abs4 = Math.abs(b3);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (b2 != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (b3 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((a(i, b2, this.r.getViewHorizontalDragRange(view)) * f5) + (a(i2, b3, this.r.getViewVerticalDragRange(view)) * (f3 / f4)));
    }

    private int a(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = width / 2;
        float a2 = f + (a(Math.min(1.0f, Math.abs(i) / width)) * f);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private float a(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public boolean a(boolean z) {
        if (this.f1797a == 2) {
            boolean computeScrollOffset = this.f1802q.computeScrollOffset();
            int currX = this.f1802q.getCurrX();
            int currY = this.f1802q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                w.g(this.s, left);
            }
            if (top != 0) {
                w.f(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.onViewPositionChanged(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1802q.getFinalX() && currY == this.f1802q.getFinalY()) {
                this.f1802q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    b(0);
                }
            }
        }
        return this.f1797a == 2;
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.onViewReleased(this.s, f, f2);
        this.t = false;
        if (this.f1797a == 1) {
            b(0);
        }
    }

    private void d() {
        float[] fArr = this.f1800d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1801e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void c(int i) {
        if (this.f1800d == null || !a(i)) {
            return;
        }
        this.f1800d[i] = 0.0f;
        this.f1801e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = ((1 << i) ^ (-1)) & this.k;
    }

    private void d(int i) {
        float[] fArr = this.f1800d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f1800d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f1801e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1800d = fArr2;
            this.f1801e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private void a(float f, float f2, int i) {
        d(i);
        float[] fArr = this.f1800d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f1801e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = d((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (e(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    public boolean a(int i) {
        return ((1 << i) & this.k) != 0;
    }

    void b(int i) {
        this.u.removeCallbacks(this.w);
        if (this.f1797a != i) {
            this.f1797a = i;
            this.r.onViewDragStateChanged(i);
            if (this.f1797a == 0) {
                this.s = null;
            }
        }
    }

    boolean b(View view, int i) {
        if (view == this.s && this.f1799c == i) {
            return true;
        }
        if (view == null || !this.r.tryCaptureView(view, i)) {
            return false;
        }
        this.f1799c = i;
        a(view, i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(MotionEvent motionEvent) {
        boolean z;
        View c2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            z = false;
            int pointerId = motionEvent.getPointerId(0);
            a(x, y, pointerId);
            View c3 = c((int) x, (int) y);
            if (c3 == this.s && this.f1797a == 2) {
                b(c3, pointerId);
            }
            int i = this.h[pointerId];
            int i2 = this.p;
            if ((i & i2) != 0) {
                this.r.onEdgeTouched(i & i2, pointerId);
            }
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId2 = motionEvent.getPointerId(actionIndex);
                            float x2 = motionEvent.getX(actionIndex);
                            float y2 = motionEvent.getY(actionIndex);
                            a(x2, y2, pointerId2);
                            int i3 = this.f1797a;
                            if (i3 == 0) {
                                int i4 = this.h[pointerId2];
                                int i5 = this.p;
                                if ((i4 & i5) != 0) {
                                    this.r.onEdgeTouched(i4 & i5, pointerId2);
                                }
                            } else if (i3 == 2 && (c2 = c((int) x2, (int) y2)) == this.s) {
                                b(c2, pointerId2);
                            }
                        } else if (actionMasked == 6) {
                            c(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (this.f1800d != null && this.f1801e != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i6 = 0; i6 < pointerCount; i6++) {
                        int pointerId3 = motionEvent.getPointerId(i6);
                        if (e(pointerId3)) {
                            float x3 = motionEvent.getX(i6);
                            float y3 = motionEvent.getY(i6);
                            float f = x3 - this.f1800d[pointerId3];
                            float f2 = y3 - this.f1801e[pointerId3];
                            View c4 = c((int) x3, (int) y3);
                            boolean z2 = c4 != null && a(c4, f, f2);
                            if (z2) {
                                int left = c4.getLeft();
                                int i7 = (int) f;
                                int clampViewPositionHorizontal = this.r.clampViewPositionHorizontal(c4, left + i7, i7);
                                int top = c4.getTop();
                                int i8 = (int) f2;
                                int clampViewPositionVertical = this.r.clampViewPositionVertical(c4, top + i8, i8);
                                int viewHorizontalDragRange = this.r.getViewHorizontalDragRange(c4);
                                int viewVerticalDragRange = this.r.getViewVerticalDragRange(c4);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange == 0) {
                                    break;
                                } else if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                    break;
                                }
                            }
                            b(f, f2, pointerId3);
                            if (this.f1797a != 1) {
                                if (z2 && b(c4, pointerId3)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    c(motionEvent);
                }
                z = false;
            }
            c();
            z = false;
        }
        if (this.f1797a == 1) {
            return true;
        }
        return z;
    }

    public void b(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View c2 = c((int) x, (int) y);
            a(x, y, pointerId);
            b(c2, pointerId);
            int i3 = this.h[pointerId];
            int i4 = this.p;
            if ((i3 & i4) != 0) {
                this.r.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f1797a == 1) {
                e();
            }
            c();
        } else if (actionMasked == 2) {
            if (this.f1797a == 1) {
                if (e(this.f1799c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1799c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f;
                    int i5 = this.f1799c;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.g[i5]);
                    b(this.s.getLeft() + i6, this.s.getTop() + i7, i6, i7);
                    c(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (e(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f1800d[pointerId2];
                    float f2 = y3 - this.f1801e[pointerId2];
                    b(f, f2, pointerId2);
                    if (this.f1797a != 1) {
                        View c3 = c((int) x3, (int) y3);
                        if (a(c3, f, f2) && b(c3, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            c(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f1797a == 1) {
                a(0.0f, 0.0f);
            }
            c();
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            a(x4, y4, pointerId3);
            if (this.f1797a == 0) {
                b(c((int) x4, (int) y4), pointerId3);
                int i8 = this.h[pointerId3];
                int i9 = this.p;
                if ((i8 & i9) != 0) {
                    this.r.onEdgeTouched(i8 & i9, pointerId3);
                }
            } else if (b((int) x4, (int) y4)) {
                b(this.s, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.f1797a == 1 && pointerId4 == this.f1799c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i2);
                    if (pointerId5 != this.f1799c) {
                        View c4 = c((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.s;
                        if (c4 == view && b(view, pointerId5)) {
                            i = this.f1799c;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    e();
                }
            }
            c(pointerId4);
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = a(f, f2, i, 1) ? 1 : 0;
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.onEdgeDragStarted(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f1798b;
        if (abs > i3 || abs2 > i3) {
            if (abs >= abs2 * 0.5f || !this.r.onEdgeLock(i2)) {
                return (this.i[i] & i2) == 0 && abs > ((float) this.f1798b);
            }
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.r.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f1798b) : z2 && Math.abs(f2) > ((float) this.f1798b);
        }
        int i = this.f1798b;
        return (f * f) + (f2 * f2) > ((float) (i * i));
    }

    private void e() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.f1799c), this.n, this.m), a(this.l.getYVelocity(this.f1799c), this.n, this.m));
    }

    private void b(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i = this.r.clampViewPositionHorizontal(this.s, i, i3);
            w.g(this.s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.r.clampViewPositionVertical(this.s, i2, i4);
            w.f(this.s, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r.onViewPositionChanged(this.s, i5, i6, i5 - left, i6 - top);
    }

    public boolean b(int i, int i2) {
        return b(this.s, i, i2);
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View c(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int d(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    private boolean e(int i) {
        if (a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
