package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes.dex */
public final class ae {

    /* renamed from: a  reason: collision with root package name */
    final a f7340a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f7341b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f7342c;

    public ae(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f7340a = aVar;
        this.f7341b = proxy;
        this.f7342c = inetSocketAddress;
    }

    public a a() {
        return this.f7340a;
    }

    public Proxy b() {
        return this.f7341b;
    }

    public InetSocketAddress c() {
        return this.f7342c;
    }

    public boolean d() {
        return this.f7340a.i != null && this.f7341b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ae) {
            ae aeVar = (ae) obj;
            if (aeVar.f7340a.equals(this.f7340a) && aeVar.f7341b.equals(this.f7341b) && aeVar.f7342c.equals(this.f7342c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f7340a.hashCode()) * 31) + this.f7341b.hashCode()) * 31) + this.f7342c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f7342c + "}";
    }
}
