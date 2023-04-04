package com.bumptech.glide.c.b.b;

import android.util.Log;
import com.bumptech.glide.a.a;
import com.bumptech.glide.c.b.b.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: b  reason: collision with root package name */
    private final File f4728b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4729c;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.a.a f4731e;

    /* renamed from: d  reason: collision with root package name */
    private final c f4730d = new c();

    /* renamed from: a  reason: collision with root package name */
    private final j f4727a = new j();

    public static a a(File file, long j) {
        return new e(file, j);
    }

    @Deprecated
    protected e(File file, long j) {
        this.f4728b = file;
        this.f4729c = j;
    }

    private synchronized com.bumptech.glide.a.a a() {
        if (this.f4731e == null) {
            this.f4731e = com.bumptech.glide.a.a.a(this.f4728b, 1, 1, this.f4729c);
        }
        return this.f4731e;
    }

    @Override // com.bumptech.glide.c.b.b.a
    public File a(com.bumptech.glide.c.h hVar) {
        String a2 = this.f4727a.a(hVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a2 + " for for Key: " + hVar);
        }
        try {
            a.d a3 = a().a(a2);
            if (a3 != null) {
                return a3.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.c.b.b.a
    public void a(com.bumptech.glide.c.h hVar, a.b bVar) {
        com.bumptech.glide.a.a a2;
        String a3 = this.f4727a.a(hVar);
        this.f4730d.a(a3);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a3 + " for for Key: " + hVar);
            }
            try {
                a2 = a();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
            if (a2.a(a3) != null) {
                return;
            }
            a.b b2 = a2.b(a3);
            if (b2 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + a3);
            }
            try {
                if (bVar.a(b2.a(0))) {
                    b2.a();
                }
                b2.c();
            } catch (Throwable th) {
                b2.c();
                throw th;
            }
        } finally {
            this.f4730d.b(a3);
        }
    }
}
