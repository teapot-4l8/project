package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzciy implements zzesa<String> {
    private final zzesn<zzdpm> zzfxn;

    public zzciy(zzesn<zzdpm> zzesnVar) {
        this.zzfxn = zzesnVar;
    }

    public static String zzb(zzdpm zzdpmVar) {
        return (String) zzesg.zzbd(zzdpmVar.zzhof.zzhnj == zzdpe.zzhnn ? "rewarded_interstitial" : "rewarded");
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzb(this.zzfxn.get());
    }
}
