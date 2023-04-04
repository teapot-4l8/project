package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrs implements zzesa<zzbzl<zzbvm>> {
    private final zzesn<zzbrr> zzeyk;
    private final zzbrt zzgae;

    private zzbrs(zzbrt zzbrtVar, zzesn<zzbrr> zzesnVar) {
        this.zzgae = zzbrtVar;
        this.zzeyk = zzesnVar;
    }

    public static zzbrs zza(zzbrt zzbrtVar, zzesn<zzbrr> zzesnVar) {
        return new zzbrs(zzbrtVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), zzbat.zzekj));
    }
}
