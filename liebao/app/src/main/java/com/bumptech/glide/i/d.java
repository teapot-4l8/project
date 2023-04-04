package com.bumptech.glide.i;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<d> f5246a = j.a(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f5247b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f5248c;

    public static d a(InputStream inputStream) {
        d poll;
        synchronized (f5246a) {
            poll = f5246a.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    d() {
    }

    void b(InputStream inputStream) {
        this.f5247b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f5247b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5247b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f5247b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5247b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f5247b.read(bArr);
        } catch (IOException e2) {
            this.f5248c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f5247b.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f5248c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f5247b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f5247b.skip(j);
        } catch (IOException e2) {
            this.f5248c = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f5247b.read();
        } catch (IOException e2) {
            this.f5248c = e2;
            return -1;
        }
    }

    public IOException a() {
        return this.f5248c;
    }

    public void b() {
        this.f5248c = null;
        this.f5247b = null;
        synchronized (f5246a) {
            f5246a.offer(this);
        }
    }
}
