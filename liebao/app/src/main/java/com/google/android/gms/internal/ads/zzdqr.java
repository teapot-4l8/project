package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqr implements zzesa<com.google.android.gms.ads.internal.util.zzf> {
    private final zzesn<zzazs> zzhdo;
    private final zzdqo zzhpn;

    private zzdqr(zzdqo zzdqoVar, zzesn<zzazs> zzesnVar) {
        this.zzhpn = zzdqoVar;
        this.zzhdo = zzesnVar;
    }

    public static zzdqr zzb(zzdqo zzdqoVar, zzesn<zzazs> zzesnVar) {
        return new zzdqr(zzdqoVar, zzesnVar);
    }

    public static com.google.android.gms.ads.internal.util.zzf zza(zzdqo zzdqoVar, zzazs zzazsVar) {
        return (com.google.android.gms.ads.internal.util.zzf) zzesg.zzbd(zzazsVar.zzyl());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzhpn, this.zzhdo.get());
    }
}
