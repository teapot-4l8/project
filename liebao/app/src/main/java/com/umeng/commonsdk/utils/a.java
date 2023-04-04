package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: CountDownTimer.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f6948e = 1;

    /* renamed from: a  reason: collision with root package name */
    private final long f6949a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6950b;

    /* renamed from: c  reason: collision with root package name */
    private long f6951c;
    private HandlerThread f;
    private Handler g;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6952d = false;
    private Handler.Callback h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f6952d) {
                    return true;
                }
                long elapsedRealtime = a.this.f6951c - SystemClock.elapsedRealtime();
                if (elapsedRealtime > 0) {
                    if (elapsedRealtime < a.this.f6950b) {
                        a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.f6950b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += a.this.f6950b;
                        }
                        a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime3);
                    }
                } else {
                    a.this.c();
                    if (a.this.f != null) {
                        a.this.f.quit();
                    }
                }
                return false;
            }
        }
    };

    public abstract void a(long j);

    public abstract void c();

    public a(long j, long j2) {
        this.f6949a = j;
        this.f6950b = j2;
        if (!d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f = handlerThread;
            handlerThread.start();
            this.g = new Handler(this.f.getLooper(), this.h);
            return;
        }
        this.g = new Handler(this.h);
    }

    public final synchronized void a() {
        this.f6952d = true;
        this.g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f6952d = false;
        if (this.f6949a <= 0) {
            c();
            return this;
        }
        this.f6951c = SystemClock.elapsedRealtime() + this.f6949a;
        this.g.sendMessage(this.g.obtainMessage(1));
        return this;
    }

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }
}
