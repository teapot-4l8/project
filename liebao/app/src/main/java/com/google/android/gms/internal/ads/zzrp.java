package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzrp implements Application.ActivityLifecycleCallbacks {
    private Context context;
    private Activity zzaax;
    private Runnable zzbtp;
    private long zzbtq;
    private final Object lock = new Object();
    private boolean foreground = true;
    private boolean zzbtm = false;
    private final List<zzrr> zzbtn = new ArrayList();
    private final List<zzsc> zzbto = new ArrayList();
    private boolean zzzq = false;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (this.zzzq) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            setActivity((Activity) context);
        }
        this.context = application;
        this.zzbtq = ((Long) zzww.zzra().zzd(zzabq.zzcqa)).longValue();
        this.zzzq = true;
    }

    public final void zza(zzrr zzrrVar) {
        synchronized (this.lock) {
            this.zzbtn.add(zzrrVar);
        }
    }

    public final void zzb(zzrr zzrrVar) {
        synchronized (this.lock) {
            this.zzbtn.remove(zzrrVar);
        }
    }

    public final Activity getActivity() {
        return this.zzaax;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbtm = false;
        boolean z = !this.foreground;
        this.foreground = true;
        if (this.zzbtp != null) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.removeCallbacks(this.zzbtp);
        }
        synchronized (this.lock) {
            for (zzsc zzscVar : this.zzbto) {
                try {
                    zzscVar.onActivityResumed(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbao.zzc("", e2);
                }
            }
            if (z) {
                for (zzrr zzrrVar : this.zzbtn) {
                    try {
                        zzrrVar.zzq(true);
                    } catch (Exception e3) {
                        zzbao.zzc("", e3);
                    }
                }
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzdz("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzsc zzscVar : this.zzbto) {
                try {
                    zzscVar.onActivityPaused(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbao.zzc("", e2);
                }
            }
        }
        this.zzbtm = true;
        if (this.zzbtp != null) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.removeCallbacks(this.zzbtp);
        }
        zzdxi zzdxiVar = com.google.android.gms.ads.internal.util.zzj.zzegq;
        zzro zzroVar = new zzro(this);
        this.zzbtp = zzroVar;
        zzdxiVar.postDelayed(zzroVar, this.zzbtq);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzaax == null) {
                return;
            }
            if (this.zzaax.equals(activity)) {
                this.zzaax = null;
            }
            Iterator<zzsc> it = this.zzbto.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzbao.zzc("", e2);
                }
            }
        }
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zzaax = activity;
            }
        }
    }
}
