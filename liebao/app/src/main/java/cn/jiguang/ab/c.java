package cn.jiguang.ab;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class c implements Callable<cn.jiguang.ac.b> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3651a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public cn.jiguang.ac.b call() {
        Context context;
        try {
            context = this.f3651a.f3649a;
            f a2 = f.a(context);
            a2.c();
            for (int i = 0; i < 30; i++) {
                if (a2.b()) {
                    return a2.a();
                }
                Thread.sleep(1000L);
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JLocation", "JLocationGpsInfo call failed:" + th.getMessage());
            return null;
        }
    }
}
