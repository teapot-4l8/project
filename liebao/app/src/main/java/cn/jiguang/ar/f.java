package cn.jiguang.ar;

import java.util.Comparator;

/* loaded from: classes.dex */
final class f implements Comparator<d> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(d dVar, d dVar2) {
        d dVar3 = dVar;
        d dVar4 = dVar2;
        if (dVar3.equals(dVar4)) {
            return 0;
        }
        if (dVar3.f3812b > dVar4.f3812b) {
            return -1;
        }
        if (dVar3.f3812b < dVar4.f3812b) {
            return 1;
        }
        if (dVar3.f3815e > dVar4.f3815e) {
            return -1;
        }
        if (dVar3.f3815e < dVar4.f3815e) {
            return 1;
        }
        if (dVar3.f3814d != 0 && dVar4.f3814d != 0) {
            if (dVar3.f3814d < dVar4.f3814d) {
                return -1;
            }
            if (dVar3.f3814d > dVar4.f3814d) {
                return 1;
            }
        }
        if (dVar3.f3813c == 0 || dVar4.f3813c == 0) {
            return 0;
        }
        if (dVar3.f3813c > dVar4.f3813c + 180000) {
            return -1;
        }
        return dVar3.f3813c < dVar4.f3813c - 180000 ? 1 : 0;
    }
}
