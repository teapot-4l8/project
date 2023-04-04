package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfy extends zzgn {
    private static final Object zzabf = new Object();
    private static volatile Long zzabh;

    public zzfy(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        if (zzabh == null) {
            synchronized (zzabf) {
                if (zzabh == null) {
                    zzabh = (Long) this.zzabq.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabg) {
            this.zzabg.zzav(zzabh.longValue());
        }
    }
}
