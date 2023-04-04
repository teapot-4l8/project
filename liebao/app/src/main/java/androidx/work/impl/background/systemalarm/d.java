package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.h;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.background.systemalarm.g;
import androidx.work.impl.utils.i;
import java.util.Collections;
import java.util.List;

/* compiled from: DelayMetCommandHandler.java */
/* loaded from: classes.dex */
public class d implements androidx.work.impl.a, androidx.work.impl.a.c, g.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2918a = h.a("DelayMetCommandHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f2919b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2920c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2921d;

    /* renamed from: e  reason: collision with root package name */
    private final e f2922e;
    private final androidx.work.impl.a.d f;
    private PowerManager.WakeLock i;
    private boolean j = false;
    private int h = 0;
    private final Object g = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, int i, String str, e eVar) {
        this.f2919b = context;
        this.f2920c = i;
        this.f2922e = eVar;
        this.f2921d = str;
        this.f = new androidx.work.impl.a.d(this.f2919b, eVar.e(), this);
    }

    @Override // androidx.work.impl.a.c
    public void a(List<String> list) {
        if (list.contains(this.f2921d)) {
            synchronized (this.g) {
                if (this.h == 0) {
                    this.h = 1;
                    h.a().b(f2918a, String.format("onAllConstraintsMet for %s", this.f2921d), new Throwable[0]);
                    if (this.f2922e.b().a(this.f2921d)) {
                        this.f2922e.c().a(this.f2921d, 600000L, this);
                    } else {
                        c();
                    }
                } else {
                    h.a().b(f2918a, String.format("Already started work for %s", this.f2921d), new Throwable[0]);
                }
            }
        }
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        h.a().b(f2918a, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        c();
        if (z) {
            Intent a2 = b.a(this.f2919b, this.f2921d);
            e eVar = this.f2922e;
            eVar.a(new e.a(eVar, a2, this.f2920c));
        }
        if (this.j) {
            Intent a3 = b.a(this.f2919b);
            e eVar2 = this.f2922e;
            eVar2.a(new e.a(eVar2, a3, this.f2920c));
        }
    }

    @Override // androidx.work.impl.background.systemalarm.g.a
    public void a(String str) {
        h.a().b(f2918a, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        b();
    }

    @Override // androidx.work.impl.a.c
    public void b(List<String> list) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.i = i.a(this.f2919b, String.format("%s (%s)", this.f2921d, Integer.valueOf(this.f2920c)));
        h.a().b(f2918a, String.format("Acquiring wakelock %s for WorkSpec %s", this.i, this.f2921d), new Throwable[0]);
        this.i.acquire();
        j b2 = this.f2922e.d().c().p().b(this.f2921d);
        if (b2 == null) {
            b();
            return;
        }
        boolean d2 = b2.d();
        this.j = d2;
        if (!d2) {
            h.a().b(f2918a, String.format("No constraints for %s", this.f2921d), new Throwable[0]);
            a(Collections.singletonList(this.f2921d));
            return;
        }
        this.f.a(Collections.singletonList(b2));
    }

    private void b() {
        synchronized (this.g) {
            if (this.h < 2) {
                this.h = 2;
                h.a().b(f2918a, String.format("Stopping work for WorkSpec %s", this.f2921d), new Throwable[0]);
                this.f2922e.a(new e.a(this.f2922e, b.c(this.f2919b, this.f2921d), this.f2920c));
                if (this.f2922e.b().e(this.f2921d)) {
                    h.a().b(f2918a, String.format("WorkSpec %s needs to be rescheduled", this.f2921d), new Throwable[0]);
                    this.f2922e.a(new e.a(this.f2922e, b.a(this.f2919b, this.f2921d), this.f2920c));
                } else {
                    h.a().b(f2918a, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f2921d), new Throwable[0]);
                }
            } else {
                h.a().b(f2918a, String.format("Already stopped work for %s", this.f2921d), new Throwable[0]);
            }
        }
    }

    private void c() {
        synchronized (this.g) {
            this.f.a();
            this.f2922e.c().a(this.f2921d);
            if (this.i != null && this.i.isHeld()) {
                h.a().b(f2918a, String.format("Releasing wakelock %s for WorkSpec %s", this.i, this.f2921d), new Throwable[0]);
                this.i.release();
            }
        }
    }
}
