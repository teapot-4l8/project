package cn.jiguang.analytics.page;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    boolean f3762a;

    /* renamed from: b  reason: collision with root package name */
    Context f3763b;

    /* renamed from: c  reason: collision with root package name */
    PushSA f3764c;

    public d(boolean z, Context context, PushSA pushSA) {
        this.f3762a = z;
        this.f3763b = context;
        this.f3764c = pushSA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3762a) {
                this.f3764c.sendLogRoutine(this.f3763b);
            } else {
                this.f3764c.saveLogRoutine(this.f3763b);
            }
        } catch (Throwable unused) {
        }
    }
}
