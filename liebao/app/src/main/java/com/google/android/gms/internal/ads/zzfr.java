package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfr extends zzgn {
    public zzfr(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzam(-1L);
        this.zzabg.zzan(-1L);
        int[] iArr = (int[]) this.zzabq.invoke(null, this.zzwh.getContext());
        synchronized (this.zzabg) {
            this.zzabg.zzam(iArr[0]);
            this.zzabg.zzan(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzabg.zzbm(iArr[2]);
            }
        }
    }
}
