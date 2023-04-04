package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcas implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzcbt> zzfvz;
    private final zzcak zzgdr;

    private zzcas(zzcak zzcakVar, zzesn<zzcbt> zzesnVar) {
        this.zzgdr = zzcakVar;
        this.zzfvz = zzesnVar;
    }

    public static zzcas zzc(zzcak zzcakVar, zzesn<zzcbt> zzesnVar) {
        return new zzcas(zzcakVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzeki));
    }
}
