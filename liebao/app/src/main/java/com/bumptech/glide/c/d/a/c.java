package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.c.l<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<Integer> f4988a = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<Bitmap.CompressFormat> f4989b = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f4990c;

    public c(com.bumptech.glide.c.b.a.b bVar) {
        this.f4990c = bVar;
    }

    @Deprecated
    public c() {
        this.f4990c = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r6 != null) goto L14;
     */
    @Override // com.bumptech.glide.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.bumptech.glide.c.b.u<Bitmap> uVar, File file, com.bumptech.glide.c.j jVar) {
        Bitmap d2 = uVar.d();
        Bitmap.CompressFormat a2 = a(d2, jVar);
        com.bumptech.glide.i.a.b.a("encode: [%dx%d] %s", Integer.valueOf(d2.getWidth()), Integer.valueOf(d2.getHeight()), a2);
        try {
            long a3 = com.bumptech.glide.i.e.a();
            int intValue = ((Integer) jVar.a(f4988a)).intValue();
            boolean z = false;
            com.bumptech.glide.c.a.c cVar = null;
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        cVar = this.f4990c != null ? new com.bumptech.glide.c.a.c(fileOutputStream, this.f4990c) : fileOutputStream;
                        d2.compress(a2, intValue, cVar);
                        cVar.close();
                        z = true;
                    } catch (IOException e2) {
                        e = e2;
                        cVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cVar = fileOutputStream;
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
            try {
                cVar.close();
            } catch (IOException unused2) {
                if (Log.isLoggable("BitmapEncoder", 2)) {
                    Log.v("BitmapEncoder", "Compressed with type: " + a2 + " of size " + com.bumptech.glide.i.j.a(d2) + " in " + com.bumptech.glide.i.e.a(a3) + ", options format: " + jVar.a(f4989b) + ", hasAlpha: " + d2.hasAlpha());
                }
                return z;
            }
        } finally {
            com.bumptech.glide.i.a.b.a();
        }
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.bumptech.glide.c.j jVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) jVar.a(f4989b);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.c.l
    public com.bumptech.glide.c.c a(com.bumptech.glide.c.j jVar) {
        return com.bumptech.glide.c.c.TRANSFORMED;
    }
}
