package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdew implements zzesa<zzdeu> {
    private final zzesn<zzebs> zzeyl;

    private zzdew(zzesn<zzebs> zzesnVar) {
        this.zzeyl = zzesnVar;
    }

    public static zzdew zzan(zzesn<zzebs> zzesnVar) {
        return new zzdew(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdeu(this.zzeyl.get());
    }
}
