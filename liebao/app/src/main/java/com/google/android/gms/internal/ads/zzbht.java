package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbht implements zzesa<zzdqc<zzchu>> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzcih> zzeyn;

    public zzbht(zzesn<zzcih> zzesnVar, zzesn<zzebs> zzesnVar2) {
        this.zzeyn = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdqc) zzesg.zzbd(new zzdqc(this.zzeyn.get(), this.zzeyl.get()));
    }
}
