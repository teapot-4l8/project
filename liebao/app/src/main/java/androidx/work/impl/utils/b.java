package androidx.work.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.k;
import androidx.work.m;
import androidx.work.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EnqueueRunnable.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3032a = androidx.work.h.a("EnqueueRunnable");

    /* renamed from: b  reason: collision with root package name */
    private final androidx.work.impl.f f3033b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.work.impl.b f3034c = new androidx.work.impl.b();

    public b(androidx.work.impl.f fVar) {
        this.f3033b = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f3033b.j()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f3033b));
            }
            if (b()) {
                d.a(this.f3033b.a().b(), RescheduleReceiver.class, true);
                c();
            }
            this.f3034c.a(k.f3067a);
        } catch (Throwable th) {
            this.f3034c.a(new k.a.C0063a(th));
        }
    }

    public k a() {
        return this.f3034c;
    }

    public boolean b() {
        WorkDatabase c2 = this.f3033b.a().c();
        c2.g();
        try {
            boolean a2 = a(this.f3033b);
            c2.j();
            return a2;
        } finally {
            c2.h();
        }
    }

    public void c() {
        androidx.work.impl.h a2 = this.f3033b.a();
        androidx.work.impl.e.a(a2.d(), a2.c(), a2.e());
    }

    private static boolean a(androidx.work.impl.f fVar) {
        List<androidx.work.impl.f> h = fVar.h();
        boolean z = false;
        if (h != null) {
            boolean z2 = false;
            for (androidx.work.impl.f fVar2 : h) {
                if (!fVar2.f()) {
                    z2 |= a(fVar2);
                } else {
                    androidx.work.h.a().d(f3032a, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", fVar2.e())), new Throwable[0]);
                }
            }
            z = z2;
        }
        return b(fVar) | z;
    }

    private static boolean b(androidx.work.impl.f fVar) {
        boolean a2 = a(fVar.a(), fVar.d(), (String[]) androidx.work.impl.f.a(fVar).toArray(new String[0]), fVar.b(), fVar.c());
        fVar.g();
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ae A[LOOP:6: B:111:0x01a8->B:113:0x01ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(androidx.work.impl.h hVar, List<? extends o> list, String[] strArr, String str, androidx.work.f fVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        String[] strArr2 = strArr;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase c2 = hVar.c();
        boolean z5 = strArr2 != null && strArr2.length > 0;
        if (z5) {
            z = true;
            z2 = false;
            z3 = false;
            for (String str2 : strArr2) {
                j b2 = c2.p().b(str2);
                if (b2 == null) {
                    androidx.work.h.a().e(f3032a, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                m.a aVar = b2.f2865b;
                z &= aVar == m.a.SUCCEEDED;
                if (aVar == m.a.FAILED) {
                    z2 = true;
                } else if (aVar == m.a.CANCELLED) {
                    z3 = true;
                }
            }
        } else {
            z = true;
            z2 = false;
            z3 = false;
        }
        boolean z6 = !TextUtils.isEmpty(str);
        if (z6 && !z5) {
            List<j.a> c3 = c2.p().c(str);
            if (!c3.isEmpty()) {
                if (fVar == androidx.work.f.APPEND) {
                    androidx.work.impl.b.b q2 = c2.q();
                    ArrayList arrayList = new ArrayList();
                    for (j.a aVar2 : c3) {
                        if (!q2.c(aVar2.f2869a)) {
                            boolean z7 = (aVar2.f2870b == m.a.SUCCEEDED) & z;
                            if (aVar2.f2870b == m.a.FAILED) {
                                z2 = true;
                            } else if (aVar2.f2870b == m.a.CANCELLED) {
                                z3 = true;
                            }
                            arrayList.add(aVar2.f2869a);
                            z = z7;
                        }
                    }
                    strArr2 = (String[]) arrayList.toArray(strArr2);
                    z5 = strArr2.length > 0;
                } else {
                    if (fVar == androidx.work.f.KEEP) {
                        for (j.a aVar3 : c3) {
                            if (aVar3.f2870b == m.a.ENQUEUED || aVar3.f2870b == m.a.RUNNING) {
                                return false;
                            }
                            while (r3.hasNext()) {
                            }
                        }
                    }
                    a.a(str, hVar, false).run();
                    androidx.work.impl.b.k p = c2.p();
                    for (j.a aVar4 : c3) {
                        p.a(aVar4.f2869a);
                    }
                    z4 = true;
                    for (o oVar : list) {
                        j b3 = oVar.b();
                        if (!z5 || z) {
                            if (!b3.a()) {
                                b3.n = currentTimeMillis;
                            } else {
                                j = currentTimeMillis;
                                b3.n = 0L;
                                if (Build.VERSION.SDK_INT < 23 && Build.VERSION.SDK_INT <= 25) {
                                    a(b3);
                                } else if (Build.VERSION.SDK_INT <= 22 && a(hVar, "androidx.work.impl.background.gcm.GcmScheduler")) {
                                    a(b3);
                                }
                                if (b3.f2865b == m.a.ENQUEUED) {
                                    z4 = true;
                                }
                                c2.p().a(b3);
                                if (z5) {
                                    for (String str3 : strArr2) {
                                        c2.q().a(new androidx.work.impl.b.a(oVar.a(), str3));
                                    }
                                }
                                for (String str4 : oVar.c()) {
                                    c2.r().a(new androidx.work.impl.b.m(str4, oVar.a()));
                                }
                                if (!z6) {
                                    c2.t().a(new androidx.work.impl.b.g(str, oVar.a()));
                                }
                                currentTimeMillis = j;
                            }
                        } else if (z2) {
                            b3.f2865b = m.a.FAILED;
                        } else if (z3) {
                            b3.f2865b = m.a.CANCELLED;
                        } else {
                            b3.f2865b = m.a.BLOCKED;
                        }
                        j = currentTimeMillis;
                        if (Build.VERSION.SDK_INT < 23) {
                        }
                        if (Build.VERSION.SDK_INT <= 22) {
                            a(b3);
                        }
                        if (b3.f2865b == m.a.ENQUEUED) {
                        }
                        c2.p().a(b3);
                        if (z5) {
                        }
                        while (r3.hasNext()) {
                        }
                        if (!z6) {
                        }
                        currentTimeMillis = j;
                    }
                    return z4;
                }
            }
        }
        z4 = false;
        while (r8.hasNext()) {
        }
        return z4;
    }

    private static void a(j jVar) {
        androidx.work.c cVar = jVar.j;
        if (cVar.d() || cVar.e()) {
            String str = jVar.f2866c;
            e.a aVar = new e.a();
            aVar.a(jVar.f2868e).a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            jVar.f2866c = ConstraintTrackingWorker.class.getName();
            jVar.f2868e = aVar.a();
        }
    }

    private static boolean a(androidx.work.impl.h hVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (androidx.work.impl.d dVar : hVar.e()) {
                if (cls.isAssignableFrom(dVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
