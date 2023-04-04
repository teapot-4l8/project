package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.h;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstraintsCommandHandler.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2913a = h.a("ConstraintsCmdHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f2914b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2915c;

    /* renamed from: d  reason: collision with root package name */
    private final e f2916d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.work.impl.a.d f2917e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, int i, e eVar) {
        this.f2914b = context;
        this.f2915c = i;
        this.f2916d = eVar;
        this.f2917e = new androidx.work.impl.a.d(this.f2914b, eVar.e(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        List<j> c2 = this.f2916d.d().c().p().c();
        ConstraintProxy.a(this.f2914b, c2);
        this.f2917e.a(c2);
        ArrayList<j> arrayList = new ArrayList(c2.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (j jVar : c2) {
            String str = jVar.f2864a;
            if (currentTimeMillis >= jVar.c() && (!jVar.d() || this.f2917e.a(str))) {
                arrayList.add(jVar);
            }
        }
        for (j jVar2 : arrayList) {
            String str2 = jVar2.f2864a;
            Intent b2 = b.b(this.f2914b, str2);
            h.a().b(f2913a, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            e eVar = this.f2916d;
            eVar.a(new e.a(eVar, b2, this.f2915c));
        }
        this.f2917e.a();
    }
}
