package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcok implements zzesa<zzdtx> {
    private final zzesn<String> zzgno;

    private zzcok(zzesn<String> zzesnVar) {
        this.zzgno = zzesnVar;
    }

    public static zzcok zzae(zzesn<String> zzesnVar) {
        return new zzcok(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdtx) zzesg.zzbd(zzdtx.zzgz(this.zzgno.get()));
    }
}
