package kotlin.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public class j extends i {
    public static final <T> List<T> a() {
        return t.f7143a;
    }

    public static final <T> ArrayList<T> a(T... tArr) {
        kotlin.d.b.i.b(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new a(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(List<? extends T> list) {
        kotlin.d.b.i.b(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : h.a(list.get(0));
        }
        return h.a();
    }
}
