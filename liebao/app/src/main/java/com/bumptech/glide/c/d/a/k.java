package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.c.d.a.j;
import com.bumptech.glide.c.f;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<com.bumptech.glide.c.b> f5009a = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.c.b.f4668c);
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<j> f5010b = j.h;

    /* renamed from: c  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<Boolean> f5011c = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: d  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<Boolean> f5012d = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f5013e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    private static final a f = new a() { // from class: com.bumptech.glide.c.d.a.k.1
        @Override // com.bumptech.glide.c.d.a.k.a
        public void a() {
        }

        @Override // com.bumptech.glide.c.d.a.k.a
        public void a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap) {
        }
    };
    private static final Set<f.a> g = Collections.unmodifiableSet(EnumSet.of(f.a.JPEG, f.a.PNG_A, f.a.PNG));
    private static final Queue<BitmapFactory.Options> h = com.bumptech.glide.i.j.a(0);
    private final com.bumptech.glide.c.b.a.e i;
    private final DisplayMetrics j;
    private final com.bumptech.glide.c.b.a.b k;
    private final List<com.bumptech.glide.c.f> l;
    private final p m = p.a();

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    public k(List<com.bumptech.glide.c.f> list, DisplayMetrics displayMetrics, com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.c.b.a.b bVar) {
        this.l = list;
        this.j = (DisplayMetrics) com.bumptech.glide.i.i.a(displayMetrics);
        this.i = (com.bumptech.glide.c.b.a.e) com.bumptech.glide.i.i.a(eVar);
        this.k = (com.bumptech.glide.c.b.a.b) com.bumptech.glide.i.i.a(bVar);
    }

    public com.bumptech.glide.c.b.u<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.c.j jVar) {
        return a(inputStream, i, i2, jVar, f);
    }

    public com.bumptech.glide.c.b.u<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.c.j jVar, a aVar) {
        com.bumptech.glide.i.i.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.k.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        com.bumptech.glide.c.b bVar = (com.bumptech.glide.c.b) jVar.a(f5009a);
        try {
            return d.a(a(inputStream, a2, (j) jVar.a(j.h), bVar, jVar.a(f5012d) != null && ((Boolean) jVar.a(f5012d)).booleanValue(), i, i2, ((Boolean) jVar.a(f5011c)).booleanValue(), aVar), this.i);
        } finally {
            c(a2);
            this.k.a((com.bumptech.glide.c.b.a.b) bArr);
        }
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, j jVar, com.bumptech.glide.c.b bVar, boolean z, int i, int i2, boolean z2, a aVar) {
        k kVar;
        int round;
        int round2;
        int i3;
        long a2 = com.bumptech.glide.i.e.a();
        int[] a3 = a(inputStream, options, aVar, this.i);
        int i4 = a3[0];
        int i5 = a3[1];
        String str = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int b2 = com.bumptech.glide.c.g.b(this.l, inputStream, this.k);
        int a4 = u.a(b2);
        boolean b3 = u.b(b2);
        int i6 = i == Integer.MIN_VALUE ? i4 : i;
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        f.a a5 = com.bumptech.glide.c.g.a(this.l, inputStream, this.k);
        a(a5, inputStream, aVar, this.i, jVar, a4, i4, i5, i6, i7, options);
        a(inputStream, bVar, z3, b3, options, i6, i7);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            kVar = this;
            if (kVar.a(a5)) {
                if (i4 < 0 || i5 < 0 || !z2 || !z4) {
                    float f2 = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i8 = options.inSampleSize;
                    float f3 = i8;
                    round = Math.round(((int) Math.ceil(i4 / f3)) * f2);
                    round2 = Math.round(((int) Math.ceil(i5 / f3)) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    round = i6;
                    round2 = i7;
                }
                if (round > 0 && round2 > 0) {
                    a(options, kVar.i, round, round2);
                }
            }
        } else {
            kVar = this;
        }
        Bitmap b4 = b(inputStream, options, aVar, kVar.i);
        aVar.a(kVar.i, b4);
        if (Log.isLoggable("Downsampler", 2)) {
            i3 = b2;
            a(i4, i5, str, options, b4, i, i2, a2);
        } else {
            i3 = b2;
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(kVar.j.densityDpi);
            bitmap = u.a(kVar.i, b4, i3);
            if (!b4.equals(bitmap)) {
                kVar.i.a(b4);
            }
        }
        return bitmap;
    }

    private static void a(f.a aVar, InputStream inputStream, a aVar2, com.bumptech.glide.c.b.a.e eVar, j jVar, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        float a2;
        int min;
        int max;
        int floor;
        double floor2;
        int i6;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + aVar + " with target [" + i4 + "x" + i5 + "]");
                return;
            }
            return;
        }
        if (i == 90 || i == 270) {
            a2 = jVar.a(i3, i2, i4, i5);
        } else {
            a2 = jVar.a(i2, i3, i4, i5);
        }
        if (a2 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + jVar + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        j.g b2 = jVar.b(i2, i3, i4, i5);
        if (b2 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i2;
        float f3 = i3;
        int c2 = i2 / c(a2 * f2);
        int c3 = i3 / c(a2 * f3);
        if (b2 == j.g.MEMORY) {
            min = Math.max(c2, c3);
        } else {
            min = Math.min(c2, c3);
        }
        if (Build.VERSION.SDK_INT > 23 || !f5013e.contains(options.outMimeType)) {
            max = Math.max(1, Integer.highestOneBit(min));
            if (b2 == j.g.MEMORY && max < 1.0f / a2) {
                max <<= 1;
            }
        } else {
            max = 1;
        }
        options.inSampleSize = max;
        if (aVar == f.a.JPEG) {
            float min2 = Math.min(max, 8);
            floor = (int) Math.ceil(f2 / min2);
            i6 = (int) Math.ceil(f3 / min2);
            int i7 = max / 8;
            if (i7 > 0) {
                floor /= i7;
                i6 /= i7;
            }
        } else {
            if (aVar == f.a.PNG || aVar == f.a.PNG_A) {
                float f4 = max;
                floor = (int) Math.floor(f2 / f4);
                floor2 = Math.floor(f3 / f4);
            } else if (aVar == f.a.WEBP || aVar == f.a.WEBP_A) {
                if (Build.VERSION.SDK_INT >= 24) {
                    float f5 = max;
                    floor = Math.round(f2 / f5);
                    i6 = Math.round(f3 / f5);
                } else {
                    float f6 = max;
                    floor = (int) Math.floor(f2 / f6);
                    floor2 = Math.floor(f3 / f6);
                }
            } else if (i2 % max != 0 || i3 % max != 0) {
                int[] a3 = a(inputStream, options, aVar2, eVar);
                int i8 = a3[0];
                i6 = a3[1];
                floor = i8;
            } else {
                floor = i2 / max;
                i6 = i3 / max;
            }
            i6 = (int) floor2;
        }
        double a4 = jVar.a(floor, i6, i4, i5);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = a(a4);
            options.inDensity = b(a4);
        }
        if (a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + i6 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private static int a(double d2) {
        int b2 = b(d2);
        double d3 = b2;
        Double.isNaN(d3);
        int c2 = c(d3 * d2);
        double d4 = c2 / b2;
        Double.isNaN(d4);
        double d5 = c2;
        Double.isNaN(d5);
        return c((d2 / d4) * d5);
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private boolean a(f.a aVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return g.contains(aVar);
    }

    private void a(InputStream inputStream, com.bumptech.glide.c.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.m.a(i, i2, options, bVar, z, z2)) {
            return;
        }
        if (bVar == com.bumptech.glide.c.b.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean z3 = false;
        try {
            z3 = com.bumptech.glide.c.g.a(this.l, inputStream, this.k).a();
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
            }
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, com.bumptech.glide.c.b.a.e eVar) {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static Bitmap b(InputStream inputStream, BitmapFactory.Options options, a aVar, com.bumptech.glide.c.b.a.e eVar) {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            aVar.a();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        u.a().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                u.a().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e2) {
                IOException a2 = a(e2, i, i2, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        eVar.a(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap b2 = b(inputStream, options, aVar, eVar);
                        u.a().unlock();
                        return b2;
                    } catch (IOException unused) {
                        throw a2;
                    }
                }
                throw a2;
            }
        } catch (Throwable th) {
            u.a().unlock();
            throw th;
        }
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + b(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.i.e.a(j));
    }

    private static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    private static void a(BitmapFactory.Options options, com.bumptech.glide.c.b.a.e eVar, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i, i2, config);
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (k.class) {
            synchronized (h) {
                poll = h.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (h) {
            h.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
