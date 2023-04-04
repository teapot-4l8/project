package androidx.work.impl.background.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.h;
import androidx.work.impl.a.c;
import androidx.work.impl.b.j;
import androidx.work.impl.d;
import androidx.work.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GreedyScheduler.java */
/* loaded from: classes.dex */
public class a implements androidx.work.impl.a, c, d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2893a = h.a("GreedyScheduler");

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.impl.h f2894b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.work.impl.a.d f2895c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2897e;

    /* renamed from: d  reason: collision with root package name */
    private List<j> f2896d = new ArrayList();
    private final Object f = new Object();

    public a(Context context, androidx.work.impl.utils.b.a aVar, androidx.work.impl.h hVar) {
        this.f2894b = hVar;
        this.f2895c = new androidx.work.impl.a.d(context, aVar, this);
    }

    @Override // androidx.work.impl.d
    public void a(j... jVarArr) {
        a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (j jVar : jVarArr) {
            if (jVar.f2865b == m.a.ENQUEUED && !jVar.a() && jVar.g == 0 && !jVar.b()) {
                if (jVar.d()) {
                    if (Build.VERSION.SDK_INT < 24 || !jVar.j.i()) {
                        arrayList.add(jVar);
                        arrayList2.add(jVar.f2864a);
                    }
                } else {
                    h.a().b(f2893a, String.format("Starting work for %s", jVar.f2864a), new Throwable[0]);
                    this.f2894b.b(jVar.f2864a);
                }
            }
        }
        synchronized (this.f) {
            if (!arrayList.isEmpty()) {
                h.a().b(f2893a, String.format("Starting tracking for [%s]", TextUtils.join(",", arrayList2)), new Throwable[0]);
                this.f2896d.addAll(arrayList);
                this.f2895c.a(this.f2896d);
            }
        }
    }

    @Override // androidx.work.impl.d
    public void a(String str) {
        a();
        h.a().b(f2893a, String.format("Cancelling work ID %s", str), new Throwable[0]);
        this.f2894b.c(str);
    }

    @Override // androidx.work.impl.a.c
    public void a(List<String> list) {
        for (String str : list) {
            h.a().b(f2893a, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f2894b.b(str);
        }
    }

    @Override // androidx.work.impl.a.c
    public void b(List<String> list) {
        for (String str : list) {
            h.a().b(f2893a, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f2894b.c(str);
        }
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        b(str);
    }

    private void b(String str) {
        synchronized (this.f) {
            int size = this.f2896d.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f2896d.get(i).f2864a.equals(str)) {
                    h.a().b(f2893a, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f2896d.remove(i);
                    this.f2895c.a(this.f2896d);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    private void a() {
        if (this.f2897e) {
            return;
        }
        this.f2894b.f().a(this);
        this.f2897e = true;
    }
}
