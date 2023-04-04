package cn.bingoogolapple.qrcode.core;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProcessDataTask.java */
/* loaded from: classes.dex */
public class e extends AsyncTask<Void, Void, h> {
    private static long g;

    /* renamed from: a  reason: collision with root package name */
    private Camera f3608a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f3609b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3610c;

    /* renamed from: d  reason: collision with root package name */
    private String f3611d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f3612e;
    private WeakReference<f> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Camera camera, byte[] bArr, f fVar, boolean z) {
        this.f3608a = camera;
        this.f3609b = bArr;
        this.f = new WeakReference<>(fVar);
        this.f3610c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f.clear();
        this.f3612e = null;
        this.f3609b = null;
    }

    private h a(f fVar) {
        Exception e2;
        int i;
        int i2;
        byte[] bArr = this.f3609b;
        if (bArr == null) {
            return null;
        }
        try {
            Camera.Size previewSize = this.f3608a.getParameters().getPreviewSize();
            i2 = previewSize.width;
            try {
                i = previewSize.height;
                try {
                    if (this.f3610c) {
                        bArr = new byte[this.f3609b.length];
                        for (int i3 = 0; i3 < i; i3++) {
                            for (int i4 = 0; i4 < i2; i4++) {
                                bArr[(((i4 * i) + i) - i3) - 1] = this.f3609b[(i3 * i2) + i4];
                            }
                        }
                        i2 = i;
                        i = i2;
                    }
                    return fVar.a(bArr, i2, i, false);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (i2 != 0 && i != 0) {
                        try {
                            a.a("识别失败重试");
                            return fVar.a(bArr, i2, i, true);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Exception e5) {
                e2 = e5;
                i = 0;
            }
        } catch (Exception e6) {
            e2 = e6;
            i = 0;
            i2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public h doInBackground(Void... voidArr) {
        f fVar = this.f.get();
        if (fVar == null) {
            return null;
        }
        String str = this.f3611d;
        if (str != null) {
            return fVar.a(a.c(str));
        }
        Bitmap bitmap = this.f3612e;
        if (bitmap != null) {
            h a2 = fVar.a(bitmap);
            this.f3612e = null;
            return a2;
        }
        if (a.a()) {
            a.a("两次任务执行的时间间隔：" + (System.currentTimeMillis() - g));
            g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        h a3 = a(fVar);
        if (a.a()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a3 != null && !TextUtils.isEmpty(a3.f3633a)) {
                a.a("识别成功时间为：" + currentTimeMillis2);
            } else {
                a.b("识别失败时间为：" + currentTimeMillis2);
            }
        }
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(h hVar) {
        f fVar = this.f.get();
        if (fVar == null) {
            return;
        }
        if (this.f3611d != null || this.f3612e != null) {
            this.f3612e = null;
            fVar.b(hVar);
            return;
        }
        fVar.a(hVar);
    }
}
