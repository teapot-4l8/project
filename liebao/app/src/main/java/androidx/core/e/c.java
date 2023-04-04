package androidx.core.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f1536b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f1537c;
    private final int f;
    private final int g;
    private final String h;

    /* renamed from: a  reason: collision with root package name */
    private final Object f1535a = new Object();

    /* renamed from: e  reason: collision with root package name */
    private Handler.Callback f1539e = new Handler.Callback() { // from class: androidx.core.e.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c.this.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                c.this.a((Runnable) message.obj);
                return true;
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private int f1538d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.f1535a) {
            if (this.f1536b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.f1536b = handlerThread;
                handlerThread.start();
                this.f1537c = new Handler(this.f1536b.getLooper(), this.f1539e);
                this.f1538d++;
            }
            this.f1537c.removeMessages(0);
            this.f1537c.sendMessage(this.f1537c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(final Callable<T> callable, final a<T> aVar) {
        final Handler handler = new Handler();
        b(new Runnable() { // from class: androidx.core.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                handler.post(new Runnable() { // from class: androidx.core.e.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(obj);
                    }
                });
            }
        });
    }

    public <T> T a(final Callable<T> callable, int i) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new Runnable() { // from class: androidx.core.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f1535a) {
            this.f1537c.removeMessages(0);
            this.f1537c.sendMessageDelayed(this.f1537c.obtainMessage(0), this.f);
        }
    }

    void a() {
        synchronized (this.f1535a) {
            if (this.f1537c.hasMessages(1)) {
                return;
            }
            this.f1536b.quit();
            this.f1536b = null;
            this.f1537c = null;
        }
    }
}
