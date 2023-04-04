package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcq extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbcn {
    private static final float[] zzent = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzend;
    private final zzbcl zzenu;
    private final float[] zzenv;
    private final float[] zzenw;
    private final float[] zzenx;
    private final float[] zzeny;
    private final float[] zzenz;
    private final float[] zzeoa;
    private float zzeob;
    private float zzeoc;
    private float zzeod;
    private SurfaceTexture zzeoe;
    private SurfaceTexture zzeof;
    private int zzeog;
    private int zzeoh;
    private int zzeoi;
    private FloatBuffer zzeoj;
    private final CountDownLatch zzeok;
    private final Object zzeol;
    private EGL10 zzeom;
    private EGLDisplay zzeon;
    private EGLContext zzeoo;
    private EGLSurface zzeop;
    private volatile boolean zzeoq;
    private volatile boolean zzeor;

    public zzbcq(Context context) {
        super("SphericalVideoProcessor");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(zzent.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzeoj = asFloatBuffer;
        asFloatBuffer.put(zzent).position(0);
        this.zzend = new float[9];
        this.zzenv = new float[9];
        this.zzenw = new float[9];
        this.zzenx = new float[9];
        this.zzeny = new float[9];
        this.zzenz = new float[9];
        this.zzeoa = new float[9];
        this.zzeob = Float.NaN;
        zzbcl zzbclVar = new zzbcl(context);
        this.zzenu = zzbclVar;
        zzbclVar.zza(this);
        this.zzeok = new CountDownLatch(1);
        this.zzeol = new Object();
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzeof = surfaceTexture;
    }

    public final void zzo(int i, int i2) {
        synchronized (this.zzeol) {
            this.width = i;
            this.height = i2;
            this.zzeoq = true;
            this.zzeol.notifyAll();
        }
    }

    public final void zzabp() {
        synchronized (this.zzeol) {
            this.zzeor = true;
            this.zzeof = null;
            this.zzeol.notifyAll();
        }
    }

    public final SurfaceTexture zzabq() {
        if (this.zzeof == null) {
            return null;
        }
        try {
            this.zzeok.await();
        } catch (InterruptedException unused) {
        }
        return this.zzeoe;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzeoi++;
        synchronized (this.zzeol) {
            this.zzeol.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzwl() {
        synchronized (this.zzeol) {
            this.zzeol.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.SurfaceTexture, android.graphics.SurfaceTexture$OnFrameAvailableListener] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        int zzd;
        int glCreateProgram;
        if (this.zzeof == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("SphericalVideoProcessor started with no output texture.");
            this.zzeok.countDown();
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.zzeom = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.zzeon = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY && this.zzeom.eglInitialize(this.zzeon, new int[2])) {
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGLConfig eGLConfig = (!this.zzeom.eglChooseConfig(this.zzeon, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) ? null : eGLConfigArr[0];
            if (eGLConfig != null) {
                EGLContext eglCreateContext = this.zzeom.eglCreateContext(this.zzeon, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                this.zzeoo = eglCreateContext;
                if (eglCreateContext != null && eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                    EGLSurface eglCreateWindowSurface = this.zzeom.eglCreateWindowSurface(this.zzeon, eGLConfig, this.zzeof, null);
                    this.zzeop = eglCreateWindowSurface;
                    if (eglCreateWindowSurface != null && eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                        EGL10 egl102 = this.zzeom;
                        EGLDisplay eGLDisplay = this.zzeon;
                        EGLSurface eGLSurface = this.zzeop;
                        if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.zzeoo)) {
                            z = true;
                            zzabf<String> zzabfVar = zzabq.zzcrd;
                            zzd = zzd(35633, ((String) zzww.zzra().zzd(zzabfVar)).equals(zzabfVar.zzsh()) ? (String) zzww.zzra().zzd(zzabfVar) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
                            if (zzd != 0) {
                                zzabf<String> zzabfVar2 = zzabq.zzcre;
                                int zzd2 = zzd(35632, !((String) zzww.zzra().zzd(zzabfVar2)).equals(zzabfVar2.zzsh()) ? (String) zzww.zzra().zzd(zzabfVar2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
                                if (zzd2 != 0) {
                                    glCreateProgram = GLES20.glCreateProgram();
                                    zzfd("createProgram");
                                    if (glCreateProgram != 0) {
                                        GLES20.glAttachShader(glCreateProgram, zzd);
                                        zzfd("attachShader");
                                        GLES20.glAttachShader(glCreateProgram, zzd2);
                                        zzfd("attachShader");
                                        GLES20.glLinkProgram(glCreateProgram);
                                        zzfd("linkProgram");
                                        int[] iArr2 = new int[1];
                                        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
                                        zzfd("getProgramiv");
                                        if (iArr2[0] != 1) {
                                            Log.e("SphericalVideoRenderer", "Could not link program: ");
                                            Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                                            GLES20.glDeleteProgram(glCreateProgram);
                                            zzfd("deleteProgram");
                                        } else {
                                            GLES20.glValidateProgram(glCreateProgram);
                                            zzfd("validateProgram");
                                        }
                                    }
                                    this.zzeog = glCreateProgram;
                                    GLES20.glUseProgram(glCreateProgram);
                                    zzfd("useProgram");
                                    int glGetAttribLocation = GLES20.glGetAttribLocation(this.zzeog, "aPosition");
                                    GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, (Buffer) this.zzeoj);
                                    zzfd("vertexAttribPointer");
                                    GLES20.glEnableVertexAttribArray(glGetAttribLocation);
                                    zzfd("enableVertexAttribArray");
                                    int[] iArr3 = new int[1];
                                    GLES20.glGenTextures(1, iArr3, 0);
                                    zzfd("genTextures");
                                    int i = iArr3[0];
                                    GLES20.glBindTexture(36197, i);
                                    zzfd("bindTextures");
                                    GLES20.glTexParameteri(36197, 10240, 9729);
                                    zzfd("texParameteri");
                                    GLES20.glTexParameteri(36197, 10241, 9729);
                                    zzfd("texParameteri");
                                    GLES20.glTexParameteri(36197, 10242, 33071);
                                    zzfd("texParameteri");
                                    GLES20.glTexParameteri(36197, 10243, 33071);
                                    zzfd("texParameteri");
                                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.zzeog, "uVMat");
                                    this.zzeoh = glGetUniformLocation;
                                    GLES20.glUniformMatrix3fv(glGetUniformLocation, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
                                    boolean z2 = this.zzeog != 0;
                                    if (z || !z2) {
                                        String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.zzeom.eglGetError()));
                                        String concat = valueOf.length() != 0 ? "EGL initialization failed: ".concat(valueOf) : new String("EGL initialization failed: ");
                                        com.google.android.gms.ads.internal.util.zzd.zzex(concat);
                                        com.google.android.gms.ads.internal.zzr.zzkz().zza(new Throwable(concat), "SphericalVideoProcessor.run.1");
                                        zzabr();
                                        this.zzeok.countDown();
                                    }
                                    SurfaceTexture surfaceTexture = new SurfaceTexture(i);
                                    this.zzeoe = surfaceTexture;
                                    surfaceTexture.setOnFrameAvailableListener(this);
                                    this.zzeok.countDown();
                                    this.zzenu.start();
                                    try {
                                        try {
                                            this.zzeoq = true;
                                            while (!this.zzeor) {
                                                while (this.zzeoi > 0) {
                                                    this.zzeoe.updateTexImage();
                                                    this.zzeoi--;
                                                }
                                                if (this.zzenu.zza(this.zzend)) {
                                                    if (Float.isNaN(this.zzeob)) {
                                                        float[] fArr = this.zzend;
                                                        float[] fArr2 = {0.0f, 1.0f, 0.0f};
                                                        float[] fArr3 = {(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[8] * fArr2[2])};
                                                        this.zzeob = -(((float) Math.atan2(fArr3[1], fArr3[0])) - 1.5707964f);
                                                    }
                                                    zzb(this.zzenz, this.zzeob + this.zzeoc);
                                                } else {
                                                    zza(this.zzend, -1.5707964f);
                                                    zzb(this.zzenz, this.zzeoc);
                                                }
                                                zza(this.zzenv, 1.5707964f);
                                                zza(this.zzenw, this.zzenz, this.zzenv);
                                                zza(this.zzenx, this.zzend, this.zzenw);
                                                zza(this.zzeny, this.zzeod);
                                                zza(this.zzeoa, this.zzeny, this.zzenx);
                                                GLES20.glUniformMatrix3fv(this.zzeoh, 1, false, this.zzeoa, 0);
                                                GLES20.glDrawArrays(5, 0, 4);
                                                zzfd("drawArrays");
                                                GLES20.glFinish();
                                                this.zzeom.eglSwapBuffers(this.zzeon, this.zzeop);
                                                if (this.zzeoq) {
                                                    GLES20.glViewport(0, 0, this.width, this.height);
                                                    zzfd("viewport");
                                                    int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzeog, "uFOVx");
                                                    int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.zzeog, "uFOVy");
                                                    if (this.width > this.height) {
                                                        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                                                        GLES20.glUniform1f(glGetUniformLocation3, (this.height * 0.87266463f) / this.width);
                                                    } else {
                                                        GLES20.glUniform1f(glGetUniformLocation2, (this.width * 0.87266463f) / this.height);
                                                        GLES20.glUniform1f(glGetUniformLocation3, 0.87266463f);
                                                    }
                                                    this.zzeoq = false;
                                                }
                                                try {
                                                    synchronized (this.zzeol) {
                                                        if (!this.zzeor && !this.zzeoq && this.zzeoi == 0) {
                                                            this.zzeol.wait();
                                                        }
                                                    }
                                                } catch (InterruptedException unused) {
                                                }
                                            }
                                            return;
                                        } catch (IllegalStateException unused2) {
                                            com.google.android.gms.ads.internal.util.zzd.zzez("SphericalVideoProcessor halted unexpectedly.");
                                            return;
                                        } catch (Throwable th) {
                                            com.google.android.gms.ads.internal.util.zzd.zzc("SphericalVideoProcessor died.", th);
                                            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "SphericalVideoProcessor.run.2");
                                            return;
                                        }
                                    } finally {
                                        this.zzenu.stop();
                                        this.zzeoe.setOnFrameAvailableListener(null);
                                        this.zzeoe = null;
                                        zzabr();
                                    }
                                }
                            }
                            glCreateProgram = 0;
                            this.zzeog = glCreateProgram;
                            GLES20.glUseProgram(glCreateProgram);
                            zzfd("useProgram");
                            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.zzeog, "aPosition");
                            GLES20.glVertexAttribPointer(glGetAttribLocation2, 3, 5126, false, 12, (Buffer) this.zzeoj);
                            zzfd("vertexAttribPointer");
                            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
                            zzfd("enableVertexAttribArray");
                            int[] iArr32 = new int[1];
                            GLES20.glGenTextures(1, iArr32, 0);
                            zzfd("genTextures");
                            int i2 = iArr32[0];
                            GLES20.glBindTexture(36197, i2);
                            zzfd("bindTextures");
                            GLES20.glTexParameteri(36197, 10240, 9729);
                            zzfd("texParameteri");
                            GLES20.glTexParameteri(36197, 10241, 9729);
                            zzfd("texParameteri");
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            zzfd("texParameteri");
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            zzfd("texParameteri");
                            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.zzeog, "uVMat");
                            this.zzeoh = glGetUniformLocation4;
                            GLES20.glUniformMatrix3fv(glGetUniformLocation4, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
                            if (this.zzeog != 0) {
                            }
                            if (z) {
                            }
                            String valueOf2 = String.valueOf(GLUtils.getEGLErrorString(this.zzeom.eglGetError()));
                            if (valueOf2.length() != 0) {
                            }
                            com.google.android.gms.ads.internal.util.zzd.zzex(concat);
                            com.google.android.gms.ads.internal.zzr.zzkz().zza(new Throwable(concat), "SphericalVideoProcessor.run.1");
                            zzabr();
                            this.zzeok.countDown();
                        }
                    }
                }
            }
        }
        z = false;
        zzabf<String> zzabfVar3 = zzabq.zzcrd;
        zzd = zzd(35633, ((String) zzww.zzra().zzd(zzabfVar3)).equals(zzabfVar3.zzsh()) ? (String) zzww.zzra().zzd(zzabfVar3) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (zzd != 0) {
        }
        glCreateProgram = 0;
        this.zzeog = glCreateProgram;
        GLES20.glUseProgram(glCreateProgram);
        zzfd("useProgram");
        int glGetAttribLocation22 = GLES20.glGetAttribLocation(this.zzeog, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation22, 3, 5126, false, 12, (Buffer) this.zzeoj);
        zzfd("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation22);
        zzfd("enableVertexAttribArray");
        int[] iArr322 = new int[1];
        GLES20.glGenTextures(1, iArr322, 0);
        zzfd("genTextures");
        int i22 = iArr322[0];
        GLES20.glBindTexture(36197, i22);
        zzfd("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        zzfd("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        zzfd("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        zzfd("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        zzfd("texParameteri");
        int glGetUniformLocation42 = GLES20.glGetUniformLocation(this.zzeog, "uVMat");
        this.zzeoh = glGetUniformLocation42;
        GLES20.glUniformMatrix3fv(glGetUniformLocation42, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        if (this.zzeog != 0) {
        }
        if (z) {
        }
        String valueOf22 = String.valueOf(GLUtils.getEGLErrorString(this.zzeom.eglGetError()));
        if (valueOf22.length() != 0) {
        }
        com.google.android.gms.ads.internal.util.zzd.zzex(concat);
        com.google.android.gms.ads.internal.zzr.zzkz().zza(new Throwable(concat), "SphericalVideoProcessor.run.1");
        zzabr();
        this.zzeok.countDown();
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        if (i > i2) {
            f3 = (f * 1.7453293f) / i;
            f4 = f2 * 1.7453293f;
            f5 = i;
        } else {
            f3 = (f * 1.7453293f) / i2;
            f4 = f2 * 1.7453293f;
            f5 = i2;
        }
        this.zzeoc -= f3;
        float f6 = this.zzeod - (f4 / f5);
        this.zzeod = f6;
        if (f6 < -1.5707964f) {
            this.zzeod = -1.5707964f;
        }
        if (this.zzeod > 1.5707964f) {
            this.zzeod = 1.5707964f;
        }
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = f;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }

    private static void zzb(float[] fArr, float f) {
        double d2 = f;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzfd("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzfd("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzfd("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzfd("getShaderiv");
            if (iArr[0] == 0) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Could not compile shader ");
                sb.append(i);
                sb.append(":");
                Log.e("SphericalVideoRenderer", sb.toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzfd("deleteShader");
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    private final boolean zzabr() {
        EGLSurface eGLSurface = this.zzeop;
        boolean z = false;
        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
            z = this.zzeom.eglDestroySurface(this.zzeon, this.zzeop) | this.zzeom.eglMakeCurrent(this.zzeon, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false;
            this.zzeop = null;
        }
        EGLContext eGLContext = this.zzeoo;
        if (eGLContext != null) {
            z |= this.zzeom.eglDestroyContext(this.zzeon, eGLContext);
            this.zzeoo = null;
        }
        EGLDisplay eGLDisplay = this.zzeon;
        if (eGLDisplay != null) {
            boolean eglTerminate = z | this.zzeom.eglTerminate(eGLDisplay);
            this.zzeon = null;
            return eglTerminate;
        }
        return z;
    }

    private static void zzfd(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }
}
