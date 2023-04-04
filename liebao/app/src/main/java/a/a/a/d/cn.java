package a.a.a.d;

import com.google.android.gms.ads.AdRequest;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: SimpleResolver.java */
/* loaded from: classes.dex */
public class cn implements ca {
    private static String h = "localhost";
    private static int i;

    /* renamed from: a  reason: collision with root package name */
    private InetSocketAddress f236a;

    /* renamed from: b  reason: collision with root package name */
    private InetSocketAddress f237b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f238c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f239d;

    /* renamed from: e  reason: collision with root package name */
    private bm f240e;
    private ct f;
    private long g;

    public cn(String str) {
        InetAddress byName;
        this.g = 10000L;
        if (str == null && (str = cb.j().g()) == null) {
            str = h;
        }
        if (str.equals("0")) {
            byName = InetAddress.getLocalHost();
        } else {
            byName = InetAddress.getByName(str);
        }
        this.f236a = new InetSocketAddress(byName, 53);
    }

    public cn() {
        this(null);
    }

    @Override // a.a.a.d.ca
    public void a(int i2, int i3) {
        this.g = (i2 * 1000) + i3;
    }

    @Override // a.a.a.d.ca
    public void a(int i2) {
        a(i2, 0);
    }

    long a() {
        return this.g;
    }

    private ax a(byte[] bArr) {
        try {
            return new ax(bArr);
        } catch (IOException e2) {
            e = e2;
            if (bo.b("verbose")) {
                e.printStackTrace();
            }
            if (!(e instanceof dg)) {
                e = new dg("Error parsing message");
            }
            throw ((dg) e);
        }
    }

    private void a(ax axVar, ax axVar2, byte[] bArr, ct ctVar) {
        if (ctVar == null) {
            return;
        }
        int a2 = ctVar.a(axVar2, bArr, axVar.c());
        if (bo.b("verbose")) {
            PrintStream printStream = System.err;
            printStream.println("TSIG verify: " + bw.b(a2));
        }
    }

    private void b(ax axVar) {
        if (this.f240e == null || axVar.f() != null) {
            return;
        }
        axVar.a(this.f240e, 3);
    }

    private int c(ax axVar) {
        bm f = axVar.f();
        return f == null ? AdRequest.MAX_CONTENT_URL_LENGTH : f.d();
    }

    @Override // a.a.a.d.ca
    public ax a(ax axVar) {
        byte[] a2;
        ax a3;
        bx b2;
        if (bo.b("verbose")) {
            System.err.println("Sending to " + this.f236a.getAddress().getHostAddress() + ":" + this.f236a.getPort());
        }
        if (axVar.a().d() == 0 && (b2 = axVar.b()) != null && b2.k() == 252) {
            return d(axVar);
        }
        ax axVar2 = (ax) axVar.clone();
        b(axVar2);
        ct ctVar = this.f;
        if (ctVar != null) {
            ctVar.a(axVar2, (cu) null);
        }
        byte[] c2 = axVar2.c(65535);
        int c3 = c(axVar2);
        long currentTimeMillis = System.currentTimeMillis() + this.g;
        boolean z = false;
        while (true) {
            boolean z2 = (this.f238c || c2.length > c3) ? true : z;
            if (z2) {
                a2 = cq.a(this.f237b, this.f236a, c2, currentTimeMillis);
            } else {
                a2 = dc.a(this.f237b, this.f236a, c2, c3, currentTimeMillis);
            }
            if (a2.length < 12) {
                throw new dg("invalid DNS header - too short");
            }
            int i2 = ((a2[0] & 255) << 8) + (a2[1] & 255);
            int b3 = axVar2.a().b();
            if (i2 != b3) {
                String str = "invalid message id: expected " + b3 + "; got id " + i2;
                if (z2) {
                    throw new dg(str);
                }
                if (bo.b("verbose")) {
                    System.err.println(str);
                }
                z = z2;
            } else {
                a3 = a(a2);
                a(axVar2, a3, a2, this.f);
                if (z2 || this.f239d || !a3.a().b(6)) {
                    break;
                }
                z = true;
            }
        }
        return a3;
    }

    @Override // a.a.a.d.ca
    /* renamed from: a */
    public Integer b(ax axVar, cc ccVar) {
        Integer valueOf;
        synchronized (this) {
            int i2 = i;
            i = i2 + 1;
            valueOf = Integer.valueOf(i2);
        }
        bx b2 = axVar.b();
        String str = getClass() + ": " + (b2 != null ? b2.j().toString() : "(none)");
        bz bzVar = new bz(this, axVar, valueOf, ccVar);
        bzVar.setName(str);
        bzVar.setDaemon(true);
        bzVar.start();
        return valueOf;
    }

    private ax d(ax axVar) {
        dj a2 = dj.a(axVar.b().j(), this.f236a, this.f);
        a2.a((int) (a() / 1000));
        a2.a(this.f237b);
        try {
            a2.a();
            List<bx> b2 = a2.b();
            ax axVar2 = new ax(axVar.a().b());
            axVar2.a().a(5);
            axVar2.a().a(0);
            axVar2.a(axVar.b(), 0);
            for (bx bxVar : b2) {
                axVar2.a(bxVar, 1);
            }
            return axVar2;
        } catch (di e2) {
            throw new dg(e2.getMessage());
        }
    }
}
