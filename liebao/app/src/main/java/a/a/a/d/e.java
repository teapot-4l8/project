package a.a.a.d;

/* compiled from: ARecord.java */
/* loaded from: classes.dex */
public class e extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f300a;

    private static byte[] b(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    @Override // a.a.a.d.bx
    bx a() {
        return new e();
    }

    private static int b(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f300a = b(tVar.d(4));
    }

    @Override // a.a.a.d.bx
    String b() {
        return f.a(b(this.f300a));
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.a(this.f300a & 4294967295L);
    }
}
