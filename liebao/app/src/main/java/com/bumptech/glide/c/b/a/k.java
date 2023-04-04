package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f4701a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final l f4702b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Bitmap.Config> f4703c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4704d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4705e;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    k(long j, l lVar, Set<Bitmap.Config> set) {
        this.f4704d = j;
        this.f = j;
        this.f4702b = lVar;
        this.f4703c = set;
        this.f4705e = new b();
    }

    public k(long j) {
        this(j, f(), g());
    }

    public long b() {
        return this.f;
    }

    @Override // com.bumptech.glide.c.b.a.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f4702b.c(bitmap) <= this.f && this.f4703c.contains(bitmap.getConfig())) {
                int c2 = this.f4702b.c(bitmap);
                this.f4702b.a(bitmap);
                this.f4705e.a(bitmap);
                this.j++;
                this.g += c2;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f4702b.b(bitmap));
                }
                d();
                c();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f4702b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f4703c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c() {
        a(this.f);
    }

    @Override // com.bumptech.glide.c.b.a.e
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap d2 = d(i, i2, config);
        if (d2 != null) {
            d2.eraseColor(0);
            return d2;
        }
        return c(i, i2, config);
    }

    @Override // com.bumptech.glide.c.b.a.e
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap d2 = d(i, i2, config);
        return d2 == null ? c(i, i2, config) : d2;
    }

    private static Bitmap c(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = f4701a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private synchronized Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f4702b.a(i, i2, config != null ? config : f4701a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f4702b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.f4702b.c(a2);
            this.f4705e.b(a2);
            b(a2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f4702b.b(i, i2, config));
        }
        d();
        return a2;
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Override // com.bumptech.glide.c.b.a.e
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0L);
    }

    @Override // com.bumptech.glide.c.b.a.e
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    private synchronized void a(long j) {
        while (this.g > j) {
            Bitmap a2 = this.f4702b.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    e();
                }
                this.g = 0L;
                return;
            }
            this.f4705e.b(a2);
            this.g -= this.f4702b.c(a2);
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f4702b.b(a2));
            }
            d();
            a2.recycle();
        }
    }

    private void d() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            e();
        }
    }

    private void e() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.f4702b);
    }

    private static l f() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new c();
    }

    private static Set<Bitmap.Config> g() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    private static final class b implements a {
        @Override // com.bumptech.glide.c.b.a.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.c.b.a.k.a
        public void b(Bitmap bitmap) {
        }

        b() {
        }
    }
}
