package okhttp3.internal.b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.ae;
import okhttp3.p;
import okhttp3.t;

/* compiled from: RouteSelector.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final okhttp3.a f7451a;

    /* renamed from: b  reason: collision with root package name */
    private final d f7452b;

    /* renamed from: c  reason: collision with root package name */
    private final okhttp3.e f7453c;

    /* renamed from: d  reason: collision with root package name */
    private final p f7454d;
    private int f;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f7455e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ae> h = new ArrayList();

    public f(okhttp3.a aVar, d dVar, okhttp3.e eVar, p pVar) {
        this.f7451a = aVar;
        this.f7452b = dVar;
        this.f7453c = eVar;
        this.f7454d = pVar;
        a(aVar.a(), aVar.h());
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a b() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy d2 = d();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ae aeVar = new ae(this.f7451a, d2, this.g.get(i));
                if (this.f7452b.c(aeVar)) {
                    this.h.add(aeVar);
                } else {
                    arrayList.add(aeVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }

    public void a(ae aeVar, IOException iOException) {
        if (aeVar.b().type() != Proxy.Type.DIRECT && this.f7451a.g() != null) {
            this.f7451a.g().connectFailed(this.f7451a.a().a(), aeVar.b().address(), iOException);
        }
        this.f7452b.a(aeVar);
    }

    private void a(t tVar, Proxy proxy) {
        if (proxy != null) {
            this.f7455e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f7451a.g().select(tVar.a());
            this.f7455e = (select == null || select.isEmpty()) ? okhttp3.internal.c.a(Proxy.NO_PROXY) : okhttp3.internal.c.a(select);
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.f7455e.size();
    }

    private Proxy d() {
        if (!c()) {
            throw new SocketException("No route to " + this.f7451a.a().f() + "; exhausted proxy configurations: " + this.f7455e);
        }
        List<Proxy> list = this.f7455e;
        int i = this.f;
        this.f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private void a(Proxy proxy) {
        String f;
        int g;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            f = this.f7451a.a().f();
            g = this.f7451a.a().g();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            f = a(inetSocketAddress);
            g = inetSocketAddress.getPort();
        }
        if (g < 1 || g > 65535) {
            throw new SocketException("No route to " + f + ":" + g + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(f, g));
        } else {
            this.f7454d.a(this.f7453c, f);
            List<InetAddress> a2 = this.f7451a.b().a(f);
            if (a2.isEmpty()) {
                throw new UnknownHostException(this.f7451a.b() + " returned no addresses for " + f);
            }
            this.f7454d.a(this.f7453c, f, a2);
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                this.g.add(new InetSocketAddress(a2.get(i), g));
            }
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* compiled from: RouteSelector.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<ae> f7456a;

        /* renamed from: b  reason: collision with root package name */
        private int f7457b = 0;

        a(List<ae> list) {
            this.f7456a = list;
        }

        public boolean a() {
            return this.f7457b < this.f7456a.size();
        }

        public ae b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<ae> list = this.f7456a;
            int i = this.f7457b;
            this.f7457b = i + 1;
            return list.get(i);
        }

        public List<ae> c() {
            return new ArrayList(this.f7456a);
        }
    }
}
