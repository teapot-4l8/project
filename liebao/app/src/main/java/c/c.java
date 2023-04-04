package c;

import com.umeng.analytics.pro.bz;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements d, e, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f3540c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    o f3541a;

    /* renamed from: b  reason: collision with root package name */
    long f3542b;

    @Override // c.d, c.e
    public c c() {
        return this;
    }

    @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // c.d
    /* renamed from: e */
    public c x() {
        return this;
    }

    @Override // c.d, c.r, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long b() {
        return this.f3542b;
    }

    public OutputStream d() {
        return new OutputStream() { // from class: c.c.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                c.this.i((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }

            public String toString() {
                return c.this + ".outputStream()";
            }
        };
    }

    @Override // c.e
    public boolean f() {
        return this.f3542b == 0;
    }

    @Override // c.e
    public void a(long j) {
        if (this.f3542b < j) {
            throw new EOFException();
        }
    }

    @Override // c.e
    public boolean b(long j) {
        return this.f3542b >= j;
    }

    @Override // c.e
    public InputStream g() {
        return new InputStream() { // from class: c.c.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (c.this.f3542b > 0) {
                    return c.this.i() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f3542b, 2147483647L);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.f3542b, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.f3542b += j2;
        o oVar = this.f3541a;
        while (j >= oVar.f3577c - oVar.f3576b) {
            j -= oVar.f3577c - oVar.f3576b;
            oVar = oVar.f;
        }
        while (j2 > 0) {
            o a2 = oVar.a();
            a2.f3576b = (int) (a2.f3576b + j);
            a2.f3577c = Math.min(a2.f3576b + ((int) j2), a2.f3577c);
            o oVar2 = cVar.f3541a;
            if (oVar2 == null) {
                a2.g = a2;
                a2.f = a2;
                cVar.f3541a = a2;
            } else {
                oVar2.g.a(a2);
            }
            j2 -= a2.f3577c - a2.f3576b;
            oVar = oVar.f;
            j = 0;
        }
        return this;
    }

    public final long h() {
        long j = this.f3542b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.f3541a.g;
        return (oVar.f3577c >= 8192 || !oVar.f3579e) ? j : j - (oVar.f3577c - oVar.f3576b);
    }

    @Override // c.e
    public byte i() {
        if (this.f3542b == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f3541a;
        int i = oVar.f3576b;
        int i2 = oVar.f3577c;
        int i3 = i + 1;
        byte b2 = oVar.f3575a[i];
        this.f3542b--;
        if (i3 == i2) {
            this.f3541a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f3576b = i3;
        }
        return b2;
    }

    public final byte c(long j) {
        u.a(this.f3542b, j, 1L);
        long j2 = this.f3542b;
        if (j2 - j > j) {
            o oVar = this.f3541a;
            while (true) {
                long j3 = oVar.f3577c - oVar.f3576b;
                if (j >= j3) {
                    j -= j3;
                    oVar = oVar.f;
                } else {
                    return oVar.f3575a[oVar.f3576b + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            o oVar2 = this.f3541a;
            do {
                oVar2 = oVar2.g;
                j4 += oVar2.f3577c - oVar2.f3576b;
            } while (j4 < 0);
            return oVar2.f3575a[oVar2.f3576b + ((int) j4)];
        }
    }

    @Override // c.e
    public short j() {
        if (this.f3542b < 2) {
            throw new IllegalStateException("size < 2: " + this.f3542b);
        }
        o oVar = this.f3541a;
        int i = oVar.f3576b;
        int i2 = oVar.f3577c;
        if (i2 - i < 2) {
            return (short) (((i() & 255) << 8) | (i() & 255));
        }
        byte[] bArr = oVar.f3575a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f3542b -= 2;
        if (i4 == i2) {
            this.f3541a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f3576b = i4;
        }
        return (short) i5;
    }

    @Override // c.e
    public int k() {
        if (this.f3542b < 4) {
            throw new IllegalStateException("size < 4: " + this.f3542b);
        }
        o oVar = this.f3541a;
        int i = oVar.f3576b;
        int i2 = oVar.f3577c;
        if (i2 - i < 4) {
            return ((i() & 255) << 24) | ((i() & 255) << 16) | ((i() & 255) << 8) | (i() & 255);
        }
        byte[] bArr = oVar.f3575a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f3542b -= 4;
        if (i8 == i2) {
            this.f3541a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f3576b = i8;
        }
        return i9;
    }

    @Override // c.e
    public short l() {
        return u.a(j());
    }

    @Override // c.e
    public int m() {
        return u.a(k());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[EDGE_INSN: B:47:0x00ad->B:39:0x00ad ?: BREAK  , SYNTHETIC] */
    @Override // c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long n() {
        long j = 0;
        if (this.f3542b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j2 = -7;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        do {
            o oVar = this.f3541a;
            byte[] bArr = oVar.f3575a;
            int i2 = oVar.f3576b;
            int i3 = oVar.f3577c;
            while (i2 < i3) {
                byte b2 = bArr[i2];
                if (b2 >= 48 && b2 <= 57) {
                    int i4 = 48 - b2;
                    if (j < -922337203685477580L || (j == -922337203685477580L && i4 < j2)) {
                        c i5 = new c().m(j).i((int) b2);
                        if (!z) {
                            i5.i();
                        }
                        throw new NumberFormatException("Number too large: " + i5.q());
                    }
                    j = (j * 10) + i4;
                } else if (b2 == 45 && i == 0) {
                    j2--;
                    z = true;
                } else if (i == 0) {
                    throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b2));
                } else {
                    z2 = true;
                    if (i2 != i3) {
                        this.f3541a = oVar.b();
                        p.a(oVar);
                    } else {
                        oVar.f3576b = i2;
                    }
                    if (!z2) {
                        break;
                    }
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
            }
            if (!z2) {
            }
        } while (this.f3541a != null);
        this.f3542b -= i;
        return z ? j : -j;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long o() {
        int i;
        int i2;
        if (this.f3542b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        long j = 0;
        boolean z = false;
        do {
            o oVar = this.f3541a;
            byte[] bArr = oVar.f3575a;
            int i4 = oVar.f3576b;
            int i5 = oVar.f3577c;
            while (i4 < i5) {
                byte b2 = bArr[i4];
                if (b2 < 48 || b2 > 57) {
                    if (b2 >= 97 && b2 <= 102) {
                        i = b2 - 97;
                    } else if (b2 >= 65 && b2 <= 70) {
                        i = b2 - 65;
                    } else if (i3 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                    } else {
                        z = true;
                        if (i4 != i5) {
                            this.f3541a = oVar.b();
                            p.a(oVar);
                        } else {
                            oVar.f3576b = i4;
                        }
                        if (!z) {
                            break;
                        }
                    }
                    i2 = i + 10;
                } else {
                    i2 = b2 - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    c i6 = new c().l(j).i((int) b2);
                    throw new NumberFormatException("Number too large: " + i6.q());
                }
                j = (j << 4) | i2;
                i4++;
                i3++;
            }
            if (i4 != i5) {
            }
            if (!z) {
            }
        } while (this.f3541a != null);
        this.f3542b -= i3;
        return j;
    }

    public f p() {
        return new f(t());
    }

    @Override // c.e
    public f d(long j) {
        return new f(h(j));
    }

    @Override // c.e
    public long a(r rVar) {
        long j = this.f3542b;
        if (j > 0) {
            rVar.a_(this, j);
        }
        return j;
    }

    public String q() {
        try {
            return a(this.f3542b, u.f3586a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String e(long j) {
        return a(j, u.f3586a);
    }

    @Override // c.e
    public String a(Charset charset) {
        try {
            return a(this.f3542b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j, Charset charset) {
        u.a(this.f3542b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                o oVar = this.f3541a;
                if (oVar.f3576b + j > oVar.f3577c) {
                    return new String(h(j), charset);
                }
                String str = new String(oVar.f3575a, oVar.f3576b, (int) j, charset);
                oVar.f3576b = (int) (oVar.f3576b + j);
                this.f3542b -= j;
                if (oVar.f3576b == oVar.f3577c) {
                    this.f3541a = oVar.b();
                    p.a(oVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
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
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return g(a2);
        }
        if (j2 < b() && c(j2 - 1) == 13 && c(j2) == 10) {
            return g(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.p().f() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (c(j2) == 13) {
                String e2 = e(j2);
                i(2L);
                return e2;
            }
        }
        String e3 = e(j);
        i(1L);
        return e3;
    }

    public int s() {
        int i;
        int i2;
        int i3;
        if (this.f3542b == 0) {
            throw new EOFException();
        }
        byte c2 = c(0L);
        if ((c2 & 128) == 0) {
            i = c2 & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((c2 & 224) == 192) {
            i = c2 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((c2 & 240) == 224) {
            i = c2 & bz.m;
            i2 = 3;
            i3 = 2048;
        } else if ((c2 & 248) != 240) {
            i(1L);
            return 65533;
        } else {
            i = c2 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.f3542b < j) {
            throw new EOFException("size < " + i2 + ": " + this.f3542b + " (to read code point prefixed 0x" + Integer.toHexString(c2) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte c3 = c(j2);
            if ((c3 & 192) != 128) {
                i(j2);
                return 65533;
            }
            i = (i << 6) | (c3 & 63);
        }
        i(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    public byte[] t() {
        try {
            return h(this.f3542b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.e
    public byte[] h(long j) {
        u.a(this.f3542b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // c.e
    public void a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        u.a(bArr.length, i, i2);
        o oVar = this.f3541a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.f3577c - oVar.f3576b);
        System.arraycopy(oVar.f3575a, oVar.f3576b, bArr, i, min);
        oVar.f3576b += min;
        this.f3542b -= min;
        if (oVar.f3576b == oVar.f3577c) {
            this.f3541a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        o oVar = this.f3541a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f3577c - oVar.f3576b);
        byteBuffer.put(oVar.f3575a, oVar.f3576b, min);
        oVar.f3576b += min;
        this.f3542b -= min;
        if (oVar.f3576b == oVar.f3577c) {
            this.f3541a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public final void u() {
        try {
            i(this.f3542b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.e
    public void i(long j) {
        o oVar;
        while (j > 0) {
            if (this.f3541a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, oVar.f3577c - this.f3541a.f3576b);
            long j2 = min;
            this.f3542b -= j2;
            j -= j2;
            this.f3541a.f3576b += min;
            if (this.f3541a.f3576b == this.f3541a.f3577c) {
                o oVar2 = this.f3541a;
                this.f3541a = oVar2.b();
                p.a(oVar2);
            }
        }
    }

    @Override // c.d
    /* renamed from: a */
    public c b(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    @Override // c.d
    /* renamed from: a */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        o e2 = e(1);
                        byte[] bArr = e2.f3575a;
                        int i3 = e2.f3577c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = (i3 + i4) - e2.f3577c;
                        e2.f3577c += i5;
                        this.f3542b += i5;
                        i = i4;
                    } else {
                        if (charAt < 2048) {
                            i((charAt >> 6) | 192);
                            i((charAt & '?') | 128);
                        } else if (charAt < 55296 || charAt > 57343) {
                            i((charAt >> '\f') | 224);
                            i(((charAt >> 6) & 63) | 128);
                            i((charAt & '?') | 128);
                        } else {
                            int i6 = i + 1;
                            char charAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                i(63);
                                i = i6;
                            } else {
                                int i7 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                i((i7 >> 18) | 240);
                                i(((i7 >> 12) & 63) | 128);
                                i(((i7 >> 6) & 63) | 128);
                                i((i7 & 63) | 128);
                                i += 2;
                            }
                        }
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public c a(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | 192);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                i(63);
            } else {
                i((i >> 12) | 224);
                i(((i >> 6) & 63) | 128);
                i((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            i((i >> 18) | 240);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 <= str.length()) {
                if (charset == null) {
                    throw new IllegalArgumentException("charset == null");
                }
                if (charset.equals(u.f3586a)) {
                    return a(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return c(bytes, 0, bytes.length);
            } else {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // c.d
    /* renamed from: b */
    public c c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    @Override // c.d
    /* renamed from: b */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        u.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            o e2 = e(1);
            int min = Math.min(i3 - i, 8192 - e2.f3577c);
            System.arraycopy(bArr, i, e2.f3575a, e2.f3577c, min);
            i += min;
            e2.f3577c += min;
        }
        this.f3542b += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            o e2 = e(1);
            int min = Math.min(i, 8192 - e2.f3577c);
            byteBuffer.get(e2.f3575a, e2.f3577c, min);
            i -= min;
            e2.f3577c += min;
        }
        this.f3542b += remaining;
        return remaining;
    }

    @Override // c.d
    public long a(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = sVar.a(this, 8192L);
            if (a2 == -1) {
                return j;
            }
            j += a2;
        }
    }

    @Override // c.d
    /* renamed from: b */
    public c i(int i) {
        o e2 = e(1);
        byte[] bArr = e2.f3575a;
        int i2 = e2.f3577c;
        e2.f3577c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f3542b++;
        return this;
    }

    @Override // c.d
    /* renamed from: c */
    public c h(int i) {
        o e2 = e(2);
        byte[] bArr = e2.f3575a;
        int i2 = e2.f3577c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        e2.f3577c = i3 + 1;
        this.f3542b += 2;
        return this;
    }

    @Override // c.d
    /* renamed from: d */
    public c g(int i) {
        o e2 = e(4);
        byte[] bArr = e2.f3575a;
        int i2 = e2.f3577c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        e2.f3577c = i5 + 1;
        this.f3542b += 4;
        return this;
    }

    @Override // c.d
    /* renamed from: j */
    public c m(long j) {
        if (j == 0) {
            return i(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        o e2 = e(i);
        byte[] bArr = e2.f3575a;
        int i2 = e2.f3577c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f3540c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        e2.f3577c += i;
        this.f3542b += i;
        return this;
    }

    @Override // c.d
    /* renamed from: k */
    public c l(long j) {
        if (j == 0) {
            return i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o e2 = e(numberOfTrailingZeros);
        byte[] bArr = e2.f3575a;
        int i = e2.f3577c;
        for (int i2 = (e2.f3577c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f3540c[(int) (15 & j)];
            j >>>= 4;
        }
        e2.f3577c += numberOfTrailingZeros;
        this.f3542b += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.f3541a;
        if (oVar == null) {
            o a2 = p.a();
            this.f3541a = a2;
            a2.g = a2;
            a2.f = a2;
            return a2;
        }
        o oVar2 = oVar.g;
        return (oVar2.f3577c + i > 8192 || !oVar2.f3579e) ? oVar2.a(p.a()) : oVar2;
    }

    @Override // c.r
    public void a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.f3542b, 0L, j);
        while (j > 0) {
            if (j < cVar.f3541a.f3577c - cVar.f3541a.f3576b) {
                o oVar = this.f3541a;
                o oVar2 = oVar != null ? oVar.g : null;
                if (oVar2 != null && oVar2.f3579e) {
                    if ((oVar2.f3577c + j) - (oVar2.f3578d ? 0 : oVar2.f3576b) <= 8192) {
                        cVar.f3541a.a(oVar2, (int) j);
                        cVar.f3542b -= j;
                        this.f3542b += j;
                        return;
                    }
                }
                cVar.f3541a = cVar.f3541a.a((int) j);
            }
            o oVar3 = cVar.f3541a;
            long j2 = oVar3.f3577c - oVar3.f3576b;
            cVar.f3541a = oVar3.b();
            o oVar4 = this.f3541a;
            if (oVar4 == null) {
                this.f3541a = oVar3;
                oVar3.g = oVar3;
                oVar3.f = oVar3;
            } else {
                oVar4.g.a(oVar3).c();
            }
            cVar.f3542b -= j2;
            this.f3542b += j2;
            j -= j2;
        }
    }

    @Override // c.s
    public long a(c cVar, long j) {
        if (cVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.f3542b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // c.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        o oVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f3542b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.f3542b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (oVar = this.f3541a) == null) {
            return -1L;
        }
        long j5 = this.f3542b;
        if (j5 - j < j) {
            while (j5 > j) {
                oVar = oVar.g;
                j5 -= oVar.f3577c - oVar.f3576b;
            }
        } else {
            while (true) {
                long j6 = (oVar.f3577c - oVar.f3576b) + j3;
                if (j6 >= j) {
                    break;
                }
                oVar = oVar.f;
                j3 = j6;
            }
            j5 = j3;
        }
        long j7 = j;
        while (j5 < j4) {
            byte[] bArr = oVar.f3575a;
            int min = (int) Math.min(oVar.f3577c, (oVar.f3576b + j4) - j5);
            for (int i = (int) ((oVar.f3576b + j7) - j5); i < min; i++) {
                if (bArr[i] == b2) {
                    return (i - oVar.f3576b) + j5;
                }
            }
            j5 += oVar.f3577c - oVar.f3576b;
            oVar = oVar.f;
            j7 = j5;
        }
        return -1L;
    }

    @Override // c.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f3542b - j < i2 || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (c(i3 + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // c.r
    public t a() {
        return t.f3582c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j = this.f3542b;
            if (j != cVar.f3542b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            o oVar = this.f3541a;
            o oVar2 = cVar.f3541a;
            int i = oVar.f3576b;
            int i2 = oVar2.f3576b;
            while (j2 < this.f3542b) {
                long min = Math.min(oVar.f3577c - i, oVar2.f3577c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (oVar.f3575a[i] != oVar2.f3575a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == oVar.f3577c) {
                    oVar = oVar.f;
                    i = oVar.f3576b;
                }
                if (i2 == oVar2.f3577c) {
                    oVar2 = oVar2.f;
                    i2 = oVar2.f3576b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        o oVar = this.f3541a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.f3577c;
            for (int i3 = oVar.f3576b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f3575a[i3];
            }
            oVar = oVar.f;
        } while (oVar != this.f3541a);
        return i;
    }

    public String toString() {
        return w().toString();
    }

    /* renamed from: v */
    public c clone() {
        c cVar = new c();
        if (this.f3542b == 0) {
            return cVar;
        }
        o a2 = this.f3541a.a();
        cVar.f3541a = a2;
        a2.g = a2;
        a2.f = a2;
        o oVar = this.f3541a;
        while (true) {
            oVar = oVar.f;
            if (oVar != this.f3541a) {
                cVar.f3541a.g.a(oVar.a());
            } else {
                cVar.f3542b = this.f3542b;
                return cVar;
            }
        }
    }

    public final f w() {
        long j = this.f3542b;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f3542b);
        }
        return f((int) j);
    }

    public final f f(int i) {
        if (i == 0) {
            return f.f3546b;
        }
        return new q(this, i);
    }
}
