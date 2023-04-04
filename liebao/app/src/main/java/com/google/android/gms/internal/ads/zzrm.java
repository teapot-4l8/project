package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrm {
    private final Object zzbtg = new Object();
    private zzrp zzbth = null;
    private boolean zzbti = false;

    public final void initialize(Context context) {
        synchronized (this.zzbtg) {
            if (!this.zzbti) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("Can not cast Context to Application");
                    return;
                }
                if (this.zzbth == null) {
                    this.zzbth = new zzrp();
                }
                this.zzbth.zza(application, context);
                this.zzbti = true;
            }
        }
    }

    public final void zza(zzrr zzrrVar) {
        synchronized (this.zzbtg) {
            if (this.zzbth == null) {
                this.zzbth = new zzrp();
            }
            this.zzbth.zza(zzrrVar);
        }
    }

    public final void zzb(zzrr zzrrVar) {
        synchronized (this.zzbtg) {
            if (this.zzbth == null) {
                return;
            }
            this.zzbth.zzb(zzrrVar);
        }
    }

    public final Activity getActivity() {
        synchronized (this.zzbtg) {
            if (this.zzbth != null) {
                return this.zzbth.getActivity();
            }
            return null;
        }
    }

    public final Context getContext() {
        synchronized (this.zzbtg) {
            if (this.zzbth != null) {
                return this.zzbth.getContext();
            }
            return null;
        }
    }
}
