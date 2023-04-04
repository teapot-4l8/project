package a.a.a.d;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: ClientSubnetOption.java */
/* loaded from: classes.dex */
public class n extends x {

    /* renamed from: a  reason: collision with root package name */
    private int f322a;

    /* renamed from: b  reason: collision with root package name */
    private int f323b;

    /* renamed from: c  reason: collision with root package name */
    private int f324c;

    /* renamed from: d  reason: collision with root package name */
    private InetAddress f325d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        super(8);
    }

    @Override // a.a.a.d.x
    void a(t tVar) {
        int h = tVar.h();
        this.f322a = h;
        if (h != 1 && h != 2) {
            throw new dg("unknown address family");
        }
        int g = tVar.g();
        this.f323b = g;
        if (g > f.a(this.f322a) * 8) {
            throw new dg("invalid source netmask");
        }
        int g2 = tVar.g();
        this.f324c = g2;
        if (g2 > f.a(this.f322a) * 8) {
            throw new dg("invalid scope netmask");
        }
        byte[] j = tVar.j();
        if (j.length != (this.f323b + 7) / 8) {
            throw new dg("invalid address");
        }
        byte[] bArr = new byte[f.a(this.f322a)];
        System.arraycopy(j, 0, bArr, 0, j.length);
        try {
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            this.f325d = byAddress;
            if (!f.a(byAddress, this.f323b).equals(this.f325d)) {
                throw new dg("invalid padding");
            }
        } catch (UnknownHostException e2) {
            throw new dg("invalid address", e2);
        }
    }

    @Override // a.a.a.d.x
    void a(v vVar) {
        vVar.c(this.f322a);
        vVar.b(this.f323b);
        vVar.b(this.f324c);
        vVar.a(this.f325d.getAddress(), 0, (this.f323b + 7) / 8);
    }

    @Override // a.a.a.d.x
    String a() {
        return this.f325d.getHostAddress() + "/" + this.f323b + ", scope netmask " + this.f324c;
    }
}
