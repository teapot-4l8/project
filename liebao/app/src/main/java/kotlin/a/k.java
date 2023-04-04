package kotlin.a;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes2.dex */
public class k extends j {
    public static final <T> int a(Iterable<? extends T> iterable, int i) {
        kotlin.d.b.i.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
