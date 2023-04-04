package kotlin.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes2.dex */
public class i {
    public static final <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.d.b.i.a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> Object[] a(T[] tArr, boolean z) {
        kotlin.d.b.i.b(tArr, "$this$copyToArrayOfAny");
        if (z && kotlin.d.b.i.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.d.b.i.a((Object) copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }
}
