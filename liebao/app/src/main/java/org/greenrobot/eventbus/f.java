package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster.java */
/* loaded from: classes2.dex */
public class f extends Handler implements l {

    /* renamed from: a  reason: collision with root package name */
    private final k f7808a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7809b;

    /* renamed from: c  reason: collision with root package name */
    private final c f7810c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7811d;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(c cVar, Looper looper, int i) {
        super(looper);
        this.f7810c = cVar;
        this.f7809b = i;
        this.f7808a = new k();
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f7808a.a(a2);
            if (!this.f7811d) {
                this.f7811d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                j a2 = this.f7808a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f7808a.a();
                        if (a2 == null) {
                            this.f7811d = false;
                            return;
                        }
                    }
                }
                this.f7810c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f7809b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f7811d = true;
        } finally {
            this.f7811d = false;
        }
    }
}
