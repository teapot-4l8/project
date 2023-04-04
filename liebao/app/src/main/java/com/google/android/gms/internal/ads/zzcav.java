package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcav implements zzesa<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>> {
    private final zzesn<zzcbt> zzfvz;
    private final zzcak zzgdr;

    private zzcav(zzcak zzcakVar, zzesn<zzcbt> zzesnVar) {
        this.zzgdr = zzcakVar;
        this.zzfvz = zzesnVar;
    }

    public static zzcav zzd(zzcak zzcakVar, zzesn<zzcbt> zzesnVar) {
        return new zzcav(zzcakVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzeki));
    }
}
