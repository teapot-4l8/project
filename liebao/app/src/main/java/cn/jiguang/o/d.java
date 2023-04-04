package cn.jiguang.o;

import android.content.Context;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4168a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4169b;

    /* renamed from: c  reason: collision with root package name */
    private String f4170c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Context context, String str) {
        this.f4168a = aVar;
        this.f4169b = context;
        this.f4170c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.a(this.f4168a, this.f4169b, this.f4170c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
