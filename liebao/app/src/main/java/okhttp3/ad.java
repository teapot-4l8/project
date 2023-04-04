package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class ad implements Closeable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Reader f7332a;

    @Nullable
    public abstract v a();

    public abstract long b();

    public abstract c.e c();

    public final Reader d() {
        Reader reader = this.f7332a;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(c(), f());
        this.f7332a = aVar;
        return aVar;
    }

    public final String e() {
        c.e c2 = c();
        try {
            return c2.a(okhttp3.internal.c.a(c2, f()));
        } finally {
            okhttp3.internal.c.a(c2);
        }
    }

    private Charset f() {
        v a2 = a();
        return a2 != null ? a2.a(okhttp3.internal.c.f7468e) : okhttp3.internal.c.f7468e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.c.a(c());
    }

    public static ad a(@Nullable v vVar, String str) {
        Charset charset = okhttp3.internal.c.f7468e;
        if (vVar != null && (charset = vVar.b()) == null) {
            charset = okhttp3.internal.c.f7468e;
            vVar = v.b(vVar + "; charset=utf-8");
        }
        c.c a2 = new c.c().a(str, charset);
        return a(vVar, a2.b(), a2);
    }

    public static ad a(@Nullable v vVar, byte[] bArr) {
        return a(vVar, bArr.length, new c.c().c(bArr));
    }

    public static ad a(@Nullable final v vVar, final long j, final c.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ad() { // from class: okhttp3.ad.1
            @Override // okhttp3.ad
            @Nullable
            public v a() {
                return v.this;
            }

            @Override // okhttp3.ad
            public long b() {
                return j;
            }

            @Override // okhttp3.ad
            public c.e c() {
                return eVar;
            }
        };
    }

    /* compiled from: ResponseBody.java */
    /* loaded from: classes.dex */
    static final class a extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private final c.e f7336a;

        /* renamed from: b  reason: collision with root package name */
        private final Charset f7337b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7338c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Reader f7339d;

        a(c.e eVar, Charset charset) {
            this.f7336a = eVar;
            this.f7337b = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            if (this.f7338c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f7339d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f7336a.g(), okhttp3.internal.c.a(this.f7336a, this.f7337b));
                this.f7339d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f7338c = true;
            Reader reader = this.f7339d;
            if (reader != null) {
                reader.close();
            } else {
                this.f7336a.close();
            }
        }
    }
}
