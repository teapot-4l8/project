package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
final class zzay implements Application.ActivityLifecycleCallbacks {
    private final Activity zza;
    private final /* synthetic */ zzat zzb;

    public zzay(zzat zzatVar, Activity activity) {
        this.zzb = zzatVar;
        this.zza = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (activity != this.zza) {
            return;
        }
        this.zzb.zzb(new zzk(3, "Activity is destroyed."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza() {
        zzat.zza(this.zzb).unregisterActivityLifecycleCallbacks(this);
    }
}
