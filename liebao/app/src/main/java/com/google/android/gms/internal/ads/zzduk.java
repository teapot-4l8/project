package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzduk implements zzesa<zzdul> {
    private final zzesn<zzdue> zzeyz;
    private final zzesn<zzdug> zzgow;

    public zzduk(zzesn<zzdug> zzesnVar, zzesn<zzdue> zzesnVar2) {
        this.zzgow = zzesnVar;
        this.zzeyz = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdul(this.zzgow.get(), this.zzeyz.get());
    }
}
