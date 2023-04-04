package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f6130a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6131b;

    /* renamed from: c  reason: collision with root package name */
    private long f6132c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6133d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6134e = true;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Handler handler, String str, long j) {
        this.f6130a = handler;
        this.f6131b = str;
        this.f6132c = j;
        this.f6133d = j;
    }

    public final void a() {
        if (this.f6134e) {
            this.f6134e = false;
            this.f = SystemClock.uptimeMillis();
            this.f6130a.postAtFrontOfQueue(this);
        }
    }

    public final boolean b() {
        return !this.f6134e && SystemClock.uptimeMillis() > this.f + this.f6132c;
    }

    public final int c() {
        if (this.f6134e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f < this.f6132c ? 1 : 3;
    }

    public final Thread d() {
        return this.f6130a.getLooper().getThread();
    }

    public final String e() {
        return this.f6131b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6134e = true;
        this.f6132c = this.f6133d;
    }

    public final void a(long j) {
        this.f6132c = Long.MAX_VALUE;
    }

    public final void f() {
        this.f6132c = this.f6133d;
    }
}
