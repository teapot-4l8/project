package b.a.j;

import android.os.Handler;
import android.os.Looper;
import b.a.h.a.b;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f3244a;

    /* renamed from: b  reason: collision with root package name */
    private Callable f3245b;

    /* renamed from: c  reason: collision with root package name */
    private a f3246c;

    /* renamed from: d  reason: collision with root package name */
    private long f3247d = 10;

    /* renamed from: e  reason: collision with root package name */
    private Handler f3248e = new Handler(Looper.getMainLooper());

    public b(ThreadPoolExecutor threadPoolExecutor, Callable callable, a aVar) {
        this.f3244a = threadPoolExecutor;
        this.f3245b = callable;
        this.f3246c = aVar;
    }

    public void a(long j) {
        this.f3247d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a.h.a.b bVar;
        Future submit = this.f3244a.submit(this.f3245b);
        try {
            bVar = (b.a.h.a.b) submit.get(this.f3247d, TimeUnit.SECONDS);
        } catch (TimeoutException e2) {
            submit.cancel(true);
            b.a.h.a.b bVar2 = new b.a.h.a.b(b.a.ERROR, -4);
            bVar2.b("request timeout : " + e2.getMessage());
            bVar = bVar2;
        } catch (Exception e3) {
            bVar = new b.a.h.a.b(b.a.ERROR, -2);
            bVar.b("request error : " + e3.getMessage());
        }
        this.f3248e.post(new c(this, bVar));
    }
}
