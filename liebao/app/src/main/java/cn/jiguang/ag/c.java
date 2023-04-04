package cn.jiguang.ag;

import android.content.Context;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3690a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3691b;

    private c(a aVar, Context context) {
        this.f3690a = aVar;
        this.f3691b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(a aVar, Context context, byte b2) {
        this(aVar, context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            cn.jiguang.u.a.a(this.f3691b, cn.jiguang.u.a.e(this.f3691b));
            this.f3690a.i(this.f3691b);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWake", "RegisterAction failed:" + th.getMessage());
        }
    }
}
