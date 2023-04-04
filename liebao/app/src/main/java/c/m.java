package c;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f3568a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final r f3569b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3570c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f3569b = rVar;
    }

    @Override // c.d, c.e
    public c c() {
        return this.f3568a;
    }

    @Override // c.r
    public void a_(c cVar, long j) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.a_(cVar, j);
        x();
    }

    @Override // c.d
    public d b(f fVar) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.b(fVar);
        return x();
    }

    @Override // c.d
    public d b(String str) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.b(str);
        return x();
    }

    @Override // c.d
    public d c(byte[] bArr) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.c(bArr);
        return x();
    }

    @Override // c.d
    public d c(byte[] bArr, int i, int i2) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.c(bArr, i, i2);
        return x();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        int write = this.f3568a.write(byteBuffer);
        x();
        return write;
    }

    @Override // c.d
    public long a(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = sVar.a(this.f3568a, 8192L);
            if (a2 == -1) {
                return j;
            }
            j += a2;
            x();
        }
    }

    @Override // c.d
    public d i(int i) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.i(i);
        return x();
    }

    @Override // c.d
    public d h(int i) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.h(i);
        return x();
    }

    @Override // c.d
    public d g(int i) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.g(i);
        return x();
    }

    @Override // c.d
    public d m(long j) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.m(j);
        return x();
    }

    @Override // c.d
    public d l(long j) {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        this.f3568a.l(j);
        return x();
    }

    @Override // c.d
    public d x() {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        long h = this.f3568a.h();
        if (h > 0) {
            this.f3569b.a_(this.f3568a, h);
        }
        return this;
    }

    @Override // c.d, c.r, java.io.Flushable
    public void flush() {
        if (this.f3570c) {
            throw new IllegalStateException("closed");
        }
        if (this.f3568a.f3542b > 0) {
            r rVar = this.f3569b;
            c cVar = this.f3568a;
            rVar.a_(cVar, cVar.f3542b);
        }
        this.f3569b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3570c;
    }

    @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3570c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f3568a.f3542b > 0) {
                this.f3569b.a_(this.f3568a, this.f3568a.f3542b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f3569b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f3570c = true;
        if (th != null) {
            u.a(th);
        }
    }

    @Override // c.r
    public t a() {
        return this.f3569b.a();
    }

    public String toString() {
        return "buffer(" + this.f3569b + ")";
    }
}
