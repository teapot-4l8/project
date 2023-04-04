package androidx.work;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* compiled from: WorkManager.java */
/* loaded from: classes.dex */
public abstract class n {
    public abstract k a(String str);

    public abstract k a(List<? extends o> list);

    public static n a(Context context) {
        return androidx.work.impl.h.b(context);
    }

    public static void a(Context context, b bVar) {
        androidx.work.impl.h.b(context, bVar);
    }

    public final k a(o oVar) {
        return a(Collections.singletonList(oVar));
    }
}
