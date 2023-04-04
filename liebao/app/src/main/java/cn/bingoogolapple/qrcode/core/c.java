package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraConfigurationManager.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3599a;

    /* renamed from: b  reason: collision with root package name */
    private Point f3600b;

    /* renamed from: c  reason: collision with root package name */
    private Point f3601c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f3599a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera) {
        Point b2 = a.b(this.f3599a);
        Point point = new Point();
        point.x = b2.x;
        point.y = b2.y;
        if (a.a(this.f3599a)) {
            point.x = b2.y;
            point.y = b2.x;
        }
        this.f3601c = a(camera.getParameters(), point);
        if (a.a(this.f3599a)) {
            this.f3600b = new Point(this.f3601c.y, this.f3601c.x);
        } else {
            this.f3600b = this.f3601c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point a() {
        return this.f3600b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.f3601c.x, this.f3601c.y);
        int[] a2 = a(camera, 60.0f);
        if (a2 != null) {
            parameters.setPreviewFpsRange(a2[0], a2[1]);
        }
        camera.setDisplayOrientation(b());
        camera.setParameters(parameters);
    }

    private int[] a(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    private int b() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = 0;
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) this.f3599a.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    private static Point a(Camera.Parameters parameters, Point point) {
        Point a2 = a(parameters.getSupportedPreviewSizes(), point);
        return a2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : a2;
    }

    private static Point a(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i4 = next.width;
            int i5 = next.height;
            int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
            if (abs == 0) {
                i2 = i5;
                i = i4;
                break;
            } else if (abs < i3) {
                i2 = i5;
                i = i4;
                i3 = abs;
            }
        }
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        return new Point(i, i2);
    }
}
