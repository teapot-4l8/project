package com.bumptech.glide.c.d.a;

import android.media.ExifInterface;
import com.bumptech.glide.c.f;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ExifInterfaceImageHeaderParser.java */
/* loaded from: classes.dex */
public final class n implements com.bumptech.glide.c.f {
    @Override // com.bumptech.glide.c.f
    public f.a a(InputStream inputStream) {
        return f.a.UNKNOWN;
    }

    @Override // com.bumptech.glide.c.f
    public f.a a(ByteBuffer byteBuffer) {
        return f.a.UNKNOWN;
    }

    @Override // com.bumptech.glide.c.f
    public int a(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }
}
