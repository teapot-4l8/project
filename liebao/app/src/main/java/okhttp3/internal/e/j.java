package okhttp3.internal.e;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.e.d;

/* compiled from: Http2Writer.java */
/* loaded from: classes2.dex */
final class j implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f7617b = Logger.getLogger(e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    final d.b f7618a;

    /* renamed from: c  reason: collision with root package name */
    private final c.d f7619c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7620d;

    /* renamed from: e  reason: collision with root package name */
    private final c.c f7621e;
    private int f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c.d dVar, boolean z) {
        this.f7619c = dVar;
        this.f7620d = z;
        c.c cVar = new c.c();
        this.f7621e = cVar;
        this.f7618a = new d.b(cVar);
        this.f = 16384;
    }

    public synchronized void a() {
        if (this.g) {
            throw new IOException("closed");
        }
        if (this.f7620d) {
            if (f7617b.isLoggable(Level.FINE)) {
                f7617b.fine(okhttp3.internal.c.a(">> CONNECTION %s", e.f7537a.f()));
            }
            this.f7619c.c(e.f7537a.i());
            this.f7619c.flush();
        }
    }

    public synchronized void a(m mVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f = mVar.d(this.f);
        if (mVar.c() != -1) {
            this.f7618a.a(mVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.f7619c.flush();
    }

    public synchronized void a(int i, int i2, List<c> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f7618a.a(list);
        long b2 = this.f7621e.b();
        int min = (int) Math.min(this.f - 4, b2);
        long j = min;
        a(i, min + 4, (byte) 5, b2 == j ? (byte) 4 : (byte) 0);
        this.f7619c.g(i2 & Integer.MAX_VALUE);
        this.f7619c.a_(this.f7621e, j);
        if (b2 > j) {
            b(i, b2 - j);
        }
    }

    public synchronized void b() {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f7619c.flush();
    }

    public synchronized void a(boolean z, int i, int i2, List<c> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(z, i, list);
    }

    public synchronized void a(int i, b bVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (bVar.l == -1) {
            throw new IllegalArgumentException();
        }
        a(i, 4, (byte) 3, (byte) 0);
        this.f7619c.g(bVar.l);
        this.f7619c.flush();
    }

    public int c() {
        return this.f;
    }

    public synchronized void a(boolean z, int i, c.c cVar, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
    }

    void a(int i, byte b2, c.c cVar, int i2) {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f7619c.a_(cVar, i2);
        }
    }

    public synchronized void b(m mVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, mVar.b() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (mVar.a(i)) {
                this.f7619c.h(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f7619c.g(mVar.b(i));
            }
            i++;
        }
        this.f7619c.flush();
    }

    public synchronized void a(boolean z, int i, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.f7619c.g(i);
        this.f7619c.g(i2);
        this.f7619c.flush();
    }

    public synchronized void a(int i, b bVar, byte[] bArr) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (bVar.l == -1) {
            throw e.a("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f7619c.g(i);
        this.f7619c.g(bVar.l);
        if (bArr.length > 0) {
            this.f7619c.c(bArr);
        }
        this.f7619c.flush();
    }

    public synchronized void a(int i, long j) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.f7619c.g((int) j);
        this.f7619c.flush();
    }

    public void a(int i, int i2, byte b2, byte b3) {
        if (f7617b.isLoggable(Level.FINE)) {
            f7617b.fine(e.a(false, i, i2, b2, b3));
        }
        int i3 = this.f;
        if (i2 > i3) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.f7619c, i2);
        this.f7619c.i(b2 & 255);
        this.f7619c.i(b3 & 255);
        this.f7619c.g(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.g = true;
        this.f7619c.close();
    }

    private static void a(c.d dVar, int i) {
        dVar.i((i >>> 16) & 255);
        dVar.i((i >>> 8) & 255);
        dVar.i(i & 255);
    }

    private void b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.f, j);
            long j2 = min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f7619c.a_(this.f7621e, j2);
        }
    }

    void a(boolean z, int i, List<c> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f7618a.a(list);
        long b2 = this.f7621e.b();
        int min = (int) Math.min(this.f, b2);
        long j = min;
        byte b3 = b2 == j ? (byte) 4 : (byte) 0;
        if (z) {
            b3 = (byte) (b3 | 1);
        }
        a(i, min, (byte) 1, b3);
        this.f7619c.a_(this.f7621e, j);
        if (b2 > j) {
            b(i, b2 - j);
        }
    }
}
