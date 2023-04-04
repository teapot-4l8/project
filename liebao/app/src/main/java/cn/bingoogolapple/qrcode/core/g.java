package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: ScanBoxView.java */
/* loaded from: classes.dex */
public class g extends View {
    private int A;
    private boolean B;
    private String C;
    private String D;
    private String E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private boolean N;
    private Drawable O;
    private Bitmap P;
    private float Q;
    private float R;
    private Bitmap S;
    private Bitmap T;
    private Bitmap U;
    private Bitmap V;
    private float W;

    /* renamed from: a  reason: collision with root package name */
    private int f3627a;
    private StaticLayout aa;
    private int ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private f af;

    /* renamed from: b  reason: collision with root package name */
    private int f3628b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f3629c;

    /* renamed from: d  reason: collision with root package name */
    private float f3630d;

    /* renamed from: e  reason: collision with root package name */
    private float f3631e;
    private Paint f;
    private TextPaint g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private int f3632q;
    private int r;
    private boolean s;
    private Drawable t;
    private Bitmap u;
    private int v;
    private int w;
    private int x;
    private float y;
    private int z;

    public g(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.h = Color.parseColor("#33FFFFFF");
        this.i = -1;
        this.j = a.a(context, 20.0f);
        this.k = a.a(context, 3.0f);
        this.p = a.a(context, 1.0f);
        this.f3632q = -1;
        this.o = a.a(context, 90.0f);
        this.l = a.a(context, 200.0f);
        this.n = a.a(context, 140.0f);
        this.r = 0;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = a.a(context, 1.0f);
        this.w = -1;
        this.x = 1000;
        this.y = -1.0f;
        this.z = 1;
        this.A = 0;
        this.B = false;
        this.f3627a = a.a(context, 2.0f);
        this.E = null;
        this.F = a.b(context, 14.0f);
        this.G = -1;
        this.H = false;
        this.I = a.a(context, 20.0f);
        this.J = false;
        this.K = Color.parseColor("#22000000");
        this.L = false;
        this.M = false;
        this.N = false;
        TextPaint textPaint = new TextPaint();
        this.g = textPaint;
        textPaint.setAntiAlias(true);
        this.ab = a.a(context, 4.0f);
        this.ac = false;
        this.ad = false;
        this.ae = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar, AttributeSet attributeSet) {
        this.af = fVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        d();
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.o = typedArray.getDimensionPixelSize(i, this.o);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.k = typedArray.getDimensionPixelSize(i, this.k);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.j = typedArray.getDimensionPixelSize(i, this.j);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.p = typedArray.getDimensionPixelSize(i, this.p);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.l = typedArray.getDimensionPixelSize(i, this.l);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.h = typedArray.getColor(i, this.h);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerColor) {
            this.i = typedArray.getColor(i, this.i);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.f3632q = typedArray.getColor(i, this.f3632q);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.r = typedArray.getDimensionPixelSize(i, this.r);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.s = typedArray.getBoolean(i, this.s);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.t = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.v = typedArray.getDimensionPixelSize(i, this.v);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.w = typedArray.getColor(i, this.w);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.x = typedArray.getInteger(i, this.x);
        } else if (i == R.styleable.QRCodeView_qrcv_verticalBias) {
            this.y = typedArray.getFloat(i, this.y);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerDisplayType) {
            this.z = typedArray.getInteger(i, this.z);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.A = typedArray.getDimensionPixelSize(i, this.A);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.n = typedArray.getDimensionPixelSize(i, this.n);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.B = typedArray.getBoolean(i, this.B);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.D = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.C = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.F = typedArray.getDimensionPixelSize(i, this.F);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.G = typedArray.getColor(i, this.G);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.H = typedArray.getBoolean(i, this.H);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.I = typedArray.getDimensionPixelSize(i, this.I);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.J = typedArray.getBoolean(i, this.J);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.L = typedArray.getBoolean(i, this.L);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.K = typedArray.getColor(i, this.K);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.M = typedArray.getBoolean(i, this.M);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.N = typedArray.getBoolean(i, this.N);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.O = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.ac = typedArray.getBoolean(i, this.ac);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowLocationPoint) {
            this.ad = typedArray.getBoolean(i, this.ad);
        } else if (i == R.styleable.QRCodeView_qrcv_isAutoZoom) {
            this.ae = typedArray.getBoolean(i, this.ae);
        }
    }

    private void d() {
        Drawable drawable = this.O;
        if (drawable != null) {
            this.U = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.U == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_grid_scan_line);
            this.U = decodeResource;
            this.U = a.b(decodeResource, this.f3632q);
        }
        Bitmap a2 = a.a(this.U, 90);
        this.V = a2;
        Bitmap a3 = a.a(a2, 90);
        this.V = a3;
        this.V = a.a(a3, 90);
        Drawable drawable2 = this.t;
        if (drawable2 != null) {
            this.S = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (this.S == null) {
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_scan_line);
            this.S = decodeResource2;
            this.S = a.b(decodeResource2, this.f3632q);
        }
        this.T = a.a(this.S, 90);
        this.o += this.A;
        this.W = (this.k * 1.0f) / 2.0f;
        this.g.setTextSize(this.F);
        this.g.setColor(this.G);
        setIsBarcode(this.B);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f3629c == null) {
            return;
        }
        a(canvas);
        b(canvas);
        c(canvas);
        d(canvas);
        e(canvas);
        e();
    }

    private void a(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.h != 0) {
            this.f.setStyle(Paint.Style.FILL);
            this.f.setColor(this.h);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, this.f3629c.top, this.f);
            canvas.drawRect(0.0f, this.f3629c.top, this.f3629c.left, this.f3629c.bottom + 1, this.f);
            canvas.drawRect(this.f3629c.right + 1, this.f3629c.top, f, this.f3629c.bottom + 1, this.f);
            canvas.drawRect(0.0f, this.f3629c.bottom + 1, f, height, this.f);
        }
    }

    private void b(Canvas canvas) {
        if (this.v > 0) {
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setColor(this.w);
            this.f.setStrokeWidth(this.v);
            canvas.drawRect(this.f3629c, this.f);
        }
    }

    private void c(Canvas canvas) {
        if (this.W > 0.0f) {
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setColor(this.i);
            this.f.setStrokeWidth(this.k);
            int i = this.z;
            if (i == 1) {
                canvas.drawLine(this.f3629c.left - this.W, this.f3629c.top, (this.f3629c.left - this.W) + this.j, this.f3629c.top, this.f);
                canvas.drawLine(this.f3629c.left, this.f3629c.top - this.W, this.f3629c.left, (this.f3629c.top - this.W) + this.j, this.f);
                canvas.drawLine(this.f3629c.right + this.W, this.f3629c.top, (this.f3629c.right + this.W) - this.j, this.f3629c.top, this.f);
                canvas.drawLine(this.f3629c.right, this.f3629c.top - this.W, this.f3629c.right, (this.f3629c.top - this.W) + this.j, this.f);
                canvas.drawLine(this.f3629c.left - this.W, this.f3629c.bottom, (this.f3629c.left - this.W) + this.j, this.f3629c.bottom, this.f);
                canvas.drawLine(this.f3629c.left, this.f3629c.bottom + this.W, this.f3629c.left, (this.f3629c.bottom + this.W) - this.j, this.f);
                canvas.drawLine(this.f3629c.right + this.W, this.f3629c.bottom, (this.f3629c.right + this.W) - this.j, this.f3629c.bottom, this.f);
                canvas.drawLine(this.f3629c.right, this.f3629c.bottom + this.W, this.f3629c.right, (this.f3629c.bottom + this.W) - this.j, this.f);
            } else if (i == 2) {
                canvas.drawLine(this.f3629c.left, this.f3629c.top + this.W, this.f3629c.left + this.j, this.f3629c.top + this.W, this.f);
                canvas.drawLine(this.f3629c.left + this.W, this.f3629c.top, this.f3629c.left + this.W, this.f3629c.top + this.j, this.f);
                canvas.drawLine(this.f3629c.right, this.f3629c.top + this.W, this.f3629c.right - this.j, this.f3629c.top + this.W, this.f);
                canvas.drawLine(this.f3629c.right - this.W, this.f3629c.top, this.f3629c.right - this.W, this.f3629c.top + this.j, this.f);
                canvas.drawLine(this.f3629c.left, this.f3629c.bottom - this.W, this.f3629c.left + this.j, this.f3629c.bottom - this.W, this.f);
                canvas.drawLine(this.f3629c.left + this.W, this.f3629c.bottom, this.f3629c.left + this.W, this.f3629c.bottom - this.j, this.f);
                canvas.drawLine(this.f3629c.right, this.f3629c.bottom - this.W, this.f3629c.right - this.j, this.f3629c.bottom - this.W, this.f);
                canvas.drawLine(this.f3629c.right - this.W, this.f3629c.bottom, this.f3629c.right - this.W, this.f3629c.bottom - this.j, this.f);
            }
        }
    }

    private void d(Canvas canvas) {
        if (this.B) {
            if (this.P != null) {
                RectF rectF = new RectF(this.f3629c.left + this.W + 0.5f, this.f3629c.top + this.W + this.r, this.R, (this.f3629c.bottom - this.W) - this.r);
                Rect rect = new Rect((int) (this.P.getWidth() - rectF.width()), 0, this.P.getWidth(), this.P.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.P, rect, rectF, this.f);
            } else if (this.u != null) {
                canvas.drawBitmap(this.u, (Rect) null, new RectF(this.f3631e, this.f3629c.top + this.W + this.r, this.f3631e + this.u.getWidth(), (this.f3629c.bottom - this.W) - this.r), this.f);
            } else {
                this.f.setStyle(Paint.Style.FILL);
                this.f.setColor(this.f3632q);
                canvas.drawRect(this.f3631e, this.f3629c.top + this.W + this.r, this.f3631e + this.p, (this.f3629c.bottom - this.W) - this.r, this.f);
            }
        } else if (this.P != null) {
            RectF rectF2 = new RectF(this.f3629c.left + this.W + this.r, this.f3629c.top + this.W + 0.5f, (this.f3629c.right - this.W) - this.r, this.Q);
            Rect rect2 = new Rect(0, (int) (this.P.getHeight() - rectF2.height()), this.P.getWidth(), this.P.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            canvas.drawBitmap(this.P, rect2, rectF2, this.f);
        } else if (this.u != null) {
            canvas.drawBitmap(this.u, (Rect) null, new RectF(this.f3629c.left + this.W + this.r, this.f3630d, (this.f3629c.right - this.W) - this.r, this.f3630d + this.u.getHeight()), this.f);
        } else {
            this.f.setStyle(Paint.Style.FILL);
            this.f.setColor(this.f3632q);
            canvas.drawRect(this.f3629c.left + this.W + this.r, this.f3630d, (this.f3629c.right - this.W) - this.r, this.f3630d + this.p, this.f);
        }
    }

    private void e(Canvas canvas) {
        if (TextUtils.isEmpty(this.E) || this.aa == null) {
            return;
        }
        if (this.H) {
            if (this.L) {
                this.f.setColor(this.K);
                this.f.setStyle(Paint.Style.FILL);
                if (this.J) {
                    Rect rect = new Rect();
                    TextPaint textPaint = this.g;
                    String str = this.E;
                    textPaint.getTextBounds(str, 0, str.length(), rect);
                    float width = ((canvas.getWidth() - rect.width()) / 2) - this.ab;
                    RectF rectF = new RectF(width, (this.f3629c.bottom + this.I) - this.ab, rect.width() + width + (this.ab * 2), this.f3629c.bottom + this.I + this.aa.getHeight() + this.ab);
                    int i = this.ab;
                    canvas.drawRoundRect(rectF, i, i, this.f);
                } else {
                    RectF rectF2 = new RectF(this.f3629c.left, (this.f3629c.bottom + this.I) - this.ab, this.f3629c.right, this.f3629c.bottom + this.I + this.aa.getHeight() + this.ab);
                    int i2 = this.ab;
                    canvas.drawRoundRect(rectF2, i2, i2, this.f);
                }
            }
            canvas.save();
            if (this.J) {
                canvas.translate(0.0f, this.f3629c.bottom + this.I);
            } else {
                canvas.translate(this.f3629c.left + this.ab, this.f3629c.bottom + this.I);
            }
            this.aa.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.L) {
            this.f.setColor(this.K);
            this.f.setStyle(Paint.Style.FILL);
            if (this.J) {
                Rect rect2 = new Rect();
                TextPaint textPaint2 = this.g;
                String str2 = this.E;
                textPaint2.getTextBounds(str2, 0, str2.length(), rect2);
                float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ab;
                RectF rectF3 = new RectF(width2, ((this.f3629c.top - this.I) - this.aa.getHeight()) - this.ab, rect2.width() + width2 + (this.ab * 2), (this.f3629c.top - this.I) + this.ab);
                int i3 = this.ab;
                canvas.drawRoundRect(rectF3, i3, i3, this.f);
            } else {
                RectF rectF4 = new RectF(this.f3629c.left, ((this.f3629c.top - this.I) - this.aa.getHeight()) - this.ab, this.f3629c.right, (this.f3629c.top - this.I) + this.ab);
                int i4 = this.ab;
                canvas.drawRoundRect(rectF4, i4, i4, this.f);
            }
        }
        canvas.save();
        if (this.J) {
            canvas.translate(0.0f, (this.f3629c.top - this.I) - this.aa.getHeight());
        } else {
            canvas.translate(this.f3629c.left + this.ab, (this.f3629c.top - this.I) - this.aa.getHeight());
        }
        this.aa.draw(canvas);
        canvas.restore();
    }

    private void e() {
        if (this.B) {
            if (this.P == null) {
                this.f3631e += this.f3627a;
                int i = this.p;
                Bitmap bitmap = this.u;
                if (bitmap != null) {
                    i = bitmap.getWidth();
                }
                if (this.M) {
                    if (this.f3631e + i > this.f3629c.right - this.W || this.f3631e < this.f3629c.left + this.W) {
                        this.f3627a = -this.f3627a;
                    }
                } else if (this.f3631e + i > this.f3629c.right - this.W) {
                    this.f3631e = this.f3629c.left + this.W + 0.5f;
                }
            } else {
                float f = this.R + this.f3627a;
                this.R = f;
                if (f > this.f3629c.right - this.W) {
                    this.R = this.f3629c.left + this.W + 0.5f;
                }
            }
        } else if (this.P == null) {
            this.f3630d += this.f3627a;
            int i2 = this.p;
            Bitmap bitmap2 = this.u;
            if (bitmap2 != null) {
                i2 = bitmap2.getHeight();
            }
            if (this.M) {
                if (this.f3630d + i2 > this.f3629c.bottom - this.W || this.f3630d < this.f3629c.top + this.W) {
                    this.f3627a = -this.f3627a;
                }
            } else if (this.f3630d + i2 > this.f3629c.bottom - this.W) {
                this.f3630d = this.f3629c.top + this.W + 0.5f;
            }
        } else {
            float f2 = this.Q + this.f3627a;
            this.Q = f2;
            if (f2 > this.f3629c.bottom - this.W) {
                this.Q = this.f3629c.top + this.W + 0.5f;
            }
        }
        postInvalidateDelayed(this.f3628b, this.f3629c.left, this.f3629c.top, this.f3629c.right, this.f3629c.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        f();
    }

    private void f() {
        int width = (getWidth() - this.l) / 2;
        int i = this.o;
        Rect rect = new Rect(width, i, this.l + width, this.m + i);
        this.f3629c = rect;
        if (this.B) {
            float f = rect.left + this.W + 0.5f;
            this.f3631e = f;
            this.R = f;
        } else {
            float f2 = rect.top + this.W + 0.5f;
            this.f3630d = f2;
            this.Q = f2;
        }
        if (this.af == null || !a()) {
            return;
        }
        this.af.a(new Rect(this.f3629c));
    }

    public Rect a(int i) {
        if (this.ac && getVisibility() == 0) {
            Rect rect = new Rect(this.f3629c);
            float measuredHeight = (i * 1.0f) / getMeasuredHeight();
            float exactCenterX = rect.exactCenterX() * measuredHeight;
            float exactCenterY = rect.exactCenterY() * measuredHeight;
            float width = (rect.width() / 2.0f) * measuredHeight;
            float height = (rect.height() / 2.0f) * measuredHeight;
            rect.left = (int) (exactCenterX - width);
            rect.right = (int) (exactCenterX + width);
            rect.top = (int) (exactCenterY - height);
            rect.bottom = (int) (exactCenterY + height);
            return rect;
        }
        return null;
    }

    public void setIsBarcode(boolean z) {
        this.B = z;
        g();
    }

    private void g() {
        if (this.O != null || this.N) {
            if (this.B) {
                this.P = this.V;
            } else {
                this.P = this.U;
            }
        } else if (this.t != null || this.s) {
            if (this.B) {
                this.u = this.T;
            } else {
                this.u = this.S;
            }
        }
        if (this.B) {
            this.E = this.D;
            this.m = this.n;
            this.f3628b = (int) (((this.x * 1.0f) * this.f3627a) / this.l);
        } else {
            this.E = this.C;
            int i = this.l;
            this.m = i;
            this.f3628b = (int) (((this.x * 1.0f) * this.f3627a) / i);
        }
        if (!TextUtils.isEmpty(this.E)) {
            if (this.J) {
                this.aa = new StaticLayout(this.E, this.g, a.b(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.aa = new StaticLayout(this.E, this.g, this.l - (this.ab * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.y != -1.0f) {
            int c2 = a.b(getContext()).y - a.c(getContext());
            int i2 = this.A;
            if (i2 == 0) {
                this.o = (int) ((c2 * this.y) - (this.m / 2));
            } else {
                this.o = i2 + ((int) (((c2 - i2) * this.y) - (this.m / 2)));
            }
        }
        f();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.B;
    }

    public int getMaskColor() {
        return this.h;
    }

    public void setMaskColor(int i) {
        this.h = i;
        g();
    }

    public int getCornerColor() {
        return this.i;
    }

    public void setCornerColor(int i) {
        this.i = i;
        g();
    }

    public int getCornerLength() {
        return this.j;
    }

    public void setCornerLength(int i) {
        this.j = i;
        g();
    }

    public int getCornerSize() {
        return this.k;
    }

    public void setCornerSize(int i) {
        this.k = i;
        g();
    }

    public int getRectWidth() {
        return this.l;
    }

    public void setRectWidth(int i) {
        this.l = i;
        g();
    }

    public int getRectHeight() {
        return this.m;
    }

    public void setRectHeight(int i) {
        this.m = i;
        g();
    }

    public int getBarcodeRectHeight() {
        return this.n;
    }

    public void setBarcodeRectHeight(int i) {
        this.n = i;
        g();
    }

    public int getTopOffset() {
        return this.o;
    }

    public void setTopOffset(int i) {
        this.o = i;
        g();
    }

    public int getScanLineSize() {
        return this.p;
    }

    public void setScanLineSize(int i) {
        this.p = i;
        g();
    }

    public int getScanLineColor() {
        return this.f3632q;
    }

    public void setScanLineColor(int i) {
        this.f3632q = i;
        g();
    }

    public int getScanLineMargin() {
        return this.r;
    }

    public void setScanLineMargin(int i) {
        this.r = i;
        g();
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.s = z;
        g();
    }

    public Drawable getCustomScanLineDrawable() {
        return this.t;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.t = drawable;
        g();
    }

    public Bitmap getScanLineBitmap() {
        return this.u;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.u = bitmap;
        g();
    }

    public int getBorderSize() {
        return this.v;
    }

    public void setBorderSize(int i) {
        this.v = i;
        g();
    }

    public int getBorderColor() {
        return this.w;
    }

    public void setBorderColor(int i) {
        this.w = i;
        g();
    }

    public int getAnimTime() {
        return this.x;
    }

    public void setAnimTime(int i) {
        this.x = i;
        g();
    }

    public float getVerticalBias() {
        return this.y;
    }

    public void setVerticalBias(float f) {
        this.y = f;
        g();
    }

    public int getToolbarHeight() {
        return this.A;
    }

    public void setToolbarHeight(int i) {
        this.A = i;
        g();
    }

    public String getQRCodeTipText() {
        return this.C;
    }

    public void setQRCodeTipText(String str) {
        this.C = str;
        g();
    }

    public String getBarCodeTipText() {
        return this.D;
    }

    public void setBarCodeTipText(String str) {
        this.D = str;
        g();
    }

    public String getTipText() {
        return this.E;
    }

    public void setTipText(String str) {
        if (this.B) {
            this.D = str;
        } else {
            this.C = str;
        }
        g();
    }

    public int getTipTextColor() {
        return this.G;
    }

    public void setTipTextColor(int i) {
        this.G = i;
        this.g.setColor(i);
        g();
    }

    public int getTipTextSize() {
        return this.F;
    }

    public void setTipTextSize(int i) {
        this.F = i;
        this.g.setTextSize(i);
        g();
    }

    public void setTipTextBelowRect(boolean z) {
        this.H = z;
        g();
    }

    public int getTipTextMargin() {
        return this.I;
    }

    public void setTipTextMargin(int i) {
        this.I = i;
        g();
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.J = z;
        g();
    }

    public void setShowTipBackground(boolean z) {
        this.L = z;
        g();
    }

    public int getTipBackgroundColor() {
        return this.K;
    }

    public void setTipBackgroundColor(int i) {
        this.K = i;
        g();
    }

    public void setScanLineReverse(boolean z) {
        this.M = z;
        g();
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.N = z;
        g();
    }

    public float getHalfCornerSize() {
        return this.W;
    }

    public void setHalfCornerSize(float f) {
        this.W = f;
        g();
    }

    public StaticLayout getTipTextSl() {
        return this.aa;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.aa = staticLayout;
        g();
    }

    public int getTipBackgroundRadius() {
        return this.ab;
    }

    public void setTipBackgroundRadius(int i) {
        this.ab = i;
        g();
    }

    public boolean a() {
        return this.ac;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ac = z;
        f();
    }

    public boolean b() {
        return this.ad;
    }

    public void setShowLocationPoint(boolean z) {
        this.ad = z;
    }

    public boolean c() {
        return this.ae;
    }

    public void setAutoZoom(boolean z) {
        this.ae = z;
    }
}
