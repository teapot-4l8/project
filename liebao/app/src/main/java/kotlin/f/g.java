package kotlin.f;

import java.util.NoSuchElementException;
import kotlin.d.b.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes2.dex */
public class g extends f {
    public static final int c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final int a(c cVar, kotlin.e.c cVar2) {
        i.b(cVar, "$this$random");
        i.b(cVar2, "random");
        try {
            return kotlin.e.d.a(cVar2, cVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final a a(int i, int i2) {
        return a.f7171a.a(i, i2, -1);
    }

    public static final c b(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return c.f7179b.a();
        }
        return new c(i, i2 - 1);
    }

    public static final int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }
}
