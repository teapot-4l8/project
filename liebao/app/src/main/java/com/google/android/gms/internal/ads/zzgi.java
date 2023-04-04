package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgi extends zzgn {
    public zzgi(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        synchronized (this.zzabg) {
            zzez zzezVar = new zzez((String) this.zzabq.invoke(null, new Object[0]));
            this.zzabg.zzbj(zzezVar.zzyy.longValue());
            this.zzabg.zzbk(zzezVar.zzyz.longValue());
        }
    }
}
