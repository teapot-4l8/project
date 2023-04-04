package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcju implements zzesa<zzbzl<zzbtp>> {
    private final zzesn<zzcjt> zzfvz;
    private final zzcjv zzgms;

    private zzcju(zzcjv zzcjvVar, zzesn<zzcjt> zzesnVar) {
        this.zzgms = zzcjvVar;
        this.zzfvz = zzesnVar;
    }

    public static zzcju zza(zzcjv zzcjvVar, zzesn<zzcjt> zzesnVar) {
        return new zzcju(zzcjvVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzeki));
    }
}
