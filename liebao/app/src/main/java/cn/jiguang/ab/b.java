package cn.jiguang.ab;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class b implements Callable<cn.jiguang.ac.a> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3650a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public cn.jiguang.ac.a call() {
        Context context;
        try {
            context = this.f3650a.f3649a;
            d dVar = new d(context);
            dVar.b();
            for (int i = 0; i < 20; i++) {
                cn.jiguang.ac.a a2 = dVar.a();
                if (a2 != null) {
                    return a2;
                }
                Thread.sleep(2000L);
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JLocation", "JLocationCellInfo call failed:" + th.getMessage());
            return null;
        }
    }
}
