package kotlin.d.b;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final <T> Iterator<T> a(T[] tArr) {
        i.b(tArr, "array");
        return new a(tArr);
    }
}
