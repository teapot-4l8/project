package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.umeng.analytics.pro.bz;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfj implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzaah = new Handler(Looper.getMainLooper());
    private final Context zzaai;
    private final PowerManager zzaaj;
    private final KeyguardManager zzaak;
    private BroadcastReceiver zzaal;
    private WeakReference<ViewTreeObserver> zzaam;
    private WeakReference<View> zzaan;
    private zzel zzaao;
    private byte zzaap = -1;
    private int zzaaq = -1;
    private long zzaar = -3;
    private Application zzyi;
    private final zzfa zzyu;

    public zzfj(Context context, zzfa zzfaVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzaai = applicationContext;
        this.zzyu = zzfaVar;
        this.zzaaj = (PowerManager) applicationContext.getSystemService("power");
        this.zzaak = (KeyguardManager) this.zzaai.getSystemService("keyguard");
        Context context2 = this.zzaai;
        if (context2 instanceof Application) {
            this.zzyi = (Application) context2;
            this.zzaao = new zzel((Application) context2, this);
        }
        zze(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(View view) {
        View currentView = getCurrentView();
        if (currentView != null) {
            currentView.removeOnAttachStateChangeListener(this);
            zzg(currentView);
        }
        this.zzaan = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.zzaar = -2L;
            return;
        }
        this.zzaar = -3L;
    }

    private final View getCurrentView() {
        WeakReference<View> weakReference = this.zzaan;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final void zzcu() {
        zzaah.post(new zzfm(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaaq = -1;
        zzf(view);
        zzcw();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaaq = -1;
        zzcw();
        zzcu();
        zzg(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzaan == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View currentView = getCurrentView();
        if (currentView == null || peekDecorView == null || currentView.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzaaq = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzcw();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzcw();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzcw();
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzcw();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzcw();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcw();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzcw();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzcw();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzcw();
    }

    public final long zzcv() {
        if (this.zzaar <= -2 && getCurrentView() == null) {
            this.zzaar = -3L;
        }
        return this.zzaar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
        if (r7 == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzcw() {
        if (this.zzaan == null) {
            return;
        }
        View currentView = getCurrentView();
        if (currentView == null) {
            this.zzaar = -3L;
            this.zzaap = (byte) -1;
            return;
        }
        boolean z = true;
        byte b2 = currentView.getVisibility() != 0 ? (byte) 1 : (byte) 0;
        if (!currentView.isShown()) {
            b2 = (byte) (b2 | 2);
        }
        PowerManager powerManager = this.zzaaj;
        if (powerManager != null && !powerManager.isScreenOn()) {
            b2 = (byte) (b2 | 4);
        }
        if (!this.zzyu.zzcg()) {
            KeyguardManager keyguardManager = this.zzaak;
            if (keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode()) {
                Activity zzd = zzfh.zzd(currentView);
                if (zzd != null) {
                    Window window = zzd.getWindow();
                    WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
                    boolean z2 = (attributes == null || (attributes.flags & 524288) == 0) ? false : true;
                }
            }
            z = false;
        }
        if (!z) {
            b2 = (byte) (b2 | 8);
        }
        if (!currentView.getGlobalVisibleRect(new Rect())) {
            b2 = (byte) (b2 | bz.n);
        }
        if (!currentView.getLocalVisibleRect(new Rect())) {
            b2 = (byte) (b2 | 32);
        }
        int windowVisibility = currentView.getWindowVisibility();
        int i = this.zzaaq;
        if (i != -1) {
            windowVisibility = i;
        }
        if (windowVisibility != 0) {
            b2 = (byte) (b2 | 64);
        }
        if (this.zzaap != b2) {
            this.zzaap = b2;
            this.zzaar = b2 == 0 ? SystemClock.elapsedRealtime() : (-3) - b2;
        }
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaam = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzaal == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzfl zzflVar = new zzfl(this);
            this.zzaal = zzflVar;
            this.zzaai.registerReceiver(zzflVar, intentFilter);
        }
        Application application = this.zzyi;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzaao);
            } catch (Exception unused) {
            }
        }
    }

    private final void zzg(View view) {
        try {
            if (this.zzaam != null) {
                ViewTreeObserver viewTreeObserver = this.zzaam.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaam = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzaal;
        if (broadcastReceiver != null) {
            try {
                this.zzaai.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzaal = null;
        }
        Application application = this.zzyi;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzaao);
            } catch (Exception unused4) {
            }
        }
    }
}
