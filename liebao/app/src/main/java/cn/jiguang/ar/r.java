package cn.jiguang.ar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class r {
    private Object g;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f3864d = new AtomicBoolean(true);
    private volatile long f = 0;
    private CountDownLatch h = new CountDownLatch(1);

    /* renamed from: a  reason: collision with root package name */
    private final int f3861a = 2000;

    /* renamed from: e  reason: collision with root package name */
    private final a<Object> f3865e = null;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f3862b = new s(this, 5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: c  reason: collision with root package name */
    private final Handler f3863c = new u(this.f3862b);

    public r(int i, int i2, a<Object> aVar) {
    }

    private synchronized long b(long j) {
        long j2 = this.f + j;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (j2 < uptimeMillis) {
            this.f = uptimeMillis;
            return -1L;
        }
        this.f = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Looper c() {
        t tVar = new t("Step");
        tVar.start();
        Looper looper = tVar.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public final synchronized Object a(long j) {
        if (a()) {
            return this.g;
        } else if (this.f3864d.get()) {
            return null;
        } else {
            try {
                if (j != -1) {
                    this.h.await(j, TimeUnit.MILLISECONDS);
                } else {
                    this.h.await();
                }
            } catch (InterruptedException unused) {
            }
            if (this.h.getCount() == 0) {
                this.h = new CountDownLatch(1);
            }
            return this.g;
        }
    }

    public final void a(Object obj) {
        if (a() || obj == null) {
            return;
        }
        this.g = obj;
        this.h.countDown();
        this.f3863c.removeMessages(233);
        this.f3862b.shutdownNow();
        try {
            this.f3863c.getLooper().quit();
        } catch (Throwable unused) {
        }
        cn.jiguang.an.d.b("Step", "done!");
    }

    public final void a(Callable<?> callable) {
        try {
            long b2 = b(this.f3861a);
            if (b2 < 0) {
                this.f3862b.submit(callable);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 233;
                obtain.obj = callable;
                this.f3863c.sendMessageAtTime(obtain, b2);
            }
            this.f3864d.set(false);
        } catch (Throwable unused) {
        }
    }

    public final boolean a() {
        return this.g != null;
    }

    public final void b() {
        try {
            if (this.f3862b != null) {
                this.f3862b.getQueue().clear();
                this.f3863c.removeMessages(233);
            }
        } catch (Throwable th) {
            Log.w("Step", "clean executor e:" + th);
        }
    }
}
