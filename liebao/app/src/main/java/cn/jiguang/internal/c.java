package cn.jiguang.internal;

import android.content.Context;
import cn.jiguang.an.d;

/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4112a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f4113b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f4114c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ JCoreInternalHelper f4115d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(JCoreInternalHelper jCoreInternalHelper, Context context, String str, Object obj) {
        this.f4115d = jCoreInternalHelper;
        this.f4112a = context;
        this.f4113b = str;
        this.f4114c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JCoreHelperAction jCoreHelperAction;
        try {
            this.f4115d.initLoad(this.f4112a);
            jCoreHelperAction = JCoreInternalHelper.jCoreHelperAction;
            jCoreHelperAction.onCommonMethod(this.f4112a, this.f4113b, this.f4114c);
        } catch (Throwable th) {
            d.f("JCoreInternalHelper", "commonMethod e:" + th);
        }
    }
}
