package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final File f5018a = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    private static volatile p f5019d;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f5020b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f5021c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a() {
        if (f5019d == null) {
            synchronized (p.class) {
                if (f5019d == null) {
                    f5019d = new p();
                }
            }
        }
        return f5019d;
    }

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, BitmapFactory.Options options, com.bumptech.glide.c.b bVar, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i = this.f5020b + 1;
        this.f5020b = i;
        if (i >= 50) {
            this.f5020b = 0;
            int length = f5018a.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f5021c = z;
            if (!this.f5021c && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f5021c;
    }
}
