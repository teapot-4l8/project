package a.a.a.d;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: AAAARecord.java */
/* loaded from: classes.dex */
public class b extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f162a;

    @Override // a.a.a.d.bx
    bx a() {
        return new b();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f162a = tVar.d(16);
    }

    @Override // a.a.a.d.bx
    String b() {
        try {
            InetAddress byAddress = InetAddress.getByAddress(null, this.f162a);
            if (byAddress.getAddress().length == 4) {
                StringBuilder sb = new StringBuilder("0:0:0:0:0:ffff:");
                byte[] bArr = this.f162a;
                int i = ((bArr[12] & 255) << 8) + (bArr[13] & 255);
                int i2 = ((bArr[14] & 255) << 8) + (bArr[15] & 255);
                sb.append(Integer.toHexString(i));
                sb.append(':');
                sb.append(Integer.toHexString(i2));
                return sb.toString();
            }
            return byAddress.getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.a(this.f162a);
    }
}
