package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgb extends zzgn {
    public zzgb(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        zzem zzemVar = new zzem((String) this.zzabq.invoke(null, this.zzwh.getContext(), Boolean.valueOf(((Boolean) zzww.zzra().zzd(zzabq.zzcsw)).booleanValue())));
        synchronized (this.zzabg) {
            this.zzabg.zzal(zzemVar.zzyl);
            this.zzabg.zzbn(zzemVar.zzym);
        }
    }
}
