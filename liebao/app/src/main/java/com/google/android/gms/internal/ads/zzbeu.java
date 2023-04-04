package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbeu extends zzbek {
    public zzbeu(zzbcs zzbcsVar) {
        super(zzbcsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final boolean zzfh(String str) {
        zzbcs zzbcsVar = this.zzerx.get();
        if (zzbcsVar != null) {
            zzbcsVar.zza(zzfi(str), this);
        }
        com.google.android.gms.ads.internal.util.zzd.zzez("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfi(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
