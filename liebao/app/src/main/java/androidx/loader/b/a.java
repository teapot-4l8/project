package androidx.loader.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.g.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: AsyncTaskLoader.java */
/* loaded from: classes.dex */
public abstract class a<D> extends c<D> {

    /* renamed from: a  reason: collision with root package name */
    volatile a<D>.RunnableC0049a f2063a;

    /* renamed from: b  reason: collision with root package name */
    volatile a<D>.RunnableC0049a f2064b;

    /* renamed from: c  reason: collision with root package name */
    long f2065c;

    /* renamed from: d  reason: collision with root package name */
    long f2066d;

    /* renamed from: e  reason: collision with root package name */
    Handler f2067e;
    private final Executor f;

    public void a(D d2) {
    }

    public abstract D d();

    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: androidx.loader.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0049a extends d<Void, Void, D> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f2068a;
        private final CountDownLatch f = new CountDownLatch(1);

        RunnableC0049a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.b.d
        public D a(Void... voidArr) {
            try {
                return (D) a.this.e();
            } catch (androidx.core.d.c e2) {
                if (c()) {
                    return null;
                }
                throw e2;
            }
        }

        @Override // androidx.loader.b.d
        protected void a(D d2) {
            try {
                a.this.b(this, d2);
            } finally {
                this.f.countDown();
            }
        }

        @Override // androidx.loader.b.d
        protected void b(D d2) {
            try {
                a.this.a(this, d2);
            } finally {
                this.f.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2068a = false;
            a.this.c();
        }
    }

    public a(Context context) {
        this(context, d.f2074c);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.f2066d = -10000L;
        this.f = executor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.b.c
    public void a() {
        super.a();
        r();
        this.f2063a = new RunnableC0049a();
        c();
    }

    @Override // androidx.loader.b.c
    protected boolean b() {
        if (this.f2063a != null) {
            if (!this.r) {
                this.u = true;
            }
            if (this.f2064b != null) {
                if (this.f2063a.f2068a) {
                    this.f2063a.f2068a = false;
                    this.f2067e.removeCallbacks(this.f2063a);
                }
                this.f2063a = null;
                return false;
            } else if (this.f2063a.f2068a) {
                this.f2063a.f2068a = false;
                this.f2067e.removeCallbacks(this.f2063a);
                this.f2063a = null;
                return false;
            } else {
                boolean a2 = this.f2063a.a(false);
                if (a2) {
                    this.f2064b = this.f2063a;
                    f();
                }
                this.f2063a = null;
                return a2;
            }
        }
        return false;
    }

    void c() {
        if (this.f2064b != null || this.f2063a == null) {
            return;
        }
        if (this.f2063a.f2068a) {
            this.f2063a.f2068a = false;
            this.f2067e.removeCallbacks(this.f2063a);
        }
        if (this.f2065c > 0 && SystemClock.uptimeMillis() < this.f2066d + this.f2065c) {
            this.f2063a.f2068a = true;
            this.f2067e.postAtTime(this.f2063a, this.f2066d + this.f2065c);
            return;
        }
        this.f2063a.a(this.f, null);
    }

    void a(a<D>.RunnableC0049a runnableC0049a, D d2) {
        a((a<D>) d2);
        if (this.f2064b == runnableC0049a) {
            z();
            this.f2066d = SystemClock.uptimeMillis();
            this.f2064b = null;
            l();
            c();
        }
    }

    void b(a<D>.RunnableC0049a runnableC0049a, D d2) {
        if (this.f2063a != runnableC0049a) {
            a(runnableC0049a, d2);
        } else if (o()) {
            a((a<D>) d2);
        } else {
            y();
            this.f2066d = SystemClock.uptimeMillis();
            this.f2063a = null;
            b(d2);
        }
    }

    protected D e() {
        return d();
    }

    public boolean g() {
        return this.f2064b != null;
    }

    @Override // androidx.loader.b.c
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.f2063a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f2063a);
            printWriter.print(" waiting=");
            printWriter.println(this.f2063a.f2068a);
        }
        if (this.f2064b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f2064b);
            printWriter.print(" waiting=");
            printWriter.println(this.f2064b.f2068a);
        }
        if (this.f2065c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            g.a(this.f2065c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            g.a(this.f2066d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
