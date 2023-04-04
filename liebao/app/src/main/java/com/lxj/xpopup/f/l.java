package com.lxj.xpopup.f;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public class l implements View.OnLayoutChangeListener, View.OnTouchListener {
    private static float i = 4.0f;
    private static float j = 2.5f;
    private static float k = 1.0f;
    private static int l = 200;
    private static int m = 1;
    private d C;
    private f D;
    private e E;
    private j F;
    private View.OnClickListener G;
    private View.OnLongClickListener H;
    private g I;
    private h J;
    private i K;
    private b L;
    private float O;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5491a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5492b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5493c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5495e;
    public boolean f;
    float g;
    float h;
    private ImageView u;
    private GestureDetector v;
    private com.lxj.xpopup.f.b w;
    private Interpolator n = new AccelerateDecelerateInterpolator();
    private int o = l;
    private float p = k;

    /* renamed from: q  reason: collision with root package name */
    private float f5496q = j;
    private float r = i;
    private boolean s = true;
    private boolean t = false;
    private final Matrix x = new Matrix();
    private final Matrix y = new Matrix();
    private final Matrix z = new Matrix();
    private final RectF A = new RectF();
    private final float[] B = new float[9];
    private int M = 2;
    private int N = 2;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5494d = false;
    private boolean P = true;
    private boolean Q = false;
    private ImageView.ScaleType R = ImageView.ScaleType.FIT_CENTER;
    private c S = new c() { // from class: com.lxj.xpopup.f.l.1
        @Override // com.lxj.xpopup.f.c
        public void a(float f, float f2) {
            if (l.this.w.a()) {
                return;
            }
            if (l.this.K != null) {
                l.this.K.a(f, f2);
            }
            l.this.z.postTranslate(f, f2);
            l.this.m();
            l lVar = l.this;
            lVar.f5491a = lVar.N == 0 && l.this.e() != 1.0f;
            l lVar2 = l.this;
            lVar2.f5492b = lVar2.N == 1 && l.this.e() != 1.0f;
            l lVar3 = l.this;
            lVar3.f5493c = lVar3.M == 0 && l.this.e() != 1.0f;
            l lVar4 = l.this;
            lVar4.f5494d = lVar4.M == 1 && l.this.e() != 1.0f;
            ViewParent parent = l.this.u.getParent();
            if (parent == null) {
                return;
            }
            if (!l.this.s || l.this.w.a() || l.this.t) {
                if (l.this.M == 2 && l.this.Q && l.this.f) {
                    parent.requestDisallowInterceptTouchEvent(false);
                } else {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((l.this.M != 2 || l.this.Q) && ((l.this.M != 0 || f < 0.0f || !l.this.f) && (l.this.M != 1 || f > -0.0f || !l.this.f))) {
                if ((l.this.N != 2 || !l.this.f5495e) && ((!l.this.f5491a || f2 <= 0.0f || !l.this.f5495e) && (!l.this.f5492b || f2 >= 0.0f || !l.this.f5495e))) {
                    if (l.this.Q) {
                        if ((l.this.N == 0 && f2 > 0.0f && l.this.f5495e) || (l.this.N == 1 && f2 < 0.0f && l.this.f5495e)) {
                            parent.requestDisallowInterceptTouchEvent(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(false);
            } else {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // com.lxj.xpopup.f.c
        public void a(float f, float f2, float f3, float f4) {
            l lVar = l.this;
            lVar.L = new b(lVar.u.getContext());
            b bVar = l.this.L;
            l lVar2 = l.this;
            int a2 = lVar2.a(lVar2.u);
            l lVar3 = l.this;
            bVar.a(a2, lVar3.b(lVar3.u), (int) f3, (int) f4);
            l.this.u.post(l.this.L);
        }

        @Override // com.lxj.xpopup.f.c
        public void a(float f, float f2, float f3) {
            if (l.this.e() < l.this.r || f < 1.0f) {
                if (l.this.I != null) {
                    l.this.I.a(f, f2, f3);
                }
                l.this.z.postScale(f, f, f2, f3);
                l.this.m();
            }
        }
    };

    public l(ImageView imageView) {
        this.u = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.O = 0.0f;
        this.w = new com.lxj.xpopup.f.b(imageView.getContext(), this.S);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.lxj.xpopup.f.l.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (l.this.H != null) {
                    l.this.H.onLongClick(l.this.u);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (l.this.J == null || l.this.e() > l.k || motionEvent.getPointerCount() > l.m || motionEvent2.getPointerCount() > l.m) {
                    return false;
                }
                return l.this.J.a(motionEvent, motionEvent2, f, f2);
            }
        });
        this.v = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.lxj.xpopup.f.l.3
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (l.this.G != null) {
                    l.this.G.onClick(l.this.u);
                }
                RectF a2 = l.this.a();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (l.this.F != null) {
                    l.this.F.a(l.this.u, x, y);
                }
                if (a2 != null) {
                    if (!a2.contains(x, y)) {
                        if (l.this.E != null) {
                            l.this.E.a(l.this.u);
                            return false;
                        }
                        return false;
                    }
                    float width = (x - a2.left) / a2.width();
                    float height = (y - a2.top) / a2.height();
                    if (l.this.D != null) {
                        l.this.D.a(l.this.u, width, height);
                        return true;
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                try {
                    float e2 = l.this.e();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (e2 < l.this.c()) {
                        l.this.a(l.this.c(), x, y, true);
                    } else if (e2 >= l.this.c() && e2 < l.this.d()) {
                        l.this.a(l.this.d(), x, y, true);
                    } else {
                        l.this.a(l.this.b(), x, y, true);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            }
        });
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.v.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void a(g gVar) {
        this.I = gVar;
    }

    public void a(h hVar) {
        this.J = hVar;
    }

    public RectF a() {
        n();
        return d(k());
    }

    public boolean a(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.u.getDrawable() == null) {
            return false;
        }
        this.z.set(matrix);
        m();
        return true;
    }

    public void a(float f) {
        this.z.setRotate(f % 360.0f);
        m();
    }

    public void b(float f) {
        this.z.postRotate(f % 360.0f);
        m();
    }

    public float b() {
        return this.p;
    }

    public float c() {
        return this.f5496q;
    }

    public float d() {
        return this.r;
    }

    public float e() {
        return (float) Math.sqrt(((float) Math.pow(a(this.z, 0), 2.0d)) + ((float) Math.pow(a(this.z, 3), 2.0d)));
    }

    public ImageView.ScaleType f() {
        return this.R;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        a(this.u.getDrawable());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r0 != 3) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.lxj.xpopup.f.b bVar;
        boolean z2;
        GestureDetector gestureDetector;
        RectF a2;
        boolean z3 = false;
        if (this.P && m.a((ImageView) view)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.g = motionEvent.getX();
                this.h = motionEvent.getY();
                ViewParent parent = view.getParent();
                o();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else {
                if (action != 1) {
                    if (action == 2) {
                        float abs = Math.abs(motionEvent.getX() - this.g);
                        float abs2 = Math.abs(motionEvent.getY() - this.h);
                        if (this.Q) {
                            this.f5495e = abs2 > abs;
                            this.f = abs > abs2 * 2.0f;
                        } else {
                            this.f5495e = ((double) e()) != 1.0d && abs2 > abs;
                            this.f = ((double) e()) != 1.0d && abs > abs2 * 2.0f;
                        }
                    }
                }
                this.f5491a = false;
                if (e() < this.p) {
                    RectF a3 = a();
                    if (a3 != null) {
                        view.post(new a(e(), this.p, a3.centerX(), a3.centerY()));
                        z = true;
                    }
                } else if (e() > this.r && (a2 = a()) != null) {
                    view.post(new a(e(), this.r, a2.centerX(), a2.centerY()));
                    z = true;
                }
                bVar = this.w;
                if (bVar == null) {
                    boolean a4 = bVar.a();
                    boolean b2 = this.w.b();
                    boolean a5 = this.w.a(motionEvent);
                    boolean z4 = (a4 || this.w.a()) ? false : true;
                    boolean z5 = (b2 || this.w.b()) ? false : true;
                    if (z4 && z5) {
                        z3 = true;
                    }
                    this.t = z3;
                    z2 = a5;
                } else {
                    z2 = z;
                }
                gestureDetector = this.v;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
            z = false;
            bVar = this.w;
            if (bVar == null) {
            }
            gestureDetector = this.v;
            return gestureDetector == null ? z2 : z2;
        }
        return false;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public void c(float f) {
        m.a(f, this.f5496q, this.r);
        this.p = f;
    }

    public void d(float f) {
        m.a(this.p, f, this.r);
        this.f5496q = f;
    }

    public void e(float f) {
        m.a(this.p, this.f5496q, f);
        this.r = f;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.H = onLongClickListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.G = onClickListener;
    }

    public void a(d dVar) {
        this.C = dVar;
    }

    public void a(f fVar) {
        this.D = fVar;
    }

    public void a(e eVar) {
        this.E = eVar;
    }

    public void a(j jVar) {
        this.F = jVar;
    }

    public void a(i iVar) {
        this.K = iVar;
    }

    public void f(float f) {
        a(f, false);
    }

    public void a(float f, boolean z) {
        a(f, this.u.getRight() / 2, this.u.getBottom() / 2, z);
    }

    public void a(float f, float f2, float f3, boolean z) {
        if (z) {
            this.u.post(new a(e(), f, f2, f3));
            return;
        }
        this.z.setScale(f, f, f2, f3);
        m();
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!m.a(scaleType) || scaleType == this.R) {
            return;
        }
        this.R = scaleType;
        g();
    }

    public void b(boolean z) {
        this.P = z;
        g();
    }

    public void g() {
        if (this.P) {
            a(this.u.getDrawable());
        } else {
            l();
        }
    }

    public void b(Matrix matrix) {
        matrix.set(this.z);
    }

    private Matrix k() {
        this.y.set(this.x);
        this.y.postConcat(this.z);
        return this.y;
    }

    public Matrix h() {
        return this.y;
    }

    public void a(int i2) {
        this.o = i2;
    }

    public float a(Matrix matrix, int i2) {
        matrix.getValues(this.B);
        return this.B[i2];
    }

    private void l() {
        this.z.reset();
        b(this.O);
        c(k());
        n();
    }

    private void c(Matrix matrix) {
        RectF d2;
        this.u.setImageMatrix(matrix);
        if (this.C == null || (d2 = d(matrix)) == null) {
            return;
        }
        this.C.a(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (n()) {
            c(k());
        }
    }

    private RectF d(Matrix matrix) {
        Drawable drawable = this.u.getDrawable();
        if (drawable != null) {
            this.A.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.A);
            return this.A;
        }
        return null;
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float a2 = a(this.u);
        float b2 = b(this.u);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.x.reset();
        float f = intrinsicWidth;
        float f2 = a2 / f;
        float f3 = intrinsicHeight;
        float f4 = b2 / f3;
        if (this.R == ImageView.ScaleType.CENTER) {
            this.x.postTranslate((a2 - f) / 2.0f, (b2 - f3) / 2.0f);
        } else if (this.R == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f2, f4);
            this.x.postScale(max, max);
            this.x.postTranslate((a2 - (f * max)) / 2.0f, (b2 - (f3 * max)) / 2.0f);
        } else if (this.R == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f2, f4));
            this.x.postScale(min, min);
            this.x.postTranslate((a2 - (f * min)) / 2.0f, (b2 - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, a2, b2);
            if (((int) this.O) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f3, f);
            }
            int i2 = AnonymousClass4.f5500a[this.R.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.x.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.x.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.x.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            } else if (f3 > b2 && (f3 * 1.0f) / f > (b2 * 1.0f) / a2) {
                this.Q = true;
                this.x.setRectToRect(rectF, new RectF(0.0f, 0.0f, a2, f3 * f2), Matrix.ScaleToFit.START);
            } else {
                this.x.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.f.l$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5500a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f5500a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5500a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5500a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5500a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean n() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        RectF d2 = d(k());
        if (d2 == null) {
            return false;
        }
        float height = d2.height();
        float width = d2.width();
        float b2 = b(this.u);
        float f6 = 0.0f;
        if (height <= b2 && d2.top >= 0.0f) {
            int i2 = AnonymousClass4.f5500a[this.R.ordinal()];
            if (i2 != 2) {
                if (i2 == 3) {
                    f4 = b2 - height;
                    f5 = d2.top;
                } else {
                    f4 = (b2 - height) / 2.0f;
                    f5 = d2.top;
                }
                f = f4 - f5;
            } else {
                f = -d2.top;
            }
            this.N = 2;
        } else if (d2.top >= 0.0f) {
            this.N = 0;
            f = -d2.top;
        } else if (d2.bottom <= b2) {
            this.N = 1;
            f = b2 - d2.bottom;
        } else {
            this.N = -1;
            f = 0.0f;
        }
        float a2 = a(this.u);
        if (width <= a2 && d2.left >= 0.0f) {
            int i3 = AnonymousClass4.f5500a[this.R.ordinal()];
            if (i3 != 2) {
                if (i3 == 3) {
                    f2 = a2 - width;
                    f3 = d2.left;
                } else {
                    f2 = (a2 - width) / 2.0f;
                    f3 = d2.left;
                }
                f6 = f2 - f3;
            } else {
                f6 = -d2.left;
            }
            this.M = 2;
        } else if (d2.left >= 0.0f) {
            this.M = 0;
            f6 = -d2.left;
        } else if (d2.right <= a2) {
            f6 = a2 - d2.right;
            this.M = 1;
        } else {
            this.M = -1;
        }
        this.z.postTranslate(f6, f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private void o() {
        b bVar = this.L;
        if (bVar != null) {
            bVar.a();
            this.L = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final float f5502b;

        /* renamed from: c  reason: collision with root package name */
        private final float f5503c;

        /* renamed from: d  reason: collision with root package name */
        private final long f5504d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        private final float f5505e;
        private final float f;

        public a(float f, float f2, float f3, float f4) {
            this.f5502b = f3;
            this.f5503c = f4;
            this.f5505e = f;
            this.f = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float a2 = a();
            float f = this.f5505e;
            l.this.S.a((f + ((this.f - f) * a2)) / l.this.e(), this.f5502b, this.f5503c);
            if (a2 < 1.0f) {
                com.lxj.xpopup.f.a.a(l.this.u, this);
            }
        }

        private float a() {
            return l.this.n.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f5504d)) * 1.0f) / l.this.o));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final OverScroller f5507b;

        /* renamed from: c  reason: collision with root package name */
        private int f5508c;

        /* renamed from: d  reason: collision with root package name */
        private int f5509d;

        public b(Context context) {
            this.f5507b = new OverScroller(context);
        }

        public void a() {
            this.f5507b.forceFinished(true);
        }

        public void a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF a2 = l.this.a();
            if (a2 == null) {
                return;
            }
            int round = Math.round(-a2.left);
            float f = i;
            if (f < a2.width()) {
                i6 = Math.round(a2.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-a2.top);
            float f2 = i2;
            if (f2 < a2.height()) {
                i8 = Math.round(a2.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.f5508c = round;
            this.f5509d = round2;
            if (round == i6 && round2 == i8) {
                return;
            }
            this.f5507b.fling(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f5507b.isFinished() && this.f5507b.computeScrollOffset()) {
                int currX = this.f5507b.getCurrX();
                int currY = this.f5507b.getCurrY();
                l.this.z.postTranslate(this.f5508c - currX, this.f5509d - currY);
                l.this.m();
                this.f5508c = currX;
                this.f5509d = currY;
                com.lxj.xpopup.f.a.a(l.this.u, this);
            }
        }
    }
}
