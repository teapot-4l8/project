package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.h.w;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    final View f1765b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1766c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1767d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1768e;
    private Runnable g;
    private int j;
    private int k;
    private boolean o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1769q;

    /* renamed from: a  reason: collision with root package name */
    final C0041a f1764a = new C0041a();
    private final Interpolator f = new AccelerateInterpolator();
    private float[] h = {0.0f, 0.0f};
    private float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] l = {0.0f, 0.0f};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public abstract void a(int i, int i2);

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    public a(View view) {
        this.f1765b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        a(f, f);
        float f2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        b(f2, f2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public a a(float f, float f2) {
        float[] fArr = this.n;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a b(float f, float f2) {
        float[] fArr = this.m;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a c(float f, float f2) {
        float[] fArr = this.l;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.j = i;
        return this;
    }

    public a d(float f, float f2) {
        float[] fArr = this.h;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a e(float f, float f2) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a b(int i) {
        this.k = i;
        return this;
    }

    public a c(int i) {
        this.f1764a.a(i);
        return this;
    }

    public a d(int i) {
        this.f1764a.b(i);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1767d = true;
            this.o = false;
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            d();
            return this.f1769q && this.f1768e;
        }
        this.f1764a.a(a(0, motionEvent.getX(), view.getWidth(), this.f1765b.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.f1765b.getHeight()));
        if (!this.f1768e && a()) {
            c();
        }
        if (this.f1769q) {
            return false;
        }
    }

    boolean a() {
        C0041a c0041a = this.f1764a;
        int f = c0041a.f();
        int e2 = c0041a.e();
        return (f != 0 && f(f)) || (e2 != 0 && e(e2));
    }

    private void c() {
        int i;
        if (this.g == null) {
            this.g = new b();
        }
        this.f1768e = true;
        this.f1766c = true;
        if (!this.o && (i = this.k) > 0) {
            w.a(this.f1765b, this.g, i);
        } else {
            this.g.run();
        }
        this.o = true;
    }

    private void d() {
        if (this.f1766c) {
            this.f1768e = false;
        } else {
            this.f1764a.b();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float a2 = a(this.h[i], f2, this.i[i], f);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f4 = this.l[i];
        float f5 = this.m[i];
        float f6 = this.n[i];
        float f7 = f4 * f3;
        if (a2 > 0.0f) {
            return a(a2 * f7, f5, f6);
        }
        return -a((-a2) * f7, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float a2 = a(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, a2) - f(f4, a2);
        if (f5 < 0.0f) {
            interpolation = -this.f.getInterpolation(-f5);
        } else if (f5 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f.getInterpolation(f5);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.j;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f1768e && this.j == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1765b.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f1768e) {
                if (a.this.f1766c) {
                    a.this.f1766c = false;
                    a.this.f1764a.a();
                }
                C0041a c0041a = a.this.f1764a;
                if (c0041a.c() || !a.this.a()) {
                    a.this.f1768e = false;
                    return;
                }
                if (a.this.f1767d) {
                    a.this.f1767d = false;
                    a.this.b();
                }
                c0041a.d();
                a.this.a(c0041a.g(), c0041a.h());
                w.a(a.this.f1765b, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041a {

        /* renamed from: a  reason: collision with root package name */
        private int f1770a;

        /* renamed from: b  reason: collision with root package name */
        private int f1771b;

        /* renamed from: c  reason: collision with root package name */
        private float f1772c;

        /* renamed from: d  reason: collision with root package name */
        private float f1773d;
        private float j;
        private int k;

        /* renamed from: e  reason: collision with root package name */
        private long f1774e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        private float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        C0041a() {
        }

        public void a(int i) {
            this.f1770a = i;
        }

        public void b(int i) {
            this.f1771b = i;
        }

        public void a() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1774e = currentAnimationTimeMillis;
            this.i = -1L;
            this.f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.f1774e), 0, this.f1771b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        private float a(long j) {
            if (j < this.f1774e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return a.a(((float) (j - this.f1774e)) / this.f1770a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.j;
            return (1.0f - f) + (f * a.a(((float) j3) / this.k, 0.0f, 1.0f));
        }

        public void d() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a2 = a(a(currentAnimationTimeMillis));
            this.f = currentAnimationTimeMillis;
            float f = ((float) (currentAnimationTimeMillis - this.f)) * a2;
            this.g = (int) (this.f1772c * f);
            this.h = (int) (f * this.f1773d);
        }

        public void a(float f, float f2) {
            this.f1772c = f;
            this.f1773d = f2;
        }

        public int e() {
            float f = this.f1772c;
            return (int) (f / Math.abs(f));
        }

        public int f() {
            float f = this.f1773d;
            return (int) (f / Math.abs(f));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }
}
