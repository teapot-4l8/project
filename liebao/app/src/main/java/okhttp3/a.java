package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.t;

/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final t f7289a;

    /* renamed from: b  reason: collision with root package name */
    final o f7290b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f7291c;

    /* renamed from: d  reason: collision with root package name */
    final b f7292d;

    /* renamed from: e  reason: collision with root package name */
    final List<y> f7293e;
    final List<k> f;
    final ProxySelector g;
    @Nullable
    final Proxy h;
    @Nullable
    final SSLSocketFactory i;
    @Nullable
    final HostnameVerifier j;
    @Nullable
    final g k;

    public a(String str, int i, o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, b bVar, @Nullable Proxy proxy, List<y> list, List<k> list2, ProxySelector proxySelector) {
        this.f7289a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i).c();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f7290b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f7291c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f7292d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f7293e = okhttp3.internal.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = okhttp3.internal.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    public t a() {
        return this.f7289a;
    }

    public o b() {
        return this.f7290b;
    }

    public SocketFactory c() {
        return this.f7291c;
    }

    public b d() {
        return this.f7292d;
    }

    public List<y> e() {
        return this.f7293e;
    }

    public List<k> f() {
        return this.f;
    }

    public ProxySelector g() {
        return this.g;
    }

    @Nullable
    public Proxy h() {
        return this.h;
    }

    @Nullable
    public SSLSocketFactory i() {
        return this.i;
    }

    @Nullable
    public HostnameVerifier j() {
        return this.j;
    }

    @Nullable
    public g k() {
        return this.k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f7289a.equals(aVar.f7289a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f7289a.hashCode()) * 31) + this.f7290b.hashCode()) * 31) + this.f7292d.hashCode()) * 31) + this.f7293e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.f7290b.equals(aVar.f7290b) && this.f7292d.equals(aVar.f7292d) && this.f7293e.equals(aVar.f7293e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && okhttp3.internal.c.a(this.h, aVar.h) && okhttp3.internal.c.a(this.i, aVar.i) && okhttp3.internal.c.a(this.j, aVar.j) && okhttp3.internal.c.a(this.k, aVar.k) && a().g() == aVar.a().g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f7289a.f());
        sb.append(":");
        sb.append(this.f7289a.g());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }
}
