package kotlin.e;

import kotlin.d.b.i;

/* compiled from: Random.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final int a(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final int a(c cVar, kotlin.f.c cVar2) {
        i.b(cVar, "$this$nextInt");
        i.b(cVar2, "range");
        if (!cVar2.e()) {
            return cVar2.b() < Integer.MAX_VALUE ? cVar.a(cVar2.a(), cVar2.b() + 1) : cVar2.a() > Integer.MIN_VALUE ? cVar.a(cVar2.a() - 1, cVar2.b()) + 1 : cVar.b();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + cVar2);
    }

    public static final int a(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void b(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final String a(Object obj, Object obj2) {
        i.b(obj, "from");
        i.b(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
