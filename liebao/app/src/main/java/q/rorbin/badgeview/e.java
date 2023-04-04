package q.rorbin.badgeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import q.rorbin.badgeview.a;

/* compiled from: QBadgeView.java */
/* loaded from: classes2.dex */
public class e extends View implements q.rorbin.badgeview.a {
    protected PointF A;
    protected PointF B;
    protected PointF C;
    protected PointF D;
    protected List<PointF> E;
    protected View F;
    protected int G;
    protected int H;
    protected TextPaint I;
    protected Paint J;
    protected Paint K;
    protected b L;
    protected a.InterfaceC0191a M;
    protected ViewGroup N;

    /* renamed from: a  reason: collision with root package name */
    protected int f7854a;

    /* renamed from: b  reason: collision with root package name */
    protected int f7855b;

    /* renamed from: c  reason: collision with root package name */
    protected int f7856c;

    /* renamed from: d  reason: collision with root package name */
    protected Drawable f7857d;

    /* renamed from: e  reason: collision with root package name */
    protected Bitmap f7858e;
    protected boolean f;
    protected float g;
    protected float h;
    protected float i;
    protected int j;
    protected String k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected boolean o;
    protected int p;

    /* renamed from: q  reason: collision with root package name */
    protected float f7859q;
    protected float r;
    protected float s;
    protected float t;
    protected int u;
    protected boolean v;
    protected RectF w;
    protected RectF x;
    protected Path y;
    protected Paint.FontMetrics z;

    public e(Context context) {
        this(context, null);
    }

    private e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        setLayerType(1, null);
        this.w = new RectF();
        this.x = new RectF();
        this.y = new Path();
        this.A = new PointF();
        this.B = new PointF();
        this.C = new PointF();
        this.D = new PointF();
        this.E = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.I = textPaint;
        textPaint.setAntiAlias(true);
        this.I.setSubpixelText(true);
        this.I.setFakeBoldText(true);
        this.I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.J = paint;
        paint.setAntiAlias(true);
        this.J.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.K = paint2;
        paint2.setAntiAlias(true);
        this.K.setStyle(Paint.Style.STROKE);
        this.f7854a = -1552832;
        this.f7856c = -1;
        this.h = c.a(getContext(), 11.0f);
        this.i = c.a(getContext(), 5.0f);
        this.j = 0;
        this.p = 8388661;
        this.f7859q = c.a(getContext(), 1.0f);
        this.r = c.a(getContext(), 1.0f);
        this.t = c.a(getContext(), 90.0f);
        this.o = true;
        this.f = false;
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1000.0f);
        }
    }

    public q.rorbin.badgeview.a a(View view) {
        if (view == null) {
            throw new IllegalStateException("targetView can not be null");
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            this.F = view;
            if (parent instanceof a) {
                ((a) parent).addView(this);
            } else {
                ViewGroup viewGroup = (ViewGroup) parent;
                int indexOfChild = viewGroup.indexOfChild(view);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                viewGroup.removeView(view);
                a aVar = new a(getContext());
                if (viewGroup instanceof RelativeLayout) {
                    aVar.setId(view.getId());
                }
                viewGroup.addView(aVar, indexOfChild, layoutParams);
                aVar.addView(view);
                aVar.addView(this);
            }
            return this;
        }
        throw new IllegalStateException("targetView must have a parent");
    }

    public View getTargetView() {
        return this.F;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.N == null) {
            b(this.F);
        }
    }

    private void b(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        this.N = viewGroup;
        if (viewGroup == null) {
            c(view);
        }
    }

    private void c(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            c((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.N = (ViewGroup) view;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0014, code lost:
        if (r0 != 6) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                        }
                    }
                } else if (this.m) {
                    this.B.x = motionEvent.getRawX();
                    this.B.y = motionEvent.getRawY();
                    invalidate();
                }
                return !this.m || super.onTouchEvent(motionEvent);
            }
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 0 && this.m) {
                this.m = false;
                d();
            }
            if (this.m) {
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.l && motionEvent.getPointerId(motionEvent.getActionIndex()) == 0 && x > this.x.left && x < this.x.right && y > this.x.top && y < this.x.bottom && this.k != null) {
            i();
            this.m = true;
            c(1);
            this.s = c.a(getContext(), 7.0f);
            getParent().requestDisallowInterceptTouchEvent(true);
            a(true);
            this.B.x = motionEvent.getRawX();
            this.B.y = motionEvent.getRawY();
        }
        if (this.m) {
        }
    }

    private void d() {
        if (this.v) {
            a(this.B);
            c(5);
            return;
        }
        b();
        c(4);
    }

    protected Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.x.width()) + c.a(getContext(), 3.0f), ((int) this.x.height()) + c.a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        a(canvas, new PointF(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f), getBadgeCircleRadius());
        return createBitmap;
    }

    protected void a(boolean z) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z) {
            this.N.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            a(this.F);
        }
    }

    private void b(boolean z) {
        int a2 = c.a(getContext(), 1.0f);
        int a3 = c.a(getContext(), 1.5f);
        int i = this.u;
        if (i == 1) {
            a2 = c.a(getContext(), 1.0f);
            a3 = c.a(getContext(), -1.5f);
        } else if (i == 2) {
            a2 = c.a(getContext(), -1.0f);
            a3 = c.a(getContext(), -1.5f);
        } else if (i == 3) {
            a2 = c.a(getContext(), -1.0f);
            a3 = c.a(getContext(), 1.5f);
        } else if (i == 4) {
            a2 = c.a(getContext(), 1.0f);
            a3 = c.a(getContext(), 1.5f);
        }
        this.J.setShadowLayer(z ? c.a(getContext(), 2.0f) : 0.0f, a2, a3, 855638016);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.G = i;
        this.H = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b bVar = this.L;
        if (bVar != null && bVar.isRunning()) {
            this.L.a(canvas);
        } else if (this.k != null) {
            e();
            float badgeCircleRadius = getBadgeCircleRadius();
            float b2 = this.s * (1.0f - (d.b(this.C, this.B) / this.t));
            if (this.l && this.m) {
                this.u = d.a(this.B, this.C);
                b(this.o);
                boolean z = b2 < ((float) c.a(getContext(), 1.5f));
                this.v = z;
                if (z) {
                    c(3);
                    a(canvas, this.B, badgeCircleRadius);
                    return;
                }
                c(2);
                a(canvas, b2, badgeCircleRadius);
                a(canvas, this.B, badgeCircleRadius);
                return;
            }
            g();
            a(canvas, this.A, badgeCircleRadius);
        }
    }

    private void e() {
        b(this.o);
        this.J.setColor(this.f7854a);
        this.K.setColor(this.f7855b);
        this.K.setStrokeWidth(this.g);
        this.I.setColor(this.f7856c);
        this.I.setTextAlign(Paint.Align.CENTER);
    }

    private void a(Canvas canvas, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6 = this.B.y - this.C.y;
        float f7 = this.B.x - this.C.x;
        this.E.clear();
        if (f7 != 0.0f) {
            double d2 = f6 / f7;
            Double.isNaN(d2);
            double d3 = (-1.0d) / d2;
            d.a(this.B, f2, Double.valueOf(d3), this.E);
            d.a(this.C, f, Double.valueOf(d3), this.E);
        } else {
            d.a(this.B, f2, Double.valueOf(0.0d), this.E);
            d.a(this.C, f, Double.valueOf(0.0d), this.E);
        }
        this.y.reset();
        Path path = this.y;
        float f8 = this.C.x;
        float f9 = this.C.y;
        int i = this.u;
        path.addCircle(f8, f9, f, (i == 1 || i == 2) ? Path.Direction.CCW : Path.Direction.CW);
        this.D.x = (this.C.x + this.B.x) / 2.0f;
        this.D.y = (this.C.y + this.B.y) / 2.0f;
        this.y.moveTo(this.E.get(2).x, this.E.get(2).y);
        this.y.quadTo(this.D.x, this.D.y, this.E.get(0).x, this.E.get(0).y);
        this.y.lineTo(this.E.get(1).x, this.E.get(1).y);
        this.y.quadTo(this.D.x, this.D.y, this.E.get(3).x, this.E.get(3).y);
        this.y.lineTo(this.E.get(2).x, this.E.get(2).y);
        this.y.close();
        canvas.drawPath(this.y, this.J);
        if (this.f7855b == 0 || this.g <= 0.0f) {
            return;
        }
        this.y.reset();
        this.y.moveTo(this.E.get(2).x, this.E.get(2).y);
        this.y.quadTo(this.D.x, this.D.y, this.E.get(0).x, this.E.get(0).y);
        this.y.moveTo(this.E.get(1).x, this.E.get(1).y);
        this.y.quadTo(this.D.x, this.D.y, this.E.get(3).x, this.E.get(3).y);
        int i2 = this.u;
        if (i2 == 1 || i2 == 2) {
            f3 = this.E.get(2).x - this.C.x;
            f4 = this.C.y;
            f5 = this.E.get(2).y;
        } else {
            f3 = this.E.get(3).x - this.C.x;
            f4 = this.C.y;
            f5 = this.E.get(3).y;
        }
        double atan = Math.atan((f4 - f5) / f3);
        int i3 = this.u;
        float a2 = 360.0f - ((float) d.a(d.a(atan, i3 + (-1) == 0 ? 4 : i3 - 1)));
        if (Build.VERSION.SDK_INT >= 21) {
            this.y.addArc(this.C.x - f, this.C.y - f, this.C.x + f, this.C.y + f, a2, 180.0f);
        } else {
            this.y.addArc(new RectF(this.C.x - f, this.C.y - f, this.C.x + f, this.C.y + f), a2, 180.0f);
        }
        canvas.drawPath(this.y, this.K);
    }

    private void a(Canvas canvas, PointF pointF, float f) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.k.isEmpty() || this.k.length() == 1) {
            float f2 = (int) f;
            this.x.left = pointF.x - f2;
            this.x.top = pointF.y - f2;
            this.x.right = pointF.x + f2;
            this.x.bottom = pointF.y + f2;
            if (this.f7857d != null) {
                a(canvas);
            } else {
                canvas.drawCircle(pointF.x, pointF.y, f, this.J);
                if (this.f7855b != 0 && this.g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f, this.K);
                }
            }
        } else {
            this.x.left = pointF.x - ((this.w.width() / 2.0f) + this.i);
            this.x.top = pointF.y - ((this.w.height() / 2.0f) + (this.i * 0.5f));
            this.x.right = pointF.x + (this.w.width() / 2.0f) + this.i;
            this.x.bottom = pointF.y + (this.w.height() / 2.0f) + (this.i * 0.5f);
            float height = this.x.height() / 2.0f;
            if (this.f7857d != null) {
                a(canvas);
            } else {
                canvas.drawRoundRect(this.x, height, height, this.J);
                if (this.f7855b != 0 && this.g > 0.0f) {
                    canvas.drawRoundRect(this.x, height, height, this.K);
                }
            }
        }
        if (this.k.isEmpty()) {
            return;
        }
        canvas.drawText(this.k, pointF.x, (((this.x.bottom + this.x.top) - this.z.bottom) - this.z.top) / 2.0f, this.I);
    }

    private void a(Canvas canvas) {
        this.J.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        int i = (int) this.x.left;
        int i2 = (int) this.x.top;
        int i3 = (int) this.x.right;
        int i4 = (int) this.x.bottom;
        if (this.f) {
            i3 = this.f7858e.getWidth() + i;
            i4 = this.f7858e.getHeight() + i2;
            canvas.saveLayer(i, i2, i3, i4, null, 31);
        }
        this.f7857d.setBounds(i, i2, i3, i4);
        this.f7857d.draw(canvas);
        if (this.f) {
            this.J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(this.f7858e, i, i2, this.J);
            canvas.restore();
            this.J.setXfermode(null);
            if (this.k.isEmpty() || this.k.length() == 1) {
                canvas.drawCircle(this.x.centerX(), this.x.centerY(), this.x.width() / 2.0f, this.K);
                return;
            }
            RectF rectF = this.x;
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.x.height() / 2.0f, this.K);
            return;
        }
        canvas.drawRect(this.x, this.K);
    }

    private void f() {
        if (this.k != null && this.f) {
            Bitmap bitmap = this.f7858e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f7858e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (this.k.isEmpty() || this.k.length() == 1) {
                int i = ((int) badgeCircleRadius) * 2;
                this.f7858e = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(this.f7858e);
                canvas.drawCircle(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, canvas.getWidth() / 2.0f, this.J);
                return;
            }
            this.f7858e = Bitmap.createBitmap((int) (this.w.width() + (this.i * 2.0f)), (int) (this.w.height() + this.i), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.f7858e);
            if (Build.VERSION.SDK_INT >= 21) {
                canvas2.drawRoundRect(0.0f, 0.0f, canvas2.getWidth(), canvas2.getHeight(), canvas2.getHeight() / 2.0f, canvas2.getHeight() / 2.0f, this.J);
            } else {
                canvas2.drawRoundRect(new RectF(0.0f, 0.0f, canvas2.getWidth(), canvas2.getHeight()), canvas2.getHeight() / 2.0f, canvas2.getHeight() / 2.0f, this.J);
            }
        }
    }

    private float getBadgeCircleRadius() {
        float width;
        float f;
        if (this.k.isEmpty()) {
            return this.i;
        }
        if (this.k.length() == 1) {
            if (this.w.height() > this.w.width()) {
                width = this.w.height() / 2.0f;
                f = this.i;
            } else {
                width = this.w.width() / 2.0f;
                f = this.i;
            }
            return width + (f * 0.5f);
        }
        return this.x.height() / 2.0f;
    }

    private void g() {
        float height = this.w.height() > this.w.width() ? this.w.height() : this.w.width();
        switch (this.p) {
            case 17:
                this.A.x = this.G / 2.0f;
                this.A.y = this.H / 2.0f;
                break;
            case 49:
                this.A.x = this.G / 2.0f;
                this.A.y = this.r + this.i + (this.w.height() / 2.0f);
                break;
            case 81:
                this.A.x = this.G / 2.0f;
                this.A.y = this.H - ((this.r + this.i) + (this.w.height() / 2.0f));
                break;
            case 8388627:
                this.A.x = this.f7859q + this.i + (height / 2.0f);
                this.A.y = this.H / 2.0f;
                break;
            case 8388629:
                this.A.x = this.G - ((this.f7859q + this.i) + (height / 2.0f));
                this.A.y = this.H / 2.0f;
                break;
            case 8388659:
                this.A.x = this.f7859q + this.i + (height / 2.0f);
                this.A.y = this.r + this.i + (this.w.height() / 2.0f);
                break;
            case 8388661:
                this.A.x = this.G - ((this.f7859q + this.i) + (height / 2.0f));
                this.A.y = this.r + this.i + (this.w.height() / 2.0f);
                break;
            case 8388691:
                this.A.x = this.f7859q + this.i + (height / 2.0f);
                this.A.y = this.H - ((this.r + this.i) + (this.w.height() / 2.0f));
                break;
            case 8388693:
                this.A.x = this.G - ((this.f7859q + this.i) + (height / 2.0f));
                this.A.y = this.H - ((this.r + this.i) + (this.w.height() / 2.0f));
                break;
        }
        i();
    }

    private void h() {
        this.w.left = 0.0f;
        this.w.top = 0.0f;
        if (TextUtils.isEmpty(this.k)) {
            this.w.right = 0.0f;
            this.w.bottom = 0.0f;
        } else {
            this.I.setTextSize(this.h);
            this.w.right = this.I.measureText(this.k);
            Paint.FontMetrics fontMetrics = this.I.getFontMetrics();
            this.z = fontMetrics;
            this.w.bottom = fontMetrics.descent - this.z.ascent;
        }
        f();
    }

    private void i() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.C.x = this.A.x + iArr[0];
        this.C.y = this.A.y + iArr[1];
    }

    protected void a(PointF pointF) {
        if (this.k == null) {
            return;
        }
        b bVar = this.L;
        if (bVar == null || !bVar.isRunning()) {
            a(true);
            b bVar2 = new b(a(), pointF, this);
            this.L = bVar2;
            bVar2.start();
            a(0);
        }
    }

    public void b() {
        this.B.x = -1000.0f;
        this.B.y = -1000.0f;
        this.u = 4;
        a(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a a(int i) {
        this.j = i;
        if (i < 0) {
            this.k = "";
        } else if (i > 99) {
            this.k = this.n ? String.valueOf(i) : "99+";
        } else if (i > 0 && i <= 99) {
            this.k = String.valueOf(i);
        } else if (this.j == 0) {
            this.k = null;
        }
        h();
        invalidate();
        return this;
    }

    public int getBadgeNumber() {
        return this.j;
    }

    public String getBadgeText() {
        return this.k;
    }

    public int getBadgeBackgroundColor() {
        return this.f7854a;
    }

    public Drawable getBadgeBackground() {
        return this.f7857d;
    }

    public int getBadgeTextColor() {
        return this.f7856c;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a b(int i) {
        if (i == 8388659 || i == 8388661 || i == 8388691 || i == 8388693 || i == 17 || i == 49 || i == 81 || i == 8388627 || i == 8388629) {
            this.p = i;
            invalidate();
            return this;
        }
        throw new IllegalStateException("only support Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP , Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM , Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END");
    }

    public int getBadgeGravity() {
        return this.p;
    }

    private void c(int i) {
        a.InterfaceC0191a interfaceC0191a = this.M;
        if (interfaceC0191a != null) {
            interfaceC0191a.a(i, this, this.F);
        }
    }

    public PointF getDragCenter() {
        if (this.l && this.m) {
            return this.B;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QBadgeView.java */
    /* loaded from: classes2.dex */
    public class a extends ViewGroup {
        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            if (getParent() instanceof RelativeLayout) {
                return;
            }
            super.dispatchRestoreInstanceState(sparseArray);
        }

        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            View view = null;
            View view2 = null;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof e) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i, i2);
                return;
            }
            view.measure(i, i2);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
