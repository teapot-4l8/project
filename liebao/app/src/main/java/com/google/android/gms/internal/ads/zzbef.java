package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbef extends com.google.android.gms.ads.internal.util.zza {
    final zzbcs zzekz;
    private final String zzemj;
    private final String[] zzemk;
    final zzbek zzerp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbef(zzbcs zzbcsVar, zzbek zzbekVar, String str, String[] strArr) {
        this.zzekz = zzbcsVar;
        this.zzerp = zzbekVar;
        this.zzemj = str;
        this.zzemk = strArr;
        com.google.android.gms.ads.internal.zzr.zzlr().zza(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwp() {
        try {
            this.zzerp.zze(this.zzemj, this.zzemk);
        } finally {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbei(this));
        }
    }
}
