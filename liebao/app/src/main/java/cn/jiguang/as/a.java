package cn.jiguang.as;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private b[] f3870a = new b[17];

    public final int a(h hVar) {
        int i = -1;
        for (b bVar = this.f3870a[(hVar.hashCode() & Integer.MAX_VALUE) % 17]; bVar != null; bVar = bVar.f3873c) {
            if (bVar.f3871a.equals(hVar)) {
                i = bVar.f3872b;
            }
        }
        return i;
    }

    public final void a(int i, h hVar) {
        if (i > 16383) {
            return;
        }
        int hashCode = (hVar.hashCode() & Integer.MAX_VALUE) % 17;
        b bVar = new b((byte) 0);
        bVar.f3871a = hVar;
        bVar.f3872b = i;
        bVar.f3873c = this.f3870a[hashCode];
        this.f3870a[hashCode] = bVar;
    }
}
