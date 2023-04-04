package a.a.a.d;

import java.util.BitSet;

/* compiled from: NXTRecord.java */
/* loaded from: classes.dex */
public class bi extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f176a;

    /* renamed from: b  reason: collision with root package name */
    private BitSet f177b;

    @Override // a.a.a.d.bx
    bx a() {
        return new bi();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f176a = new bj(tVar);
        this.f177b = new BitSet();
        int b2 = tVar.b();
        for (int i = 0; i < b2; i++) {
            int g = tVar.g();
            for (int i2 = 0; i2 < 8; i2++) {
                if (((1 << (7 - i2)) & g) != 0) {
                    this.f177b.set((i * 8) + i2);
                }
            }
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f176a);
        int length = this.f177b.length();
        for (short s = 0; s < length; s = (short) (s + 1)) {
            if (this.f177b.get(s)) {
                sb.append(" ");
                sb.append(cz.b(s));
            }
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f176a.a(vVar, (o) null, z);
        int length = this.f177b.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i |= this.f177b.get(i2) ? 1 << (7 - (i2 % 8)) : 0;
            if (i2 % 8 == 7 || i2 == length - 1) {
                vVar.b(i);
                i = 0;
            }
        }
    }
}
