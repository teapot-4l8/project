package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build;
import androidx.work.i;
import androidx.work.impl.b.j;

/* compiled from: NetworkNotRoamingController.java */
/* loaded from: classes.dex */
public class f extends c<androidx.work.impl.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2813a = androidx.work.h.a("NetworkNotRoamingCtrlr");

    public f(Context context, androidx.work.impl.utils.b.a aVar) {
        super(androidx.work.impl.a.b.g.a(context, aVar).c());
    }

    @Override // androidx.work.impl.a.a.c
    boolean a(j jVar) {
        return jVar.j.a() == i.NOT_ROAMING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.a.a.c
    /* renamed from: a */
    public boolean b(androidx.work.impl.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return (bVar.a() && bVar.d()) ? false : true;
        }
        androidx.work.h.a().b(f2813a, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
