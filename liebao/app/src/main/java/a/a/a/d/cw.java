package a.a.a.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TXTBase.java */
/* loaded from: classes.dex */
abstract class cw extends bx {

    /* renamed from: a  reason: collision with root package name */
    protected List<byte[]> f266a;

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f266a = new ArrayList(2);
        while (tVar.b() > 0) {
            this.f266a.add(tVar.k());
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        Iterator<byte[]> it = this.f266a.iterator();
        while (it.hasNext()) {
            sb.append(a(it.next(), true));
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        for (byte[] bArr : this.f266a) {
            vVar.b(bArr);
        }
    }
}
