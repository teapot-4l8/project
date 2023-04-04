package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqn implements zzesa<zzbzl<zzbsz>> {
    private final zzesn<zzdqm> zzfzu;
    private final zzdqk zzhpm;

    private zzdqn(zzdqk zzdqkVar, zzesn<zzdqm> zzesnVar) {
        this.zzhpm = zzdqkVar;
        this.zzfzu = zzesnVar;
    }

    public static zzdqn zza(zzdqk zzdqkVar, zzesn<zzdqm> zzesnVar) {
        return new zzdqn(zzdqkVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfzu.get(), zzbat.zzekj));
    }
}
