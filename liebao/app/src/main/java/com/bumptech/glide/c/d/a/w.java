package com.bumptech.glide.c.d.a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class w<T> implements com.bumptech.glide.c.k<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<Long> f5041a = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new i.a<Long>() { // from class: com.bumptech.glide.c.d.a.w.1

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f5046a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.c.i.a
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f5046a) {
                this.f5046a.position(0);
                messageDigest.update(this.f5046a.putLong(l.longValue()).array());
            }
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.c.i<Integer> f5042b = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new i.a<Integer>() { // from class: com.bumptech.glide.c.d.a.w.2

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f5047a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.c.i.a
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f5047a) {
                this.f5047a.position(0);
                messageDigest.update(this.f5047a.putInt(num.intValue()).array());
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final b f5043c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final c<T> f5044d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f5045e;
    private final b f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(T t, com.bumptech.glide.c.j jVar) {
        return true;
    }

    public static com.bumptech.glide.c.k<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.c.b.a.e eVar) {
        return new w(eVar, new a());
    }

    public static com.bumptech.glide.c.k<ParcelFileDescriptor, Bitmap> b(com.bumptech.glide.c.b.a.e eVar) {
        return new w(eVar, new d());
    }

    w(com.bumptech.glide.c.b.a.e eVar, c<T> cVar) {
        this(eVar, cVar, f5043c);
    }

    w(com.bumptech.glide.c.b.a.e eVar, c<T> cVar, b bVar) {
        this.f5045e = eVar;
        this.f5044d = cVar;
        this.f = bVar;
    }

    @Override // com.bumptech.glide.c.k
    public com.bumptech.glide.c.b.u<Bitmap> a(T t, int i, int i2, com.bumptech.glide.c.j jVar) {
        long longValue = ((Long) jVar.a(f5041a)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) jVar.a(f5042b);
        if (num == null) {
            num = 2;
        }
        j jVar2 = (j) jVar.a(j.h);
        if (jVar2 == null) {
            jVar2 = j.g;
        }
        j jVar3 = jVar2;
        MediaMetadataRetriever a2 = this.f.a();
        try {
            try {
                this.f5044d.a(a2, t);
                Bitmap a3 = a(a2, longValue, num.intValue(), i, i2, jVar3);
                a2.release();
                return com.bumptech.glide.c.d.a.d.a(a3, this.f5045e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, j jVar) {
        Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || jVar == j.f) ? null : b(mediaMetadataRetriever, j, i, i2, i3, jVar);
        return b2 == null ? a(mediaMetadataRetriever, j, i) : b2;
    }

    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, j jVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float a2 = jVar.a(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * a2), Math.round(a2 * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
                return null;
            }
            return null;
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        @Override // com.bumptech.glide.c.d.a.w.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        @Override // com.bumptech.glide.c.d.a.w.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }
}
