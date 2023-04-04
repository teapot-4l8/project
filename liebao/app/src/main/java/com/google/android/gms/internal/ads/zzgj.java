package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgj extends zzgn {
    public zzgj(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzf(zzcq.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzabq.invoke(null, this.zzwh.getContext())).booleanValue();
        synchronized (this.zzabg) {
            if (booleanValue) {
                this.zzabg.zzf(zzcq.ENUM_TRUE);
            } else {
                this.zzabg.zzf(zzcq.ENUM_FALSE);
            }
        }
    }
}
