package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzamj {
    private final Object zzdlv = new Object();
    private final Object zzdlw = new Object();
    private zzamo zzdlx;
    private zzamo zzdly;

    public final zzamo zza(Context context, zzbar zzbarVar) {
        zzamo zzamoVar;
        synchronized (this.zzdlw) {
            if (this.zzdly == null) {
                this.zzdly = new zzamo(zzl(context), zzbarVar, zzadv.zzdga.get());
            }
            zzamoVar = this.zzdly;
        }
        return zzamoVar;
    }

    public final zzamo zzb(Context context, zzbar zzbarVar) {
        zzamo zzamoVar;
        synchronized (this.zzdlv) {
            if (this.zzdlx == null) {
                this.zzdlx = new zzamo(zzl(context), zzbarVar, (String) zzww.zzra().zzd(zzabq.zzcms));
            }
            zzamoVar = this.zzdlx;
        }
        return zzamoVar;
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
