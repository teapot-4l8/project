package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.an.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4102a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f4103b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f4104c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f4105d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f4106e;
    final /* synthetic */ Object[] f;
    final /* synthetic */ JCoreInternalHelper g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(JCoreInternalHelper jCoreInternalHelper, Context context, String str, int i, String str2, Bundle bundle, Object[] objArr) {
        this.g = jCoreInternalHelper;
        this.f4102a = context;
        this.f4103b = str;
        this.f4104c = i;
        this.f4105d = str2;
        this.f4106e = bundle;
        this.f = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JCoreHelperAction jCoreHelperAction;
        try {
            this.g.initLoad(this.f4102a);
            jCoreHelperAction = JCoreInternalHelper.jCoreHelperAction;
            jCoreHelperAction.onEvent(this.f4102a, this.f4103b, this.f4104c, this.f4105d, this.f4106e, this.f);
        } catch (Throwable th) {
            d.f("JCoreInternalHelper", "onEvent e:" + th);
        }
    }
}
