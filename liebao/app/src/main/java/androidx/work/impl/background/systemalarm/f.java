package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.h;
import androidx.work.impl.b.j;

/* compiled from: SystemAlarmScheduler.java */
/* loaded from: classes.dex */
public class f implements androidx.work.impl.d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2933a = h.a("SystemAlarmScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f2934b;

    public f(Context context) {
        this.f2934b = context.getApplicationContext();
    }

    @Override // androidx.work.impl.d
    public void a(j... jVarArr) {
        for (j jVar : jVarArr) {
            a(jVar);
        }
    }

    @Override // androidx.work.impl.d
    public void a(String str) {
        this.f2934b.startService(b.c(this.f2934b, str));
    }

    private void a(j jVar) {
        h.a().b(f2933a, String.format("Scheduling work with workSpecId %s", jVar.f2864a), new Throwable[0]);
        this.f2934b.startService(b.a(this.f2934b, jVar.f2864a));
    }
}
