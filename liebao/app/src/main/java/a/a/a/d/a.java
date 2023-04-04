package a.a.a.d;

import java.net.InetAddress;

/* compiled from: A6Record.java */
/* loaded from: classes.dex */
public class a extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f102a;

    /* renamed from: b  reason: collision with root package name */
    private InetAddress f103b;

    /* renamed from: c  reason: collision with root package name */
    private bj f104c;

    @Override // a.a.a.d.bx
    bx a() {
        return new a();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        int g = tVar.g();
        this.f102a = g;
        int i = ((128 - g) + 7) / 8;
        if (g < 128) {
            byte[] bArr = new byte[16];
            tVar.a(bArr, 16 - i, i);
            this.f103b = InetAddress.getByAddress(bArr);
        }
        if (this.f102a > 0) {
            this.f104c = new bj(tVar);
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f102a);
        if (this.f103b != null) {
            sb.append(" ");
            sb.append(this.f103b.getHostAddress());
        }
        if (this.f104c != null) {
            sb.append(" ");
            sb.append(this.f104c);
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f102a);
        InetAddress inetAddress = this.f103b;
        if (inetAddress != null) {
            int i = ((128 - this.f102a) + 7) / 8;
            vVar.a(inetAddress.getAddress(), 16 - i, i);
        }
        bj bjVar = this.f104c;
        if (bjVar != null) {
            bjVar.a(vVar, (o) null, z);
        }
    }
}
