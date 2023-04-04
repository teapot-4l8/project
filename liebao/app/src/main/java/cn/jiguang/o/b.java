package cn.jiguang.o;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4161a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4162b;

    /* renamed from: c  reason: collision with root package name */
    private String f4163c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f4164d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Context context, String str, Bundle bundle) {
        this.f4161a = aVar;
        this.f4162b = context;
        this.f4163c = str;
        this.f4164d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.a(this.f4161a, this.f4162b, this.f4163c, this.f4164d);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JCommon", "BundleAction failed:" + th.getMessage());
        }
    }
}
