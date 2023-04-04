package cn.jiguang.analytics.page;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3760a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PushSA f3761b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PushSA pushSA, Context context) {
        this.f3761b = pushSA;
        this.f3760a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3761b.saveLogRoutine(this.f3760a);
        } catch (Throwable unused) {
        }
    }
}
