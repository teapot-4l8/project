package cn.jiguang.push.asus;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4195a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f4196b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PushMessageReceiver f4197c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PushMessageReceiver pushMessageReceiver, Context context, Intent intent) {
        this.f4197c = pushMessageReceiver;
        this.f4195a = context;
        this.f4196b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4197c.a(this.f4195a, this.f4196b);
    }
}
