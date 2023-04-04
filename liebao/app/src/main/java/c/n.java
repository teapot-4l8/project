package c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class n implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f3571a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final s f3572b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3573c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f3572b = sVar;
    }

    @Override // c.e
    public c c() {
        return this.f3571a;
    }

    @Override // c.s
    public long a(c cVar, long j) {
        if (cVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3573c) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f3571a.f3542b == 0 && this.f3572b.a(this.f3571a, 8192L) == -1) {
                    return -1L;
                }
                return this.f3571a.a(cVar, Math.min(j, this.f3571a.f3542b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // c.e
    public boolean f() {
        if (this.f3573c) {
            throw new IllegalStateException("closed");
        }
        return this.f3571a.f() && this.f3572b.a(this.f3571a, 8192L) == -1;
    }

    @Override // c.e
    public void a(long j) {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    @Override // c.e
    public boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f3573c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f3571a.f3542b < j) {
                if (this.f3572b.a(this.f3571a, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // c.e
    public byte i() {
        a(1L);
        return this.f3571a.i();
    }

    @Override // c.e
    public f d(long j) {
        a(j);
        return this.f3571a.d(j);
    }

    @Override // c.e
    public byte[] h(long j) {
        a(j);
        return this.f3571a.h(j);
    }

    @Override // c.e
    public void a(byte[] bArr) {
        try {
            a(bArr.length);
            this.f3571a.a(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (this.f3571a.f3542b > 0) {
                c cVar = this.f3571a;
                int a2 = cVar.a(bArr, i, (int) cVar.f3542b);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i += a2;
            }
            throw e2;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        if (this.f3571a.f3542b == 0 && this.f3572b.a(this.f3571a, 8192L) == -1) {
            return -1;
        }
        return this.f3571a.read(byteBuffer);
    }

    @Override // c.e
    public long a(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f3572b.a(this.f3571a, 8192L) != -1) {
            long h = this.f3571a.h();
            if (h > 0) {
                j += h;
                rVar.a_(this.f3571a, h);
            }
        }
        if (this.f3571a.b() > 0) {
            long b2 = j + this.f3571a.b();
            c cVar = this.f3571a;
            rVar.a_(cVar, cVar.b());
            return b2;
        }
        return j;
    }

    @Override // c.e
    public String a(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f3571a.a(this.f3572b);
        return this.f3571a.a(charset);
    }

    @Override // c.e
    public String r() {
        return f(Long.MAX_VALUE);
    }

    @Override // c.e
    public String f(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return this.f3571a.g(a2);
        }
        if (j2 < Long.MAX_VALUE && b(j2) && this.f3571a.c(j2 - 1) == 13 && b(1 + j2) && this.f3571a.c(j2) == 10) {
            return this.f3571a.g(j2);
        }
        c cVar = new c();
        c cVar2 = this.f3571a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f3571a.b(), j) + " content=" + cVar.p().f() + (char) 8230);
    }

    @Override // c.e
    public short j() {
        a(2L);
        return this.f3571a.j();
    }

    @Override // c.e
    public short l() {
        a(2L);
        return this.f3571a.l();
    }

    @Override // c.e
    public int k() {
        a(4L);
        return this.f3571a.k();
    }

    @Override // c.e
    public int m() {
        a(4L);
        return this.f3571a.m();
    }

    @Override // c.e
    public long n() {
        byte c2;
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            c2 = this.f3571a.c(i);
            if ((c2 < 48 || c2 > 57) && !(i == 0 && c2 == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(c2)));
        }
        return this.f3571a.n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long o() {
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            byte c2 = this.f3571a.c(i);
            if ((c2 < 48 || c2 > 57) && ((c2 < 97 || c2 > 102) && (c2 < 65 || c2 > 70))) {
                break;
            }
            i = i2;
        }
        return this.f3571a.o();
    }

    @Override // c.e
    public void i(long j) {
        if (this.f3573c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f3571a.f3542b == 0 && this.f3572b.a(this.f3571a, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f3571a.b());
            this.f3571a.i(min);
            j -= min;
        }
    }

    @Override // c.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        if (this.f3573c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a2 = this.f3571a.a(b2, j, j2);
            if (a2 == -1) {
                long j3 = this.f3571a.f3542b;
                if (j3 >= j2 || this.f3572b.a(this.f3571a, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return a2;
            }
        }
        return -1L;
    }

    @Override // c.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (this.f3573c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!b(1 + j2) || this.f3571a.c(j2) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // c.e
    public InputStream g() {
        return new InputStream() { // from class: c.n.1
            @Override // java.io.InputStream
            public int read() {
                if (n.this.f3573c) {
                    throw new IOException("closed");
                }
                if (n.this.f3571a.f3542b == 0 && n.this.f3572b.a(n.this.f3571a, 8192L) == -1) {
                    return -1;
                }
                return n.this.f3571a.i() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                if (n.this.f3573c) {
                    throw new IOException("closed");
                }
                u.a(bArr.length, i, i2);
                if (n.this.f3571a.f3542b == 0 && n.this.f3572b.a(n.this.f3571a, 8192L) == -1) {
                    return -1;
                }
                return n.this.f3571a.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                if (n.this.f3573c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(n.this.f3571a.f3542b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                n.this.close();
            }

            public String toString() {
                return n.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3573c;
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3573c) {
            return;
        }
        this.f3573c = true;
        this.f3572b.close();
        this.f3571a.u();
    }

    @Override // c.s
    public t a() {
        return this.f3572b.a();
    }

    public String toString() {
        return "buffer(" + this.f3572b + ")";
    }
}
