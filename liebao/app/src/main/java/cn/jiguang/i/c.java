package cn.jiguang.i;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4092a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4093b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f4094c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Context context, Intent intent) {
        this.f4092a = bVar;
        this.f4093b = context;
        this.f4094c = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b.a(this.f4092a, this.f4093b, this.f4094c);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JAppMovement", "dealMovementAction throwable:" + th.getMessage());
        }
    }
}
