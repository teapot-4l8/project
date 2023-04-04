package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class j implements s {

    /* renamed from: b  reason: collision with root package name */
    private final e f3554b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f3555c;

    /* renamed from: d  reason: collision with root package name */
    private final k f3556d;

    /* renamed from: a  reason: collision with root package name */
    private int f3553a = 0;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f3557e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f3555c = new Inflater(true);
        e a2 = l.a(sVar);
        this.f3554b = a2;
        this.f3556d = new k(a2, this.f3555c);
    }

    @Override // c.s
    public long a(c cVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0L;
        } else {
            if (this.f3553a == 0) {
                b();
                this.f3553a = 1;
            }
            if (this.f3553a == 1) {
                long j2 = cVar.f3542b;
                long a2 = this.f3556d.a(cVar, j);
                if (a2 != -1) {
                    a(cVar, j2, a2);
                    return a2;
                }
                this.f3553a = 2;
            }
            if (this.f3553a == 2) {
                c();
                this.f3553a = 3;
                if (!this.f3554b.f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    private void b() {
        this.f3554b.a(10L);
        byte c2 = this.f3554b.c().c(3L);
        boolean z = ((c2 >> 1) & 1) == 1;
        if (z) {
            a(this.f3554b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f3554b.j());
        this.f3554b.i(8L);
        if (((c2 >> 2) & 1) == 1) {
            this.f3554b.a(2L);
            if (z) {
                a(this.f3554b.c(), 0L, 2L);
            }
            long l = this.f3554b.c().l();
            this.f3554b.a(l);
            if (z) {
                a(this.f3554b.c(), 0L, l);
            }
            this.f3554b.i(l);
        }
        if (((c2 >> 3) & 1) == 1) {
            long a2 = this.f3554b.a((byte) 0);
            if (a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f3554b.c(), 0L, a2 + 1);
            }
            this.f3554b.i(a2 + 1);
        }
        if (((c2 >> 4) & 1) == 1) {
            long a3 = this.f3554b.a((byte) 0);
            if (a3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f3554b.c(), 0L, a3 + 1);
            }
            this.f3554b.i(a3 + 1);
        }
        if (z) {
            a("FHCRC", this.f3554b.l(), (short) this.f3557e.getValue());
            this.f3557e.reset();
        }
    }

    private void c() {
        a("CRC", this.f3554b.m(), (int) this.f3557e.getValue());
        a("ISIZE", this.f3554b.m(), (int) this.f3555c.getBytesWritten());
    }

    @Override // c.s
    public t a() {
        return this.f3554b.a();
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3556d.close();
    }

    private void a(c cVar, long j, long j2) {
        int i;
        o oVar = cVar.f3541a;
        while (j >= oVar.f3577c - oVar.f3576b) {
            j -= oVar.f3577c - oVar.f3576b;
            oVar = oVar.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.f3577c - i, j2);
            this.f3557e.update(oVar.f3575a, (int) (oVar.f3576b + j), min);
            j2 -= min;
            oVar = oVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
