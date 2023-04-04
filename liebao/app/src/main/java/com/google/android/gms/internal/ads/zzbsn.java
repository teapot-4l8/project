package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsn implements zzesa<zzdpm> {
    private final zzbsj zzgbg;

    private zzbsn(zzbsj zzbsjVar) {
        this.zzgbg = zzbsjVar;
    }

    public static zzbsn zzj(zzbsj zzbsjVar) {
        return new zzbsn(zzbsjVar);
    }

    public static zzdpm zzk(zzbsj zzbsjVar) {
        return (zzdpm) zzesg.zzbd(zzbsjVar.zzamf());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzk(this.zzgbg);
    }
}
