package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdc implements zzesa<zzcdd> {
    private final zzesn<zzcdr> zzgff;

    private zzcdc(zzesn<zzcdr> zzesnVar) {
        this.zzgff = zzesnVar;
    }

    public static zzcdc zzy(zzesn<zzcdr> zzesnVar) {
        return new zzcdc(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcdd(this.zzgff.get());
    }
}
