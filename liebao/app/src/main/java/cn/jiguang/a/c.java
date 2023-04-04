package cn.jiguang.a;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.an.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    Context f3644a;

    /* renamed from: b  reason: collision with root package name */
    boolean f3645b;

    /* renamed from: c  reason: collision with root package name */
    String f3646c;

    /* renamed from: d  reason: collision with root package name */
    Bundle f3647d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, boolean z, String str, Bundle bundle) {
        this.f3644a = context;
        this.f3645b = z;
        this.f3646c = str;
        this.f3647d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3645b) {
                if (a.b(this.f3644a)) {
                    cn.jiguang.am.c.a().b(this.f3644a, this.f3646c, this.f3647d);
                }
            } else if (a.a(this.f3644a)) {
                cn.jiguang.am.c.a();
                cn.jiguang.am.c.a(this.f3644a, this.f3646c, this.f3647d);
            }
        } catch (Throwable th) {
            d.h("JCoreGobal", "do action error:" + th.getMessage());
        }
    }
}
