package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.Collections;

/* compiled from: CameraPreview.java */
/* loaded from: classes.dex */
public class d extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Camera f3602a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3603b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3604c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3605d;

    /* renamed from: e  reason: collision with root package name */
    private float f3606e;
    private c f;
    private a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraPreview.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public d(Context context) {
        super(context);
        this.f3603b = false;
        this.f3604c = false;
        this.f3605d = false;
        this.f3606e = 1.0f;
        getHolder().addCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCamera(Camera camera) {
        this.f3602a = camera;
        if (camera != null) {
            c cVar = new c(getContext());
            this.f = cVar;
            cVar.a(this.f3602a);
            if (this.f3603b) {
                requestLayout();
            } else {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegate(a aVar) {
        this.g = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f3604c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        a();
        c();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f3604c = false;
        a();
    }

    private void c() {
        if (this.f3602a != null) {
            try {
                this.f3603b = true;
                SurfaceHolder holder = getHolder();
                holder.setKeepScreenOn(true);
                this.f3602a.setPreviewDisplay(holder);
                this.f.b(this.f3602a);
                this.f3602a.startPreview();
                if (this.g != null) {
                    this.g.a();
                }
                d();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Camera camera = this.f3602a;
        if (camera != null) {
            try {
                this.f3603b = false;
                camera.cancelAutoFocus();
                this.f3602a.setOneShotPreviewCallback(null);
                this.f3602a.stopPreview();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Rect rect) {
        if (this.f3602a == null || rect == null || rect.left <= 0 || rect.top <= 0) {
            return;
        }
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        cn.bingoogolapple.qrcode.core.a.a("转换前", rect);
        if (cn.bingoogolapple.qrcode.core.a.a(getContext())) {
            centerY = centerX;
            centerX = centerY;
            height = width;
            width = height;
        }
        Rect rect2 = new Rect(centerX - width, centerY - height, centerX + width, centerY + height);
        cn.bingoogolapple.qrcode.core.a.a("转换后", rect2);
        cn.bingoogolapple.qrcode.core.a.a("扫码框发生变化触发对焦测光");
        a(rect2.centerX(), rect2.centerY(), rect2.width(), rect2.height());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!b()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1 && (motionEvent.getAction() & 255) == 1) {
            if (this.f3605d) {
                return true;
            }
            this.f3605d = true;
            cn.bingoogolapple.qrcode.core.a.a("手指触摸触发对焦测光");
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (cn.bingoogolapple.qrcode.core.a.a(getContext())) {
                y = x;
                x = y;
            }
            int a2 = cn.bingoogolapple.qrcode.core.a.a(getContext(), 120.0f);
            a(x, y, a2, a2);
        }
        if (motionEvent.getPointerCount() == 2) {
            int action = motionEvent.getAction() & 255;
            if (action == 2) {
                float a3 = cn.bingoogolapple.qrcode.core.a.a(motionEvent);
                float f = this.f3606e;
                if (a3 > f) {
                    a(true, this.f3602a);
                } else if (a3 < f) {
                    a(false, this.f3602a);
                }
            } else if (action == 5) {
                this.f3606e = cn.bingoogolapple.qrcode.core.a.a(motionEvent);
            }
        }
        return true;
    }

    private static void a(boolean z, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            int zoom = parameters.getZoom();
            if (z && zoom < parameters.getMaxZoom()) {
                cn.bingoogolapple.qrcode.core.a.a("放大");
                zoom++;
            } else if (!z && zoom > 0) {
                cn.bingoogolapple.qrcode.core.a.a("缩小");
                zoom--;
            } else {
                cn.bingoogolapple.qrcode.core.a.a("既不放大也不缩小");
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
            return;
        }
        cn.bingoogolapple.qrcode.core.a.a("不支持缩放");
    }

    private void a(float f, float f2, int i, int i2) {
        boolean z;
        try {
            Camera.Parameters parameters = this.f3602a.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            boolean z2 = true;
            if (parameters.getMaxNumFocusAreas() > 0) {
                cn.bingoogolapple.qrcode.core.a.a("支持设置对焦区域");
                Rect a2 = cn.bingoogolapple.qrcode.core.a.a(1.0f, f, f2, i, i2, previewSize.width, previewSize.height);
                cn.bingoogolapple.qrcode.core.a.a("对焦区域", a2);
                parameters.setFocusAreas(Collections.singletonList(new Camera.Area(a2, 1000)));
                parameters.setFocusMode("macro");
                z = true;
            } else {
                cn.bingoogolapple.qrcode.core.a.a("不支持设置对焦区域");
                z = false;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                cn.bingoogolapple.qrcode.core.a.a("支持设置测光区域");
                Rect a3 = cn.bingoogolapple.qrcode.core.a.a(1.5f, f, f2, i, i2, previewSize.width, previewSize.height);
                cn.bingoogolapple.qrcode.core.a.a("测光区域", a3);
                parameters.setMeteringAreas(Collections.singletonList(new Camera.Area(a3, 1000)));
            } else {
                cn.bingoogolapple.qrcode.core.a.a("不支持设置测光区域");
                z2 = z;
            }
            if (z2) {
                this.f3602a.cancelAutoFocus();
                this.f3602a.setParameters(parameters);
                this.f3602a.autoFocus(new Camera.AutoFocusCallback() { // from class: cn.bingoogolapple.qrcode.core.d.1
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z3, Camera camera) {
                        if (z3) {
                            cn.bingoogolapple.qrcode.core.a.a("对焦测光成功");
                        } else {
                            cn.bingoogolapple.qrcode.core.a.b("对焦测光失败");
                        }
                        d.this.d();
                    }
                });
                return;
            }
            this.f3605d = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            cn.bingoogolapple.qrcode.core.a.b("对焦测光失败：" + e2.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f3605d = false;
        Camera camera = this.f3602a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f3602a.setParameters(parameters);
            this.f3602a.cancelAutoFocus();
        } catch (Exception unused) {
            cn.bingoogolapple.qrcode.core.a.b("连续对焦失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f3602a != null && this.f3603b && this.f3604c;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        c cVar = this.f;
        if (cVar != null && cVar.a() != null) {
            Point a2 = this.f.a();
            float f = defaultSize;
            float f2 = defaultSize2;
            float f3 = a2.x;
            float f4 = a2.y;
            float f5 = (f3 * 1.0f) / f4;
            if ((f * 1.0f) / f2 < f5) {
                defaultSize = (int) ((f2 / ((f4 * 1.0f) / f3)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f / f5) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }
}
