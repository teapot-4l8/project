package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqs implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbrn = ((Long) zzww.zzra().zzd(zzabq.zzcrg)).longValue();
    private final Context zzaai;
    private final PowerManager zzaaj;
    private final KeyguardManager zzaak;
    private WeakReference<ViewTreeObserver> zzaam;
    private final WindowManager zzbro;
    private BroadcastReceiver zzbrp;
    private WeakReference<View> zzbrq;
    private zzra zzbrr;
    private final Rect zzbrv;
    private final DisplayMetrics zzxe;
    private Application zzyi;
    private com.google.android.gms.ads.internal.util.zzbp zzbrs = new com.google.android.gms.ads.internal.util.zzbp(zzbrn);
    private boolean zzbrt = false;
    private int zzaaq = -1;
    private final HashSet<zzqw> zzbru = new HashSet<>();

    public zzqs(Context context, View view) {
        this.zzaai = context.getApplicationContext();
        this.zzbro = (WindowManager) context.getSystemService("window");
        this.zzaaj = (PowerManager) this.zzaai.getSystemService("power");
        this.zzaak = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzaai;
        if (context2 instanceof Application) {
            this.zzyi = (Application) context2;
            this.zzbrr = new zzra((Application) context2, this);
        }
        this.zzxe = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzbrv = rect;
        rect.right = this.zzbro.getDefaultDisplay().getWidth();
        this.zzbrv.bottom = this.zzbro.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbrq;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzbrq = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzr.zzkx().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void zza(zzqw zzqwVar) {
        this.zzbru.add(zzqwVar);
        zzbu(3);
    }

    public final void zzb(zzqw zzqwVar) {
        this.zzbru.remove(zzqwVar);
    }

    private final void zzcu() {
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzqv
            private final zzqs zzbsd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbsd = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzbsd.zzly();
            }
        });
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaaq = -1;
        zzf(view);
        zzbu(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaaq = -1;
        zzbu(3);
        zzcu();
        zzg(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbrq == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzbrq.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzaaq = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbu(3);
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzbu(3);
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbu(3);
        zzcu();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzbu(3);
        zzcu();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzbu(2);
        zzcu();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzbu(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0135 A[LOOP:0: B:65:0x012f->B:67:0x0135, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzbu(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        List<Rect> emptyList;
        boolean z3;
        Iterator<zzqw> it;
        if (this.zzbru.size() == 0 || (weakReference = this.zzbrq) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z4 = i == 1;
        boolean z5 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Failure getting view location.", e2);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrj)).booleanValue() && view != null) {
            emptyList = zzi(view);
        } else {
            emptyList = Collections.emptyList();
        }
        List<Rect> list = emptyList;
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i2 = this.zzaaq;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        if (!z5) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            if (com.google.android.gms.ads.internal.util.zzj.zza(view, this.zzaaj, this.zzaak) && z && z2 && windowVisibility == 0) {
                z3 = true;
                if (z4 || this.zzbrs.tryAcquire() || z3 != this.zzbrt) {
                    if (z3 && !this.zzbrt && i == 1) {
                        return;
                    }
                    zzqx zzqxVar = new zzqx(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime(), this.zzaaj.isScreenOn(), view == null && com.google.android.gms.ads.internal.zzr.zzkx().isAttachedToWindow(view), view == null ? view.getWindowVisibility() : 8, zza(this.zzbrv), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzxe.density, z3, list);
                    it = this.zzbru.iterator();
                    while (it.hasNext()) {
                        it.next().zza(zzqxVar);
                    }
                    this.zzbrt = z3;
                }
                return;
            }
        }
        z3 = false;
        if (z4) {
        }
        if (z3) {
        }
        zzqx zzqxVar2 = new zzqx(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime(), this.zzaaj.isScreenOn(), view == null && com.google.android.gms.ads.internal.zzr.zzkx().isAttachedToWindow(view), view == null ? view.getWindowVisibility() : 8, zza(this.zzbrv), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzxe.density, z3, list);
        it = this.zzbru.iterator();
        while (it.hasNext()) {
        }
        this.zzbrt = z3;
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbv(rect.left), zzbv(rect.top), zzbv(rect.right), zzbv(rect.bottom));
    }

    private final int zzbv(int i) {
        return (int) (i / this.zzxe.density);
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaam = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbrp == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbrp = new zzqu(this);
            com.google.android.gms.ads.internal.zzr.zzlq().zza(this.zzaai, this.zzbrp, intentFilter);
        }
        Application application = this.zzyi;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbrr);
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error registering activity lifecycle callbacks.", e2);
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
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        if (this.zzbrp != null) {
            try {
                com.google.android.gms.ads.internal.zzr.zzlq().zza(this.zzaai, this.zzbrp);
            } catch (IllegalStateException e4) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e5, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbrp = null;
        }
        Application application = this.zzyi;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbrr);
            } catch (Exception e6) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    public final void zzen(long j) {
        this.zzbrs.zzfc(j);
    }

    public final void zzlx() {
        this.zzbrs.zzfc(zzbrn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzly() {
        zzbu(3);
    }
}
