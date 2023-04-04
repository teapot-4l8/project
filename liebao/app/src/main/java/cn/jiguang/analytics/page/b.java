package cn.jiguang.analytics.page;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3758a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PushSA f3759b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PushSA pushSA, Context context) {
        this.f3759b = pushSA;
        this.f3758a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3759b.saveLogRoutine(this.f3758a);
        } catch (Throwable unused) {
        }
    }
}
