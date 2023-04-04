package cn.jiguang.as;

import android.util.Pair;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements Callable<LinkedHashSet<cn.jiguang.ar.h>> {

    /* renamed from: a  reason: collision with root package name */
    private String f3916a;

    /* renamed from: b  reason: collision with root package name */
    private m f3917b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, m mVar) {
        this.f3916a = str;
        this.f3917b = mVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ LinkedHashSet<cn.jiguang.ar.h> call() {
        LinkedHashSet<cn.jiguang.ar.h> a2 = m.a(this.f3916a);
        if (a2 != null && a2.size() > 0) {
            m.a(this.f3917b, this.f3916a, new Pair(a2, Long.valueOf(System.currentTimeMillis())));
        }
        return a2;
    }
}
