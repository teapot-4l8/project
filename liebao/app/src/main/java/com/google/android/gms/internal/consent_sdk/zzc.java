package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public abstract class zzc {
    private static zzc zza;

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    /* loaded from: classes.dex */
    interface zza {
        zza zza(Application application);

        zzc zza();
    }

    public abstract zzj zza();

    public abstract zzaz zzb();

    public static zzc zza(Context context) {
        zzc zzcVar;
        synchronized (zzc.class) {
            if (zza == null) {
                zza = new zzai(null).zza((Application) context.getApplicationContext()).zza();
            }
            zzcVar = zza;
        }
        return zzcVar;
    }
}
