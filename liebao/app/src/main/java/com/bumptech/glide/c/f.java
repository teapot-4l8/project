package com.bumptech.glide.c;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ImageHeaderParser.java */
/* loaded from: classes.dex */
public interface f {
    int a(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar);

    a a(InputStream inputStream);

    a a(ByteBuffer byteBuffer);

    /* compiled from: ImageHeaderParser.java */
    /* loaded from: classes.dex */
    public enum a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean i;

        a(boolean z) {
            this.i = z;
        }

        public boolean a() {
            return this.i;
        }
    }
}
