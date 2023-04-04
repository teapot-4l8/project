package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgh extends zzgn {
    private long zzaar;
    private final zzfj zzxo;

    public zzgh(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2, zzfj zzfjVar) {
        super(zzfcVar, str, str2, zzbVar, i, 53);
        this.zzxo = zzfjVar;
        if (zzfjVar != null) {
            this.zzaar = zzfjVar.zzcv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        if (this.zzxo != null) {
            this.zzabg.zzbl(((Long) this.zzabq.invoke(null, Long.valueOf(this.zzaar))).longValue());
        }
    }
}
