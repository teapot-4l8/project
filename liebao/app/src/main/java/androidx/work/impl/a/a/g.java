package androidx.work.impl.a.a;

import android.content.Context;
import androidx.work.i;
import androidx.work.impl.b.j;

/* compiled from: NetworkUnmeteredController.java */
/* loaded from: classes.dex */
public class g extends c<androidx.work.impl.a.b> {
    public g(Context context, androidx.work.impl.utils.b.a aVar) {
        super(androidx.work.impl.a.b.g.a(context, aVar).c());
    }

    @Override // androidx.work.impl.a.a.c
    boolean a(j jVar) {
        return jVar.j.a() == i.UNMETERED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.a.a.c
    /* renamed from: a */
    public boolean b(androidx.work.impl.a.b bVar) {
        return !bVar.a() || bVar.c();
    }
}
