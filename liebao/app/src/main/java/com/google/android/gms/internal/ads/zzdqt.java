package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqt implements zzesa<zzbac> {
    private final zzesn<zzazs> zzhdo;
    private final zzdqo zzhpn;

    private zzdqt(zzdqo zzdqoVar, zzesn<zzazs> zzesnVar) {
        this.zzhpn = zzdqoVar;
        this.zzhdo = zzesnVar;
    }

    public static zzdqt zzc(zzdqo zzdqoVar, zzesn<zzazs> zzesnVar) {
        return new zzdqt(zzdqoVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbac) zzesg.zzbd(this.zzhdo.get().zzyn());
    }
}
