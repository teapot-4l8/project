package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: e  reason: collision with root package name */
    final boolean f7679e;
    final boolean f;
    @Nullable
    final String[] g;
    @Nullable
    final String[] h;
    private static final h[] i = {h.bl, h.bm, h.bn, h.bo, h.bp, h.aX, h.bb, h.aY, h.bc, h.bi, h.bh};
    private static final h[] j = {h.bl, h.bm, h.bn, h.bo, h.bp, h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.aI, h.aJ, h.ag, h.ah, h.E, h.I, h.i};

    /* renamed from: a  reason: collision with root package name */
    public static final k f7675a = new a(true).a(i).a(af.TLS_1_3, af.TLS_1_2).a(true).a();

    /* renamed from: b  reason: collision with root package name */
    public static final k f7676b = new a(true).a(j).a(af.TLS_1_3, af.TLS_1_2, af.TLS_1_1, af.TLS_1_0).a(true).a();

    /* renamed from: c  reason: collision with root package name */
    public static final k f7677c = new a(true).a(j).a(af.TLS_1_0).a(true).a();

    /* renamed from: d  reason: collision with root package name */
    public static final k f7678d = new a(false).a();

    k(a aVar) {
        this.f7679e = aVar.f7680a;
        this.g = aVar.f7681b;
        this.h = aVar.f7682c;
        this.f = aVar.f7683d;
    }

    public boolean a() {
        return this.f7679e;
    }

    @Nullable
    public List<h> b() {
        String[] strArr = this.g;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    @Nullable
    public List<af> c() {
        String[] strArr = this.h;
        if (strArr != null) {
            return af.a(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.g != null) {
            enabledCipherSuites = okhttp3.internal.c.a(h.f7392a, sSLSocket.getEnabledCipherSuites(), this.g);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.h != null) {
            enabledProtocols = okhttp3.internal.c.a(okhttp3.internal.c.h, sSLSocket.getEnabledProtocols(), this.h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = okhttp3.internal.c.a(h.f7392a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = okhttp3.internal.c.a(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (this.f7679e) {
            if (this.h == null || okhttp3.internal.c.b(okhttp3.internal.c.h, this.h, sSLSocket.getEnabledProtocols())) {
                return this.g == null || okhttp3.internal.c.b(h.f7392a, this.g, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z = this.f7679e;
            if (z != kVar.f7679e) {
                return false;
            }
            return !z || (Arrays.equals(this.g, kVar.g) && Arrays.equals(this.h, kVar.h) && this.f == kVar.f);
        }
        return false;
    }

    public int hashCode() {
        if (this.f7679e) {
            return ((((527 + Arrays.hashCode(this.g)) * 31) + Arrays.hashCode(this.h)) * 31) + (!this.f ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f7679e) {
            String obj = this.g != null ? b().toString() : "[all enabled]";
            String obj2 = this.h != null ? c().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f7680a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        String[] f7681b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        String[] f7682c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7683d;

        a(boolean z) {
            this.f7680a = z;
        }

        public a(k kVar) {
            this.f7680a = kVar.f7679e;
            this.f7681b = kVar.g;
            this.f7682c = kVar.h;
            this.f7683d = kVar.f;
        }

        public a a(h... hVarArr) {
            if (!this.f7680a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                strArr[i] = hVarArr[i].bq;
            }
            return a(strArr);
        }

        public a a(String... strArr) {
            if (!this.f7680a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f7681b = (String[]) strArr.clone();
            return this;
        }

        public a a(af... afVarArr) {
            if (!this.f7680a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[afVarArr.length];
            for (int i = 0; i < afVarArr.length; i++) {
                strArr[i] = afVarArr[i].f;
            }
            return b(strArr);
        }

        public a b(String... strArr) {
            if (!this.f7680a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f7682c = (String[]) strArr.clone();
            return this;
        }

        public a a(boolean z) {
            if (!this.f7680a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f7683d = z;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }
}
