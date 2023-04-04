package kotlin.a;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes2.dex */
public class e extends d {
    public static final <T> List<T> a(T[] tArr) {
        kotlin.d.b.i.b(tArr, "$this$asList");
        List<T> a2 = g.a(tArr);
        kotlin.d.b.i.a((Object) a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }
}
