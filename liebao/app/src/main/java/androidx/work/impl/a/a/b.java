package androidx.work.impl.a.a;

import android.content.Context;
import androidx.work.impl.b.j;

/* compiled from: BatteryNotLowController.java */
/* loaded from: classes.dex */
public class b extends c<Boolean> {
    public b(Context context, androidx.work.impl.utils.b.a aVar) {
        super(androidx.work.impl.a.b.g.a(context, aVar).b());
    }

    @Override // androidx.work.impl.a.a.c
    boolean a(j jVar) {
        return jVar.j.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.a.a.c
    /* renamed from: a */
    public boolean b(Boolean bool) {
        return !bool.booleanValue();
    }
}
