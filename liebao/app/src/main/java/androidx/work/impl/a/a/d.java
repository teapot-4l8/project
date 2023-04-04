package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build;
import androidx.work.i;
import androidx.work.impl.b.j;

/* compiled from: NetworkConnectedController.java */
/* loaded from: classes.dex */
public class d extends c<androidx.work.impl.a.b> {
    public d(Context context, androidx.work.impl.utils.b.a aVar) {
        super(androidx.work.impl.a.b.g.a(context, aVar).c());
    }

    @Override // androidx.work.impl.a.a.c
    boolean a(j jVar) {
        return jVar.j.a() == i.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.a.a.c
    /* renamed from: a */
    public boolean b(androidx.work.impl.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return (bVar.a() && bVar.b()) ? false : true;
        }
        return !bVar.a();
    }
}
