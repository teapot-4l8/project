package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f4590a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f4591b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f4592c;

    /* renamed from: d  reason: collision with root package name */
    private int f4593d;

    /* renamed from: e  reason: collision with root package name */
    private int f4594e;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f4596a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4590a = inputStream;
        this.f4591b = charset;
        this.f4592c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4590a) {
            if (this.f4592c != null) {
                this.f4592c = null;
                this.f4590a.close();
            }
        }
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f4590a) {
            if (this.f4592c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f4593d >= this.f4594e) {
                c();
            }
            for (int i3 = this.f4593d; i3 != this.f4594e; i3++) {
                if (this.f4592c[i3] == 10) {
                    if (i3 != this.f4593d) {
                        i2 = i3 - 1;
                        if (this.f4592c[i2] == 13) {
                            String str = new String(this.f4592c, this.f4593d, i2 - this.f4593d, this.f4591b.name());
                            this.f4593d = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(this.f4592c, this.f4593d, i2 - this.f4593d, this.f4591b.name());
                    this.f4593d = i3 + 1;
                    return str2;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f4594e - this.f4593d) + 80) { // from class: com.bumptech.glide.a.b.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, b.this.f4591b.name());
                    } catch (UnsupportedEncodingException e2) {
                        throw new AssertionError(e2);
                    }
                }
            };
            loop1: while (true) {
                byteArrayOutputStream.write(this.f4592c, this.f4593d, this.f4594e - this.f4593d);
                this.f4594e = -1;
                c();
                i = this.f4593d;
                while (i != this.f4594e) {
                    if (this.f4592c[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f4593d) {
                byteArrayOutputStream.write(this.f4592c, this.f4593d, i - this.f4593d);
            }
            this.f4593d = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public boolean b() {
        return this.f4594e == -1;
    }

    private void c() {
        InputStream inputStream = this.f4590a;
        byte[] bArr = this.f4592c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f4593d = 0;
        this.f4594e = read;
    }
}
