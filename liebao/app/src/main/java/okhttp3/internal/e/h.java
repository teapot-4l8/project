package okhttp3.internal.e;

import c.s;
import c.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.e.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Reader.java */
/* loaded from: classes2.dex */
public final class h implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f7591a = Logger.getLogger(e.class.getName());

    /* renamed from: b  reason: collision with root package name */
    final d.a f7592b;

    /* renamed from: c  reason: collision with root package name */
    private final c.e f7593c;

    /* renamed from: d  reason: collision with root package name */
    private final a f7594d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7595e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list);

        void a(int i, long j);

        void a(int i, okhttp3.internal.e.b bVar);

        void a(int i, okhttp3.internal.e.b bVar, c.f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, c.e eVar, int i2);

        void a(boolean z, m mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c.e eVar, boolean z) {
        this.f7593c = eVar;
        this.f7595e = z;
        a aVar = new a(eVar);
        this.f7594d = aVar;
        this.f7592b = new d.a(4096, aVar);
    }

    public void a(b bVar) {
        if (this.f7595e) {
            if (!a(true, bVar)) {
                throw e.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        c.f d2 = this.f7593c.d(e.f7537a.h());
        if (f7591a.isLoggable(Level.FINE)) {
            f7591a.fine(okhttp3.internal.c.a("<< CONNECTION %s", d2.f()));
        }
        if (!e.f7537a.equals(d2)) {
            throw e.b("Expected a connection header but was %s", d2.a());
        }
    }

    public boolean a(boolean z, b bVar) {
        try {
            this.f7593c.a(9L);
            int a2 = a(this.f7593c);
            if (a2 < 0 || a2 > 16384) {
                throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte i = (byte) (this.f7593c.i() & 255);
            if (!z || i == 4) {
                byte i2 = (byte) (this.f7593c.i() & 255);
                int k = this.f7593c.k() & Integer.MAX_VALUE;
                if (f7591a.isLoggable(Level.FINE)) {
                    f7591a.fine(e.a(true, k, a2, i, i2));
                }
                switch (i) {
                    case 0:
                        b(bVar, a2, i2, k);
                        break;
                    case 1:
                        a(bVar, a2, i2, k);
                        break;
                    case 2:
                        c(bVar, a2, i2, k);
                        break;
                    case 3:
                        d(bVar, a2, i2, k);
                        break;
                    case 4:
                        e(bVar, a2, i2, k);
                        break;
                    case 5:
                        f(bVar, a2, i2, k);
                        break;
                    case 6:
                        g(bVar, a2, i2, k);
                        break;
                    case 7:
                        h(bVar, a2, i2, k);
                        break;
                    case 8:
                        i(bVar, a2, i2, k);
                        break;
                    default:
                        this.f7593c.i(a2);
                        break;
                }
                return true;
            }
            throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(i));
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short i3 = (b2 & 8) != 0 ? (short) (this.f7593c.i() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, -1, a(a(i, b2, i3), i3, b2, i2));
    }

    private List<c> a(int i, short s, byte b2, int i2) {
        a aVar = this.f7594d;
        aVar.f7599d = i;
        aVar.f7596a = i;
        this.f7594d.f7600e = s;
        this.f7594d.f7597b = b2;
        this.f7594d.f7598c = i2;
        this.f7592b.a();
        return this.f7592b.b();
    }

    private void b(b bVar, int i, byte b2, int i2) {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short i3 = (b2 & 8) != 0 ? (short) (this.f7593c.i() & 255) : (short) 0;
        bVar.a(z, i2, this.f7593c, a(i, b2, i3));
        this.f7593c.i(i3);
    }

    private void c(b bVar, int i, byte b2, int i2) {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void a(b bVar, int i) {
        int k = this.f7593c.k();
        bVar.a(i, k & Integer.MAX_VALUE, (this.f7593c.i() & 255) + 1, (Integer.MIN_VALUE & k) != 0);
    }

    private void d(b bVar, int i, byte b2, int i2) {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int k = this.f7593c.k();
        okhttp3.internal.e.b a2 = okhttp3.internal.e.b.a(k);
        if (a2 == null) {
            throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(k));
        }
        bVar.a(i2, a2);
    }

    private void e(b bVar, int i, byte b2, int i2) {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
        } else if (i % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            m mVar = new m();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int j = this.f7593c.j() & 65535;
                int k = this.f7593c.k();
                if (j != 2) {
                    if (j == 3) {
                        j = 4;
                    } else if (j == 4) {
                        j = 7;
                        if (k < 0) {
                            throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (j == 5 && (k < 16384 || k > 16777215)) {
                        throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(k));
                    }
                } else if (k != 0 && k != 1) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                mVar.a(j, k);
            }
            bVar.a(false, mVar);
        }
    }

    private void f(b bVar, int i, byte b2, int i2) {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short i3 = (b2 & 8) != 0 ? (short) (this.f7593c.i() & 255) : (short) 0;
        bVar.a(i2, this.f7593c.k() & Integer.MAX_VALUE, a(a(i - 4, b2, i3), i3, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) {
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b2 & 1) != 0, this.f7593c.k(), this.f7593c.k());
    }

    private void h(b bVar, int i, byte b2, int i2) {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int k = this.f7593c.k();
        int k2 = this.f7593c.k();
        int i3 = i - 8;
        okhttp3.internal.e.b a2 = okhttp3.internal.e.b.a(k2);
        if (a2 == null) {
            throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(k2));
        }
        c.f fVar = c.f.f3546b;
        if (i3 > 0) {
            fVar = this.f7593c.d(i3);
        }
        bVar.a(k, a2, fVar);
    }

    private void i(b bVar, int i, byte b2, int i2) {
        if (i != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long k = this.f7593c.k() & 2147483647L;
        if (k == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(k));
        }
        bVar.a(i2, k);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7593c.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes2.dex */
    public static final class a implements s {

        /* renamed from: a  reason: collision with root package name */
        int f7596a;

        /* renamed from: b  reason: collision with root package name */
        byte f7597b;

        /* renamed from: c  reason: collision with root package name */
        int f7598c;

        /* renamed from: d  reason: collision with root package name */
        int f7599d;

        /* renamed from: e  reason: collision with root package name */
        short f7600e;
        private final c.e f;

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        a(c.e eVar) {
            this.f = eVar;
        }

        @Override // c.s
        public long a(c.c cVar, long j) {
            while (true) {
                int i = this.f7599d;
                if (i == 0) {
                    this.f.i(this.f7600e);
                    this.f7600e = (short) 0;
                    if ((this.f7597b & 4) != 0) {
                        return -1L;
                    }
                    b();
                } else {
                    long a2 = this.f.a(cVar, Math.min(j, i));
                    if (a2 == -1) {
                        return -1L;
                    }
                    this.f7599d = (int) (this.f7599d - a2);
                    return a2;
                }
            }
        }

        @Override // c.s
        public t a() {
            return this.f.a();
        }

        private void b() {
            int i = this.f7598c;
            int a2 = h.a(this.f);
            this.f7599d = a2;
            this.f7596a = a2;
            byte i2 = (byte) (this.f.i() & 255);
            this.f7597b = (byte) (this.f.i() & 255);
            if (h.f7591a.isLoggable(Level.FINE)) {
                h.f7591a.fine(e.a(true, this.f7598c, this.f7596a, i2, this.f7597b));
            }
            int k = this.f.k() & Integer.MAX_VALUE;
            this.f7598c = k;
            if (i2 != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(i2));
            }
            if (k != i) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(c.e eVar) {
        return (eVar.i() & 255) | ((eVar.i() & 255) << 16) | ((eVar.i() & 255) << 8);
    }

    static int a(int i, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
