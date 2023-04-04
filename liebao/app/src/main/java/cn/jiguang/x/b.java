package cn.jiguang.x;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private Context f4247a;

    public b(Context context) {
        this.f4247a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        String g;
        try {
            g = a.g(this.f4247a);
            return g;
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "[GoogleIdCall] failed:" + th.getMessage());
            return "";
        }
    }
}
