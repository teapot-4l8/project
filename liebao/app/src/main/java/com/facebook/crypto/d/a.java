package com.facebook.crypto.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: FixedSizeByteArrayOutputStream.java */
/* loaded from: classes.dex */
public class a extends ByteArrayOutputStream {
    public a(int i) {
        super(i);
    }

    public byte[] a() {
        if (this.buf.length != this.count) {
            throw new IOException("Size supplied is too small");
        }
        return this.buf;
    }
}
