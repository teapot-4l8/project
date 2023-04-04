package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class k implements s {

    /* renamed from: a  reason: collision with root package name */
    private final e f3558a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f3559b;

    /* renamed from: c  reason: collision with root package name */
    private int f3560c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3561d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f3558a = eVar;
        this.f3559b = inflater;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r1.f3576b != r1.f3577c) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        r7.f3541a = r1.b();
        c.p.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return -1;
     */
    @Override // c.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(c cVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f3561d) {
            throw new IllegalStateException("closed");
        } else {
            if (j == 0) {
                return 0L;
            }
            while (true) {
                boolean b2 = b();
                try {
                    o e2 = cVar.e(1);
                    int inflate = this.f3559b.inflate(e2.f3575a, e2.f3577c, (int) Math.min(j, 8192 - e2.f3577c));
                    if (inflate > 0) {
                        e2.f3577c += inflate;
                        long j2 = inflate;
                        cVar.f3542b += j2;
                        return j2;
                    } else if (this.f3559b.finished() || this.f3559b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e3) {
                    throw new IOException(e3);
                }
            }
        }
    }

    public final boolean b() {
        if (this.f3559b.needsInput()) {
            c();
            if (this.f3559b.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.f3558a.f()) {
                return true;
            }
            o oVar = this.f3558a.c().f3541a;
            this.f3560c = oVar.f3577c - oVar.f3576b;
            this.f3559b.setInput(oVar.f3575a, oVar.f3576b, this.f3560c);
            return false;
        }
        return false;
    }

    private void c() {
        int i = this.f3560c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f3559b.getRemaining();
        this.f3560c -= remaining;
        this.f3558a.i(remaining);
    }

    @Override // c.s
    public t a() {
        return this.f3558a.a();
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3561d) {
            return;
        }
        this.f3559b.end();
        this.f3561d = true;
        this.f3558a.close();
    }
}
