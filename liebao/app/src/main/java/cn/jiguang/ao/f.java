package cn.jiguang.ao;

import android.content.Context;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        this.f3780a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        String e2;
        try {
            atomicBoolean = d.f3779d;
            atomicBoolean.set(true);
            e2 = d.e(this.f3780a);
            File[] a2 = cn.jiguang.f.e.a(e2, cn.jiguang.f.f.f4073b);
            if (a2 != null) {
                for (File file : a2) {
                    d.a(this.f3780a, file);
                }
            } else {
                cn.jiguang.an.d.b("ReportHistory", "no history, no report");
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
