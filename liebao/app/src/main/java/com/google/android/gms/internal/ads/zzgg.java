package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgg extends zzgn {
    private final boolean zzabm;

    public zzgg(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 61);
        this.zzabm = zzfcVar.zzcg();
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        long longValue = ((Long) this.zzabq.invoke(null, this.zzwh.getContext(), Boolean.valueOf(this.zzabm))).longValue();
        synchronized (this.zzabg) {
            this.zzabg.zzbo(longValue);
        }
    }
}
