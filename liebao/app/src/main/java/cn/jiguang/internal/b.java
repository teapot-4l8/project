package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.an.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4107a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f4108b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4109c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f4110d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ JCoreInternalHelper f4111e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(JCoreInternalHelper jCoreInternalHelper, Context context, String str, String str2, Bundle bundle) {
        this.f4111e = jCoreInternalHelper;
        this.f4107a = context;
        this.f4108b = str;
        this.f4109c = str2;
        this.f4110d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JCoreHelperAction jCoreHelperAction;
        try {
            this.f4111e.initLoad(this.f4107a);
            jCoreHelperAction = JCoreInternalHelper.jCoreHelperAction;
            jCoreHelperAction.directHandle(this.f4107a, this.f4108b, this.f4109c, this.f4110d);
        } catch (Throwable th) {
            d.f("JCoreInternalHelper", "directHandle e:" + th);
        }
    }
}
