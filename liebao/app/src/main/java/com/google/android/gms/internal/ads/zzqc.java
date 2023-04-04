package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqc extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    private Handler handler;
    private final int[] zzbli;
    private SurfaceTexture zzblj;
    private Error zzblk;
    private RuntimeException zzbll;
    private zzqa zzblm;

    public zzqc() {
        super("dummySurface");
        this.zzbli = new int[1];
    }

    public final zzqa zzn(boolean z) {
        boolean z2;
        start();
        this.handler = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.zzblm == null && this.zzbll == null && this.zzblk == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzbll;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzblk;
        if (error != null) {
            throw error;
        }
        return this.zzblm;
    }

    public final void release() {
        this.handler.sendEmptyMessage(3);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.handler.sendEmptyMessage(2);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i == 2) {
                    this.zzblj.updateTexImage();
                    return true;
                } else if (i != 3) {
                    return true;
                } else {
                    try {
                        this.zzblj.release();
                        this.zzblm = null;
                        this.zzblj = null;
                        GLES20.glDeleteTextures(1, this.zzbli, 0);
                    } catch (Throwable th) {
                        try {
                            Log.e("DummySurface", "Failed to release dummy surface", th);
                        } finally {
                            quit();
                        }
                    }
                    return true;
                }
            }
            try {
                try {
                    boolean z = message.arg1 != 0;
                    EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                    zzpg.checkState(eglGetDisplay != null, "eglGetDisplay failed");
                    int[] iArr = new int[2];
                    zzpg.checkState(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr2 = new int[1];
                    zzpg.checkState(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                    zzpg.checkState(eglCreateContext != null, "eglCreateContext failed");
                    EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                    zzpg.checkState(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                    zzpg.checkState(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                    GLES20.glGenTextures(1, this.zzbli, 0);
                    SurfaceTexture surfaceTexture = new SurfaceTexture(this.zzbli[0]);
                    this.zzblj = surfaceTexture;
                    surfaceTexture.setOnFrameAvailableListener(this);
                    this.zzblm = new zzqa(this, this.zzblj, z);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.zzbll = e2;
                    synchronized (this) {
                        notify();
                    }
                }
            } catch (Error e3) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                this.zzblk = e3;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }
}
