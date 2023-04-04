package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.h;
import androidx.lifecycle.v;

/* compiled from: ProcessLifecycleOwner.java */
/* loaded from: classes.dex */
public class u implements l {
    private static final u i = new u();
    private Handler f;

    /* renamed from: b  reason: collision with root package name */
    private int f2033b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f2034c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2035d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2036e = true;
    private final m g = new m(this);
    private Runnable h = new Runnable() { // from class: androidx.lifecycle.u.1
        @Override // java.lang.Runnable
        public void run() {
            u.this.e();
            u.this.f();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    v.a f2032a = new v.a() { // from class: androidx.lifecycle.u.2
        @Override // androidx.lifecycle.v.a
        public void a() {
        }

        @Override // androidx.lifecycle.v.a
        public void b() {
            u.this.a();
        }

        @Override // androidx.lifecycle.v.a
        public void c() {
            u.this.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        i.b(context);
    }

    void a() {
        int i2 = this.f2033b + 1;
        this.f2033b = i2;
        if (i2 == 1 && this.f2036e) {
            this.g.a(h.a.ON_START);
            this.f2036e = false;
        }
    }

    void b() {
        int i2 = this.f2034c + 1;
        this.f2034c = i2;
        if (i2 == 1) {
            if (this.f2035d) {
                this.g.a(h.a.ON_RESUME);
                this.f2035d = false;
                return;
            }
            this.f.removeCallbacks(this.h);
        }
    }

    void c() {
        int i2 = this.f2034c - 1;
        this.f2034c = i2;
        if (i2 == 0) {
            this.f.postDelayed(this.h, 700L);
        }
    }

    void d() {
        this.f2033b--;
        f();
    }

    void e() {
        if (this.f2034c == 0) {
            this.f2035d = true;
            this.g.a(h.a.ON_PAUSE);
        }
    }

    void f() {
        if (this.f2033b == 0 && this.f2035d) {
            this.g.a(h.a.ON_STOP);
            this.f2036e = true;
        }
    }

    private u() {
    }

    void b(Context context) {
        this.f = new Handler();
        this.g.a(h.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: androidx.lifecycle.u.3
            @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                v.b(activity).a(u.this.f2032a);
            }

            @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                u.this.c();
            }

            @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                u.this.d();
            }
        });
    }

    @Override // androidx.lifecycle.l
    public h getLifecycle() {
        return this.g;
    }
}
