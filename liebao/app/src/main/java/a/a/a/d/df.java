package a.a.a.d;

import java.util.ArrayList;

/* compiled from: WKSRecord.java */
/* loaded from: classes.dex */
public class df extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f284a;

    /* renamed from: b  reason: collision with root package name */
    private int f285b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f286c;

    @Override // a.a.a.d.bx
    bx a() {
        return new df();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f284a = tVar.d(4);
        this.f285b = tVar.g();
        byte[] j = tVar.j();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < j.length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if ((j[i] & 255 & (1 << (7 - i2))) != 0) {
                    arrayList.add(Integer.valueOf((i * 8) + i2));
                }
            }
        }
        this.f286c = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f286c[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        sb.append(f.a(this.f284a));
        sb.append(" ");
        sb.append(this.f285b);
        for (int i : this.f286c) {
            sb.append(" ");
            sb.append(i);
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.a(this.f284a);
        vVar.b(this.f285b);
        int[] iArr = this.f286c;
        byte[] bArr = new byte[(iArr[iArr.length - 1] / 8) + 1];
        for (int i : iArr) {
            int i2 = i / 8;
            bArr[i2] = (byte) ((1 << (7 - (i % 8))) | bArr[i2]);
        }
        vVar.a(bArr);
    }
}
