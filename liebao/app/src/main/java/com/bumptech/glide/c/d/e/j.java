package com.bumptech.glide.c.d.e;

import android.util.Log;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class j implements k<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.bumptech.glide.c.f> f5082a;

    /* renamed from: b  reason: collision with root package name */
    private final k<ByteBuffer, c> f5083b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f5084c;

    public j(List<com.bumptech.glide.c.f> list, k<ByteBuffer, c> kVar, com.bumptech.glide.c.b.a.b bVar) {
        this.f5082a = list;
        this.f5083b = kVar;
        this.f5084c = bVar;
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(InputStream inputStream, com.bumptech.glide.c.j jVar) {
        return !((Boolean) jVar.a(i.f5081b)).booleanValue() && com.bumptech.glide.c.g.a(this.f5082a, inputStream, this.f5084c) == f.a.GIF;
    }

    @Override // com.bumptech.glide.c.k
    public u<c> a(InputStream inputStream, int i, int i2, com.bumptech.glide.c.j jVar) {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f5083b.a(ByteBuffer.wrap(a2), i, i2, jVar);
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e2);
                return null;
            }
            return null;
        }
    }
}
