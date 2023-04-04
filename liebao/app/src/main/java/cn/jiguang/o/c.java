package cn.jiguang.o;

import android.content.Context;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4165a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4166b;

    /* renamed from: c  reason: collision with root package name */
    private String f4167c;

    public c(a aVar, Context context, String str) {
        this.f4165a = aVar;
        this.f4166b = context;
        this.f4167c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.b(this.f4165a, this.f4166b, this.f4167c);
        } catch (Throwable unused) {
        }
    }
}
