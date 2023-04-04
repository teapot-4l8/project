package kotlin.a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes2.dex */
public class n extends m {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        kotlin.d.b.i.b(list, "$this$sortWith");
        kotlin.d.b.i.b(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
