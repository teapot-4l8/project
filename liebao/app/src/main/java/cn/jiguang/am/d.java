package cn.jiguang.am;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3744a;

    /* renamed from: b  reason: collision with root package name */
    private String f3745b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3746c;

    /* renamed from: d  reason: collision with root package name */
    private Context f3747d;

    public d(c cVar, Context context, String str, Bundle bundle) {
        this.f3744a = cVar;
        this.f3745b = str;
        this.f3746c = bundle;
        this.f3747d = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            cn.jiguang.ap.a.a(this.f3747d, this.f3745b, this.f3746c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
