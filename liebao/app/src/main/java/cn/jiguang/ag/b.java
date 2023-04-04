package cn.jiguang.ag;

import android.content.Context;
import cn.jiguang.o.f;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3688a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Context context) {
        this.f3688a = aVar;
        this.f3689b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3688a.a(this.f3689b);
            if (f.h(this.f3689b, "JWake")) {
                this.f3688a.a(this.f3689b, "JWake");
            } else {
                cn.jiguang.ad.a.d("JWake", "can't wake because wakeConfig not allow");
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWake", "dealAction throwable:" + th.getMessage());
        }
    }
}
