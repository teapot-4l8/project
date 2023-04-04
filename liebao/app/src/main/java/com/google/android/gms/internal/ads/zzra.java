package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzra implements Application.ActivityLifecycleCallbacks {
    private final Application zzyi;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyj;
    private boolean zzyk = false;

    public zzra(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyj = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyi = application;
    }

    private final void zza(zzri zzriVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzyj.get();
            if (activityLifecycleCallbacks != null) {
                zzriVar.zza(activityLifecycleCallbacks);
            } else if (this.zzyk) {
            } else {
                this.zzyi.unregisterActivityLifecycleCallbacks(this);
                this.zzyk = true;
            }
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error while dispatching lifecycle callback.", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzrd(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzrc(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzrf(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzre(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzrh(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzrg(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzrj(this, activity));
    }
}
