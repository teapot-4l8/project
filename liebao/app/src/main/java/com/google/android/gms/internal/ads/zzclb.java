package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclb implements zzesa<zzcku> {
    private final zzesn<zzdmp> zzfcu;
    private final zzesn<zztz> zzgma;

    private zzclb(zzesn<zztz> zzesnVar, zzesn<zzdmp> zzesnVar2) {
        this.zzgma = zzesnVar;
        this.zzfcu = zzesnVar2;
    }

    public static zzclb zzad(zzesn<zztz> zzesnVar, zzesn<zzdmp> zzesnVar2) {
        return new zzclb(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcku(this.zzgma.get(), this.zzfcu.get());
    }
}
