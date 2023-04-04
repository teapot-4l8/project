package a.a.a.d;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: TypeBitmap.java */
/* loaded from: classes.dex */
final class da implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private TreeSet<Integer> f274a;

    private da() {
        this.f274a = new TreeSet<>();
    }

    public da(t tVar) {
        this();
        while (tVar.b() > 0) {
            if (tVar.b() < 2) {
                throw new dg("invalid bitmap descriptor");
            }
            int g = tVar.g();
            if (g < -1) {
                throw new dg("invalid ordering");
            }
            int g2 = tVar.g();
            if (g2 > tVar.b()) {
                throw new dg("invalid bitmap");
            }
            for (int i = 0; i < g2; i++) {
                int g3 = tVar.g();
                if (g3 != 0) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        if (((1 << (7 - i2)) & g3) != 0) {
                            this.f274a.add(Integer.valueOf((g * 256) + (i * 8) + i2));
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.f274a.iterator();
        while (it.hasNext()) {
            sb.append(cz.b(it.next().intValue()));
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private static void a(v vVar, TreeSet<Integer> treeSet, int i) {
        int intValue = ((treeSet.last().intValue() & 255) / 8) + 1;
        int[] iArr = new int[intValue];
        vVar.b(i);
        vVar.b(intValue);
        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            int i2 = (intValue2 & 255) / 8;
            iArr[i2] = (1 << (7 - (intValue2 % 8))) | iArr[i2];
        }
        for (int i3 = 0; i3 < intValue; i3++) {
            vVar.b(iArr[i3]);
        }
    }

    public void a(v vVar) {
        if (this.f274a.size() == 0) {
            return;
        }
        int i = -1;
        TreeSet treeSet = new TreeSet();
        Iterator<Integer> it = this.f274a.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            int i2 = intValue >> 8;
            if (i2 != i) {
                if (treeSet.size() > 0) {
                    a(vVar, treeSet, i);
                    treeSet.clear();
                }
                i = i2;
            }
            treeSet.add(Integer.valueOf(intValue));
        }
        a(vVar, treeSet, i);
    }

    public boolean a() {
        return this.f274a.isEmpty();
    }
}
