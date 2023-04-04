package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzduf implements zzesa<zzduc> {
    private final zzesn<zzdue> zzeyz;
    private final zzesn<zzdug> zzgow;
    private final zzesn<zzdtt> zzhuw;

    public zzduf(zzesn<zzdtt> zzesnVar, zzesn<zzdug> zzesnVar2, zzesn<zzdue> zzesnVar3) {
        this.zzhuw = zzesnVar;
        this.zzgow = zzesnVar2;
        this.zzeyz = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzduc(this.zzhuw.get(), this.zzgow.get(), this.zzeyz.get());
    }
}
