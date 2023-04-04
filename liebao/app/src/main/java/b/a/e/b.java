package b.a.e;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class b extends b.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f3137a = null;

    /* renamed from: b  reason: collision with root package name */
    private Handler f3138b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3139c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f3140d = true;

    public abstract void a(long j);

    public abstract void b(long j);

    @Override // b.a.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
        this.f3140d = true;
        Runnable runnable = this.f3137a;
        if (runnable != null) {
            this.f3138b.removeCallbacks(runnable);
        }
        c cVar = new c(this);
        this.f3137a = cVar;
        this.f3138b.postDelayed(cVar, 500L);
    }

    @Override // b.a.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        boolean z = !this.f3139c;
        this.f3139c = true;
        this.f3140d = false;
        Runnable runnable = this.f3137a;
        if (runnable != null) {
            this.f3138b.removeCallbacks(runnable);
            this.f3137a = null;
        }
        if (z) {
            a(System.currentTimeMillis());
        }
    }
}
