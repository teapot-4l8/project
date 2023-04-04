package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnu implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzbov> zzfvz;
    private final zzbnl zzfxk;

    public zzbnu(zzbnl zzbnlVar, zzesn<zzbov> zzesnVar) {
        this.zzfxk = zzbnlVar;
        this.zzfvz = zzesnVar;
    }

    public static zzbzl<zzbuj> zza(zzbnl zzbnlVar, zzbov zzbovVar) {
        return (zzbzl) zzesg.zzbd(new zzbzl(zzbovVar, zzbat.zzeki));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfvz.get());
    }
}
