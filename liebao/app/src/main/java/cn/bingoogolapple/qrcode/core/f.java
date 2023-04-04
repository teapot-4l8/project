package cn.bingoogolapple.qrcode.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cn.bingoogolapple.qrcode.core.d;

/* compiled from: QRCodeView.java */
/* loaded from: classes.dex */
public abstract class f extends RelativeLayout implements Camera.PreviewCallback {
    private static final long[] p = {255, 255, 255, 255};

    /* renamed from: a  reason: collision with root package name */
    protected Camera f3613a;

    /* renamed from: b  reason: collision with root package name */
    protected d f3614b;

    /* renamed from: c  reason: collision with root package name */
    protected g f3615c;

    /* renamed from: d  reason: collision with root package name */
    protected a f3616d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f3617e;
    protected e f;
    protected int g;
    protected b h;
    private PointF[] i;
    private Paint j;
    private long k;
    private ValueAnimator l;
    private long m;
    private long n;
    private int o;

    /* compiled from: QRCodeView.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        void a(boolean z);

        void e_();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract h a(Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract h a(byte[] bArr, int i, int i2, boolean z);

    protected abstract void a();

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3617e = false;
        this.g = 0;
        this.h = b.HIGH_FREQUENCY;
        this.k = 0L;
        this.m = 0L;
        this.n = System.currentTimeMillis();
        this.o = 0;
        a(context, attributeSet);
        a();
    }

    private void a(Context context, AttributeSet attributeSet) {
        d dVar = new d(context);
        this.f3614b = dVar;
        dVar.setDelegate(new d.a() { // from class: cn.bingoogolapple.qrcode.core.f.1
            @Override // cn.bingoogolapple.qrcode.core.d.a
            public void a() {
                f.this.m();
            }
        });
        g gVar = new g(context);
        this.f3615c = gVar;
        gVar.a(this, attributeSet);
        this.f3614b.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f3614b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f3614b.getId());
        layoutParams.addRule(8, this.f3614b.getId());
        addView(this.f3615c, layoutParams);
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(getScanBoxView().getCornerColor());
        this.j.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f3617e && this.f3614b.b()) {
            try {
                this.f3613a.setOneShotPreviewCallback(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setDelegate(a aVar) {
        this.f3616d = aVar;
    }

    public d getCameraPreview() {
        return this.f3614b;
    }

    public g getScanBoxView() {
        return this.f3615c;
    }

    public void b() {
        g gVar = this.f3615c;
        if (gVar != null) {
            gVar.setVisibility(0);
        }
    }

    public void c() {
        g gVar = this.f3615c;
        if (gVar != null) {
            gVar.setVisibility(8);
        }
    }

    public void d() {
        a(this.g);
    }

    public void a(int i) {
        if (this.f3613a != null || Camera.getNumberOfCameras() == 0) {
            return;
        }
        int b2 = b(i);
        if (b2 != -1) {
            c(b2);
            return;
        }
        if (i == 0) {
            b2 = b(1);
        } else if (i == 1) {
            b2 = b(0);
        }
        if (b2 != -1) {
            c(b2);
        }
    }

    private int b(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            try {
                Camera.getCameraInfo(i2, cameraInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    private void c(int i) {
        try {
            this.g = i;
            Camera open = Camera.open(i);
            this.f3613a = open;
            this.f3614b.setCamera(open);
        } catch (Exception e2) {
            e2.printStackTrace();
            a aVar = this.f3616d;
            if (aVar != null) {
                aVar.e_();
            }
        }
    }

    public void e() {
        try {
            h();
            if (this.f3613a != null) {
                this.f3614b.a();
                this.f3614b.setCamera(null);
                this.f3613a.release();
                this.f3613a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        this.f3617e = true;
        d();
        m();
    }

    public void g() {
        this.f3617e = false;
        e eVar = this.f;
        if (eVar != null) {
            eVar.b();
            this.f = null;
        }
        Camera camera = this.f3613a;
        if (camera != null) {
            try {
                camera.setOneShotPreviewCallback(null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void h() {
        g();
        c();
    }

    public void i() {
        f();
        b();
    }

    public void j() {
        e();
        this.f3616d = null;
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f3615c.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (cn.bingoogolapple.qrcode.core.a.a()) {
            cn.bingoogolapple.qrcode.core.a.a("两次 onPreviewFrame 时间间隔：" + (System.currentTimeMillis() - this.k));
            this.k = System.currentTimeMillis();
        }
        d dVar = this.f3614b;
        if (dVar != null && dVar.b()) {
            try {
                a(bArr, camera);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f3617e) {
            e eVar = this.f;
            if (eVar == null || !(eVar.getStatus() == AsyncTask.Status.PENDING || this.f.getStatus() == AsyncTask.Status.RUNNING)) {
                this.f = new e(camera, bArr, this, cn.bingoogolapple.qrcode.core.a.a(getContext())).a();
            }
        }
    }

    private void a(byte[] bArr, Camera camera) {
        d dVar = this.f3614b;
        if (dVar == null || !dVar.b()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.n < 150) {
            return;
        }
        this.n = currentTimeMillis;
        long j = 0;
        long j2 = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
        if (Math.abs(bArr.length - (((float) j2) * 1.5f)) < 1.0E-5f) {
            boolean z = false;
            for (int i = 0; i < j2; i += 10) {
                j += bArr[i] & 255;
            }
            long j3 = j / (j2 / 10);
            long[] jArr = p;
            int length = this.o % jArr.length;
            this.o = length;
            jArr[length] = j3;
            this.o = length + 1;
            int length2 = jArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = true;
                    break;
                } else if (jArr[i2] > 60) {
                    break;
                } else {
                    i2++;
                }
            }
            cn.bingoogolapple.qrcode.core.a.a("摄像头环境亮度为：" + j3);
            a aVar = this.f3616d;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        if (this.f3617e) {
            String str = hVar == null ? null : hVar.f3633a;
            if (TextUtils.isEmpty(str)) {
                try {
                    if (this.f3613a != null) {
                        this.f3613a.setOneShotPreviewCallback(this);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            this.f3617e = false;
            try {
                if (this.f3616d != null) {
                    this.f3616d.a(str);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        if (this.f3616d != null) {
            this.f3616d.a(hVar == null ? null : hVar.f3633a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Rect rect) {
        this.f3614b.a(rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        PointF[] pointFArr;
        super.dispatchDraw(canvas);
        if (!k() || (pointFArr = this.i) == null) {
            return;
        }
        for (PointF pointF : pointFArr) {
            canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.j);
        }
        this.i = null;
        postInvalidateDelayed(2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k() {
        g gVar = this.f3615c;
        return gVar != null && gVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l() {
        g gVar = this.f3615c;
        return gVar != null && gVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(PointF[] pointFArr, Rect rect, boolean z, String str) {
        if (pointFArr != null && pointFArr.length != 0) {
            try {
                Camera.Size previewSize = this.f3613a.getParameters().getPreviewSize();
                boolean z2 = this.g == 1;
                int c2 = cn.bingoogolapple.qrcode.core.a.c(getContext());
                PointF[] pointFArr2 = new PointF[pointFArr.length];
                int i = 0;
                for (PointF pointF : pointFArr) {
                    pointFArr2[i] = a(pointF.x, pointF.y, previewSize.width, previewSize.height, z2, c2, rect);
                    i++;
                }
                this.i = pointFArr2;
                postInvalidate();
                if (z) {
                    return a(pointFArr2, str);
                }
                return false;
            } catch (Exception e2) {
                this.i = null;
                e2.printStackTrace();
            }
        }
        return false;
    }

    private boolean a(PointF[] pointFArr, final String str) {
        if (this.f3613a == null || this.f3615c == null || pointFArr == null || pointFArr.length < 1) {
            return false;
        }
        ValueAnimator valueAnimator = this.l;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && System.currentTimeMillis() - this.m >= 1200) {
            Camera.Parameters parameters = this.f3613a.getParameters();
            if (parameters.isZoomSupported()) {
                float f = pointFArr[0].x;
                float f2 = pointFArr[0].y;
                float f3 = pointFArr[1].x;
                float f4 = pointFArr[1].y;
                float abs = Math.abs(f - f3);
                float abs2 = Math.abs(f2 - f4);
                if (((int) Math.sqrt((abs * abs) + (abs2 * abs2))) > this.f3615c.getRectWidth() / 4) {
                    return false;
                }
                final int maxZoom = parameters.getMaxZoom();
                final int i = maxZoom / 4;
                final int zoom = parameters.getZoom();
                post(new Runnable() { // from class: cn.bingoogolapple.qrcode.core.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        f fVar = f.this;
                        int i2 = zoom;
                        fVar.a(i2, Math.min(i + i2, maxZoom), str);
                    }
                });
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, final String str) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        this.l = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.bingoogolapple.qrcode.core.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.f3614b == null || !f.this.f3614b.b()) {
                    return;
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                Camera.Parameters parameters = f.this.f3613a.getParameters();
                parameters.setZoom(intValue);
                f.this.f3613a.setParameters(parameters);
            }
        });
        this.l.addListener(new AnimatorListenerAdapter() { // from class: cn.bingoogolapple.qrcode.core.f.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.a(new h(str));
            }
        });
        this.l.setDuration(600L);
        this.l.setRepeatCount(0);
        this.l.start();
        this.m = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private PointF a(float f, float f2, float f3, float f4, boolean z, int i, Rect rect) {
        PointF pointF;
        int width = getWidth();
        int height = getHeight();
        if (cn.bingoogolapple.qrcode.core.a.a(getContext())) {
            float f5 = width;
            float f6 = height;
            pointF = new PointF((f4 - f) * (f5 / f4), (f3 - f2) * (f6 / f3));
            pointF.y = f6 - pointF.y;
            pointF.x = f5 - pointF.x;
            if (rect == null) {
                pointF.y += i;
            }
        } else {
            float f7 = width;
            pointF = new PointF(f * (f7 / f3), f2 * (height / f4));
            if (z) {
                pointF.x = f7 - pointF.x;
            }
        }
        if (rect != null) {
            pointF.y += rect.top;
            pointF.x += rect.left;
        }
        return pointF;
    }
}
