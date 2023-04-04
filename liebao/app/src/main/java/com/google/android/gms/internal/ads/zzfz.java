package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfz extends zzgn {
    private long zzabi;

    public zzfz(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 12);
        this.zzabi = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzap(-1L);
        this.zzabg.zzap(((Long) this.zzabq.invoke(null, this.zzwh.getContext())).longValue());
    }
}
