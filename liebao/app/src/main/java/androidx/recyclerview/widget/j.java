package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
public class j extends RecyclerView.h implements RecyclerView.m {
    private static final int[] k = {16842919};
    private static final int[] l = new int[0];

    /* renamed from: a  reason: collision with root package name */
    final StateListDrawable f2310a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable f2311b;

    /* renamed from: c  reason: collision with root package name */
    int f2312c;

    /* renamed from: d  reason: collision with root package name */
    int f2313d;

    /* renamed from: e  reason: collision with root package name */
    float f2314e;
    int f;
    int g;
    float h;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    /* renamed from: q  reason: collision with root package name */
    private final StateListDrawable f2315q;
    private final Drawable r;
    private final int s;
    private final int t;
    private RecyclerView w;
    private int u = 0;
    private int v = 0;
    private boolean x = false;
    private boolean y = false;
    private int z = 0;
    private int A = 0;
    private final int[] B = new int[2];
    private final int[] C = new int[2];
    final ValueAnimator i = ValueAnimator.ofFloat(0.0f, 1.0f);
    int j = 0;
    private final Runnable D = new Runnable() { // from class: androidx.recyclerview.widget.j.1
        @Override // java.lang.Runnable
        public void run() {
            j.this.b(500);
        }
    };
    private final RecyclerView.n E = new RecyclerView.n() { // from class: androidx.recyclerview.widget.j.2
        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            j.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f2310a = stateListDrawable;
        this.f2311b = drawable;
        this.f2315q = stateListDrawable2;
        this.r = drawable2;
        this.o = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.p = Math.max(i, drawable.getIntrinsicWidth());
        this.s = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.t = Math.max(i, drawable2.getIntrinsicWidth());
        this.m = i2;
        this.n = i3;
        this.f2310a.setAlpha(255);
        this.f2311b.setAlpha(255);
        this.i.addListener(new a());
        this.i.addUpdateListener(new b());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.w;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            d();
        }
        this.w = recyclerView;
        if (recyclerView != null) {
            c();
        }
    }

    private void c() {
        this.w.addItemDecoration(this);
        this.w.addOnItemTouchListener(this);
        this.w.addOnScrollListener(this.E);
    }

    private void d() {
        this.w.removeItemDecoration(this);
        this.w.removeOnItemTouchListener(this);
        this.w.removeOnScrollListener(this.E);
        f();
    }

    void a() {
        this.w.invalidate();
    }

    void a(int i) {
        if (i == 2 && this.z != 2) {
            this.f2310a.setState(k);
            f();
        }
        if (i == 0) {
            a();
        } else {
            b();
        }
        if (this.z == 2 && i != 2) {
            this.f2310a.setState(l);
            c(1200);
        } else if (i == 1) {
            c(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.z = i;
    }

    private boolean e() {
        return androidx.core.h.w.g(this.w) == 1;
    }

    public void b() {
        int i = this.j;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.i.cancel();
        }
        this.j = 1;
        ValueAnimator valueAnimator = this.i;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.i.setDuration(500L);
        this.i.setStartDelay(0L);
        this.i.start();
    }

    void b(int i) {
        int i2 = this.j;
        if (i2 == 1) {
            this.i.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.j = 3;
        ValueAnimator valueAnimator = this.i;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.i.setDuration(i);
        this.i.start();
    }

    private void f() {
        this.w.removeCallbacks(this.D);
    }

    private void c(int i) {
        f();
        this.w.postDelayed(this.D, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.u uVar) {
        if (this.u != this.w.getWidth() || this.v != this.w.getHeight()) {
            this.u = this.w.getWidth();
            this.v = this.w.getHeight();
            a(0);
        } else if (this.j != 0) {
            if (this.x) {
                a(canvas);
            }
            if (this.y) {
                b(canvas);
            }
        }
    }

    private void a(Canvas canvas) {
        int i = this.u;
        int i2 = this.o;
        int i3 = i - i2;
        int i4 = this.f2313d;
        int i5 = this.f2312c;
        int i6 = i4 - (i5 / 2);
        this.f2310a.setBounds(0, 0, i2, i5);
        this.f2311b.setBounds(0, 0, this.p, this.v);
        if (e()) {
            this.f2311b.draw(canvas);
            canvas.translate(this.o, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f2310a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.o, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.f2311b.draw(canvas);
        canvas.translate(0.0f, i6);
        this.f2310a.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    private void b(Canvas canvas) {
        int i = this.v;
        int i2 = this.s;
        int i3 = i - i2;
        int i4 = this.g;
        int i5 = this.f;
        int i6 = i4 - (i5 / 2);
        this.f2315q.setBounds(0, 0, i5, i2);
        this.r.setBounds(0, 0, this.u, this.t);
        canvas.translate(0.0f, i3);
        this.r.draw(canvas);
        canvas.translate(i6, 0.0f);
        this.f2315q.draw(canvas);
        canvas.translate(-i6, -i3);
    }

    void a(int i, int i2) {
        int computeVerticalScrollRange = this.w.computeVerticalScrollRange();
        int i3 = this.v;
        this.x = computeVerticalScrollRange - i3 > 0 && i3 >= this.m;
        int computeHorizontalScrollRange = this.w.computeHorizontalScrollRange();
        int i4 = this.u;
        boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= this.m;
        this.y = z;
        if (!this.x && !z) {
            if (this.z != 0) {
                a(0);
                return;
            }
            return;
        }
        if (this.x) {
            float f = i3;
            this.f2313d = (int) ((f * (i2 + (f / 2.0f))) / computeVerticalScrollRange);
            this.f2312c = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.y) {
            float f2 = i4;
            this.g = (int) ((f2 * (i + (f2 / 2.0f))) / computeHorizontalScrollRange);
            this.f = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        int i5 = this.z;
        if (i5 == 0 || i5 == 1) {
            a(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.z;
        if (i == 1) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a2 && !b2) {
                return false;
            }
            if (b2) {
                this.A = 1;
                this.h = (int) motionEvent.getX();
            } else if (a2) {
                this.A = 2;
                this.f2314e = (int) motionEvent.getY();
            }
            a(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.z == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (a2 || b2) {
                if (b2) {
                    this.A = 1;
                    this.h = (int) motionEvent.getX();
                } else if (a2) {
                    this.A = 2;
                    this.f2314e = (int) motionEvent.getY();
                }
                a(2);
            }
        } else if (motionEvent.getAction() == 1 && this.z == 2) {
            this.f2314e = 0.0f;
            this.h = 0.0f;
            a(1);
            this.A = 0;
        } else if (motionEvent.getAction() == 2 && this.z == 2) {
            b();
            if (this.A == 1) {
                b(motionEvent.getX());
            }
            if (this.A == 2) {
                a(motionEvent.getY());
            }
        }
    }

    private void a(float f) {
        int[] g = g();
        float max = Math.max(g[0], Math.min(g[1], f));
        if (Math.abs(this.f2313d - max) < 2.0f) {
            return;
        }
        int a2 = a(this.f2314e, max, g, this.w.computeVerticalScrollRange(), this.w.computeVerticalScrollOffset(), this.v);
        if (a2 != 0) {
            this.w.scrollBy(0, a2);
        }
        this.f2314e = max;
    }

    private void b(float f) {
        int[] h = h();
        float max = Math.max(h[0], Math.min(h[1], f));
        if (Math.abs(this.g - max) < 2.0f) {
            return;
        }
        int a2 = a(this.h, max, h, this.w.computeHorizontalScrollRange(), this.w.computeHorizontalScrollOffset(), this.u);
        if (a2 != 0) {
            this.w.scrollBy(a2, 0);
        }
        this.h = max;
    }

    private int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    boolean a(float f, float f2) {
        if (!e() ? f >= this.u - this.o : f <= this.o / 2) {
            int i = this.f2313d;
            int i2 = this.f2312c;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean b(float f, float f2) {
        if (f2 >= this.v - this.s) {
            int i = this.g;
            int i2 = this.f;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    private int[] g() {
        int[] iArr = this.B;
        int i = this.n;
        iArr[0] = i;
        iArr[1] = this.v - i;
        return iArr;
    }

    private int[] h() {
        int[] iArr = this.C;
        int i = this.n;
        iArr[0] = i;
        iArr[1] = this.u - i;
        return iArr;
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    private class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f2319b = false;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2319b) {
                this.f2319b = false;
            } else if (((Float) j.this.i.getAnimatedValue()).floatValue() == 0.0f) {
                j.this.j = 0;
                j.this.a(0);
            } else {
                j.this.j = 2;
                j.this.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2319b = true;
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    private class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            j.this.f2310a.setAlpha(floatValue);
            j.this.f2311b.setAlpha(floatValue);
            j.this.a();
        }
    }
}
