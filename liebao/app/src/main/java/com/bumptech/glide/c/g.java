package com.bumptech.glide.c;

import com.bumptech.glide.c.d.a.r;
import com.bumptech.glide.c.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class g {
    public static f.a a(List<f> list, InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        if (inputStream == null) {
            return f.a.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new r(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                f.a a2 = list.get(i).a(inputStream);
                if (a2 != f.a.UNKNOWN) {
                    return a2;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return f.a.UNKNOWN;
    }

    public static f.a a(List<f> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return f.a.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            f.a a2 = list.get(i).a(byteBuffer);
            if (a2 != f.a.UNKNOWN) {
                return a2;
            }
        }
        return f.a.UNKNOWN;
    }

    public static int b(List<f> list, InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new r(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int a2 = list.get(i).a(inputStream, bVar);
                if (a2 != -1) {
                    return a2;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }
}
