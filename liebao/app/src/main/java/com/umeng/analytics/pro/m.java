package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import com.youth.banner.config.BannerConfig;
import java.util.ArrayList;

/* compiled from: BackgroundMonitor.java */
/* loaded from: classes2.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static m f6584a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final int f6585b = BannerConfig.LOOP_TIME;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6586c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6587d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f6588e = new Handler(Looper.getMainLooper());
    private ArrayList<n> f = new ArrayList<>();
    private a g = new a();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* compiled from: BackgroundMonitor.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f6586c && m.this.f6587d) {
                m.this.f6586c = false;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
                for (int i = 0; i < m.this.f.size(); i++) {
                    ((n) m.this.f.get(i)).n();
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f6584a);
        }
    }

    public static m a() {
        return f6584a;
    }

    private m() {
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f.add(nVar);
        }
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) == nVar) {
                    this.f.remove(i);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f6587d = false;
        this.f6586c = true;
        a aVar = this.g;
        if (aVar != null) {
            this.f6588e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f6587d = true;
        a aVar = this.g;
        if (aVar != null) {
            this.f6588e.removeCallbacks(aVar);
            this.f6588e.postDelayed(this.g, 3000L);
        }
    }
}
