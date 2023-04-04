package cn.jiguang.analytics.page;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3756a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PushSA f3757b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PushSA pushSA, Context context) {
        this.f3757b = pushSA;
        this.f3756a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3757b.sendLogRoutine(this.f3756a);
        } catch (Throwable unused) {
        }
    }
}
